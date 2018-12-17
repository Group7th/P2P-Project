package com.group7.controller;

import com.group7.service.IoansAccomplishAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:IoansAccomplishAuditController
 * discriptoin: 满表审核表
 * author:ZHEN
 * createTime:2018-12-08 15:12
 */
@Controller
public class IoansAccomplishAuditController {

    @Autowired
    private IoansAccomplishAuditService ioansService;

    /**
     * 查询满表审核表信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/IoansAccomplishAudit")
    public Object getList(@RequestBody Map map){
        // System.out.println(map);
        Map tempMap = new HashMap();
        tempMap.put("page",ioansService.getList(map));
        tempMap.put("total",ioansService.getPageCount(map));
        System.out.println(tempMap);
        return tempMap;
    }

    /**
     * 查询流标贷款信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getFailureLoans")
    public Object getFailureLoans(@RequestBody Map map){
        // System.out.println(map);
        Map tempMap = new HashMap();
        tempMap.put("page",ioansService.getFailureLoans(map));
        tempMap.put("total",ioansService.getFailureLoansCount(map));
        System.out.println(tempMap);
        return tempMap;
    }

    /**
     * 贷款(满标)审核
     * @return
     */
    @ResponseBody
    @RequestMapping("/loanReview")
    public  Object loanReview(@RequestBody Map map){
        System.out.println(map);
        int  i =ioansService.loanReview(map);
        System.out.println(i+"...................");
        return i;
    }

    /**
     * 每个贷款的 投标记录
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/InvestmentRecord")
    public Object InvestmentRecord(@RequestBody Map map){
        //System.out.println(map);
        List<Map> maps = ioansService.InvestmentRecord(map);
        //System.out.println(maps);
        return maps;
    }


}
