package com.group7.controller;


import com.group7.service.BorrowingInformationServide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 借贷信息（可用于前台首页展示，我的投资信息展示）
 */
@Controller
public class BorrowingInformationController {
    /*引入服务层*/
    @Autowired
    private BorrowingInformationServide biService;

    /**
     * 首页个人征信贷款数据
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("indexInformation")
    public Object indexInformation(@RequestParam Map map){
        map.put("type","1");
        return biService.getBorrowingList(map);
    }

    /**
     * 首页抵押贷款数据
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("indexInformationDiYa")
    public Object indexInformationDiYa(@RequestParam Map map){
        map.put("type","2");
        System.out.println("进入方法");
        return biService.getBorrowingList(map);
    }



}
