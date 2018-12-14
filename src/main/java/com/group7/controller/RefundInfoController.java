package com.group7.controller;

import com.group7.service.RefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:RefundInfoService
 * discriptoin:
 * author:邢博
 * createTime:2018-12-13 14:16
 */
@Controller
public class RefundInfoController {
    /**
     * 依赖注入
     */
    @Autowired
    private RefundInfoService refundInfoService;

    /**
     * 还款时调用存储过程
     * @return
     */
    @Scheduled(cron="0 * 20 * * ?")
    public String RefundInfo(){

        Map map = new HashMap();
        return refundInfoService.getRefundInfo(map);
    }

    /**
     * 查询还款的信息列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/OverdueInfo")
    public Map OverdueInfo(@RequestBody Map map){
        Map tempMap = new HashMap();
        tempMap.put("page",refundInfoService.getOverdueInfo(map));
        tempMap.put("totel",refundInfoService.getPageCount(map));
        return tempMap;
    }
}
