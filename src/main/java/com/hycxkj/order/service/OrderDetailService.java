package com.hycxkj.order.service;

import com.hycxkj.order.font.FontOrderList;
import org.springframework.mobile.device.Device;

import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 10:36
 */
public interface OrderDetailService {

    /**
     *  插入订单详细
     *  @param orderList 前端提交的订单
     * @return 订单号， 因为会发生拆单行为，所以返回的订单号可能有多个！
     */
    List<String> insertOrderDetail(FontOrderList orderList, Device device);
}
