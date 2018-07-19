package com.hycxkj.common.base;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/29 15:36
 */
public enum HttpStatus {

    OK(200,"OK"),
    OK_201(201,"新资源被创建"),
    E_400(400,"请求参数不匹配"),
    E_401(401, "没有登录"),
    E_403(403,"没有权限"),
    E_404(404,"找不到页面"),
    E_405(405,"请求方式不对"),
    E_415(415,"不支持的媒体类型"),
    E_500(500, "亲，服务器正忙，请稍等");

    private int code;
    private String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
