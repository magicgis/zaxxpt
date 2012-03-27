package com.hnatourism.club.golf.domain;


import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫充球记录表
 * 
 * 历史版本:
 *					2011-08-01 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfRecord extends AbstractEntity {
	//${c.getComments()}
	private String id ;
	//${c.getComments()}
	private String siteId ;
	//${c.getComments()}
	private String contractId ;
	//${c.getComments()}
	private Long addNum ;
	//${c.getComments()}
	private Date startTime ;
	//${c.getComments()}
	private Date endTime ;
	//${c.getComments()}
	private Long contractPrice ;
	//${c.getComments()}
	private Long price ;
	//${c.getComments()}
	private Long amount ;
	//${c.getComments()}
	private String sts ;
	//${c.getComments()}
	private String createUser ;
	//${c.getComments()}
	private Date createTime ;
	//${c.getComments()}
	private String updateUser ;
	//${c.getComments()}
	private Date updateTime ;

	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置${c.getComments()}
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getSiteId() {
		return siteId;
	}
	/**
	 * 设置${c.getComments()}
	 * @param siteId
	 */	
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getContractId() {
		return contractId;
	}
	/**
	 * 设置${c.getComments()}
	 * @param contractId
	 */	
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getAddNum() {
		return addNum;
	}
	/**
	 * 设置${c.getComments()}
	 * @param addNum
	 */	
	public void setAddNum(Long addNum) {
		this.addNum = addNum;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param startTime
	 */	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param endTime
	 */	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getContractPrice() {
		return contractPrice;
	}
	/**
	 * 设置${c.getComments()}
	 * @param contractPrice
	 */	
	public void setContractPrice(Long contractPrice) {
		this.contractPrice = contractPrice;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getPrice() {
		return price;
	}
	/**
	 * 设置${c.getComments()}
	 * @param price
	 */	
	public void setPrice(Long price) {
		this.price = price;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getAmount() {
		return amount;
	}
	/**
	 * 设置${c.getComments()}
	 * @param amount
	 */	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getSts() {
		return sts;
	}
	/**
	 * 设置${c.getComments()}
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置${c.getComments()}
	 * @param createUser
	 */	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置${c.getComments()}
	 * @param updateUser
	 */	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param updateTime
	 */	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}