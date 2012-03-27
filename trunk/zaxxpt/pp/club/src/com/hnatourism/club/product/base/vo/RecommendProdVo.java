package com.hnatourism.club.product.base.vo;

import java.util.Date;

import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:
 * 
 * 历史版本: 2011-9-22 v1.0.0 (lixun) 创建
 * 
 */
public class RecommendProdVo extends AbstractVo{
	//${c.getComments()}
	private String id ;
	//推荐城市简码
	private String recommendCityCode ;
	//产品类型 F机票 H酒店 T 旅游G团购 C优惠券
	private String prodType ;
	//顺序
	private Long seq ;
	//价格
	private Long price ;
	//折扣
	private Long discount ;
	//版本
	private String version ;
	//内容
	private String content ;
	//产品子类型：如酒店【0.特价，1点评, 2.置顶】
	private String prodSubType ;
	//DEPARTURE_AIRPORT-ARRIVAL_AIRPORT,HOTEL_CODE-ROOM_CODE，GROUP_CODE
	private String prodCode ;
	//出发城市-到达城市，喜来登-大床房
	private String prodName ;
	//出发日期，入住日期
	private Date startDate ;
	//0禁用 1启动
	private String sts ;
	//${c.getComments()}
	private String rmk ;
	//${c.getComments()}
	private String createUser ;
	//${c.getComments()}
	private Date createTime ;
	//${c.getComments()}
	private String updateUser ;
	//${c.getComments()}
	private Date updateTime ;
	//标题
	private String title ;
	//页面样式
	private String css ;
	//页面位置简码
	private String location ;
	
	private String source;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecommendCityCode() {
		return recommendCityCode;
	}

	public void setRecommendCityCode(String recommendCityCode) {
		this.recommendCityCode = recommendCityCode;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProdSubType() {
		return prodSubType;
	}

	public void setProdSubType(String prodSubType) {
		this.prodSubType = prodSubType;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
}
