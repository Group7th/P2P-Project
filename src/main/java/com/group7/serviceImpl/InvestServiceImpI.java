package com.group7.serviceImpl;

import com.group7.dao.InvestDao;
import com.group7.entity.Invest;
import com.group7.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
        //如果pageNo为空默认1  pageSize 为空,默认10
        int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize")==null?5:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return investDao.getInves(map);
    }

    @Override
    public Map getInvesCount(Map map) {
        int pageSize = Integer.valueOf(map.get("pageSize")+"");  //当前页数据条数
        int pageNo = Integer.valueOf(map.get("pageNo")+"");  //当前页数
        int invesCount = investDao.getInvesCount(map); //获取总页数
        int maxPage =  invesCount % pageSize == 0 ? invesCount / pageSize : invesCount / pageSize + 1;  //判断当前是第几页
        Map tempMap = new HashMap();
        if(pageNo>=maxPage){   //如果当前页大于最大页     把值赋给Map 1为显示 0为隐藏  下一页按钮
            tempMap.put("hi",0);
        }else {
            tempMap.put("sh",1);
        }
        return tempMap;
    }

    @Override
    public Map investment(Map map) {
        return investDao.investment(map);
    }
}
