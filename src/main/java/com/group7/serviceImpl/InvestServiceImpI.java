package com.group7.serviceImpl;

import com.group7.dao.InvestDao;
import com.group7.entity.Invest;
import com.group7.entity.InvestmentAmount;
import com.group7.service.InvestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:InvestServiceImpI
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-24 12:35
 */
@Service
public class InvestServiceImpI implements InvestService {

    @Autowired
    private InvestDao investDao;


    /**
     * 多条件筛选 查询分页
     * @param map
     * @return
     */
    public List<Map> getInves(Map map) {
        //如果pageNo为空默认1  pageSize 为空,默认10
        int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize")==null?5:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return investDao.getInves(map);
    }


    /**
     * 分页总数量
     * @param map
     * @return
     */
    @Override
    public Map getInvesCount(Map map) {
        int pageSize = Integer.valueOf(map.get("pageSize")+"");  //当前页数据条数
        int pageNo = Integer.valueOf(map.get("pageNo")+"");  //当前页数
        int invesCount = investDao.getInvesCount(map); //获取总页数
        int maxPage =  invesCount % pageSize == 0 ? invesCount / pageSize : invesCount / pageSize + 1;  //判断当前是第几页
        Map tempMap = new HashMap();
        if(pageNo>=maxPage){   //如果当前页大于最大页     把值赋给Map 1为显示 0为隐藏  下一页按钮
            tempMap.put("hi",0);
        }else {
            tempMap.put("sh",1);
        }
        return tempMap;
    }


    /**
     * 获取个人贷款信息  个人信息 账户信息
     * @param map
     * @return
     */
    @Override
    public Map investment(Map map) {
        Map tempMap = new HashMap();
        Map investment = investDao.investment(map);
        if(investment!=null){
            return investDao.investment(map);
        }else{
            tempMap.put("error","1");
            return tempMap;
        }
    }

    /**
     * 投资信息表   贷款人的投资人和投资信息记录
     * @param invest
     * @return
     */
    @Override
    public int investmentAmount(InvestmentAmount invest) {
        return investDao.investmentAmount(invest);
    }

    /**
     * 查询投资信息  不能重复投资
     * @param userName
     * @param loansId
     * @return
     */
    @Override
    public Integer investmentVerify(@Param("userName") String userName,@Param("loansId") Integer loansId) {
        return investDao.investmentVerify(userName,loansId);
    }
    /**
     * 投资金额 添加到 投资表 总投资金额中
     * @param invest
     * @return
     */
    @Override
    public int investmentMoeny(InvestmentAmount invest) {
        return investDao.investmentMoeny(invest);
    }
    /**
     * 查看贷款 投资信息
     * @param loansId
     * @return
     */
    @Override
    public List<Map> investmentInformation(Integer loansId) {
        return investDao.investmentInformation(loansId);
    }
    /**
     * 查询是否实名制
     * @param userName
     * @return
     */
    @Override
    public Map earnings(String userName) {
        return investDao.earnings(userName);
    }
    /**
     * 投资完成 改变账户可用金额
     * @param invest
     * @return
     */
    @Override
    public int changeMoeny(InvestmentAmount invest) {
        return investDao.changeMoeny(invest);
    }

    /**
     * 投资金额添加到 公司账户
     * @param invest
     * @return
     */
    @Override
    public int moeny(InvestmentAmount invest) {
        return investDao.moeny(invest);
    }

    /**
     * 投资成功 (把资金转入公司账户) 添加公司资金记录
     * @param invest
     * @return
     */
    @Override
    public int moneyCorporation(InvestmentAmount invest) {
        return investDao.moneyCorporation(invest);
    }

    /**
     * 投资成功  添加 发送系统消息提示客户
     * @param invest
     * @return
     */
    @Override
    public int message(InvestmentAmount invest) {
        return investDao.message(invest);
    }
    /**
     * 投资成功 添加资金记录
     * @param invest
     * @return
     */
    @Override
    public int moneyRecord(InvestmentAmount invest) {
        return investDao.moneyRecord(invest);
    }


}
