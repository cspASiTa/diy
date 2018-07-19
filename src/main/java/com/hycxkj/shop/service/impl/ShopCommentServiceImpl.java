package com.hycxkj.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.shop.bean.ShopComment;
import com.hycxkj.shop.bean.ShopCommentExample;
import com.hycxkj.shop.mapper.ShopCommentMapper;
import com.hycxkj.shop.service.ShopCommentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/04/02 05:42
*/
@Service
public class ShopCommentServiceImpl implements ShopCommentService {

    @Autowired
    private ShopCommentMapper shopCommentMapper;

    @Override
    @Transactional
    public long insert(ShopComment model) {
        return shopCommentMapper.insert(model);
    }

    @Override
    @Transactional
    public long insertSelective(ShopComment model){
        return shopCommentMapper.insertSelective(model);
    }

    @Override
    public PageInfo<ShopComment> getByPage(Integer pageNum, Integer pageSize) {
        ShopCommentExample shopCommentExample = new ShopCommentExample();
        ShopCommentExample.Criteria criteria = shopCommentExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, shopCommentExample);
    }

    public ShopComment getById(Long id) {
        ShopCommentExample shopCommentExample = new ShopCommentExample();
        ShopCommentExample.Criteria criteria = shopCommentExample.createCriteria();
        criteria.andShopCommentIdEqualTo(id);
        List<ShopComment> list = shopCommentMapper.selectByExample(shopCommentExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public PageInfo<ShopComment> getPagesByExample(Integer pageNum, Integer pageSize, ShopCommentExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<ShopComment> list = shopCommentMapper.selectByExample(example);
        PageInfo<ShopComment> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        ShopCommentExample shopCommentExample = new ShopCommentExample();
        ShopCommentExample.Criteria criteria = shopCommentExample.createCriteria();
        criteria.andShopCommentIdEqualTo(id);
        return deleteByExample(shopCommentExample);
    }

    @Override
    @Transactional
    public int deleteByExample(ShopCommentExample example) {
        return shopCommentMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(ShopComment model,Long id) {
        ShopCommentExample shopCommentExample = new ShopCommentExample();
        ShopCommentExample.Criteria criteria = shopCommentExample.createCriteria();
        criteria.andShopCommentIdEqualTo(id);
        return updateSelectiveByExample(model,shopCommentExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(ShopComment model, ShopCommentExample example){
        return shopCommentMapper.updateByExampleSelective(model,example);
    }

    @Override
    public PageInfo<ShopComment> getShopItemComments(Long shopItemId,Integer pageNum, Integer pageSize) {
        ShopCommentExample example = new ShopCommentExample();
        ShopCommentExample.Criteria criteria = example.createCriteria();
        criteria.andShopItemIdEqualTo(shopItemId);
        return getPagesByExample(pageNum, pageSize, example);
    }
}