package com.hycxkj.production.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.production.bean.ProductionCategory;
import com.hycxkj.production.bean.ProductionCategoryExample;
import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/03/29 09:47
*/
public interface ProductionCategoryService {

    int insert(ProductionCategory model);

    /**
     * 只插入部分
     */
    int insertSelective(ProductionCategory model);

    PageInfo<ProductionCategory> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<ProductionCategory> getPagesByExample(Integer pageNum, Integer pageSize, ProductionCategoryExample example);

    int deleteById(Integer id);

    int deleteByExample(ProductionCategoryExample example);

    int updateSelectiveById(ProductionCategory model,Integer id);

    int updateSelectiveByExample(ProductionCategory model, ProductionCategoryExample example);
    List<ProductionCategory> getCategory();
}