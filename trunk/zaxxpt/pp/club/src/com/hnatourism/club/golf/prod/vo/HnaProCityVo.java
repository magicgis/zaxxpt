package com.hnatourism.club.golf.prod.vo;

import java.util.List;

import com.hnatourism.framework.web.vo.AbstractVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫球场的城市vo
 * 
 * 历史版本:2011-08-02 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class HnaProCityVo extends AbstractVo
{
	/**
	 * 城市ID
	 */
	private String pcCode;
	
	/**
	 * 城市名称
	 */
	private String pcName;
	
	/**
	 * 城市包含的球场列表
	 */
	private List<GolfInfoVo> golflist;
	
	/**
	 * 城市包含的球场列表
	 */
	private List<List<GolfInfoVo>> golflist_result;
	

	public String getPcCode() {
		return pcCode;
	}

	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public List<GolfInfoVo> getGolflist() {
		return golflist;
	}

	public void setGolflist(List<GolfInfoVo> golflist) {
		this.golflist = golflist;
	}

	public List<List<GolfInfoVo>> getGolflist_result() {
		return golflist_result;
	}

	public void setGolflist_result(List<List<GolfInfoVo>> golflistResult) {
		golflist_result = golflistResult;
	}
}
