package com.hnatourism.club.lounge.prod.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnatourism.framework.web.vo.AbstractVo;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场休息室产品信息表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class LoungeInfoVo extends AbstractVo{
	/**
	 * ${c.getComments()}
	 */
	private String id;
	/**
	 * 机场休息室名称
	 */
	private String name;
	/**
	 * 机场三字码码
	 */
	private String airportCode;
	/**
	 * 休息室地址
	 */
	private String address;
	/**
	 * 航空公司二字码，多个用/分隔
	 */
	private String airlineCorp;
	/**
	 * 启用状态
	 */
	private String sts;
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
	//房间类型集合
	private List<LoungeRoomVo> roomlist;
	//机场
	private FilghtAirportVo airport;
	//航空公司
	private List<FilghtAirlineComVo> airlinelist;
	private String organizationId;
	private LoungeImgVo image;
	
	//平面图
	private List<LoungeImgVo> loungeImgVoList=new ArrayList<LoungeImgVo>();
	
	
	
	public List<LoungeImgVo> getLoungeImgVoList() {
		return loungeImgVoList;
	}

	public void setLoungeImgVoList(List<LoungeImgVo> loungeImgVoList) {
		this.loungeImgVoList = loungeImgVoList;
	}

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
	 * 获取机场休息室名称
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置机场休息室名称
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取机场三字码码
	 * @return
	 */
	public String getAirportCode() {
		return airportCode;
	}

	/**
	 * 设置机场三字码码
	 * @param airportCode
	 */	
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	/**
	 * 获取休息室地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置休息室地址
	 * @param address
	 */	
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取航空公司二字码，多个用/分隔
	 * @return
	 */
	public String getAirlineCorp() {
		return airlineCorp;
	}

	/**
	 * 设置航空公司二字码，多个用/分隔
	 * @param airlineCorp
	 */	
	public void setAirlineCorp(String airlineCorp) {
		this.airlineCorp = airlineCorp;
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

	public List<LoungeRoomVo> getRoomlist() {
		return roomlist;
	}

	public void setRoomlist(List<LoungeRoomVo> roomlist) {
		this.roomlist = roomlist;
	}

	public FilghtAirportVo getAirport() {
		return airport;
	}

	public void setAirport(FilghtAirportVo airport) {
		this.airport = airport;
	}

	public List<FilghtAirlineComVo> getAirlinelist() {
		return airlinelist;
	}

	public void setAirlinelist(List<FilghtAirlineComVo> airlinelist) {
		this.airlinelist = airlinelist;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public LoungeImgVo getImage() {
		return image;
	}

	public void setImage(LoungeImgVo image) {
		this.image = image;
	}
}