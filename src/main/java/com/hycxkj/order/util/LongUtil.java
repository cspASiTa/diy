package com.hycxkj.order.util;

import com.hycxkj.order.exception.LongOverFlowException;

import java.util.Objects;

/**
 * @author 陈少平
 * @description Long工具类
 * @create in 2018/5/6 12:57
 */
public class LongUtil {
    /**
     * 判断是否溢出
     */
    public static boolean isOverFlow(long num) {
        return num < 0? true: false;
    }

    /**
     * 处理 Long NuLl。 如果为Null,转换为0
     * @return
     */
    public static long dealLongNull(Long num) {
        if(Objects.isNull(num)) {
            return 0l;
        }
        return num.longValue();
    }

    /**
     * 判断不法分子，乱填num。导致重量溢出
     */
    public static void isOverFlow(long total, String message) {
        boolean overFlow = LongUtil.isOverFlow(total);
        if(overFlow) {
            throw new LongOverFlowException(message);
        }
    }
}
