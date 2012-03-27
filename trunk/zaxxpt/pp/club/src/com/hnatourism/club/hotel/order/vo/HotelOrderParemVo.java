package com.hnatourism.club.hotel.order.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店信息预订vo
 * 
 * 历史版本:2011-09-06 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HotelOrderParemVo extends AbstractVo{
	/**
	 * 客户ID
	 */
	String memberId;
	/**
	 * 是否是新用户预订，1为是，0为否
	 */
	String isFirst;
	/**
	 * 酒店编码
	 */
	String hcode;
	/**
	 * 房型编码
	 */
	String rcode;
	/**
	 * 入住时间 YYYY-MM-DD
	 */
	String idate;
	/**
	 * 离店时间YYYY-MM-DD
	 */
	String odate;
	/**
	 * 预计到点时间  HH:MM-HH:MM
	 */
	String adate;
	/**
	 * 入住人数
	 */
	int pnum;
	/**
	 * 入住人姓名 多人使用逗号分隔
	 */
	String pname;
	/**
	 * 总价格
	 */
	Long totalMoney;
	/**
	 * 特殊需求
	 */
	String rmk;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}
	public String getHcode() {
		return hcode;
	}
	public void setHcode(String hcode) {
		this.hcode = hcode;
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Long getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Long totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
}