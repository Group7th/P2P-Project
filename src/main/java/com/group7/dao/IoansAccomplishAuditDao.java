package com.group7.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:IoansAccomplishAuditDao
 * discriptoin:
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
                            +"(select * from tb_loans a "
                            + "join  tb_loanstype b on a.loansid=b.loansid "
                            + "join tb_userinformation c on a.userid = c.userid "
                            + "where loansmoney = investmentamount and  loansstate = 2 "
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
}
