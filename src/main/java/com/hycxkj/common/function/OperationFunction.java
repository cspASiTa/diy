package com.hycxkj.common.function;

import java.util.List;

/**
 * @author 陈少平
 * @description  分页lambda。为了抽取重复的代码：
 *    PageHelper.start(pageNum, pageSize)
 *    list = Mapper.XX (查询操作)
 *    new PageInfo(list)
 *    后面感觉没什么必要，所以又没添加进去了。。。。
 * @create in 2018/4/22 16:06
 */
@FunctionalInterface
public interface OperationFunction<Mapper,T> {

    List<T> apply();
}
