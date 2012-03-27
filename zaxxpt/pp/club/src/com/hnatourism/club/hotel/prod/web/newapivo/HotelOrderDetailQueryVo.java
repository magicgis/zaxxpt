package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店订单详情查询vo
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelOrderDetailQueryVo {
	
	private String code;
	private String source;
	private String key;
	private String syssource;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSyssource() {
		return syssource;
	}
	public void setSyssource(String syssource) {
		this.syssource = syssource;
	}
}
