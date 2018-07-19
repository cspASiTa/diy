package com.hycxkj.user.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.User;
import com.hycxkj.user.bean.UserExample;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:13 CST 2018
*/
public interface UserService {

    int insert(User model);

    /**
     * 只插入部分
     */
    int insertSelective(User model);

    PageInfo<User> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<User> getPagesByExample(Integer pageNum, Integer pageSize, UserExample example);

    int deleteById(Long id);

    int deleteByExample(UserExample example);

    int updateSelectiveById(User model,Long id);

    int updateSelectiveByExample(User model, UserExample example);

    User getUserById(Long userId);
}