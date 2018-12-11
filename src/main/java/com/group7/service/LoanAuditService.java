package com.group7.service;

import org.apache.ibatis.annotations.Param;

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

	/**
	 * 审核通过
	 * @param LOANSSTATE
	 * @param LOANSID
	 * @return
	 */
	int update(Integer LOANSSTATE,Integer LOANSID);

	/**
	 *招标审核驳回 修改状态 存入驳回理由
	 * @param REASON
	 * @param LOANSSTATE
	 * @param LOANSID
	 * @return
	 */
	int reject(String REASON,Integer LOANSSTATE,Integer LOANSID);

	/**
	 * 通过消息
	 * @param LOANSID
	 * @return
	 */
	int passReason(Integer LOANSID);

	/**
	 * 驳回消息
	 * @param LOANSID
	 * @return
	 */
	int rejectReson(Integer LOANSID);
}
