package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.web.vo.MemberVo;
/**
*用户动态 解析类 quhailong
*/
public class FlightGroupResponseMessage extends ResponseMessage{
	private MemberVo memberVo;
	private String judge;


	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		JSONObject result = (JSONObject)obj.get("result");
		if(result.get("resultCode").equals("")){
			judge = "right";
		}else{
			judge = "error";
		}
		JSONObject member = (JSONObject)obj.get("member");
		paraseMember(member);
	}

	private void paraseMember(JSONObject member) {
		memberVo = new MemberVo();
		//memberVo.setId(member.get("id").toString());
		//memberVo.setCode(member.get("code").toString());
		//memberVo.setEmail(member.get("email").toString());
		//memberVo.setPassword(member.get("password").toString());
	}

	public MemberVo getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}
	
	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}
}
