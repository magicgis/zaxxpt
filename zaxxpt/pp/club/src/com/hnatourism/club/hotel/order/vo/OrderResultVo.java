package com.hnatourism.club.hotel.order.vo;

import java.util.List;

import com.hnatourism.club.hotel.api.vo.ResultVo;
import com.hnatourism.club.hotel.order.vo.HotelOrderVo;
import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店订单信息API返回结果,
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderResultVo extends AbstractVo{
	/**
	 * 返回结果
	 */
	ResultVo result;
	
	/**
	 * 酒店订单详情
	 */
	HotelOrderDetailsVo resultBean;
	/**
	 * 酒店订单列表
	 */
	List<HotelOrderVo> resultList;
	
	//setter && getter 
	public ResultVo getResult() {
		return result;
	}
	public void setResult(ResultVo result) {
		this.result = result;
	}
	public HotelOrderDetailsVo getResultBean() {
		return resultBean;
	}
	public void setResultBean(HotelOrderDetailsVo resultBean) {
		this.resultBean = resultBean;
	}
	public List<HotelOrderVo> getResultList() {
		return resultList;
	}
	public void setResultList(List<HotelOrderVo> resultList) {
		this.resultList = resultList;
	}
	
}