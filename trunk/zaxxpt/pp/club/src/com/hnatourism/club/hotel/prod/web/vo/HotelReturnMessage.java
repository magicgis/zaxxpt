package com.hnatourism.club.hotel.prod.web.vo;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称：海航旅业B2C系统系统
 *
 * 功能描述：调用c站  酒店常用旅客接口 （调用C站接口用）
 *
 * 历史版本：2011-10-31 v1.0.0 (zhanghan) 创建
 *
 */
public class HotelReturnMessage extends AbstractVo{
	//接口返回状态
	private Result result;
	//接口返回数据
	private List<Passenger> passenger = new ArrayList<Passenger>() ;
	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}
	/**
	 * @return the passenger
	 */
	public List<Passenger> getPassenger() {
		return passenger;
	}
	/**
	 * @param passenger the passenger to set
	 */
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	
	
}
