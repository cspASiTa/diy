package com.hycxkj.postage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.postage.bean.PostagePackageCondition;
import com.hycxkj.postage.bean.PostagePackageConditionExample;
import com.hycxkj.postage.mapper.PostagePackageConditionMapper;
import com.hycxkj.postage.service.PostagePackageConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author 陈少平
* @description
* @create in 2018/05/06 06:48
*/
@Service
public class PostagePackageConditionServiceImpl implements PostagePackageConditionService {

    @Autowired
    private PostagePackageConditionMapper postagePackageConditionMapper;

    @Override
    @Transactional
    public int insert(PostagePackageCondition model) {
        return postagePackageConditionMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(PostagePackageCondition model){
        return postagePackageConditionMapper.insertSelective(model);
    }

    @Override
    public PageInfo<PostagePackageCondition> getByPage(Integer pageNum, Integer pageSize) {
        PostagePackageConditionExample postagePackageConditionExample = new PostagePackageConditionExample();
        PostagePackageConditionExample.Criteria criteria = postagePackageConditionExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, postagePackageConditionExample);
    }

    @Override
    public PageInfo<PostagePackageCondition> getPagesByExample(Integer pageNum, Integer pageSize, PostagePackageConditionExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<PostagePackageCondition> list = postagePackageConditionMapper.selectByExample(example);
        PageInfo<PostagePackageCondition> info = new PageInfo<>(list);
        return info;
    }

    public PostagePackageCondition getById(Long id) {
        PostagePackageConditionExample postagePackageConditionExample = new PostagePackageConditionExample();
        PostagePackageConditionExample.Criteria criteria = postagePackageConditionExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<PostagePackageCondition> list = postagePackageConditionMapper.selectByExample(postagePackageConditionExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Long id) {
        PostagePackageConditionExample postagePackageConditionExample = new PostagePackageConditionExample();
        PostagePackageConditionExample.Criteria criteria = postagePackageConditionExample.createCriteria();
        criteria.andIdEqualTo(id);
        return deleteByExample(postagePackageConditionExample);
    }

    @Override
    @Transactional
    public int deleteByExample(PostagePackageConditionExample example) {
        return postagePackageConditionMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(PostagePackageCondition model,Long id) {
        PostagePackageConditionExample postagePackageConditionExample = new PostagePackageConditionExample();
        PostagePackageConditionExample.Criteria criteria = postagePackageConditionExample.createCriteria();
        criteria.andIdEqualTo(id);
        return updateSelectiveByExample(model,postagePackageConditionExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(PostagePackageCondition model, PostagePackageConditionExample example){
        return postagePackageConditionMapper.updateByExampleSelective(model,example);
    }

    @Override
    public List<PostagePackageCondition> getByPostageTemplateId(long postageTemplateId, byte carryAway) {
        PostagePackageConditionExample postagePackageConditionExample = new PostagePackageConditionExample();
        PostagePackageConditionExample.Criteria criteria = postagePackageConditionExample.createCriteria();
        criteria.andPostageTemplateIdEqualTo(postageTemplateId);
        criteria.andCarrayAwayEqualTo(carryAway);
        List<PostagePackageCondition> list = postagePackageConditionMapper.selectByExample(postagePackageConditionExample);
        return list;
    }
}