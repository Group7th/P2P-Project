package com.group7.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 后台网站管理
 * 申恩
 */

public interface WebsiteGuanLiDao {

    /**
     * 获取分页信息
     * @param map
     * @return
     */
    @Select({"<script> "
            + " select * from  (select t.*,rownum rn from tb_notice t where rownum &lt; #{end}" +
            "<if test=\"HEADLINE!=null and HEADLINE!=''\"> and HEADLINE like '%'||#{HEADLINE}||'%' </if>" +
            "<if test=\"OPERATOR!=null and OPERATOR!=''\"> and OPERATOR like '%'||#{OPERATOR}||'%' </if>" +
            ") a where a.rn &gt; #{start} order by time desc "
            +"</script>"})
    List<Map> getnoticeGuanLi(Map map);


    /**
     * 获取总数量
     * @param map
     * @return
     */
    @Select({
            "<script>" +" select count(*) from tb_notice  <where>" +
                    "<if test=\"HEADLINE!=null and HEADLINE!=''\"> and HEADLINE like '%'||#{HEADLINE}||'%' </if>" +
                    "<if test=\"OPERATOR!=null and OPERATOR!=''\"> and OPERATOR like '%'||#{OPERATOR}||'%' </if>"
                    +" </where></script>"
    })
    int getnoticeGuanLiCount(Map map);


    /**
     * 添加公告
     * @param map
     * @return
     */
    @Insert("insert into tb_notice values(seq_tb_notice_id.nextval,#{HEADLINE},#{CONTENT},sysdate,#{userName})")
    int addNotice(Map map);

    /**
     * 修改
     * @param map
     * @return
     */
    @Update("update tb_notice set headline=#{HEADLINE},content=#{CONTENT} where id=#{ID}")
    int updateNotice(Map map);

    /**
     * 删除公告
     * @param ID
     * @return//
     */
    @Delete("delete from tb_notice where id=#{ID}")
    int delectNotice(Integer ID);

    @Delete("<script>" +
            "delete from tb_notice where id in" +
            "<foreach item=\"item\" index=\"index\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">"+
            "#{item}"+
            "</foreach>"+
            "</script>")
    int deleteNotices(String[] ids);
}
