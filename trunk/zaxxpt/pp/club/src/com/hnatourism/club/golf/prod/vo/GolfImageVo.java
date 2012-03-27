package com.hnatourism.club.golf.prod.vo;

import java.util.Date;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫图片VO
 * 
 * 历史版本:2010-08-04 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfImageVo
{
	//产品图片ID
	private String id;
	//产品ID
	private String golfId;
	//产品图片路径
	private String path;
	//产品图片类型
	private String type;
	//产品图片状态
	private String sts;
	//产品图片排序标识
	private String seq;
	//添加者
	private String createUser;
	//添加时间
	private Date createTime;
	//最后修改人
	private String updateUser;
	//最后修改时间
	private Date updateTime;
	//备注
	private String rmk;
	//图片名称
	private String name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGolfId() {
		return golfId;
	}
	public void setGolfId(String golfId) {
		this.golfId = golfId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
