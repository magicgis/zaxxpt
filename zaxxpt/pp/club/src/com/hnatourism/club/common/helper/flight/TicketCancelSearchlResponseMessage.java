package com.hnatourism.club.common.helper.flight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.book.BookingFlightVo;
import com.hnatourism.club.flight.web.vo.MemberPassengerVo;

/**
*退票申请 解析类 lianpeng
*/

public class TicketCancelSearchlResponseMessage extends ResponseMessage {
	
	private String resultCode;
	private String message;
	private String orderCode;
	private List<MemberPassengerVo> flightPassengers;

	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		JSONObject result = (JSONObject) obj.get("result");
		resultCode = (String) result.get("resultCode");
		message = (String) result.get("message");
		orderCode = (String) obj.get("orderCode");
		flightPassengers = parseFlightPassengers((JSONArray) obj.get("flightPassenger"));
	}
	private List<MemberPassengerVo> parseFlightPassengers(JSONArray flightOtherJSONArray) {
		// TODO Auto-generated method stub
		ArrayList<MemberPassengerVo> list = new ArrayList<MemberPassengerVo>();
		if(flightOtherJSONArray != null && !flightOtherJSONArray.isEmpty()){
			for (int i = 0; i < flightOtherJSONArray.size(); i++) {
				JSONObject flightOtherJSONObj = (JSONObject)flightOtherJSONArray.get(i);
				MemberPassengerVo flightpassenger = new MemberPassengerVo();
				flightpassenger.setId((String) flightOtherJSONObj.get("id"));
				flightpassenger.setName((String) flightOtherJSONObj.get("name"));
				flightpassenger.setType((String) flightOtherJSONObj.get("passengerType"));
				flightpassenger.setApplyMoney((String) flightOtherJSONObj.get("applyMoney"));
				flightpassenger.setTicketSts((String) flightOtherJSONObj.get("ticketSts"));
				flightpassenger.setAirlineCompanyCode((String) flightOtherJSONObj.get("airlineCompanyCode"));
				flightpassenger.setFlightNo((String) flightOtherJSONObj.get("flightNo"));
				flightpassenger.setCabinCode((String) flightOtherJSONObj.get("cabinCode"));
				flightpassenger.setDepartureDate((String) flightOtherJSONObj.get("departureDate"));
				flightpassenger.setArrivalDate((String) flightOtherJSONObj.get("arrivalDate"));
				flightpassenger.setDepartureAirport((String ) flightOtherJSONObj.get("departureAirport"));
				flightpassenger.setArrivalAirport((String) flightOtherJSONObj.get("arrivalAirport"));
				flightpassenger.setDepartureAirportCode((String) flightOtherJSONObj.get("departureAirportCode"));
				flightpassenger.setArrivalAirportCode((String) flightOtherJSONObj.get("arrivalAirportCode"));
				flightpassenger.setEtNo((String) flightOtherJSONObj.get("etNo"));
				flightpassenger.setPnr((String) flightOtherJSONObj.get("pnr"));
				flightpassenger.setRuleExlain((String) flightOtherJSONObj.get("ruleExlain"));
				list.add(flightpassenger);
			}	
		}		
		return list;
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
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public List<MemberPassengerVo> getFlightPassengers() {
		return flightPassengers;
	}
	public void setFlightPassengers(List<MemberPassengerVo> flightPassengers) {
		this.flightPassengers = flightPassengers;
	}

}
