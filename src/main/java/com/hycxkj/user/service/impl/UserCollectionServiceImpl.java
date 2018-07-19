package com.hycxkj.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.production.font.FontSimpleProduction;
import com.hycxkj.user.bean.UserCollection;
import com.hycxkj.user.bean.UserCollectionExample;
import com.hycxkj.user.mapper.UserCollectionMapper;
import com.hycxkj.user.service.UserCollectionService;
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
public class UserCollectionServiceImpl implements UserCollectionService {

    @Autowired
    private UserCollectionMapper userCollectionMapper;

    @Override
    @Transactional
    public int insert(UserCollection model) {
        return userCollectionMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(UserCollection model){
        return userCollectionMapper.insertSelective(model);
    }

    @Override
    public PageInfo<UserCollection> getByPage(Integer pageNum, Integer pageSize) {
        UserCollectionExample userCollectionExample = new UserCollectionExample();
        UserCollectionExample.Criteria criteria = userCollectionExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, userCollectionExample);
    }

    @Override
    public PageInfo<UserCollection> getPagesByExample(Integer pageNum, Integer pageSize, UserCollectionExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<UserCollection> list = userCollectionMapper.selectByExample(example);
        PageInfo<UserCollection> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        UserCollectionExample userCollectionExample = new UserCollectionExample();
        UserCollectionExample.Criteria criteria = userCollectionExample.createCriteria();
        criteria.andCollectionIdEqualTo(id);
        return deleteByExample(userCollectionExample);
    }

    @Override
    @Transactional
    public int deleteByExample(UserCollectionExample example) {
        return userCollectionMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(UserCollection model,Long id) {
        UserCollectionExample userCollectionExample = new UserCollectionExample();
        UserCollectionExample.Criteria criteria = userCollectionExample.createCriteria();
        criteria.andCollectionIdEqualTo(id);
        return updateSelectiveByExample(model,userCollectionExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(UserCollection model, UserCollectionExample example){
        return userCollectionMapper.updateByExampleSelective(model,example);
    }

    @Override
    public PageInfo<FontSimpleProduction> selectCollectionProductionInfo(long userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FontSimpleProduction> list = userCollectionMapper.selectCollectionProductionInfo(userId);
        PageInfo<FontSimpleProduction> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}