package com.hycxkj.shop.font;

import com.hycxkj.shop.bean.ShopComment;
import com.hycxkj.shop.bean.ShopItem;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/5 15:05
 */
@Data
@NoArgsConstructor
public class FontShopItemDetail {
    private ShopItem shopItem;
    private ShopComment shopComment;
}
