package com.group7.service;

import java.util.List;
import java.util.Map;

/**
 * className:RefundInfoService
 * discriptoin:
 * author:zz
 * createTime:2018-12-13 14:13
 */
public interface RefundInfoService {

    /**
     *定时器调用还款的存储过程时返回的还款信息
     * @return
     */
    String getRefundInfo(Map map);

    /**
     * 查询出还款逾期的信息
     * @return
     */
    List<Map> getOverdueInfo(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
}
