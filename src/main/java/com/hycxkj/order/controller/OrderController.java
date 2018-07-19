package com.hycxkj.order.controller;

import com.hycxkj.common.base.BaseController;
import com.hycxkj.order.font.FontOrderList;
import com.hycxkj.order.service.OrderDetailService;
import com.hycxkj.order.service.OrderService;
import com.hycxkj.shop.service.ShopItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 12:19
 */
@Api(tags = "商品订单接口")
@RequestMapping("/api")
@RestController
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ShopItemService shopItemService;

    @ApiOperation("生成订单")
    @PostMapping("/order")
    public Object generatorOrder(Device device, @ModelAttribute FontOrderList fontOrders) {
        // 先拆单，根据商家进行拆单
        List<String> list = orderDetailService.insertOrderDetail(fontOrders, device);
        return putSuccess(list);
    }
}
