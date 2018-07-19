package com.hycxkj.postage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.hycxkj.order.exception.LongOverFlowException;
import com.hycxkj.order.util.LongUtil;
import com.hycxkj.postage.bean.PostageCarryMode;
import com.hycxkj.postage.bean.PostagePackageCondition;
import com.hycxkj.postage.bean.PostageTemplate;
import com.hycxkj.postage.bean.PostageTemplateExample;
import com.hycxkj.postage.domain.PostageDomain;
import com.hycxkj.postage.mapper.PostageTemplateMapper;
import com.hycxkj.postage.service.PostageCarryModeService;
import com.hycxkj.postage.service.PostagePackageConditionService;
import com.hycxkj.postage.service.PostageTemplateService;
import com.hycxkj.shop.bean.ShopItem;
import com.hycxkj.shop.service.ShopItemService;
import com.hycxkj.user.bean.UserAddr;
import com.hycxkj.user.service.UserAddrService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
* @author 陈少平
* @description
* @create in 2018/05/06 06:48
*/
@Service
public class PostageTemplateServiceImpl implements PostageTemplateService {

    @Autowired
    private PostageTemplateMapper postageTemplateMapper;

    @Autowired
    private PostageCarryModeService postageCarryModeService;

    @Autowired
    private PostagePackageConditionService postagePackageConditionService;

    @Autowired
    private ShopItemService shopItemService;


    @Autowired
    private UserAddrService userAddrService;
    @Override
    @Transactional
    public long insert(PostageTemplate model) {
        return postageTemplateMapper.insert(model);
    }

    @Override
    @Transactional
    public long insertSelective(PostageTemplate model){
        return postageTemplateMapper.insertSelective(model);
    }

