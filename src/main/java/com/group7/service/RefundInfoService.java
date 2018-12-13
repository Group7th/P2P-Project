package com.group7.service;

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
    String getRefundInfo();
}
