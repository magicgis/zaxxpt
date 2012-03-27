package com.hnatourism.club.lounge.order.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室订单表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderLounge extends AbstractEntity {
	//${c.getComments()}
	private String id;
	//${c.getComments()}
	private String roomId;
	//预定开始时间
	private Date startTime;
	//预定结束时间，只有贵宾间有
	private Date endTime;
	//${c.getComments()}
	private String sts;
	//${c.getComments()}
	private String paySts;
	//${c.getComments()}
	private Double price;
	//${c.getComments()}
//	private String name;
	//${c.getComments()}
	private String flightNo;
	//附加费用编号,多个以逗号分割
	private String additionalItemId;
	//附加费用编号
	private Double additionalFee;
	//${c.getComments()}
	private String operateSts;
	//${c.getComments()}
	private String consumerSts;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date createTime;
	//${c.getComments()}
	private String updateUser;
	//${c.getComments()}
	private Date updateTime;
	//渠道来源
	private String source;
	//备注
	private String rmk;
	//客户ID
	private String memberId;
	//订单号
	private String code;
	//取消订单还是确认订单


	private Date confirmTime;
	private Date confirmEndTime;
	private String billId;
	private String profit;
	private String profitAmount;
	private Double signPrice;
	private Double additionalSignPrice;
	
//	private String action;
	///////////////////////////关联查询对象,主要用于避免订单查询时多次查询的问题
	//休息室名称 	lixun
	private String loungeName;
	
	//休息是类型  lixun
	private String loungeType;
	
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
	public String getRoomId() {
		return roomId;
	}

	/**
	 * 设置${c.getComments()}
	 * @param roomId
	 */	
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	/**
	 * 获取预定开始时间
	 * @return
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 设置预定开始时间
	 * @param startTime
	 */	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取预定结束时间，只有贵宾间有
	 * @return
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 设置预定结束时间，只有贵宾间有
	 * @param endTime
	 */	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	public String getPaySts() {
		return paySts;
	}

	/**
	 * 设置${c.getComments()}
	 * @param paySts
	 */	
	public void setPaySts(String paySts) {
		this.paySts = paySts;
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
//	public String getName() {
//		return name;
//	}
//
//	/**
//	 * 设置${c.getComments()}
//	 * @param name
//	 */	
//	public void setName(String name) {
//		this.name = name;
//	}
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
	public String getOperateSts() {
		return operateSts;
	}

	/**
	 * 设置${c.getComments()}
	 * @param operateSts
	 */	
	public void setOperateSts(String operateSts) {
		this.operateSts = operateSts;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Date getConfirmEndTime() {
		return confirmEndTime;
	}

	public void setConfirmEndTime(Date confirmEndTime) {
		this.confirmEndTime = confirmEndTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(String profitAmount) {
		this.profitAmount = profitAmount;
	}

	public Double getSignPrice() {
		return signPrice;
	}

	public void setSignPrice(Double signPrice) {
		this.signPrice = signPrice;
	}

//	public String getAction() {
//		return action;
//	}
//
//	public void setAction(String action) {
//		this.action = action;
//	}
	
	public Double getAdditionalSignPrice() {
		return additionalSignPrice;
	}

	public String getLoungeName() {
		return loungeName;
	}

	public void setLoungeName(String loungeName) {
		this.loungeName = loungeName;
	}

	public String getLoungeType() {
		return loungeType;
	}

	public void setLoungeType(String loungeType) {
		this.loungeType = loungeType;
	}

	public void setAdditionalSignPrice(Double additionalSignPrice) {
		this.additionalSignPrice = additionalSignPrice;
	}
	
}