package com.group7.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:RefundInfoService
 * discriptoin:还款
 * author:zz
 * createTime:2018-12-13 13:57
 */
public interface RefundInfoDao {

    /**
     *定时器调用还款的存储过程时返回的还款信息
     * @return
     */
    String getRefundInfo(Map map);

    /**
     * 查询出还款的信息
     * @return
     */
    @Select({"<script>" +
            " select * from (select rownum rn,t.LOANSID,t.USERID,t.USERNAME,t.LOANSMONEY,t.REFUNDWAY,"
            +" t.LOANSINTERESTRATE,t.REFUNDDEADLINE,t.TIME,round(sysdate-t.TIME) as OVERDUEDAY,t.TDATE,t.LOANSTYPE,t.LOANSUSED,t.LOANSSTATE,t.REASON,"
            +" b.USERPHONE as up,b.IDENTITYCARD as CARD,"
            +" b.BANKCARDNUMBERS as BANKCARD,b.SITE as SITE,c.GLOBALVALUE as VALUE,c.HOUSEPROPERTY as HOUSE,"
            +" c.CARINFORMATION as CAR,c.APPRAISALREPORT as PORT FROM tb_loans t"
            +" join tb_userinformation b on b.USERID = t.USERID"
            +" join tb_loanstype c on c.LOANSID = t.LOANSID"
            +" where rownum &lt; #{end} and t.LOANSSTATE in (10,11)"
            +"<if test=\"loansId!=null and loansId!=''\"> and t.LOANSID like '%'||#{loansId}||'%' </if>"
            +"<if test=\"userName!=null and userName!=''\">and t.USERNAME like '%'||#{userName}||'%'</if>"
            +"<if test=\"loansType!=null and loansType!=0\">and t.LOANSTYPE=#{loansType}</if>"
            +"<if test=\"loansState!=null and loansState!=0\">and t.LOANSSTATE=#{loansState}</if>"
            +" ) a where a.rn &gt; #{start}"
            +"</script>"})
    List<Map> getOverdueInfo(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select({"<script>"
            +"select count(*) from tb_loans "
            +"<where>"
            +"<if test=\"loansId!=null and loansId!=''\"> and LOANSID=#{loansId} </if>"
            +"<if test=\"userName!=null and userName!=''\">and USERNAME like '%'||#{userName}||'%'</if>"
            +"<if test=\"loansType!=null and loansType!=0\">and LOANSTYPE=#{loansType}</if>"
            +"<if test=\"loansState!=null and loansState!=0\">and LOANSSTATE=#{loansState}</if>"
            +"and LOANSSTATE=1"
            +"</where>"
            +"</script>"})
    int getPageCount(Map map);
}