    @Override
    public PageInfo<PostageTemplate> getByPage(Integer pageNum, Integer pageSize) {
        PostageTemplateExample postageTemplateExample = new PostageTemplateExample();
        PostageTemplateExample.Criteria criteria = postageTemplateExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, postageTemplateExample);
    }

    @Override
    public PageInfo<PostageTemplate> getPagesByExample(Integer pageNum, Integer pageSize, PostageTemplateExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<PostageTemplate> list = postageTemplateMapper.selectByExample(example);
        PageInfo<PostageTemplate> info = new PageInfo<>(list);
        return info;
    }

    public PostageTemplate getById(Long id) {
        PostageTemplateExample postageTemplateExample = new PostageTemplateExample();
        PostageTemplateExample.Criteria criteria = postageTemplateExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<PostageTemplate> list = postageTemplateMapper.selectByExample(postageTemplateExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Long id) {
        PostageTemplateExample postageTemplateExample = new PostageTemplateExample();
        PostageTemplateExample.Criteria criteria = postageTemplateExample.createCriteria();
        criteria.andIdEqualTo(id);
        return deleteByExample(postageTemplateExample);
    }

    @Override
    @Transactional
    public int deleteByExample(PostageTemplateExample example) {
        return postageTemplateMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(PostageTemplate model,Long id) {
        PostageTemplateExample postageTemplateExample = new PostageTemplateExample();
        PostageTemplateExample.Criteria criteria = postageTemplateExample.createCriteria();
        criteria.andIdEqualTo(id);
        return updateSelectiveByExample(model,postageTemplateExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(PostageTemplate model, PostageTemplateExample example){
        return postageTemplateMapper.updateByExampleSelective(model,example);
    }

    @Override
    public PostageDomain getPostageDomainByPostageTemplateId(long postageTemplateId, byte carryAway) {
        PostageTemplate postageTemplate = getById(postageTemplateId);
        if(Objects.isNull(postageTemplate)) {
            return null;
        }
        PostageDomain postageDomain = new PostageDomain();
        postageDomain.setPostageTemplate(postageTemplate);
        Boolean packageMail = postageTemplate.getPackageMail();
        if(!packageMail) {
            List<PostageCarryMode> postageCarryMode = postageCarryModeService.getByPostageTemplateId(postageTemplateId, carryAway);
            postageDomain.setPostageCarryMode(postageCarryMode);
            List<PostagePackageCondition> postagePackageCondition = postagePackageConditionService.getByPostageTemplateId(postageTemplateId, carryAway);
            postageDomain.setPostagePackageCondition(postagePackageCondition);
        }
        return postageDomain;
    }

    /**
     * 邮费计算方式：
     * 购买同一商家下的不同商品，同时有不同运费模板计算方法：
     * 首件取大，续重取各自。
     * 逻辑如下：
     * 1、不包邮
     *  1.1、不满足指定条件包邮
     *    1.1.1、运送方式中首件取大，续重取各自。
     *  1.2、满足指定条件包邮：
     *    跳过
     * 2、包邮
     *  跳过
     * @return  key: 商家ID ， value 邮费的Map
     */
    @Override
    public Map<Long, Long> calPostage(Long addrId, Map<Long,Map<Long,Integer>> itemsOfBusi, Map<Long, Byte> carryAwayMap) {
        //key：商家ID，value: 邮费
        Map<Long, Long> busisPostage = new HashMap<>();
        UserAddr userAddr = userAddrService.getByAddrId(addrId);
        String receiverProvince = userAddr.getReceiverProvince();
        String receiverCity = userAddr.getReceiverCity();
        for(Map.Entry<Long,Map<Long,Integer>> itemOfBusi: itemsOfBusi.entrySet()) {
            long totalPrice = 0;
            Long busiId = itemOfBusi.getKey();
            Map<Long, Integer> itemOfBusiValue = itemOfBusi.getValue();
            // 将需要计算邮费的添加到此集合。
            // key：商品ID, value: 运送方式
            Map<Long ,PostageCarryMode> needCalPostage = new HashMap<>();
            // 遍历商品 key: 商品ID  value:商品数量
            for (Long itemId : itemOfBusiValue.keySet()) {
                byte carryAway = carryAwayMap.get(itemId) == null? 0 : carryAwayMap.get(itemId);
                Integer itemNum = itemOfBusiValue.get(itemId);
                PostageTemplate postageTemplate = postageTemplateMapper.getByBusiIdAndItemId(busiId, itemId);
                boolean packageMail = postageTemplate.getPackageMail() ;
                if(!packageMail) {
                    // 不包邮，计算邮费
                    PostageDomain postageDomain = getPostageDomainByPostageTemplateId(postageTemplate.getId(), carryAway);
                    List<PostagePackageCondition> postagePackageCondition = postageDomain.getPostagePackageCondition();
                    if(!CollectionUtils.isEmpty(postagePackageCondition)) {
                        //按条件包邮. 遍历所有条件包邮
                        int tmp_count = 0;
                        for (PostagePackageCondition packageCondition : postagePackageCondition) {
                            // 查看用户地址在包邮区域内的条件是否满足
                            String region = packageCondition.getRegion();
                            // null,即包邮条件地区为全国
                            if(StringUtils.isEmpty(region)) {
                                // 如果返回true。 继续判断下一个商品是否需要计算邮费
                                if(addNeddCalPostage(needCalPostage, itemNum, packageCondition, itemId, postageDomain,receiverProvince,receiverCity,carryAway)) break;
                            }else {
                                // 不为空。
                                List<String> area = Arrays.asList(packageCondition.getRegion().split("|"));
                                if(area.contains(receiverProvince) || area.contains(receiverCity)) {
                                    if(addNeddCalPostage(needCalPostage, itemNum, packageCondition, itemId, postageDomain,receiverProvince,receiverCity,carryAway)) break;
                                }else {
                                    //不包含，则继续。
                                    tmp_count++;
                                    continue;
                                }
                            }
                        }
                        // 不包含在按条件包邮的地区内
                        if(tmp_count == postagePackageCondition.size()) {
                            addDefineCarrayMode(needCalPostage, postageDomain.getPostageCarryMode(), receiverProvince, receiverCity, itemId, carryAway);
                        }
                    }else {
                        //不按条件包邮, 直接添加到 需要计算邮费的集合中
                        addDefineCarrayMode(needCalPostage, postageDomain.getPostageCarryMode(), receiverProvince, receiverCity, itemId, carryAway);
                    }
                }else{
                    // 该商品包邮，继续遍历
                    continue;
                }
            }
            long maxFirstPrice = 0;
            // 邮费计算方式：
            // 购买同一商家下的不同商品，同时有不同运费模板计算方法：
            // 首件取大，续重取各自。
            // 获取最大的首件运费
            for (Map.Entry<Long, PostageCarryMode> carryModeEntry : needCalPostage.entrySet()) {
                Long itemId = carryModeEntry.getKey();
                PostageCarryMode carryMode = carryModeEntry.getValue();
                long firstAmount = LongUtil.dealLongNull(carryMode.getFirstAmount());
                if(maxFirstPrice < firstAmount) {
                    maxFirstPrice = firstAmount;
                }
                // 计算后续各自邮费
                long secondAmount = LongUtil.dealLongNull(carryMode.getSecondAmount());
                int secondPiece = carryMode.getSecondPiece() == null? 0 : carryMode.getSecondPiece();
                long secondWeight = LongUtil.dealLongNull(carryMode.getSecondWeight());
                long secondBulk = LongUtil.dealLongNull(carryMode.getSecondBulk());
                int num = itemOfBusiValue.get(itemId);
                if(secondPiece > 0) {
                    int firstPiece = carryMode.getFirstPiece() == null? 0 : carryMode.getFirstPiece();
                    int diffPiece = num - firstPiece;
                    if(diffPiece <= 0) {
                        continue;
                    }
                    int count = diffPiece / secondPiece;
                    if(num % secondPiece != 0) {
                        count++;
                    }
                    totalPrice += count * secondAmount;
                    LongUtil.isOverFlow(totalPrice,"邮费溢出 "+totalPrice);
                }else if(secondWeight > 0) {
                    ShopItem shopItem = shopItemService.getById(itemId);
                    long weight = shopItem.getWeight();
                    long totalWeight = num * weight;
                    long diffWeight = totalWeight - carryMode.getFirstWeight();
                    if(diffWeight <= 0) {
                        continue;
                    }
                    int count = (int) Math.ceil(diffWeight / secondWeight);
                    totalPrice += count * secondAmount;
                }else {
                    // 体积暂时不处理。
                }
            }
            totalPrice += maxFirstPrice;
            busisPostage.put(busiId, totalPrice);
        }
        return busisPostage;
    }

    /**
     * 添加指定的运送模板
     * @param needCalPostage
     * @param postageCarryModes 运送条件
     * @param province
     * @param city
     * @param itemId
     * @param carryAway
     */
    private void addDefineCarrayMode(Map<Long ,PostageCarryMode> needCalPostage, List<PostageCarryMode> postageCarryModes, String province, String city, long itemId, byte carryAway) {
        for (PostageCarryMode postageCarryMode : postageCarryModes) {
            String region = postageCarryMode.getRegion();
            if(StringUtils.isEmpty(region)) {
                needCalPostage.put(itemId, postageCarryMode);
            }else {
                List<String> area = Arrays.asList(region.split("|"));
                if (area.contains(province) || area.contains(city)) {
                    needCalPostage.put(itemId, postageCarryMode);
                }
            }
            return;
        }
        // 获取默认的运送方式
        PostageCarryMode carrayMode = postageCarryModeService.getPostageTemplateDefaultCarrayMode(postageCarryModes.get(0).getPostageTemplateId(), carryAway);
        needCalPostage.put(itemId, carrayMode);
    }
    /**
     *  判断是否需要加入到  需要计算邮费的集合中
     * @param needCalPostage  需要计算邮费的集合
     * @param itemNum 商品的数量
     * @param packageCondition 包邮条件
     * @param itemId  商品ID
     * @param postageDomain
     * @param province 用户地址省份
     * @param city 用户地址城市
     * @param carryAway 运送方式
     * @return  true: 需要。 false: 不需要
     */
    private boolean addNeddCalPostage(Map<Long ,PostageCarryMode> needCalPostage, int itemNum, PostagePackageCondition packageCondition, long itemId,PostageDomain postageDomain, String province, String city, byte carryAway) {
        boolean isAdd = false;
        List<PostageCarryMode> postageCarryModes = postageDomain.getPostageCarryMode();
        long packageAmount = LongUtil.dealLongNull(packageCondition.getAmount());
        long packageWeight = LongUtil.dealLongNull(packageCondition.getWeightNo());
        if(packageAmount > 0) { // 商品的包邮条件是看件数
            if(itemNum <= packageAmount) {  // 商品数量少于包邮的件数，加入 需要包邮的集合中
                isAdd = true;
            }
        }else if(packageWeight > 0) {
            ShopItem shopItem = shopItemService.getById(itemId);
            long weight = shopItem.getWeight();
            LongUtil.isOverFlow(weight * itemNum, "重量溢出 " + (weight * itemNum));
            if((weight * itemNum) > packageWeight) {
                isAdd = true;
            }
        }else {
            // 关于体积，暂不支持！！！
//            isAdd = false;
        }
        if(isAdd) {
            addDefineCarrayMode(needCalPostage,postageCarryModes,province,city,itemId,carryAway);
            return true;
        }
        return false;
    }
}