package com.hycxkj.user.mapper;

import com.hycxkj.user.bean.UserAddr;
import com.hycxkj.user.bean.UserAddrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddrMapper {
    long countByExample(UserAddrExample example);

    int deleteByExample(UserAddrExample example);

    int insert(UserAddr record);

    int insertSelective(UserAddr record);

    List<UserAddr> selectByExample(UserAddrExample example);

    int updateByExampleSelective(@Param("record") UserAddr record, @Param("example") UserAddrExample example);

    int updateByExample(@Param("record") UserAddr record, @Param("example") UserAddrExample example);
}