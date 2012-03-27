package com.hnatourism.club.flight.web.vo;

import com.hnatourism.framework.web.vo.AbstractVo;

public class FlightMemberPassenVo extends AbstractVo {
	/**
	*乘机人vo wuyuhu
	*2011-8-23
	*/
	private static final long serialVersionUID = 1L;
	private String name;// 名称
	private String type;// 乘客类型01成人; 02儿童
	private String certType;// 乘客类型为01成人时：证件类型: 0身份证;1护照; 2军官证;
	// 3港澳通行证 ; 4回乡证; 5台胞证; 6国际海员证; 7外国人永久居留证; 9其他；乘客类型为02儿童时：证件类型：0身份证;9出生日期
	private String certNo;//证件号码（类型为儿童，证件类型选择为出生日期时，格式为：YYYY-MM-DD）
	private String id;//乘机人 ID
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
