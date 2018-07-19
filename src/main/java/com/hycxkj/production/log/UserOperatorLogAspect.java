package com.hycxkj.production.log;

import com.hycxkj.recommend.redis.RedisService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 陈少平
 * @description  用户记录用户的喜好
 * @create in 2018/4/10 15:25
 */
@Aspect
@Order(1)
@Component
public class UserOperatorLogAspect {

    private static final Logger logger = LoggerFactory.getLogger("MONGO");

    private Pattern pattern = Pattern.compile(".*proId=(\\d+),.*userId=(\\d+),");  // 获取 userId
    private Pattern pattern2 = Pattern.compile(".*proId=(\\d+),.*title=(.*?),.*categoryId=(\\d+)");  //获取proId, title, categoryId

    @Autowired
    private RedisService redisService;

    @Pointcut("target(com.hycxkj.production.controller.ProductionController) && @annotation(com.hycxkj.production.annotation.UserLikeRecord)")
    public void userLog(){}

    @Before("userLog()")
    public void userOperatorDoBefore() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        long nowTime = System.currentTimeMillis();
        request.setAttribute("startTime",nowTime);
    }

    @After("userLog()")
    public void userOperatorDoAfter(JoinPoint joinPoint) {
        String args = Arrays.toString(joinPoint.getArgs());
        // 判断用户是否登录，如果登录，那么记录，如果没登录，那么直接返回
        long userId = isLoginAndIncreaseProductionClick(args);
        if(userId > 0) {
            // 当前用户有登录，记录用户喜好
            Document userLikelog = getUserLileLog(joinPoint, args, userId);
            logger.info(MongoDBAppender.getUserLikeLogCollectionName(),userLikelog);
        }
        // 记录当前访问的用户的一些基本信息
        Document document = getUserViewLog(joinPoint, args);
        logger.info(MongoDBAppender.getUserViewLogCollectionName(),document);
    }

    /**
     *  获取用户喜欢记录
     * @param joinPoint
     * @param args 方法参数
     * @param userId
     * @return
     */
    private Document getUserLileLog(JoinPoint joinPoint, String args, long userId) {
        Document document = new Document();
        document.append("userId",userId);
        document.append("viewTime",new Date());
        appendUserLikeInfo(document, args);
        return document;
    }

    /**
     *  生成用户浏览记录
     * @return Document
     */
    private Document getUserViewLog(JoinPoint joinPoint, String args) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        String url = request.getRequestURL().toString();
        String host = request.getRemoteAddr();
        String class_method =  joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Date date = new Date(startTime);
        Document document = new Document();
        document.append("url",url);
        document.append("time",time);
        document.append("host",host);
        document.append("class_method",class_method);
        document.append("args",args);
        document.append("date",date);
        return document;
    }

    /**
     *  如果没有userId 返回 -1，如果有那么直接返回userId的值
     *  并将作品的点击数 + 1
     * @param args 客户端传给服务器的参数
     * @return
     */
    private long isLoginAndIncreaseProductionClick(String args) {
        Matcher matcher = pattern.matcher(args);
        if(matcher.find()) {
            String proId = matcher.group(1);
            long userId = Long.parseLong(matcher.group(2));
            redisService.increaseProductionClick(proId);
            return userId;
        }
        return -1;
    }

    /**
     * 将 proId , title 添加到Document中 （用户喜好分析时，需要使用）
     */
    private void appendUserLikeInfo(Document document, String args) {
        Matcher matcher = pattern2.matcher(args);
        if(matcher.find()) {
            long proId = Long.parseLong(matcher.group(1));
            if(proId > 0) {
                document.append("proId",proId);
            }
            String title = matcher.group(2);
            if(!title.equals("null")) {
                document.append("title",title);
            }
            int categoryId = Integer.parseInt(matcher.group(3));
            if(categoryId > 0) {
                document.append("categoryId",categoryId);
            }
        }
    }

}
