package com.group7.service;

import java.util.List;
import java.util.Map;

/**
 * 锦囊
 */
public interface JinNangService {

    /**
     * 获取登陆人id
     * @param userName
     * @return
     */
    int getId(String userName);

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
    int getCommentCount(Map map);

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
     * 获取投资类型分析
     * @param id
     * @return
     */
    List<Map> getTouZiLieXingFenXi(int id);

    /**
     * 获取借款类型分析
     * @param id
     * @return
     */
    List<Map> getJieKuanLieXingFenXi(int id);

}
