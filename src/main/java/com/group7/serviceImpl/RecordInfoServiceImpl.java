package com.group7.serviceImpl;

import com.group7.dao.RecordInfoDao;
import com.group7.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RecordInfoServiceImpl
 * Description:
 * Author:严浩天
 * CreateTime:2018-12-08 16:47
 */
@Service
public class RecordInfoServiceImpl implements RecordInfoService {

    @Autowired
    private RecordInfoDao recordInfoDao;

    @Override
    public List<Map> moneyRecordList(Map map) {
        return recordInfoDao.moneyRecordList(map);
    }

    @Override
    public int moneyRecordListCount(Map map) {
        return recordInfoDao.moneyRecordListCount(map);
    }

    @Override
    public int deleteMoneyRecord(int moneyrecord) {
        return recordInfoDao.deleteMoneyRecord(moneyrecord);
    }

    @Override
    public int getId(String userName) {
        return recordInfoDao.getId(userName);
    }
}
