package com.hycxkj.redis;

import com.hycxkj.recommend.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/23 14:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void addProductionClickTest() {
        redisService.increaseProductionClick(16);
        redisService.increaseProductionClick(26);
        redisService.increaseProductionClick(36);
        redisService.increaseProductionClick(46);
        redisService.increaseProductionClick(56);
        redisService.increaseProductionClick(66);
        redisService.increaseProductionClick(76);
        redisService.increaseProductionClick(86);
        redisService.increaseProductionClick(96);
        redisService.increaseProductionClick(106);
        redisService.increaseProductionClick(326);
        redisService.increaseProductionClick(226);
        redisService.increaseProductionClick(226);
        redisService.increaseProductionClick(226);
        redisService.increaseProductionClick(226);
        redisService.increaseProductionClick(226);
        redisService.increaseProductionClick(226);
        redisService.increaseProductionClick(226);
        redisService.increaseProductionClick(226);
        redisService.increaseProductionClick(226);
        for(long i = 34; i < 551; i++) {
            redisService.increaseProductionClick(i);
        }
    }

    @Test
    public void getProductionClickTop10Test() {
        redisService.getProductionClickTop10().forEach(x -> {
            System.out.println(x.getScore() + " " +x.getValue());
        });
    }

    @Test
    public void clearTest() {
        redisService.clearProductionClickZset();
        getProductionClickTop10Test();
    }
}
