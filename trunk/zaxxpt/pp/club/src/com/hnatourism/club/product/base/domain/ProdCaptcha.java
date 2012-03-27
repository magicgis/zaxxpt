package com.hnatourism.club.product.base.domain;


import java.util.Date;

import com.hnatourism.framework.core.domain.AbstractEntity;
/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:消费验证码
 * 
 * 历史版本:
 *					2011-08-29 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class ProdCaptcha extends AbstractEntity {
	//主键
	private String id;
	//串码编码，不能重复
	private String code;
	//串码使用状态
	private String sts;
	//类型 0 优惠券验证码GF高尔夫消费码L机场消费码
	private String type;
	//暂时无用，如：prod_coupons_id
	private String prodId;
	//暂时无用，如：prod_coupons_code
	private String prodCode;
	//使用的订单
	private String orderCode;
	//备注
	private String rmk;
	//暂时无用，所有人
	private String memberId;
	//串码创建时间
	private Date createTime;
	//${c.getComments()}
	private String createUser;
	//${c.getComments()}
	private Date updateTime;
	//${c.getComments()}
	private String updateUser;

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
	 * 获取串码编码，不能重复
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置串码编码，不能重复
	 * @param code
	 */	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取串码使用状态
	 * @return
	 */
	public String getSts() {
		return sts;
	}

	/**
	 * 设置串码使用状态
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取类型 0 优惠券验证码GF高尔夫消费码L机场消费码
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置类型 0 优惠券验证码GF高尔夫消费码L机场消费码
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取暂时无用，如：prod_coupons_id
	 * @return
	 */
	public String getProdId() {
		return prodId;
	}

	/**
	 * 设置暂时无用，如：prod_coupons_id
	 * @param prodId
	 */	
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	/**
	 * 获取暂时无用，如：prod_coupons_code
	 * @return
	 */
	public String getProdCode() {
		return prodCode;
	}

	/**
	 * 设置暂时无用，如：prod_coupons_code
	 * @param prodCode
	 */	
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	/**
	 * 获取使用的订单
	 * @return
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * 设置使用的订单
	 * @param orderCode
	 */	
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	/**
	 * 获取备注
	 * @return
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * 设置备注
	 * @param rmk
	 */	
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * 获取暂时无用，所有人
	 * @return
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 设置暂时无用，所有人
	 * @param memberId
	 */	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取串码创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置串码创建时间
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
}