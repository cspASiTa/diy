package com.hycxkj.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.shop.bean.ShopBusiItem;
import com.hycxkj.shop.bean.ShopBusiItemExample;
import com.hycxkj.shop.mapper.ShopBusiItemMapper;
import com.hycxkj.shop.service.ShopBusiItemService;
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
public class ShopBusiItemServiceImpl implements ShopBusiItemService {

    @Autowired
    private ShopBusiItemMapper shopBusiItemMapper;

    @Override
    @Transactional
    public long insert(ShopBusiItem model) {
        return shopBusiItemMapper.insert(model);
    }

    @Override
    @Transactional
    public long insertSelective(ShopBusiItem model){
        return shopBusiItemMapper.insertSelective(model);
    }

    @Override
    public PageInfo<ShopBusiItem> getByPage(Integer pageNum, Integer pageSize) {
        ShopBusiItemExample shopBusiItemExample = new ShopBusiItemExample();
        ShopBusiItemExample.Criteria criteria = shopBusiItemExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, shopBusiItemExample);
    }

    @Override
    public PageInfo<ShopBusiItem> getPagesByExample(Integer pageNum, Integer pageSize, ShopBusiItemExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<ShopBusiItem> list = shopBusiItemMapper.selectByExample(example);
        PageInfo<ShopBusiItem> info = new PageInfo<>(list);
        return info;
    }

    public ShopBusiItem getById(Long id) {
        ShopBusiItemExample shopBusiItemExample = new ShopBusiItemExample();
        ShopBusiItemExample.Criteria criteria = shopBusiItemExample.createCriteria();
        criteria.andShopBusiItemIdEqualTo(id);
        List<ShopBusiItem> list = shopBusiItemMapper.selectByExample(shopBusiItemExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Long id) {
        ShopBusiItemExample shopBusiItemExample = new ShopBusiItemExample();
        ShopBusiItemExample.Criteria criteria = shopBusiItemExample.createCriteria();
        criteria.andShopBusiItemIdEqualTo(id);
        return deleteByExample(shopBusiItemExample);
    }

    @Override
    @Transactional
    public int deleteByExample(ShopBusiItemExample example) {
        return shopBusiItemMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(ShopBusiItem model,Long id) {
        ShopBusiItemExample shopBusiItemExample = new ShopBusiItemExample();
        ShopBusiItemExample.Criteria criteria = shopBusiItemExample.createCriteria();
        criteria.andShopBusiItemIdEqualTo(id);
        return updateSelectiveByExample(model,shopBusiItemExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(ShopBusiItem model, ShopBusiItemExample example){
        return shopBusiItemMapper.updateByExampleSelective(model,example);
    }

    @Override
    public ShopBusiItem getByBusiIdAndItemId(long shopBusiId, long shopItemId) {
        ShopBusiItemExample example = new ShopBusiItemExample();
        ShopBusiItemExample.Criteria criteria = example.createCriteria();
        criteria.andShopBusiIdEqualTo(shopBusiId);
        criteria.andShopItemIdEqualTo(shopItemId);
        List<ShopBusiItem> items = shopBusiItemMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(items)) {
            return null;
        }else {
            return items.get(0);
        }
    }
}