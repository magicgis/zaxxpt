package com.hnatourism.club.golf.order.vo;
import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:账单表
 * 
 * 历史版本:
 *					2011-08-08 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class OrderBillVo extends AbstractVo{
	/**
	 * ${c.getComments()}
	 */
	private String id ;
	/**
	 * ${c.getComments()}
	 */
	private String roleId ;
	/**
	 * ${c.getComments()}
	 */
	private Long type ;
	/**
	 * ${c.getComments()}
	 */
	private Long account ;
	/**
	 * ${c.getComments()}
	 */
	private Long tradeNo ;
	/**
	 * ${c.getComments()}
	 */
	private Date tradeTime ;
	/**
	 * ${c.getComments()}
	 */
	private Double mny ;
	/**
	 * ${c.getComments()}
	 */
	private Date updateTime ;
	/**
	 * ${c.getComments()}
	 */
	private String updateUser ;
	/**
	 * ${c.getComments()}
	 */
	private Date createTime ;
	/**
	 * ${c.getComments()}
	 */
	private String createUser ;

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
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置${c.getComments()}
	 * @param roleId
	 */	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getType() {
		return type;
	}
	/**
	 * 设置${c.getComments()}
	 * @param type
	 */	
	public void setType(Long type) {
		this.type = type;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getAccount() {
		return account;
	}
	/**
	 * 设置${c.getComments()}
	 * @param account
	 */	
	public void setAccount(Long account) {
		this.account = account;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getTradeNo() {
		return tradeNo;
	}
	/**
	 * 设置${c.getComments()}
	 * @param tradeNo
	 */	
	public void setTradeNo(Long tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getTradeTime() {
		return tradeTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param tradeTime
	 */	
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Double getMny() {
		return mny;
	}
	/**
	 * 设置${c.getComments()}
	 * @param mny
	 */	
	public void setMny(Double mny) {
		this.mny = mny;
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
}