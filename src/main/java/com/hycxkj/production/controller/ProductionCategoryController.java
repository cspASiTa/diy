package com.hycxkj.production.controller;

import com.hycxkj.common.base.BaseController;
import com.hycxkj.common.base.BaseResult;
import com.hycxkj.common.base.HttpStatus;
import com.hycxkj.production.bean.ProductionCategory;
import com.hycxkj.production.service.ProductionCategoryService;
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
* @create in 2018/03/29 09:47
*/
@Slf4j
@RestController
@Api(value="目录controller",tags= "目录接口")
@RequestMapping("/api")
public class ProductionCategoryController extends BaseController {

    @Autowired
    private ProductionCategoryService productionCategoryService;

    @ApiOperation("获取目录")
    @GetMapping("/production/categories")
    public Object getProductionCategory() {
        List<ProductionCategory> category = productionCategoryService.getCategory();
        BaseResult result = new BaseResult();
        result.setData(category);
        result.setCode(HttpStatus.OK.getCode());
        return result;
    }

}