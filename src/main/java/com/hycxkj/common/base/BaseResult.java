package com.hycxkj.common.base;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/29 15:27
 */
@Data
@NoArgsConstructor
public class BaseResult {
    private int code;
    private String message;
    private Object data;
}
