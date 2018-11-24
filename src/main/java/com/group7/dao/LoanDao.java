package com.group7.dao;

import java.util.Map;

/**
 * className:LoanDao
 * discriptoin:贷款业务
 * author:zz
 * createTime:2018-11-24 09:32
 */
public interface LoanDao {

    /**
     * 申请贷款，把申请贷款的信息存到数据库
     * @param map
     * @return
     */
    int applyForLoad(Map map);
}
