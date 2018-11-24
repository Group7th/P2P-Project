package com.group7.serviceImpl;

import com.group7.dao.InvestDao;
import com.group7.entity.Invest;
import com.group7.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:InvestServiceImpI
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-24 12:35
 */
@Service
public class InvestServiceImpI implements InvestService {

    @Autowired
    private InvestDao investDao;

    public List<Map> getInves(Map map) {
        map.put("pageSize",5);
        //如果pageNo为空默认1  pageSize 为空,默认10
        int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize")==null?5:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return investDao.getInves(map);
    }

    @Override
    public int getInvesCount(Map map) {

        return investDao.getInvesCount(map);
    }
}
