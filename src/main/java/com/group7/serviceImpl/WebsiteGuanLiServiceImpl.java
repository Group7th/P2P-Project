package com.group7.serviceImpl;

import com.group7.dao.WebsiteGuanLiDao;
import com.group7.service.WebsiteGuanLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WebsiteGuanLiServiceImpl implements WebsiteGuanLiService{
    //
    @Autowired
    private WebsiteGuanLiDao websiteGuanLiDao;

    @Override
    public List<Map> getnoticeGuanLi(Map map) {
        return websiteGuanLiDao.getnoticeGuanLi(map);
    }

    @Override
    public int getnoticeGuanLiCount(Map map) {
        return websiteGuanLiDao.getnoticeGuanLiCount(map);
    }

    @Override
    public int addNotice(Map map) {
        return websiteGuanLiDao.addNotice(map);
    }

    @Override
    public int updateNotice(Map map) {
        return websiteGuanLiDao.updateNotice(map);
    }

    @Override
    public int delectNotice(Integer ID) {
        return websiteGuanLiDao.delectNotice(ID);
    }

    @Override
    public int deleteNotices(String[] ids) {
        return websiteGuanLiDao.deleteNotices(ids);
    }
}
