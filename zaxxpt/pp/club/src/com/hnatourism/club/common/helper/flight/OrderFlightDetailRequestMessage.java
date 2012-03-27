package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

/**
*机票详情请求串 wuyuhu
*/

public class OrderFlightDetailRequestMessage extends RequestMessage {
	
	private String orderId;

	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL + "/order/flight/newOrderFlightDetail.jsp?"+"orderId="+orderId;
		return url;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
