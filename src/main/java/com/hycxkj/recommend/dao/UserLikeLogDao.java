package com.hycxkj.recommend.dao;

import com.hycxkj.recommend.entity.UserLikeLog;

import java.util.Date;
import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 8:27
 */
public interface UserLikeLogDao {

    /**
     *  去重查询
     *  @param fieldName 去重的字段标志
     * @return 去重后的字段
     */
    List getDistinct(String fieldName);

    /**
     * 通过 userId 和 大于指定的时间内 获取 UserLikeLogs
     * @param userId
     * @param time
     * @return  List<UserLikeLog>
     */
    List<UserLikeLog> getUserLikeLogsByUserIdAndGtTime(long userId, Date time);

}
