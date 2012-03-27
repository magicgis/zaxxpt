package com.hnatourism.club.order.domain;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:积分兑换订单
 * 
 * 历史版本:
 *					2011-10-12 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderPointsExchange extends AbstractEntity {
	//创建人
	private String createUser ;
	//创建时间，信息发布时间(YYYY-MM-DD HH:MM:SS)
	private Date createTime ;
	//更新人
	private String updateUser ;
	//更新时间
	private Date updateTime ;
	//主键
	private String id ;
	//积分兑换编号
	private String code ;
	//发布会员卡号
	private String owner ;
	//兑换积分数（100的整数倍）
	private Long points ;
	//报价
	private Long price ;
	//联系电话
	private String contact ;
	//状态
	private String sts ;
	//购买者（分公司ID或总公司ID）
	private String purchaser ;
	//兑换时间(YYYY-MM-DD HH:MM:SS)
	private Date conversionTime ;
	//锁定状态（0：未锁定 1：锁定）
	private String operateSts ;
	//所属分公司ID
	private String organizationId ;
	/**
	 * 过期时间（天）
	 */
	private Integer expiredDay;
	
	
	public Integer getExpiredDay() {
		return expiredDay;
	}
	public void setExpiredDay(Integer expiredDay) {
		this.expiredDay = expiredDay;
	}
	/**
	 * 获取创建人
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置创建人
	 * @param createUser
	 */	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取创建时间，信息发布时间(YYYY-MM-DD HH:MM:SS)
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置创建时间，信息发布时间(YYYY-MM-DD HH:MM:SS)
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取更新人
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置更新人
	 * @param updateUser
	 */	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取更新时间
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置更新时间
	 * @param updateTime
	 */	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取主键
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置主键
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取积分兑换编号
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置积分兑换编号
	 * @param code
	 */	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取发布会员卡号
	 * @return
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * 设置发布会员卡号
	 * @param owner
	 */	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * 获取兑换积分数（100的整数倍）
	 * @return
	 */
	public Long getPoints() {
		return points;
	}
	/**
	 * 设置兑换积分数（100的整数倍）
	 * @param points
	 */	
	public void setPoints(Long points) {
		this.points = points;
	}
	/**
	 * 获取报价
	 * @return
	 */
	public Long getPrice() {
		return price;
	}
	/**
	 * 设置报价
	 * @param price
	 */	
	public void setPrice(Long price) {
		this.price = price;
	}
	/**
	 * 获取联系电话
	 * @return
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置联系电话
	 * @param contact
	 */	
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取状态
	 * @return
	 */
	public String getSts() {
		return sts;
	}
	/**
	 * 设置状态
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取购买者（分公司ID或总公司ID）
	 * @return
	 */
	public String getPurchaser() {
		return purchaser;
	}
	/**
	 * 设置购买者（分公司ID或总公司ID）
	 * @param purchaser
	 */	
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	/**
	 * 获取兑换时间(YYYY-MM-DD HH:MM:SS)
	 * @return
	 */
	public Date getConversionTime() {
		return conversionTime;
	}
	/**
	 * 设置兑换时间(YYYY-MM-DD HH:MM:SS)
	 * @param conversionTime
	 */	
	public void setConversionTime(Date conversionTime) {
		this.conversionTime = conversionTime;
	}
	/**
	 * 获取锁定状态（0：未锁定 1：锁定）
	 * @return
	 */
	public String getOperateSts() {
		return operateSts;
	}
	/**
	 * 设置锁定状态（0：未锁定 1：锁定）
	 * @param operateSts
	 */	
	public void setOperateSts(String operateSts) {
		this.operateSts = operateSts;
	}
	/**
	 * 获取所属分公司ID
	 * @return
	 */
	public String getOrganizationId() {
		return organizationId;
	}
	/**
	 * 设置所属分公司ID
	 * @param organizationId
	 */	
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
}