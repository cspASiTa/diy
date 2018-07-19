package com.hycxkj.shop.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.shop.bean.ShopBusiness;
import com.hycxkj.shop.bean.ShopBusinessExample;
import com.hycxkj.shop.font.FontSimpleBusiness;

/**
* @author 陈少平
* @description
* @create in 2018/04/02 05:42
*/
public interface ShopBusinessService {

    long insert(ShopBusiness model);

    /**
     * 只插入部分
     */
    long insertSelective(ShopBusiness model);

    PageInfo<ShopBusiness> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<ShopBusiness> getPagesByExample(Integer pageNum, Integer pageSize, ShopBusinessExample example);

    ShopBusiness getById(Long id);

    int deleteById(Long id);

    int deleteByExample(ShopBusinessExample example);

    int updateSelectiveById(ShopBusiness model,Long id);

    int updateSelectiveByExample(ShopBusiness model, ShopBusinessExample example);

    /**
     * 获取成品店铺的简单信息
     * @return
     */
    PageInfo<FontSimpleBusiness> getFinishStoreSimpleInfo(Integer pageNum, Integer pageSize);

    /**
     * 获取自制下的成品店铺的简单信息
     * @return
     */
    PageInfo<FontSimpleBusiness> getSelfMadeFinishStoreSimpleInfo(Integer pageNum, Integer pageSize);

    /**
     * 获取成品精选店铺的简单信息
     * @return
     */
    PageInfo<FontSimpleBusiness> getFinishSpecialStoreSimpleInfo(Integer pageNum, Integer pageSize);

    /**
     * 获取自制下精选店铺的简单信息
     * @return
     */
    PageInfo<FontSimpleBusiness> getSelfMadeFinishSpecialStoreSimpleInfo(Integer pageNum, Integer pageSize);
}