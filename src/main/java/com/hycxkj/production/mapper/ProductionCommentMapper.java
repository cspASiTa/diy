package com.hycxkj.production.mapper;

import com.hycxkj.production.bean.ProductionComment;
import com.hycxkj.production.bean.ProductionCommentExample;
import com.hycxkj.production.font.FontComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionCommentMapper {
    long countByExample(ProductionCommentExample example);

    int deleteByExample(ProductionCommentExample example);

    int insert(ProductionComment record);

    int insertSelective(ProductionComment record);

    List<ProductionComment> selectByExample(ProductionCommentExample example);

    int updateByExampleSelective(@Param("record") ProductionComment record, @Param("example") ProductionCommentExample example);

    int updateByExample(@Param("record") ProductionComment record, @Param("example") ProductionCommentExample example);

    List<FontComment> getProductionCommentsByPage2Font(Long produtionId);
}