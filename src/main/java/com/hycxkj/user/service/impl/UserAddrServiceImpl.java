package com.hycxkj.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.UserAddr;
import com.hycxkj.user.bean.UserAddrExample;
import com.hycxkj.user.mapper.UserAddrMapper;
import com.hycxkj.user.service.UserAddrService;
import io.jsonwebtoken.lang.Collections;
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
public class UserAddrServiceImpl implements UserAddrService {

    @Autowired
    private UserAddrMapper userAddrMapper;

    @Override
    @Transactional
    public int insert(UserAddr model) {
        return userAddrMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(UserAddr model){
        return userAddrMapper.insertSelective(model);
    }

    @Override
    public PageInfo<UserAddr> getByPage(Integer pageNum, Integer pageSize) {
        UserAddrExample userAddrExample = new UserAddrExample();
        UserAddrExample.Criteria criteria = userAddrExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, userAddrExample);
    }

    @Override
    public PageInfo<UserAddr> getPagesByExample(Integer pageNum, Integer pageSize, UserAddrExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<UserAddr> list = userAddrMapper.selectByExample(example);
        PageInfo<UserAddr> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        UserAddrExample userAddrExample = new UserAddrExample();
        UserAddrExample.Criteria criteria = userAddrExample.createCriteria();
        criteria.andAddrIdEqualTo(id);
        return deleteByExample(userAddrExample);
    }

    @Override
    @Transactional
    public int deleteByExample(UserAddrExample example) {
        return userAddrMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(UserAddr model,Long id) {
        UserAddrExample userAddrExample = new UserAddrExample();
        UserAddrExample.Criteria criteria = userAddrExample.createCriteria();
        criteria.andAddrIdEqualTo(id);
        return updateSelectiveByExample(model,userAddrExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(UserAddr model, UserAddrExample example){
        return userAddrMapper.updateByExampleSelective(model,example);
    }

    @Override
    public UserAddr getByAddrId(long addrId) {
        UserAddrExample userAddrExample = new UserAddrExample();
        UserAddrExample.Criteria criteria = userAddrExample.createCriteria();
        criteria.andAddrIdEqualTo(addrId);
        List<UserAddr> userAddrs = userAddrMapper.selectByExample(userAddrExample);
        if(!Collections.isEmpty(userAddrs)) {
            return userAddrs.get(0);
        }
        return null;
    }
}