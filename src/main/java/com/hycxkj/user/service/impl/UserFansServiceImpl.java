package com.hycxkj.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.UserFans;
import com.hycxkj.user.bean.UserFansExample;
import com.hycxkj.user.mapper.UserFansMapper;
import com.hycxkj.user.service.UserFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:12 CST 2018
*/
@Service
public class UserFansServiceImpl implements UserFansService {

    @Autowired
    private UserFansMapper userFansMapper;

    @Override
    @Transactional
    public int insert(UserFans model) {
        return userFansMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(UserFans model){
        return userFansMapper.insertSelective(model);
    }

    @Override
    public PageInfo<UserFans> getByPage(Integer pageNum, Integer pageSize) {
        UserFansExample userFansExample = new UserFansExample();
        UserFansExample.Criteria criteria = userFansExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, userFansExample);
    }

    @Override
    public PageInfo<UserFans> getPagesByExample(Integer pageNum, Integer pageSize, UserFansExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<UserFans> list = userFansMapper.selectByExample(example);
        PageInfo<UserFans> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        UserFansExample userFansExample = new UserFansExample();
        UserFansExample.Criteria criteria = userFansExample.createCriteria();
        criteria.andFansIdEqualTo(id);
        return deleteByExample(userFansExample);
    }

    @Override
    @Transactional
    public int deleteByExample(UserFansExample example) {
        return userFansMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(UserFans model,Long id) {
        UserFansExample userFansExample = new UserFansExample();
        UserFansExample.Criteria criteria = userFansExample.createCriteria();
        criteria.andFansIdEqualTo(id);
        return updateSelectiveByExample(model,userFansExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(UserFans model, UserFansExample example){
        return userFansMapper.updateByExampleSelective(model,example);
    }

    @Override
    public long getFansCount(Long userId) {
        return userFansMapper.getFansCount(userId);
    }

    @Override
    public long getFocusCount( Long focusId) {
        return userFansMapper.getFocusCount(focusId);
    }
}