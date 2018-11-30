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
}
