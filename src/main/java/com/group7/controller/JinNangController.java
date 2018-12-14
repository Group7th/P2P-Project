package com.group7.controller;


import com.group7.service.JinNangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用于锦囊
 * 申恩
 */
@Controller
public class JinNangController {

    @Autowired
    private JinNangService jinNangService;


    /**
     * 添加一条锦囊
     * @param map
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("faBuJinNang")
    public int  faBuJinNang(@RequestBody Map map,HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userSession");
        int userId = jinNangService.getId(userName);
        map.put("userName",userName);
        map.put("userId",userId);
        return jinNangService.addJInNang(map);
    }


    /**
     * 获取锦囊列表
     * @return
     */
    @ResponseBody
    @RequestMapping("getJinNangListMap")
    public Object getJinNangListMap(@RequestBody Map map){
        map.put("type",1);

        List<Map> jinNangListMap = jinNangService.getJinNangListMap(map);
        int jinNangCount = jinNangService.getJinNangCount();
        System.out.println(jinNangCount);
        for (Map map2 :jinNangListMap) {
            int commentCount = jinNangService.getCommentCount(map2);
            map2.put("commentCount",commentCount);
            map2.put("jinNangCount",jinNangCount);
        }
        return jinNangListMap;
    }

    /**
     * 获取锦囊xinxi
     * @return
     */
    @ResponseBody
    @RequestMapping("getJinNangXinXi")
    public Object getJinNangXinXi(@RequestParam Map map){
        int commentCount = jinNangService.getCommentCount(map);
        List<Map> jinNangListMap = jinNangService.getJinNangById(map);
        map.put("commentCount",commentCount);
        jinNangListMap.add(map);
        return jinNangListMap;
    }

    /**
     * 添加评论
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("addComment")
    public Object addComment(@RequestBody Map map,HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userSession");
        int userId = jinNangService.getId(userName);
        map.put("userId",userId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        map.put("datatime",df.format(new Date()));
        return jinNangService.addComment(map);
    }

    /**
     * 获取评论列表
     * @return
     */
    @ResponseBody
    @RequestMapping("getCommentList")
    public Object getCommentList(@RequestParam Map map){
        return jinNangService.commentList(map);
    }

    @ResponseBody
    @RequestMapping("getSSCWXinXi")
    public Object getSSCWXinXi(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userSession");
        int id = jinNangService.getId(userName);//获取登陆人的id

        //定义maps 用来存放投资信息
        Map touZiMap = new LinkedHashMap();
        List<Map> charts = jinNangService.getTouZiCWFenXi(id);
        for (Map map:charts) {
            if(map.get("MONEY")==null){
                map.put("MONEY",0);
            }
            touZiMap.put(map.get("YUEFEN"),map.get("MONEY"));
        }

        Map jieKuanMap = new LinkedHashMap();
        List<Map> jieKuanCWFenXi = jinNangService.getJieKuanCWFenXi(id);
        for (Map map:jieKuanCWFenXi) {
            if(map.get("MONEY")==null){
                map.put("MONEY",0);
            }
            jieKuanMap.put(map.get("YUEFEN"),map.get("MONEY"));
        }


        Map JieKuanMapLieXing = new LinkedHashMap();
        List<Map> touZiMapLieXingList = jinNangService.getTouZiLieXingFenXi(id);
        String LOANSTYPE="";
        for (Map map:touZiMapLieXingList) {
            if (map.get("LOANSTYPE")!=null&&map.get("LOANSTYPE")!=""){
                    if(Integer.valueOf(map.get("LOANSTYPE")+"")==1){
                        LOANSTYPE ="房屋抵押贷款";
                    }
                    if(Integer.valueOf(map.get("LOANSTYPE")+"")==2){
                         LOANSTYPE ="车辆抵押贷款";
                    }if(Integer.valueOf(map.get("LOANSTYPE")+"")==3){
                         LOANSTYPE ="征信贷款";
                    }
            }
            JieKuanMapLieXing.put(LOANSTYPE,map.get("MONEY"));
        }

        Map touZiMapLieXing = new LinkedHashMap();
        List<Map> jieKuanCWFenXi1 = jinNangService.getJieKuanLieXingFenXi(id);
        String LOANSTYPES="";
        for (Map map:jieKuanCWFenXi1) {
                if (map.get("LOANSTYPE")!=null&&map.get("LOANSTYPE")!=""){
                        if(Integer.valueOf(map.get("LOANSTYPE")+"")==1){
                            LOANSTYPES ="房屋抵押贷款";
                        }
                        if(Integer.valueOf(map.get("LOANSTYPE")+"")==2){
                            LOANSTYPES ="车辆抵押贷款";
                        }if(Integer.valueOf(map.get("LOANSTYPE")+"")==3){
                            LOANSTYPES ="征信贷款";
                        }
                 }
            touZiMapLieXing.put(LOANSTYPES,map.get("MONEY"));
        }


        List<Map> dataListMap = new ArrayList<>();
        dataListMap.add(touZiMap);
        dataListMap.add(jieKuanMap);
        dataListMap.add(touZiMapLieXing);
        dataListMap.add(JieKuanMapLieXing);
        return dataListMap;
    }

    /**
     * 锦囊管理
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("getJinNangGUanLi")
    public Object getJinNangGUanLi(@RequestBody Map map){
        Map maps = new HashMap();
        maps.put("data",jinNangService.getJinNangListMap(map));
        maps.put("total",jinNangService.getJinNangCount());
        return maps;
    }

    /**
     * 删除
     * @param ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteJinNang")
    public Object delectJinNang(@RequestParam Integer ID){
        return jinNangService.deleteJinNang(ID);
    }

    /**
     * 批量删除锦囊
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteJinNangSS/{ids}")
    public Object deleteJinNangSS(@PathVariable("ids") String[] ids){
        return jinNangService.deleteJinNangS(ids);
    }
}


