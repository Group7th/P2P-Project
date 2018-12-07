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
}
