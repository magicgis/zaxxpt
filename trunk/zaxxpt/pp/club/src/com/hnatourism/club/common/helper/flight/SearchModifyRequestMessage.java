package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

/**
*查找机票列表请求 wuyuhu
*/

public class SearchModifyRequestMessage extends RequestMessage {
	
	String dpt="";
	String arr="";
	String date="";
	String ftype="1";
	String carrier="";
	String dptTime="0";
	String mCabinCode="";
	String isource="51666";
	String tktNo="";
	String queryRealTimeFlight="";

	@Override
	public String getRequsetString() {
		String queryStr =  BASE_REQUEST_URL+"/prod/flight/flightSearchPhone.jsp?"
		+"dpt="+dpt
		+"&arr="+arr
		+"&date="+date;

		queryStr+="&ftype="+ftype.trim()
		+"&mCabinCode="+mCabinCode
		+"&carrier="+carrier
		+"&dptTime="+dptTime
		+"&isource=51666"
		+"&qryFlag=modify"
		+"&tktNo="+tktNo;
		
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

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public void setDptTime(String dptTime) {
		this.dptTime = dptTime;
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

	public String getMCabinCode() {
		return mCabinCode;
	}

	public void setMCabinCode(String cabinCode) {
		mCabinCode = cabinCode;
	}

	public String getDpt() {
		return dpt;
	}

	public String getArr() {
		return arr;
	}

	public String getDate() {
		return date;
	}

	public String getFtype() {
		return ftype;
	}

	public String getCarrier() {
		return carrier;
	}

	public String getDptTime() {
		return dptTime;
	}

	public String getIsource() {
		return isource;
	}

	public String getTktNo() {
		return tktNo;
	}

	public void setTktNo(String tktNo) {
		this.tktNo = tktNo;
	}


	
	
	
}
