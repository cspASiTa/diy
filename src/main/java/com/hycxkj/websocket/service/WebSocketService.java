package com.hycxkj.websocket.service;

import com.hycxkj.websocket.bean.ChatLog;
import com.hycxkj.websocket.bean.Push;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/7 21:01
 */
public interface WebSocketService {
    /**
     * 广播
     * 管理员，发给所有在线用户,并将发送的记录插入到数据库中
     *
     * @param msg
     */
    void sendAllMsg(Push msg);

    /**
     *  点对点推送
     */
    void send2User(ChatLog chatLog);
}
