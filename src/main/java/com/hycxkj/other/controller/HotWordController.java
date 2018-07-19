package com.hycxkj.other.controller;

import com.hycxkj.common.base.BaseController;
import com.hycxkj.common.base.BaseResult;
import com.hycxkj.common.base.HttpStatus;
import com.hycxkj.other.bean.HotWord;
import com.hycxkj.other.service.HotWordService;
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
@Api(tags= "输入框的关键词接口")
@RestController
@RequestMapping("/api")
public class HotWordController extends BaseController{

    @Autowired
    private HotWordService hotWordService;

    @ApiOperation("获取首页的搜索栏的关键字")
    @GetMapping("/hot-word/home")
    public Object getHomeHotWord() {
        List<HotWord> hotWords = hotWordService.getHotWordToFont((byte) 0);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(hotWords);
        return result;
    }

    @ApiOperation("获取店铺的搜索栏的关键字")
    @GetMapping("/hot-word/store")
    public Object getStoreHotWord() {
        List<HotWord> hotWords = hotWordService.getHotWordToFont((byte) 1);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(hotWords);
        return result;
    }

}