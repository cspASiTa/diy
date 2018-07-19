package com.hycxkj.postage.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.postage.bean.PostageTemplate;
import com.hycxkj.postage.bean.PostageTemplateExample;
import com.hycxkj.postage.domain.PostageDomain;

import java.util.Map;

/**
* @author 陈少平
* @description
* @create in 2018/05/06 06:48
*/
public interface PostageTemplateService {

    long insert(PostageTemplate model);

    /**
     * 只插入部分
     */
    long insertSelective(PostageTemplate model);

    PageInfo<PostageTemplate> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<PostageTemplate> getPagesByExample(Integer pageNum, Integer pageSize, PostageTemplateExample example);

    PostageTemplate getById(Long id);

    int deleteById(Long id);

    int deleteByExample(PostageTemplateExample example);

    int updateSelectiveById(PostageTemplate model,Long id);

    int updateSelectiveByExample(PostageTemplate model, PostageTemplateExample example);

    PostageDomain getPostageDomainByPostageTemplateId(long postageTemplateId, byte carryAway);

    /**
     * 计算邮费
     * @param addrId 用户地址ID
     * @param itemsOfBusi key:商家ID value:{key:商品ID,value:商品数量}
     * @param carryAway 运送方式  key:商品ID，value 商品运送方式
     * @return  key: 商家ID ， value 邮费的Map
     */
    Map<Long, Long> calPostage(Long addrId, Map<Long,Map<Long,Integer>> itemsOfBusi, Map<Long, Byte> carryAway);

}