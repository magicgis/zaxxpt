package com.hnatourism.club.golf.domain;


import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫表
 * 
 * 历史版本:
 *					2011-08-01 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfInfo extends AbstractEntity {
	//球场模式
	private String pattern ;
	//${c.getComments()}
	private String id ;
	//${c.getComments()}
	private String name ;
	//${c.getComments()}
	private String city ;
	//${c.getComments()}
	private String designer ;
	//${c.getComments()}
	private Date setupTime ;
	//${c.getComments()}
	private Long stadiumArea ;
	//${c.getComments()}
	private Long fairwayLength ;
	//${c.getComments()}
	private String greenGrass ;
	//${c.getComments()}
	private String fairwayGrass ;
	//${c.getComments()}
	private String courseData ;
	//${c.getComments()}
	private String courseDescription ;
	//该字段存储设施的ID，以逗号分隔
	private String facilityInformation ;
	//${c.getComments()}
	private String sts ;
	//${c.getComments()}
	private String createUser ;
	//${c.getComments()}
	private Date createTime ;
	//${c.getComments()}
	private String updateUser ;
	//${c.getComments()}
	private Date updateTime ;
	
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
	public String getName() {
		return name;
	}
	/**
	 * 设置${c.getComments()}
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置${c.getComments()}
	 * @param city
	 */	
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getDesigner() {
		return designer;
	}
	/**
	 * 设置${c.getComments()}
	 * @param designer
	 */	
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Date getSetupTime() {
		return setupTime;
	}
	/**
	 * 设置${c.getComments()}
	 * @param setupTime
	 */	
	public void setSetupTime(Date setupTime) {
		this.setupTime = setupTime;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getStadiumArea() {
		return stadiumArea;
	}
	/**
	 * 设置${c.getComments()}
	 * @param stadiumArea
	 */	
	public void setStadiumArea(Long stadiumArea) {
		this.stadiumArea = stadiumArea;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public Long getFairwayLength() {
		return fairwayLength;
	}
	/**
	 * 设置${c.getComments()}
	 * @param fairwayLength
	 */	
	public void setFairwayLength(Long fairwayLength) {
		this.fairwayLength = fairwayLength;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getGreenGrass() {
		return greenGrass;
	}
	/**
	 * 设置${c.getComments()}
	 * @param greenGrass
	 */	
	public void setGreenGrass(String greenGrass) {
		this.greenGrass = greenGrass;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getFairwayGrass() {
		return fairwayGrass;
	}
	/**
	 * 设置${c.getComments()}
	 * @param fairwayGrass
	 */	
	public void setFairwayGrass(String fairwayGrass) {
		this.fairwayGrass = fairwayGrass;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getCourseData() {
		return courseData;
	}
	/**
	 * 设置${c.getComments()}
	 * @param courseData
	 */	
	public void setCourseData(String courseData) {
		this.courseData = courseData;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getCourseDescription() {
		return courseDescription;
	}
	/**
	 * 设置${c.getComments()}
	 * @param courseDescription
	 */	
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	/**
	 * 获取该字段存储设施的ID，以逗号分隔
	 * @return
	 */
	public String getFacilityInformation() {
		return facilityInformation;
	}
	/**
	 * 设置该字段存储设施的ID，以逗号分隔
	 * @param facilityInformation
	 */	
	public void setFacilityInformation(String facilityInformation) {
		this.facilityInformation = facilityInformation;
	}
	/**
	 * 获取${c.getComments()}
	 * @return
	 */
	public String getSts() {
		return sts;
	}
	/**
	 * 设置${c.getComments()}
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
}