package com.group7.serviceImpl;

import com.group7.dao.LoanAuditDao;
import com.group7.dao.LoanDao;
import com.group7.service.LoanAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * className:LoanAuditServiceImpl
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-28 21:22
 */
@Service
@Transactional
public class LoanAuditServiceImpl implements LoanAuditService{
	//依赖注入
	@Autowired
	private LoanAuditDao loanAuditDao;

	/**
	 * 贷款列表
	 * @param map
	 * @return
	 */
	@Override
	public List<Map> getList(Map map) {
		return loanAuditDao.getList(map);
	}

	/**
	 * 获取分数总数量
	 * @param map
	 * @return
	 */
	@Override
	public int getPageCount(Map map) {
		return loanAuditDao.getPageCount(map);
	}

	/**
	 * 审核通过
	 * @param LOANSSTATE
	 * @param LOANSID
	 * @return
	 */
	@Override
	public int update(Integer LOANSSTATE, Integer LOANSID) {

		return loanAuditDao.update(LOANSSTATE,LOANSID);
	}

	/**
	 * 驳回贷款 修改状态 存入驳回理由
	 * @param REASON
	 * @param LOANSSTATE
	 * @param LOANSID
	 * @return
	 */
	@Override
	public int reject(String REASON, Integer LOANSSTATE, Integer LOANSID) {
		return loanAuditDao.reject(REASON,LOANSSTATE,LOANSID);
	}

	/**
	 * 通过理由
	 * @param LOANSID
	 * @return
	 */
	@Override
	public int passReason(Integer LOANSID) {
		return loanAuditDao.passReason(LOANSID);
	}

	/**
	 * 驳回消息
	 * @param LOANSID
	 * @return
	 */
	@Override
	public int rejectReson(Integer LOANSID) {
		return loanAuditDao.rejectReson(LOANSID);
	}
}
