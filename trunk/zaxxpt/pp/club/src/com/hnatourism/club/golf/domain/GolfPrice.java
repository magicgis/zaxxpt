package com.hnatourism.club.golf.domain;


import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫价格表
 * 
 * 历史版本:
 *					2011-08-01 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfPrice extends AbstractEntity {
	//${c.getComments()}
	private String id ;
	//${c.getComments()}
	private String explain ;
	//${c.getComments()}
	private String siteId ;
	//${c.getComments()}
	private String containItem ;
	//${c.getComments()}
	private Long signingPrice ;
	//${c.getComments()}
	private Long price ;
	//${c.getComments()}
	private Long targeDate ;
	//${c.getComments()}
	private Long hSigningprice ;
	//${c.getComments()}
	private Long hPrice ;
	//${c.getComments()}
	private Long hTargeDate ;
	//${c.getComments()}
	private Date startTime ;
	//${c.getComments()}
	private Date endTime ;
	//${c.getComments()}
	private String createUser ;
	//${c.getComments()}
	private Date createTime ;
	//${c.getComments()}
	private String updateUser ;
	//${c.getComments()}
	private Date updateTime ;
	//当天提前预定小时。
	private Integer advanceTime ;

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
	public String getExplain() {
		return explain;
	}
	/**
	 * 设置${c.getComments()}
	 * @param explain
	 */	
	public void setExplain(String explain) {
		this.explain = explain;
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
	public String getContainItem() {
		return containItem;
	}
	/**
	 * 设置${c.getComments()}
	 * @param containItem
	 */	
	public void setContainItem(String containItem) {
		this.containItem = containItem;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getSigningPrice() {
		return signingPrice;
	}
	/**
	 * 设置${c.getComments()}
	 * @param signingPrice
	 */	
	public void setSigningPrice(Long signingPrice) {
		this.signingPrice = signingPrice;
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
	public Long getTargeDate() {
		return targeDate;
	}
	/**
	 * 设置${c.getComments()}
	 * @param targeDate
	 */	
	public void setTargeDate(Long targeDate) {
		this.targeDate = targeDate;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getHSigningprice() {
		return hSigningprice;
	}
	/**
	 * 设置${c.getComments()}
	 * @param hSigningprice
	 */	
	public void setHSigningprice(Long hSigningprice) {
		this.hSigningprice = hSigningprice;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getHPrice() {
		return hPrice;
	}
	/**
	 * 设置${c.getComments()}
	 * @param hPrice
	 */	
	public void setHPrice(Long hPrice) {
		this.hPrice = hPrice;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getHTargeDate() {
		return hTargeDate;
	}
	/**
	 * 设置${c.getComments()}
	 * @param hTargeDate
	 */	
	public void setHTargeDate(Long hTargeDate) {
		this.hTargeDate = hTargeDate;
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
	public Integer getAdvanceTime() {
		return advanceTime;
	}
	public void setAdvanceTime(Integer advanceTime) {
		this.advanceTime = advanceTime;
	}
}