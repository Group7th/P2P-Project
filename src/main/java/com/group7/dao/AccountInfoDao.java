package com.group7.dao;

import java.util.List;
import java.util.Map;

/**
 * ClassName:AccountInfoDao
 * Description:
 * Author:严浩天
 * CreateTime:2018-11-28 16:49
 */

public interface AccountInfoDao {

    /**
     * 账户信息
     * @return
     */
    List<Map> accountInfo(String userName);
}
