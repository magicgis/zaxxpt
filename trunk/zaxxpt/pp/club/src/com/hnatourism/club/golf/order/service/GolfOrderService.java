package com.hnatourism.club.golf.order.service;

import com.hnatourism.club.golf.order.vo.GolfOrderVo;

/**
 * 高尔夫定单接口
 * @author 栾晓东
 *
 */
public interface GolfOrderService {
	/**
	 * 根据定单ID找出定单信息。
	 * @param id
	 * @return
	 */
	public GolfOrderVo getOrderById(String id);
	
	/**
	 * 将申请退场的  定单ID  与    退场理由     提交。
	 * @param orderId	定单Id
	 * @param rmk	退场理由
	 */
	public void saveOrUpdateRmk(String orderId,String paySts,String rmk);
	/**
	 * 将申请退场的  定单ID  与   改期时间     提交。
	 * @param orderId	定单Id
	 * @param updateTime	改期时间
	 */
	public void saveOrUpdateTime(String orderId,String paySts,String updateTime);
	
}
