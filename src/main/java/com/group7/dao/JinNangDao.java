package com.group7.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 锦囊Dao
 */
public interface JinNangDao {

    /**
     * 根据用户名获取id
     * @param userName
     * @return
     */
    List<Map> getId(String userName);

    /**
     * 添加一条锦囊
     * @param map
     * @return
     */
    int addJInNang(Map map);

    /**
     * 获取锦囊列表
     * @return
     */
    List<Map> getJinNangListMap(Map map);


    /**
     * 获取锦囊总数量
     * @return
     */
    @Select({"<script>" +" select count(*) from tb_jinnang" +
            " <if test=\"HEADLINE!=null and HEADLINE!=''\"> and a.HEADLINE like '%'||#{HEADLINE}||'%'</if>" +
            " <if test=\"USERNAME!=null and USERNAME!=''\"> and b.USERNAME like '%'||#{USERNAME}||'%'</if>"
            + "</script>"})
    int getJinNangCount();

    /**
     * 删除公告
     * @param ID
     * @return
     */
    @Delete("delete from tb_jinnang where id=#{ID}")
    int deleteJinNang(Integer ID);

    @Delete("<script>" +
            "delete from tb_jinnang where id in" +
            "<foreach item=\"item\" index=\"index\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">"+
            "#{item}"+
            "</foreach>"+
            "</script>")
    int deleteJinNangS(String[] ids);

    /**
     * 根据ID获取锦囊
     * @param map
     * @return
     */
    @Select({"<script>" +" select  a.*,b.username,c.HEADPORTRAIT from tb_jinnang  a,tb_user b,tb_userinformation c where a.issuer_id=b.id and a.issuer_id=c.userid and a.id=#{ID} " + "</script>"})
    List<Map> getJinNangById(Map map);

    /**
     * 添加评论
     * @param map
     * @return
     */
    int addComment(Map map);

    /**
     *评论列表
     * @param map
     * @return
     */
    List<Map> commentList(Map map);

    /**
     * 获取评论数量
     * @param map
     * @return
     */
    List<Map> getCommentCount(Map map);


    /**
     * 获取投资财务分析
     * @param id
     * @return
     */
    List<Map> getTouZiCWFenXi(int id);

    /**
     * 获取借款财务分析
     * @param id
     * @return
     */
    List<Map> getJieKuanCWFenXi(int id);


    /**
     * 获取借款类型分析
     * @param id
     * @return
     */
    List<Map> getTouZiLieXingFenXi(int id);

    /**
     * 获取投资类型分析
     * @param id
     * @return
     */
    List<Map> getJieKuanLieXingFenXi(int id);




}
