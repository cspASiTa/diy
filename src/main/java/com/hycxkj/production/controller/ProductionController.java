package com.hycxkj.production.controller;

import com.github.pagehelper.PageInfo;
import com.hycxkj.common.base.BaseController;
import com.hycxkj.production.annotation.UserLikeRecord;
import com.hycxkj.production.bean.Production;
import com.hycxkj.production.font.FontSimpleProduction;
import com.hycxkj.production.service.ProductionService;
import com.hycxkj.recommend.redis.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author 陈少平
* @description
* @create in 2018/03/29 09:47
*/
@Slf4j
@RestController
@Api(value="作品controller",tags = {"作品操作接口"})
@RequestMapping("/api")
public class ProductionController extends BaseController {

    @Autowired
    private ProductionService productionService;

    @Autowired
    private RedisService redisService;

    @ApiOperation("获取用户自身的作品")
    @GetMapping("/productions/{userId}")
    public Object getUserProductionToFont(@ApiParam(value="用户ID")@PathVariable Long userId, @ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<FontSimpleProduction> pageInfo = productionService.getProductionSimpleInfoByUserId(userId, pageNum, pageSize);
        return putPage(pageInfo);
    }

    @ApiOperation("获取作品的简单信息(推荐页面使用)。")
    @GetMapping("/productons/simple")
    public Object getSimpleProductionToFont(@RequestParam @ApiParam("指的是从第几页开始请求，必填") Integer pageNum,@ApiParam("一次请求多少条数据，默认10") @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<FontSimpleProduction> pageInfo = productionService.getSimpleProdutionToFont(pageNum, pageSize);
        return putPage(pageInfo);
    }

    @UserLikeRecord
    @ApiOperation("插入作品。所有的表单提交content-type均为form-data  以下字段必填 uId, categoryId, title, image, description, material, content")
    @PostMapping("/production")
    public Object insertProduction(@ModelAttribute Production production) {
        production.setUploadTime(new Date());
        productionService.insertSelective(production);
        return putSuccess();
    }

    @UserLikeRecord
    @ApiOperation("将作品的阅读数+1, 请提交 proId ,readnumber,title, categoryId, userId(当前用户,若没，则不用) 3个字段")
    @PutMapping("/production/readnumber/increase")
    public Object addReadnumber(@ModelAttribute FontSimpleProduction fontProduction) {
        Production production = new Production();
        production.setReadnumber(fontProduction.getReadnumber());
        production.setProId(fontProduction.getProId());
        productionService.addReadnumber(production);
        return putSuccess();
    }

    @UserLikeRecord
    @ApiOperation("将作品的点赞数+1，只需提交 likeCount , proId,title, categoryId  userId(当前用户,若没，则不用) 3个字段即可")
    @PutMapping("/production/like-count/increase")
    public Object addLikeCount(@ModelAttribute FontSimpleProduction fontProduction) {
        Production production = new Production();
        production.setLikeCount(fontProduction.getLikeCount());
        production.setProId(fontProduction.getProId());
        productionService.addLikeCount(production);
        return putSuccess();
    }

    @ApiOperation("将作品的点赞数-1，只需提交 likeCount , proId,title,categoryId, userId(当前用户,若没，则不用) 3个字段即可")
    @PutMapping("/production/like-count/decrease")
    public Object decreaseLikeCount(@ModelAttribute FontSimpleProduction fontProduction) {
        Production production = new Production();
        production.setLikeCount(fontProduction.getLikeCount());
        production.setProId(fontProduction.getProId());
        productionService.decreaseLikeCount(production);
        return putSuccess();
    }

    @ApiOperation("分页获取每个分类下作品的简单信息（推荐类目请调用/api/productions/simple)。{categoryId}必须被替换成具体的数值 " +
            "如果家具的类目ID 为3.那么调用的URL为 /productions/simple/3  pageNum, pageSize 请放在请求参数中。")
    @GetMapping("/productions/simple/{categoryId}")
    public Object getSimleProductionByCategory(@PathVariable Integer categoryId, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo<FontSimpleProduction> pageInfo = productionService.getProductionSimpleInfoByCateogryId(categoryId, pageNum, pageSize);
        return putPage(pageInfo);
    }

    @ApiOperation("返回用户喜欢的作品，用于猜你喜欢")
    @GetMapping("/productions/like/simple")
    public Object getUserLikeSimpleProduction(@RequestParam(required = false) Long userId, @ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认10",required = false) @RequestParam(defaultValue = "10") Integer pageSize) {
        // 用户没登录，按照点击数从高到低返回
        List<FontSimpleProduction> list = null;
        if(Objects.isNull(userId)) {
            list = productionService.getUserLikeSimpleProductionByRedis(pageNum, pageSize);
        }else {
            // 根据用户的喜好关键词获取用户喜欢的作品
            list = productionService.getUserLikeProduction(userId, pageNum, pageSize);
            // 如果不够
            if(CollectionUtils.isEmpty(list)) {
                list = productionService.getUserLikeSimpleProductionByRedis(pageNum, pageSize);
            }
        }
        return putSuccess(list);
    }

    @ApiOperation("获取作品的详细信息")
    @GetMapping("/production/detail/{pid}")
    public Object getProductionDetailInfo(@PathVariable Long pid) {
        Production production = productionService.getProduction(pid);
        return putSuccess(production);
    }
}