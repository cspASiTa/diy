package com.hycxkj.order.exception;

/**
 * @author 陈少平
 * @description 整形溢出异常
 * @create in 2018/5/6 12:59
 */
public class LongOverFlowException extends RuntimeException {
    public LongOverFlowException() {
    }
    public LongOverFlowException(String message) {
        super(message);
    }
}
