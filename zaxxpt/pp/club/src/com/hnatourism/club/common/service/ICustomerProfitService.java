package com.hnatourism.club.common.service;


import java.util.Map;

import com.hnatourism.framework.core.service.IService;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:客户分润
 * 
 * 历史版本:2010-08-30 v1.0.0 (gaojie) 创建:
 * 
 */
public interface ICustomerProfitService extends IService{

	/**
	 * 返回折扣值
	 * @param cityCode
	 * @return
	 */
	public Map<String, Object> cal_profit(Double price,String memberId,String goods);
	
	public Map<String, Object> anti_cal_profit(Double price,String memberId,String goods);
}
