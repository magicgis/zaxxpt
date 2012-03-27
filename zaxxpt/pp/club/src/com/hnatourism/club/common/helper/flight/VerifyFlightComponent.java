package com.hnatourism.club.common.helper.flight;

import com.hnatourism.framework.utils.StringUtils;

/**
 * 验证航班舱位是否有可预订座位的组件类
 * 
 * @author fanghw
 *
 */
public class VerifyFlightComponent {

	/**
	 * 验证航班舱位是否有可预订的空座
	 * @param airlineCompany
	 * @param flightNo
	 * @param cabinCode
	 * @param dptAirport
	 * @param arrAirport
	 * @param flyDate
	 * @param inFlyDate
	 * @param flightType
	 * @return
	 */
	public static boolean verifyFlightSeatNum(String airlineCompany,String flightNo,String cabinCode,String dptAirport,
			String arrAirport,String flyDate,String inFlyDate,String flightType){
		boolean ok=false;
		
		VerifyFlightphoneRequestMessage req=new VerifyFlightphoneRequestMessage();
		req.setAirlineCompany(airlineCompany);
		req.setFlightNo(flightNo);
		req.setCabinCode(cabinCode);
		req.setDptAirport(dptAirport);
		req.setArrAirport(arrAirport);
		req.setFlyDate(flyDate.split(" ")[0]);
		req.setInFlyDate(inFlyDate.split(" ")[0]);
		req.setFlightType(flightType);
		
		VerifyFlightphoneResponseMessage res=new VerifyFlightphoneResponseMessage();
		
		try{
			String jsonStr=req.excute2();
			res.parseResponse(jsonStr);
			if(StringUtils.isEmpty(res.getResultCode())){
				ok=true;
			}			
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		
		return ok;
	}
	
}
