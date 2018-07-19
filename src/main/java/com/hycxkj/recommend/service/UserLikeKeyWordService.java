package com.hycxkj.recommend.service;

import com.hycxkj.recommend.entity.UserLikeKeyWord;

import java.util.List;
import java.util.Set;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 16:17
 */
public interface UserLikeKeyWordService {

    void insertAll(Set<UserLikeKeyWord> set);

    /**
     *  通过UserId 获取 用户的记录
     * @param userId
     * @return
     */
    List<UserLikeKeyWord> getListByUserId(long userId);

    void deleteListByUserId(long userId);

    void deleteById(String id);

}
