/**
 * 
 */
package com.hnatourism.club.common.util;



/**
 * @author gujianliang
 * @2011-8-31
 */
public class SubRunBean {

	/**
	 * 用户
	 */
	private	String cardNo;	            //现金来源账户
	private	String privilegeType;		//直减1 返积分2
	private	String account;	            //用户分润账户
	private	String platformAccount;	    //平台分润账户
	private	String subCorpAccount;	    //分公司分润账户
	private	String roleCode;	        //角色      GOLD金管家      PLATINUM白金管家     DIAMOND钻石管家       GOVERNMENT政企管家
	
	/**  
	 * 产品
	 */
	private	String sellerCardNo;			//产品提供商账户     DB
	private String prodType;				//产品类型     GF高尔夫    F机票      L机场休息室      H酒店
	private Double prodSalePrice;		//产品销售价
	private Double prodSignprice;	    //产品签约价
	private Double prodPrice;			//购买价
	private Double salerPoint;          //商家返点
	private Double attPrice;            //其他附加费用
	/**
	 * 订单
	 */
	private String orderId;				//订单id
	private String orderCode;			//订单号
	private String orderType;			//订单type
	private Double orderPrice;			//总价
	private Double orderSignprice;		//底价
	private Double orderRetPrice;		//直返金额
	private Double orderExPrice;		//附加价格总和
	private Double deviationPrice=0.0;      //误差背离金额
	
	//按照人收费单收费项目总和
	private Double attPepoPrice;
	//按照单收费总和
	private Double attOrderPrice;
	//按照单收费低价总和
	private Double attOrderLowPrice=0.0;
	//按照人收费单收费项目低价总和
	private Double attPepoLowPrice=0.0;
	
	//退改使用
	private Double fee;//手续费
	private Double sellerfee;//扣除费  给供应商
	private Double sellerMoney;//产品提供商钱
	private Double amountMoney;//用户分润帐号
	
	/**
	 * 分润使用（根据汇付要求格式拼接）
	 */
	private String sellerDetail;   //产品提供商 
	private String details;        //分润详细
	
	
	/**
	 * 需要计算的
	 */
	private Double subCorpNoMoney;  //分公司钱
	private Double platformNoMoney; //平台钱
	
	//退给用户的金额
	private Double returnPrice;
	
	
	/**
	 * 政企管家用
	 */
	private Double subCorpPoint =0.0;//分公司分点
	private Double platformPoint=0.0;//平台分点
	private String profitpoint="ALL";//平台和分公司分点    ALL为全分
	private String memberFlowpoint="ALL";//会员享受最低点    ALL为全分
	
	
	
	public Double getSubCorpPoint() {
		return subCorpPoint;
	}
	public void setSubCorpPoint(Double subCorpPoint) {
		this.subCorpPoint = subCorpPoint;
	}
	public Double getPlatformPoint() {
		return platformPoint;
	}
	public void setPlatformPoint(Double platformPoint) {
		this.platformPoint = platformPoint;
	}
	public String getProfitpoint() {
		return profitpoint;
	}
	public void setProfitpoint(String profitpoint) {
		this.profitpoint = profitpoint;
	}
	public String getMemberFlowpoint() {
		return memberFlowpoint;
	}
	public void setMemberFlowpoint(String memberFlowpoint) {
		this.memberFlowpoint = memberFlowpoint;
	}
	public Double getReturnPrice() {
		return returnPrice;
	}
	public void setReturnPrice(Double returnPrice) {
		this.returnPrice = returnPrice;
	}
	public Double getAttPrice() {
		return attPrice;
	}
	public void setAttPrice(Double attPrice) {
		this.attPrice = attPrice;
	}
	public Double getAttPepoPrice() {
		return attPepoPrice;
	}
	public void setAttPepoPrice(Double attPepoPrice) {
		this.attPepoPrice = attPepoPrice;
	}
	public Double getAttOrderPrice() {
		return attOrderPrice;
	}
	public void setAttOrderPrice(Double attOrderPrice) {
		this.attOrderPrice = attOrderPrice;
	}
	public Double getSubCorpNoMoney() {
		return subCorpNoMoney;
	}
	public void setSubCorpNoMoney(Double subCorpNoMoney) {
		this.subCorpNoMoney = subCorpNoMoney;
	}
	public Double getPlatformNoMoney() {
		return platformNoMoney;
	}
	public void setPlatformNoMoney(Double platformNoMoney) {
		this.platformNoMoney = platformNoMoney;
	}
	public String getSellerDetail() {
		return sellerDetail;
	}
	public void setSellerDetail(String sellerDetail) {
		this.sellerDetail = sellerDetail;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public Double getSellerfee() {
		return sellerfee;
	}
	public void setSellerfee(Double sellerfee) {
		this.sellerfee = sellerfee;
	}
	public Double getAmountMoney() {
		return amountMoney;
	}
	public void setAmountMoney(Double amountMoney) {
		this.amountMoney = amountMoney;
	}
	public String getPrivilegeType() {
		return privilegeType;
	}
	public void setPrivilegeType(String privilegeType) {
		this.privilegeType = privilegeType;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPlatformAccount() {
		return platformAccount;
	}
	public void setPlatformAccount(String platformAccount) {
		this.platformAccount = platformAccount;
	}
	public String getSubCorpAccount() {
		return subCorpAccount;
	}
	public void setSubCorpAccount(String subCorpAccount) {
		this.subCorpAccount = subCorpAccount;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getSellerCardNo() {
		return sellerCardNo;
	}
	public void setSellerCardNo(String sellerCardNo) {
		this.sellerCardNo = sellerCardNo;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public Double getProdSalePrice() {
		return prodSalePrice;
	}
	public void setProdSalePrice(Double prodSalePrice) {
		this.prodSalePrice = prodSalePrice;
	}
	public Double getProdSignprice() {
		return prodSignprice;
	}
	public void setProdSignprice(Double prodSignprice) {
		this.prodSignprice = prodSignprice;
	}
	public Double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Double getOrderSignprice() {
		return orderSignprice;
	}
	public void setOrderSignprice(Double orderSignprice) {
		this.orderSignprice = orderSignprice;
	}
	public Double getOrderRetPrice() {
		return orderRetPrice;
	}
	public void setOrderRetPrice(Double orderRetPrice) {
		this.orderRetPrice = orderRetPrice;
	}
	public Double getOrderExPrice() {
		return orderExPrice;
	}
	public void setOrderExPrice(Double orderExPrice) {
		this.orderExPrice = orderExPrice;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Double getSellerMoney() {
		return sellerMoney;
	}
	public void setSellerMoney(Double sellerMoney) {
		this.sellerMoney = sellerMoney;
	}
	public Double getAttOrderLowPrice() {
		return attOrderLowPrice;
	}
	public void setAttOrderLowPrice(Double attOrderLowPrice) {
		this.attOrderLowPrice = attOrderLowPrice;
	}
	public Double getAttPepoLowPrice() {
		return attPepoLowPrice;
	}
	public void setAttPepoLowPrice(Double attPepoLowPrice) {
		this.attPepoLowPrice = attPepoLowPrice;
	}
	public Double getSalerPoint() {
		return salerPoint;
	}
	public void setSalerPoint(Double salerPoint) {
		this.salerPoint = salerPoint;
	}
	public Double getDeviationPrice() {
		return deviationPrice;
	}
	public void setDeviationPrice(Double deviationPrice) {
		this.deviationPrice = deviationPrice;
	}
	
}
