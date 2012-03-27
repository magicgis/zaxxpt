package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

/**
*退票申请请求串 lianpeng
*/

public class TicketCancelSearchRequestMessage extends RequestMessage {
	
	private String orderCode;
	//fTicketCancelSave.jsp?orderCode=000132460&passengerId=u8338&memberId=dfsae2134df
	@Override
	public String getRequsetString() {
		String url = BASE_REQUEST_URL + "/order/flight/fTicketCancelSearch.jsp?orderCode="+orderCode;
		return url;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

}
