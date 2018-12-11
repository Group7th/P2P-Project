package com.group7.service;

import com.group7.entity.InvestmentAmount;

import java.util.List;
import java.util.Map;

/**
 * className:InvestService
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-24 12:34
 */
public interface InvestService {

    /**
     * 多条件筛选 查询分页
     * @param map
     * @return
     */
    List<Map> getInves(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    Map getInvesCount(Map map);

    /**
     * 获取个人贷款信息  个人信息 账户信息
     * @param map
     * @return
     */
    Map investment(Map map);

    /**
     * 投资信息表   贷款人的投资人和投资信息记录
     * @param invest
     * @return
     */
    int investmentAmount(InvestmentAmount invest);

    /**
     * 查询投资信息  不能重复投资
     * @param userName
     * @param loansId
     * @return
     */
    Map investmentVerify(String userName,Integer loansId);

    /**
     * 投资金额 添加到 投资表 总投资金额中
     * @param invest
     * @return
     */
    int investmentMoeny(InvestmentAmount invest);


    /**
     * 查看贷款 投资信息
     * @param loansId
     * @return
     */
    List<Map> investmentInformation(Integer loansId);

}
