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
    public List<Map> accountInfo(String userName) {
        List<Map> tempList = accountInfoDao.accountInfo(userName);
        return tempList;
    }
}
