package com.hycxkj.shop;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/1 21:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopBusinessTest {
//
//    @Autowired
//    private ShopBusinessService shopBusinessService;
//    private static String [] pics = {"http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.1.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.2.jpg",
//    "http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.3.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.4.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.5.jpg",
//    "http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.1.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.2.jpg",
//    "http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.3.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.4.jpg",
//    "http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.5.jpg"};
//
//    @Test
//    public void insertTest() {
//        Random random = new Random();
//        int length = JavaTest.unicoder.length;
//        for(long i = 7; i <= 400; i++) {
//            ShopBusiness business = new ShopBusiness();
//            business.setuId(i);
//            business.setPayWx("18250073990");
//            business.setPayZfb("18250073990");
//            business.setIdentifyBack("http://p6cnojz4k.bkt.clouddn.com/idetify/timg.jpg");
//            business.setIdentifyFont("http://p6cnojz4k.bkt.clouddn.com/idetify/timg.jpg");
//            business.setCreateTime(new Date());
//            String pic = pics[(int) ((i - 1) % 10)];
//            business.setImage(pic);
//            int nextInt = random.nextInt(10);
//            nextInt = nextInt == 0 ? 1: nextInt;
//            StringBuilder sb = new StringBuilder();
//            for(int j = 0; j < nextInt; j++) {
//                sb.append((char)JavaTest.unicoder[random.nextInt(length)]);
//            }
//            business.setShopName(sb.toString());
//            shopBusinessService.insertSelective(business);
//        }
//    }

}
