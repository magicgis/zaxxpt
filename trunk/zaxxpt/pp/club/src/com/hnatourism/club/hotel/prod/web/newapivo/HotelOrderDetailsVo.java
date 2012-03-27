package com.hnatourism.club.hotel.prod.web.newapivo;

import java.text.ParseException;

import com.hnatourism.club.common.util.DateUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店订单详情信息
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelOrderDetailsVo {

	/** property */
	private String orderId;

	/** property */
	private String code;

	/** property */
	private String type;

	/** property */
	private String hname;

	/** property */
	private String haddress;

	/** property */
	private String rname;

	/** property */
	private String hcode;

	/** property */
	private String rcode;

	/** property */
	private String rnum;

	/** property */
	private String totalMoney;

	/** property */
	private String actualMoney;

	/** property */
	private String bookTime;

	/** property */
	private String idate;

	/** property */
	private String odate;

	/** property */
	private String sts;
	
	private String stsValue;

	/** property */
	private String payType;

	/** property */
	private String paySts;

	/** property */
	private String name;

	/** property */
	private String phone;

	/** property */
	private String email;

	/** property */
	private String pnames;

	/** property */
	private String ctime;

	private String rmk;

	private String atime;

	private String latime;
	//特殊需求
	private String sneed;

//	private int daysIn;

	/**
	 * @return the daysIn
	 */
	public int getDaysIn() {
		int days = 0;
		try {
			days = DateUtils.comDate(DateUtils.parseDate(this.idate, "yyyy-MM-dd"),
					DateUtils.parseDate(this.odate, "yyyy-MM-dd"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return days;
	}

	/**
	 * @return the atime
	 */
	public String getAtime() {
		return atime;
	}

	/**
	 * @param atime
	 *            the atime to set
	 */
	public void setAtime(String atime) {
		this.atime = atime;
	}

	/**
	 * @return the latime
	 */
	public String getLatime() {
		return latime;
	}

	/**
	 * @param latime
	 *            the latime to set
	 */
	public void setLatime(String latime) {
		this.latime = latime;
	}

	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * @param rmk
	 *            the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	/**
	 * @return the ctime
	 */
	public String getCtime() {
		return ctime;
	}

	/**
	 * @param ctime
	 *            the ctime to set
	 */
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

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

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	/**
	 * @return the stsValue
	 */
	public String getStsValue() {
		return stsValue;
	}

	/**
	 * @param stsValue the stsValue to set
	 */
	public void setStsValue(String stsValue) {
		this.stsValue = stsValue;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getHcode() {
		return hcode;
	}

	public void setHcode(String hcode) {
		this.hcode = hcode;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	/**
	 * @return the sneed
	 */
	public String getSneed() {
		return sneed;
	}

	/**
	 * @param sneed the sneed to set
	 */
	public void setSneed(String sneed) {
		this.sneed = sneed;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(String actualMoney) {
		this.actualMoney = actualMoney;
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

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPnames() {
		return pnames;
	}

	public void setPnames(String pnames) {
		this.pnames = pnames;
	}

}
