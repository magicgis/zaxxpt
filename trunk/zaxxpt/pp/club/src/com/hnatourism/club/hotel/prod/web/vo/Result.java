package com.hnatourism.club.hotel.prod.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称：海航旅业B2C系统系统
 *
 * 功能描述：调用c站  酒店常用旅客接口返回结果（调用C站接口用）
 *
 * 历史版本：2011-10-31 v1.0.0 (zhanghan) 创建
 *
 */
public class Result extends AbstractVo {
	//返回结果code
	private String resultCode;
	//消息
	private String message;
	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
