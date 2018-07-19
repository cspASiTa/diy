package com.hycxkj.other.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hycxkj.other.bean.Banner;
import com.hycxkj.other.bean.BannerExample;
import com.hycxkj.other.mapper.BannerMapper;
import com.hycxkj.other.service.BannerService;
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
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    @Transactional
    public int insert(Banner model) {
        return bannerMapper.insert(model);
    }

    @Override
    @Transactional
    public int insertSelective(Banner model){
        return bannerMapper.insertSelective(model);
    }

    @Override
    public PageInfo<Banner> getByPage(Integer pageNum, Integer pageSize) {
        BannerExample bannerExample = new BannerExample();
        BannerExample.Criteria criteria = bannerExample.createCriteria();
        criteria.getAllCriteria();
        return getPagesByExample(pageNum, pageSize, bannerExample);
    }

    @Override
    public PageInfo<Banner> getPagesByExample(Integer pageNum, Integer pageSize, BannerExample example){
        PageHelper.startPage(pageNum,pageSize);
        List<Banner> list = bannerMapper.selectByExample(example);
        PageInfo<Banner> info = new PageInfo<>(list);
        return info;
    }

    public Banner getById(Integer id) {
        BannerExample bannerExample = new BannerExample();
        BannerExample.Criteria criteria = bannerExample.createCriteria();
        criteria.andBannerIdEqualTo(id);
        List<Banner> list = bannerMapper.selectByExample(bannerExample);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int deleteById(Integer id) {
        BannerExample bannerExample = new BannerExample();
        BannerExample.Criteria criteria = bannerExample.createCriteria();
        criteria.andBannerIdEqualTo(id);
        return deleteByExample(bannerExample);
    }

    @Override
    @Transactional
    public int deleteByExample(BannerExample example) {
        return bannerMapper.deleteByExample(example);
    }


    @Override
    public int updateSelectiveById(Banner model,Integer id) {
        BannerExample bannerExample = new BannerExample();
        BannerExample.Criteria criteria = bannerExample.createCriteria();
        criteria.andBannerIdEqualTo(id);
        return updateSelectiveByExample(model,bannerExample);
    }

    @Override
    @Transactional
    public int updateSelectiveByExample(Banner model, BannerExample example){
        return bannerMapper.updateByExampleSelective(model,example);
    }

    @Override
    public List<Banner> getBanners() {
        List<Banner> banners = bannerMapper.getBannersToFont();
        return banners;
    }
}