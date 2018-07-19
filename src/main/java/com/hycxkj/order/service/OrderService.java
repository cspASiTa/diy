package com.hycxkj.order.service;

import com.hycxkj.order.bean.Order;

import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 10:36
 */
public interface OrderService {

    int insertOrderBatch(List<Order> orders);
}
