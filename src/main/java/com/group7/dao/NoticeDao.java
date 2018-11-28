package com.group7.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 公告信息Dao接口
 * 申恩
 */
@Component
public interface NoticeDao {

    /**
     * 获取公告信息
     * @param map
     * @return
     */
    List<Map> getNotice(Map map);

}
