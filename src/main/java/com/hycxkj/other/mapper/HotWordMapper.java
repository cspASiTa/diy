package com.hycxkj.other.mapper;

import com.hycxkj.other.bean.HotWord;
import com.hycxkj.other.bean.HotWordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotWordMapper {
    long countByExample(HotWordExample example);

    int deleteByExample(HotWordExample example);

    int insert(HotWord record);

    int insertSelective(HotWord record);

    List<HotWord> selectByExample(HotWordExample example);

    int updateByExampleSelective(@Param("record") HotWord record, @Param("example") HotWordExample example);

    int updateByExample(@Param("record") HotWord record, @Param("example") HotWordExample example);

    /**
     * 获取关键字给前端
     * @param type
     * @return
     */
    List<HotWord> getHotWordToFont(byte type);
}