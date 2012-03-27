package com.hnatourism.club.golf.prod.vo;

import com.hnatourism.framework.core.domain.AbstractEntity;
import java.util.Date;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫预定时间表
 * 
 * 历史版本:
 *					2011-08-01 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfTimeMaintainVo extends AbstractEntity {
	//ID
	private String id;
	//场地ID
	private String golfId;
	//场地维护结束时间
	private String endTime;
	//场地维护开始时间
	private String startTime;
	//添加时间
	private Date createTime;
	//添加者
	private String createUser;
	//最后修改人
	private String updateUser;
	//最后修改时间
	private Date updateTime;
	
	
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
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime)
	{
		
		String front=endTime.substring(0,endTime.indexOf(":"));
		String back=endTime.substring(endTime.indexOf(":")+1);
		String middle=front.substring(front.indexOf(" ")+1);
		front=front.substring(0,front.indexOf(" "));
		
		if(!back.equalsIgnoreCase("00"))
		{
			middle=String.valueOf(Integer.parseInt(middle)+1);
			back="00";
		}
		
		this.endTime = front+" "+middle+":"+back;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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
}