package com.group7.service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:AccountService
 * Description:
 * Author:严浩天
 * CreateTime:2018-11-28 17:22
 */
public interface AccountService {
    /**
     * 账户信息
     * @return
     */
    List<Map> accountInfo(String userName);
}
