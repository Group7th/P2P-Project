package com.group7.serviceImpl;

import com.group7.dao.AccountInfoDao;
import com.group7.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * ClassName:AccountServiceImpl
 * Description:
 * Author:严浩天
 * CreateTime:2018-11-28 17:23
 */
@Service
@SuppressWarnings("all")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountInfoDao accountInfoDao;

    @Autowired
    private HttpSession session;


    @Override
    public Map accountInfo(String userName) {
        Map tempList = accountInfoDao.accountInfo(userName);
        return tempList;
    }

    @Override
    public int payPwd(String userName) {
        return accountInfoDao.payPwd(userName);
    }

    @Override
    public int charge(Map map) {
        return accountInfoDao.charge(map);
    }

    @Override
    public String headPic(String userName) {
        return accountInfoDao.headPic(userName);
    }

    @Override
    public int addHeadPic(Map map) {
        return accountInfoDao.addHeadPic(map);
    }

    @Override
    public Map accountSet(String userName) {
        return accountInfoDao.accountSet(userName);
    }

    @Override
    public int changePhone(Map map) {
        return accountInfoDao.changePhone(map);
    }

    @Override
    public int changePwd(Map map) {
        return accountInfoDao.changePwd(map);
    }

    @Override
    public int addIdCard(Map map) {
        return accountInfoDao.addIdCard(map);
    }

    @Override
    public int addIdCardNum(String realName, int sex, String idNum, String address, int userinformationid) {
        return accountInfoDao.addIdCardNum(realName,sex,idNum,address,userinformationid);
    }

    @Override
    public int addBankNums(String bankCardNums, int userinformationid) {
        return accountInfoDao.addBankNums(bankCardNums,userinformationid);
    }

    @Override
    public int changeState(Map map) {
        return accountInfoDao.changeState(map);
    }

    @Override
    public int getState(int userinformationid) {
        return accountInfoDao.getState(userinformationid);
    }

    @Override
    public int getUserInformatioId(int accountId) {
        return accountInfoDao.getUserInformatioId(accountId);
    }

    @Override
    public int withdraw(double withdraw, double costMoney, int userinformationid) {
        return accountInfoDao.withdraw(withdraw, costMoney, userinformationid);
    }

    @Override
    public double getAvailMoney(int userinformationid) {
        return accountInfoDao.getAvailMoney(userinformationid);
    }

    @Override
    public int getIdByUserName(String userName) {
        return accountInfoDao.getIdByUserName(userName);
    }

    @Override
    public int addChargeRecord(Map map) {
        return accountInfoDao.addChargeRecord(map);
    }

    @Override
    public int withdrawRecord(Map map) {
        return accountInfoDao.withdrawRecord(map);
    }

    @Override
    public int addFeeToPool(double costMoney) {
        return accountInfoDao.addFeeToPool(costMoney);
    }
}
