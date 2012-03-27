package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;

		
	public class HotAirLineRequestMessage extends RequestMessage{
	
		
		
		@Override
		public String getRequsetString() {
			
			String url = BASE_REQUEST_URL+"/prod/flight/flightRecommend.jsp";
			
			return url;
		}
}
