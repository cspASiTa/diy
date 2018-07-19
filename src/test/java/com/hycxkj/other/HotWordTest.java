package com.hycxkj.other;

import com.hycxkj.other.bean.HotWord;
import com.hycxkj.other.service.HotWordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/3 20:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HotWordTest {

    @Autowired
    private HotWordService hotWordService;

    private static String [] searchWords = {"渣渣辉","贪玩蓝月","古天乐","陈小春","不知妻美刘强东","普通家庭马化腾","悔创阿里杰克马","人生失败周炜鸿",
    "童子鸡","童子鸭","童子鹅","童子虾","童子系列","托儿索","儿童劫","我帅胡","仙剑一","仙剑二","仙剑三","陈少平"};

    @Test
    public void getHomeHotWord() {
        for(int i = 0; i < 20; i++) {
            HotWord hotWord = new HotWord();
            hotWord.setCreateTime(new Date());
            hotWord.setSearchWord(searchWords[i]);
            if(i >= 10) {
                hotWord.setType((byte)1);
            }else {
                hotWord.setType((byte)0);
            }
            hotWordService.insertSelective(hotWord);
        }
    }
}
