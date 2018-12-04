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
    Map accountInfo(String userName);

    /**
     * 查询用户支付密码
     * @param userName
     * @return
     */
    int payPwd(String userName);

    /**
     * 用户充值
     * @param map
     * @return
     */
    int charge(Map map);

    /**
     * 根据用户名查找头像
     * @param userName
     * @return
     */
    String headPic(String userName);

    /**
     * 插入用户头像
     * @param map
     * @return
     */
    int addHeadPic(Map map);
}
