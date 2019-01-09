package com.group7.serviceImpl;

import com.group7.dao.diagramDao;
import com.group7.service.diagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 图表服务实现类
 */
@Service
public class diagramServiceImpl implements diagramService {

    @Autowired
    private diagramDao diagramdao;

    @Override
    public List<Map> getDaikuan() {
        return diagramdao.getDaikuan();
    }

    @Override
    public List<Map> getHuankuan() {
        return diagramdao.getHuankuan();
    }

    @Override
    public List<Map> getChongChi() {
        return diagramdao.getChongChi();
    }

    @Override
    public List<Map> getTiXian() {
        return diagramdao.getTiXian();
    }
}
