package com.hycxkj.websocket.service.impl;

import com.hycxkj.websocket.bean.Push;
import com.hycxkj.websocket.mapper.PushMapper;
import com.hycxkj.websocket.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/8 11:35
 */
@Service
public class PushServiceImpl implements PushService {

    @Autowired
    private PushMapper pushMapper;

    @Override
    public int insert(Push push){
        push.setPushtime(new Date());
        return pushMapper.insertSelective(push);
    }
}
