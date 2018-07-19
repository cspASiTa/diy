package com.hycxkj.postage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.postage.bean.PostageCarryMode;
import com.hycxkj.postage.bean.PostageCarryModeExample;
import com.hycxkj.postage.mapper.PostageCarryModeMapper;
import com.hycxkj.postage.service.PostageCarryModeService;
import com.hycxkj.shop.bean.ShopBusiItem;
import com.hycxkj.shop.bean.ShopBusiness;
import com.hycxkj.shop.service.ShopBusiItemService;
import com.hycxkj.user.bean.UserAddr;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/05/06 08:28
*/
@Service
public class PostageCarryModeServiceImpl implements PostageCarryModeService {

    @Autowired
    private PostageCarryModeMapper postageCarryModeMapper;

    @Override
    @Transactional
    public int insert(PostageCarryMode model) {
        return postageCarryModeMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(PostageCarryMode model){
        return postageCarryModeMapper.insertSelective(model);
    }

    @Override
    public PageInfo<PostageCarryMode> getByPage(Integer pageNum, Integer pageSize) {
        PostageCarryModeExample postageCarryModeExample = new PostageCarryModeExample();
        PostageCarryModeExample.Criteria criteria = postageCarryModeExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, postageCarryModeExample);
    }

    @Override
    public PageInfo<PostageCarryMode> getPagesByExample(Integer pageNum, Integer pageSize, PostageCarryModeExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<PostageCarryMode> list = postageCarryModeMapper.selectByExample(example);
        PageInfo<PostageCarryMode> info = new PageInfo<>(list);
        return info;
    }

    public PostageCarryMode getById(Long id) {
        PostageCarryModeExample postageCarryModeExample = new PostageCarryModeExample();
        PostageCarryModeExample.Criteria criteria = postageCarryModeExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<PostageCarryMode> list = postageCarryModeMapper.selectByExample(postageCarryModeExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Long id) {
        PostageCarryModeExample postageCarryModeExample = new PostageCarryModeExample();
        PostageCarryModeExample.Criteria criteria = postageCarryModeExample.createCriteria();
        criteria.andIdEqualTo(id);
        return deleteByExample(postageCarryModeExample);
    }

    @Override
    @Transactional
    public int deleteByExample(PostageCarryModeExample example) {
        return postageCarryModeMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(PostageCarryMode model,Long id) {
        PostageCarryModeExample postageCarryModeExample = new PostageCarryModeExample();
        PostageCarryModeExample.Criteria criteria = postageCarryModeExample.createCriteria();
        criteria.andIdEqualTo(id);
        return updateSelectiveByExample(model,postageCarryModeExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(PostageCarryMode model, PostageCarryModeExample example){
        return postageCarryModeMapper.updateByExampleSelective(model,example);
    }

    @Override
    public List<PostageCarryMode> getByPostageTemplateId(long postageTemplateId, byte carryAway) {
        PostageCarryModeExample postageCarryModeExample = new PostageCarryModeExample();
        PostageCarryModeExample.Criteria criteria = postageCarryModeExample.createCriteria();
        criteria.andPostageTemplateIdEqualTo(postageTemplateId);
        criteria.andCarryAwayEqualTo(carryAway);
        List<PostageCarryMode> list = postageCarryModeMapper.selectByExample(postageCarryModeExample);
        return list;
    }

    @Override
    public PostageCarryMode getPostageTemplateDefaultCarrayMode(long postageTemplateId, byte carryAway) {
        PostageCarryModeExample postageCarryModeExample = new PostageCarryModeExample();
        PostageCarryModeExample.Criteria criteria = postageCarryModeExample.createCriteria();
        criteria.andPostageTemplateIdEqualTo(postageTemplateId);
        criteria.andCarryAwayEqualTo(carryAway);
        criteria.andIsDefaultEqualTo(true);
        List<PostageCarryMode> list = postageCarryModeMapper.selectByExample(postageCarryModeExample);
        if(!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }
}