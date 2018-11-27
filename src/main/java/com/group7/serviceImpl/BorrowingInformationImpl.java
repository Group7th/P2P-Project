package com.group7.serviceImpl;

import com.group7.dao.BorrowingInformationDao;
import com.group7.service.BorrowingInformationServide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 借贷信息
 * 申恩
 */
@Service
public class BorrowingInformationImpl implements BorrowingInformationServide {

    @Autowired
    private BorrowingInformationDao bfDao;

    @Override
    public List<Map> getBorrowingList(Map map) {
        return bfDao.getBorrowingList(map);
    }
}
