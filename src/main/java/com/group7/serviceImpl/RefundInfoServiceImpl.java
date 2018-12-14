package com.group7.serviceImpl;

import com.group7.dao.RefundInfoDao;
import com.group7.service.RefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:RefundInfoImpl
 * discriptoin:
 * author:邢博
 * createTime:2018-12-13 14:13
 */
@Service
public class RefundInfoServiceImpl implements RefundInfoService {

    /**
     * 依赖注入
     */
    @Autowired
    private RefundInfoDao refundInfoDao;
    /**
     *定时器调用还款的存储过程时返回的还款信息
     * @return
     */
    @Override
    public String getRefundInfo(Map map) {
        map.put("refundInfo","");
        String refundInfo = refundInfoDao.getRefundInfo(map);
        if (refundInfo==null&&"".equals(refundInfo)){
            return "";
        }else{
            return refundInfo;
        }
    }

    @Override
    public List<Map> getOverdueInfo(Map map) {
        return refundInfoDao.getOverdueInfo(map);
    }

    @Override
    public int getPageCount(Map map) {
        return refundInfoDao.getPageCount(map);
    }
}
