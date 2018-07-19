package com.hycxkj.shop.mapper;

import com.hycxkj.shop.bean.ShopBusiItem;
import com.hycxkj.shop.bean.ShopBusiItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopBusiItemMapper {
    long countByExample(ShopBusiItemExample example);

    int deleteByExample(ShopBusiItemExample example);

    long insert(ShopBusiItem record);

    long insertSelective(ShopBusiItem record);

    List<ShopBusiItem> selectByExample(ShopBusiItemExample example);

    int updateByExampleSelective(@Param("record") ShopBusiItem record, @Param("example") ShopBusiItemExample example);

    int updateByExample(@Param("record") ShopBusiItem record, @Param("example") ShopBusiItemExample example);
}