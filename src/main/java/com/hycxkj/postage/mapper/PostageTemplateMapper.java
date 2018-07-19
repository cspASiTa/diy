package com.hycxkj.postage.mapper;

import com.hycxkj.postage.bean.PostageTemplate;
import com.hycxkj.postage.bean.PostageTemplateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostageTemplateMapper {
    long countByExample(PostageTemplateExample example);

    int deleteByExample(PostageTemplateExample example);

    int insert(PostageTemplate record);

    int insertSelective(PostageTemplate record);

    List<PostageTemplate> selectByExample(PostageTemplateExample example);

    int updateByExampleSelective(@Param("record") PostageTemplate record, @Param("example") PostageTemplateExample example);

    int updateByExample(@Param("record") PostageTemplate record, @Param("example") PostageTemplateExample example);

    /**
     *  通过商家ID 和 商品ID 获取 PostageTemplate
     * @param shopBusiId
     * @param shopItemId
     * @return
     */
    PostageTemplate getByBusiIdAndItemId(@Param("shopBusiId") long shopBusiId, @Param("shopItemId") long shopItemId);
}