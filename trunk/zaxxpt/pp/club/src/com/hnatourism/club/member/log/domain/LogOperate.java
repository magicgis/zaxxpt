package com.hnatourism.club.member.log.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员操作日志表
 * 
 * 历史版本:
 *					2011-10-17 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class LogOperate extends AbstractEntity {
	//ID
	private String id ;
	//操作内容
	private String content ;
	//路径。例：XX模块/xx子模块 ，（英文）
	private String path ;
	//事件触发URL
	private String url ;
	//创建时间
	private Date createTime ;
	//创建人
	private String createUser ;
	//备注
	private String rmk ;
	//对应产品编号/活动编号，例：金币池操作关联团活动ID
	private String prodId ;

	/**
	 * 获取ID
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置ID
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取操作内容
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置操作内容
	 * @param content
	 */	
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取路径。例：XX模块/xx子模块 ，（英文）
	 * @return
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置路径。例：XX模块/xx子模块 ，（英文）
	 * @param path
	 */	
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取事件触发URL
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置事件触发URL
	 * @param url
	 */	
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置创建时间
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取创建人
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置创建人
	 * @param createUser
	 */	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取备注
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * 设置备注
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取对应产品编号/活动编号，例：金币池操作关联团活动ID
	 * @return
	 */
	public String getProdId() {
		return prodId;
	}
	/**
	 * 设置对应产品编号/活动编号，例：金币池操作关联团活动ID
	 * @param prodId
	 */	
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
}