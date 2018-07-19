package com.hycxkj.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.User;
import com.hycxkj.user.bean.UserExample;
import com.hycxkj.user.mapper.UserMapper;
import com.hycxkj.user.service.UserService;
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
* @create in Thu Mar 29 16:51:13 CST 2018
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public int insert(User model) {
        return userMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(User model){
        return userMapper.insertSelective(model);
    }

    @Override
    public PageInfo<User> getByPage(Integer pageNum, Integer pageSize) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, userExample);
    }

    @Override
    public PageInfo<User> getPagesByExample(Integer pageNum, Integer pageSize, UserExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.selectByExample(example);
        PageInfo<User> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return deleteByExample(userExample);
    }

    @Override
    @Transactional
    public int deleteByExample(UserExample example) {
        return userMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(User model,Long id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return updateSelectiveByExample(model,userExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(User model, UserExample example){
        return userMapper.updateByExampleSelective(model,example);
    }

    @Override
    public User getUserById(Long userId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<User> list = userMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }
}