package com.hycxkj.websocket.service;

import com.hycxkj.websocket.bean.ChatLog;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/7 20:53
 */
public interface ChatLogService {
    /**
     * 记录消息
     * @param chatLog
     * @return
     */
    int recordChatLog(ChatLog chatLog);
}
