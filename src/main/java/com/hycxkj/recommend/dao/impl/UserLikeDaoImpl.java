package com.hycxkj.recommend.dao.impl;

import com.hycxkj.recommend.dao.UserLikeLogDao;
import com.hycxkj.recommend.entity.UserLikeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 8:27
 */
@Repository
public class UserLikeDaoImpl implements UserLikeLogDao{

    @Autowired
    private MongoTemplate mongoTemplate;
    private static final String COLLECTION_NAME = "userLikeLog";

    @Override
    public List getDistinct(String fieldName) {
        return mongoTemplate.getCollection(COLLECTION_NAME).distinct(fieldName);
    }

    @Override
    public List<UserLikeLog> getUserLikeLogsByUserIdAndGtTime(long userId, Date time) {
        Criteria id = Criteria.where("userId").is(userId).and("viewTime").gte(time);
        Query query = new Query(id);
        List<UserLikeLog> likeLogs = mongoTemplate.find(query, UserLikeLog.class);
        return likeLogs;
    }
}
