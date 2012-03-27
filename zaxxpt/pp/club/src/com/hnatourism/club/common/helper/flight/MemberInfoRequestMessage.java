package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
/**
*自动登录 fanghongwen
*/

public class MemberInfoRequestMessage extends RequestMessage{
	private String aid;
	private String aname;
	private String auser;
	private String uname;
	private String url;
	private String furl;
	private String timestamp;
	private String sig;
	
	@Override
	public String getRequsetString() {
		StringBuffer sb=new StringBuffer(AUTO_LOGIN+"/handler/member/autoLoginOther.jsp?");
		sb.append("aid="+aid);
		sb.append("&aname="+aname);
		sb.append("&auser="+auser);
		sb.append("&uname="+uname);
		sb.append("&url="+url);
		sb.append("&furl="+furl);
		sb.append("&timestamp="+timestamp);
		sb.append("&sig="+sig);
		return sb.toString();
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAuser() {
		return auser;
	}

	public void setAuser(String auser) {
		this.auser = auser;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

}
