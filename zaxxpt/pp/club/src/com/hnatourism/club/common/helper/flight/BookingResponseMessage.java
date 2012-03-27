package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.web.vo.PayVo;

	/**
	*机票预订解析  wuyuhu
	*/	

public class BookingResponseMessage extends ResponseMessage {
	private String resultCode;
	private String message;
	private PayVo payVo;
	
	protected void parseHeader(JSONObject obj) {
		super.parseHeader(obj);
		
		//机票预订错误消息
		String flightErrors=getBookingFlightErrors(obj);
		if(!flightErrors.equals("")){
			message=flightErrors;
		}
	}

	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		JSONObject result = (JSONObject)obj.get("result");
		resultCode = (String)result.get("resultCode");
		message = (String)result.get("message");
		String orderId = (String) obj.get("orderId");
//		String code = (String) obj.get("code");
//		String totalMoney = (String) obj.get("totalMoney");	
//		String actualMoney = (String)obj.get("actualMoney");
//		String isFirst = (String) obj.get("isFirst");
//		String email = (String) obj.get("email");
//		String password = (String) obj.get("password");
//		String memberId = (String) obj.get("memberId");
//		String webAccount = (String) obj.get("webAccount");
//		String xlbAccount = (String) obj.get("xlbAccount");
//		String cabinPriceChange = (String) obj.get("cabinPriceChange");
//		String deliveryFee = (String) obj.get("deliveryFee");
//		
		payVo = new PayVo();
		payVo.setOrderId(orderId);
//		payVo.setCode(code);
//		payVo.setTotalMoney(totalMoney);
//		payVo.setActualMoney(actualMoney);
//		payVo.setIsFirst(isFirst);
//		payVo.setEmail(email);
//		payVo.setPassword(password);
//		payVo.setMemberId(memberId);
//		payVo.setWebAccount(webAccount);
//		payVo.setXlbAccount(xlbAccount);
//		payVo.setCabinPriceChange(cabinPriceChange);
//		payVo.setDeliveryFee(deliveryFee);

	}
	
	/**
	 * 机票预订的错误消息
	 * @param obj
	 * @return
	 */
	public String getBookingFlightErrors(JSONObject obj){
		String msg="";
		//机票预订的去程错误信息
		JSONArray goErrorResult=(JSONArray)obj.get("goErrorResult");
		if(goErrorResult!=null){
			for(int i=0;i<goErrorResult.size();i++){
				JSONObject errorItem=(JSONObject)goErrorResult.get(i);
				String code=(String)errorItem.get("resultCode");
				if(i==0&&code.equals(""))break;
				msg+=(String)errorItem.get("message");
			}
		}
		
		//机票预订的返程错误信息
		JSONArray reErrorResult=(JSONArray)obj.get("reErrorResult");
		if(reErrorResult!=null){
			for(int i=0;i<reErrorResult.size();i++){
				JSONObject errorItem=(JSONObject)reErrorResult.get(i);
				String code=(String)errorItem.get("resultCode");
				if(i==0&&code.equals(""))break;
				msg+=(String)errorItem.get("message");
			}
		}
		
		//机票预订的常用错误信息
		JSONArray commonErrorResult=(JSONArray)obj.get("commonErrorResult");
		if(commonErrorResult!=null){
			for(int i=0;i<commonErrorResult.size();i++){
				JSONObject errorItem=(JSONObject)commonErrorResult.get(i);
				String code=(String)errorItem.get("resultCode");
				if(i==0&&code.equals(""))break;
				msg+=(String)errorItem.get("message");
			}
		}
		
		return msg;
	}

	public PayVo getPayVo() {
		return payVo;
	}

	public void setPayVo(PayVo payVo) {
		this.payVo = payVo;
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
