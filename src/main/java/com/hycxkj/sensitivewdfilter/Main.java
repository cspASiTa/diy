package com.hycxkj.sensitivewdfilter;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/1 15:22
 */
public class Main {

    public static void main(String[] args) {
        String s = "我草尼玛的出售炸药,我叫习近平哈哈李小鹏";
        String ss = "我草尼玛的出售炸药电话的个筹备习近平。我草你妈的个傻逼，。草草草哦啊哦";
        String filter = WordFilter.doFilter(s);
        System.out.println(filter);
    }
}
