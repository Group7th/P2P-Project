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

    /**
     * 查询用户手机号和登录密码
     * @param userName
     * @return
     */
    Map accountSet(String userName);

    /**
     * 用户更换手机号
     * @param map
     * @return
     */
    int changePhone(Map map);

    /**
     * 用户更换密码
     * @param map
     * @return
     */
    int changePwd(Map map);
}
