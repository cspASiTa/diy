package com.hycxkj.recommend;

import com.hycxkj.common.util.TimeFormatterUtil;
import com.hycxkj.recommend.bean.HotProduction;
import com.hycxkj.recommend.entity.UserLikeKeyWord;
import com.hycxkj.recommend.entity.UserLikeLog;
import com.hycxkj.recommend.redis.RedisService;
import com.hycxkj.recommend.service.HotProductionService;
import com.hycxkj.recommend.service.UserLikeKeyWordService;
import com.hycxkj.recommend.service.UserLikeLogService;
import org.ansj.app.keyword.Keyword;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author 陈少平
 * @description  定时处理用户的喜好记录，生成用户喜好列表。用于用户的兴趣推荐
 * @create in 2018/4/20 7:26
 */
@Component
public class ScheduleTask {

    @Autowired
    private UserLikeLogService userLikeLogService;

    @Autowired
    private UserLikeKeyWordService userLikeKeyWordService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private HotProductionService hotProductionService;
    /**
     * 用户喜欢列表最多能有几个词
     */
    private static final int USER_LIKE_WORD_MAX = 20;

    /**
     *  每天凌晨0时0分0秒 开始分析用户当天浏览记录，并将用户喜好列表插入Mongodb中
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void analysisUserLikeLog() {
        List<Long> ids = userLikeLogService.getUsersId();
        ids.forEach(id  -> {
            TreeSet<UserLikeKeyWord> set = new TreeSet<>();
            //获取用户今天的浏览记录
            List<UserLikeLog> userLikeLogs = userLikeLogService.getUserLikeLogsByUserId(id);
            userLikeLogs.forEach(userLikeLog -> {
                String title = userLikeLog.getTitle();
                int categoryId = userLikeLog.getCategoryId();
                List<Keyword> top = AnsjUtil.getWeightTop(title);
                top.forEach(word -> {
                    UserLikeKeyWord keyWord = new UserLikeKeyWord();
                    keyWord.setUserId(id);
                    keyWord.setCategoryId(categoryId);
                    keyWord.setCTime(userLikeLog.getViewTime());
                    keyWord.setKeyword(word.getName());
                    keyWord.setWeight(word.getScore());
                    set.add(keyWord);
                });
            });
            dealLog(set,id);
        });
    }

    /**
     *  每天6点生成昨日作品点击Top 10
     *  1、将redis 作品点击zSet中的Top10 存入 mysql数据库
     *  2、清空redis作品点击zSet
     */
    @Scheduled(cron = "0 0 6 * * ?")
    public void generatorProductionClickTop10(){
        // 获取前一天日期
        LocalDateTime time = LocalDateTime.now().minusDays(1l);
        LocalDateTime of = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), 6, 0, 0);
        Date date = TimeFormatterUtil.formatterDate(of.toString());
        Set<ZSetOperations.TypedTuple<String>> clickTop10 = redisService.getProductionClickTop10();
        clickTop10.forEach(x -> {
            String proId = x.getValue();
            double clickCount = x.getScore();
            HotProduction hotProduction = new HotProduction();
            hotProduction.setClickCount((int)clickCount);
            hotProduction.setProid(Long.parseLong(proId));
            hotProduction.setCtime(date);
            hotProductionService.insert(hotProduction);
        });
        redisService.clearProductionClickZset();
    }

    /**
     *  处理用户当天生成的喜好列表。
     *  从数据库中获取用户之前的喜好列表（只允许保留20个），
     *  按照时间先后顺序，删除旧的喜好,插入新的喜好
     * @param set
     */
    private void dealLog(TreeSet<UserLikeKeyWord> set,long userId) {
        if(set.size() > USER_LIKE_WORD_MAX) {
            while(set.size() > USER_LIKE_WORD_MAX) {
                set.pollLast();
            }
            userLikeKeyWordService.deleteListByUserId(userId);
            userLikeKeyWordService.insertAll(set);
            return;
        }
        List<UserLikeKeyWord> keyWords = userLikeKeyWordService.getListByUserId(userId);
        if(CollectionUtils.isEmpty(keyWords)) {
            //生成的关键字 大于 20
            while(set.size() > USER_LIKE_WORD_MAX) {
                set.pollLast();
            }
            userLikeKeyWordService.insertAll(set);
            return ;
        }else {
            // 越新的，排越前面
            Collections.sort(keyWords,(o1,o2) -> {
                return o1.getCTime().getTime() >= o2.getCTime().getTime() ? 1 : -1;
            });
            int index = 0;
            do {
                set.add(keyWords.get(index++));
            }while(set.size() <= USER_LIKE_WORD_MAX);
            userLikeKeyWordService.deleteListByUserId(userId);
            userLikeKeyWordService.insertAll(set);
            return ;
        }
    }
}
