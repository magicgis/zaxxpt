package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店预订信息vo (非查询)
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelBookVo {
	
	private String memberId;// 必填项;//用户编码
	private String isFirst;// 必填项;//是否是新用户预订，1为是，0为否
	private String rmk;// ;//0备注
	private String totalMoney;// 必填;//订单金额
	private String source;// ;//订单来源（iphone或android）
	
	// private String 酒店房型信息;//;//
	private String hcode;// 必填项;//酒店编码
	private String rcode;// 必填项;//房型编码
	private String idate;// 必填项;//入住时间 YYYY-MM-DD
	private String odate;// 必填项;//离店时间YYYY-MM-DD
	private String adate;// 必填项;//预计到点时间 HH:MM-HH:MM
	private int pnum;// 必填项;//入住人数
	private String pname;// 必填项;//入住人姓名 多人使用逗号“，“分隔
	
	// private String contact;//;//联系人信息
	private String contact_name;// 必填项;//联系人
	private String contact_phone;// 必填项;//联系电话
	private String contact_mobile;// ;//预订手机号
	private String contact_email;// ;//电子邮箱
	
	// private String 发票信息;//;//
	
	private String invoice_needtype;// ;//是否需要发票 Y 是 ，N否
	private String invoice_head;// ;//发票抬头 个人
	private String invoice_person;// ;//发票收件人
	private String invoice_mobile;// ;//发票收件人电话
	private String invoice_address;// ;//发票收件地址
	private String invoice_zipcode;// ;//发票邮编
	private String invoice_deliverytype;// ;//邮寄方式

	private String key;// 必填;//新华旅行网分配的唯一授权码
	private String syssource;// 选填;//系统来源
	private String roomPlanCode;// 必填;//房型计划编码
	private String payType;// 必填;//支付类型:1-现付,2-预付
	private String credit_name;// 选填;//持卡人姓名
	private String credit_cardNum;// 选填;//信用卡号码
	private String credit_cardType;// 选填;//信用卡卡种
	private String credit_expireDate;// 选填;//信用卡有效期
	private String credit_idNum;// 选填;//证件号码
	private String credit_idType;// 选填;//证件类型
	private String customCommission;// 选填;//渠道自定义佣金比例
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
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
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int room) {
		this.pnum = room;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contactName) {
		contact_name = contactName;
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contactPhone) {
		contact_phone = contactPhone;
	}
	public String getContact_mobile() {
		return contact_mobile;
	}
	public void setContact_mobile(String contactMobile) {
		contact_mobile = contactMobile;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contactEmail) {
		contact_email = contactEmail;
	}
	public String getInvoice_needtype() {
		return invoice_needtype;
	}
	public void setInvoice_needtype(String invoiceNeedtype) {
		invoice_needtype = invoiceNeedtype;
	}
	public String getInvoice_head() {
		return invoice_head;
	}
	public void setInvoice_head(String invoiceHead) {
		invoice_head = invoiceHead;
	}
	public String getInvoice_person() {
		return invoice_person;
	}
	public void setInvoice_person(String invoicePerson) {
		invoice_person = invoicePerson;
	}
	public String getInvoice_mobile() {
		return invoice_mobile;
	}
	public void setInvoice_mobile(String invoiceMobile) {
		invoice_mobile = invoiceMobile;
	}
	public String getInvoice_address() {
		return invoice_address;
	}
	public void setInvoice_address(String invoiceAddress) {
		invoice_address = invoiceAddress;
	}
	public String getInvoice_zipcode() {
		return invoice_zipcode;
	}
	public void setInvoice_zipcode(String invoiceZipcode) {
		invoice_zipcode = invoiceZipcode;
	}
	public String getInvoice_deliverytype() {
		return invoice_deliverytype;
	}
	public void setInvoice_deliverytype(String invoiceDeliverytype) {
		invoice_deliverytype = invoiceDeliverytype;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSyssource() {
		return syssource;
	}
	public void setSyssource(String syssource) {
		this.syssource = syssource;
	}
	public String getRoomPlanCode() {
		return roomPlanCode;
	}
	public void setRoomPlanCode(String roomPlanCode) {
		this.roomPlanCode = roomPlanCode;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getCredit_name() {
		return credit_name;
	}
	public void setCredit_name(String creditName) {
		credit_name = creditName;
	}
	public String getCredit_cardNum() {
		return credit_cardNum;
	}
	public void setCredit_cardNum(String creditCardNum) {
		credit_cardNum = creditCardNum;
	}
	public String getCredit_cardType() {
		return credit_cardType;
	}
	public void setCredit_cardType(String creditCardType) {
		credit_cardType = creditCardType;
	}
	public String getCredit_expireDate() {
		return credit_expireDate;
	}
	public void setCredit_expireDate(String creditExpireDate) {
		credit_expireDate = creditExpireDate;
	}
	public String getCredit_idNum() {
		return credit_idNum;
	}
	public void setCredit_idNum(String creditIdNum) {
		credit_idNum = creditIdNum;
	}
	public String getCredit_idType() {
		return credit_idType;
	}
	public void setCredit_idType(String creditIdType) {
		credit_idType = creditIdType;
	}
	public String getCustomCommission() {
		return customCommission;
	}
	public void setCustomCommission(String customCommission) {
		this.customCommission = customCommission;
	}
	
	
}
