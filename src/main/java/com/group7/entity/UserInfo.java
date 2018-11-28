package com.group7.entity;

import java.io.Serializable;

/**
 * className:UserDao
 * discriptoin:
 * author:严浩天
 * createTime:2018-11-24 09:55
 */
public class UserInfo {

    private Integer userInfomationId;
    private Integer userId;
    private String userName;
    private Integer userSex;
    private String userPhone;
    private String identityCard;
    private String bankCardNumbers;
    private String email;
    private String headPortrait;
    private String site;
    private String education;
    private String marriage;
    private String basicinCome;
    private Integer state;

    public Integer getUserInfomationId() {
        return userInfomationId;
    }

    public void setUserInfomationId(Integer userInfomationId) {
        this.userInfomationId = userInfomationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getBankCardNumbers() {
        return bankCardNumbers;
    }

    public void setBankCardNumbers(String bankCardNumbers) {
        this.bankCardNumbers = bankCardNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getBasicinCome() {
        return basicinCome;
    }

    public void setBasicinCome(String basicinCome) {
        this.basicinCome = basicinCome;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
