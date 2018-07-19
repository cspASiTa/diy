package com.hycxkj.user.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.UserPay;
import com.hycxkj.user.bean.UserPayExample;
import java.util.List;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:12 CST 2018
*/
public interface UserPayService {

    int insert(UserPay model);

    /**
     * 只插入部分
     */
    int insertSelective(UserPay model);

    PageInfo<UserPay> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<UserPay> getPagesByExample(Integer pageNum, Integer pageSize, UserPayExample example);

    int deleteById(Long id);

    int deleteByExample(UserPayExample example);

    int updateSelectiveById(UserPay model,Long id);

    int updateSelectiveByExample(UserPay model, UserPayExample example);

}