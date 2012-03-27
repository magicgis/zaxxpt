package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

/**
*查找机票列表请求 wuyuhu
*/

public class SearchRequestMessage extends RequestMessage {
	
	String dpt;
	String arr;
	String date;
	String ftype;
	String cabin;
	String carrier;
	String dptTime;
	String dateType;
	//String cabinCode;
	String backDate;
	String isource="51666";
	
	String queryRealTimeFlight="";

	@Override
	public String getRequsetString() {
		String queryStr =  BASE_REQUEST_URL+"/prod/flight/flightSearchPhone.jsp?"
		+"dpt="+dpt
		+"&arr="+arr
		+"&date="+date;
		if(null != backDate && !"null".equals(backDate)){
			queryStr+="&backDate="+backDate;
			System.out.println(queryStr);
		}
		queryStr+="&ftype="+ftype.trim()
		+"&cabin="+cabin
		+"&carrier="+carrier
		+"&dptTime="+dptTime
		+"&isource=51666"
		//+"&isource="+isource
		+"&qryFlag=flight"
		+"&queryRealTimeFlight="+queryRealTimeFlight
		+"&source=51666";
		
		return queryStr;
	}

	public void setDpt(String dpt) {
		this.dpt = dpt;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public void setDptTime(String dptTime) {
		this.dptTime = dptTime;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}

	public String getCabin() {
		return cabin;
	}

	public void setIsource(String isource) {
		this.isource = isource;
	}

	public String getQueryRealTimeFlight() {
		return queryRealTimeFlight;
	}

	public void setQueryRealTimeFlight(String queryRealTimeFlight) {
		this.queryRealTimeFlight = queryRealTimeFlight;
	}


	
	
	
}
