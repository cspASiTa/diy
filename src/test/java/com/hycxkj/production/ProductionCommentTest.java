package com.hycxkj.production;

import com.hycxkj.JavaTest;
import com.hycxkj.production.bean.ProductionComment;
import com.hycxkj.production.service.ProductionCommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/31 17:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductionCommentTest {

    @Autowired
    private ProductionCommentService service;

    @Test
    public void test() {
        Random random = new Random(56);
        int length = JavaTest.unicoder.length;
        for(long i = 6; i <= 992; i++) {
            // 是否有评论
            if(i %36 !=0) {
                int nextInt = random.nextInt(40);
                //添加几条评论
                for(int j = 0; j < nextInt; j++ ) {
                    ProductionComment comment = new ProductionComment();
                    comment.setProductionId(i);
                    comment.setCreateTime(new Date(System.currentTimeMillis() + Math.abs(random.nextInt(10000))));
                    comment.setUserId(i);
                    int contentLength = random.nextInt(101);
                    StringBuilder sb  = new StringBuilder();
                    for(int k = 0; k < contentLength; k++) {
                        sb.append((char)JavaTest.unicoder[random.nextInt(length)]);
                    }
                    comment.setContent(sb.toString());
                    service.insertSelective(comment);
                }
            }else {

            }
        }
    }
}
