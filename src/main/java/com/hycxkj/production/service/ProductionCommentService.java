package com.hycxkj.production.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.production.bean.ProductionComment;
import com.hycxkj.production.bean.ProductionCommentExample;
import com.hycxkj.production.font.FontComment;

/**
* @author 陈少平
* @description
* @create in 2018/03/29 09:47
*/
public interface ProductionCommentService {

    int insert(ProductionComment model);

    /**
     * 只插入部分
     */
    int insertSelective(ProductionComment model);

    PageInfo<ProductionComment> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<ProductionComment> getPagesByExample(Integer pageNum, Integer pageSize, ProductionCommentExample example);

    int deleteById(Long id);

    int deleteByExample(ProductionCommentExample example);

    int updateSelectiveById(ProductionComment model,Long id);

    int updateSelectiveByExample(ProductionComment model, ProductionCommentExample example);

    PageInfo<FontComment> getProductionCommentsByPage2Font(Integer pageNum, Integer pageSize, Long produtionId);
}