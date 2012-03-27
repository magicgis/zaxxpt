package com.hnatourism.club.lounge.prod.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室项目价格表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class LoungePriceVo extends AbstractVo{
	/**
	 * 价格主键
	 */
	private String id;
	/**
	 * 价格编码，要求简单但是不能重复
	 */
	private String code;
	/**
	 * 休息室编号
	 */
	private String roomId;
	/**
	 * 签约价格
	 */
	private Double signingPrice;
	/**
	 * 销售价格
	 */
	private Double price;
	/**
	 * 儿童销售价
	 */
	private Double childrenPrice;
	/**
	 * 包含项目/单收费项目名称
	 */
	private String item;
	/**
	 * S：单收费项目
	 */
	private String type;
	/**
	 * 0按人，1按单
	 */
	private String way;
	/**
	 * 启用状态
	 */
	private String sts;
	/**
	 * 暂时不用，有效期开始日期
	 */
	private Date startDate;
	/**
	 * 暂时不用，有效期结束日期
	 */
	private Date endDate;
	/**
	 * ${c.getComments()}
	 */
	private String createUser;
	/**
	 * ${c.getComments()}
	 */
	private Date createTime;
	/**
	 * ${c.getComments()}
	 */
	private String updateUser;
	/**
	 * ${c.getComments()}
	 */
	private Date updateTime;
	private Double price_reg;
	private Double cprice_reg;

	/**
	 * 获取价格主键
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置价格主键
	 * @param id
	 */	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取价格编码，要求简单但是不能重复
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置价格编码，要求简单但是不能重复
	 * @param code
	 */	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取休息室编号
	 * @return
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * 设置休息室编号
	 * @param roomId
	 */	
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	/**
	 * 获取签约价格
	 * @return
	 */
	public Double getSigningPrice() {
		return signingPrice;
	}

	/**
	 * 设置签约价格
	 * @param signingPrice
	 */	
	public void setSigningPrice(Double signingPrice) {
		this.signingPrice = signingPrice;
	}
	/**
	 * 获取销售价格
	 * @return
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 设置销售价格
	 * @param price
	 */	
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取儿童销售价
	 * @return
	 */
	public Double getChildrenPrice() {
		return childrenPrice;
	}

	/**
	 * 设置儿童销售价
	 * @param childrenPrice
	 */	
	public void setChildrenPrice(Double childrenPrice) {
		this.childrenPrice = childrenPrice;
	}
	/**
	 * 获取包含项目/单收费项目名称
	 * @return
	 */
	public String getItem() {
		return item;
	}

	/**
	 * 设置包含项目/单收费项目名称
	 * @param item
	 */	
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * 获取S：单收费项目
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置S：单收费项目
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取0按人，1按单
	 * @return
	 */
	public String getWay() {
		return way;
	}

	/**
	 * 设置0按人，1按单
	 * @param way
	 */	
	public void setWay(String way) {
		this.way = way;
	}
	/**
	 * 获取启用状态
	 * @return
	 */
	public String getSts() {
		return sts;
	}

	/**
	 * 设置启用状态
	 * @param sts
	 */	
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取暂时不用，有效期开始日期
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 设置暂时不用，有效期开始日期
	 * @param startDate
	 */	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取暂时不用，有效期结束日期
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 设置暂时不用，有效期结束日期
	 * @param endDate
	 */	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public Double getPrice_reg() {
		return price_reg;
	}

	public void setPrice_reg(Double priceReg) {
		price_reg = priceReg;
	}

	public Double getCprice_reg() {
		return cprice_reg;
	}

	public void setCprice_reg(Double cpriceReg) {
		cprice_reg = cpriceReg;
	}
}