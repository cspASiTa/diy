package com.hycxkj.other.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.other.bean.HotWord;
import com.hycxkj.other.bean.HotWordExample;
import com.hycxkj.other.mapper.HotWordMapper;
import com.hycxkj.other.service.HotWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author 陈少平
* @description
* @create in 2018/04/03 04:39
*/
@Service
public class HotWordServiceImpl implements HotWordService {

    @Autowired
    private HotWordMapper hotWordMapper;

    @Override
    @Transactional
    public int insert(HotWord model) {
        return hotWordMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(HotWord model){
        return hotWordMapper.insertSelective(model);
    }

    @Override
    public PageInfo<HotWord> getByPage(Integer pageNum, Integer pageSize) {
        HotWordExample hotWordExample = new HotWordExample();
        HotWordExample.Criteria criteria = hotWordExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, hotWordExample);
    }

    @Override
    public PageInfo<HotWord> getPagesByExample(Integer pageNum, Integer pageSize, HotWordExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<HotWord> list = hotWordMapper.selectByExample(example);
        PageInfo<HotWord> info = new PageInfo<>(list);
        return info;
    }

    public HotWord getById(Integer id) {
        HotWordExample hotWordExample = new HotWordExample();
        HotWordExample.Criteria criteria = hotWordExample.createCriteria();
        criteria.andHotIdEqualTo(id);
        List<HotWord> list = hotWordMapper.selectByExample(hotWordExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Integer id) {
        HotWordExample hotWordExample = new HotWordExample();
        HotWordExample.Criteria criteria = hotWordExample.createCriteria();
        criteria.andHotIdEqualTo(id);
        return deleteByExample(hotWordExample);
    }

    @Override
    @Transactional
    public int deleteByExample(HotWordExample example) {
        return hotWordMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(HotWord model,Integer id) {
        HotWordExample hotWordExample = new HotWordExample();
        HotWordExample.Criteria criteria = hotWordExample.createCriteria();
        criteria.andHotIdEqualTo(id);
        return updateSelectiveByExample(model,hotWordExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(HotWord model, HotWordExample example){
        return hotWordMapper.updateByExampleSelective(model,example);
    }

    @Override
    public List<HotWord> getHotWordToFont(byte type) {
        List<HotWord> words = hotWordMapper.getHotWordToFont(type);
        return words;
    }
}