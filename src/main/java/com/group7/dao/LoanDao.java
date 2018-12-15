package com.group7.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:LoanService
 * discriptoin:贷款业务 dao层
 * author:zz
 * createTime:2018-11-24 09:32
 */
public interface LoanDao {

    /**
     * 点击申请贷款，查询当前用户的信息
     * @param map
     * @return
     */
    Map getUserInfo(Map map);

    /**
     * 申请贷款，把申请贷款的信息存到数据库
     * @param map
     * @return
     */
    int applyForLoad(Map map);

    /**
     * 申请贷款，把房屋抵押贷款类型的信息存到数据库
     * @param map
     * @return
     */
    int houseLoans(Map map);

    /**
     * 查询是否已经贷款了
     * @return
     */
    Map selectloans(String username);

    /**
     * 申请贷款，把车辆抵押贷款类型的信息存到数据库
     * @param map
     * @return
     */
    int carLoans(Map map);

    /**
     * 申请贷款，把信用贷款类型的信息存到数据库
     * @param map
     * @return
     */
    /*int creditLoans(Map map);*/

    /**
     * 查询出还款逾期的信息
     * @return
     */
    @Select({"<script>" +
            " select * from (select rownum rn,t.LOANSID,t.USERID,t.USERNAME,t.LOANSMONEY,t.REFUNDWAY,"
            +" t.LOANSINTERESTRATE,t.REFUNDDEADLINE,t.TIME,round(sysdate-t.TIME) as OVERDUEDAY,t.LOANSTYPE,t.LOANSUSED,t.LOANSSTATE,t.REASON,"
            +" b.USERPHONE as up,b.IDENTITYCARD as CARD,"
            +" b.BANKCARDNUMBERS as BANKCARD,b.SITE as SITE,c.GLOBALVALUE as VALUE,c.HOUSEPROPERTY as HOUSE,"
            +" c.CARINFORMATION as CAR,c.APPRAISALREPORT as PORT FROM tb_loans t"
            +" join tb_userinformation b on b.USERID = t.USERID"
            +" join tb_loanstype c on c.LOANSID = t.LOANSID"
            +" where rownum &lt; #{end} and t.LOANSSTATE=10"
            +"<if test=\"loansId!=null and loansId!=''\"> and t.LOANSID like '%'||#{loansId}||'%' </if>"
            +"<if test=\"userName!=null and userName!=''\">and t.USERNAME like '%'||#{userName}||'%'</if>"
            +"<if test=\"loansType!=null and loansType!=0\">and t.LOANSTYPE=#{loansType}</if>"
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
            +"and LOANSSTATE=1"
            +"</where>"
            +"</script>"})
    int getPageCount(Map map);
}
