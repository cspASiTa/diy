package com.hycxkj.user.controller;

import com.hycxkj.common.base.BaseController;
import com.hycxkj.user.service.UserPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author 陈少平
* @description
* @create in Thu Mar 29 16:51:12 CST 2018
*/
@Slf4j
@RestController
@RequestMapping("/api")
public class UserPayController extends BaseController {

    @Autowired
    private UserPayService userPayService;

}