package com.hycxkj.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hycxkj.common.base.BaseController;
import com.hycxkj.common.base.BaseResult;
import com.hycxkj.common.base.HttpStatus;
import com.hycxkj.shop.bean.ShopComment;
import com.hycxkj.shop.bean.ShopItem;
import com.hycxkj.shop.font.FontSimpleShopItem;
import com.hycxkj.shop.service.ShopCommentService;
import com.hycxkj.shop.service.ShopItemService;
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
@Api(tags= "商品接口")
@RestController
@RequestMapping("/api")
public class ShopItemController extends BaseController{

    @Autowired
    private ShopItemService shopItemService;

    @Autowired
    private ShopCommentService shopCommentService;

    @ApiOperation("获取成品下的单品推荐的商品的简单信息")
    @GetMapping("/item/finish/single/simple")
    public Object getFinishSingleRecommend(@ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<FontSimpleShopItem> pageInfo = shopItemService.getSingleItemRecommend((byte) 0, pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(pageInfo.getList());
        return result;
    }

    @ApiOperation("获取成品下的每日上新的商品的简单信息")
    @GetMapping("/item/finish/fresh/simple")
    public Object getFinishFreshRecommend(@ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<FontSimpleShopItem> pageInfo = shopItemService.getFreshRecommend((byte) 0, pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(pageInfo.getList());
        return result;
    }

    @ApiOperation("获取自制下的单品推荐的商品的简单信息")
    @GetMapping("/item/self/single/simple")
    public Object getSelfMadeFinishSingleRecommend(@ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<FontSimpleShopItem> pageInfo = shopItemService.getSingleItemRecommend((byte) 1, pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(pageInfo.getList());
        return result;
    }

    @ApiOperation("获取成品下的每日上新的商品的简单信息")
    @GetMapping("/item/self/fresh/simple")
    public Object getSelfMadeFinishFreshRecommend(@ApiParam(value="第几页，默认1",required = false) @RequestParam(defaultValue = "1") Integer pageNum, @ApiParam(value ="每页几条数据，默认5",required = false) @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<FontSimpleShopItem> pageInfo = shopItemService.getFreshRecommend((byte) 1, pageNum, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        result.setData(pageInfo.getList());
        return result;
    }

    @ApiOperation("获取商品的详细信息和商品前10条评论信息")
    @GetMapping("/item/details/{itemId}")
    public Object getItemDetails(@ApiParam(value="商品ID",required = true) @PathVariable Long itemId,@ApiParam(value="评论的条数，默认10条",required = false) @RequestParam(defaultValue = "10") Integer pageSize) {
        ShopItem shopItem = shopItemService.getById(itemId);
        PageInfo<ShopComment> comments = shopCommentService.getShopItemComments(itemId, 1, pageSize);
        BaseResult result = new BaseResult();
        result.setCode(HttpStatus.OK.getCode());
        JSONObject object = new JSONObject();
        object.put("item",shopItem);
        object.put("comments",comments.getList());
        result.setData(object);
        System.out.println(shopItem);
        System.out.println(result);
        return result;
    }
}