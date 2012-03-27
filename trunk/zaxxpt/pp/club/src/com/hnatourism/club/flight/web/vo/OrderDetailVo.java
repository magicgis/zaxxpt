package com.hnatourism.club.flight.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;
	/**
	*机票订单详细信息 vo wuyuhu
	*2011-8-23
	*/	

public class OrderDetailVo extends AbstractVo {
	//订单id
	private String orderId;
	//订单号
	private String code;
	//金额
	private String totalMoney;
	//订单日期
	private String createTime;
	//出发城市
	private String depAirportCode;
	//到达城市
	private String arrAirportCode;
	//状态 等待支付 00 等待出票 01出票成功 02 出票失败 03 已取消 04
	private String sts;
	//航班类型  单程 1往返 2 联程 3
	private String type;
	//备注
	private String rmk;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDepAirportCode() {
		return depAirportCode;
	}

	public void setDepAirportCode(String depAirportCode) {
		this.depAirportCode = depAirportCode;
	}

	public String getArrAirportCode() {
		return arrAirportCode;
	}

	public void setArrAirportCode(String arrAirportCode) {
		this.arrAirportCode = arrAirportCode;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	
}
 
