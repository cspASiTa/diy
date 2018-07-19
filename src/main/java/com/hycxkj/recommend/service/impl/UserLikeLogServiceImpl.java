package com.hycxkj.recommend.service.impl;

import com.hycxkj.common.util.TimeFormatterUtil;
import com.hycxkj.recommend.dao.UserLikeLogDao;
import com.hycxkj.recommend.entity.UserLikeLog;
import com.hycxkj.recommend.service.UserLikeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 8:24
 */
@Service
public class UserLikeLogServiceImpl implements UserLikeLogService{

    @Autowired
    private UserLikeLogDao userLikeLogDao;

    @Override
    public List<Long> getUsersId() {
        return userLikeLogDao.getDistinct("userId");
    }

    @Override
    public List<UserLikeLog> getUserLikeLogsByUserId(long userId) {
        // 日志分析在 晚上12:00。即下一天的 0:0。 因此这边减去 1天.
        // 为了确保时间是 12:00:00。真的是恶心我了。jdk1.8的 LocalDateTime 提供的Api 转换Date 真的是好麻烦
        // 考虑用Instant，但是Instant 提供的API 更不符合我的要求
        LocalDateTime time = LocalDateTime.now().minusDays(1);
        LocalDateTime of = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), 0, 0, 0);
        Date date = TimeFormatterUtil.formatterDate(of.toString());
        List<UserLikeLog> likeLogs = userLikeLogDao.getUserLikeLogsByUserIdAndGtTime(userId,date);
        return likeLogs;
    }

}
