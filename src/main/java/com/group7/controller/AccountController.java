package com.group7.controller;

import com.group7.service.AccountService;
import com.group7.util.FileUtil.FileUpAndDown;
import com.group7.util.MapUtil.MapUtil;
import com.group7.util.getInfoByIdCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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

    @javax.annotation.Resource
    private getInfoByIdCard getInfoByIdCard;

    /**
     * 账号信息页面
     * @return
     */
    @RequestMapping("/toGeRenZhongXinShouYe")
    public String accountList(Model model){
        Object userSession = session.getAttribute("userSession");
        String userName = userSession+"";
        //获取账户总揽页面所需要的信息
        Map accountList = accountService.accountInfo(userName);
        //获取账户设置页面所需要的信息
        Map accountSet = accountService.accountSet(userName);
        //自动拆箱
        int userAccountId = Integer.valueOf(accountList.get("USERACCOUNTID")+"");
        //根据账户id查找用户信息id
        int userInformatioId = accountService.getUserInformatioId(userAccountId);
        //获取用户的认证状态
        int state = accountService.getState(userInformatioId);
        //放入model中实时取值
        model.addAttribute("state",state);
        accountList.put("state",state);
        accountList.put("userName",userName);
        //调用map合并工具类将两个map合并成一个map
        Map<String,Object> resultMap = MapUtil.mergeMaps(new Map[]{accountList,accountSet});
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
        Object userSession = session.getAttribute("userSession");
        //获取用户名
        String userName = userSession+"";
        //从session中获取用户的账户信息 是一个map
        Object accountList = session.getAttribute("accountList");
        //将object转回成map
        Map tempAccount = (Map) session.getAttribute("accountList");
        //获取userinformationid
        Object o = tempAccount.get("USERINFORMATIONID");
        Integer userinformationid = Integer.valueOf(o  + "");
        //根据用户名获取用户的id
        int id = accountService.getIdByUserName(userName);
        Map tempMap = new HashMap();
        tempMap.put("money",dollar);
        tempMap.put("userinformationid",userinformationid);
        int charge = accountService.charge(tempMap);
        Map recordMap = new HashMap();
        //交易金额
        recordMap.put("watercoursemoney",dollar);
        //userid
        recordMap.put("userid",id);
        //根据userinformationid查询用户交易后的余额
        double availMoney = accountService.getAvailMoney(userinformationid);
        //余额
        recordMap.put("balance",availMoney);
        accountService.addChargeRecord(recordMap);
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
        //查找出来的用户支付密码
        String headPic = accountService.headPic(userName);
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
        Map accountList =(Map)session.getAttribute("accountList");
        //将从session中取出的userinformationid转换成integer类型
        Integer o = Integer.valueOf(accountList.get("USERINFORMATIONID")+"");
        int state = accountService.getState(o);
        //获取用户支付密码
        String payPwd = accountService.getPayPwd(o);
        String phone=accountSet.get("USERPHONE")+"";
        String password=accountSet.get("PASSWORD")+"";
        String bankcardnumbers=accountSet.get("BANKCARDNUMBERS")+"";
        model.addAttribute("payPwd",payPwd);
        model.addAttribute("phone",phone);
        model.addAttribute("password",password);
        model.addAttribute("state",state);
        model.addAttribute("bankcardnumbers",bankcardnumbers);
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
            //输入的原密码错误
            tempMap.put("msg","fail");
        }else{
            userMap.put("password",newPwd);
            userMap.put("userName",userName);
            accountService.changePwd(userMap);
            //密码正确 更新成功
            tempMap.put("msg","success");
        }
        return tempMap;
    }

    /**
     * 绑定银行卡号
     * @param bankNum
     * @return
     */
    @RequestMapping("/addBankNumbers")
    @ResponseBody
    public Map<String,String> bankCardNums(@RequestParam String bankNum){
        //从session中获取用户的账户信息 是一个map
        Object accountList = session.getAttribute("accountList");
        //将object转回成map
        Map tempAccount = (Map) session.getAttribute("accountList");
        //获取userinformationid
        Object o = tempAccount.get("USERINFORMATIONID");
        //将userinformationid从Object转换为integer类型
        Integer userinformationid = Integer.valueOf(o+"");
        int i = accountService.addBankNums(bankNum, userinformationid);
        Map msgMap = new HashMap();
        if(i>0){
            msgMap.put("msg","success");
        }else {
            msgMap.put("msg","fail");
        }
        return msgMap;
    }

    /**
     * 修改用户支付密码
     * @param newPayPwd
     * @return
     */
    @RequestMapping("/changePayPwd")
    @ResponseBody
    public Map<String,String> changePayPwd(@RequestParam String newPayPwd,String oldPayPwd){
        //从session中获取用户的账户信息 是一个map
        Object accountList = session.getAttribute("accountList");
        //将object转回成map
        Map tempAccount = (Map) session.getAttribute("accountList");
        //获取userinformationid
        Object o = tempAccount.get("USERINFORMATIONID");
        //将userinformationid从Object转换为integer类型
        Integer userinformationid = Integer.valueOf(o+"");
        //获取用户数据库中的支付密码
        String payPwd = accountService.getPayPwd(userinformationid);
        //创建一个map当返回参数
        Map msgMap = new HashMap();
        //判断用户输入的原密码和数据库中的密码是否一致
        if(payPwd.equals(oldPayPwd)){
            //如果密码一致 进行修改支付密码操作
            int i = accountService.changePayPwd(newPayPwd, userinformationid);
            if(i>0){
                msgMap.put("msg","success");
            }else {
                msgMap.put("msg","fail");
            }
        }else{
            //输入的原密码与数据库中的密码不一致
            msgMap.put("msg","deny");
        }
        return msgMap;
    }

    /**
     * 身份证验证方法(省略了OCR接口验证)
     * @param realName
     * @param idNum
     * @param front
     * @param behind
     * @return
     */
    @RequestMapping("/identityIdCard")
    //@ResponseBody
    public String IdCard(@RequestParam String realName,
                         String idNum,
                         MultipartFile front,
                         MultipartFile behind,
                         Model model,
                         String education,
                         String marriage,
                         String basicIncome) {
        //OCR身份证识别
//        String res=new ShowApiRequest("http://route.showapi.com/1429-1","76850","3ae9b0a4bcb346dabeca64447a7406f4")
//                .addTextPara("imgData","")
//                .addTextPara("type","")
//                .post();
        //从session中获取用户的账户信息 是一个map
        Object accountList = session.getAttribute("accountList");
        //将object转回成map
        Map tempAccount = (Map) session.getAttribute("accountList");
        //获取userinformationid
        Object o = tempAccount.get("USERINFORMATIONID");
        //将userinformationid从Object转换为integer类型
        Integer userinformationid = Integer.valueOf(o+"");
        //调用身份证查询方法 根据身份证号识别籍贯性别等信息
        Map<String, Object> idCardMap = getInfoByIdCard.getIdCard(idNum);
        //接口方法返回来的性别
        String sex = idCardMap.get("sex")+"";
        String address = idCardMap.get("address")+"";
        //出生年月日信息
        String birthday = idCardMap.get("birthday")+"";
        //将验证信息存入到数据库
        accountService.addIdCardNum(realName,sex,idNum,address,education,marriage,basicIncome,birthday,userinformationid);
        //创建一个tempMap当返回值带参
        Map tempMap = new HashMap();
        //创建一个imgMap传入方法中 将图片地址插入数据库
        Map imgMap = new HashMap();
        //创建一个stateMap传入更新状态方法中
        Map stateMap = new HashMap();
        //将传过来的身份证图片正反面上传到远程ftp服务器
        String frontImgName = FileUpAndDown.getInstance().upLoad(front);
        String behindImgName = FileUpAndDown.getInstance().upLoad(behind);
        //将3个参数传入imgMap中执行mybatis的sql语句
        imgMap.put("userinformationid",userinformationid);
        imgMap.put("frontImgName",frontImgName);
        imgMap.put("behindImgName",behindImgName);
        //上传认证信息后先更新成待审核状态1
        stateMap.put("certification",1);
        stateMap.put("userinformationid",userinformationid);
        //将身份证图片路径添加到数据库
        int i = accountService.addIdCard(imgMap);

        //将性别、身份证号码和家庭地址存入到数据库
//        accountService.addIdCardNum(realName,sex,idNum,address,userinformationid);
        String msg="";
        if(1>0) {
            msg="success";
            tempMap.put("msg","success");
            //认证通过更新状态码
            accountService.changeState(stateMap);
        }else{
            msg="fail";
            tempMap.put("msg","fail");
        }
        model.addAttribute("msg",msg);
        return "backStage/IDCardIdentity";
    }

    /**
     * 提现
     * @param actualMoney
     * @return
     */
    @RequestMapping("/withdraw")
    @ResponseBody
    public Map<String,String> withdraw(@RequestParam double actualMoney,double costMoney){
        Object userSession = session.getAttribute("userSession");
        //获取用户名
        String userName = userSession+"";
        //从session中获取用户的账户信息 是一个map
        Object accountList = session.getAttribute("accountList");
        //将object转回成map
        Map tempAccount = (Map) session.getAttribute("accountList");
        //获取userinformationid
        Object o = tempAccount.get("USERINFORMATIONID");
        //将userinformationid从Object转换为integer类型
        Integer userinformationid = Integer.valueOf(o+"");
        int i = accountService.withdraw(actualMoney,costMoney,userinformationid);
        //new一个记录表的map
        Map recordMap = new HashMap();
        //根据用户名获取用户id
        int id = accountService.getIdByUserName(userName);
        //用户id
        recordMap.put("userid",id);
        //交易金额=提现费用+手续费
        double watercoursemoney = actualMoney+costMoney;
        //交易金额放入记录表的map中
        recordMap.put("watercoursemoney",watercoursemoney);
        //余额 根据userinformationid查询余额
        double availMoney = accountService.getAvailMoney(userinformationid);
        recordMap.put("balance",availMoney);
        accountService.withdrawRecord(recordMap);
        Map msgMap = new HashMap();
        if(i>0){
            //提现成功后将手续费添加到资金池
            accountService.addFeeToPool(costMoney);
            msgMap.put("msg","success");
        }else{
            msgMap.put("msg","fail");
        }
        return msgMap;
    }

    /**
     * 提现页面
     * @param model
     * @return
     */
    @RequestMapping("toGRZXTiXian1")
    public String toGRZXTiXian1(Model model){
        //从session中获取用户的账户信息 是一个map
        Object accountList = session.getAttribute("accountList");
        //将object转回成map
        Map tempAccount = (Map) session.getAttribute("accountList");
        //获取userinformationid
        Object o = tempAccount.get("USERINFORMATIONID");
        //将userinformationid从Object转换为integer类型
        Integer userinformationid = Integer.valueOf(o+"");
        //查询用户的可用余额
        double availMoney = accountService.getAvailMoney(userinformationid);
        model.addAttribute("availMoney",availMoney);
        return "yirenbaopage/个人中心-提现";
    }

    /**
     * 后台审核信息列表数据
     * @return
     */
    @RequestMapping("/IdentityAudit")
    @ResponseBody
    public Map IdentityAudit(@RequestBody Map map){
        System.out.println("当前的map"+map);
            Map rmap=new HashMap();
            rmap.put("data",accountService.identityAudit(map));
            rmap.put("total",accountService.identityAuditSum());
            System.out.println("--------------"+rmap);
            return rmap;
    }


    @RequestMapping("/toIdentityAudit")
    public String toIdentityAudit(){
        return "backStage/identityAudit";
    }

    /**
     * 后台审核通过方法
     * @param userinformationid
     * @return
     */
    @RequestMapping("/throughAuditing")
    @ResponseBody
    public Map throughAuditing(@RequestBody Map map){
        System.out.println("后台审核传过来的map");
        Map stateMap = new HashMap();
        Map flagMap = new HashMap();
        //上传认证信息后先更新成已通过状态2
        stateMap.put("certification",2);
        stateMap.put("userinformationid",Integer.valueOf(map.get("userinformationid")+""));
        //上传认证信息后先更新成已通过状态2
        int i = accountService.changeState(stateMap);
        Map sysMsgMap = new HashMap();
        sysMsgMap.put("messagetype","审核");
        sysMsgMap.put("messageContent","尊敬的客户，您好，您的实名认证审核已通过！请准守平台规则，合理消费，谨防上当受骗！");
        sysMsgMap.put("userid",Integer.valueOf(map.get("userid")+""));
        //审核通过给用户发送系统消息
        int i1 = accountService.addSysMsg(sysMsgMap);
        if(i>0&&i1>0){
            flagMap.put("msg","success");
        }else{
            flagMap.put("msg","fail");
        }
        return flagMap;
    }

    @RequestMapping("/addSysMsg")
    @ResponseBody
    public Map addSysMsg(@RequestBody Map map){
        Map msgMap = new HashMap();
        Map sysMsgMap = new HashMap();
        sysMsgMap.put("messagetype","审核");
        sysMsgMap.put("messageContent","尊敬的客户，您好，非常抱歉您的实名认证审核未通过！原因："+(map.get("reason")+""));
        sysMsgMap.put("userid",Integer.valueOf(map.get("userid")+""));
        //驳回后将通过状态变成未认证
        Map stateMap = new HashMap();
        //驳回后将通过状态变成未认证0
        stateMap.put("certification",0);
        stateMap.put("userinformationid",Integer.valueOf(map.get("userinformationid")+""));
        //更改成未认证状态
        accountService.changeState(stateMap);
        //将审核不通过的信息发送到系统消息
        int i = accountService.addSysMsg(sysMsgMap);
        if(i>0){
            msgMap.put("msg","success");
        }else{
            msgMap.put("msg","fail");
        }
        return msgMap;
    }

}
