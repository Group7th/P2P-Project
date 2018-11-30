package com.group7.controller;

import com.group7.service.LoanAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:LoanAuditController
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-28 21:31
 */
@Controller
@RequestMapping("/Audit")
public class LoanAuditController {
	//依赖注入
	@Autowired
	private LoanAuditService loanAuditService;

	@ResponseBody
	@RequestMapping("/list")
	public Object list(@RequestBody Map map){
		Map tempMap= new HashMap();
		tempMap.put("page",loanAuditService.getList(map));
		tempMap.put("total",loanAuditService.getPageCount(map));
		return tempMap;
	}
}
