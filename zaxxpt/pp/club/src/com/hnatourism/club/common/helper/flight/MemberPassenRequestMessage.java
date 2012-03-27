package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
/**
*根据用户ID 所有乘机热门 wuyuhu
*/
public class MemberPassenRequestMessage extends RequestMessage {

	String memberId;

	@Override
	public String getRequsetString() {
		String queryStr = BASE_REQUEST_URL
				+ "/prod/flight/memberPassengerSearch.jsp?" + "memberId=" + memberId;
		return queryStr;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
