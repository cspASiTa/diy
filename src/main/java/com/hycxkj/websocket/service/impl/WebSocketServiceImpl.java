package com.hycxkj.websocket.service.impl;

import com.hycxkj.websocket.bean.ChatLog;
import com.hycxkj.websocket.bean.Push;
import com.hycxkj.websocket.constant.Constant;
import com.hycxkj.websocket.service.ChatLogService;
import com.hycxkj.websocket.service.PushService;
import com.hycxkj.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/7 21:01
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private ChatLogService chatLogService;

    @Autowired
    private PushService pushService;

    @Override
    public void sendAllMsg(Push msg) {
        template.convertAndSend(Constant.PRODUCER_PATH,msg.getContent());
        pushService.insert(msg);
    }

    @Override
    public void send2User(ChatLog chatLog) {
        System.out.println(chatLog);
        template.convertAndSendToUser(chatLog.getSendid()+"","/msg/"+chatLog.getReceiveid(),chatLog.getSendid() + " 对 " + chatLog.getReceiveid() + " 发送了：" + chatLog.getContent());
        chatLogService.recordChatLog(chatLog);
    }
}
