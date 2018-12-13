package com.group7.serviceImpl;

import com.group7.service.RefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private RefundInfoService refundInfoService;
    /**
     *定时器调用还款的存储过程时返回的还款信息
     * @return
     */
    @Override
    public String getRefundInfo() {
        return refundInfoService.getRefundInfo();
    }
}
