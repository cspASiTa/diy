package com.hycxkj.postage.controller;

import com.hycxkj.common.base.BaseController;
import com.hycxkj.postage.service.PostagePackageConditionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* @author 陈少平
* @description
* @create in 2018/05/06 06:48
*/
@Slf4j
@Api(tags= "接口")
@RestController
@RequestMapping("/api")
public class PostagePackageConditionController extends BaseController{

    @Autowired
    private PostagePackageConditionService postagePackageConditionService;

}