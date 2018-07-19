package com.hycxkj.recommend.service.impl;

import com.hycxkj.recommend.dao.UserLikeKeyWordDao;
import com.hycxkj.recommend.entity.UserLikeKeyWord;
import com.hycxkj.recommend.service.UserLikeKeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 16:17
 */
@Service
public class UserLikeKeyWordServiceImpl implements UserLikeKeyWordService{

    @Autowired
    private UserLikeKeyWordDao userLikeKeyWordDao;

    @Override
    public void insertAll(Set<UserLikeKeyWord> set) {
        userLikeKeyWordDao.insertAll(set);
    }

    @Override
    public List<UserLikeKeyWord> getListByUserId(long userId) {
        return userLikeKeyWordDao.getListByUserId(userId);
    }

    @Override
    public void deleteListByUserId(long userId) {
        userLikeKeyWordDao.deleteListByUserId(userId);
    }

    @Override
    public void deleteById(String id) {
        userLikeKeyWordDao.deleteById(id);
    }
}
