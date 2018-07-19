package com.hycxkj.user.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.user.bean.UserAuth;
import com.hycxkj.user.bean.UserAuthExample;
import java.util.List;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:12 CST 2018
*/
public interface UserAuthService {

    int insert(UserAuth model);

    /**
     * 只插入部分
     */
    int insertSelective(UserAuth model);

    PageInfo<UserAuth> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<UserAuth> getPagesByExample(Integer pageNum, Integer pageSize, UserAuthExample example);

    int deleteById(Long id);

    int deleteByExample(UserAuthExample example);

    int updateSelectiveById(UserAuth model,Long id);

    int updateSelectiveByExample(UserAuth model, UserAuthExample example);

}