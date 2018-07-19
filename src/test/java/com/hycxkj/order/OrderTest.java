package com.hycxkj.order;

import com.hycxkj.order.bean.Order;
import com.hycxkj.order.bean.OrderDetail;
import com.hycxkj.order.font.FontOrder;
import com.hycxkj.order.font.FontOrderList;
import com.hycxkj.order.mapper.OrderMapper;
import com.hycxkj.order.service.OrderDetailService;
import com.hycxkj.order.service.OrderService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/13 14:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailService orderDetailService;

    @Test
    public void testInsertSelectiveBatch() {
        List<Order> list = new ArrayList<>();
        for(int i =0 ; i< 10;i ++) {
            Order order = new Order();
            order.setOrderDetailId("11");
            order.setWeights(11l);
            order.setPicPath("www.baidu.com");
            order.setItemId(1l);
            order.setNum(121);
            list.add(order);
        }
        orderMapper.insertByBatch(list);
        System.out.println(list);
    }

    @Test
    public void testOrder() {
        MyDevice device = new MyDevice();
        List<FontOrder> list = new ArrayList<>();
        FontOrder order = new FontOrder();
        order.setAddrId(2);
        order.setCarryAway((byte)0);
        order.setNum(3);
        order.setShopBusiId(21);
        order.setShopItemId(59);
        order.setUid(1);

        FontOrder order1 = new FontOrder();
        order1.setAddrId(2);
        order1.setCarryAway((byte)0);
        order1.setNum(1);
        order1.setShopBusiId(21);
        order1.setShopItemId(60);
        order1.setUid(1);

        FontOrder order2 = new FontOrder();
        order2.setAddrId(2);
        order2.setCarryAway((byte)0);
        order2.setNum(3);
        order2.setShopBusiId(21);
        order2.setShopItemId(61);
        order2.setUid(1);

        FontOrder order3 = new FontOrder();
        order3.setAddrId(2);
        order3.setCarryAway((byte)0);
        order3.setNum(1);
        order3.setShopBusiId(20);
        order3.setShopItemId(58);
        order3.setUid(1);

        list.add(order);
        list.add(order1);
        list.add(order2);
        list.add(order3);
        FontOrderList fontOrderList = new FontOrderList();
        fontOrderList.setFontOrders(list);
        List<String> detail = orderDetailService.insertOrderDetail(fontOrderList, device);
        for (String s : detail) {
            System.out.println(s);
        }

    }

    public class MyDevice implements Device {

        @Override
        public boolean isNormal() {
            return true;
        }

        @Override
        public boolean isMobile() {
            return false;
        }

        @Override
        public boolean isTablet() {
            return false;
        }

        @Override
        public DevicePlatform getDevicePlatform() {
            return null;
        }
    }
}
