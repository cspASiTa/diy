package com.hycxkj.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.shop.bean.ShopBusiness;
import com.hycxkj.shop.bean.ShopBusinessExample;
import com.hycxkj.shop.font.FontSimpleBusiness;
import com.hycxkj.shop.mapper.ShopBusinessMapper;
import com.hycxkj.shop.service.ShopBusinessService;
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
* @create in 2018/04/02 05:42
*/
@Service
public class ShopBusinessServiceImpl implements ShopBusinessService {

    @Autowired
    private ShopBusinessMapper shopBusinessMapper;

    @Override
    @Transactional
    public long insert(ShopBusiness model) {
        return shopBusinessMapper.insert(model);
    }

    @Override
    @Transactional
    public long insertSelective(ShopBusiness model){
        return shopBusinessMapper.insertSelective(model);
    }

    @Override
    public PageInfo<ShopBusiness> getByPage(Integer pageNum, Integer pageSize) {
        ShopBusinessExample shopBusinessExample = new ShopBusinessExample();
        ShopBusinessExample.Criteria criteria = shopBusinessExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, shopBusinessExample);
    }

    @Override
    public PageInfo<ShopBusiness> getPagesByExample(Integer pageNum, Integer pageSize, ShopBusinessExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<ShopBusiness> list = shopBusinessMapper.selectByExample(example);
        PageInfo<ShopBusiness> info = new PageInfo<>(list);
        return info;
    }

    public ShopBusiness getById(Long id) {
        ShopBusinessExample shopBusinessExample = new ShopBusinessExample();
        ShopBusinessExample.Criteria criteria = shopBusinessExample.createCriteria();
        criteria.andBusiIdEqualTo(id);
        List<ShopBusiness> list = shopBusinessMapper.selectByExample(shopBusinessExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Long id) {
        ShopBusinessExample shopBusinessExample = new ShopBusinessExample();
        ShopBusinessExample.Criteria criteria = shopBusinessExample.createCriteria();
        criteria.andBusiIdEqualTo(id);
        return deleteByExample(shopBusinessExample);
    }

    @Override
    @Transactional
    public int deleteByExample(ShopBusinessExample example) {
        return shopBusinessMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(ShopBusiness model,Long id) {
        ShopBusinessExample shopBusinessExample = new ShopBusinessExample();
        ShopBusinessExample.Criteria criteria = shopBusinessExample.createCriteria();
        criteria.andBusiIdEqualTo(id);
        return updateSelectiveByExample(model,shopBusinessExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(ShopBusiness model, ShopBusinessExample example){
        return shopBusinessMapper.updateByExampleSelective(model,example);
    }

    @Override
    public PageInfo<FontSimpleBusiness> getFinishStoreSimpleInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FontSimpleBusiness> list = shopBusinessMapper.getFinishStoreSimpleInfo((byte)0);
        PageInfo<FontSimpleBusiness> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<FontSimpleBusiness> getSelfMadeFinishStoreSimpleInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FontSimpleBusiness> list = shopBusinessMapper.getFinishStoreSimpleInfo((byte)1);
        PageInfo<FontSimpleBusiness> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<FontSimpleBusiness> getFinishSpecialStoreSimpleInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FontSimpleBusiness> list = shopBusinessMapper.getSpecialStoreSimpleInfo((byte)0);
        PageInfo<FontSimpleBusiness> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<FontSimpleBusiness> getSelfMadeFinishSpecialStoreSimpleInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FontSimpleBusiness> list = shopBusinessMapper.getSpecialStoreSimpleInfo((byte)1);
        PageInfo<FontSimpleBusiness> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}