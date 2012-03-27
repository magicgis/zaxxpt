package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;


/**
*缓存类 wuyuhu
*/
public class SearchFlightCacheRequestMessage extends RequestMessage {
	@Override
	public String getRequsetString() {
		String queryStr =  BASE_REQUEST_URL+"/prod/flight/airPortCitySearch.jsp";
		return queryStr;
	}
}
