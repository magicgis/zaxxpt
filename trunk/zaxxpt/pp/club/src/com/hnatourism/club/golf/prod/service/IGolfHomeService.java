package com.hnatourism.club.golf.prod.service;

import java.util.Map;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫首页业务
 * 
 * 历史版本:2011-08-2 v1.0.0 (高杰) 创建:
 * 
 */
public interface IGolfHomeService
{
	/**
	 * 得到高尔夫首页需要的高尔夫球场信息和城市信息
	 * @return 高尔夫球场信息（image）和城市信息（city）
	 * @throws Exception
	 */
	public Map<String,Object> findByComm() throws Exception;
}
