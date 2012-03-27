package com.hnatourism.club.flight.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.helper.flight.FlightGWRequestMessage;
import com.hnatourism.club.common.helper.flight.FlightGWResponseMessage;
import com.hnatourism.club.flight.web.vo.FlightGWVo;
import com.hnatourism.framework.utils.XmlUtils;
import com.hnatourism.framework.web.action.BaseAction;
//官网查询 add by wuyuhu
public class GWDetailAction extends BaseAction{
	//出发机场
	private String dep;
	//到达机场 
	private String arr;
	//出发时间
	private String deDate;
	//官网查询
	public String searchGwFlight(){
		FlightGWRequestMessage flightGWRequestMessage = new FlightGWRequestMessage();
		flightGWRequestMessage.setDepartureAirportCode(dep);
		flightGWRequestMessage.setArrivalAirportCode(arr);
		flightGWRequestMessage.setDepartureDate(deDate);
		flightGWRequestMessage.setSource(Constants.CLUB_ORDER_SOURCE);
		List<FlightGWVo> flightListG=null;
		List<FlightGWVo> flightArr=null;
		Map<String,List<FlightGWVo>> map=new HashMap();
		FlightGWResponseMessage flightGWResponse=null;
		try {
			String resultStrG = flightGWRequestMessage.excute();
			flightGWResponse = new FlightGWResponseMessage();
			flightGWResponse.parseResponse(resultStrG);
			flightListG = flightGWResponse.getFlightGWList();
//			FlightGWVo flightGWVo0=new FlightGWVo();
//			flightGWVo0.setFlightNo("CZ3108");
//			flightGWVo0.setCabinCode("H");
//			flightGWVo0.setPrice("1000");
//			flightListG.add(flightGWVo0);
//			
//			FlightGWVo flightGWVo1=new FlightGWVo();
//			flightGWVo1.setFlightNo("CZ3108");
//			flightGWVo1.setCabinCode("F");
//			flightGWVo1.setPrice("1100");
//			flightListG.add(flightGWVo1);
//			
//			FlightGWVo flightGWVo2=new FlightGWVo();
//			flightGWVo2.setFlightNo("CZ3108");
//			flightGWVo2.setCabinCode("Y");
//			flightGWVo2.setPrice("1500");
//			flightListG.add(flightGWVo2);
			
			for(int i=0;i<flightListG.size();i++){
			    FlightGWVo flightGWVo=flightListG.get(i);
			    flightArr=new ArrayList<FlightGWVo>();
				if(null == map.get(flightGWVo.getFlightNo())){
					flightArr.add(flightGWVo);
					map.put(flightGWVo.getFlightNo(), flightArr);
				}
				else{
					List<FlightGWVo> list=map.get(flightGWVo.getFlightNo());
					list.add(flightGWVo);
					map.put(flightGWVo.getFlightNo(), list);
				}
			}
			String result=XmlUtils.o2Xml(map);
			System.out.println(result);
			writeString(result, "xml");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			flightListG=null;
			flightArr=null;
			map=null;
			flightGWResponse=null;
			flightGWRequestMessage=null;
		}
		return null;
	}
	
	
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	public String getDeDate() {
		return deDate;
	}
	public void setDeDate(String deDate) {
		this.deDate = deDate;
	}
}
