package com.hnatourism.club.hotel.order.vo;


import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店订单vo
 * 
 * 历史版本: 2011-9-5 v1.0.0 (lixun) 创建
 * 
 * 以下是api返回的数据结构
 * {"orderId":"d7c109ebe8e54754ab3c8ceef25f8f13","code":"001762200"
 * ,"type":"0","hname"
 * :"上海大名星苑酒店","totalMoney":516,"bookTime":"2011-06-10","idate"
 * :"2011-06-02","sts":"新单"}
 * 
 */
@SuppressWarnings("serial")
public class HotelOrderVo extends AbstractVo {
	
	/**
	 * 订单ID
	 */
	private String orderId;
	/**
	 * 订单号
	 */
	private String code;
	/**
	 * 订单类型 0是普通订单 1是团购订单
	 */
	private String type;
	/**
	 * 酒店名称
	 */
	private String hname;
	/**
	 * 金额
	 */
	private String totalMoney;
	/**
	 * 订单日期
	 */
	private String bookTime;
	/**
	 * 入住日期
	 */
	private String idate;
	/**
	 * 订单状态,XD：未支付,YQR：已支付,SC：已取消
	 */
	private String sts;
	
	/**
	 * 订单转单字符串
	 */
	private String stsValue;
	
	// setter && getter
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getStsValue() {
		return stsValue;
	}
	public void setStsValue(String stsValue) {
		this.stsValue = stsValue;
	}
	
	// setter && getter end

}
