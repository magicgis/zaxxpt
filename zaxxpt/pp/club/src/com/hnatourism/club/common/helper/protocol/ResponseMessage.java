package com.hnatourism.club.common.helper.protocol;

import java.util.HashMap;

import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.JSONParser;
import com.hnatourism.club.common.helper.json.parser.ParseException;


/**
 * 消息响应基类
 * 
 * @author liyi
 *
 */
public abstract class ResponseMessage{
	protected JSONParser parser;
	protected String resultCode;
	protected String message;
	public static HashMap<String, String> RESULT_MESSAGE = new HashMap<String, String>();


	public ResponseMessage() {
		parser = new JSONParser();
	}

	protected void parseHeader(JSONObject obj) {
		JSONObject header = (JSONObject) obj.get("result");
		resultCode = (String) header.get("resultCode");		
		message =(String)header.get("message");			
	}

	public void parseResponse(String jsonStr) throws ParseException {
		if(jsonStr==null || jsonStr.equals("")){
			//Log.i("test","result is null");
			return ;
		}
		JSONObject obj = (JSONObject) parser.parse(jsonStr);
		//parseHeader(obj);
		//if("".equals(resultCode))//请求成功，有结果返回
		parseBody(obj);
	}
	
		
	 /**
	  * 解析消息体
	  * 
	  * @param obj
	  */
	protected abstract void parseBody(JSONObject obj)throws ParseException;
	
	public String getResultCode() {
		return resultCode;
	}

	public String getMessage() {
		return message;
	}
	
}
