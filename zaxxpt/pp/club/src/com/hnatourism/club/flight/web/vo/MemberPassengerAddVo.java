package com.hnatourism.club.flight.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;

public class MemberPassengerAddVo extends AbstractVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private String resultCode;
	//成功或失败代码及信息
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
