package com.hycxkj.user;

import com.hycxkj.user.bean.UserCollection;
import com.hycxkj.user.service.UserCollectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/10 8:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCollectionTest {

    @Autowired
    private UserCollectionService userCollectionService;

    @Test
    public void insertTest() {
        for(long i = 4; i <= 500; i++) {
            for(long j = 1; j <= 200; j++) {
                UserCollection collection = new UserCollection();
                collection.setuId(j);
                collection.setType((byte)1);
                collection.setCreateTime(new Date());
                collection.setTypeId(i);
                userCollectionService.insert(collection);
            }
        }
    }
}
