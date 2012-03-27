package com.hnatourism.club.golf.prod.service;

import java.util.Map;

import com.hnatourism.club.golf.prod.vo.GolfInfoVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫产品详细首页
 * 
 * 历史版本:2011-08-2 v1.0.0 (周峰) 创建:
 * 
 */
public interface IGolfProdViewService
{
	/**
	 * 得到产品详细信息
	 * @return 高尔夫球场详细信息
	 * @throws Exception
	 */
	public GolfInfoVo findById(String id) throws Exception;
}
