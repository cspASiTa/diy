package com.hycxkj.shop;

import com.hycxkj.JavaTest;
import com.hycxkj.shop.bean.ShopItem;
import com.hycxkj.shop.bean.ShopItemExample;
import com.hycxkj.shop.mapper.ShopItemMapper;
import com.hycxkj.shop.service.ShopItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/2 14:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopItemTest {
//
    @Autowired
    private ShopItemService shopItemService;
    @Autowired
    private ShopItemMapper shopItemMapper;
    private static String [] pics = {"http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.1.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.2.jpg",
            "http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.3.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.4.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re1.5.jpg",
            "http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.1.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.2.jpg",
            "http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.3.jpg","http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.4.jpg",
            "http://p6cnojz4k.bkt.clouddn.com/store/store_pic_Re2.5.jpg"};
    @Test
    public void insertTest() {
        Random random = new Random(56);
        String sallPoint = "快来买哦，便宜又实惠。啦啦啦啦啦。巴拉巴拉。";
        String desc = "泥猴哈，我是渣渣辉。我为XXX代言。嘎嘎大家！！面客气，面客气。大家好，我是古天乐，跟我一起来砍兄弟！";
        String title = "大家好，我是陈小春";
        int length = JavaTest.unicoder.length;
        for(int i = 1; i <= 394; i++) {
            int i1 = random.nextInt(5) + 1;
            for(int i11 = 0;i11 < i1; i11++ ) {
                ShopItem item = new ShopItem();
                int categoryId = i % 12 <= 1 ? 2 : i % 12;
                item.setCategoryId(categoryId);
                item.setNum(9999);
                int price = Math.abs(random.nextInt(999999));
                price = price <= 1000 ? price * 100: price;
                item.setPrice((long)price);
                item.setTitle(title);
                int weight = Math.abs(random.nextInt(99999));
                item.setWeight((long)weight);
                item.setSallPoint(sallPoint);
                String pic = pics[(i - 1) % 10];
                System.out.println(pic);
                item.setImage(pic);
                item.setShopDesc(desc);
                item.setCreateTime(new Date());
                if(i % 34 == 0) {
                    item.setDiscountPrice((long)(price - 1000));
                }
                if(i % 10 ==0) {
                    item.setType((byte)1);
                }
                item.setShopBusiId((long)i);
                shopItemService.insertSelective(item);
            }
        }
    }

    @Test
    public void updateTest() {
        ShopItemExample example = new ShopItemExample();
        ShopItemExample.Criteria criteria = example.createCriteria();
        criteria.getAllCriteria();
        List<ShopItem> list = shopItemMapper.selectByExample(example);
        for (ShopItem shopItem : list) {
            Integer categoryId = shopItem.getCategoryId();
            if(categoryId > 11) {
                categoryId = categoryId % 12;
                shopItem.setCategoryId(categoryId);
                shopItemService.updateSelectiveById(shopItem,shopItem.getItemId());
            }
        }
    }
}
