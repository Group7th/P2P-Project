package com.group7.serviceImpl;

import com.group7.dao.JinNangDao;
import com.group7.service.JinNangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JInNangServiceImpl implements JinNangService {

    @Autowired
    private JinNangDao jinNangDao;


    @Override
    public int getId(String userName) {
        List<Map> ListMap = jinNangDao.getId(userName);
        int userId =Integer.valueOf( ListMap.get(0).get("ID")+"");
        return userId;
    }

    @Override
    public int addJInNang(Map map) {
        return jinNangDao.addJInNang(map);
    }

    @Override
    public List<Map> getJinNangListMap(Map map) {
        return jinNangDao.getJinNangListMap(map);
    }
}
