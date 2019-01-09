package com.group7.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:IoansAccomplishAuditDao
 * discriptoin:满表审核
 * author:ZHEN
 * createTime:2018-12-08 15:13
 */
public interface IoansAccomplishAuditDao {


    /**
     * 查询 所有满标贷款信息  进行审核
     * @param map
     * @return
     */
    @Select({"<script>" +
            "select * from"
            +"(select rownum rn,t.* from "
            +"(select a.loansid,a.username,a.loansmoney,a.loansinterestrate,a.refunddeadline,a.loansstate,a.investmentamount,a.refundway,a.begintime,a.loansused,a.loanstype,c.userphone,c.identitycard,c.bankcardnumbers,c.site,b.globalvalue,b.appraisalreport,b.carinformation,b.houseproperty,"
            +"(select count(*) from tb_investment q join tb_loans w on q.loansid=w.loansid where  q.loansid = a.loansid) as con from tb_loans a "
            + "join  tb_loanstype b on a.loansid=b.loansid "
            + "join tb_userinformation c on a.userid = c.userid "
            + "where a.loansmoney = a.investmentamount and  a.loansstate = 2 "
            +"<if test=\"loansId!=null and loansId!=''\"> and a.LOANSID like '%'||#{loansId}||'%' </if> "
            +"<if test=\"userName!=null and userName!=''\">and a.USERNAME like '%'||#{userName}||'%'</if> "
            +"<if test=\"loansType!=null and loansType!=0\">and a.LOANSTYPE=#{loansType}</if> "
            + " ) t "
            + "where rownum &lt; #{end} ) a "
            +"where a.rn &gt; #{start} "
            +"</script>"})
    List<Map> getList(Map map);

    /**
     * 查询 所有满标贷款信息 条数
     * @param map
     * @return
     */
    @Select({"<script>"
            +"select count(1) from tb_loans "
            +"<where>"
            +"<if test=\"loansId!=null and loansId!=''\"> and LOANSID=#{loansId} </if>"
            +"<if test=\"userName!=null and userName!=''\">and USERNAME like '%'||#{userName}||'%'</if>"
            +"<if test=\"loansType!=null and loansType!=0\">and LOANSTYPE=#{loansType}</if>"
            +"and loansmoney = investmentamount and loansstate = 2"
            +"</where>"
            +"</script>"})
    int getPageCount(Map map);

    /**
     * 查询 所有满标贷款信息  进行审核
     * @param map
     * @return
     */
    @Select({"<script>" +
            "select * from"
            +"(select rownum rn,t.* from "
            +"(select a.loansid,a.username,a.loansmoney,a.loansinterestrate,a.refunddeadline,a.loansstate,a.investmentamount,a.refundway,a.begintime,a.loansused,a.loanstype,c.userphone,c.identitycard,c.bankcardnumbers,c.site,b.globalvalue,b.appraisalreport,b.carinformation,b.houseproperty,"
            +"(select count(*) from tb_investment q join tb_loans w on q.loansid=w.loansid where  q.loansid = a.loansid) as con from tb_loans a "
            + "join  tb_loanstype b on a.loansid=b.loansid "
            + "join tb_userinformation c on a.userid = c.userid "
            + "where a.loansstate = 3 "
            +"<if test=\"loansId!=null and loansId!=''\"> and a.LOANSID like '%'||#{loansId}||'%' </if> "
            +"<if test=\"userName!=null and userName!=''\">and a.USERNAME like '%'||#{userName}||'%'</if> "
            +"<if test=\"loansType!=null and loansType!=0\">and a.LOANSTYPE=#{loansType}</if> "
            + " ) t "
            + "where rownum &lt; #{end} ) a "
            +"where a.rn &gt; #{start} "
            +"</script>"})
    List<Map> getFailureLoans(Map map);

    /**
     * 查询 所有满标贷款信息 条数
     * @param map
     * @return
     */
    @Select({"<script>"
            +"select count(1) from tb_loans "
            +"<where>"
            +"<if test=\"loansId!=null and loansId!=''\"> and LOANSID=#{loansId} </if>"
            +"<if test=\"userName!=null and userName!=''\">and USERNAME like '%'||#{userName}||'%'</if>"
            +"<if test=\"loansType!=null and loansType!=0\">and LOANSTYPE=#{loansType}</if>"
            +"and loansmoney = investmentamount and loansstate = 3"
            +"</where>"
            +"</script>"})
    int getFailureLoansCount(Map map);


    /**
     * 贷款审核
     * @param map
     * @return
     */
    Integer loanReview(Map map);

    /**
     * 每个贷款的投资记录
     * @return
     */
    List<Map> InvestmentRecord(Map map);

    /**
     * 查询贷款审核记录表
     * @param map
     * @return
     */
    @Select({"<script>" +
            "select * from"
            +" (select rownum rn,t.* from "
            +" (select d.auditstype,d.auditstate,to_char(d.time,'yyyy-mm-dd hh24:mi:ss') as time,a.loansid,a.username,a.loansmoney,a.loansinterestrate,a.refunddeadline,a.loansstate,a.investmentamount,a.refundway,a.begintime,a.loansused,a.loanstype,c.userphone,c.identitycard,c.bankcardnumbers,c.site,b.globalvalue,b.appraisalreport,b.carinformation,b.houseproperty,"
            +" (select count(*) from tb_investment q join tb_loans w on q.loansid=w.loansid where  q.loansid = a.loansid) as con from tb_loans a "
            +" join tb_loanstype b on a.loansid=b.loansid "
            +" join tb_userinformation c on a.userid = c.userid "
            +" join tb_auditrecord d on d.loansid = a.loansid "
            +" <where> "
            +" <if test=\"loansId!=null and loansId!=''\"> and a.LOANSID like '%'||#{loansId}||'%' </if> "
            +" <if test=\"userName!=null and userName!=''\">and a.USERNAME like '%'||#{userName}||'%'</if> "
            +" <if test=\"auditStype!=null and auditStype!=0\">and d.auditStype = #{auditStype}</if> "
            +" </where>) t "
            +" where rownum &lt; #{end} ) a "
            +" where a.rn &gt; #{start} "
            +"</script>"})
    List<Map> loansRecord(Map map);

    /**
     *  查询贷款审核记录表 条数
     * @param map
     * @return
     */
    @Select({"<script>"
            +"select count(1) from tb_loans a"
            +" join tb_loanstype b on a.loansid=b.loansid "
            +" join tb_userinformation c on a.userid = c.userid "
            +" join tb_auditrecord d on d.loansid = a.loansid "
            +"<where>"
            +"<if test=\"loansId!=null and loansId!=''\"> and LOANSID=#{loansId} </if>"
            +"<if test=\"userName!=null and userName!=''\">and USERNAME like '%'||#{userName}||'%'</if>"
            +" <if test=\"auditstype!=null and auditstype!=0\">and d.auditStype=#{auditStype}</if> "
            +"</where>"
            +"</script>"})
    int getLoansRecordCount(Map map);
}
