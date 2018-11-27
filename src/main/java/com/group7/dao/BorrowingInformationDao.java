package com.group7.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 借贷信息(用于首页，投资页面)Dao
 * 申恩
 */
@Component
public interface BorrowingInformationDao {

    /**
     * 获取借款信息
     * @param map
     * @return
     */
    List<Map> getBorrowingList(Map map);
}
