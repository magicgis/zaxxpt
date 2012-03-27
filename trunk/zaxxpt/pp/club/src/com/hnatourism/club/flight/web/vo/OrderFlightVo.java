package com.hnatourism.club.flight.web.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hnatourism.club.flight.book.BookingFlightVo;
import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机票订单Vo
 * 
 * 历史版本:
 *					2010-07-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderFlightVo extends AbstractVo {
 
	private String id;
	
	// 订单号
	private String code;
	
	//票总价格 ：净结价=成本价扣除返点（相当于总佣金+总成本价）（用户看到的价，支付价）
	private BigDecimal totalMoney;
	private BigDecimal actualPay;
	
	//订单状态00 订座成功 01 订单取消 03 出票成功 05 支付差错 07 出票失败 09 已退款
	private String sts;
	//订单类型 0：普通票；1：团购票2:议价票  3：秒杀
	private String type;
	// 团购名
	private String groupName;
	// 秒杀标识 0代表普通团购，1代表第一波秒杀，2代表第二波秒杀  3.EDM团购
	private String seckill;
	// 下单人
	private String createUser;
	//预订时间
	private Date createTime;
	
	//票总价格 ：净结价=成本价扣除返点（相当于总佣金+总成本价）（用户看到的价，支付价）
	private BigDecimal totalTicketPrice;
	
	// 总机建费
	private BigDecimal totalConstructionFee;
	// 总燃油费
	private BigDecimal totalBaf;

	// 支付方式
	private String payType ;
	// 支付状态 0:未支付 1: 部分支付 2:支付完毕
	private String paySts ;
	 
	//预定航班
	private List<BookingFlightVo> bookingFlightVoList;
	
	//PNR是否成功
	private boolean isPnr;
	//备注
	private String rmk;
	//行程类型
	private String ticketType;
	 //乘机人
	private List<MemberPassengerVo> orderFlightPassengerVoList;
	
	//行程单
	private FlightItineraryVo orderItineraryVo;
	
	//机票订单联系人
	private FlightContactVo orderContactVo;
	//机票订单日志
	private List orderFlightLogVoList;
	/**
	 * 改签历史信息
	 */
	private List orderFlightModifyVoList;
	/**
	 * 支付信息
	 */
	private  List payTradeDetailVoList;
	/**
	 * 金币支付信息
	 */
	private List xlbDetailVoList;
	/**
	 * 订单已金币数量
	 */
	private BigDecimal xlbTotalPay;
	//儿童数
	private Long childNum ;
	//成人数
	private Long adultNum ;
	//总人数（票数）
	private Long personNum ;
	//团购CODE
	private String groupCode;
	//来源
	private String source;
	//用户ID
	private String memberId;
	//行程单邮寄费
	private BigDecimal deliveryFee;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public BigDecimal getActualPay() {
		return actualPay;
	}
	public void setActualPay(BigDecimal actualPay) {
		this.actualPay = actualPay;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getSeckill() {
		return seckill;
	}
	public void setSeckill(String seckill) {
		this.seckill = seckill;
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
	public BigDecimal getTotalTicketPrice() {
		return totalTicketPrice;
	}
	public void setTotalTicketPrice(BigDecimal totalTicketPrice) {
		this.totalTicketPrice = totalTicketPrice;
	}
	public BigDecimal getTotalConstructionFee() {
		return totalConstructionFee;
	}
	public void setTotalConstructionFee(BigDecimal totalConstructionFee) {
		this.totalConstructionFee = totalConstructionFee;
	}
	public BigDecimal getTotalBaf() {
		return totalBaf;
	}
	public void setTotalBaf(BigDecimal totalBaf) {
		this.totalBaf = totalBaf;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPaySts() {
		return paySts;
	}
	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}
	public List<BookingFlightVo> getBookingFlightVoList() {
		return bookingFlightVoList;
	}
	public void setBookingFlightVoList(List<BookingFlightVo> bookingFlightVoList) {
		this.bookingFlightVoList = bookingFlightVoList;
	}
	public boolean isPnr() {
		return isPnr;
	}
	public void setPnr(boolean isPnr) {
		this.isPnr = isPnr;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public List<MemberPassengerVo> getOrderFlightPassengerVoList() {
		return orderFlightPassengerVoList;
	}
	public void setOrderFlightPassengerVoList(
			List<MemberPassengerVo> orderFlightPassengerVoList) {
		this.orderFlightPassengerVoList = orderFlightPassengerVoList;
	}
	public FlightItineraryVo getOrderItineraryVo() {
		return orderItineraryVo;
	}
	public void setOrderItineraryVo(FlightItineraryVo orderItineraryVo) {
		this.orderItineraryVo = orderItineraryVo;
	}
	public FlightContactVo getOrderContactVo() {
		return orderContactVo;
	}
	public void setOrderContactVo(FlightContactVo orderContactVo) {
		this.orderContactVo = orderContactVo;
	}
	public List getOrderFlightLogVoList() {
		return orderFlightLogVoList;
	}
	public void setOrderFlightLogVoList(List orderFlightLogVoList) {
		this.orderFlightLogVoList = orderFlightLogVoList;
	}
	public List getOrderFlightModifyVoList() {
		return orderFlightModifyVoList;
	}
	public void setOrderFlightModifyVoList(List orderFlightModifyVoList) {
		this.orderFlightModifyVoList = orderFlightModifyVoList;
	}
	public List getPayTradeDetailVoList() {
		return payTradeDetailVoList;
	}
	public void setPayTradeDetailVoList(List payTradeDetailVoList) {
		this.payTradeDetailVoList = payTradeDetailVoList;
	}
	public List getXlbDetailVoList() {
		return xlbDetailVoList;
	}
	public void setXlbDetailVoList(List xlbDetailVoList) {
		this.xlbDetailVoList = xlbDetailVoList;
	}
	public BigDecimal getXlbTotalPay() {
		return xlbTotalPay;
	}
	public void setXlbTotalPay(BigDecimal xlbTotalPay) {
		this.xlbTotalPay = xlbTotalPay;
	}
	public Long getChildNum() {
		return childNum;
	}
	public void setChildNum(Long childNum) {
		this.childNum = childNum;
	}
	public Long getAdultNum() {
		return adultNum;
	}
	public void setAdultNum(Long adultNum) {
		this.adultNum = adultNum;
	}
	public Long getPersonNum() {
		return personNum;
	}
	public void setPersonNum(Long personNum) {
		this.personNum = personNum;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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
	/**
	 * @return the deliveryFee
	 */
	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}
	/**
	 * @param deliveryFee the deliveryFee to set
	 */
	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
}
 
