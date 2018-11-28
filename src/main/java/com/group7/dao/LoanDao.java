package com.group7.dao;

import java.util.Map;

/**
 * className:LoanService
 * discriptoin:贷款业务 dao层
 * author:zz
 * createTime:2018-11-24 09:32
 */
public interface LoanDao {

    /**
     * 点击申请贷款，查询当前用户的信息
     * @param username
     * @return
     */
    Map getUserInfo(String username);

    /**
     * 申请贷款，把申请贷款的信息存到数据库
     * @param map
     * @return
     */
    int applyForLoad(Map map);

    /**
     * 申请贷款，把房屋抵押贷款类型的信息存到数据库
     * @param map
     * @return
     */
    int houseLoans(Map map);

    /**
     * 申请贷款，把车辆抵押贷款类型的信息存到数据库
     * @param map
     * @return
     */
    int carLoans(Map map);

    /**
     * 申请贷款，把信用贷款类型的信息存到数据库
     * @param map
     * @return
     */
    int creditLoans(Map map);

}
