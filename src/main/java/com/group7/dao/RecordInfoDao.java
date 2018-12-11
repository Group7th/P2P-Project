package com.group7.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
            +") a where a.rn &gt; #{start}"
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
}
