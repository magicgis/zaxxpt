package com.hnatourism.club.hotel.prod.web.vo;


import com.hnatourism.club.hotel.api.vo.ResultVo;
import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店信息API返回结果
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HotelVo extends AbstractVo{
	/**
	 * 返回结果
	 */
	ResultVo result;
	/**
	 * 酒店信息
	 */
	HotelInfoVo resultBean;
	

	
	public ResultVo getResult() {
		return result;
	}
	
	public void setResultBean(HotelInfoVo resultBean) {
		this.resultBean = resultBean;
	}
	public HotelInfoVo getResultBean() {
		return resultBean;
	}
	public void setResult(ResultVo result) {
		this.result = result;
	}


}