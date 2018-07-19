package com.hycxkj.recommend;

import com.hycxkj.recommend.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/23 16:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ScheduleTest {

    @Autowired
    private ScheduleTask scheduleTask;

    @Autowired
    private RedisService redisService;

    @Test
    public void generatorProductionClickTop10Test() {
        scheduleTask.generatorProductionClickTop10();
        redisService.getProductionClickTop10().forEach(x -> {
            System.out.println(x.getScore());
        });
    }
}
