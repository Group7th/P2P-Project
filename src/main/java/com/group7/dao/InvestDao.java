package com.group7.dao;

import com.group7.entity.InvestmentAmount;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * className:InvestDao
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-24 12:33
 */
public interface InvestDao {

    /**
     * 多条件筛选 查询分页
     *
     * @param map
     * @return
     */
    List<Map> getInves(Map map);

    /**
     * 分页总数量
     *
     * @param map
     * @return
     */
    int getInvesCount(Map map);

    /**
     * 获取个人贷款信息
     *
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
     * @param loansId
     * @return
     */
    Integer investmentVerify(@Param("userName") String userName, @Param("loansId") Integer loansId);

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

    /**
     * 查询是否实名制
     * @param userName
     * @return
     */
    Map earnings(String userName);

    /**
     * 投资完成 改变账户可用金额
     * @param invest
     * @return
     */
    int changeMoeny(InvestmentAmount invest);

    /**
     * 投资金额添加到 公司账户
     * @param invest
     * @return
     */
    int moeny(InvestmentAmount invest);


    /**
     * 投资成功  添加 发送系统消息提示客户
     * @param invest
     * @return
     */
    int message(InvestmentAmount invest);

    /**
     * 投资成功 添加资金记录
     * @param invest
     * @return
     */
    int moneyRecord(InvestmentAmount invest);

    /**
     * 投资成功 把资金转入公司账户(贷款人贷款成功把钱从公司账户扣除) 添加公司资金记录
     * @param invest
     * @return
     */
    int moneyCorporation (InvestmentAmount invest);


    }