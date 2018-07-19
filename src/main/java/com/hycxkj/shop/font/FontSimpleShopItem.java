package com.hycxkj.shop.font;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/2 19:01
 */
@Data
@NoArgsConstructor
public class FontSimpleShopItem implements Serializable{
    private Long itemId;
    private String image;
    private Long shopBusiId;
    private String shopName;
}
