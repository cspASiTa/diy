package com.hycxkj.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Properties;

/**
 * @author 陈少平
 * @description
 * @create in 2018/2/13 17:48
 */
public class ValidateResultPush {

    private static final String LINE_SEPARATOR ;
    static {
        Properties properties = System.getProperties();
        LINE_SEPARATOR = properties.getProperty("line.separator");
    }

    public static String validateHasError(BindingResult result){
        if(result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errors = result.getAllErrors();
            int size = errors.size();
            for(int i = 0; i < size; i++) {
                ObjectError error = errors.get(i);
                if(i < size - 1) {
                    sb.append(error.getDefaultMessage()).append(LINE_SEPARATOR);
                }else {
                    sb.append(error.getDefaultMessage());
                }
            }
            for (ObjectError error : errors) {
                sb.append(error.getDefaultMessage());
            }
            return sb.toString();
        }
        return null;
    }
}
