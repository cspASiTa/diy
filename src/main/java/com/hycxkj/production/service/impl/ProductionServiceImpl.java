package com.hycxkj.production.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.production.bean.Production;
import com.hycxkj.production.bean.ProductionExample;
import com.hycxkj.production.font.FontSimpleProduction;
import com.hycxkj.production.mapper.ProductionMapper;
import com.hycxkj.production.service.ProductionService;
import com.hycxkj.recommend.entity.UserLikeKeyWord;
import com.hycxkj.recommend.redis.RedisService;
import com.hycxkj.recommend.service.UserLikeKeyWordService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
* @author 陈少平
* @description
* @create in 2018/03/29 09:47
*/
@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionMapper productionMapper;

    @Autowired
    private UserLikeKeyWordService userLikeKeyWordService;

    @Autowired
    private RedisService redisService;

    @Override
    @Transactional
    public int insert(Production model) {
        return productionMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(Production model){
        return productionMapper.insertSelective(model);
    }

    @Override
    public PageInfo<Production> getByPage(Integer pageNum, Integer pageSize) {
        ProductionExample productionExample = new ProductionExample();
        ProductionExample.Criteria criteria = productionExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, productionExample);
    }

    @Override
    public PageInfo<Production> getPagesByExample(Integer pageNum, Integer pageSize, ProductionExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<Production> list = productionMapper.selectByExample(example);
        PageInfo<Production> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        ProductionExample productionExample = new ProductionExample();
        ProductionExample.Criteria criteria = productionExample.createCriteria();
        criteria.andProIdEqualTo(id);
        return deleteByExample(productionExample);
    }

    @Override
    @Transactional
    public int deleteByExample(ProductionExample example) {
        return productionMapper.deleteByExample(example);
    }

    @Override
    @Transactional
    public int updateSelectiveById(Production model,Long id) {
        ProductionExample productionExample = new ProductionExample();
        ProductionExample.Criteria criteria = productionExample.createCriteria();
        criteria.andProIdEqualTo(id);
        return updateSelectiveByExample(model,productionExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(Production model, ProductionExample example){
        return productionMapper.updateByExampleSelective(model,example);
    }

    @Override
    public PageInfo<FontSimpleProduction> getSimpleProdutionToFont(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FontSimpleProduction> list = productionMapper.getProductionSimpleInfo();
        PageInfo<FontSimpleProduction> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Production getProduction(Long proId) {
        ProductionExample example = new ProductionExample();
        ProductionExample.Criteria criteria = example.createCriteria();
        criteria.andProIdEqualTo(proId);
        List<Production> list = productionMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public PageInfo<FontSimpleProduction> getProductionSimpleInfoByCateogryId(Integer categoryId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FontSimpleProduction> list = productionMapper.getProductionSimpleInfoByCateogryId(categoryId);
        PageInfo<FontSimpleProduction> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<FontSimpleProduction> getProductionSimpleInfoByUserId(Long userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FontSimpleProduction> list = productionMapper.getProductionSimpleInfoByUserId(userId);
        PageInfo<FontSimpleProduction> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<FontSimpleProduction> getUserLikeProduction(Long userId, Integer pageNum, Integer pageSize) {
        List<UserLikeKeyWord> userLikeWords = userLikeKeyWordService.getListByUserId(userId);
        // 按照目录进行分类
        // 提取每个目录下，权重最高的词
        Set<UserLikeKeyWord> set = new TreeSet(userLikeWords);
        Map<Integer, UserLikeKeyWord> map = new HashMap<>();
        set.forEach(x -> {
            if(!map.containsKey(x.getCategoryId())) {
                map.put(x.getCategoryId(),x);
            }
        });
        // 获取这些词的权重比，根据每次获取多少页，按照比例的获取每个目录下的作品数
        List<FontSimpleProduction> list = new ArrayList<>();
        // 计算总分
        double sum = 0;
        for (Map.Entry<Integer, UserLikeKeyWord> item: map.entrySet()) {
            sum += item.getValue().getWeight();
        }
        for (Map.Entry<Integer, UserLikeKeyWord> item: map.entrySet()) {
            UserLikeKeyWord word = item.getValue();
            int categoryId = word.getCategoryId();
            double weight = word.getWeight();
            int size = (int) Math.round(weight / sum * 10);
            PageHelper.startPage(pageNum, size);
            List<FontSimpleProduction> productions = productionMapper.getUserLikeProductions(categoryId, word.getKeyword());
            PageInfo<FontSimpleProduction> info = new PageInfo<>(productions);
            List<FontSimpleProduction> list1 = info.getList();
            int tmpSize = list1.size();
            int diff = size - tmpSize;
            // 如果查出的数量不够
            if(diff > 0) {
                PageHelper.startPage(pageNum, diff);
                List<FontSimpleProduction> productionList = productionMapper.getUserLikeProductionsByCategory(categoryId);
                PageInfo<FontSimpleProduction> tmpInfo = new PageInfo<>(productionList);
                list1.addAll(tmpInfo.getList());
            }
            list.addAll(list1);
        }
        return list;
    }

    @Override
    public FontSimpleProduction getSimpleProduction(long proId) {
        return productionMapper.getSimpleProductionByProId(proId);
    }

    @Override
    @Transactional
    public int addReadnumber(Production production) {
        production.setReadnumber(production.getReadnumber() + 1);
        return updateSelectiveById(production,production.getProId());
    }

    @Override
    @Transactional
    public int addLikeCount(Production production) {
        production.setLikeCount(production.getLikeCount() + 1);
        return updateSelectiveById(production,production.getProId());
    }

    @Override
    @Transactional
    public int decreaseLikeCount(Production production) {
        production.setLikeCount(production.getLikeCount() - 1);
        return updateSelectiveById(production,production.getProId());
    }

    @Override
    public List<FontSimpleProduction> getUserLikeSimpleProductionByRedis(int pageNum, int pageSize) {
        Set<ZSetOperations.TypedTuple<String>> set = redisService.getProductionByClickDescAndPage(pageNum, pageSize);
        List<FontSimpleProduction> list = new ArrayList<>();
        for (ZSetOperations.TypedTuple<String> item : set) {
            long proId = Long.parseLong(item.getValue());
            list.add(getSimpleProduction(proId));
        }
        return list;
    }

}