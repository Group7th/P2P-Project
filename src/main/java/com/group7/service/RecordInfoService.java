package com.group7.service;


import java.util.List;
import java.util.Map;

/**
 * ClassName:RecordInfoService
 * Description:
 * Author:严浩天
 * CreateTime:2018-12-08 16:45
 */
public interface RecordInfoService {
    /**
     * 资金记录列表
     * @return
     */
    List<Map> moneyRecordList(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int moneyRecordListCount(Map map);

    /**
     * 根据moneyrecord删除
     * @param moneyrecord
     * @return
     */
    int deleteMoneyRecord(int moneyrecord);

    /**
     * 根据名字查找id
     * @param userName
     * @return
     */
    int getId(String userName);

}
