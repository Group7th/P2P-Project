package com.group7.controller;

import com.group7.entity.InvestmentAmount;
import com.group7.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:InvestController
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-23 21:12
 */
//扫描控制层
@Transactional
@Controller
public class InvestController {

    @Autowired  //依赖注入
    private InvestService investService;


    /**
     * 投资选择页面
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/invest")
    public Object invest(@RequestParam Map map){
        Map tempMap = new HashMap();
        //if(map!=null&&"".equals(map)){  //判断不能为空
            map.put("pageSize",5);   //定义一页 页数
            List<Map> inves = investService.getInves(map);  //获取查询信息
            Map invesCount = investService.getInvesCount(map);  //获取页码信息
            tempMap.put("inves",inves);
            tempMap.put("invesCount",invesCount);
        //}
        return tempMap;
    }

    /**
     * 投资页面
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/investment")
    public Object investment(@RequestParam Map map){
        Map investment = investService.investment(map);
       // System.out.println(investment);
        return investment;
    }

    /**
     * 贷款 投资详情信息
     * @param invest
     * @return
     */
    @ResponseBody
    @RequestMapping("/investmentAmount")
    public Object investmentAmount(@RequestBody InvestmentAmount invest){
        System.out.println(invest.toString());
        int i = investService.investmentAmount(invest);
        int i1 = investService.investmentMoeny(invest);

        System.out.println(invest);

        return i;
    }

    /**
     * 查询投资信息  不能重复投资
     * @param userId
     * @param loansId
     * @return
     */
    @ResponseBody
    @RequestMapping("/investmentVerify")
    public Object investmentVerify(@RequestParam Integer userId,Integer loansId){
        //System.out.println(userId+","+loansId);
        Map map = investService.investmentVerify(userId, loansId);
        //System.out.println(map);
        return map;
    }







}
