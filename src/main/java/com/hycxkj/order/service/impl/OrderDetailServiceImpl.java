package com.hycxkj.order.service.impl;

import com.hycxkj.order.bean.Order;
import com.hycxkj.order.bean.OrderDetail;
import com.hycxkj.order.font.FontOrder;
import com.hycxkj.order.font.FontOrderList;
import com.hycxkj.order.mapper.OrderDetailMapper;
import com.hycxkj.order.service.OrderDetailService;
import com.hycxkj.order.service.OrderService;
import com.hycxkj.order.util.LongUtil;
import com.hycxkj.order.util.OrderUtil;
import com.hycxkj.postage.service.PostageTemplateService;
import com.hycxkj.shop.bean.ShopItem;
import com.hycxkj.shop.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 10:37
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private ShopItemService shopItemService;

    @Autowired
    private PostageTemplateService postageTemplateService;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderService orderService;

    @Override
    @Transactional
    public List<String> insertOrderDetail(FontOrderList orderList, Device device) {
        List<FontOrder> fontOrders = orderList.getFontOrders();
        long uId = fontOrders.get(0).getUid();
        long addrId = fontOrders.get(0).getAddrId();
        //处理前端传上来的Bean, 转换成 Map{key:商家ID,value:Map{key:商品ID,value:商品数量}}
        Map<Long,Map<Long,Integer>> map = new HashMap<>();
        Map<Long, Byte> carryAwayMap = new HashMap<>();
        for (FontOrder fontOrder : fontOrders) {
            long shopBusiId = fontOrder.getShopBusiId();
            long shopItemId = fontOrder.getShopItemId();
            carryAwayMap.put(shopItemId,fontOrder.getCarryAway());
            int num = fontOrder.getNum();
            if(!map.containsKey(shopBusiId)) {
                Map<Long,Integer> tmp = new HashMap<>();
                tmp.put(shopItemId, num);
                map.put(shopBusiId, tmp);
            }else {
                Map<Long, Integer> tmp = map.get(shopBusiId);
                tmp.put(shopItemId, num);
            }
        }
        // 获取每个商家的邮费
        Map<Long, Long> postage = postageTemplateService.calPostage(addrId, map, carryAwayMap);
        // 开始拆单
        ArrayList<Order> orders = new ArrayList<>();
        List<String> specialOrderIds = new ArrayList<>();
        for (Map.Entry<Long, Map<Long, Integer>> mapEntry : map.entrySet()) {
            // 为每一个订单生成唯一的订单号
            String specialOrderId = OrderUtil.generatorOrderId(device);
            specialOrderIds.add(specialOrderId);
            long totalPrice = 0;
            long totalWeight = 0;
            Long busiId = mapEntry.getKey();
            Map<Long, Integer> mapEntryValue = mapEntry.getValue();
            // 处理每个商家的商品  key: 商品ID ， value: 商品数量
            for (Map.Entry<Long, Integer> entry : mapEntryValue.entrySet()) {
                ShopItem shopItem = shopItemService.getById(entry.getKey());
                long price = LongUtil.dealLongNull(shopItem.getPrice());
                long discountPrice = LongUtil.dealLongNull(shopItem.getDiscountPrice());
                long realPrice  = price - discountPrice;
                int num = entry.getValue();
                long shopPrice = num * realPrice;
                totalPrice += shopPrice;
                LongUtil.isOverFlow(totalPrice, "金钱溢出 "+totalPrice);
                long weight = shopItem.getWeight();
                totalWeight += num * weight;
                LongUtil.isOverFlow(totalWeight, "重量溢出 " +totalWeight);
                // 为每个商品生成简单订单
                Order order = new Order();
                order.setOrderDetailId(specialOrderId);
                order.setNum(num);
                order.setPicPath(shopItem.getImage());
                order.setItemId(entry.getKey());
                order.setWeights(num * weight);
                order.setTotalPrice(num * realPrice);
                order.setPrice(price);
                orders.add(order);
            }
            // 加上邮费
            long posrFee = postage.get(busiId);
            totalPrice += posrFee;
            // 完成拆单，生成订单详细表
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderDetailId(specialOrderId);
            orderDetail.setAddrId(addrId);
            orderDetail.setuId(uId);
            orderDetail.setPostFee(posrFee);
            orderDetail.setTotalWeight(totalWeight);
            orderDetail.setCreateTime(new Date());
            orderDetail.setPayment(totalPrice);
            orderDetailMapper.insertSelective(orderDetail);
        }
        orderService.insertOrderBatch(orders);
        return specialOrderIds;
    }
}
