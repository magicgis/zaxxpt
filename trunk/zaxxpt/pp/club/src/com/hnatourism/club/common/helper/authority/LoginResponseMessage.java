package com.hnatourism.club.common.helper.authority;

import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.MemberInfo.MemberInfoVo;


public class LoginResponseMessage extends ResponseMessage {
	
	private MemberInfoVo memberInfoVo;
	
	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		memberInfoVo=new MemberInfoVo();
		memberInfoVo.setId((String) obj.get("memberId"));
		memberInfoVo.setCode((String) obj.get("code"));
		memberInfoVo.setMobile((String) obj.get("mobile"));
		memberInfoVo.setEmail((String) obj.get("email"));
	}

	public MemberInfoVo getMemberInfoVo() {
		return memberInfoVo;
	}

	public void setMemberInfoVo(MemberInfoVo memberInfoVo) {
		this.memberInfoVo = memberInfoVo;
	}
	
	

}
