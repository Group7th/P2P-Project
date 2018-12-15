package com.group7.service;



import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

public interface WebsiteGuanLiService {

    /**
     * 获取分页信息
     * @param map
     * @return
     */
    List<Map> getnoticeGuanLi(Map map);


    /**
     * 获取总数量
     * @param map
     * @return
     */

    int getnoticeGuanLiCount(Map map);


    /**
     * 添加公告
     * @param map
     * @return
     */
    int addNotice(Map map);

    /**
     * 修改//公告
     * @param map
     * @return
     */
    int updateNotice(Map map);

    int delectNotice(Integer ID);

    int deleteNotices(String[] ids);
}
