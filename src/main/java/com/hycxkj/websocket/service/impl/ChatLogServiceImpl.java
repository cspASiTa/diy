package com.hycxkj.websocket.service.impl;

import com.hycxkj.websocket.bean.ChatLog;
import com.hycxkj.websocket.mapper.ChatLogMapper;
import com.hycxkj.websocket.service.ChatLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/7 20:53
 */
@Service
public class ChatLogServiceImpl implements ChatLogService {

    @Autowired
    private ChatLogMapper chatLogMapper;

    @Transactional
    @Override
    public int recordChatLog(ChatLog chatLog){
        chatLog.setSendtime(new Date());
        return chatLogMapper.insertSelective(chatLog);
    }
}
