package com.hnatourism.club.common.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


import com.hnatourism.club.common.domain.FlightAirport;
import com.hnatourism.framework.cache.CacheDataManager;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.StringUtils;

/**
 * 机场信息标签
 * 
 * @author leiping_zhu
 * @version
 */
public class AirportWriteTag extends TagSupport {

	/** 机场三字码 */
	private String key;
	private String isDisplayCity;
	private String isDisplayLname;
	private String isDisplayPinyin;

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		if(StringUtils.isEmpty(key)){
			return 0;
		}
		StringBuffer buff = new StringBuffer("");
//		List<FlightAirport> airports = (List<FlightAirport>) SearchFlightCacheResponseMessage.flightAirportListCache;
		List<FlightAirport> airports = (List<FlightAirport>) CacheDataManager.get("FLIGHT_AIRPORT");
		if(!ListUtils.isEmpty(airports)){
		for(int i=0;i<airports.size();i++){
			FlightAirport airport = (FlightAirport) airports.get(i);
			if(key.equals(airport.getCode())){
				if("true".equals(isDisplayCity)){
					String cityName=airport.getCityName();
					if(StringUtils.isBlank(cityName)){
						cityName=airport.getName();
					}
					if(StringUtils.isBlank(cityName)){
						cityName=airport.getLname();
					}
					if(cityName!=null && cityName.indexOf("市")!=-1){
						cityName=cityName.substring(0,cityName.length()-1);
					}
					buff.append(cityName);
				}
				else{
					// 默认取得长名
					String name =airport.getLname();
					if(StringUtils.isBlank(name)){
						name=airport.getName();
					}
					if("true".equals(isDisplayPinyin)){
						buff.append(StringUtils.isBlank(airport.getPinyin())? name:airport.getPinyin());
					}
					else{
						buff.append(name);
					}
				}
				break;
			}
		}
		}
		try {
			pageContext.getOut().write(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}


	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	public String getIsDisplayCity() {
		return isDisplayCity;
	}

	public void setIsDisplayCity(String isDisplayCity) {
		this.isDisplayCity = isDisplayCity;
	}


	public String getIsDisplayLname() {
		return isDisplayLname;
	}


	public void setIsDisplayLname(String isDisplayLname) {
		this.isDisplayLname = isDisplayLname;
	}


	public String getIsDisplayPinyin() {
		return isDisplayPinyin;
	}


	public void setIsDisplayPinyin(String isDisplayPinyin) {
		this.isDisplayPinyin = isDisplayPinyin;
	}

}
