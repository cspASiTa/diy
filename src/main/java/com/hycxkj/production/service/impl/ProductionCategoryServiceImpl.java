package com.hycxkj.production.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.common.function.OperationFunction;
import com.hycxkj.production.bean.ProductionCategory;
import com.hycxkj.production.bean.ProductionCategoryExample;
import com.hycxkj.production.font.FontSimpleProduction;
import com.hycxkj.production.mapper.ProductionCategoryMapper;
import com.hycxkj.production.mapper.ProductionMapper;
import com.hycxkj.production.service.ProductionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author 陈少平
* @description
* @create in 2018/03/29 09:47
*/
@Service
public class ProductionCategoryServiceImpl implements ProductionCategoryService {

    @Autowired
    private ProductionCategoryMapper productionCategoryMapper;

    @Override
    @Transactional
    public int insert(ProductionCategory model) {
        return productionCategoryMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(ProductionCategory model){
        return productionCategoryMapper.insertSelective(model);
    }

    @Override
    public PageInfo<ProductionCategory> getByPage(Integer pageNum, Integer pageSize) {
        ProductionCategoryExample productionCategoryExample = new ProductionCategoryExample();
        ProductionCategoryExample.Criteria criteria = productionCategoryExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, productionCategoryExample);
    }

    @Override
    public PageInfo<ProductionCategory> getPagesByExample(Integer pageNum, Integer pageSize, ProductionCategoryExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<ProductionCategory> list = productionCategoryMapper.selectByExample(example);
        PageInfo<ProductionCategory> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Integer id) {
        ProductionCategoryExample productionCategoryExample = new ProductionCategoryExample();
        ProductionCategoryExample.Criteria criteria = productionCategoryExample.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        return deleteByExample(productionCategoryExample);
    }

    @Override
    @Transactional
    public int deleteByExample(ProductionCategoryExample example) {
        return productionCategoryMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(ProductionCategory model,Integer id) {
        ProductionCategoryExample productionCategoryExample = new ProductionCategoryExample();
        ProductionCategoryExample.Criteria criteria = productionCategoryExample.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        return updateSelectiveByExample(model,productionCategoryExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(ProductionCategory model, ProductionCategoryExample example){
        return productionCategoryMapper.updateByExampleSelective(model,example);
    }

    @Override
    public List<ProductionCategory> getCategory() {
        return productionCategoryMapper.getSimpleCategories();
    }

}