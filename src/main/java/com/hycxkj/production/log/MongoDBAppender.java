package com.hycxkj.production.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.net.UnknownHostException;

/**
 * @author 陈少平
 * @description  将用户浏览作品的日志，利用logback 写入mongodb中
 * @create in 2018/4/12 21:20
 */
public class MongoDBAppender extends UnsynchronizedAppenderBase<ILoggingEvent>{

    private static MongoClient mongo;
    private MongoCollection<Document> userViewLogCollection;
    private MongoCollection<Document> userLikeLogCollection;
    private String host;
    private int port;
    private String dbName;
    private String username;
    private String password;
    // 用户浏览记录
    private String userViewLog;
    // 用户喜好记录
    private String userLikeLog;

    private int connectionsPerHost = 30;


    @Override
    public void start() {
        try {
            connectToMongoDB();
            super.start();
        } catch (UnknownHostException e) {
            addInfo("连接mongodb 数据库失败");
            addError("Error connecting to MongoDB server: " + host + ":" + port, e);
        }
    }

    private void connectToMongoDB() throws UnknownHostException {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            MongoCredential credential = MongoCredential.createCredential(username, dbName, password.toCharArray());
            mongo = new MongoClient(new ServerAddress(host,port),credential,buildOptions());
            addInfo("连接并验证mongodb成功！");
        }else {
            mongo = new MongoClient(new ServerAddress(host,port),buildOptions());
            addInfo("连接mongodb成功");
        }
        MongoDatabase database = mongo.getDatabase(dbName);
        userViewLogCollection = database.getCollection(userViewLog);
        userLikeLogCollection = database.getCollection(userLikeLog);
    }

    private MongoClientOptions buildOptions() {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(connectionsPerHost);
        final MongoClientOptions mongoClientOptions = builder.build();
        return mongoClientOptions;
    }

    @Override
    protected void append(ILoggingEvent loggingEvent) {
        String message = loggingEvent.getMessage();
        String collectionName = getRecordCollectionName(message);
        Object[] array = loggingEvent.getArgumentArray();
        if(array.length > 0) {
            Object o  = array[0];
            if(o instanceof Document) {
                Document document = (Document) o;
                mongoInsert(document,collectionName);
            }
        }
    }

    private void mongoInsert(Document document, String collectionName) {
        try{
            if(collectionName.equals(userViewLog)) {
                userViewLogCollection.insertOne(document);
            }else if(collectionName.equals(userLikeLog)) {
                userLikeLogCollection.insertOne(document);
            }
        }catch (Exception e) {
            addError("数据插入集合："+collectionName+" 中失败");
        }
    }

    /**
     *  返回该记录应该记录在哪个集合中
     * @param message logger 的key
     * @exception  RuntimeException   message不在 Mongodb 的集合内
     * @return
     */
    private String getRecordCollectionName(String message) {
        String name = "";
        if(message.equals(userViewLog)) {
            name = userViewLog;
        }else if(message.equals(userLikeLog)) {
            name = userLikeLog;
        }
        if(name.equals("")) {
            throw new RuntimeException("抱歉，此日志: "+ message+ "好像不属于任何一个集合！");
        }
        return name;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setUserViewLog(String userViewlog) {
        this.userViewLog = userViewlog;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnectionsPerHost(int connectionsPerHost) {
        this.connectionsPerHost = connectionsPerHost;
    }

    public void setUserLikeLog(String userLikeLog) {
        this.userLikeLog = userLikeLog;
    }

    private static enum MongodbCollection{
        // 用户浏览日志
        USER_VIEW_LOG("userViewLog"),

        // 用户喜好日志
        USER_LIKE_LOG("userLikeLog");

        // MongodbCollection name
        private String name;
        MongodbCollection(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static String getUserViewLogCollectionName() {
        return MongodbCollection.USER_VIEW_LOG.getName();
    }

    public static String getUserLikeLogCollectionName() {
        return MongodbCollection.USER_LIKE_LOG.getName();
    }
}
