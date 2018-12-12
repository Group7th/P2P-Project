package com.group7.dao;

import org.apache.ibatis.annotations.Param;

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
     * 插入姓名、用户性别、身份证和家庭地址
     * @param realName
     * @param sex
     * @param idNum
     * @param address
     * @param userinformationid
     * @return
     */
    int addIdCardNum(@Param("realName") String realName, @Param("sex") int sex, @Param("idNum") String idNum, @Param("address") String address, @Param("userinformationid") int userinformationid);

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
}
