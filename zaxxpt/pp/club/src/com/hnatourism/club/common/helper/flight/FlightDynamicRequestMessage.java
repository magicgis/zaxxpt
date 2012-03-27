package com.hnatourism.club.common.helper.flight;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
import com.hnatourism.framework.utils.StringUtils;
//航班动态
public class FlightDynamicRequestMessage extends RequestMessage{

	
		private String fno;
		
		private String dpt;
		private String arr;
		
	
		@Override
		public String getRequsetString() {
			
			String url=BASE_REQUEST_URL+"/prod/flight/flightMovement.jsp?";
			
			if(!StringUtils.isEmpty(fno)){
				url=url+"fno="+fno;
			}else {
				if(!StringUtils.isEmpty(dpt)&&!StringUtils.isEmpty(arr)){
					url=url+"dpt="+dpt+"&arr="+arr;
				}
				
			}
			
			
			return url;
		}


		public String getFno() {
			return fno;
		}


		public void setFno(String fno) {
			this.fno = fno;
		}


		public String getDpt() {
			return dpt;
		}


		public void setDpt(String dpt) {
			this.dpt = dpt;
		}


		public String getArr() {
			return arr;
		}


		public void setArr(String arr) {
			this.arr = arr;
		}

}
