package com.hnatourism.club.common.service;


import com.hnatourism.framework.core.service.IService;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:天气预报
 * 
 * 历史版本:
 *					2010-08-16 v1.0.0 (hna) 创建:
 * 
 */
public interface ISysWeatherService extends IService{

	/**
	 * 查询天气预报
	 * @param cityCode
	 * @return
	 */
	public String find(String cityCode);
}
