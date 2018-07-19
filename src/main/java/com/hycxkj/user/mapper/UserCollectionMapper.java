package com.hycxkj.user.mapper;

import com.hycxkj.production.font.FontSimpleProduction;
import com.hycxkj.user.bean.UserCollection;
import com.hycxkj.user.bean.UserCollectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCollectionMapper {
    long countByExample(UserCollectionExample example);

    int deleteByExample(UserCollectionExample example);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    List<UserCollection> selectByExample(UserCollectionExample example);

    int updateByExampleSelective(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    int updateByExample(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    /**
     *  获取用户的作品收藏
     * @param userId 获取的用户的ID
     * @return
     */
    List<FontSimpleProduction> selectCollectionProductionInfo(@Param("userId") long userId);
}