package com.group7.dao;

import com.group7.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * className:UserDao
 * discriptoin:
 * author:严浩天
 * createTime:2018-11-24 10:11
 */
public interface UserDao {

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
     * 向用户信息表插入信息
     * @param userPhone
     * @return
     */
    int addPhone(@Param("userPhone") String userPhone, @Param("userId")Integer userId);

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

