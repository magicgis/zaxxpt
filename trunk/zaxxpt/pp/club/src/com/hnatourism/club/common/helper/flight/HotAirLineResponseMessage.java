package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;

import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.web.vo.HotAirLineVo;





  public class HotAirLineResponseMessage extends ResponseMessage {

	
	  private  Map<String, List<HotAirLineVo>> map = new HashMap<String, List<HotAirLineVo>>(); 

	   
	  ArrayList<HotAirLineVo> hotAirLineList;
	  
      
	   @Override
	    public  void parseBody(JSONObject obj) throws ParseException{
			// TODO Auto-generated method stub
		   
		   

		    hotAirLineList=new ArrayList<HotAirLineVo>();
		    
		    JSONArray resultBean = (JSONArray)obj.get("resultBean");
		    
		    
		    if (resultBean != null) {
		    	
				extractHotAirLine(resultBean,hotAirLineList);
				
			}
		}
      
	    private void extractHotAirLine(JSONArray resultBean, List<HotAirLineVo> hotAirList) {
    	   
    	   HotAirLineVo hotAirLineVo;
    	   
    	   String city;
    	  
    	   for (int i = 0; i < resultBean.size(); i++) {
    		   hotAirList=new ArrayList<HotAirLineVo>();
    		   JSONObject pageBean = (JSONObject)resultBean.get(i);
    		  
    		   JSONArray flights =(JSONArray)pageBean.get("flights");
    		   
    		   city= pageBean.get("city").toString();
   	    	
   	          
    		   for(int j = 0; j < flights.size(); j++){
    			     hotAirLineVo=new HotAirLineVo();
        	         JSONObject page = (JSONObject) flights.get(j);
        	         hotAirLineVo.setId(page.get("id").toString());
		    	     hotAirLineVo.setRecommendCityId(page.get("recommendCityId").toString());
		    	     hotAirLineVo.setDepartureCity(page.get("departureCity").toString());
		    	     hotAirLineVo.setArrivalCity(page.get("arrivalCity").toString());
		    	     hotAirLineVo.setTodayPrice(page.get("todayPrice").toString());
		    	     hotAirLineVo.setTomorrowPrice(page.get("tomorrowPrice").toString());
		    	     hotAirLineVo.setWeekPrice(page.get("weekPrice").toString());
		    	     hotAirLineVo.setSts(page.get("sts").toString());
		    	     hotAirLineVo.setCreateTime(page.get("createTime").toString());
		    	     hotAirLineVo.setCreateUser(page.get("createUser").toString());
		    	     hotAirLineVo.setDepartureAirport(page.get("departureAirport").toString());
		    	     hotAirLineVo.setArrivalAirport(page.get("arrivalAirport").toString());
		    	     hotAirLineVo.setDepartureDate(page.get("departureDate").toString());
		    	     hotAirLineVo.setDptDate(page.get("dptDate").toString());
		    	     hotAirLineVo.setUpdateTime(page.get("updateTime").toString());
		    	     hotAirLineVo.setUpdateUser(page.get("updateUser").toString());
		    	     hotAirLineVo.setDiscount(page.get("discount").toString());
		    	     hotAirLineVo.setAirCompany(page.get("airCompany").toString());
		    	     hotAirList.add(hotAirLineVo);
    	    	 }
    		    map.put(city,hotAirList);
    	     }
          }
	    
	    protected void parseHeader(JSONObject obj) {
			JSONObject header = (JSONObject) obj.get("resultFlight");
			resultCode = (String) header.get("resultCode");		
			message =(String)header.get("message");			
			
			
		}
	    
	public Map<String, List<HotAirLineVo>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<HotAirLineVo>> map) {
		this.map = map;
	}

	public ArrayList<HotAirLineVo> getHotAirLineList() {
		return hotAirLineList;
	}

	public void setHotAirLineList(ArrayList<HotAirLineVo> hotAirLineList) {
		this.hotAirLineList = hotAirLineList;
	}



}