package com.hnatourism.club.flight.web.vo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:三折票信息
 * 
 * 历史版本: 2011-09-05 v1.0.0 (hna) 创建:
 * 
 */
public class FlightGroupVo {
	//出发城市
	private String originCity;
	//到达城市
	private String destinationsCity;
	//出发日期
	private String startTime;
	//人数
	private String totalNumber;
	//单价
	private String price;
	//联系人
	private String name;
	//联系方式
	private String contact;
	//特殊需求
	private String groupDesire;
	//邮箱
	private String email;
	//用户ID
	private String memberId;
	//用户Code
	private String memberCode;
	//是否登陆
	private String isLogin;
	//来源
	private String source;
	
	public String getOriginCity() {
		return originCity;
	}
	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}
	public String getDestinationsCity() {
		return destinationsCity;
	}
	public void setDestinationsCity(String destinationsCity) {
		this.destinationsCity = destinationsCity;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGroupDesire() {
		return groupDesire;
	}
	public void setGroupDesire(String groupDesire) {
		this.groupDesire = groupDesire;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
}
