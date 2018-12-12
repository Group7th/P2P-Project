package com.group7.controller;

import com.group7.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:RecordController
 * Description:
 * Author:严浩天
 * CreateTime:2018-12-08 16:49
 */
@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordInfoService recordInfoService;

    @Autowired
    private HttpSession session;
    /**
     * 资金记录列表
     * @param map
     * @return
     */
    @RequestMapping("/moneyList")
    @ResponseBody
    public Map page(@RequestBody Map map){
        System.out.println(map+".......");
        Object userSession = session.getAttribute("userSession");
        String userName = userSession+"";
        int id = recordInfoService.getId(userName);
        System.out.println("用户的id为："+id);
        map.put("userid",id);
        //System.out.println(pageNo+"......."+pageSize);
       // PageHelper.startPage(Integer.valueOf(map.get("pageNo")+""),Integer.valueOf(map.get("pageSize")+""));
        // PageHelper.startPage(pageNo,pageSize);
       // PageInfo<Map> page =new PageInfo<>(recordInfoService.moneyRecordList());
        //int[] navigatepageNums = page.getNavigatepageNums();
        // System.out.println(page.getTotal()+"........");
        Map rmap=new HashMap();
        rmap.put("data",recordInfoService.moneyRecordList(map));
        rmap.put("total",recordInfoService.moneyRecordListCount(map));
        System.out.println(rmap);
        return rmap;
    }

    /**
     * 删除一行数据
     * @param moneyrecord
     * @return
     */
    @RequestMapping("/deleteRows/{moneyrecord}")
    @ResponseBody
    public Map deleteRows(@PathVariable int moneyrecord){
        System.out.println(moneyrecord+"数据过来了.......");
        int i = recordInfoService.deleteMoneyRecord(moneyrecord);
        Map<String,String> tempMap = new HashMap<>();
        if(i>0){
            tempMap.put("msg","success");
        }else{
            tempMap.put("msg","fail");
        }
        return tempMap;
    }

}

