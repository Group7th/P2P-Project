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
     * @param userId
     * @param loansId
     * @return
     */
    Map investmentVerify(@Param("userId") Integer userId, @Param("loansId") Integer loansId);

    /**
     * 投资金额 添加到 投资表 总投资金额中
     * @param invest
     * @return
     */
    int investmentMoeny(InvestmentAmount invest);

}