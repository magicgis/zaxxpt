package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

/**
*退票申请请求串 lianpeng
*/

public class TicketCancelRequestMessage extends RequestMessage {
	
	private String orderCode;
	private String passengerId;
	private String memberId;
	private String source;
	private String cancelType;
	private String reason;
	//fTicketCancelSave.jsp?orderCode=000132460&passengerId=u8338&memberId=dfsae2134df
	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL + "/order/flight/fTicketCancelSave.jsp?"
		+"orderCode="+orderCode
		+"&passengerId="+passengerId
		+"&memberId="+memberId
		+"&cancelType="+cancelType
		+"&reason="+reason
		+"&source=51666";
		return url;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCancelType() {
		return cancelType;
	}

	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
