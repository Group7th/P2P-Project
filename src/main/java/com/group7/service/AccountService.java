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

    /**
     * 插入身份证验证信息
     * @param map
     * @return
     */
    int addIdCard(Map map);

    /**
     * 插入姓名、年龄、身份证、家庭住址、学历、婚姻状况、基本收入
     * @param realName
     * @param sex
     * @param idNum
     * @param address
     * @param education
     * @param marriage
     * @param basicIncome
     * @param userinformationid
     * @return
     */
    int addIdCardNum(String realName,String sex,String idNum,String address,String education, String marriage,String basicIncome,String birthday,int userinformationid);

    /**
     * 添加银行卡号
     * @param bankCardNums
     * @param userinformationid
     * @return
     */
    int addBankNums(String bankCardNums,int userinformationid);

    /**
     * 实名认证通过后更新状态
     * @param map
     * @return
     */
    int changeState(Map map);

    /**
     * 获取实名认证的状态
     * @return
     */
    int getState(int userinformationid);

    /**
     * 根据accountId朝赵informationId
     * @param accountId
     * @return
     */
    int getUserInformatioId(int accountId);

    /**
     * 提现
     * @param withdraw
     * @param userinformationid
     * @return
     */
    int withdraw(double withdraw,double costMoney,int userinformationid);

    /**
     * 查询用户可用余额
     * @param userinformationid
     * @return
     */
    double getAvailMoney(int userinformationid);

    /**
     * 根据用户名查找用户ID
     * @param userName
     * @return
     */
    int getIdByUserName(String userName);

    /**
     * 添加充值记录
     * @param map
     * @return
     */
    int addChargeRecord(Map map);

    /**
     * 添加提现记录
     * @param map
     * @return
     */
    int withdrawRecord(Map map);

    /**
     * 将提现的手续费添加到资金池
     * @param costMoney
     * @return
     */
    int addFeeToPool(double costMoney);

    /**
     * 获取用户支付密码
     * @param userinformationid
     * @return
     */
    String getPayPwd(int userinformationid);

    /**
     * 更改支付密码
     * @param newPayPwd
     * @param userinformationid
     * @return
     */
    int changePayPwd(String newPayPwd,int userinformationid);

    /**
     * 后台审核用户信息
     * @return
     */
    List<Map> identityAudit(Map map);

    /**
     * 后台审核用户信息总量
     * @return
     */
    int identityAuditSum();

    /**
     * 将审核状态发送到系统消息中
     * @param map
     * @return
     */
    int addSysMsg(Map map);
}
