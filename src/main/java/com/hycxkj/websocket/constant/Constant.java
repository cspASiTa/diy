package com.hycxkj.websocket.constant;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/7 21:08
 */
public class Constant {
    /**
     *  全局推送URL
     */
    public static final String SUBSCRIBE_BROKER = "/topic";

    /**
     *  全局推送URL
     */
    public static final String SUBSCRIBE_BROKER_PREFIX = "/app";
    /**
     *  点对点的URL
     */
    public static final String P2P_BROKER = "/queue";

    /**
     * 点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
     */
    public static final String P2P_BROKER_PREFIX = "/user";

    /**
     *  点对点消息推送地址后缀,最后的地址为/user/用户识别码/msg
     */
    public static final String P2P_PUSH_PATH = "/msg";

    /**
     * /客户端输入 xxx/ws 即可和服务端通信。 例如服务端地址是localhost:8080.
     * xx 即是 localhost:8080/ws
     */
    public static final String END_PONIT = "/ws/endpoint";
    /**
     * 运行跨域的范围
     */
    public static final String ALLOW_ORIGINS = "*";

    /**
     * 服务端生产地址,客户端订阅此地址以接收服务端生产的消息
     */
    public static final String PRODUCER_PATH = "/topic/nf";
}
