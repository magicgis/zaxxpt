/**
 * 
 */
package com.hnatourism.club.pay;

/**
 * @author gujianliang
 * @2011-8-23
 */
public class PayVo {

	//应答码  000000代表成功
	private String RespCode;
	//余额账号
	private String UsrId;
	//错误信息  错误时，返回原因
	private String ErrMsg;
	//可用余额
	private String AcctBal;
	//冻结金额
	private String FrzBal;
	//旧密码
	private String OldTransPwd;
	//新密码
	private String NewTransPwd;
	
	//订单号
	private String orderId;
	//支付通道    1，支付宝 	2，财付通 3，汇付 	4 , 网上银行支付(直连)
	private String paymentType;
	//付款方式   1，余额支付 2 , 网银支付  3 , 信用卡支付
	private String payType;
	//卖家分账明细   格式为：卖家收款账号^金额^备注
	private String seller_details;
	//分润方分账明细 格式为：	收款方账号1^金额^备注|收款方账号1^金额   如有多条则用“|”隔开，最多不能超过10条，备注最多1000个字符，即500个汉
	private String details;
	//支付账号
	private String buyer_account;
	//支付金额
	private String  total_fee;
	//通知地址
	private String notify_url;
	
	//签约类型
	private String type;
	//签约帐号
	private String account;
	//签约后的账户
	private String signed_account;
	//签约后的流水号
	private String batchNo;
	
	
	//充值金额
	private String OrdAmt;
	//充值账号
	private String OperId;
	//充值订单号
	private String OrdId;
	//充值交易号
	private String TradeNo;
	//充值通知地址
	private String NotifyUrl;
	
	
	//退款通道
   private String payback_type="3";
   //交易号
   private String 	trade_no;
   //退款手续费
   private String refund_fee;
	//退款总金额
   private String refund_amount;
   //未分账全退标识       可为空，T代表未分账全退
   private String  unbalance;
   //卖家退款明细   格式为：   退款方账号1^金额^备注
  // private String  seller_details;
   //退款明细   格式为：   退款方账号1^金额^备注|退款方账号1^金额^备注      如有多条则用“|”隔开，最多不能超过10条，备注最多1000个字符，即500个汉
   //private String  details;
   //退款描述
   private String descrition;

   //支付接口调用地址
	private String address;
   
   
	//充值接口 用户私有内容
	private String MerPriv;
	
	
	public String getMerPriv() {
		return MerPriv;
	}
	public void setMerPriv(String merPriv) {
		MerPriv = merPriv;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPayback_type() {
	return payback_type;
}
public void setPayback_type(String paybackType) {
	payback_type = paybackType;
}
public String getTrade_no() {
	return trade_no;
}
public void setTrade_no(String tradeNo) {
	trade_no = tradeNo;
}
public String getRefund_fee() {
	return refund_fee;
}
public void setRefund_fee(String refundFee) {
	refund_fee = refundFee;
}
public String getRefund_amount() {
	return refund_amount;
}
public void setRefund_amount(String refundAmount) {
	refund_amount = refundAmount;
}
public String getUnbalance() {
	return unbalance;
}
public void setUnbalance(String unbalance) {
	this.unbalance = unbalance;
}
public String getDescrition() {
	return descrition;
}
public void setDescrition(String descrition) {
	this.descrition = descrition;
}
	public String getNotifyUrl() {
		return NotifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		NotifyUrl = notifyUrl;
	}
	public String getOrdAmt() {
		return OrdAmt;
	}
	public void setOrdAmt(String ordAmt) {
		OrdAmt = ordAmt;
	}
	public String getOperId() {
		return OperId;
	}
	public void setOperId(String operId) {
		OperId = operId;
	}
	public String getOrdId() {
		return OrdId;
	}
	public void setOrdId(String ordId) {
		OrdId = ordId;
	}
	public String getTradeNo() {
		return TradeNo;
	}
	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSigned_account() {
		return signed_account;
	}
	public void setSigned_account(String signedAccount) {
		signed_account = signedAccount;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notifyUrl) {
		notify_url = notifyUrl;
	}
	public String getRespCode() {
		return RespCode;
	}
	public void setRespCode(String respCode) {
		RespCode = respCode;
	}
	public String getUsrId() {
		return UsrId;
	}
	public void setUsrId(String usrId) {
		UsrId = usrId;
	}
	public String getErrMsg() {
		return ErrMsg;
	}
	public void setErrMsg(String errMsg) {
		ErrMsg = errMsg;
	}
	public String getAcctBal() {
		return AcctBal;
	}
	public void setAcctBal(String acctBal) {
		AcctBal = acctBal;
	}
	public String getFrzBal() {
		return FrzBal;
	}
	public void setFrzBal(String frzBal) {
		FrzBal = frzBal;
	}
	public String getOldTransPwd() {
		return OldTransPwd;
	}
	public void setOldTransPwd(String oldTransPwd) {
		OldTransPwd = oldTransPwd;
	}
	public String getNewTransPwd() {
		return NewTransPwd;
	}
	public void setNewTransPwd(String newTransPwd) {
		NewTransPwd = newTransPwd;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getSeller_details() {
		return seller_details;
	}
	public void setSeller_details(String sellerDetails) {
		seller_details = sellerDetails;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getBuyer_account() {
		return buyer_account;
	}
	public void setBuyer_account(String buyerAccount) {
		buyer_account = buyerAccount;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String totalFee) {
		total_fee = totalFee;
	}
	
}
