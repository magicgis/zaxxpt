package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店订单列表查询vo
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelOrderQueryVo {
	private String memberid;// 用户id;//必填
	private String source;// 客户端类型_客户端名称_渠道_版本号来源，如android_hotel_xhlx_v1.0;//必填
	private String key;// 新华旅行网分配的唯一授权码;//
	private String syssource;// 系统来源;//
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
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
