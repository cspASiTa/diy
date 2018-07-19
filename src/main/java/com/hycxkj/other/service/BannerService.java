package com.hycxkj.other.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.other.bean.Banner;
import com.hycxkj.other.bean.BannerExample;
import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/04/03 04:39
*/
public interface BannerService {

    int insert(Banner model);

    /**
     * 只插入部分
     */
    int insertSelective(Banner model);

    PageInfo<Banner> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<Banner> getPagesByExample(Integer pageNum, Integer pageSize, BannerExample example);

    Banner getById(Integer id);

    int deleteById(Integer id);

    int deleteByExample(BannerExample example);

    int updateSelectiveById(Banner model,Integer id);

    int updateSelectiveByExample(Banner model, BannerExample example);

    List<Banner> getBanners();
}