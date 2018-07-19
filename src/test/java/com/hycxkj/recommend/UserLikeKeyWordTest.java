package com.hycxkj.recommend;

import com.hycxkj.recommend.entity.UserLikeKeyWord;
import com.hycxkj.recommend.service.UserLikeKeyWordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 20:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.hycxkj.Main.class)
public class UserLikeKeyWordTest {

    @Autowired
    private ScheduleTask scheduleTask;

    @Autowired
    private UserLikeKeyWordService userLikeKeyWordService;

    @Test
    public void analysisUserLikeLog() {
        scheduleTask.analysisUserLikeLog();
    }

    @Test
    public void testDeleteListByUserId() {
        userLikeKeyWordService.deleteListByUserId(12l);
    }

    @Test
    public void testDeleteByObject() {
        List<UserLikeKeyWord> listByUserId = userLikeKeyWordService.getListByUserId(12l);
        userLikeKeyWordService.deleteById(listByUserId.get(0).getId());
    }

}
