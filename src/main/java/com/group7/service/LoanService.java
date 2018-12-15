package com.group7.service;

import java.util.List;
import java.util.Map;

/**
 * className:LoanService
 * discriptoin:申请贷款业务层
 * author:zz
 * createTime:2018-11-24 20:41
 */
public interface LoanService {

    /**
     * 点击申请贷款，查询当前用户的信息
     * @param map
     * @return
     */
    Map getUserInfo(Map map);

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
     * 查询是否已经贷款了
     * @return
     */
    Map selectloans(String username);

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
     *//*
    int creditLoans(Map map);*/

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
