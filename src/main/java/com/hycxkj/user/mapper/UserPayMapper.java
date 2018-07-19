package com.hycxkj.user.mapper;

import com.hycxkj.user.bean.UserPay;
import com.hycxkj.user.bean.UserPayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPayMapper {
    long countByExample(UserPayExample example);

    int deleteByExample(UserPayExample example);

    int insert(UserPay record);

    int insertSelective(UserPay record);

    List<UserPay> selectByExample(UserPayExample example);

    int updateByExampleSelective(@Param("record") UserPay record, @Param("example") UserPayExample example);

    int updateByExample(@Param("record") UserPay record, @Param("example") UserPayExample example);
}