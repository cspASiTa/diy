package com.hycxkj.shop.mapper;

import com.hycxkj.shop.bean.ShopBusiItem;
import com.hycxkj.shop.bean.ShopItem;
import com.hycxkj.shop.bean.ShopItemExample;
import com.hycxkj.shop.font.FontSimpleShopItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopItemMapper {
    long countByExample(ShopItemExample example);

    int deleteByExample(ShopItemExample example);

    long insert(ShopItem record);

    long insertSelective(ShopItem record);

    List<ShopItem> selectByExample(ShopItemExample example);

    int updateByExampleSelective(@Param("record") ShopItem record, @Param("example") ShopItemExample example);

    int updateByExample(@Param("record") ShopItem record, @Param("example") ShopItemExample example);

    List<ShopBusiItem> testUse();

    /**
     *  获取单品推荐
     * @param type 自制：1 或者 成品：0
     * @return
     */
    List<FontSimpleShopItem> getSingleItemRecommend(byte type);

    /**
     *  获取每日上新
     * @param type  自制：1 或者 成品：0
     * @return
     */
    List<FontSimpleShopItem> getFreshRecommend(byte type);

}