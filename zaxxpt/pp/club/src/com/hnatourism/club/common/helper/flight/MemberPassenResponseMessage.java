package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.web.vo.FlightMemberPassenVo;
/**
*解析所有乘机人 wuyuhu
*/

public class MemberPassenResponseMessage extends ResponseMessage {

	ArrayList<FlightMemberPassenVo> MemberPassenList;

	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		// TODO Auto-generated method stub
		MemberPassenList = new ArrayList<FlightMemberPassenVo>();
		JSONArray passenger = (JSONArray) obj.get("passenger");
		if (passenger != null) {
			extractFlightInfos(passenger, MemberPassenList);
		}
	}

	private void extractFlightInfos(JSONArray passenger,
			List<FlightMemberPassenVo> passengerList) {

		FlightMemberPassenVo fmpvo;
		for (int i = 0; i < passenger.size(); i++) {
			JSONObject psge = (JSONObject) passenger.get(i);
			fmpvo = new FlightMemberPassenVo();
			// 名称
			fmpvo.setName(psge.get("name").toString());
			// 乘机人 ID
			fmpvo.setId(psge.get("id").toString());
			// 证件号码（类型为儿童，证件类型选择为出生日期时，格式为：YYYY-MM-DD）
			fmpvo.setCertNo(psge.get("certNo").toString());
			// 乘客类型为01成人时：证件类型: 0身份证;1护照; 2军官证;
			// 3港澳通行证 ; 4回乡证; 5台胞证; 6国际海员证; 7外国人永久居留证;
			// 9其他；乘客类型为02儿童时：证件类型：0身份证;9出生日期
			fmpvo.setCertType(psge.get("certType").toString());
			// 乘客类型01成人; 02儿童
			fmpvo.setType(psge.get("type").toString());
			passengerList.add(fmpvo);

		}
	}

	public ArrayList<FlightMemberPassenVo> getMemberPassenList() {
		return MemberPassenList;
	}

	public void setMemberPassenList(
			ArrayList<FlightMemberPassenVo> memberPassenList) {
		MemberPassenList = memberPassenList;
	}
}
