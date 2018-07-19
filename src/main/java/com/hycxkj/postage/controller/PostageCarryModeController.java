package com.hycxkj.postage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.hycxkj.postage.service.PostageCarryModeService;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import com.hycxkj.common.base.BaseController;
/**
* @author 陈少平
* @description
* @create in 2018/05/06 08:28
*/
@Slf4j
@Api(tags= "接口")
@RestController
@RequestMapping("/api")
public class PostageCarryModeController extends BaseController{

    @Autowired
    private PostageCarryModeService postageCarryModeService;

}