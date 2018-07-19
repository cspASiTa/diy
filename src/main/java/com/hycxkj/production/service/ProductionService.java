package com.hycxkj.production.service;

import com.github.pagehelper.PageInfo;
import com.hycxkj.production.bean.Production;
import com.hycxkj.production.bean.ProductionExample;
import com.hycxkj.production.font.FontSimpleProduction;

import java.util.List;

/**
* @author 陈少平
* @description
* @create in 2018/03/29 09:47
*/
public interface ProductionService {

    int insert(Production model);

    /**
     * 只插入部分
     */
    int insertSelective(Production model);

    PageInfo<Production> getByPage(Integer pageNum, Integer pageSize);

    PageInfo<Production> getPagesByExample(Integer pageNum, Integer pageSize, ProductionExample example);

    int deleteById(Long id);

    int deleteByExample(ProductionExample example);

    int updateSelectiveById(Production model,Long id);

    int updateSelectiveByExample(Production model, ProductionExample example);

    PageInfo<FontSimpleProduction> getSimpleProdutionToFont(Integer pageNum, Integer pageSize);

    /**
     *  将作品的阅读数 + 1
     * @return
     */
    int addReadnumber(Production production);

    /**
     *  将作品的点赞数 + 1
     * @param production
     * @return
     */
    int addLikeCount(Production production);

    int decreaseLikeCount(Production production);

    Production getProduction(Long proId);

    PageInfo<FontSimpleProduction> getProductionSimpleInfoByCateogryId(Integer categoryId, Integer pageNum, Integer pageSize);

    /**
     *  通过用户ID 分页获取用户的作品
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<FontSimpleProduction> getProductionSimpleInfoByUserId(Long userId, Integer pageNum, Integer pageSize);

    /**
     *  根据用户的喜好，获取用户喜欢的作品
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<FontSimpleProduction> getUserLikeProduction(Long userId, Integer pageNum, Integer pageSize);

    /**
     *  获取单个作品返回给前端
     * @param proId 作品ID
     * @return
     */
    FontSimpleProduction getSimpleProduction(long proId);

    /**
     * 从redis中按照作品的点击率从高到低获取作品
     */
    List<FontSimpleProduction> getUserLikeSimpleProductionByRedis(int pageNum, int pageSize);
}