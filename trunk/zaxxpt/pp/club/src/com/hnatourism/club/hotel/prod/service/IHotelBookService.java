package com.hnatourism.club.hotel.prod.service;

import com.hnatourism.club.hotel.order.vo.HotelOrderContactVo;
import com.hnatourism.club.hotel.order.vo.HotelOrderParemVo;
import com.hnatourism.club.hotel.order.vo.OrderResultVo;
import com.hnatourism.club.hotel.prod.web.vo.HotelVo;
import com.hnatourism.club.hotel.prod.web.vo.QryHotelVo;
import com.hnatourism.club.hotel.prod.web.vo.QryRoomVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转到酒店预订页
 * 
 * 历史版本: ${2011.9.5} v1.0.0 (高杰) 创建
 * 
 */
public interface IHotelBookService
{
	public HotelVo findHotelDetail(QryHotelVo qryHotelVo) throws Exception;
	public HotelVo findHotelRoomList(QryRoomVo qryRoomVo) throws Exception;
	public OrderResultVo newHotelOrder(HotelOrderParemVo hotelOrderParemVo, HotelOrderContactVo hotelOrderContact) throws Exception;
}
