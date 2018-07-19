package com.hycxkj.user;

import com.hycxkj.Main;
import com.hycxkj.user.bean.User;
import com.hycxkj.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/29 22:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    private static String [] arr = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    @Test
    public void insertTest() {
        for(int i = 32; i < 1000; i++) {
            User user = new User();
            user.setPassword("fd7543b6ad714cab37cd07d53327d4c1");
            user.setUserName("testtest000"+i);
            if(i % 2 == 0) {
                user.setAvatar("http://p6cnojz4k.bkt.clouddn.com/image/home_portrait2.png.png");
            }else {
                user.setAvatar("http://p6cnojz4k.bkt.clouddn.com/image/home_portrait1.png.png");
            }
            user.setUserSalt("testtest000"+i);
            user.setPhone("18250073990");
            user.setEmail("18250073990@163.com");
            user.setCreateTime(new Date());
            user.setLoginIp("0:0:0:0:0:0:0:1");
            user.setLastLoginTime(new Date());
            //生成多少个字
            String userNick= "";
            int temp  = (int) Math.ceil(Math.random() * 10);
            for(int j = 0; j < temp; j++) {
                //随机生成unicode
                String x = "\\u4";
                for(int k = 0; k < 3; k++) {
                     x  += arr[(int)(Math.random() * 16)];
                }
                //生成字
                String word = unicode2String(x);
                userNick += word;
            }
            user.setUserNick(userNick);
            userMapper.insertSelective(user);
        }
    }

    public  String unicode2String(String unicode){
        if(StringUtils.isBlank(unicode)) return null;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while((i=unicode.indexOf("\\u", pos)) != -1){
            sb.append(unicode.substring(pos, i));
            if(i+5 < unicode.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(unicode.substring(i+2, i+6), 16));
            }
        }
        return sb.toString();
    }
}
