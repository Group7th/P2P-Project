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

    /**
     * 注册时赋予用户普通角色
     * @param userid
     * @return
     */
    int registerRole(int userid);

    /**
     * 注册时添加用户默认账户信息
     * @param userinformationid
     * @return
     */
    int registerAccountInfo (int userinformationid);

    /**
     * 根据id查找用户userinformationId
     * @param id
     * @return
     */
    int registerUserinformationid(int id);
}
