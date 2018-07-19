package com.hycxkj.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.hycxkj.common.base.BaseController;
import com.hycxkj.common.base.HttpStatus;
import com.hycxkj.user.service.UserFansService;
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
@Api(tags = "用户粉丝接口")
@RestController
@RequestMapping("/api")
public class UserFansController extends BaseController {

    @Autowired
    private UserFansService userFansService;

    @ApiOperation("获取用户粉丝数量")
    @GetMapping("/fans/count/{beFocusId}")
    public Object getUserFansCount(@ApiParam("用户ID")@PathVariable Long beFocusId) {
        long count = userFansService.getFansCount(beFocusId);
        return putSuccess(count);
    }

    @ApiOperation("获取用户的关注数")
    @GetMapping("/fans/focus/count/{focusId}")
    public Object getUserFoucusCount(@ApiParam("用户ID") @PathVariable Long focusId) {
        long count = userFansService.getFocusCount(focusId);
        return putSuccess(count);
    }

    @ApiOperation("获取用户的关注数和用户的粉丝数")
    @GetMapping("/fans/and/focus/count/{userId}")
    public Object getUserFansCountAndUserFoucusCount(@ApiParam("用户ID") @RequestParam Long userId) {
        long fansCount = userFansService.getFansCount(userId);
        long focusCount = userFansService.getFocusCount(userId);
        JSONObject object = new JSONObject();
        object.put("code", HttpStatus.OK.getCode());
        object.put("fansCount",fansCount);
        object.put("focusCount",focusCount);
        return object;
    }
}