package com.hycxkj.recommend.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.recommend.bean.HotProduction;
import com.hycxkj.recommend.bean.HotProductionExample;
import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/04/23 04:15
*/
public interface HotProductionService {

    int insert(HotProduction model);

    /**
     * 只插入部分
     */
    int insertSelective(HotProduction model);

    PageInfo<HotProduction> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<HotProduction> getPagesByExample(Integer pageNum, Integer pageSize, HotProductionExample example);

    HotProduction getById(Long id);

    int deleteById(Long id);

    int deleteByExample(HotProductionExample example);

    int updateSelectiveById(HotProduction model,Long id);

    int updateSelectiveByExample(HotProduction model, HotProductionExample example);

}