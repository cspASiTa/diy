package com.hycxkj.websocket.config;

import com.hycxkj.websocket.constant.Constant;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/7 20:09
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //允许跨域，
        // 客户端输入 xxx/ws 即可和服务端通信。 例如服务端地址是localhost:8080.
        // xx 即是 localhost:8080/ws
        stompEndpointRegistry.addEndpoint("/ws/endpoint").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 订阅Broker名称
        // queue 是点对点
        // topic 是全局推送
        // //服务端发送消息给客户端的域,多个用逗号隔开 .  1 对 1 推送的时候，域的名字要和前缀一样。
        registry.enableSimpleBroker(Constant.P2P_BROKER_PREFIX, Constant.SUBSCRIBE_BROKER);
        registry.setUserDestinationPrefix(Constant.P2P_BROKER_PREFIX);
        // 全局使用的消息前缀（客户端订阅路径上会体现出来）
//        registry.setApplicationDestinationPrefixes(Constant.SUBSCRIBE_BROKER_PREFIX);
        // 点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
//         registry.setUserDestinationPrefix("/user");
    }
}
