package com.hycxkj.other;

import com.hycxkj.other.bean.Banner;
import com.hycxkj.other.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/3 19:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BannerTest {

    @Resource(name = "bannerServiceImpl")
    private BannerService bannerService;

    @Test
    public void testInsertBanner() {
        for(int i = 0; i < 5; i++) {
            Banner banner = new Banner();
            banner.setAlt("嘿嘿。我未显示");
            if(i % 2 ==0 ) {
                banner.setImage("http://p6cnojz4k.bkt.clouddn.com/banner/store_advertising.jpg");
            }else {
                banner.setImage("http://p6cnojz4k.bkt.clouddn.com/banner/store_advertising2.jpg");
            }
            banner.setCreateTime(new Date());
            banner.setLink("https://www.baidu.com");
            bannerService.insertSelective(banner);
        }
    }
}
