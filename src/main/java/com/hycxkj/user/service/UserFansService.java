package com.hycxkj.user.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.UserFans;
import com.hycxkj.user.bean.UserFansExample;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:12 CST 2018
*/
public interface UserFansService {

    int insert(UserFans model);

    /**
     * 只插入部分
     */
    int insertSelective(UserFans model);

    PageInfo<UserFans> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<UserFans> getPagesByExample(Integer pageNum, Integer pageSize, UserFansExample example);

    int deleteById(Long id);

    int deleteByExample(UserFansExample example);

    int updateSelectiveById(UserFans model,Long id);

    int updateSelectiveByExample(UserFans model, UserFansExample example);
    /**
     *  获取用户的fans数
     * @param userId
     * @return
     */
    long getFansCount(Long userId);

    /**
     * 获取用户的关注数
     * @param focusId
     * @return
     */
    long getFocusCount(Long focusId);
}