package com.hycxkj.user.controller;

import com.github.pagehelper.PageInfo;
import com.hycxkj.common.base.BaseController;
import com.hycxkj.production.font.FontSimpleProduction;
import com.hycxkj.user.service.UserCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:12 CST 2018
*/
@Api(tags="用户收藏接口")
@RestController
@RequestMapping("/api")
public class UserCollectionController extends BaseController {

    @Autowired
    private UserCollectionService userCollectionService;

    @ApiOperation("获取指定用户的收藏作品")
    @GetMapping("/collections/{userId}")
    public Object getpRroductionCollections(@ApiParam(value="用户ID")@PathVariable Long userId, @ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<FontSimpleProduction> pageInfo = userCollectionService.selectCollectionProductionInfo(userId, pageNum, pageSize);
        return putPage(pageInfo);
    }

}