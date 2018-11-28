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
}

