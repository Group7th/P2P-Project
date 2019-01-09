package com.group7.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 图表
 */
public interface diagramDao {

    /**
     * 获取12个月的贷款信息
     * @return
     */
    @Select({"<script>"+
            "   select sum(a.loansmoney) as money,to_char(b.month,'yyyy-mm') as yuefen from (select * from tb_loans ) a right join  tb_yue b on\n" +
            " to_char(b.month,'yyyy-mm')=to_char(a.begintime,'yyyy-mm') \n" +
            "  group by to_char(b.month,'yyyy-mm') order by to_char(b.month,'yyyy-mm') asc "+
            "</script>"})
    List<Map> getDaikuan();

    /**
     * 获取12个月的还款信息
     * @return
     */
    @Select({"<script>"+
            "   select sum(a.refundmoney) as money,to_char(b.month,'yyyy-mm') as yuefen from (select * from tb_refund ) a right join  tb_yue b on\n" +
            " to_char(b.month,'yyyy-mm')=to_char(a.refunddate,'yyyy-mm') \n" +
            "  group by to_char(b.month,'yyyy-mm') order by to_char(b.month,'yyyy-mm') asc "+
            "</script>"})
    List<Map> getHuankuan();

    /**
     * 获取12个月充值信息
     * @return
     */
    @Select({"<script>"+
            "   select sum(a.WATERCOURSEMONEY) as money,to_char(b.month,'yyyy-mm') as yuefen from (select * from tb_moneyrecord where WATERCOURSETYPE='充值' ) a right join  tb_yue b on\n" +
            " to_char(b.month,'yyyy-mm')=to_char(a.WATERCOURSETIME,'yyyy-mm') \n" +
            "  group by to_char(b.month,'yyyy-mm') order by to_char(b.month,'yyyy-mm') asc "+
            "</script>"})
    List<Map> getChongChi();


    /**
     * 获取12个月的提现信息
     * @return
     */
    @Select({"<script>"+
            " select sum(a.WATERCOURSEMONEY) as money,to_char(b.month,'yyyy-mm') as yuefen from (select * from tb_moneyrecord where WATERCOURSETYPE='提现' ) a right join  tb_yue b on\n" +
            " to_char(b.month,'yyyy-mm')=to_char(a.WATERCOURSETIME,'yyyy-mm') \n" +
            "  group by to_char(b.month,'yyyy-mm') order by to_char(b.month,'yyyy-mm') asc "+
            "</script>"})
    List<Map> getTiXian();

}
