package com.hnatourism.club.common.helper.authority;

import com.hnatourism.club.common.helper.protocol.RequestMessage;


public class LoginRequestMessage extends RequestMessage {
	private String code;
	private String pwd;
	private String type;
	private String source;
		
	@Override
	public String getRequsetString() {
		StringBuffer sb=new StringBuffer(BASE_REQUEST_URL+"/login.jsp?");
		sb.append("code="+code);
		sb.append("&pwd="+pwd);
		sb.append("&type="+type);
		sb.append("&source="+source);
		return sb.toString();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	
	

}
