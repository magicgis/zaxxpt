package com.hnatourism.club.hotel.order.vo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:
 * 
 * 历史版本: 2011-9-5 v1.0.0 (lixun) 创建
 * 
 */
public class QueryHotelOrderVo {

	private String memberId;
	private String code;
	private String source ;
	/**
	 * 订单状态 sts 订单状态 XD：未支付 YQR：已支付 SC：已取消
	 */
	private String sts;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

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

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}
	
}
