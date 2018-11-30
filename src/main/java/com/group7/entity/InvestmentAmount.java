package com.group7.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * className:InvestmentAmount
 * discriptoin:
 * author:ZHEN
 * createTime:2018-11-27 17:15
 */
public class InvestmentAmount implements Serializable {

  /*investmentid
    userid          NUMBER not null,
    loansid         NUMBER not null,
    investmentmoney NUMBER,
    investmentdate  TIMESTAMP(6),
    interestrate*/

    private Integer investmentId;  //投资ID
    private Integer userId;        //用户ID
    private Integer loansId;       //贷款ID
    private Integer investmentMoney;//投资金额
    private Data     investmentDate;//投资时间
    private Integer interestrate;  //利率
    private Integer investmentamount;  //投资总金额
    private Integer loansmoney; //贷款总金额

    @Override
    public String toString() {
        return "InvestmentAmount{" +
                "investmentId=" + investmentId +
                ", userId=" + userId +
                ", loansId=" + loansId +
                ", investmentMoney=" + investmentMoney +
                ", investmentDate=" + investmentDate +
                ", interestrate=" + interestrate +
                ", investmentamount=" + investmentamount +
                ", loansmoney=" + loansmoney +
                '}';
    }

    public Integer getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Integer investmentId) {
        this.investmentId = investmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLoansId() {
        return loansId;
    }

    public void setLoansId(Integer loansId) {
        this.loansId = loansId;
    }

    public Integer getInvestmentMoney() {
        return investmentMoney;
    }

    public void setInvestmentMoney(Integer investmentMoney) {
        this.investmentMoney = investmentMoney;
    }

    public Data getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(Data investmentDate) {
        this.investmentDate = investmentDate;
    }

    public Integer getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(Integer interestrate) {
        this.interestrate = interestrate;
    }

    public Integer getInvestmentamount() {
        return investmentamount;
    }

    public void setInvestmentamount(Integer investmentamount) {
        this.investmentamount = investmentamount;
    }

    public Integer getLoansmoney() {
        return loansmoney;
    }

    public void setLoansmoney(Integer loansmoney) {
        this.loansmoney = loansmoney;
    }

    public InvestmentAmount() {
    }

    public InvestmentAmount(Integer investmentId, Integer userId, Integer loansId, Integer investmentMoney, Data investmentDate, Integer interestrate, Integer investmentamount, Integer loansmoney) {
        this.investmentId = investmentId;
        this.userId = userId;
        this.loansId = loansId;
        this.investmentMoney = investmentMoney;
        this.investmentDate = investmentDate;
        this.interestrate = interestrate;
        this.investmentamount = investmentamount;
        this.loansmoney = loansmoney;
    }
}
