package com.hycxkj.production.mapper;

import com.hycxkj.production.bean.ProductionCategory;
import com.hycxkj.production.bean.ProductionCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionCategoryMapper {
    long countByExample(ProductionCategoryExample example);

    int deleteByExample(ProductionCategoryExample example);

    int insert(ProductionCategory record);

    int insertSelective(ProductionCategory record);

    List<ProductionCategory> selectByExample(ProductionCategoryExample example);

    int updateByExampleSelective(@Param("record") ProductionCategory record, @Param("example") ProductionCategoryExample example);

    int updateByExample(@Param("record") ProductionCategory record, @Param("example") ProductionCategoryExample example);

    List<ProductionCategory> getSimpleCategories();
}