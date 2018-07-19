package com.hycxkj.websocket.mapper;

import com.hycxkj.websocket.bean.ChatLog;
import com.hycxkj.websocket.bean.ChatLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatLogMapper {
    long countByExample(ChatLogExample example);

    int deleteByExample(ChatLogExample example);

    int insert(ChatLog record);

    int insertSelective(ChatLog record);

    List<ChatLog> selectByExample(ChatLogExample example);

    int updateByExampleSelective(@Param("record") ChatLog record, @Param("example") ChatLogExample example);

    int updateByExample(@Param("record") ChatLog record, @Param("example") ChatLogExample example);
}