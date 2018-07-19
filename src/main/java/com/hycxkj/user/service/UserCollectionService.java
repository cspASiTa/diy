package com.hycxkj.user.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.production.font.FontSimpleProduction;
import com.hycxkj.user.bean.UserCollection;
import com.hycxkj.user.bean.UserCollectionExample;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:12 CST 2018
*/
public interface UserCollectionService {

    int insert(UserCollection model);

    /**
     * 只插入部分
     */
    int insertSelective(UserCollection model);

    PageInfo<UserCollection> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<UserCollection> getPagesByExample(Integer pageNum, Integer pageSize, UserCollectionExample example);

    int deleteById(Long id);

    int deleteByExample(UserCollectionExample example);

    int updateSelectiveById(UserCollection model,Long id);

    int updateSelectiveByExample(UserCollection model, UserCollectionExample example);

    /**
     *  分页获取用户的收藏的作品
     * @param userId 用户ID
     * @param pageNum 从第几页开始
     * @param pageSize 1页有多少条记录
     * @return
     */
    PageInfo<FontSimpleProduction> selectCollectionProductionInfo(long userId, int pageNum, int pageSize);
}