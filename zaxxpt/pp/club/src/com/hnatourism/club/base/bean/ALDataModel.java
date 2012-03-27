package com.hnatourism.club.base.bean;

public class ALDataModel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3978252667059529093L;

	/** 机构编码 */
	private String corpCode;

	/** 用户编码 */
	private String userCode;
	/** 用户姓名* */
	private String name;

	/** 网站唯一标示 */
	private String websiteFlag;

	/** 时间戳 */
	private String transferTime;

	private String flag="";

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String toXml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<aLDataModel>");
		sb.append("<corpCode>").append(corpCode).append("</corpCode>");
		sb.append("<userCode>").append(userCode).append("</userCode>");
		sb.append("<name>").append(name).append("</name>");
		sb.append("<websiteFlag>").append(websiteFlag).append("</websiteFlag>");
		sb.append("<transferTime>").append(transferTime).append(
				"</transferTime>");
		sb.append("<flag>").append(flag).append("</flag>");
		sb.append("</aLDataModel>");
		return sb.toString();
	}

	public boolean checkEmpty() {
		corpCode = corpCode == null ? "" : corpCode.trim();
		userCode = userCode == null ? "" : userCode.trim();
		name = name == null ? "" : name.trim();
		websiteFlag = websiteFlag == null ? "" : websiteFlag.trim();
		transferTime = transferTime == null ? "" : transferTime.trim();
		if (corpCode.length() == 0 || userCode.length() == 0
				|| name.length() == 0 || websiteFlag.length() == 0
				|| transferTime.length() == 0) {
			return false;
		}
		return true;

	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(String transferTime) {
		this.transferTime = transferTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsiteFlag() {
		return websiteFlag;
	}

	public void setWebsiteFlag(String websiteFlag) {
		this.websiteFlag = websiteFlag;
	}
}
