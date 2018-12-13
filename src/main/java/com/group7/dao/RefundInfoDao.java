package com.group7.dao;

/**
 * className:RefundInfoService
 * discriptoin:还款
 * author:zz
 * createTime:2018-12-13 13:57
 */
public interface RefundInfoDao {

    /**
     *定时器调用还款的存储过程时返回的还款信息
     * @return
     */
    String getRefundInfo();
}
