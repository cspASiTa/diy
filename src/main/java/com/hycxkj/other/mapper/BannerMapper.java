package com.hycxkj.other.mapper;

import com.hycxkj.other.bean.Banner;
import com.hycxkj.other.bean.BannerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    long countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExample(BannerExample example);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    /**
     *  获取轮播图给前端
     * @return
     */
    List<Banner> getBannersToFont();
}