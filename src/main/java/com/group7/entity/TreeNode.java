package com.group7.entity;

import java.util.List;


public class TreeNode {

	private int id;
	private String text;
    private int parentId;
	private String state;
	private String iconCls;
	private String url;
	private String remark;

	private List<TreeNode> children;

	private String checked;

	@Override
	public String toString() {
		return "TreeNode{" +
				"id=" + id +
				", text='" + text + '\'' +
				", parentId=" + parentId +
				", state='" + state + '\'' +
				", iconCls='" + iconCls + '\'' +
				", url='" + url + '\'' +
				", remark='" + remark + '\'' +
				", children=" + children +
				", checked='" + checked + '\'' +
				'}';
	}

	/**
	 * ���ι���
	 * @param id
	 * @param text
	 * @param parentId
	 * @param state
	 * @param iconCls
	 * @param url
	 * @param remark
	 */
	public TreeNode(int id, String text, int parentId, String state,
			String iconCls, String url, String remark) {
		super();
		this.id = id;
		this.text = text;
		this.parentId = parentId;
		this.state = state;
		this.iconCls = iconCls;
		this.url = url;
		this.remark = remark;
	}

	
	public TreeNode(int id, String text, int parentId, String state,
			String iconCls, String url, String remark, String checked) {
		super();
		this.id = id;
		this.text = text;
		this.parentId = parentId;
		this.state = state;
		this.iconCls = iconCls;
		this.url = url;
		this.remark = remark;
		this.checked = checked;
	}


	public TreeNode(int id, String text, int parentId, String state,
			String iconCls) {
		super();
		this.id = id;
		this.text = text;
		this.parentId = parentId;
		this.state = state;
		this.iconCls = iconCls;
	}


	public TreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}


	public String getChecked() {
		return checked;
	}


	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	
	
}