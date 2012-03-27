/**
 * 
 */
package com.hnatourism.club.common.payinterface;

import com.hnatourism.club.golf.api.ApiClient;

/**
 * @author gujianliang
 * @2011-8-22
 */
public class PayInterfaceApi {

	
	
	public Object getBalance(){
		
		return null;
	}
	/**
	 * @author gujianliang
	 * @2011-8-22
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApiClient.getHtml("http://mas.chinapnr.com/gaq/entry.do?CmdId=QueryBalance");
	}

}
