package com.group7.dao;

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
}
