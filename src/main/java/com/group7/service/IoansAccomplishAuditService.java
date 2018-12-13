package com.group7.service;


import java.util.List;
import java.util.Map;

/**
 * className:IoansAccomplishAuditService
 * discriptoin:满表审核
 * author:ZHEN
 * createTime:2018-12-08 15:13
 */
public interface IoansAccomplishAuditService {

    /**
     * 查询 所有满标贷款信息  进行审核
     * @param map
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 查询 所有满标贷款信息 条数
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 查询 所有流标贷款信息  进行审核
     * @param map
     * @return
     */
    List<Map> getFailureLoans(Map map);

    /**
     * 查询 所有流标贷款信息 条数
     * @param map
     * @return
     */
    int getFailureLoansCount(Map map);

    /**
     * 贷款审核
     * @param map
     * @return
     */
    int loanReview(Map map);
}
