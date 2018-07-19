package com.hycxkj.user.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.UserAddr;
import com.hycxkj.user.bean.UserAddrExample;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:12 CST 2018
*/
public interface UserAddrService {

    int insert(UserAddr model);

    /**
     * 只插入部分
     */
    int insertSelective(UserAddr model);

    PageInfo<UserAddr> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<UserAddr> getPagesByExample(Integer pageNum, Integer pageSize, UserAddrExample example);

    int deleteById(Long id);

    int deleteByExample(UserAddrExample example);

    int updateSelectiveById(UserAddr model,Long id);

    int updateSelectiveByExample(UserAddr model, UserAddrExample example);

    UserAddr getByAddrId(long addrId);
}