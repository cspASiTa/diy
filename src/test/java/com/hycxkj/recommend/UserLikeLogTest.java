package com.hycxkj.recommend;

import com.hycxkj.recommend.dao.UserLikeLogDao;
import com.hycxkj.recommend.entity.UserLikeLog;
import com.hycxkj.recommend.service.UserLikeLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 10:42
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.hycxkj.Main.class)
public class UserLikeLogTest {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserLikeLogService userLikeLogService;

    @Autowired UserLikeLogDao userLikeLogDao;

    @Test
    public void testFindDistinctUserId() {
        List distinct = mongoTemplate.getCollection("userLikeLog").distinct("userId");
        System.out.println(distinct);
    }

    @Test
    public void testGetUserLikeLogsByUserId() {
        List<UserLikeLog> userId = userLikeLogService.getUserLikeLogsByUserId(12l);
        System.out.println(" sss " + userId);
        LocalDateTime of = LocalDateTime.of(2018, 4, 19, 0, 0, 0);
        Date date = new Date(of.getNano());
        System.out.println(date);
        List<UserLikeLog> userLikeLogsByUserIdAndGtTime = userLikeLogDao.getUserLikeLogsByUserIdAndGtTime(12l, date);
        System.out.println("xxxx  "+ userLikeLogsByUserIdAndGtTime);
    }

}
