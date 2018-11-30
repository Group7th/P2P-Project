package com.group7.service;

import java.util.List;
import java.util.Map;

/**
 * className:LoanAuditService
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-28 21:21
 */
public interface LoanAuditService {

	/**
	 * 贷款列表
	 * @param map
	 * @return
	 */
	List<Map> getList(Map map);

	/**
	 * 查询分页总数量
	 * @param map
	 * @return
	 */
	int getPageCount(Map map);
}
