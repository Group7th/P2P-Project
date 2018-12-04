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
}
