package com.hnatourism.club.product.base.domain;


import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:推荐产品类
 * 
 * 历史版本:
 *					2011-03-21 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class RecommendProd extends AbstractEntity {
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

	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置${c.getComments()}
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取推荐城市简码
	 * @return
	 */
	public String getRecommendCityCode() {
		return recommendCityCode;
	}
	/**
	 * 设置推荐城市简码
	 * @param recommendCityCode
	 */	
	public void setRecommendCityCode(String recommendCityCode) {
		this.recommendCityCode = recommendCityCode;
	}
	/**
	 * 获取产品类型 F机票 H酒店 T 旅游G团购 C优惠券
	 * @return
	 */
	public String getProdType() {
		return prodType;
	}
	/**
	 * 设置产品类型 F机票 H酒店 T 旅游G团购 C优惠券
	 * @param prodType
	 */	
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	/**
	 * 获取顺序
	 * @return
	 */
	public Long getSeq() {
		return seq;
	}
	/**
	 * 设置顺序
	 * @param seq
	 */	
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	/**
	 * 获取价格
	 * @return
	 */
	public Long getPrice() {
		return price;
	}
	/**
	 * 设置价格
	 * @param price
	 */	
	public void setPrice(Long price) {
		this.price = price;
	}
	/**
	 * 获取折扣
	 * @return
	 */
	public Long getDiscount() {
		return discount;
	}
	/**
	 * 设置折扣
	 * @param discount
	 */	
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	/**
	 * 获取版本
	 * @return
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * 设置版本
	 * @param version
	 */	
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 获取内容
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置内容
	 * @param content
	 */	
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取产品子类型：如酒店【0.特价，1点评, 2.置顶】
	 * @return
	 */
	public String getProdSubType() {
		return prodSubType;
	}
	/**
	 * 设置产品子类型：如酒店【0.特价，1点评, 2.置顶】
	 * @param prodSubType
	 */	
	public void setProdSubType(String prodSubType) {
		this.prodSubType = prodSubType;
	}
	/**
	 * 获取DEPARTURE_AIRPORT-ARRIVAL_AIRPORT,HOTEL_CODE-ROOM_CODE
，GROUP_CODE
	 * @return
	 */
	public String getProdCode() {
		return prodCode;
	}
	/**
	 * 设置DEPARTURE_AIRPORT-ARRIVAL_AIRPORT,HOTEL_CODE-ROOM_CODE
，GROUP_CODE
	 * @param prodCode
	 */	
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	/**
	 * 获取出发城市-到达城市
，喜来登-大床房
	 * @return
	 */
	public String getProdName() {
		return prodName;
	}
	/**
	 * 设置出发城市-到达城市
，喜来登-大床房
	 * @param prodName
	 */	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	/**
	 * 获取出发日期，入住日期
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置出发日期，入住日期
	 * @param startDate
	 */	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取0禁用 1启动
	 * @return
	 */
	public String getSts() {
		return sts;
	}
	/**
	 * 设置0禁用 1启动
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * 设置${c.getComments()}
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置${c.getComments()}
	 * @param createUser
	 */	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置${c.getComments()}
	 * @param updateUser
	 */	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param updateTime
	 */	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取标题
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置标题
	 * @param title
	 */	
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取页面样式
	 * @return
	 */
	public String getCss() {
		return css;
	}
	/**
	 * 设置页面样式
	 * @param css
	 */	
	public void setCss(String css) {
		this.css = css;
	}
	/**
	 * 获取页面位置简码
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置页面位置简码
	 * @param location
	 */	
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