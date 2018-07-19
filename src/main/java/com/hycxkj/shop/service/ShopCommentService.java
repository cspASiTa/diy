package com.hycxkj.shop.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.shop.bean.ShopComment;
import com.hycxkj.shop.bean.ShopCommentExample;

/**
* @author 陈少平
* @description
* @create in 2018/04/02 05:42
*/
public interface ShopCommentService {

    long insert(ShopComment model);

    /**
     * 只插入部分
     */
    long insertSelective(ShopComment model);

    PageInfo<ShopComment> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<ShopComment> getPagesByExample(Integer pageNum, Integer pageSize, ShopCommentExample example);

    ShopComment getById(Long id);

    int deleteById(Long id);

    int deleteByExample(ShopCommentExample example);

    int updateSelectiveById(ShopComment model,Long id);

    int updateSelectiveByExample(ShopComment model, ShopCommentExample example);

    /**
     *  分页获取商品的评论信息
     * @param shopItemId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<ShopComment> getShopItemComments(Long shopItemId,Integer pageNum, Integer pageSize);
}