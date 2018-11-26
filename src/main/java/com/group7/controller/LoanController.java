package com.group7.controller;

import com.group7.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Map getUserInfo(@RequestParam String username){
        return loanService.getUserInfo(username);
    }
    /**
     * 申请贷款时向数据库添加信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("applyForLoan")
    public Object applyForLoan(@RequestBody Map map){
        System.out.println(map.get("type"));
        System.out.println(map);
        boolean state = false;
        if(map!=null){
            int result = loanService.applyForLoad(map);
            if(result>0){
                if(map.get("type").equals(1)){
                    int i = loanService.houseLoans(map);
                    if(i>0){
                        state = true;
                    }
                }else if(map.get("type").equals(2)){
                    int i = loanService.carLoans(map);
                    if(i>0){
                        state = true;
                    }
                }else{
                    int i = loanService.creditLoans(map);
                    if(i>0){
                        state = true;
                    }
                }
            }
        }
        return state;
    }

}
