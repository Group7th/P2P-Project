package com.group7.service;

import java.util.List;
import java.util.Map;


/**
 * 公告信息
 * 申恩
 */
public interface NoticeService {


    /**
     * 获取公告信息
     * @param map
     * @return
     */
    List<Map> getNotice(Map map);

}
