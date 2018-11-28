package com.group7.entity;

import java.io.Serializable;

/**
 * ClassName:User
 * Description:
 * Author:严浩天
 * CreateTime:2018-11-24 10:27
 */

public class User{
    private Integer id;
    private String userName;
    private String password;
    private Integer enable;
    private String userPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    //重写toString方法 方便Controller测试实体数据

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
