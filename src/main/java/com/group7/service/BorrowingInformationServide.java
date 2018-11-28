package com.group7.service;


import java.util.List;
import java.util.Map;

/**
 * 借贷信息Service
 * 申恩
 */
public interface BorrowingInformationServide {
    /**
     * 获取借款信息
     * @param map
     * @return
     */
    List<Map> getBorrowingList(Map map);
}
