package com.group7.dao;


import com.group7.entity.TreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;





public interface PowerDao {


	/**
	 * 登陆验证
	 * @param map
	 * @return
	 */
	int toLogin(Map map);


	/**
	 * 用户权限列表（用于主菜单查询）
	 * @return
	 */
	List<TreeNode> getPowersByUserId(String userName);

	/**
	 * 角色列表
	 * @return
	 */
	List<Map> getList(Map map);

	/**
	 * 查询分页数据的总数量
	 * @param
	 */
	int getPageCount(Map map);

	/**
	 * 带选择的权限树（用于授权勾选）
	 * @return
	 */
	List<TreeNode>  getPowerCheckedTree();

	/**
	 * 带选择的权限树（用于授权勾选）
	 * @param roleId
	 * @return
	 */
	List<Map>  getPowerCheckedTreeA(String roleId);

	/**
	 * 添加角色权限关联表
	 * @param roleId
	 * @param powerId
	 * @return
	 */
	int addRolePower(@Param("roleId") int roleId,@Param("powerId") int powerId);

	/**
	 * 删除原来关联的所有权限
	 * @param roleId
	 * @return
	 */
	int delPowersByRoleId(int roleId);

	/**
	 * 修改角色管理信息
	 * @param map
	 * @return
	 */
	int up(Map map);

	/**
	 * 删除角色管理信息
	 * @param map
	 * @return
	 */
	int de(Map map);

	/**
	 * 添加角色管理信息
	 * @param map
	 * @return
	 */
	int add(Map map);

	/**
	 * 账户列表
	 * @return
	 */
	List<Map> accountList(Map map);

	/**
	 * 查询分页数据的总数量
	 * @param map
	 * @return
	 */
	int accountListCount(Map map);

	/**
	 * 修改账户管理信息
	 * @param map
	 * @return
	 */
	int accountUpdate(Map map);

	/**
	 * 删除账户管理信息
	 * @param map
	 * @return
	 */
	int accountDelete(Map map);

	/**
	 * 添加账户管理信息
	 * @param map
	 * @return
	 */
	int accountAdd(Map map);
}
