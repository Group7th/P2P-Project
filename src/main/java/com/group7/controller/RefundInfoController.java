package com.group7.controller;

import com.group7.service.RefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Scheduled(cron="0 * 14 * * ?")
    public void RefundInfo(){
        String refundInfo = refundInfoService.getRefundInfo();
        System.out.println(refundInfo);
        //获取当前时间
        LocalDateTime localDateTime =LocalDateTime.now();
        System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //return refundInfo;
    }
}
