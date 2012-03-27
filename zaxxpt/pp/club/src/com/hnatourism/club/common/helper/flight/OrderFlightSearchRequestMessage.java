package com.hnatourism.club.common.helper.flight;

import java.net.URLEncoder;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
/**
*订单列表 请求类 wuyuhu
*/
public class OrderFlightSearchRequestMessage extends RequestMessage {
	
	private String memberId;
	
	/**
	 * 订单号
	 */
	private String orderCode;
	
	/**
	 * 订单状态：
	 */
	private String sts;
	
	//代客下单生成订单的操作员
	private String operatorUser;
	//票号
	private String etNo;
	//证件号码
	private String certNo;
	//PNR
	private String pnr;
	
	//订单来源
	private String source;
	
	//命令标志
	private String cmd;
	
	//乘客姓名
	private String pName;

	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL + "/order/flight/orderFlightSearch.jsp?"+"memberId="+memberId;
		if(orderCode!=null&&!orderCode.trim().equals("")){
			url+="&orderCode="+orderCode;
		}
		if(sts!=null&&!sts.trim().equals("")){
			url+="&sts="+sts;
		}
		if(operatorUser!=null&&!operatorUser.trim().equals("")){
			url+="&operatorUser="+operatorUser;
		}
		if(etNo!=null&&!etNo.trim().equals("")){
			url+="&etNo="+etNo;
		}
		if(certNo!=null&&!certNo.trim().equals("")){
			url+="&certNo="+certNo;
		}
		if(pnr!=null&&!pnr.trim().equals("")){
			url+="&pnr="+pnr;
		}
		if(cmd!=null&&!cmd.trim().equals("")){
			url+="&cmd="+cmd;
		}
		if(source!=null&&!source.trim().equals("")){
			url+="&source="+source;
		}
		if(pName!=null&&!pName.trim().equals("")){
			try{
				url+="&pName="+URLEncoder.encode(pName,"utf-8");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return url;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getOperatorUser() {
		return operatorUser;
	}

	public void setOperatorUser(String operatorUser) {
		this.operatorUser = operatorUser;
	}

	public String getEtNo() {
		return etNo;
	}

	public void setEtNo(String etNo) {
		this.etNo = etNo;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPName() {
		return pName;
	}

	public void setPName(String name) {
		pName = name;
	}
	
	

	
	
	
	
}
