/**
 * 
 */
package com.hnatourism.club.golf.order.service;

import com.hnatourism.club.pay.PayVo;

/**
 * @author gujianliang
 * @2011-9-19
 */
public interface IOrderGolfSubRunService {

//	public Boolean payAndSubRun(String orderId,String createUser);
	
	public PayVo payAndSubRun(String orderId,String createUser);
}
