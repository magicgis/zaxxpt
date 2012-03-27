package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店现付担保查询结果vo
 * 
 * 历史版本: 2011-11-17 v1.0.0 (lixun) 创建
 * 
 */
public class HotelGuaranteeResultVo extends HotelResultVo{
	private HotelGuaranteeVo resultBean;

	public HotelGuaranteeVo getResultBean() {
		return resultBean;
	}

	public void setResultBean(HotelGuaranteeVo resultBean) {
		this.resultBean = resultBean;
	}
	
}
