package com.group7.controller;

import com.group7.service.AccountService;
import com.group7.util.FileUtil.FileUpAndDown;
import com.group7.util.MapUtil.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:AccountController
 * Description:
 * Author:严浩天
 * CreateTime:2018-11-28 18:12
 */

@Controller
//@Api
@SuppressWarnings("all")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private HttpSession session;

    @Autowired
    private ResourceLoader resourceLoader;

    @javax.annotation.Resource
    private FileUpAndDown fileUpAndDown;

    /**
     * 账号信息页面
     * @return
     */
    @RequestMapping("/toGeRenZhongXinShouYe")
    public String accountList(){
        Object userSession = session.getAttribute("userSession");
        String userName = userSession+"";
        //获取账户总揽页面所需要的信息
        Map accountList = accountService.accountInfo(userName);
        //获取账户设置页面所需要的信息
        Map accountSet = accountService.accountSet(userName);
        System.out.println(accountList);
        accountList.put("userName",userName);
        //调用map合并工具类将两个map合并成一个map
        Map<String,Object> resultMap = MapUtil.mergeMaps(new Map[]{accountList,accountSet});
        System.out.println("测试合并后的map"+resultMap);
        session.setAttribute("accountList",resultMap);
        return "yirenbaopage/GRZX";
    }

    /**
     * 文件上传ftp服务器并返回文件名称
     * @param file
     * @return
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam MultipartFile file){
        //将传过来的图片上传到远程服务器
        //FileUpAndDown.getInstance().upLoad(file);
        String fileName = FileUpAndDown.getInstance().upLoad(file);
        return fileName;
    }

    /**
     * 图片显示方法
     * @param fileName
     * @return
     */
    @RequestMapping("/showFtp")
    public ResponseEntity showFtp(String fileName){
        System.out.println(fileName);
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            Resource resource = resourceLoader.getResource("ftp://ftpadmin:yanhaotian@39.96.8.65/images/"+fileName);
            return ResponseEntity.ok(resourceLoader.getResource("ftp://ftpadmin:yanhaotian@39.96.8.65/images/"+fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 判断用户输入的支付密码和数据库中的一致性
     * @param payPassword_rsainput 传过来的密码
     * @return
     */
    @RequestMapping("/pay")
    @ResponseBody
    public Map<String,String> payPwd(@RequestParam int payPassword_rsainput){
        Object userSession = session.getAttribute("userSession");
        String userName =userSession+"";
        //查找出来的用户支付密码
        int pwd = accountService.payPwd(userName);
        System.out.println("用户的密码:"+pwd);
        Map tempMap = new HashMap();
        if(pwd==payPassword_rsainput){
            tempMap.put("msg","success");
        }else{
            tempMap.put("msg","fail");
        }
        return tempMap;
    }

    /**
     * 充值成功后更新账户余额
     * @param dollar
     * @return
     */
    @RequestMapping("/charge")
    @ResponseBody
    public int charge(@RequestParam Integer dollar){
        System.out.println(session.getAttribute("accountList"));
        //从session中获取用户的账户信息 是一个map
        Object accountList = session.getAttribute("accountList");
        //将object转回成map
        Map tempAccount = (Map) session.getAttribute("accountList");
        //获取userinformationid
        Object o = tempAccount.get("USERINFORMATIONID");
        Integer userinformationid = Integer.valueOf(o  + "");
        Map tempMap = new HashMap();
        tempMap.put("money",dollar);
        tempMap.put("userinformationid",userinformationid);
        int charge = accountService.charge(tempMap);
        return charge;
    }

    /**
     * 获取用户头像
     * @return
     */
    @RequestMapping("/getImg")
    @ResponseBody
    public Map<String,String> getHeadImg(){
        Object userSession = session.getAttribute("userSession");
        String userName =userSession+"";
        System.out.println(userName+"用户名");
        //查找出来的用户支付密码
        String headPic = accountService.headPic(userName);
        System.out.println("用户的头像:"+headPic);
        Map tempMap = new HashMap();
        if(headPic!=null&&headPic!=""){
            //如果取到了头像，说明用户修改过头像，直接把数据库中存的头像给他
            tempMap.put("msg",headPic);
        }else{
            //如果取不到头像，说明可能是新注册的用户，给他一个默认头像
            tempMap.put("msg","touxiang4.jpg");
        }
        return tempMap;
    }

    /**
     * 修改用户头像方法
     * @param imgName
     * @return
     */
    @RequestMapping("/addImg")
    @ResponseBody
    public Map<String,String> addHeadImg(@RequestParam String imgName){
        System.out.println(imgName+"图片的名称传过来了");
        Map accountList =(Map)session.getAttribute("accountList");
        Integer o = Integer.valueOf(accountList.get("USERINFORMATIONID")+"");
        Map tempMap = new HashMap();
        tempMap.put("imgName",imgName);
        tempMap.put("userinformationid",o);
        int i = accountService.addHeadPic(tempMap);
        Map<String,String> msgMap = new HashMap();
        if(i>0){
            msgMap.put("msg","修改头像成功");
        }else{
            msgMap.put("msg","修改头像失败");
        }
        return msgMap;
    }

    /**
     * 账号信息页面
     * @return
     */
    @RequestMapping("/toGRZXZhangHao")
    public String accountSet(Model model){
        Object userSession = session.getAttribute("userSession");
        String userName = userSession+"";
        //获取账户总揽页面所需要的信息
//        Map accountList = accountService.accountInfo(userName);
        //获取账户设置页面所需要的信息
        Map accountSet = accountService.accountSet(userName);
        String phone=accountSet.get("USERPHONE")+"";
        String password=accountSet.get("PASSWORD")+"";
        model.addAttribute("phone",phone);
        model.addAttribute("password",password);
//        System.out.println(accountList);
//        accountList.put("userName",userName);
        //调用map合并工具类将两个map合并成一个map
//        Map<String,Object> resultMap = MapUtil.mergeMaps(new Map[]{accountList,accountSet});
//        session.setAttribute("accountList",resultMap);
        return "yirenbaopage/个人中心-账户设置";
    }

    /**
     * 更换用户手机号
     * @param newPhone
     * @return
     */
    @RequestMapping("/changePhone")
    @ResponseBody
    public Map<String, String> changePhone(@RequestParam String newPhone){
        //从session中取出userName
        Object userSession = session.getAttribute("userSession");
        //将userName转换成String
        String userName =userSession+"";
        //获取session中存放的所有账户信息并转换回map类型
        Map accountList =(Map)session.getAttribute("accountList");
        //获取用户的手机号（和密码）数据来源于数据库中 是最新的数据
        Map accountSet = accountService.accountSet(userName);
        //从map中取出用户手机号
        String userphone = accountSet.get("USERPHONE")+"";
        //将从session中取出的userinformationid转换成integer类型
        Integer o = Integer.valueOf(accountList.get("USERINFORMATIONID")+"");
        Map tempMap = new HashMap();
        tempMap.put("phone",newPhone);
        tempMap.put("userinformationid",o);
        int i = accountService.changePhone(tempMap);
        Map<String,String> msgMap = new HashMap();
        if(i>0){
            msgMap.put("msg","success");
            msgMap.put("newP",userphone);
            session.setAttribute("USERPHONE",newPhone);
        }else{
            msgMap.put("msg","fail");
        }
        return msgMap;
    }

    /**
     * 更新密码
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping("/changePwd")
    @ResponseBody
    public Map<String, String> changePwd(@RequestParam String oldPwd,String newPwd){
        //从session中取出userName
        Object userSession = session.getAttribute("userSession");
        //将userName转换成String
        String userName =userSession+"";
        //获取session中存放的所有账户信息并转换回map类型
        Map accountList =(Map)session.getAttribute("accountList");
        //获取用户的手机号（和密码）数据来源于数据库中 是最新的数据
        Map accountSet = accountService.accountSet(userName);
        //从map中取出用户密码
        String userPwd = accountSet.get("PASSWORD")+"";
        //创建一个userMap进行方法操作
        Map userMap = new HashMap();
        //创建返回值的map
        Map tempMap = new HashMap();
        if(!oldPwd.equals(userPwd)){
            System.out.println("输入的原来的密码："+oldPwd+"-----原来的密码："+userPwd);
            //输入的原密码错误
            tempMap.put("msg","fail");
            System.out.println("错误");
        }else{
            System.out.println("新密码"+newPwd);
            userMap.put("password",newPwd);
            userMap.put("userName",userName);
            accountService.changePwd(userMap);
            //密码正确 更新成功
            tempMap.put("msg","success");
            System.out.println("成功");

        }
        return tempMap;
    }
}
