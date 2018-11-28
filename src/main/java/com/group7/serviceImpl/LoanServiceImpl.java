package com.group7.serviceImpl;

import com.group7.dao.LoanDao;
import com.group7.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:LoanServiceImpl
 * discriptoin:
 * author:邢博
 * createTime:2018-11-24 20:52
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanDao loanDao;

    @Override
    public Map getUserInfo(String username) {
        return loanDao.getUserInfo(username);
    }

    @Override
    public int applyForLoad(Map map) {
        return loanDao.applyForLoad(map);
    }

    @Override
    public int houseLoans(Map map) {
        return loanDao.houseLoans(map);
    }

    @Override
    public int carLoans(Map map) {
        return loanDao.carLoans(map);
    }

    @Override
    public int creditLoans(Map map) {
        return loanDao.creditLoans(map);
    }
}
