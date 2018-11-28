package com.group7.dao;

import java.util.List;
import java.util.Map;

/**
 * className:InvestDao
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-24 12:33
 */
public interface InvestDao {

    /**
     * 多条件筛选 查询分页
     *
     * @param map
     * @return
     */
    List<Map> getInves(Map map);

    /**
     * 分页总数量
     *
     * @param map
     * @return
     */
    int getInvesCount(Map map);

    /**
     * 获取个人贷款信息
     *
     * @param map
     * @return
     */
    Map investment(Map map);


    int investmentAmount();



}