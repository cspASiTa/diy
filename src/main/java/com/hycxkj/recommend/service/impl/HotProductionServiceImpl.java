package com.hycxkj.recommend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.recommend.bean.HotProduction;
import com.hycxkj.recommend.bean.HotProductionExample;
import com.hycxkj.recommend.mapper.HotProductionMapper;
import com.hycxkj.recommend.service.HotProductionService;
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
* @create in 2018/04/23 04:15
*/
@Service
public class HotProductionServiceImpl implements HotProductionService {

    @Autowired
    private HotProductionMapper hotProductionMapper;

    @Override
    @Transactional
    public int insert(HotProduction model) {
        return hotProductionMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(HotProduction model){
        return hotProductionMapper.insertSelective(model);
    }

    @Override
    public PageInfo<HotProduction> getByPage(Integer pageNum, Integer pageSize) {
        HotProductionExample hotProductionExample = new HotProductionExample();
        HotProductionExample.Criteria criteria = hotProductionExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, hotProductionExample);
    }

    @Override
    public PageInfo<HotProduction> getPagesByExample(Integer pageNum, Integer pageSize, HotProductionExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<HotProduction> list = hotProductionMapper.selectByExample(example);
        PageInfo<HotProduction> info = new PageInfo<>(list);
        return info;
    }

    public HotProduction getById(Long id) {
        HotProductionExample hotProductionExample = new HotProductionExample();
        HotProductionExample.Criteria criteria = hotProductionExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<HotProduction> list = hotProductionMapper.selectByExample(hotProductionExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Long id) {
        HotProductionExample hotProductionExample = new HotProductionExample();
        HotProductionExample.Criteria criteria = hotProductionExample.createCriteria();
        criteria.andIdEqualTo(id);
        return deleteByExample(hotProductionExample);
    }

    @Override
    @Transactional
    public int deleteByExample(HotProductionExample example) {
        return hotProductionMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(HotProduction model,Long id) {
        HotProductionExample hotProductionExample = new HotProductionExample();
        HotProductionExample.Criteria criteria = hotProductionExample.createCriteria();
        criteria.andIdEqualTo(id);
        return updateSelectiveByExample(model,hotProductionExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(HotProduction model, HotProductionExample example){
        return hotProductionMapper.updateByExampleSelective(model,example);
    }
}