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

    @Override
    public int getUserIdByUserinformationId(int userinformationid) {
        return recordInfoDao.getUserIdByUserinformationId(userinformationid);
    }

    @Override
    public Integer getSumInvestment(int userid) {
        return recordInfoDao.getSumInvestment(userid);
    }

    @Override
    public Map getSumIncome(int userinformationid) {
        return recordInfoDao.getSumIncome(userinformationid);
    }

    @Override
    public List<Map> investList(Map map) {
        return recordInfoDao.investList(map);
    }

    @Override
    public int investListCount(Map map) {
        return recordInfoDao.investListCount(map);
    }

    @Override
    public List<Map> systemMessageList(Map map) {
        return recordInfoDao.systemMessageList(map);
    }

    @Override
    public int systemMessageListCount(Map map) {
        return recordInfoDao.systemMessageListCount(map);
    }

    @Override
    public int deleteMessageRecord(int messageid) {
        return recordInfoDao.deleteMessageRecord(messageid);
    }

    @Override
    public int changeMessageState(Map map) {
        return recordInfoDao.changeMessageState(map);
    }
}
