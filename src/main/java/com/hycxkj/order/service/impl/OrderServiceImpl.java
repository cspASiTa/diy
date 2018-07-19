package com.hycxkj.order.service.impl;

import com.hycxkj.order.bean.Order;
import com.hycxkj.order.exception.LongOverFlowException;
import com.hycxkj.order.font.FontOrder;
import com.hycxkj.order.mapper.OrderMapper;
import com.hycxkj.order.service.OrderService;
import com.hycxkj.order.util.LongUtil;
import com.hycxkj.order.util.OrderUtil;
import com.hycxkj.shop.bean.ShopItem;
import com.hycxkj.shop.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 10:37
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShopItemService shopItemService;

    @Override
    public int insertOrderBatch(List<Order> orders) {
        return orderMapper.insertByBatch(orders);
    }
}
