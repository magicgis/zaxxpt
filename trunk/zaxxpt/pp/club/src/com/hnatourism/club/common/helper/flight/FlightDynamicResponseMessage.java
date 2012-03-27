package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.web.vo.FlightDynamicVo;
import com.hnatourism.club.flight.web.vo.HotAirLineVo;

public class FlightDynamicResponseMessage extends ResponseMessage {
	
	 ArrayList<FlightDynamicVo> flightDynamicList;
	
	@Override
	  public  void parseBody(JSONObject obj) throws ParseException{
		 
		
		 
		 JSONArray flightList = (JSONArray)obj.get("flightList");
	 
		 
		
		 
		 if(flightList!= null){
		 extractFlightDynamic(flightList);
		 }
		 
	 }
          private void extractFlightDynamic(JSONArray flightLists)throws ParseException{
        	  
        	  
        	  
        	  flightDynamicList =new  ArrayList<FlightDynamicVo>();
        	  
        	  FlightDynamicVo flightDynamicVo;
        	  
        	  
        	  
        	  for(int i=0;i<flightLists.size();i++){
        		  
        		  JSONObject FlightInfo =(JSONObject)flightLists.get(i);
        		  
        		  flightDynamicVo =new FlightDynamicVo();
        		  
        		  flightDynamicVo.setDeptDate(FlightInfo.get("deptDate").toString());
        	//	  flightDynamicVo.setFlightNote(FlightInfo.get("flightNote").toString());
        	//	  flightDynamicVo.setFlightNullCode(FlightInfo.get("flightNullCode").toString());
        		  flightDynamicVo.setFlightNum(FlightInfo.get("flightNum").toString());
        		  flightDynamicVo.setFlightDepcode(FlightInfo.get("flightDepcode").toString());
        		  flightDynamicVo.setFlightArrcode(FlightInfo.get("flightArrcode").toString());
        		  flightDynamicVo.setDeptAirport(FlightInfo.get("deptAirport").toString());
        		  flightDynamicVo.setArrAirport(FlightInfo.get("arrAirport").toString());
        		  flightDynamicVo.setExpectedDeptTime(FlightInfo.get("expectedDeptTime").toString());
        		  flightDynamicVo.setExpectedArrTime(FlightInfo.get("expectedArrTime").toString());
        		  flightDynamicVo.setRealDeptTime(FlightInfo.get("realDeptTime").toString());
        		  flightDynamicVo.setRealArrTime(FlightInfo.get("realArrTime").toString());
        		  flightDynamicVo.setFlightTerminal(FlightInfo.get("flightTerminal").toString());
        		  flightDynamicVo.setFlightHTerminal(FlightInfo.get("flightHTerminal").toString());
        		  flightDynamicVo.setFlightState(FlightInfo.get("flightState").toString());
        	//	  flightDynamicVo.setPlaneType(FlightInfo.get("planeType").toString());
        	//	  flightDynamicVo.setTimeRate(FlightInfo.get("timeRate").toString());
        		
        		  flightDynamicList.add(flightDynamicVo);
        	  }
        	 
	   
   }
          
         public ArrayList<FlightDynamicVo> getFlightDynamicList() {
      		return flightDynamicList;
      	}
      	public void setFlightDynamicList(ArrayList<FlightDynamicVo> flightDynamicList) {
      		this.flightDynamicList = flightDynamicList;
      	}
}
