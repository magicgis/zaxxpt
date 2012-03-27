package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.MemberInfo.MemberInfoVo;
/**
*解析用户信息 wuyuhu
*/

public class MemberInfoResponseMessage extends ResponseMessage{
	public MemberInfoVo voInfo;
	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		JSONObject memberInfo = (JSONObject) obj.get("memberinfo");
		String id=(String)memberInfo.get("id");
		String code=(String)memberInfo.get("code");
		String email=(String)memberInfo.get("email");
		String password=(String)memberInfo.get("password");
		String name=(String)memberInfo.get("name");
		String sex=(String)memberInfo.get("sex");
		String birthdateYear=(String)memberInfo.get("birthdateYear");
		String birthdateMonth=(String)memberInfo.get("birthdateMonth");
		String birthdateDay=(String)memberInfo.get("birthdateDay");
		String phone=(String)memberInfo.get("phone");
		String mobile=(String)memberInfo.get("mobile");
		String address=(String)memberInfo.get("address");
		String emailChecking=(String)memberInfo.get("emailChecking");
		String mobileBinding=(String)memberInfo.get("mobileBinding");
		String registrationDate=(String)memberInfo.get("registration_date");
		String status=(String)memberInfo.get("status");
		String lastLoginTime=(String)memberInfo.get("lastLogin_time");
		String createTime=(String)memberInfo.get("createTime");
		String createUser=(String)memberInfo.get("createUser");
		String updateTime=(String)memberInfo.get("updateTime");
		String updateUser=(String)memberInfo.get("updateUser");
		String source=(String)memberInfo.get("source");
		String rootSource=(String)memberInfo.get("rootSource");
		String loginNum=(String)memberInfo.get("loginNum");
		String activeSts=(String)memberInfo.get("activeSts");
		String isFirst=(String)memberInfo.get("isFirst");
		voInfo=new MemberInfoVo();
		voInfo.setId(id);
		voInfo.setCode(code);
		voInfo.setEmail(email);
		voInfo.setPassword(password);
		voInfo.setName(name);
		voInfo.setSex(sex);
		voInfo.setBirthdateDay(birthdateDay);
		voInfo.setBirthdateMonth(birthdateMonth);
		voInfo.setBirthdateYear(birthdateYear);
		voInfo.setPhone(phone);
		voInfo.setMobile(mobile);
		voInfo.setAddress(address);
		voInfo.setEmailChecking(emailChecking);
		voInfo.setMobileBinding(mobileBinding);
//		try {
//			voInfo.setRegistrationDate(DateUtils.parseDate(registrationDate,"yyyy-MM-dd HH:mm:ss"));
//			voInfo.setLastLoginTime(DateUtils.parseDate(lastLoginTime,"yyyy-MM-dd HH:mm:ss"));
//			voInfo.setCreateTime(DateUtils.parseDate(createTime,"yyyy-MM-dd HH:mm:ss"));
//			voInfo.setUpdateTime(DateUtils.parseDate(updateTime,"yyyy-MM-dd HH:mm:ss"));
//		} catch (java.text.ParseException e) {
//			e.printStackTrace();
//		}
		voInfo.setStatus(status);
		voInfo.setCreateUser(createUser);
		voInfo.setUpdateUser(updateUser);
		voInfo.setSource(source);
		voInfo.setRootSource(rootSource);
		voInfo.setLoginNum(loginNum);
		voInfo.setActiveSts(activeSts);
		voInfo.setIsFirst(isFirst);
	}
	public MemberInfoVo getVoInfo() {
		return voInfo;
	}
	public void setVoInfo(MemberInfoVo voInfo) {
		this.voInfo = voInfo;
	}

}
