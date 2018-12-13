package com.group7.controller;

import com.group7.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        int i = recordInfoService.deleteMoneyRecord(moneyrecord);
        Map<String,String> tempMap = new HashMap<>();
        if(i>0){
            tempMap.put("msg","success");
        }else{
            tempMap.put("msg","fail");
        }
        return tempMap;
    }

    /**
     * 进入投资记录表
     * @return
     */
    @RequestMapping("toGRZXTouZi")
    public String toGRZXTouZi(Model model){
        //从session中获取用户的账户信息 是一个map
        Object accountList = session.getAttribute("accountList");
        //将object转回成map
        Map tempAccount = (Map) session.getAttribute("accountList");
        //获取userinformationid
        Object o = tempAccount.get("USERINFORMATIONID");
        //将userinformationid从Object转换为integer类型
        Integer userinformationid = Integer.valueOf(o+"");
        //根据userinformationid查找userid
        int userid = recordInfoService.getUserIdByUserinformationId(userinformationid);
        System.out.println(userid+"---------?????");
        //累计投资
        Integer sumInvestment = recordInfoService.getSumInvestment(userid);
        System.out.println("累计投资为什么报错?????????"+sumInvestment);
        //获取累计收益 待收本金  待收收益
        Map sumIncome = recordInfoService.getSumIncome(userinformationid);
        System.out.println(sumIncome+"????????????????????");
        //累计收益
        Object accruedincome = sumIncome.get("ACCRUEDINCOME");
        //待收本金
        Object awaitmoney = sumIncome.get("AWAITMONEY");
        //待收收益
        Object awaitinterest = sumIncome.get("AWAITINTEREST");
        System.out.println("累计投资"+sumInvestment+"累计收益"+accruedincome+"待收本金"+awaitmoney+"待收收益"+awaitinterest);
        model.addAttribute("sumInvestment",sumInvestment);
        model.addAttribute("accruedincome",accruedincome);
        model.addAttribute("awaitmoney",awaitmoney);
        model.addAttribute("awaitinterest",awaitinterest);
        return "yirenbaopage/个人中心-投资记录.html";
    }

    /**
     * 投资记录列表
     * @param map
     * @return
     */
    @RequestMapping("/investList")
    @ResponseBody
    public Map investList(@RequestBody Map map){
        System.out.println(map+".......");
        Object userSession = session.getAttribute("userSession");
        String userName = userSession+"";
        int id = recordInfoService.getId(userName);
        System.out.println("用户的id为："+id);
        map.put("userid",id);
        Map rmap=new HashMap();
        rmap.put("data",recordInfoService.investList(map));
        rmap.put("total",recordInfoService.investListCount(map));
        System.out.println(rmap);
        return rmap;
    }

    /**
     * 系统消息列表
     * @param map
     * @return
     */
    @RequestMapping("/messageList")
    @ResponseBody
    public Map messageList(@RequestBody Map map){
        System.out.println(map+".......");
        Object userSession = session.getAttribute("userSession");
        String userName = userSession+"";
        int id = recordInfoService.getId(userName);
        System.out.println("用户的id为："+id);
        map.put("userid",id);
        Map rmap=new HashMap();
        rmap.put("data",recordInfoService.systemMessageList(map));
        rmap.put("total",recordInfoService.systemMessageListCount(map));
        System.out.println(rmap);
        return rmap;
    }

    /**
     * 删除一行系统消息
     * @param messageid
     * @return
     */
    @RequestMapping("/deleteMessage/{messageid}")
    @ResponseBody
    public Map deleteMessage(@PathVariable int messageid){
        int i = recordInfoService.deleteMessageRecord(messageid);
        Map<String,String> tempMap = new HashMap<>();
        if(i>0){
            tempMap.put("msg","success");
        }else{
            tempMap.put("msg","fail");
        }
        return tempMap;
    }


    /**
     * 资金记录列表
     * @param map
     * @return
     */
    @RequestMapping("/changeMessageState")
    @ResponseBody
    public Map changeMessageState(@RequestBody Map map){
        System.out.println(map+".......");
        Object userSession = session.getAttribute("userSession");
        String userName = userSession+"";
        int id = recordInfoService.getId(userName);
        System.out.println("用户的id为："+id);
        map.put("userid",id);
        //改变未读消息的状态为已读
        int i = recordInfoService.changeMessageState(map);
        Map tempMap = new HashMap();
        if(i>0){
            tempMap.put("msg","success");
        }else{
            tempMap.put("msg","fail");
        }
        return tempMap;
    }
}

