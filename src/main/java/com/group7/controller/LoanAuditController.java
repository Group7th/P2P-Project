package com.group7.controller;

import com.group7.service.LoanAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
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

	/**
	 * 查询 分页 招标审核
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Object list(@RequestBody Map map){
		//StringUtils.isEmpty(map.get("pageNo"));等于 str!=null&&!"".equals(str)

		Map tempMap= new HashMap();
		tempMap.put("page",loanAuditService.getList(map));
		tempMap.put("total",loanAuditService.getPageCount(map));
		return tempMap;
	}

	/**
	 * 贷款通过
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update(@RequestBody Map map){
		//贷款通过 修改贷款状态
		loanAuditService.update(2,Integer.valueOf(map.get("LOANSID")+""));
		Integer loansid = Integer.valueOf(map.get("LOANSID") + "");
		//新增到消息记录表
		loanAuditService.passReason(loansid);
		return 1;
	}
	@ResponseBody
	/**
	 * 贷款驳回
	 */
	@RequestMapping("/reject")
	public Object reject(@RequestBody Map map){
		//贷款驳回 修改状态
		loanAuditService.reject((String) map.get("REASON"), 0, Integer.valueOf(map.get("LOANSID") + ""));
		Integer loansid = Integer.valueOf(map.get("LOANSID") + "");
		//新增到消息记录表
		loanAuditService.rejectReson(loansid);
		return 1;
	}

}
