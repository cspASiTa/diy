package com.hycxkj.postage.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.postage.bean.PostagePackageCondition;
import com.hycxkj.postage.bean.PostagePackageConditionExample;

import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/05/06 06:48
*/
public interface PostagePackageConditionService {

    int insert(PostagePackageCondition model);

    /**
     * 只插入部分
     */
    int insertSelective(PostagePackageCondition model);

    PageInfo<PostagePackageCondition> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<PostagePackageCondition> getPagesByExample(Integer pageNum, Integer pageSize, PostagePackageConditionExample example);

    PostagePackageCondition getById(Long id);

    int deleteById(Long id);

    int deleteByExample(PostagePackageConditionExample example);

    int updateSelectiveById(PostagePackageCondition model,Long id);

    int updateSelectiveByExample(PostagePackageCondition model, PostagePackageConditionExample example);

    List<PostagePackageCondition> getByPostageTemplateId(long postageTemplateId, byte carryAway);
}