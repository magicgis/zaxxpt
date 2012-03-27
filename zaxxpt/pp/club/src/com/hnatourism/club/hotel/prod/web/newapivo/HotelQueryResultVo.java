package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店查询结果
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelQueryResultVo extends HotelResultVo{
	/** property 酒店查询结果*/
	private HotelQueryInfoVo resultBean;

	public HotelQueryInfoVo getResultBean() {
		return resultBean;
	}

	public void setResultBean(HotelQueryInfoVo resultBean) {
		this.resultBean = resultBean;
	} 
	
}
