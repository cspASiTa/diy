package com.hycxkj.shop.mapper;

import com.hycxkj.shop.bean.ShopBusiness;
import com.hycxkj.shop.bean.ShopBusinessExample;
import com.hycxkj.shop.font.FontSimpleBusiness;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopBusinessMapper {
    long countByExample(ShopBusinessExample example);

    int deleteByExample(ShopBusinessExample example);

    long insert(ShopBusiness record);

    long insertSelective(ShopBusiness record);

    List<ShopBusiness> selectByExample(ShopBusinessExample example);

    int updateByExampleSelective(@Param("record") ShopBusiness record, @Param("example") ShopBusinessExample example);

    int updateByExample(@Param("record") ShopBusiness record, @Param("example") ShopBusinessExample example);

    /**
     * 获取成品店铺的简单信息
     * @return
     */
    List<FontSimpleBusiness> getFinishStoreSimpleInfo(Byte type);

    /**
     * 获取精选店铺的简单信息
     * @return
     */
    List<FontSimpleBusiness> getSpecialStoreSimpleInfo(Byte type);
}