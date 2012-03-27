package com.hnatourism.club.base.bean;

public class CHADataModel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3978252667059529093L;

	/** 成果网媒体ID */
	private String aid;

	/** 成果网媒体名称 */
	private String aname;
	
	/** 媒体用户唯一标识符 */
	private String auser;

	/** 媒体用户昵称 */
	private String uname;

	/** 登录成功跳转URL */
	private String url;

	/** 登录失败跳转URL */
	private String furl="";
	
	/** unix时间戳 */
	private String timestamp;
	
	/** 签名 */
	private String sig;

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
