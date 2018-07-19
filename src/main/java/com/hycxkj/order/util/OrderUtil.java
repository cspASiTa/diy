package com.hycxkj.order.util;

import org.springframework.mobile.device.Device;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author 陈少平
 * @description 订单工具类
 * @create in 2018/5/6 10:51
 */
public class OrderUtil {

    /**
     *  获取用户下单渠道
     * @param device
     * @return
     */
    private static String getOrderChannel(Device device) {
        if(device.isNormal()) {
            return OrderChannel.WEB;
        }else if(device.isMobile()) {
            return OrderChannel.PHONE;
        }else if(device.isTablet()) {
            return OrderChannel.TABLET;
        }
        return OrderChannel.UNKNOWN;
    }

    /**
     *  订单渠道描述类
     *  1 ： 网页下单
     *  2 ： 手机下单
     *  3 :  平板下单
     *  4 :  未知
     */
    public static class OrderChannel {
        public static String WEB = "1";
        public static String PHONE = "2";
        public static String TABLET = "3";
        public static String UNKNOWN = "4";
    }

    /**
     *  1位下单渠道
     *  12位下单日期。例如 20180913121213(年月日时分秒)
     *  3位随机。
     * @return
     */
    public static String generatorOrderId(Device device) {
        String orderChannel = getOrderChannel(device);
        // 12位
        String orderId = DateTimeFormatter.ofPattern("yyMMddHHssmm").format(LocalDateTime.now());;
        // 3位随机
        String random = get3Random();
        return orderChannel + orderId + random;
    }

    /**
     *  获取3位随机的数字
     * @return
     */
    private static String get3Random() {
        Random random = new Random();
        String i = random.nextInt(1000) + "";
        int fillLength = 3 - i.length();
        String tmp = "";
        switch (fillLength) {
            case 1: tmp = "0"; break;
            case 2: tmp = "00"; break;
            default:break;
        }
        return tmp + i;
    }


}
