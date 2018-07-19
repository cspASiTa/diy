package com.hycxkj.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.hycxkj.common.base.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author 陈少平
 * @description
 * @create in 2018/2/20 21:35
 */
@RestControllerAdvice
public class GlobalExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionAspect.class);

    @ExceptionHandler(value = {MissingServletRequestParameterException.class, InvalidPropertyException.class,BindException.class})
    public Object delMissingServletRequestParameterException(Exception ex){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", HttpStatus.E_400.getCode());
        jsonObject.put("msg",HttpStatus.E_400.getMessage());
        return jsonObject;
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object delHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", HttpStatus.E_415.getCode());
        jsonObject.put("msg",HttpStatus.E_415.getMessage() +"=>"+ex.getMessage());
        return jsonObject;
    }

    /**
     *  处理自定义验证注解异常
     * @param ex 异常
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Object delConstraintViolationException(ConstraintViolationException ex) {
        JSONObject jsonObject = new JSONObject();
        StringBuilder sb = new StringBuilder();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            sb.append(violation.getMessageTemplate());
        }
        jsonObject.put("code",HttpStatus.E_400.getCode());
        jsonObject.put("msg",sb.toString());
        return jsonObject;
    }
}
