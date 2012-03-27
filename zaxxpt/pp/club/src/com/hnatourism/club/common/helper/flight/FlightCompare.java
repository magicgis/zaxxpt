package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.flight.web.vo.FlightCabinInfoVo;
import com.hnatourism.club.flight.web.vo.FlightGWVo;
import com.hnatourism.club.flight.web.vo.FlightInfoVo;
//add by quhailong
public class FlightCompare {
	
	//航班比对
	public ArrayList<FlightInfoVo> compare(ArrayList<FlightInfoVo> flightInfoVoList, List<FlightGWVo> flightGWVoList){
		for (int i = 0; i < flightInfoVoList.size(); i++) {
			for (int j = 0; j < flightGWVoList.size(); j++) {
				FlightInfoVo flightInfoVo = flightInfoVoList.get(i);
				FlightGWVo flightGWVo = flightGWVoList.get(j);
				List<FlightCabinInfoVo> flightCabinInfoVoList = flightInfoVo.getFlightCabinInfoVoList();
				boolean flightNo = false;
				boolean departureAirportCode = false;
				boolean arrivalAirportCode = false;
				boolean departureTime = false;
				boolean arrivalTime = false;
				
				if(flightGWVo.getFlightNo().equals(flightInfoVo.getAirlineCompanyCode()+flightInfoVo.getFlightNo())){
					flightNo = true;
				}
				if(flightGWVo.getDepartureAirportCode().equals(flightInfoVo.getDepartureAirportCode())){
					departureAirportCode = true;
				}
				if(flightGWVo.getArrivalAirportCode().equals(flightInfoVo.getArrivalAirportCode())){
					arrivalAirportCode = true;
				}
				if(flightGWVo.getDepartureTime().equals(flightInfoVo.getDepartureTime())){
					departureTime = true;
				}
				if(flightGWVo.getArrivalTime().equals(flightInfoVo.getArrivalTime())){
					arrivalTime = true;
				}
				if(flightNo&&departureAirportCode&&arrivalAirportCode&&departureTime&&arrivalTime){
					if(flightInfoVo.getFlightCabinInfoVo().getFlightGWVo()==null){
						flightInfoVo.getFlightCabinInfoVo().setFlightGWVo(flightGWVo);
					}else{
						for(int k=0; k<flightInfoVo.getFlightCabinInfoVoList().size(); k++){
							if(flightInfoVo.getFlightCabinInfoVoList().get(k).getFlightGWVo()!=null){
								flightInfoVo.getFlightCabinInfoVoList().get(k).setFlightGWVo(flightGWVo);
								break;
							}
						}
					}
				}
			}
		}
		return flightInfoVoList;
	}
}
