package com.hnatourism.club.hotel.prod.web.newapivo;

import java.util.List;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店房型返回信息
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelRoomResultVo extends HotelResultVo{
	private List<HotelRoomBaseInfoVo> resultBean;

	public List<HotelRoomBaseInfoVo> getResultBean() {
		return resultBean;
	}

	public void setResultBean(List<HotelRoomBaseInfoVo> resultBean) {
		this.resultBean = resultBean;
	}
	
}
