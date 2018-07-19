package com.hycxkj.shop.controller;

import com.github.pagehelper.PageInfo;
import com.hycxkj.common.base.BaseController;
import com.hycxkj.common.base.BaseResult;
import com.hycxkj.common.base.HttpStatus;
import com.hycxkj.shop.font.FontSimpleBusiness;
import com.hycxkj.shop.service.ShopBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
* @author 陈少平
* @description
* @create in 2018/04/02 05:42
*/
@Slf4j
@Api(tags= "店铺接口")
@RestController
@RequestMapping("/api")
public class ShopBusinessController extends BaseController{

    @Autowired
    private ShopBusinessService shopBusinessService;

    @ApiOperation("获取成品下成品店铺，默认返回前5条数据。")
    @GetMapping("/store/finish/finish/simple")
    public Object getFinishStoreSimpleInfo(@ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<FontSimpleBusiness> pageInfo = shopBusinessService.getFinishStoreSimpleInfo(pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(pageInfo.getList());
        return result;
    }

    @ApiOperation("获取成品下精选店铺，默认返回前5条数据。")
    @GetMapping("/store/finish/special/simple")
    public Object getFinishSpecialStoreSimpleInfo(@ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<FontSimpleBusiness> pageInfo = shopBusinessService.getFinishSpecialStoreSimpleInfo(pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(pageInfo.getList());
        return pageInfo;
    }

    @ApiOperation("获取自制下成品店铺，默认返回前5条数据。")
    @GetMapping("/store/self/finish/simple")
    public Object getSelfMadeFinishStoreSimpleInfo(@ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<FontSimpleBusiness> pageInfo = shopBusinessService.getSelfMadeFinishStoreSimpleInfo(pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(pageInfo.getList());
        return result;
    }

    @ApiOperation("获取自制下精选店铺，默认返回前5条数据。")
    @GetMapping("/store/self/special/simple")
    public Object getSelfMadeFinishSpecialStoreSimpleInfo(@ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<FontSimpleBusiness> pageInfo = shopBusinessService.getSelfMadeFinishSpecialStoreSimpleInfo(pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(pageInfo.getList());
        return pageInfo;
    }


}