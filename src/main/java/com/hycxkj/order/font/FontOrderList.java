package com.hycxkj.order.font;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 13:48
 */
@ApiModel(value = "FontOrderList")
@NoArgsConstructor
@Data
public class FontOrderList implements Serializable {
    private List<FontOrder> fontOrders;
}
