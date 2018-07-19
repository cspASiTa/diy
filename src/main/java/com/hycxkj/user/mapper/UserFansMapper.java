package com.hycxkj.user.mapper;

import com.hycxkj.user.bean.UserFans;
import com.hycxkj.user.bean.UserFansExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFansMapper {
    long countByExample(UserFansExample example);

    int deleteByExample(UserFansExample example);

    int insert(UserFans record);

    int insertSelective(UserFans record);

    List<UserFans> selectByExample(UserFansExample example);

    int updateByExampleSelective(@Param("record") UserFans record, @Param("example") UserFansExample example);

    int updateByExample(@Param("record") UserFans record, @Param("example") UserFansExample example);

    /**
     *  获取用户的fans数
     * @param userId
     * @return
     */
    long getFansCount(Long userId);

    /**
     * 获取用户的关注数
     * @param focusId
     * @return
     */
    long getFocusCount(@Param("focusId") Long focusId);
}