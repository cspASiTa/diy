package com.hycxkj.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.UserAuth;
import com.hycxkj.user.bean.UserAuthExample;
import com.hycxkj.user.mapper.UserAuthMapper;
import com.hycxkj.user.service.UserAuthService;
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
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Override
    @Transactional
    public int insert(UserAuth model) {
        return userAuthMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(UserAuth model){
        return userAuthMapper.insertSelective(model);
    }

    @Override
    public PageInfo<UserAuth> getByPage(Integer pageNum, Integer pageSize) {
        UserAuthExample userAuthExample = new UserAuthExample();
        UserAuthExample.Criteria criteria = userAuthExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, userAuthExample);
    }

    @Override
    public PageInfo<UserAuth> getPagesByExample(Integer pageNum, Integer pageSize, UserAuthExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<UserAuth> list = userAuthMapper.selectByExample(example);
        PageInfo<UserAuth> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        UserAuthExample userAuthExample = new UserAuthExample();
        UserAuthExample.Criteria criteria = userAuthExample.createCriteria();
        criteria.andIdEqualTo(id);
        return deleteByExample(userAuthExample);
    }

    @Override
    @Transactional
    public int deleteByExample(UserAuthExample example) {
        return userAuthMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(UserAuth model,Long id) {
        UserAuthExample userAuthExample = new UserAuthExample();
        UserAuthExample.Criteria criteria = userAuthExample.createCriteria();
        criteria.andIdEqualTo(id);
        return updateSelectiveByExample(model,userAuthExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(UserAuth model, UserAuthExample example){
        return userAuthMapper.updateByExampleSelective(model,example);
    }
}