package com.hycxkj.shop.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.shop.bean.ShopItem;
import com.hycxkj.shop.bean.ShopItemExample;
import com.hycxkj.shop.font.FontSimpleShopItem;

/**
* @author 陈少平
* @description
* @create in 2018/04/02 05:42
*/
public interface ShopItemService {

    long insert(ShopItem model);

    /**
     * 只插入部分
     */
    long insertSelective(ShopItem model);

    PageInfo<ShopItem> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<ShopItem> getPagesByExample(Integer pageNum, Integer pageSize, ShopItemExample example);

    ShopItem getById(Long id);

    int deleteById(Long id);

    int deleteByExample(ShopItemExample example);

    int updateSelectiveById(ShopItem model,Long id);

    int updateSelectiveByExample(ShopItem model, ShopItemExample example);

    /**
     *  获取单品推荐（type 1 是自制， type 0 是成品）
     * @param type 自制：1 或者 成品：0
     * @return
     */
    PageInfo<FontSimpleShopItem> getSingleItemRecommend(byte type,Integer pageNum, Integer pageSize);

    /**
     *  获取每日上新（type 1 是自制， type 0 是成品）
     * @param type  自制：1 或者 成品：0
     * @return
     */
    PageInfo<FontSimpleShopItem> getFreshRecommend(byte type,Integer pageNum, Integer pageSize);

}