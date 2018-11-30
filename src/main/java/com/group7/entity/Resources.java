package com.group7.entity;

/**
 * className:Resources
 * discriptoin:资源表实体
 * author:毛宇
 * createTime:2018-11-30 00:09
 */
public class Resources {
	private Integer id;//资源id
	private String NAME;//资源名称
	private String RESURL;//资源url
	private Integer TYPE;//资源类型
	private Integer PARENTID;//父资源
	private Integer SORT;//排序

	public Resources() {
	}

	/**
	 * 构造
	 * @param id
	 * @param NAME
	 * @param RESURL
	 * @param TYPE
	 * @param PARENTID
	 * @param SORT
	 */
	public Resources(Integer id, String NAME, String RESURL, Integer TYPE, Integer PARENTID, Integer SORT) {
		this.id = id;
		this.NAME = NAME;
		this.RESURL = RESURL;
		this.TYPE = TYPE;
		this.PARENTID = PARENTID;
		this.SORT = SORT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public String getRESURL() {
		return RESURL;
	}

	public void setRESURL(String RESURL) {
		this.RESURL = RESURL;
	}

	public Integer getTYPE() {
		return TYPE;
	}

	public void setTYPE(Integer TYPE) {
		this.TYPE = TYPE;
	}

	public Integer getPARENTID() {
		return PARENTID;
	}

	public void setPARENTID(Integer PARENTID) {
		this.PARENTID = PARENTID;
	}

	public Integer getSORT() {
		return SORT;
	}

	public void setSORT(Integer SORT) {
		this.SORT = SORT;
	}
}
