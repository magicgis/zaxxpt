package com.hnatourism.club.golf.order.vo;


import java.util.Date;
import java.util.List;

import com.hnatourism.framework.core.domain.AbstractEntity;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫订单定单退改信息VO
 * 
 * 历史版本:2011-08-06 v1.0.0 (栾晓东) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfOrderExceptionVo extends AbstractEntity
{
	//支付状态
	private String paySts;
	//消费状态
	private String consumerSts;
	//操作状态
	private String operateSts;
	//${c.getComments()}
	private String id;
	//${c.getComments()}
	private String orderId;
	//异常订单状态
	private String sts;
	//${c.getComments()}
	private String type;
	//手续费率
	private Double feeRate;
	//手续费
	private Double fee;
	//退款金额/改期补额
	private Double price;
	//${c.getComments()}//退场原因。
	private String rmk;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String updateUser;
	//${c.getComments()}
	private Date updateTime;
	
	//改期时间。
	private Date bookTime;
	//确认时间
	private Date confirmTime;
	
	private String code;
	//打球人员
	private List<GolfOrderPlayVo>  golfOrderPlayVoList;
	
	  
	public Date getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	public Date getBookTime() {
		return bookTime;
	}
	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPaySts() {
		return paySts;
	}
	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}
	public String getConsumerSts() {
		return consumerSts;
	}
	public void setConsumerSts(String consumerSts) {
		this.consumerSts = consumerSts;
	}
	public String getOperateSts() {
		return operateSts;
	}
	public void setOperateSts(String operateSts) {
		this.operateSts = operateSts;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Double getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(Double feeRate) {
		this.feeRate = feeRate;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
	public List<GolfOrderPlayVo> getGolfOrderPlayVoList() {
		return golfOrderPlayVoList;
	}
	public void setGolfOrderPlayVoList(List<GolfOrderPlayVo> golfOrderPlayVoList) {
		this.golfOrderPlayVoList = golfOrderPlayVoList;
	}
 
	
 
}
