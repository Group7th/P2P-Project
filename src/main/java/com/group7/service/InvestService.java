package com.group7.service;

import java.util.List;
import java.util.Map;

/**
 * className:InvestService
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-24 12:34
 */
public interface InvestService {

    /**
     * 多条件筛选 查询分页
     * @param map
     * @return
     */
    List<Map> getInves(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    Map getInvesCount(Map map);

    /**
     * 获取个人贷款信息  个人信息 账户信息
     * @param map
     * @return
     */
    Map investment(Map map);
}
