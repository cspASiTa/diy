package com.hycxkj.shop.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.shop.bean.ShopBusiItem;
import com.hycxkj.shop.bean.ShopBusiItemExample;

/**
* @author 陈少平
* @description
* @create in 2018/04/02 05:42
*/
public interface ShopBusiItemService {

    long insert(ShopBusiItem model);

    /**
     * 只插入部分
     */
    long insertSelective(ShopBusiItem model);

    PageInfo<ShopBusiItem> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<ShopBusiItem> getPagesByExample(Integer pageNum, Integer pageSize, ShopBusiItemExample example);

    ShopBusiItem getById(Long id);

    int deleteById(Long id);

    int deleteByExample(ShopBusiItemExample example);

    int updateSelectiveById(ShopBusiItem model,Long id);

    int updateSelectiveByExample(ShopBusiItem model, ShopBusiItemExample example);

    /**
     *  通过商家ID 和 商品ID 获取 ShopBusiItem
     * @param shopBusiId
     * @param shopItemId
     * @return
     */
    ShopBusiItem getByBusiIdAndItemId(long shopBusiId, long shopItemId);
}