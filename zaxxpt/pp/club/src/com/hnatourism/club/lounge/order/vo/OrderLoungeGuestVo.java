package com.hnatourism.club.lounge.order.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室顾客表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderLoungeGuestVo extends AbstractVo{
	/**
	 * ${c.getComments()}
	 */
	private String id;
	/**
	 * 订单编号
	 */
	private String orderId;
	/**
	 * 常旅客编号
	 */
	private String memberPassengerId;
	/**
	 * ${c.getComments()}
	 */
	private Double price;
	/**
	 * ${c.getComments()}
	 */
	private String name;
	/**
	 * 乘客类型
	 */
	private String type;
	/**
	 * ${c.getComments()}
	 */
	private String flightNo;
	/**
	 * ${c.getComments()}
	 */
	private String consumerSts;
	/**
	 * 附加费用编号,多个以/分割
	 */
	private String additionalItemId;
	/**
	 * 附加费用编号
	 */
	private Double additionalFee;
	/**
	 * ${c.getComments()}
	 */
	private String createUser;
	/**
	 * ${c.getComments()}
	 */
	private Date createTime;
	/**
	 * ${c.getComments()}
	 */
	private String updateUser;
	/**
	 * ${c.getComments()}
	 */
	private Date updateTime;
	//订单类型，是异常还是正常
	private String orderType;
	private Double additionalSignPrice;//附加费用签约总价

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
	 * 获取订单编号
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 设置订单编号
	 * @param orderId
	 */	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取常旅客编号
	 * @return
	 */
	public String getMemberPassengerId() {
		return memberPassengerId;
	}

	/**
	 * 设置常旅客编号
	 * @param memberPassengerId
	 */	
	public void setMemberPassengerId(String memberPassengerId) {
		this.memberPassengerId = memberPassengerId;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 设置${c.getComments()}
	 * @param price
	 */	
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置${c.getComments()}
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取乘客类型
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置乘客类型
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * 设置${c.getComments()}
	 * @param flightNo
	 */	
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getConsumerSts() {
		return consumerSts;
	}

	/**
	 * 设置${c.getComments()}
	 * @param consumerSts
	 */	
	public void setConsumerSts(String consumerSts) {
		this.consumerSts = consumerSts;
	}
	/**
	 * 获取附加费用编号,多个以/分割
	 * @return
	 */
	public String getAdditionalItemId() {
		return additionalItemId;
	}

	/**
	 * 设置附加费用编号,多个以/分割
	 * @param additionalItemId
	 */	
	public void setAdditionalItemId(String additionalItemId) {
		this.additionalItemId = additionalItemId;
	}
	/**
	 * 获取附加费用编号
	 * @return
	 */
	public Double getAdditionalFee() {
		return additionalFee;
	}

	/**
	 * 设置附加费用编号
	 * @param additionalFee
	 */	
	public void setAdditionalFee(Double additionalFee) {
		this.additionalFee = additionalFee;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Double getAdditionalSignPrice() {
		return additionalSignPrice;
	}

	public void setAdditionalSignPrice(Double additionalSignPrice) {
		this.additionalSignPrice = additionalSignPrice;
	}
}