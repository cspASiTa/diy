package com.hycxkj.order.font;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 12:23
 */
@ApiModel(value = "FontOrder")
@Data
@NoArgsConstructor
public class FontOrder implements Serializable {
    @ApiModelProperty("商家ID，必填")
    private long shopBusiId;
    @ApiModelProperty("商品ID，必填")
    private long shopItemId;
    @ApiModelProperty("购买的商品数量，必填")
    private int num;
    @ApiModelProperty("用户ID,必填")
    private long uid;
    @ApiModelProperty("用户地址ID，必填")
    private long addrId;
    @ApiModelProperty("商品的运送方式，必填")
    private byte carryAway;
}
