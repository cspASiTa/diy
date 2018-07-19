package com.hycxkj.recommend.service;

import com.hycxkj.recommend.entity.UserLikeLog;

import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 8:24
 */
public interface UserLikeLogService {

    /**
     *  获取集合中去重后的用户的ID；
     * @return List<Long>
     */
    List<Long> getUsersId();

    /**
     *  通过 UserId 获取 userId 当天所浏览的作品
     * @param userId
     * @return
     */
    List<UserLikeLog> getUserLikeLogsByUserId(long userId);


}
