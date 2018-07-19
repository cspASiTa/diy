package com.hycxkj.shop.mapper;

import com.hycxkj.shop.bean.ShopComment;
import com.hycxkj.shop.bean.ShopCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCommentMapper {
    long countByExample(ShopCommentExample example);

    int deleteByExample(ShopCommentExample example);

    long insert(ShopComment record);

    long insertSelective(ShopComment record);

    List<ShopComment> selectByExample(ShopCommentExample example);

    int updateByExampleSelective(@Param("record") ShopComment record, @Param("example") ShopCommentExample example);

    int updateByExample(@Param("record") ShopComment record, @Param("example") ShopCommentExample example);
}