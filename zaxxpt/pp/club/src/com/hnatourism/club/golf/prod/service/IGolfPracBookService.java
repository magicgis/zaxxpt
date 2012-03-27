package com.hnatourism.club.golf.prod.service;

import java.util.Map;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫练习场预订页面业务
 * 
 * 历史版本:2011-08-2 v1.0.0 (高杰) 创建:
 * 
 */
public interface IGolfPracBookService
{
	/**
	 * 得到高尔夫练习场预订页面需要的练习场信息和登录者信息
	 * @param 场地ID
	 * @return 练习场信息（golf）和登录者信息（login）
	 * @throws Exception
	 */
	public Map<String, Object> findByBook(String siteid) throws Exception;
}
