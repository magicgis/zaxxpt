package com.hnatourism.club.flight.web.vo;

import java.util.Date;

import com.hnatourism.framework.web.vo.AbstractVo;

public class OrderFlightLogVo extends AbstractVo{

	// ID
	private String id;
	// 订单号
	private String orderCode;
	// 创建人
	private String createUser;
	// 创建时间
	private String createTime;
	// 操作类型
	private String type;
	// 对应旅客姓名
	private String userName;
	// 操作内容（例如：）
	// 张无敌 改为西部航空ＣＺ１５２１航班 15：30起飞 16：50到达 新票号：123-24323423
	// 张无敌 西部航空ＣＺ１５２１航班 受理中
	// 张无敌 改为：身份证 1501201215454811222
	// 张无敌 西部航空ＣＺ１５２１航班 已退款

	private String content;
	// 更新人
	private String updateUser;
	// 更新时间
	private Date updateTime;
	// 备用字段1
	private String filed1;
	// 备用字段2
	private String filed2;
	// 备用字段3
	private String filed3;
	// 备用字段4
	private String filed4;
	// 备用字段5
	private String filed5;

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
	 * 获取订单号
	 * @return
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * 设置订单号
	 * @param orderCode
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
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
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取操作类型
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置操作类型
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取对应旅客姓名
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置对应旅客姓名
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取操作内容（例如：）
	张无敌　改为西部航空ＣＺ１５２１航班　15：30起飞　16：50到达　新票号：123-24323423
	张无敌　西部航空ＣＺ１５２１航班　受理中
	张无敌　改为：身份证　1501201215454811222
	张无敌　西部航空ＣＺ１５２１航班　已退款

	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置操作内容（例如：）
	张无敌　改为西部航空ＣＺ１５２１航班　15：30起飞　16：50到达　新票号：123-24323423
	张无敌　西部航空ＣＺ１５２１航班　受理中
	张无敌　改为：身份证　1501201215454811222
	张无敌　西部航空ＣＺ１５２１航班　已退款

	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * 获取备用字段1
	 * @return
	 */
	public String getFiled1() {
		return filed1;
	}

	/**
	 * 设置备用字段1
	 * @param filed1
	 */
	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}

	/**
	 * 获取备用字段2
	 * @return
	 */
	public String getFiled2() {
		return filed2;
	}

	/**
	 * 设置备用字段2
	 * @param filed2
	 */
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}

	/**
	 * 获取备用字段3
	 * @return
	 */
	public String getFiled3() {
		return filed3;
	}

	/**
	 * 设置备用字段3
	 * @param filed3
	 */
	public void setFiled3(String filed3) {
		this.filed3 = filed3;
	}

	/**
	 * 获取备用字段4
	 * @return
	 */
	public String getFiled4() {
		return filed4;
	}

	/**
	 * 设置备用字段4
	 * @param filed4
	 */
	public void setFiled4(String filed4) {
		this.filed4 = filed4;
	}

	/**
	 * 获取备用字段5
	 * @return
	 */
	public String getFiled5() {
		return filed5;
	}

	/**
	 * 设置备用字段5
	 * @param filed5
	 */
	public void setFiled5(String filed5) {
		this.filed5 = filed5;
	}

}
