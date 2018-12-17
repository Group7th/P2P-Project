package com.group7.controller;

import com.group7.entity.UserInfo;
import com.group7.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:LoanController
 * discriptoin:
 * author:邢博
 * createTime:2018-11-24 21:06
 */
@Controller
@Transactional
public class LoanController {

    @Autowired
    private LoanService loanService;

    /**
     * 点击申请贷款，查询当前用户的信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Object getUserInfo(@RequestParam Map map){
        return loanService.getUserInfo(map);
    }

    /**
     * 通用获取session
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSessoinUserInfo")
    public Object getSessoinUserInfo(HttpSession session){
        return  session.getAttribute("userSession");
    }

    /**
     * 查询当前用户是否已经贷款
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectLoans")
    public Object selectLoans(@RequestParam String username){
        System.out.println(username);
        Map info = loanService.selectloans(username);
        return info;
    }

    /**
     * 申请贷款时向数据库添加信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/applyForLoan")
    public Object applyForLoan(@RequestBody Map map){
        System.out.println(map);
        int i = loanService.applyForLoad(map);
        map.put("loansid",map.get("loansid"));
        if(map.get("type").equals("1")){
            loanService.houseLoans(map);
        }else if(map.get("type").equals("2")){
            loanService.carLoans(map);
        }
        return i;
    }

    /**
     * 查询逾期的信息列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/OverdueInfo")
    public Map OverdueInfo(@RequestBody Map map){
        System.out.println(loanService.getOverdueInfo(map));
        Map tempMap = new HashMap();
        tempMap.put("page",loanService.getOverdueInfo(map));
        tempMap.put("totel",loanService.getPageCount(map));
        return tempMap;
    }
}
