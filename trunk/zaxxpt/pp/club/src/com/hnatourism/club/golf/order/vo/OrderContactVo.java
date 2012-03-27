package com.hnatourism.club.golf.order.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:订单联系人表
 * 
 * 历史版本:
 *					2011-08-08 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderContactVo extends AbstractVo{
	/**
	 * ID
	 */
	private String id ;
	/**
	 * 姓名
	 */
	private String name ;
	/**
	 * 电话
	 */
	private String phone ;
	/**
	 * 手机
	 */
	private String mobile ;
	/**
	 * 电子邮件
	 */
	private String email ;
	/**
	 * 确认方式(phone:电话;mobile:手机;email:电子邮件),酒店使用，不能为空
	 */
	private String confirmMode ;
	/**
	 * ${c.getComments()}
	 */
	private String rmk ;
	/**
	 * 创建人
	 */
	private String createUser ;
	/**
	 * 创建时间
	 */
	private Date createTime ;
	/**
	 * 订单id
	 */
	private String orderId ;
	/**
	 * 订单编码(方便显示)
	 */
	private String orderCode ;
	/**
	 * 0.机票 1.酒店 2 机+酒 3.度假
	 */
	private String prodType ;
	/**
	 * 更新人Code值
	 */
	private String updateUser ;
	/**
	 * 更新时间
	 */
	private Date updateTime ;
	/**
	 * 地址
	 */
	private String address ;
	/**
	 * 城市
	 */
	private String city ;

	/**
	 * 获取ID
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置ID
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置姓名
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取电话
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置电话
	 * @param phone
	 */	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取手机
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置手机
	 * @param mobile
	 */	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取电子邮件
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置电子邮件
	 * @param email
	 */	
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取确认方式(phone:电话;mobile:手机;email:电子邮件),酒店使用，不能为空
	 * @return
	 */
	public String getConfirmMode() {
		return confirmMode;
	}
	/**
	 * 设置确认方式(phone:电话;mobile:手机;email:电子邮件),酒店使用，不能为空
	 * @param confirmMode
	 */	
	public void setConfirmMode(String confirmMode) {
		this.confirmMode = confirmMode;
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
	 * 获取创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置创建时间
	 * @param createTime
	 */	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取订单id
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * 设置订单id
	 * @param orderId
	 */	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取订单编码(方便显示)
	 * @return
	 */
	public String getOrderCode() {
		return orderCode;
	}
	/**
	 * 设置订单编码(方便显示)
	 * @param orderCode
	 */	
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	/**
	 * 获取0.机票 1.酒店 2 机+酒 3.度假
	 * @return
	 */
	public String getProdType() {
		return prodType;
	}
	/**
	 * 设置0.机票 1.酒店 2 机+酒 3.度假
	 * @param prodType
	 */	
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	/**
	 * 获取更新人Code值
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置更新人Code值
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
	 * 获取地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置地址
	 * @param address
	 */	
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取城市
	 * @return
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置城市
	 * @param city
	 */	
	public void setCity(String city) {
		this.city = city;
	}
}