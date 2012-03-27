package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
import com.hnatourism.club.flight.passenger.MemberPassengerVo;

/**
*删除常用乘机人请求 quhailong
*/
public class MemberPassengerDelRequestMessage extends RequestMessage{
	// 存放memberPassengerVo 乘机人信息list
	private ArrayList<MemberPassengerVo> memberPassengerVoList;
	// 乘机人总人数
	private String personNum;
	@Override
	public String getRequsetString() {
		String queryStr = BASE_REQUEST_URL
		+ "/prod/flight/memberPassengerDel.jsp?"
		+"personNum="+personNum
		+ getPsnadd(memberPassengerVoList);
		return queryStr;
	}
	
	//拼接乘机人信息url
	public String getPsnadd(ArrayList<MemberPassengerVo> pasaddlist){
		StringBuffer pasadd = new StringBuffer("");
		for(int i =0;i<pasaddlist.size();i++){
			MemberPassengerVo mpasvo = pasaddlist.get(i);
			pasadd.append("&memberPassengerVoList[" + i + "].id=")
			.append(mpasvo.getId());
		}
		return pasadd.toString();
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
