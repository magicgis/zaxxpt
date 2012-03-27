package com.hnatourism.club.golf.prod.vo;

import java.util.Date;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫订单VO
 * 
 * 历史版本:2010-08-04 v1.0.0 (苏忆) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfConfirmVo extends AbstractVo{
	//订单ID
	private String orderId;
	//订单状态
	private String orderState;
	//订单生成时间
	private String orderGenerateDate;
	//订场规则
	private String orderRule;
	//场地名称
	private String siteName;
	//下场时间
	private String siteDate;
	//场地类型
	private String siteType;
	//场地
	private String siteCode;
	//产品名称
	private String productName;
	//包含项目
	private String includeItem;
	//打球人数
	private String playerCount;
	//姓名
	private String playerNames;
	//预订时间
	private String bookDate;
	//联系人信息
	private String userName;
	//联系方式
	private String telephone;
	//订单生成时间
	private String orderDate;
	//订单跟踪记录显示
	private String orderTrace;
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderTrace() {
		return orderTrace;
	}
	public void setOrderTrace(String orderTrace) {
		this.orderTrace = orderTrace;
	}
	public String getBallCount() {
		return ballCount;
	}
	public void setBallCount(String ballCount) {
		this.ballCount = ballCount;
	}
	//订单金额
	private String orderPrice;
	//球数
	private String ballCount;
	public String getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getOrderGenerateDate() {
		return orderGenerateDate;
	}
	public void setOrderGenerateDate(String orderGenerateDate) {
		this.orderGenerateDate = orderGenerateDate;
	}
	public String getOrderRule() {
		return orderRule;
	}
	public void setOrderRule(String orderRule) {
		this.orderRule = orderRule;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteDate() {
		return siteDate;
	}
	public void setSiteDate(String siteDate) {
		this.siteDate = siteDate;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getIncludeItem() {
		return includeItem;
	}
	public void setIncludeItem(String includeItem) {
		this.includeItem = includeItem;
	}
	public String getPlayerCount() {
		return playerCount;
	}
	public void setPlayerCount(String playerCount) {
		this.playerCount = playerCount;
	}
	public String getPlayerNames() {
		return playerNames;
	}
	public void setPlayerNames(String playerNames) {
		this.playerNames = playerNames;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
