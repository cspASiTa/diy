package com.hycxkj.common.base;

import com.github.pagehelper.PageInfo;
import com.hycxkj.common.util.ValidateResultPush;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/11 23:09
 */
public class BaseController {

    /**
     * 处理验证失败错误信息
     * @param result
     * @return
     */
    protected BaseResult pushValidatar(BindingResult result) {
        String error = ValidateResultPush.validateHasError(result);
        if(!StringUtils.isEmpty(error)) {
            BaseResult baseResult = new BaseResult();
            baseResult.setCode(HttpStatus.E_400.getCode());
            baseResult.setMessage(error);
            return baseResult;
        }
        return null;
    }

    /**
     *  添加成功的返回值。 code : 200。 msg : OK
     */
    public BaseResult putSuccess(){
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setMessage(HttpStatus.OK.getMessage());
        return result;
    }
    /**
     *  添加成功的返回值
     *  @param data  传给客户端的数据
     */
    public BaseResult putSuccess(Object data){
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(data);
        return result;
    }

    /**
     * 添加 500 的 返回
     * @return
     */
    public BaseResult putError() {
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.E_500.getCode());
        result.setMessage(HttpStatus.E_500.getMessage());
        return result;
    }

    /**
     *  添加 分页的返回
     * @param info
     * @return
     */
    public BaseResult putPage(PageInfo info) {
        BaseResult result = new BaseResult();
        List list = info.getList();
        result.setData(list);
        result.setCode(HttpStatus.OK.getCode());
        return result;
    }
}
