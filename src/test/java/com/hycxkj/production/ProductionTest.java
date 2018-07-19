package com.hycxkj.production;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.Main;
import com.hycxkj.common.function.OperationFunction;
import com.hycxkj.production.bean.Production;
import com.hycxkj.production.font.FontSimpleProduction;
import com.hycxkj.production.mapper.ProductionMapper;
import com.hycxkj.production.service.ProductionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/28 22:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class ProductionTest {

    @Autowired
    private ProductionMapper productionMapper;

    @Autowired
    private ProductionService productionService;

    @Test
    public void insert() {
        Random random = new Random(56);
        for(long i = 30; i< 1000; i++) {
            Production production = new Production();
            production.setuId(i);
            int category = Math.abs(random.nextInt(12));
            if(category == 1) {
                category = 1 + Math.abs(random.nextInt(11));
            }
            production.setLikeCount(Math.abs(random.nextInt(10000)));
            production.setReadnumber(Math.abs(random.nextInt(1000000)));
            production.setUploadTime(new Date());
            production.setCategoryId(category);
            production.setStatus((byte)1);
            if(i % 12 ==0) {
                production.setType((byte)1);
            }
            if(i %2 == 0) {
                production.setTitle("龙岩超级好吃的童子鸡");
                production.setDescription("这是我第一次做这个，请大家多多关照");
                production.setMaterial("[{\"狗屎\":\"1斤\"},{“童子尿”:\"3斤\"},{\"叫花鸡\",\"10只\"}]");
                production.setContent("[{\"media\":\"http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg\",\"desc\":\"现将童子鸡放到尿中泡一泡\"},{\"media\":\"http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg\",\"desc\":\"现将童子鸡放到尿中泡一泡\"},{\"media\":\"http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg\",\"desc\":\"现将童子鸡放到尿中泡一泡\"},{\"media\":\"http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg\",\"desc\":\"现将童子鸡放到尿中泡一泡\"}]]");
                production.setImage("http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg");
            }else {
                production.setTitle("玫瑰花精油洗脸洁面皂");
                production.setDescription("我是superMAN，我超级厉害");
                production.setMaterial("[{\"玫瑰花\":\"1斤\"},{“砂糖”:\"3斤\"},{\"桂花\",\"3斤\"}]");
                production.setContent("[{\"media\":\"http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg\",\"desc\":\"现将童子鸡放到尿中泡一泡\"},{\"media\":\"http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg\",\"desc\":\"现将童子鸡放到尿中泡一泡\"},{\"media\":\"http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg\",\"desc\":\"现将童子鸡放到尿中泡一泡\"},{\"media\":\"http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg\",\"desc\":\"现将童子鸡放到尿中泡一泡\"}]]");
                production.setImage("http://p6cnojz4k.bkt.clouddn.com/image/home_photo1.jpg.jpg");
            }
            productionMapper.insertSelective(production);
        }
    }

    @Test
    public void testMutilPage() {
        PageHelper.startPage(1,10);
        List<FontSimpleProduction> info = productionMapper.getProductionSimpleInfo();
        PageInfo<FontSimpleProduction> pageInfo = new PageInfo<>(info);
        List<FontSimpleProduction> list = pageInfo.getList();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(list.size());
        System.out.println(list);

        PageHelper.startPage(3,50);
        List<FontSimpleProduction> info1 = productionMapper.getProductionSimpleInfo();
        PageInfo<FontSimpleProduction> pageInfo1 = new PageInfo<>(info1);
        List<FontSimpleProduction> list1 = pageInfo1.getList();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(list1.size());
        System.out.println(list1);
    }

    @Test
    public void getUserLikeProductionsTest(){
        List<FontSimpleProduction> productions = productionMapper.getUserLikeProductions(14, "情人节");
        System.out.println(productions);
    }

    @Test
    public void getUserLikeProductionTest() {
        List<FontSimpleProduction> production = productionService.getUserLikeProduction(12l, 1, 10);
        System.out.println(production);
    }

    //自己写的 lambda 测试着玩玩。。。
//    @Test
//    public void lambadaTest(){
//        PageInfo<FontSimpleProduction> s = basePageHelper(1,10,() -> {
//          return productionMapper.getUserLikeProductionsByCategory(5);
//        });
//        List<FontSimpleProduction> list = s.getList();
//        for (FontSimpleProduction fontSimpleProduction : list) {
//            System.out.println(fontSimpleProduction);
//        }
//    }
//
//    public PageInfo<FontSimpleProduction> basePageHelper(int pageNum, int pageSize, OperationFunction<ProductionMapper,FontSimpleProduction> operator) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<FontSimpleProduction>  list = operator.apply();
//        return new PageInfo(list);
//    }

    @Test
    public void getUserLikeProductionTest2() {
        List<FontSimpleProduction> production = productionService.getUserLikeProduction(12l, 1, 10);
        for (FontSimpleProduction fontSimpleProduction : production) {
            System.out.println(fontSimpleProduction);
        }
    }
}
