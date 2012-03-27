package com.hnatourism.club.lounge.order.vo;

import java.util.Date;

import com.hnatourism.club.lounge.prod.vo.LoungeInfoVo;
import com.hnatourism.club.lounge.prod.vo.LoungePriceVo;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;
import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.List;
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
public class OrderLoungeVo extends AbstractVo{
	/**
	 * ${c.getComments()}
	 */
	private String id;
	/**
	 * ${c.getComments()}
	 */
	private String roomId;
	
	/**
	 * 休息室信息
	 * author lixun 
	 * date 2011-8-13 16:50:31
	 */
	private LoungeInfoVo loungeInfoVo;
	
	/**
	 * 机场休息是订单日志
	 * author lixun 
	 * date 2011-8-15 17:52:28
	 */
	private List<LogLoungeOrderVo> logLoungeOrderVoList;
	/**
	 * 联系人
	 */
	private OrderContactVo orderContactVo;
	/**
	 * 机场休息是退改信息
	 * author lixun 
	 * date 2011-8-16 20:21:37
	 */
	private List<OrderLoungeExceptionVo> loungeExceptionVoList;
	
	/**
	 * 休息室房间信息
	 */
	private LoungeRoomVo loungeRoomVo;
	/**
	 * 单收费项目 gujianliang
	 */
	private List<LoungePriceVo> loungePriceVoList;
	
	/**
	 * 人员列表  gujianliang
	 */
	private List<OrderLoungeGuestVo> orderLoungeGuestVoList;
	/**
	 * 预定开始时间
	 */
	private Date startTime;
	/**
	 * 预定结束时间，只有贵宾间有
	 */
	private Date endTime;
	/**
	 * ${c.getComments()}
	 */
	private String sts;
	/**
	 * ${c.getComments()}
	 */
	private String paySts;
	/**
	 * ${c.getComments()}
	 */
	private Double price;
	/**
	 * ${c.getComments()}
	 */
	private String name;
	/**
	 * ${c.getComments()}
	 */
	private String flightNo;
	/**
	 * 附加费用编号,多个以逗号分割
	 */
	private String additionalItemId;
	/**
	 * 附加费用编号
	 */
	private Double additionalFee;
	/**
	 * ${c.getComments()}
	 */
	private String operateSts;
	/**
	 * ${c.getComments()}
	 */
	private String consumerSts;
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
	private Double additionalSignPrice;
	
	//休息室名称 	lixun
	private String loungeName;
	
	//休息是类型  lixun
	private String loungeType;

	//订单号
	private String code;
	private String profit;
	private String profitAmount;
	private Double signPrice;
	//取消订单还是确认订单
	private String action;
	
	/**
	 * 修改原因(谷建亮)  用于传参不用于显示
	 */
	private String rmk;
	/**
	 * 顾客id(谷建亮)  用于传参不用于显示，已逗号间隔
	 */
	private String  guestIds;
	private String [] guestIdArray;
	private String [] additionalItemIds;
	private String source;
	private String memberId;
	private Date confirmTime;
	private Date confirmEndTime;
	private String billId;
	


	public String[] getGuestIdArray() {
		return guestIdArray;
	}

	public void setGuestIdArray(String[] guestIdArray) {
		this.guestIdArray = guestIdArray;
	}

	public void setGuestIds(String guestIds) {
		this.guestIds = guestIds;
	}

	public String[] getAdditionalItemIds() {
		return additionalItemIds;
	}

	public void setAdditionalItemIds(String[] additionalItemIds) {
		this.additionalItemIds = additionalItemIds;
	}


	public List<OrderLoungeGuestVo> getOrderLoungeGuestVoList() {
		return orderLoungeGuestVoList;
	}

	public void setOrderLoungeGuestVoList(
			List<OrderLoungeGuestVo> orderLoungeGuestVoList) {
		this.orderLoungeGuestVoList = orderLoungeGuestVoList;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	

	public String getGuestIds() {
		return guestIds;
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
	
	
//	public LoungeRoom getLoungeRoom() {
//		return loungeRoom;
//	}
//
//	public void setLoungeRoom(LoungeRoom loungeRoom) {
//		this.loungeRoom = loungeRoom;
//	}


	
	
	/**
	 * 获取预定开始时间
	 * @return
	 */
	public Date getStartTime() {
		return startTime;
	}

	
	public LoungeInfoVo getLoungeInfoVo() {
		return loungeInfoVo;
	}

	public void setLoungeInfoVo(LoungeInfoVo loungeInfoVo) {
		this.loungeInfoVo = loungeInfoVo;
	}

	public List<LogLoungeOrderVo> getLogLoungeOrderVoList() {
		return logLoungeOrderVoList;
	}

	public void setLogLoungeOrderVoList(List<LogLoungeOrderVo> logLoungeOrderVoList) {
		this.logLoungeOrderVoList = logLoungeOrderVoList;
	}

	public List<OrderLoungeExceptionVo> getLoungeExceptionVoList() {
		return loungeExceptionVoList;
	}

	public void setLoungeExceptionVoList(
			List<OrderLoungeExceptionVo> loungeExceptionVoList) {
		this.loungeExceptionVoList = loungeExceptionVoList;
	}

	
	public LoungeRoomVo getLoungeRoomVo() {
		return loungeRoomVo;
	}

	public void setLoungeRoomVo(LoungeRoomVo loungeRoomVo) {
		this.loungeRoomVo = loungeRoomVo;
	}

	public List<LoungePriceVo> getLoungePriceVoList() {
		return loungePriceVoList;
	}

	public void setLoungePriceVoList(List<LoungePriceVo> loungePriceVoList) {
		this.loungePriceVoList = loungePriceVoList;
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


	public OrderContactVo getOrderContactVo() {
		return orderContactVo;
	}

	public void setOrderContactVo(OrderContactVo orderContactVo) {
		this.orderContactVo = orderContactVo;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Double getAdditionalSignPrice() {
		return additionalSignPrice;
	}

	public void setAdditionalSignPrice(Double additionalSignPrice) {
		this.additionalSignPrice = additionalSignPrice;
	}

	public void setLoungeName(String loungeName) {
		this.loungeName = loungeName;
	}

	public String getLoungeName() {
		return loungeName;
	}

	public void setLoungeType(String loungeType) {
		this.loungeType = loungeType;
	}

	public String getLoungeType() {
		return loungeType;
	}


}