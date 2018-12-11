package com.group7.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.group7.dao.PowerDao;
import com.group7.entity.TreeNode;
import com.group7.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PowerServiceImpl implements PowerService {

	@Autowired
	private PowerDao powerDao;

	/**
	 * 登陆验证
	 * @param map
	 * @return
	 */
	@Override
	public int toLogin(Map map) {
		return powerDao.toLogin(map);
	}




	/**
	 * 从全部节点中查找，谁是当前节点的孩子，如果是，把他设置到 children集合里面
	 * @param treeNode  当前节点
	 * @param powerList  全部节点
	 */
	private void bindChild(TreeNode treeNode, List<TreeNode> powerList){
		for(TreeNode tempTreeNode:powerList){
			if(treeNode.getId()==tempTreeNode.getParentId()){//如果集合中父id和当前节点ID相等，说明该节点是当前节点的子节点
				//powerList.remove(tempTreeNode);
				//获取当前节点的孩子集合,如果以前没有添加过孩子
				List<TreeNode> childrens = treeNode.getChildren();
				if(childrens==null){
					//第一次获取孩子集合为空，初始化集合，添加当前节点，设置为孩子
					List<TreeNode> tempChildrens = new ArrayList<TreeNode>();
					tempChildrens.add(tempTreeNode);
					treeNode.setChildren(tempChildrens);
				}else{//不空，直接添加
					childrens.add(tempTreeNode);
				}
				//递归，自己调用自己，执行同样的方法，查找孩子并绑定
				bindChild(tempTreeNode,powerList);
			}
		}
	}


	@Override
	public List<TreeNode> getPowersByUserId(String userName) {

			List<TreeNode> treeList = powerDao.getPowersByUserId(userName);

			List<TreeNode> tempTreeList = new ArrayList<TreeNode>();
			if(treeList!=null&&treeList.size()>0){
				for(TreeNode treeNode:treeList){
					if(treeNode.getParentId()==0){
						treeNode.setChildren(new ArrayList<TreeNode>());
						//List<TreeNode> children = treeNode.getChildren();
						tempTreeList.add(treeNode);
						for(TreeNode ctn:treeList){
							if(ctn.getParentId()==treeNode.getId()){
								treeNode.getChildren().add(ctn);
							}
						}
					}
				}
			}
			return tempTreeList;
		}


	@Override
	public List<Map> getList(Map map) {
		//如果pageNo为空默认1  pageSize 为空,默认10
		int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
		int pageSize = map.get("pageSize")==null?5:Integer.valueOf(map.get("pageSize")+"");
		//计算分页的开始值和结束值
		map.put("start",(pageNo-1)*pageSize);
		map.put("end",pageNo*pageSize+1);
		return powerDao.getList(map);
	}

	@Override
	public int getPageCount(Map map) {
		return powerDao.getPageCount(map);
	}





	@Override
	public List<TreeNode> powerCheckedTree(String roleId) {
		//获取所有树信息   mybatis 返回的实体类
		List<TreeNode> powerMapList = powerDao.getPowerCheckedTree();
		//获取到 当登陆人 所有的权限节点
		List<Map> powersByRoleId = powerDao.getPowerCheckedTreeA(roleId);

		//判断是否为空
		if(powerMapList!=null&&powerMapList.size()>0){
			for (TreeNode tempTreeNode : powerMapList) {  //循环实体类
				//判断当前节点是否被选中
				if(powersByRoleId!=null&&powersByRoleId.size()>0){
					for(Map tmap:powersByRoleId){
						 // 如id相同 添加为选中
						if(tempTreeNode.getId()==Integer.valueOf(tmap.get("POWERID")+"")){
							tempTreeNode.setChecked("true");
						}
					}
				}
			}
		}

		//定义一个临时的集合，用于存放拼装后的结果集
		List<TreeNode> tempPowerList = new ArrayList<TreeNode>();
		if(powerMapList!=null&&powerMapList.size()>0){  //判断 powerMapList 是否为空
			for(TreeNode treeNode:powerMapList){
				//先查找一级节点
				if(treeNode.getParentId()==0){
					//如果是一级节点直接放入临时集合
					tempPowerList.add(treeNode);
					//递归找到一级及子节点下有没有节点
					bindChild(treeNode,powerMapList);

				}
			}
		}
		return tempPowerList;
	}

	@Override
	public int saveRolePower(Map map) {

		String powerIds = map.get("powerIds")+"";//powerIds:1,2,3,4,5,  roleid:1
		Integer roleId = Integer.valueOf(map.get("roleId")+"");
		boolean suc=false;
		//删除原来的关联项目
		powerDao.delPowersByRoleId(roleId);
		//批量添加角色和权限关联
		if(powerIds!=null&&!"".equals(powerIds)){
			String[] ids = powerIds.split(",");
			for(String id:ids){

				int i=powerDao.addRolePower(roleId,Integer.valueOf(id));
				if(i==-1)
					suc=true;
			}
		}
		if(suc){
			return -1;
		}
		return 0;
	}
	@Override
	public int up(Map map) {
		return powerDao.up(map);
	}
	@Override
	public int de(Map map) {
		return powerDao.de(map);
	}
	@Override
	public int add(Map map) {
		return powerDao.add(map);
	}
	@Override
	public List<Map> accountList(Map map) {
		//如果pageNo为空默认1  pageSize 为空,默认10
		int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
		int pageSize = map.get("pageSize")==null?5:Integer.valueOf(map.get("pageSize")+"");
		//计算分页的开始值和结束值
		map.put("start",(pageNo-1)*pageSize);
		map.put("end",pageNo*pageSize+1);
		return powerDao.accountList(map);
	}
	@Override
	public int accountListCount(Map map) {
		return powerDao.accountListCount(map);
	}
	@Override
	public int accountUpdate(Map map) {
		return powerDao.accountUpdate(map);
	}
	@Override
	public int accountDelete(Map map) {
		return powerDao.accountDelete(map);
	}
	@Override
	public int accountAdd(Map map) {
		return powerDao.accountAdd(map);
	}


}
