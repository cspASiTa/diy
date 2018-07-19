package com.hycxkj.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/23 18:45
 */
public class TimeFormatterUtil {

    /**
     *  主要用于LocalDateTime转 Date时的工具类
     *  LocalDateTime toString 时， 会带有个T。
     * @param date
     * @return
     */
    public static Date formatterDate(String date) {
        date = date.replace("T", " ");
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd hh:mm");
        Date tmp = null;
        try {
            tmp = format.parse(date);
        } catch (ParseException e) {
            format.applyPattern("yyyy-MM-dd hh:mm:ss");
            try {
                tmp = format.parse(date);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return tmp;
    }
}
