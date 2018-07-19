package com.hycxkj.postage.mapper;

import com.hycxkj.postage.bean.PostageCarryMode;
import com.hycxkj.postage.bean.PostageCarryModeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostageCarryModeMapper {
    long countByExample(PostageCarryModeExample example);

    int deleteByExample(PostageCarryModeExample example);

    int insert(PostageCarryMode record);

    int insertSelective(PostageCarryMode record);

    List<PostageCarryMode> selectByExample(PostageCarryModeExample example);

    int updateByExampleSelective(@Param("record") PostageCarryMode record, @Param("example") PostageCarryModeExample example);

    int updateByExample(@Param("record") PostageCarryMode record, @Param("example") PostageCarryModeExample example);
}