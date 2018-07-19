package com.hycxkj.other.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.other.bean.HotWord;
import com.hycxkj.other.bean.HotWordExample;
import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/04/03 04:39
*/
public interface HotWordService {

    int insert(HotWord model);

    /**
     * 只插入部分
     */
    int insertSelective(HotWord model);

    PageInfo<HotWord> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<HotWord> getPagesByExample(Integer pageNum, Integer pageSize, HotWordExample example);

    HotWord getById(Integer id);

    int deleteById(Integer id);

    int deleteByExample(HotWordExample example);

    int updateSelectiveById(HotWord model,Integer id);

    int updateSelectiveByExample(HotWord model, HotWordExample example);

    /**
     * 获取首页关键字给前端
     * @param type
     * @return
     */
    List<HotWord> getHotWordToFont(byte type);

}