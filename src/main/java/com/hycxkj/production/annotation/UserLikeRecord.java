package com.hycxkj.production.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 陈少平
 * @description 用于记录用户的喜好，只是为了AOP能够拦截到！！
 * @create in 2018/4/13 9:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UserLikeRecord {
}
