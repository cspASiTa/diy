package com.hycxkj.recommend.mapper;

import com.hycxkj.recommend.bean.HotProduction;
import com.hycxkj.recommend.bean.HotProductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotProductionMapper {
    long countByExample(HotProductionExample example);

    int deleteByExample(HotProductionExample example);

    int insert(HotProduction record);

    int insertSelective(HotProduction record);

    List<HotProduction> selectByExample(HotProductionExample example);

    int updateByExampleSelective(@Param("record") HotProduction record, @Param("example") HotProductionExample example);

    int updateByExample(@Param("record") HotProduction record, @Param("example") HotProductionExample example);
}