package com.hnatourism.club.hotel.prod.web.newapivo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:返回json数据的基本返回提示信息
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class ResultMessage{
	

	private String resultCode;
	
	private String message;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
