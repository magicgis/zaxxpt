package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
import com.hnatourism.club.flight.passenger.MemberPassengerVo;

/**
*新增常用乘机人请求 wuyuhu
*/
public class MemberPassengerAddRequestMessage extends RequestMessage {
	// 用户ID
	String memberId;
	// 用户编码
	String memberCode;
	// 存放memberPassengerVo 乘机人信息list
	ArrayList<MemberPassengerVo> memberPassengerVoList;
	// 乘机人总人数
	String personNum;
    String psnadd = "";
	@Override
	public String getRequsetString() {
		String queryStr = BASE_REQUEST_URL
				+ "/prod/flight/memberPassengerAdd.jsp?" + "memberId="
				+ memberId + "&memberCode=" + memberCode
				+"&personNum="+personNum
			    + getPsnadd(memberPassengerVoList);

		return queryStr;
	}
	//拼接乘机人信息url
	public String getPsnadd(ArrayList<MemberPassengerVo> pasaddlist){
		StringBuffer pasadd = new StringBuffer("");
		for(int i =0;i<pasaddlist.size();i++){
			MemberPassengerVo mpasvo = pasaddlist.get(i);
			pasadd.append("&memberPassengerVoList[" + i + "].id=")
			.append(mpasvo.getId())
			.append("&memberPassengerVoList[" + i + "].name=")
			.append(mpasvo.getName())
			.append("&memberPassengerVoList[" + i + "].type=")
			.append(mpasvo.getType())
			.append("&memberPassengerVoList[" + i + "].certType=")
			.append(mpasvo.getCertType())
			.append("&memberPassengerVoList[" + i + "].certNo=")
			.append(mpasvo.getCertNo());
		}
		return pasadd.toString();
	}
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public ArrayList<MemberPassengerVo> getMemberPassengerVoList() {
		return memberPassengerVoList;
	}

	public void setMemberPassengerVoList(
			ArrayList<MemberPassengerVo> memberPassengerVoList) {
		this.memberPassengerVoList = memberPassengerVoList;
	}

	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

}
