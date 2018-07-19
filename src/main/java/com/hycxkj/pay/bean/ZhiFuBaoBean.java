package com.hycxkj.pay.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 0:47
 */
@Data
@NoArgsConstructor
public class ZhiFuBaoBean {
    @ApiModelProperty("商户订单号，商户网站订单系统中唯一订单号，必填")
    private String WIDout_trade_no;
    @ApiModelProperty("订单名称，必填")
    private String WIDsubject;
    @ApiModelProperty("付款金额，必填")
    private String WIDtotal_amount;
    @ApiModelProperty("销售产品码 必填")
    String product_code="QUICK_WAP_WAY";
    @ApiModelProperty("商品描述，可空")
    private String WIDbody;
    @ApiModelProperty("超时时间 可空")
    String timeout_express="2m";
}
