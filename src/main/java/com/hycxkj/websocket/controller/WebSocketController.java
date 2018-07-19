package com.hycxkj.websocket.controller;

import com.hycxkj.websocket.bean.ChatLog;
import com.hycxkj.websocket.bean.Push;
import com.hycxkj.websocket.service.ChatLogService;
import com.hycxkj.websocket.service.WebSocketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/7 20:40
 */
@Api(tags = "在线即时聊天接口")
@Controller
public class WebSocketController {

    @Autowired
    private ChatLogService chatLogService;

    @Autowired
    private WebSocketService webSocketService;


    @MessageMapping("/ws/message")
    public void sendAll(Push push){
        webSocketService.sendAllMsg(push);
    }

    @MessageMapping("/ws/chat")
    public void send2User(ChatLog chatLog){
        webSocketService.send2User(chatLog);
    }
}
