/**
 * 项目名称：海航旅业B2C
 *
 * 功能描述
 *
 * @ver 0.1
 * @author zhangyun
 */
package com.hnatourism.club.common.web.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;

import com.hnatourism.club.common.cache.FlightCache;
import com.hnatourism.club.common.domain.FlightAirport;
import com.hnatourism.club.common.domain.HnaProcity;
import com.hnatourism.framework.cache.CacheDataManager;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.opensymphony.xwork2.ActionSupport;


public class BookSuccAction extends ActionSupport{
	
	private String orderId;
	private String orderCode;
	private String price;
	private String goods;
	
	
	public String toSuccess()
	{
		return goods;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getGoods() {
		return goods;
	}


	public void setGoods(String goods) {
		this.goods = goods;
	}
}