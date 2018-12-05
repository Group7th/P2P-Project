package com.group7.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:LoanAuditDao
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-28 20:39
 */
public interface LoanAuditDao {

	/**
	 * 贷款列表
	 * @param map
	 * @return
	 * 重点注意：注解动态sql要加"{}",要加script  大于小于号要&lt;
	 */
	@Select({"<script>" +
			" select * from (select rownum rn,t.LOANSID,t.USERID,t.USERNAME,t.LOANSMONEY,t.REFUNDWAY,"
			+" t.LOANSINTERESTRATE,t.REFUNDDEADLINE,t.BEGINTIME,t.LOANSTYPE,t.LOANSUSED,t.LOANSSTATE,t.REASON,"
			+" b.USERPHONE as up,b.IDENTITYCARD as CARD,"
			+" b.BANKCARDNUMBERS as BANKCARD,b.SITE as SITE,c.GLOBALVALUE as VALUE,c.HOUSEPROPERTY as HOUSE,"
			+" c.CARINFORMATION as CAR,c.APPRAISALREPORT as PORT FROM tb_loans t"
			+" join tb_userinformation b on b.USERID = t.USERID"
			+" join tb_loanstype c on c.LOANSID = t.LOANSID"
			+" where rownum &lt; #{end} and t.LOANSSTATE=1"
			+"<if test=\"loansId!=null and loansId!=''\"> and t.LOANSID like '%'||#{loansId}||'%' </if>"
			+"<if test=\"userName!=null and userName!=''\">and t.USERNAME like '%'||#{userName}||'%'</if>"
			+"<if test=\"loansType!=null and loansType!=0\">and t.LOANSTYPE=#{loansType}</if>"
			+" ) a where a.rn &gt; #{start}"
			+"</script>"})
	List<Map> getList(Map map);

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


	/**
	 * 审核通过
	 * @param LOANSSTATE
	 * @param LOANSID
	 * @return
	 */
	@Update({"<script>"
			+" update tb_loans set LOANSSTATE = #{lt} where LOANSID=#{ls} "
			+"</script>"})
	int update(@Param("lt") Integer LOANSSTATE,@Param("ls") Integer LOANSID);

	/**
	 * 招标审核驳回 修改状态 存入驳回理由
	 * @param REASON
	 * @param LOANSSTATE
	 * @param LOANSID
	 * @return
	 */
	@Update({"<script>"
			+"update tb_loans set REASON = #{rs},LOANSSTATE = #{lt} where LOANSID=#{ls}"
			+"</script>"})
	int reject(@Param("rs") String REASON,@Param("lt") Integer LOANSSTATE,@Param("ls") Integer LOANSID  );

}
