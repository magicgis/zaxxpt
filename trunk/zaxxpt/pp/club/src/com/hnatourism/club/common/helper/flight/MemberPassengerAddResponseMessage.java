package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.web.vo.MemberPassengerAddVo;
/**
*解析乘机人信息 wuyuhu
*/

public class MemberPassengerAddResponseMessage extends ResponseMessage {

	ArrayList<MemberPassengerAddVo> MemberPassenAddList;

	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		// TODO Auto-generated method stub
		MemberPassenAddList = new ArrayList<MemberPassengerAddVo>();
		JSONObject resultObj = (JSONObject) obj.get("result");
		if (resultObj != null) {
			//extractPasAdd(passenger, MemberPassenAddList);
		}
	}

	private void extractPasAdd(JSONArray passenger,
			List<MemberPassengerAddVo> passengerList) {

		MemberPassengerAddVo mpsaddvo;
		for (int i = 0; i < passenger.size(); i++) {
			JSONObject psge = (JSONObject) passenger.get(i);
			mpsaddvo = new MemberPassengerAddVo();
			// 返回信息编码
			mpsaddvo.setResultCode(psge.get("resultCode").toString());
			// 返回信息massage
			mpsaddvo.setMessage(psge.get("message").toString());
			passengerList.add(mpsaddvo);

		}
	}

	public ArrayList<MemberPassengerAddVo> getMemberPassenAddList() {
		return MemberPassenAddList;
	}

	public void setMemberPassenAddList(
			ArrayList<MemberPassengerAddVo> memberPassenAddList) {
		MemberPassenAddList = memberPassenAddList;
	}

}
