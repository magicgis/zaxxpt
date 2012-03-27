package com.hnatourism.club.golf.order.service;

import com.hnatourism.club.golf.order.vo.GolfOrderVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫预订提交
 * 
 * 历史版本:2011-08-4 v1.0.0 (高杰) 创建:
 * 
 */
public interface IGolfSubmitService
{
	/**
	 * 提交高尔夫预订信息
	 * @param 高尔夫预订信息VO
	 * @throws Exception
	 */
	public String addBook(GolfOrderVo golfOrder) throws Exception;
	
	/**
	 * 得到高尔夫订单详情
	 * @param 高尔夫订单ID
	 * @return 高尔夫订单VO
	 * @throws Exception
	 */
	public Object detailOrder(String orderId) throws Exception;
}
