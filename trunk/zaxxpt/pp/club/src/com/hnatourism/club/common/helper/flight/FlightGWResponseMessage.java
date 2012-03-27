package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.web.vo.FlightGWVo;

/**
*解析官网航班 quhailong
*/
public class FlightGWResponseMessage extends ResponseMessage{
	private String resultCode;
	private String message;
	private List<FlightGWVo> flightGWList = new ArrayList<FlightGWVo>();
	
	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		JSONArray flightGWArray = (JSONArray)obj.get("resultList");
		if(flightGWArray!=null){
			extractFlightGW(flightGWList,flightGWArray);
		}
	}
	//解析官网返回航班信息
	private void extractFlightGW(List<FlightGWVo> flightGWList,
			JSONArray flightGWArray) {
		FlightGWVo flightGWVo;
		for (int i = 0; i < flightGWArray.size(); i++) {
			flightGWVo = new FlightGWVo();
			JSONObject flightGW = (JSONObject)flightGWArray.get(i);
			//航班号
			flightGWVo.setFlightNo((String)flightGW.get("no"));
			//航空公司编号
			flightGWVo.setAirlineCompanyCode((String)flightGW.get("carrier"));
			//出发机场Code
			flightGWVo.setDepartureAirportCode((String)flightGW.get("dpt"));
			//到达机场Code
			flightGWVo.setArrivalAirportCode((String)flightGW.get("arr"));
			//仓位
			flightGWVo.setCabinCode((String)flightGW.get("seat"));
			//退改签信息
			flightGWVo.setCabinInfo((String)flightGW.get("explain"));
			//价格
			flightGWVo.setPrice((String)flightGW.get("fare"));
			//来源
			flightGWVo.setOrigin((String)flightGW.get("origin"));
			//起飞时间
			flightGWVo.setDepartureTime((String)flightGW.get("btime"));
			//到达时间
			flightGWVo.setArrivalTime((String)flightGW.get("etime"));
			flightGWList.add(flightGWVo);
		}
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
	public List<FlightGWVo> getFlightGWList() {
		return flightGWList;
	}
	public void setFlightGWList(List<FlightGWVo> flightGWList) {
		this.flightGWList = flightGWList;
	}
}
