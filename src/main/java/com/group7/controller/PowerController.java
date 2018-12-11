
package com.group7.controller;

import java.util.*;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.group7.dao.PowerDao;
import com.group7.entity.TreeNode;
import com.group7.service.PowerService;
import com.group7.serviceImpl.PowerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * className:InvestController
 * discriptoin:   权限树 和 后台登陆
 * author:ZHEN
 * createTime:2018-11-23 21:12
 */

@Controller
public class PowerController {

	@Autowired
	private PowerService powerservice;



	/**
	 * 后台登陆
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userLogin")
	public int userLogin(@RequestParam Map map, HttpSession session){
	//	System.out.println(map);
		int i = powerservice.toLogin(map);
		if(i>0){
			session.setAttribute("userName",map.get("username"));
		}
		//Object userName = session.getAttribute("userName");
		//System.out.println(userName);
		return i;
	}



	/**
	 * 左侧树
	 * @return
	 */
	@RequestMapping("/userPower")
	public String toIndex(Model model, HttpSession session){
		String userName = (session.getAttribute("userName")+"");
		List<TreeNode> parentList = powerservice.getPowersByUserId(userName);
		model.addAttribute("powerList", parentList) ;
		model.addAttribute("userName",userName);
		return "frontEnd/indexTo";
	}


	/**
	 * 角色列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/roleList")
	public Object roleList(@RequestParam Map paramMap){
		Map tempMap = new HashMap();
		tempMap.put("code",0);
		tempMap.put("msg","");
		tempMap.put("count",powerservice.getPageCount(paramMap));
		tempMap.put("data",powerservice.getList(paramMap));
		//System.out.println(tempMap);
		return tempMap;
	}

	/**
	 * 把从后取到的权限列表转成json数据，供前台easyui使用
	 * 带选择的权限树
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/powerCheckedTree")
	public Object powerCheckedTree(String roleId){
		List<TreeNode> treeNodes = powerservice.powerCheckedTree(roleId);
		//System.out.println(treeNodes);
		return treeNodes;
	}

	/**
	 * 保存角色权限关联
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveRolePower")
	public Object saveRolePower(@RequestParam Map paramMap){
		//System.out.println(paramMap);
		int saveRolePower = powerservice.saveRolePower(paramMap);
		return saveRolePower;
	}

	/**
	 *  修改 角色管理
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/up")
	public Object up(@RequestParam Map map){
		//System.out.println("....."+roleId);
		int up = powerservice.up(map);
		//System.out.println(up);
		return up;
	}
	/**
	 *  删除 角色管理
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/de")
	public Object de(@RequestParam Map map){
		//System.out.println(map);
		return powerservice.de(map);
	}
	/**
	 *  添加 角色管理
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Object add(@RequestParam Map map){
		//System.out.println("....."+map);
		return powerservice.add(map);
	}

	/**
	 * 账户列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("accountList")
	public Object accountList(@RequestParam Map paramMap){
		Map tempMap = new HashMap();
		tempMap.put("code",0);
		tempMap.put("msg","");
		tempMap.put("count",powerservice.accountListCount(paramMap));
		tempMap.put("data",powerservice.accountList(paramMap));
		//System.out.println(tempMap);
		return tempMap;
	}

	/**
	 *  修改  账户管理
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/accountUpdate")
	public Object accountUpdate(@RequestParam Map map){
		//System.out.println("....."+map);
		//powerservice.accountUpdate(map)
		return powerservice.accountUpdate(map);
	}
	/**
	 *  删除  账户管理
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/accountDelete")
	public Object accountDelete(@RequestParam Map map){
		///System.out.println("....."+map);
		//powerservice.accountDelete(map)
		return powerservice.accountDelete(map);
	}
	/**
	 *  添加 账户管理
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/accountAdd")
	public Object accountAdd(@RequestParam Map map){
		//System.out.println("....."+map);
		//powerservice.accountAdd(map)
		return powerservice.accountAdd(map);
	}

}
