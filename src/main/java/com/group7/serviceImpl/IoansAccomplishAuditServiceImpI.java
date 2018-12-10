package com.group7.serviceImpl;

import com.group7.dao.IoansAccomplishAuditDao;
import com.group7.service.IoansAccomplishAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:IoansAccomplishAuditServiceImpI
 * discriptoin:
 * author:ZHEN
 * createTime:2018-12-08 15:13
 */
@Service
public class IoansAccomplishAuditServiceImpI implements IoansAccomplishAuditService{

    @Autowired
    private IoansAccomplishAuditDao ioansDao;

    @Override
    public List<Map> getList(Map map) {
        return ioansDao.getList(map);
    }

    @Override
    public int getPageCount(Map map) {
        return ioansDao.getPageCount(map);
    }
}
