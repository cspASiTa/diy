package com.hycxkj.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.shop.bean.ShopItem;
import com.hycxkj.shop.bean.ShopItemExample;
import com.hycxkj.shop.font.FontShopItemDetail;
import com.hycxkj.shop.font.FontSimpleShopItem;
import com.hycxkj.shop.mapper.ShopItemMapper;
import com.hycxkj.shop.service.ShopItemService;
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
public class ShopItemServiceImpl implements ShopItemService {

    @Autowired
    private ShopItemMapper shopItemMapper;

    @Override
    @Transactional
    public long insert(ShopItem model) {
        return shopItemMapper.insert(model);
    }

    @Override
    @Transactional
    public long insertSelective(ShopItem model){
        return shopItemMapper.insertSelective(model);
    }

    @Override
    public PageInfo<ShopItem> getByPage(Integer pageNum, Integer pageSize) {
        ShopItemExample shopItemExample = new ShopItemExample();
        ShopItemExample.Criteria criteria = shopItemExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, shopItemExample);
    }

    @Override
    public PageInfo<ShopItem> getPagesByExample(Integer pageNum, Integer pageSize, ShopItemExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<ShopItem> list = shopItemMapper.selectByExample(example);
        PageInfo<ShopItem> info = new PageInfo<>(list);
        return info;
    }

    public ShopItem getById(Long id) {
        ShopItemExample shopItemExample = new ShopItemExample();
        ShopItemExample.Criteria criteria = shopItemExample.createCriteria();
        criteria.andItemIdEqualTo(id);
        List<ShopItem> list = shopItemMapper.selectByExample(shopItemExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Long id) {
        ShopItemExample shopItemExample = new ShopItemExample();
        ShopItemExample.Criteria criteria = shopItemExample.createCriteria();
        criteria.andItemIdEqualTo(id);
        return deleteByExample(shopItemExample);
    }

    @Override
    @Transactional
    public int deleteByExample(ShopItemExample example) {
        return shopItemMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(ShopItem model,Long id) {
        ShopItemExample shopItemExample = new ShopItemExample();
        ShopItemExample.Criteria criteria = shopItemExample.createCriteria();
        criteria.andItemIdEqualTo(id);
        return updateSelectiveByExample(model,shopItemExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(ShopItem model, ShopItemExample example){
        return shopItemMapper.updateByExampleSelective(model,example);
    }

    @Override
    public PageInfo<FontSimpleShopItem> getSingleItemRecommend(byte type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FontSimpleShopItem> list = shopItemMapper.getSingleItemRecommend(type);
        PageInfo<FontSimpleShopItem> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<FontSimpleShopItem> getFreshRecommend(byte type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FontSimpleShopItem> list = shopItemMapper.getFreshRecommend(type);
        PageInfo<FontSimpleShopItem> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}