package com.hycxkj.recommend.dao;

import com.hycxkj.recommend.entity.UserLikeKeyWord;

import java.util.List;
import java.util.Set;

/**
 * @author 陈少平
 * @description 用户喜欢关键词列表Dao
 * @create in 2018/4/20 16:12
 */
public interface UserLikeKeyWordDao {

    void insertAll(Set<UserLikeKeyWord> set);

    /**
     *  通过UserId 获取 用户的记录
     * @param userId
     * @return
     */
    List<UserLikeKeyWord> getListByUserId(long userId);

    /**
     * 通过 userId 删除  指定用户的记录
     * @param userId
     */
    void deleteListByUserId(long userId);

    /**
     *  删除指定文档
     * @param id
     */
    void deleteById(String id);
}
