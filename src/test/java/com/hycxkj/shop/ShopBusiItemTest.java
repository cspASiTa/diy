package com.hycxkj.shop;

import com.hycxkj.shop.bean.ShopBusiItem;
import com.hycxkj.shop.mapper.ShopItemMapper;
import com.hycxkj.shop.service.ShopBusiItemService;
import com.hycxkj.shop.service.ShopItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/2 15:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopBusiItemTest {

    @Autowired
    private ShopBusiItemService shopBusiItemService;

    @Autowired
    private ShopItemMapper shopItemMapper;

    @Test
    public void insertTest() {
        List<ShopBusiItem> list = shopItemMapper.testUse();
        for (ShopBusiItem shopBusiItem : list) {
            shopBusiItemService.insert(shopBusiItem);
        }
    }
}
