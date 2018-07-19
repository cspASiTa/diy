package com.hycxkj.user.controller;

import com.hycxkj.common.base.BaseController;
import com.hycxkj.user.bean.User;
import com.hycxkj.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:13 CST 2018
*/
@Slf4j
@Api(tags="用户接口")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    private static final String  defaultAvatar = "http://p6cnojz4k.bkt.clouddn.com/avatar/Personal_portrait@2x.png.png";
    private static final String  defaultUserName = "起个名字好难咯";

    @ApiOperation("获取用户的头像和用户昵称。用户如果未注册，userId不用传，后台会返回默认的头像和用户昵称")
    @GetMapping("/user/avatar/usernick")
    public Object getUserAvatarAndUserName(@ApiParam(value="用户ID", required = false) @RequestParam(required = false) Long userId) {
        HashMap<String, String> map = new HashMap<>();
        if(Objects.isNull(userId)) {
            map.put("avatar",defaultAvatar);
            map.put("userName",defaultUserName);
            return putSuccess(map);
        }
        User user = userService.getUserById(userId);
        map.put("avatar",user.getAvatar().length() == 0? defaultAvatar : user.getAvatar());
        map.put("userName",user.getUserNick().length() == 0? defaultUserName : user.getUserNick());
        return putSuccess(map);
    }

}