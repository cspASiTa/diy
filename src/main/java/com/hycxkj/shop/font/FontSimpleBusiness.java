package com.hycxkj.shop.font;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/2 16:28
 */
@NoArgsConstructor
@Data
public class FontSimpleBusiness implements Serializable{
    private String image;
    private Long busiId;
    private String shopName;
}
