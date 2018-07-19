package com.hycxkj.production.mapper;

import com.hycxkj.production.bean.Production;
import com.hycxkj.production.bean.ProductionExample;
import com.hycxkj.production.font.FontSimpleProduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionMapper {
    long countByExample(ProductionExample example);

    int deleteByExample(ProductionExample example);

    int insert(Production record);

    int insertSelective(Production record);

    List<Production> selectByExampleWithBLOBs(ProductionExample example);

    List<Production> selectByExample(ProductionExample example);

    int updateByExampleSelective(@Param("record") Production record, @Param("example") ProductionExample example);

    int updateByExampleWithBLOBs(@Param("record") Production record, @Param("example") ProductionExample example);

    int updateByExample(@Param("record") Production record, @Param("example") ProductionExample example);

    List<FontSimpleProduction> getProductionSimpleInfo();

    /**
     *  通过分类ID 获取作品的简单信息
     * @param categoryId
     * @return
     */
    List<FontSimpleProduction> getProductionSimpleInfoByCateogryId(Integer categoryId);

    /**
     *  通过用户ID获取用户的收藏作品
     * @param userId
     * @return
     */
    List<FontSimpleProduction> getProductionSimpleInfoByUserId(Long userId);

    /**
     *  获取用户喜欢的作品
     * @param categoryId
     * @param keyword  用户喜欢的关键词
     * @return
     */
    List<FontSimpleProduction> getUserLikeProductions(@Param("categoryId") int categoryId, @Param("keyword") String keyword);

    List<FontSimpleProduction> getUserLikeProductionsByCategory(int categoryId);

    /**
     *  获取单个作品
     * @param proId 作品ID
     * @return
     */
    FontSimpleProduction getSimpleProductionByProId(long proId);
}