package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
//回调修改订单状态 wuyuhu
public class FlightCallBackResponseMessage extends ResponseMessage{
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
	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		JSONObject result = (JSONObject)obj.get("result");
		resultCode = (String)result.get("resultCode");
		message = (String)result.get("message");
	}

}
