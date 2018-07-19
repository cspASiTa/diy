package com.hycxkj.postage;

import com.hycxkj.postage.bean.PostageCarryMode;
import com.hycxkj.postage.bean.PostagePackageCondition;
import com.hycxkj.postage.bean.PostageTemplate;
import com.hycxkj.postage.service.PostageCarryModeService;
import com.hycxkj.postage.service.PostagePackageConditionService;
import com.hycxkj.postage.service.PostageTemplateService;
import com.hycxkj.shop.bean.ShopBusiItem;
import com.hycxkj.shop.service.ShopBusiItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/6 19:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostageTemplateTest {
    @Autowired
    private PostageTemplateService postageTemplateService;

    @Autowired
    private PostagePackageConditionService postagePackageConditionService;

    @Autowired
    private ShopBusiItemService shopBusiItemService;

    @Autowired
    private PostageCarryModeService postageCarryModeService;
    @Test
    public void testInsert() {
        for(long i = 1; i <= 20; i++) {
            PostageTemplate template = new PostageTemplate();
            template.setBusiId(i);
            template.setAddr("福建省龙岩市东肖街道1号");
            template.setPackageMail(true);
            postageTemplateService.insert(template);
        }
        for(long i = 21; i <= 40; i++) {
            PostageTemplate template = new PostageTemplate();
            template.setBusiId(i);
            template.setAddr("福建省晋江市罗山街道XXX");
            template.setPackageMail(false);
            template.setIsPackageCondition(true);
            long insert = postageTemplateService.insert(template);
            PostagePackageCondition condition = new PostagePackageCondition();
            condition.setPostageTemplateId(insert);
            condition.setAmount(19999l);
            postagePackageConditionService.insertSelective(condition);
            PostageCarryMode carryMode = new PostageCarryMode();
            carryMode.setPostageTemplateId(insert);
            carryMode.setFirstAmount(1000l);
            carryMode.setFirstPiece(1);
            carryMode.setSecondPiece(1);
            carryMode.setSecondAmount(0l);
            postageCarryModeService.insertSelective(carryMode);
        }
    }

    @Test
    public void testInsert2() {
        for(long i = 41; i <= 337; i++) {
            PostageTemplate template = new PostageTemplate();
            template.setBusiId(i);
            template.setAddr("福建省龙岩市东肖街道1号");
            template.setPackageMail(true);
            postageTemplateService.insert(template);
        }
        for(long i = 116; i <= 1000; i++) {
            ShopBusiItem item = shopBusiItemService.getById(i);
            item.setPostageTemplateId(item.getShopBusiId());
            shopBusiItemService.updateSelectiveById(item, item.getShopBusiItemId());
        }
    }

    @Test
    public void calPostageTest() {
        long userAddr = 2l;
        Map<Long, Byte> carryAway = new HashMap<>();
        Map<Long,Map<Long, Integer>> map = new HashMap<>();
        Map<Long, Integer> tmp = new HashMap<>();
        tmp.put(59l,3);
        tmp.put(60l,1);
        tmp.put(61l,3);
        map.put(21l,tmp);
        Map<Long, Integer> tmp2 = new HashMap<>();
        tmp2.put(58l,1);
        map.put(20l, tmp2);
        carryAway.put(59l,new Byte((byte)0));
        carryAway.put(60l,new Byte((byte)0));
        carryAway.put(61l,new Byte((byte)0));
        carryAway.put(58l,new Byte((byte)0));
        byte carry = 0;
        Map<Long, Long> postage = postageTemplateService.calPostage(userAddr, map, carryAway);
        for (Long aLong : postage.keySet()) {
            System.out.println(aLong);
            System.out.println(postage.get(aLong));
        }
    }
}
