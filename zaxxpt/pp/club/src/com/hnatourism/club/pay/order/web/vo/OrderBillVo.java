package com.hnatourism.club.pay.order.web.vo;

import java.util.Date;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:账单表
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderBillVo extends AbstractVo{
	/**
	 * ${c.getComments()}
	 */
	private String id ;
	/**
	 * ${c.getComments()}
	 */
	private String roleId ;
	/**
	 * ${c.getComments()}
	 */
	private String type ;
	/**
	 * ${c.getComments()}
	 */
	private String account ;
	/**
	 * ${c.getComments()}
	 */
	private String tradeNo ;
	/**
	 * ${c.getComments()}
	 */
	private Date tradeTime ;
	/**
	 * ${c.getComments()}
	 */
	private Float amount ;
	/**
	 * ${c.getComments()}
	 */
	private Date updateTime ;
	/**
	 * ${c.getComments()}
	 */
	private String updateUser ;
	/**
	 * ${c.getComments()}
	 */
	private Date createTime ;
	/**
	 * ${c.getComments()}
	 */
	private String createUser ;

	
	
	private String orderId;
	private String orderType;
	
	private String orderCode;
	private String prodType;
	
	private String transactionType;
	private Float commission;
	
	private String status;
	private String rmk;
	
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
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
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置${c.getComments()}
	 * @param roleId
	 */	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getTradeTime() {
		return tradeTime;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**
	 * 设置${c.getComments()}
	 * @param tradeTime
	 */	
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
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
	 * @return the mny
	 */
 
	public String getOrderCode() {
		return orderCode;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Float getCommission() {
		return commission;
	}
	public void setCommission(Float commission) {
		this.commission = commission;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
}