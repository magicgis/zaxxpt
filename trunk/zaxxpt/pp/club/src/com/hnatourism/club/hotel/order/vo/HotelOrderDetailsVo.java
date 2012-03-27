package com.hnatourism.club.hotel.order.vo;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店订单详情vo
 * 
 * 历史版本: 2011-9-5 v1.0.0 (lixun) 创建 以下是几点订单详情api返回的数据结构
 * 
 * 
 * {"orderId":"4c0b6043b77d421999b4b7fee5991f49"
 * ,"code":"001762590","type":"0","hname"
 * :"上海大名星苑酒店","haddress":"上海虹口区东大名路1191号",
 * "rname":"江景套房","hcode":"0000131359","rcode"
 * :"0000509475","rnum":1,"totalMoney"
 * :516,"actualMoney":516,"bookTime":"2011-06-10"
 * ,"idate":"2011-06-02","odate":"2011-06-03"
 * ,"sts":"XD","payType":"netbank","paySts"
 * :"WZF","name":"xianren","phone":"13677778888"
 * ,"email":"xianren2003@163.com","pnames":"xianren"}
 * 
 *订单接口实际返回数据
 * {"result":{"resultCode":"","message":""},"resultBean":{"orderId":
 * "e1fba43778e344e3a4aaf277a6c77f73"
 * ,"code":"001848240","type":"0","hname":"上海大名星苑酒店"
 * ,"haddress":"","rname":"江景套房"
 * ,"hcode":"0000131359","rcode":"0000509475","rnum"
 * :1,"totalMoney":516,"actualMoney"
 * :0,"bookTime":"2011-06-24","idate":"2011-07-21"
 * ,"odate":"2011-07-22","sts":"SC"
 * ,"stsValue":"取消","payType":"netbank","paySts":
 * "WZF","name":"xianren","phone":"13677778888"
 * ,"email":"liu-xin1@hnair.com","pnames":"xianren","rmk":"订单已取消成功"}}
 */
@SuppressWarnings("serial")
public class HotelOrderDetailsVo extends AbstractVo {

	/**
	 * 地址
	 */
	private String haddress;
	
	/**
	 * 订单ID
	 */
	private String orderId;
	/**
	 * 订单号
	 */
	private String code;
	/**
	 * 城市编码
	 */
	private String city;
	
	/**
	 * 预订时间
	 */
	private String bookTime;
	/**
	 * 订单总额
	 */
	private String totalMoney;
	/**
	 * 还需支付金额
	 */
	private String actualMoney;
	/**
	 * 订单状态
	 */
	private String sts;
	/**
	 * 订单状态的中文字符
	 */
	private String stsValue;
	/**
	 * 支付方式, 网站支付 webpay,支付宝 alipay
	 */
	private String payType;
	/**
	 * 支付状态,,WZF：未支付,YZF：已支付,ZFZ：支付中
	 */
	private String paySts;
	/**
	 * 酒店编码
	 */
	private String hcode;
	/**
	 * 酒店名
	 */
	private String hname;
	/**
	 * 房型编码
	 */
	private String rcode;
	/**
	 * 房型名
	 */
	private String rname;
	/**
	 * 房间数
	 */
	private String rnum;
	/**
	 * 入住时间
	 */
	private String idate;
	/**
	 * 离店时间
	 */
	private String odate;
	/**
	 * 入住人 多人以逗号分隔
	 */
	private String pnames;
	/**
	 * 到店时间
	 */
	private String adate;
	/**
	 * 联系人
	 */
	private String name;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 电子邮箱
	 */
	private String email;
	
	// 备注，特殊需求
	private String rmk;
	// 特殊需求
	private String sneed;
	// 预计到达时间
	private String atime;
	// 最晚到达时间
	private String latime;
	// 订单生成时间
	private String ctime;
	
	//附加参数,这些参数作为临时填充数据使用
	//天数
	private String daysIn;
	//加床数
	private String bedCount;
	//没床价格
	private String bedPrice;
	//早餐数
	private String breakfastCount;
	//早餐单价
	private String breakfastPrice;
	
	/**
	 *会员ID
	 */
	private String memberId;
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
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
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
	public String getHcode() {
		return hcode;
	}
	public void setHcode(String hcode) {
		this.hcode = hcode;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	
	public String getPnames() {
		return pnames;
	}
	
	public void setPnames(String pnames) {
		this.pnames = pnames;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
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
	public String getDaysIn() {
		return daysIn;
	}
	public void setDaysIn(String daysIn) {
		this.daysIn = daysIn;
	}
	public String getBedCount() {
		return bedCount;
	}
	public void setBedCount(String bedCount) {
		this.bedCount = bedCount;
	}
	public String getBedPrice() {
		return bedPrice;
	}
	public void setBedPrice(String bedPrice) {
		this.bedPrice = bedPrice;
	}
	public String getBreakfastCount() {
		return breakfastCount;
	}
	public void setBreakfastCount(String breakfastCount) {
		this.breakfastCount = breakfastCount;
	}
	public String getBreakfastPrice() {
		return breakfastPrice;
	}
	public void setBreakfastPrice(String breakfastPrice) {
		this.breakfastPrice = breakfastPrice;
	}
	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	// setter && getter end
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
	/**
	 * @return the atime
	 */
	public String getAtime() {
		return atime;
	}
	/**
	 * @param atime the atime to set
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
	 * @param latime the latime to set
	 */
	public void setLatime(String latime) {
		this.latime = latime;
	}
	/**
	 * @return the ctime
	 */
	public String getCtime() {
		return ctime;
	}
	/**
	 * @param ctime the ctime to set
	 */
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getHaddress() {
		return haddress;
	}
	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}
}
