package com.hycxkj.postage.mapper;

import com.hycxkj.postage.bean.PostagePackageCondition;
import com.hycxkj.postage.bean.PostagePackageConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostagePackageConditionMapper {
    long countByExample(PostagePackageConditionExample example);

    int deleteByExample(PostagePackageConditionExample example);

    int insert(PostagePackageCondition record);

    int insertSelective(PostagePackageCondition record);

    List<PostagePackageCondition> selectByExample(PostagePackageConditionExample example);

    int updateByExampleSelective(@Param("record") PostagePackageCondition record, @Param("example") PostagePackageConditionExample example);

    int updateByExample(@Param("record") PostagePackageCondition record, @Param("example") PostagePackageConditionExample example);
}