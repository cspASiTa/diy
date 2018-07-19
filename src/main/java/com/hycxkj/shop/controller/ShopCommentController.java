package com.hycxkj.shop.controller;

import com.github.pagehelper.PageInfo;
import com.hycxkj.common.base.BaseController;
import com.hycxkj.common.base.BaseResult;
import com.hycxkj.common.base.HttpStatus;
import com.hycxkj.shop.bean.ShopComment;
import com.hycxkj.shop.service.ShopCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* @author 陈少平
* @description
* @create in 2018/04/02 05:42
*/
@Slf4j
@Api(tags= "商品评论接口")
@RestController
@RequestMapping("/api")
public class ShopCommentController extends BaseController{

    @Autowired
    private ShopCommentService shopCommentService;

    @ApiOperation("分页获取商品的评论信息")
    @GetMapping("/item/comments/{itemId}")
    public Object getShopItemComments(@ApiParam(value="商品ID",required = true) @PathVariable Long itemId, @ApiParam(value="第几页，默认1",required = true) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认10",required = true) @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<ShopComment> pageInfo = shopCommentService.getShopItemComments(itemId, pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setData(pageInfo.getList());
        result.setCode(HttpStatus.OK.getCode());
        return result;
    }
}