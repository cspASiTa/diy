package com.hycxkj.postage.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.postage.bean.PostageCarryMode;
import com.hycxkj.postage.bean.PostageCarryModeExample;

import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/05/06 08:28
*/
public interface PostageCarryModeService {

    int insert(PostageCarryMode model);

    /**
     * 只插入部分
     */
    int insertSelective(PostageCarryMode model);

    PageInfo<PostageCarryMode> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<PostageCarryMode> getPagesByExample(Integer pageNum, Integer pageSize, PostageCarryModeExample example);

    PostageCarryMode getById(Long id);

    int deleteById(Long id);

    int deleteByExample(PostageCarryModeExample example);

    int updateSelectiveById(PostageCarryMode model,Long id);

    int updateSelectiveByExample(PostageCarryMode model, PostageCarryModeExample example);

    /**
     * 获取模板指定的运送方式的运送模板
     * @param postageTemplateId
     * @param carryAway
     * @return
     */
    List<PostageCarryMode> getByPostageTemplateId(long postageTemplateId, byte carryAway);

    /**
     * 获取模板具体运送方式的默认运费
     * @param postageTemplateId
     * @param carryAway
     * @return
     */
    PostageCarryMode getPostageTemplateDefaultCarrayMode(long postageTemplateId ,byte carryAway);
}