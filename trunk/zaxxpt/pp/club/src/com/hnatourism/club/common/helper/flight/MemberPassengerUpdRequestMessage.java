package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
import com.hnatourism.club.flight.passenger.MemberPassengerVo;

public class MemberPassengerUpdRequestMessage extends RequestMessage{
	
	private MemberPassengerVo memberPassengerVo;
	@Override
	public String getRequsetString() {
		String queryStr = BASE_REQUEST_URL
		+ "/prod/flight/memberPassengerUpd.jsp?"
		+ getPsnupd(memberPassengerVo);
		return queryStr;
	}
	
	//拼接乘机人信息url
	public String getPsnupd(MemberPassengerVo mpasvo){
		StringBuffer pasadd = new StringBuffer("");
		pasadd.append("memberId=")
		.append(mpasvo.getMemberId())
		.append("&memberCode=")
		.append(mpasvo.getMemberCode())
		.append("&id=")
		.append(mpasvo.getId())
		.append("&name=")
		.append(mpasvo.getName())
		.append("&type=")
		.append(mpasvo.getType())
		.append("&certType=")
		.append(mpasvo.getCertType())
		.append("&certNo=")
		.append(mpasvo.getCertNo());
		
		return pasadd.toString();
	}

	public MemberPassengerVo getMemberPassengerVo() {
		return memberPassengerVo;
	}

	public void setMemberPassengerVo(MemberPassengerVo memberPassengerVo) {
		this.memberPassengerVo = memberPassengerVo;
	}
}
