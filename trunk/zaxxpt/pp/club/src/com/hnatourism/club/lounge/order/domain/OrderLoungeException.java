package com.hnatourism.club.lounge.order.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室订单退改表
 * 
 * 历史版本:
 *					2011-08-11 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderLoungeException extends AbstractEntity {
	//${c.getComments()}
	private String id;
	//原始订单ID
	private String orderId;
	//修改原因
	private String rmk;
	//异常订单状态
	private String sts;
	//异常订单类型
	private String type;
	//手续费率
	private Double feeRate;
	//手续费
	private Double fee;
	//退款金额/改期补额
	private Double price;
	//支付状态
	private String paySts;
	//消费状态
	private String consumerSts;
	//操作状态
	private String operateSts;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String updateUser;
	//${c.getComments()}
	private Date updateTime;

	private Date bookTime;
	private Date bookEndTime;
	//单收项id集合以逗号间隔
	private String additionalItemIds;
	private Date confirmTime;
	
	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	private String code;
	
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAdditionalItemIds() {
		return additionalItemIds;
	}

	public void setAdditionalItemIds(String additionalItemIds) {
		this.additionalItemIds = additionalItemIds;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}

	public Date getBookEndTime() {
		return bookEndTime;
	}

	public void setBookEndTime(Date bookEndTime) {
		this.bookEndTime = bookEndTime;
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
	 * 获取原始订单ID
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 设置原始订单ID
	 * @param orderId
	 */	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取修改原因
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * 设置修改原因
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取异常订单状态
	 * @return
	 */
	public String getSts() {
		return sts;
	}

	/**
	 * 设置异常订单状态
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取异常订单类型
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置异常订单类型
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取手续费率
	 * @return
	 */
	public Double getFeeRate() {
		return feeRate;
	}

	/**
	 * 设置手续费率
	 * @param feeRate
	 */	
	public void setFeeRate(Double feeRate) {
		this.feeRate = feeRate;
	}
	/**
	 * 获取手续费
	 * @return
	 */
	public Double getFee() {
		return fee;
	}

	/**
	 * 设置手续费
	 * @param fee
	 */	
	public void setFee(Double fee) {
		this.fee = fee;
	}
	/**
	 * 获取退款金额/改期补额
	 * @return
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 设置退款金额/改期补额
	 * @param price
	 */	
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取支付状态
	 * @return
	 */
	public String getPaySts() {
		return paySts;
	}

	/**
	 * 设置支付状态
	 * @param paySts
	 */	
	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}
	/**
	 * 获取消费状态
	 * @return
	 */
	public String getConsumerSts() {
		return consumerSts;
	}

	/**
	 * 设置消费状态
	 * @param consumerSts
	 */	
	public void setConsumerSts(String consumerSts) {
		this.consumerSts = consumerSts;
	}
	/**
	 * 获取操作状态
	 * @return
	 */
	public String getOperateSts() {
		return operateSts;
	}

	/**
	 * 设置操作状态
	 * @param operateSts
	 */	
	public void setOperateSts(String operateSts) {
		this.operateSts = operateSts;
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