package com.hnatourism.club.golf.prod.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnatourism.club.common.domain.SysContact;
import com.hnatourism.framework.web.vo.AbstractVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫产品信息VO
 * 
 * 历史版本:2010-08-04 v1.0.0 (高杰+栾晓东+周峰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfInfoVo extends AbstractVo
{
	/**
	 * 球场模式
	 */
	private String pattern ;
	//产品ID
	private String id;
	//产品名称
	private String name;
	//对应城市ID
	private String city;
	//设计师
	private String designer;
	//球场模式
	private String sitemode;
	//产品建立时间
	private Date setupTime;
	//球场面积
	private Long stadiumArea;
	//球道长度
	private Long fairwayLength;
	//果岭草种
	private String greenGrass;
	//球道草种
	private String fairwayGrass;
	//球场数据
	private String courseData;
	//球场描述
	private String courseDescription;
	//设施信息，该字段存储设施的ID，以逗号分隔
	private String facilityInformation;
	//产品状态
	private String sts;
	//添加者
	private String createUser;
	//添加时间
	private Date createTime;
	//最后修改人
	private String updateUser;
	//最后修改时间
	private Date updateTime;
	//高尔夫平时价格
	private GolfPriceVo minPrice;
	//高尔夫节假日价格
	private GolfPriceVo minHPrice;
	//高尔夫图片
	private GolfImageVo golfimage;
	//高尔夫城市（省份）
	private HnaProCityVo cityVo;
	//球场状态
	private SysConstantVo sysConstantVo;
	//高尔夫场地VO列表
	private List<GolfSiteVo> golfsitelist;
	//高尔夫场地VO
	private GolfSiteVo golfsite;
	//球场图片列表
	private List<GolfImageVo> golfiamgelist;
	private String organizationId;
	//地址
	private String address;
	//路线
	private String referenceLine;
	//联系人
	private List<SysContact> sysContactList=new ArrayList<SysContact>();
	
	
	public List<SysContact> getSysContactList() {
		return sysContactList;
	}
	public void setSysContactList(List<SysContact> sysContactList) {
		this.sysContactList = sysContactList;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReferenceLine() {
		return referenceLine;
	}
	public void setReferenceLine(String referenceLine) {
		this.referenceLine = referenceLine;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public GolfPriceVo getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(GolfPriceVo minPrice) {
		this.minPrice = minPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public Date getSetupTime() {
		return setupTime;
	}
	public void setSetupTime(Date setupTime) {
		this.setupTime = setupTime;
	}
	public Long getStadiumArea() {
		return stadiumArea;
	}
	public void setStadiumArea(Long stadiumArea) {
		this.stadiumArea = stadiumArea;
	}
	public Long getFairwayLength() {
		return fairwayLength;
	}
	public void setFairwayLength(Long fairwayLength) {
		this.fairwayLength = fairwayLength;
	}
	public String getGreenGrass() {
		return greenGrass;
	}
	public void setGreenGrass(String greenGrass) {
		this.greenGrass = greenGrass;
	}
	public String getFairwayGrass() {
		return fairwayGrass;
	}
	public void setFairwayGrass(String fairwayGrass) {
		this.fairwayGrass = fairwayGrass;
	}
	public String getCourseData() {
		return courseData;
	}
	public void setCourseData(String courseData) {
		this.courseData = courseData;
	}
	public String getFacilityInformation() {
		return facilityInformation;
	}
	public void setFacilityInformation(String facilityInformation) {
		this.facilityInformation = facilityInformation;
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
	public GolfImageVo getGolfimage() {
		return golfimage;
	}
	public void setGolfimage(GolfImageVo golfimage) {
		this.golfimage = golfimage;
	}
	public List<GolfSiteVo> getGolfsitelist() {
		return golfsitelist;
	}
	public void setGolfsitelist(List<GolfSiteVo> golfsitelist) {
		this.golfsitelist = golfsitelist;
	}
	public List<GolfImageVo> getGolfiamgelist() {
		return golfiamgelist;
	}
	public void setGolfiamgelist(List<GolfImageVo> golfiamgelist) {
		this.golfiamgelist = golfiamgelist;
	}
	public HnaProCityVo getCityVo() {
		return cityVo;
	}
	public void setCityVo(HnaProCityVo cityVo) {
		this.cityVo = cityVo;
	}
	public String getSitemode() {
		return sitemode;
	}
	public void setSitemode(String sitemode) {
		this.sitemode = sitemode;
	}

	public SysConstantVo getSysConstantVo() {
		return sysConstantVo;
	}
	public void setSysConstantVo(SysConstantVo sysConstantVo) {
		this.sysConstantVo = sysConstantVo;
	}
	
	/**
	 * 获取球场模式
	 * @return
	 */
	public String getPattern() {
		return pattern;
	}
	/**
	 * 设置球场模式
	 * @param pattern
	 */	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public GolfPriceVo getMinHPrice() {
		return minHPrice;
	}
	public void setMinHPrice(GolfPriceVo minHPrice) {
		this.minHPrice = minHPrice;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public GolfSiteVo getGolfsite() {
		return golfsite;
	}
	public void setGolfsite(GolfSiteVo golfsite) {
		this.golfsite = golfsite;
	}
}