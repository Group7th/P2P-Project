package com.group7.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RecordInfoDao
 * Description:
 * Author:严浩天
 * CreateTime:2018-12-08 16:37
 */

public interface RecordInfoDao {
    /**
     * 资金记录列表
     * @return
     */
    @Select({"<script>" +
            "select * from (select rownum rn,t.* from tb_moneyrecord t where rownum &lt; #{end} "
            +"<if test=\"watercoursetype!=null and watercoursetype!=''\"> and watercoursetype=#{watercoursetype} </if>"
            +"<if test=\"watercoursetime!=null and watercoursetime!=''\"> and ${watercoursetime}</if>"
            +"<if test=\"userid!=null and userid!=''\"> and userid=#{userid}</if>"
            +") a where a.rn &gt; #{start}  order by watercoursetime desc"
            +"</script>"})
    List<Map> moneyRecordList(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select({"<script>"
            +"select count(*) from tb_moneyrecord "
            +"<where>"
            +"<if test=\"watercoursetype!=null and watercoursetype!=''\"> and watercoursetype=#{watercoursetype} </if>"
            +"<if test=\"watercoursetime!=null and watercoursetime!=''\"> and  ${watercoursetime}</if>"
            +"<if test=\"userid!=null and userid!=''\"> and userid=#{userid}</if>"
            +"</where>"
            +"</script>"})
    int moneyRecordListCount(Map map);

    /**
     * 根据moneyrecord删除
     * @param moneyrecord
     * @return
     */
    @Delete("delete from tb_moneyrecord where moneyrecord=#{moneyrecord}")
    int deleteMoneyRecord(int moneyrecord);

    /**
     * 根据名字查找id
     * @param userName
     * @return
     */
    @Select("select id from tb_user where userName=#{userName}")
    int getId(String userName);

    /**
     * 根据userinformationid查找userid
     * @param userinformationid
     * @return
     */
    @Select("select userid from tb_userinformation where userinformationid=#{userinformationid}")
    int getUserIdByUserinformationId(int userinformationid);

    /**
     * 查找用户的累计投资
     * @param userid
     * @return
     */
    @Select("select sum(INVESTMENTMONEY) from TB_INVESTMENT where userid=#{userid}")
    Integer getSumInvestment(int userid);

    /**
     * 根据userinformationid查找累计收益
     * @param userinformationid
     * @return
     */
    @Select("select accruedincome,awaitmoney,awaitinterest from tb_useraccount where userinformationid=#{userinformationid}")
    Map getSumIncome(int userinformationid);

    /**
     * 投资记录列表
     * @param map
     * @return
     */
    @Select({"<script>"
            +"select *from "
            +"(select rownum rn, t.* from "
            +"(select a.*,b.loanstypename,c.loansstate  from tb_investment a join tb_loanstype b on a.loansid = b.loansid  join tb_loans c on c.loansid = a.loansid "
            +"where a.userId = #{userid} and a.loansId in (select loansId from tb_loans where loansstate = #{loansstate}) )  t "
            +"where rownum &lt; #{end} ) a "
            +"where a.rn &gt; #{start} "
            +"</script>"})
    List<Map> investList(Map map);

    /**
     * 投资记录列表分页总数量
     * @param map
     * @return
     */
    @Select({"<script>"
            +"select count(*)  from tb_investment a join tb_loanstype b on a.loansid = b.loansid "
            +"where userId = #{userid} and a.loansId in (select loansId from tb_loans where loansstate = #{loansstate})"
            +"</script>"})
    int investListCount(Map map);



    /**
     * 系统消息列表
     * @return
     */
    @Select({"<script>" +
            "select * from (select rownum rn,t.* from TB_MESSAGE t where rownum &lt; #{end} "
            +"<if test=\"userid!=null and userid!=''\"> and userid=#{userid}</if>"
            +"<if test=\"messagestate!=null and messagestate!=''\"> and messagestate=#{messagestate}</if>"
            +") a where a.rn &gt; #{start}  order by SENDTIME desc"
            +"</script>"})
    List<Map> systemMessageList(Map map);

    /**
     * 系统消息分页总数量
     * @param map
     * @return
     */
    @Select({"<script>"
            +"select count(*) from TB_MESSAGE "
            +"<where>"
            +"<if test=\"userid!=null and userid!=''\"> and userid=#{userid}</if>"
            +"<if test=\"messagestate!=null and messagestate!=''\"> and messagestate=#{messagestate}</if>"
            +"</where>"
            +"</script>"})
    int systemMessageListCount(Map map);

    /**
     * 根据moneyrecord删除
     * @param messageid
     * @return
     */
    @Delete("delete from tb_message where MESSAGEID=#{messageid}")
    int deleteMessageRecord(int messageid);

    /**
     * 将未读消息变为已读
     * @param map
     * @return
     */
    @Update("update tb_message set messagestate=#{messagestate} where userid=#{userid}")
    int changeMessageState(Map map);

    /**
     * 获取未读消息的数量
     * @return
     */
    @Select("select count(*) from tb_message where messagestate=1 and userid=#{userid}")
    int getUnreadCount(int userid);
}


