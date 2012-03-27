package com.hnatourism.club.golf.prod.vo;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
import java.util.List;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫场地表
 * 
 * 历史版本:2011-08-04 v1.0.0 (高杰+栾晓东) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfSiteVo extends AbstractEntity
{
	//场地ID
	private String id;
	//高尔夫产品ID
	private String golfId;
	//球场模式
	private String pattern;
	//球场类型ID
	private Long type;
	//场地数量
	private Long num;
	//场地名称，用逗号分隔记录场地名称
	private String name;
	//场地工作时间
	private String startTime;
	//场地结束时间（下场日期）
	private String endTime;
	//订场规则
	private String rmk;
	//添加者
	private String createUser;
	//添加时间
	private Date createTime;
	//最后修改人
	private String updateUser;
	//最后修改时间
	private Date updateTime;
	//场地平常日价格
	private GolfPriceVo golfPriceVo;
	//场地节假日价格
	private GolfPriceVo golfHPriceVo;
	//场地最近可预订时间
	private String bookTime;
	//场地最近可预订时间，展示
	private String bookTime_show;
	//高尔夫球场类型
	private SysConstantVo sysConst;
	//球场模式
	private SysConstantVo patternVo;
	//场地维修时间集合
	private List<GolfTimeMaintainVo> maintainList;
	//场地工作时间列表
	private List<String> workTimeList;
	//场地工作时间状态列表
	private List<String> workTimeStatusList;
	//场地对应的球场VO
	private GolfInfoVo  golfInfoVo;
	//是否是节假日
	private SysHolidayVo holiday;
	//价格列表
	private List<GolfPriceVo> pricelist;
	//消费说明
	private String explain;
	
	
	public GolfInfoVo getGolfInfoVo() {
		return golfInfoVo;
	}
	public void setGolfInfoVo(GolfInfoVo golfInfoVo) {
		this.golfInfoVo = golfInfoVo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGolfId() {
		return golfId;
	}
	public void setGolfId(String golfId) {
		this.golfId = golfId;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public List<GolfTimeMaintainVo> getMaintainList() {
		return maintainList;
	}
	public void setMaintainList(List<GolfTimeMaintainVo> maintainList) {
		this.maintainList = maintainList;
	}
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	public List<String> getWorkTimeList() {
		return workTimeList;
	}
	public void setWorkTimeList(List<String> workTimeList) {
		this.workTimeList = workTimeList;
	}
	public List<String> getWorkTimeStatusList() {
		return workTimeStatusList;
	}
	public void setWorkTimeStatusList(List<String> workTimeStatusList) {
		this.workTimeStatusList = workTimeStatusList;
	}
	public GolfPriceVo getGolfPriceVo() {
		return golfPriceVo;
	}
	public void setGolfPriceVo(GolfPriceVo golfPriceVo) {
		this.golfPriceVo = golfPriceVo;
	}
	public SysConstantVo getSysConst() {
		return sysConst;
	}
	public void setSysConst(SysConstantVo sysConst) {
		this.sysConst = sysConst;
	}
	public SysConstantVo getPatternVo() {
		return patternVo;
	}
	public void setPatternVo(SysConstantVo patternVo) {
		this.patternVo = patternVo;
	}
	public String getBookTime_show() {
		return bookTime_show;
	}
	public void setBookTime_show(String bookTimeShow) {
		bookTime_show = bookTimeShow;
	}
	public GolfPriceVo getGolfHPriceVo() {
		return golfHPriceVo;
	}
	public void setGolfHPriceVo(GolfPriceVo golfHPriceVo) {
		this.golfHPriceVo = golfHPriceVo;
	}
	public SysHolidayVo getHoliday() {
		return holiday;
	}
	public void setHoliday(SysHolidayVo holiday) {
		this.holiday = holiday;
	}
	public List<GolfPriceVo> getPricelist() {
		return pricelist;
	}
	public void setPricelist(List<GolfPriceVo> pricelist) {
		this.pricelist = pricelist;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
}