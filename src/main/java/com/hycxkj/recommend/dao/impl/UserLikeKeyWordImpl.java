package com.hycxkj.recommend.dao.impl;

import com.hycxkj.recommend.dao.UserLikeKeyWordDao;
import com.hycxkj.recommend.entity.UserLikeKeyWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 16:12
 */
@Repository
public class UserLikeKeyWordImpl implements UserLikeKeyWordDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertAll(Set<UserLikeKeyWord> set) {
        mongoTemplate.insertAll(set);
    }

    @Override
    public List<UserLikeKeyWord> getListByUserId(long userId) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
        List<UserLikeKeyWord> keyWords = mongoTemplate.find(query, UserLikeKeyWord.class);
        return keyWords;
    }

    @Override
    @Transactional
    public void deleteListByUserId(long userId) {
        mongoTemplate.remove(new Query().addCriteria(Criteria.where("userId").is(userId)),UserLikeKeyWord.class);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(new Query().addCriteria(Criteria.where("_id").is(id)),UserLikeKeyWord.class);
    }
}
