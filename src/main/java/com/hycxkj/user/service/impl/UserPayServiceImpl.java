package com.hycxkj.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.UserPay;
import com.hycxkj.user.bean.UserPayExample;
import com.hycxkj.user.mapper.UserPayMapper;
import com.hycxkj.user.service.UserPayService;
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
public class UserPayServiceImpl implements UserPayService {

    @Autowired
    private UserPayMapper userPayMapper;

    @Override
    @Transactional
    public int insert(UserPay model) {
        return userPayMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(UserPay model){
        return userPayMapper.insertSelective(model);
    }

    @Override
    public PageInfo<UserPay> getByPage(Integer pageNum, Integer pageSize) {
        UserPayExample userPayExample = new UserPayExample();
        UserPayExample.Criteria criteria = userPayExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, userPayExample);
    }

    @Override
    public PageInfo<UserPay> getPagesByExample(Integer pageNum, Integer pageSize, UserPayExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<UserPay> list = userPayMapper.selectByExample(example);
        PageInfo<UserPay> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        UserPayExample userPayExample = new UserPayExample();
        UserPayExample.Criteria criteria = userPayExample.createCriteria();
        criteria.andUserPayIdEqualTo(id);
        return deleteByExample(userPayExample);
    }

    @Override
    @Transactional
    public int deleteByExample(UserPayExample example) {
        return userPayMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(UserPay model,Long id) {
        UserPayExample userPayExample = new UserPayExample();
        UserPayExample.Criteria criteria = userPayExample.createCriteria();
        criteria.andUserPayIdEqualTo(id);
        return updateSelectiveByExample(model,userPayExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(UserPay model, UserPayExample example){
        return userPayMapper.updateByExampleSelective(model,example);
    }
}