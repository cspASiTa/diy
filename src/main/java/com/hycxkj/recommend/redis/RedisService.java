package com.hycxkj.recommend.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author 陈少平
 * @description  缓存，主要是为了实现，更好，更方便的实现，每日点击Top 10
 * @create in 2018/4/22 18:32
 */
@Component
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //无需理自动检测插件的错误。spring自动为我们注入了stringRedisTemplate，我们自然可以拿到
    @Resource(name = "stringRedisTemplate")
    private ZSetOperations<String, String> zSet;
    /**
     *  存储点击率的 zset key
     */
    private static final String PRODUCTION_CLICK_ZSET = "productionClickZset";

    /**
     * 将作品的点击数 + 1
     * @param productionId
     */
    public void increaseProductionClick(String productionId) {
        zSet.incrementScore(PRODUCTION_CLICK_ZSET,productionId,1);
    }

    /**
     * 将作品的点击数 + 1
     * @param productionId
     */
    public void increaseProductionClick(long productionId) {
        zSet.incrementScore(PRODUCTION_CLICK_ZSET,productionId+"",1);
    }

    /**
     * 返回每日点击数最多的10个
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> getProductionClickTop10() {
        Set<ZSetOperations.TypedTuple<String>> tupleSet = zSet.reverseRangeWithScores(PRODUCTION_CLICK_ZSET, 0, 9);
        return tupleSet;
    }

    /**
     * 按照作品的点击数从高到低，分页返回
     * @param pageNum 从第几页
     * @param pageSize 每页大小
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> getProductionByClickDescAndPage(int pageNum, int pageSize) {
        long start = (pageNum - 1) * pageSize;
        long end = pageNum * pageSize - 1;
        Set<ZSetOperations.TypedTuple<String>> set = zSet.reverseRangeWithScores(PRODUCTION_CLICK_ZSET, start, end);
        return set;
    }


    /**
     *  清空productionClickZset。
     */
    public void clearProductionClickZset(){
        RedisOperations<String, String> operations = zSet.getOperations();
        operations.delete(PRODUCTION_CLICK_ZSET);
    }
}
