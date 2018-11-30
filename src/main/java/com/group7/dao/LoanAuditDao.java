package com.group7.dao;

import org.apache.ibatis.annotations.Select;

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
			"select * from (select rownum rn,t.* from tb_loans t where rownum &lt; #{end} "
			+"<if test=\"loansId!=null and loansId!=''\"> and LOANSID=#{loansId} </if>"
			+"<if test=\"userName!=null and userName!=''\">and USERNAME like '%'||#{userName}||'%'</if>"
			+"<if test=\"loansType!=null and loansType!=0\">and LOANSTYPE=#{loansType}</if>"
			+") a where a.rn &gt; #{start} and LOANSSTATE=1 "
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
}
