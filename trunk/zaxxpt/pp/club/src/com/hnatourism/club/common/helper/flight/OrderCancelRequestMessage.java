package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

/**
*机票取消订单请求串 wuyuhu
*/

public class OrderCancelRequestMessage extends RequestMessage {
	
	private String orderCode;
	private String orderHotelId;
	private String memberId;

	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL + "/order/flight/fOrderCancel.jsp?"
		+"orderCode="+orderCode
		+"&orderHotelId="+orderHotelId
		+"&memberId="+memberId;
		return url;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderHotelId() {
		return orderHotelId;
	}

	public void setOrderHotelId(String orderHotelId) {
		this.orderHotelId = orderHotelId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
