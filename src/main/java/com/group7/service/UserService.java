package com.group7.service;

import com.group7.entity.User;

/**
 * ClassName:UserDao
 * Description:
 * Author:严浩天
 * CreateTime:2018-11-23 19:33
 */

public interface UserService {

    /**
     * 用户注册方法
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 注册的用户名查重
     * @param userName
     * @return
     */
    String checkRepeat(String userName);

    /**
     * 注册的手机号查重
     * @param userPhone
     * @return
     */
    String checkRepeatPhone(String userPhone);
}
