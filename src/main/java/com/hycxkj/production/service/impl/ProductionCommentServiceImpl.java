package com.hycxkj.production.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.production.bean.ProductionComment;
import com.hycxkj.production.bean.ProductionCommentExample;
import com.hycxkj.production.font.FontComment;
import com.hycxkj.production.mapper.ProductionCommentMapper;
import com.hycxkj.production.service.ProductionCommentService;
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
public class ProductionCommentServiceImpl implements ProductionCommentService {

    @Autowired
    private ProductionCommentMapper productionCommentMapper;

    @Override
    @Transactional
    public int insert(ProductionComment model) {
        return productionCommentMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(ProductionComment model){
        return productionCommentMapper.insertSelective(model);
    }

    @Override
    public PageInfo<ProductionComment> getByPage(Integer pageNum, Integer pageSize) {
        ProductionCommentExample productionCommentExample = new ProductionCommentExample();
        ProductionCommentExample.Criteria criteria = productionCommentExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, productionCommentExample);
    }

    @Override
    public PageInfo<ProductionComment> getPagesByExample(Integer pageNum, Integer pageSize, ProductionCommentExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<ProductionComment> list = productionCommentMapper.selectByExample(example);
        PageInfo<ProductionComment> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteById(Long id) {
        ProductionCommentExample productionCommentExample = new ProductionCommentExample();
        ProductionCommentExample.Criteria criteria = productionCommentExample.createCriteria();
        criteria.andCommentIdEqualTo(id);
        return deleteByExample(productionCommentExample);
    }

    @Override
    @Transactional
    public int deleteByExample(ProductionCommentExample example) {
        return productionCommentMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(ProductionComment model,Long id) {
        ProductionCommentExample productionCommentExample = new ProductionCommentExample();
        ProductionCommentExample.Criteria criteria = productionCommentExample.createCriteria();
        criteria.andCommentIdEqualTo(id);
        return updateSelectiveByExample(model,productionCommentExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(ProductionComment model, ProductionCommentExample example){
        return productionCommentMapper.updateByExampleSelective(model,example);
    }

    @Override
    public PageInfo<FontComment> getProductionCommentsByPage2Font(Integer pageNum, Integer pageSize, Long produtionId) {
        PageHelper.startPage(pageNum,pageSize);
        List<FontComment> list = productionCommentMapper.getProductionCommentsByPage2Font(produtionId);
        PageInfo<FontComment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}