package com.group7.serviceImpl;


import com.group7.dao.NoticeDao;
import com.group7.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 公告信息
 * 申恩
 */
@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Map> getNotice(Map map) {
        return noticeDao.getNotice(map);
    }
}
