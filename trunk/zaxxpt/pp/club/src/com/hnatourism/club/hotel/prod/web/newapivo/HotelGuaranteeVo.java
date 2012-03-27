package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店担保查询返回内容
 * 
 * 历史版本: 2011-11-17 v1.0.0 (lixun) 创建
 * 
 */
public class HotelGuaranteeVo {
	/** property 	是否需要担保 0-不担保,1-担保*/
	private String needGuarantee;

	/** property 	*/
	private String guaranteeMoney;

	/** property 	*/
	private String guaranteeRule;

	public String getNeedGuarantee() {
		return needGuarantee;
	}

	public void setNeedGuarantee(String needGuarantee) {
		this.needGuarantee = needGuarantee;
	}

	public String getGuaranteeMoney() {
		return guaranteeMoney;
	}

	public void setGuaranteeMoney(String guaranteeMoney) {
		this.guaranteeMoney = guaranteeMoney;
	}

	public String getGuaranteeRule() {
		return guaranteeRule;
	}

	public void setGuaranteeRule(String guaranteeRule) {
		this.guaranteeRule = guaranteeRule;
	}
	
}
