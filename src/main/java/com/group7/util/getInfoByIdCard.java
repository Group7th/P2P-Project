package com.group7.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:getInfoByIdCard
 * Description:
 * Author:严浩天
 * CreateTime:2018-12-06 13:02
 */
@Component
public class getInfoByIdCard {
    /**
     * 根据身份证号返回家庭地址、性别和出生年月日
     * @param idCardNum
     * @return
     */
    public Map<String,Object> getIdCard(String idCardNum){
        System.out.println(idCardNum+"进入到了工具中");
        String s = (new ShowApiRequest("http://route.showapi.com/25-3", "76850", "3ae9b0a4bcb346dabeca64447a7406f4"))
                .addTextPara("id", "410522199705304710")
                .post();
        JSONObject jsStr = JSONObject.parseObject(s);
        JSONObject showapi_res_body=jsStr.getJSONObject("showapi_res_body");
        JSONObject retData = showapi_res_body.getJSONObject("retData");
        String address = retData.getString("address");
        System.out.println(address+"工具类中的地址");
        String sex = retData.getString("sex");
        String birthday = retData.getString("birthday");
        Map<String,Object> infoMap = new HashMap();
        infoMap.put("address",address);
        infoMap.put("birthday",birthday);
        if(sex.equals("M")){
            infoMap.put("sex",1);
        }
        if(sex.equals("F")){
            infoMap.put("sex",2);
        }
        return infoMap;
    }
}
