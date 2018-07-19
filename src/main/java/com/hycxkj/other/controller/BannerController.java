package com.hycxkj.other.controller;

import com.hycxkj.common.base.BaseController;
import com.hycxkj.common.base.BaseResult;
import com.hycxkj.common.base.HttpStatus;
import com.hycxkj.other.bean.Banner;
import com.hycxkj.other.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/04/03 04:39
*/
@Slf4j
@Api(tags= "商家页的轮播图接口")
@RestController
@RequestMapping("/api")
public class BannerController extends BaseController{

    @Autowired
    private BannerService bannerService;

    @ApiOperation("获取商家页面的banners")
    @GetMapping("/banners")
    public Object getBanners() {
        List<Banner> banners = bannerService.getBanners();
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(banners);
        return result;
    }
}