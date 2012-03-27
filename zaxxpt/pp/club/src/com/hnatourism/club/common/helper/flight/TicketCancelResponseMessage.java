package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;

/**
*退票申请 解析类 lianpeng
*/

public class TicketCancelResponseMessage extends ResponseMessage {
	
	private String resultCode;
	private String message;

	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		JSONObject result = (JSONObject)obj.get("result");
		resultCode = (String) result.get("resultCode");
		message = (String) result.get("message");
	}

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
