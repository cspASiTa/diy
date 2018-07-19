package com.hycxkj.common.util;

import org.springframework.context.ApplicationContext;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/14 9:49
 */
public class ApplicationContextUtil {
    private static ApplicationContext applicationContext;
    //获取上下文
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //设置上下文
    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    //通过名字获取上下文中的bean
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    //通过类型获取上下文中的bean
    public static Object getBean(Class<?> requiredType){
        return applicationContext.getBean(requiredType);
    }
}
