package com.hycxkj.websocket.mapper;

import com.hycxkj.websocket.bean.Push;
import com.hycxkj.websocket.bean.PushExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PushMapper {
    long countByExample(PushExample example);

    int deleteByExample(PushExample example);

    int insert(Push record);

    int insertSelective(Push record);

    List<Push> selectByExample(PushExample example);

    int updateByExampleSelective(@Param("record") Push record, @Param("example") PushExample example);

    int updateByExample(@Param("record") Push record, @Param("example") PushExample example);
}