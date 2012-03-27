package com.hnatourism.club.common.web.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.cache.CityareaCache;
import com.hnatourism.club.common.helper.flight.WeatherRequestMessage;
import com.hnatourism.club.common.service.ISysOrganizationService;
import com.hnatourism.club.common.service.ISysWeatherService;
import com.hnatourism.club.common.web.javabean.IndexQryComponent;
import com.hnatourism.club.common.web.vo.WeatherVo;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.web.action.BaseAction;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:官方公告
 * 
 * 历史版本:
 *					2010-08-03 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class SysOrganizationAction extends BaseAction {
	private static final Log log = LogFactory.getLog(SysOrganizationAction.class);

  	private List sysOrgList;
    
  	private ISysOrganizationService sysOrganizationService;
  	
	public String show_list()
	{
		try
		{
			sysOrgList=sysOrganizationService.findByType("SUBSIDIARY");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "success";
	}

	public void setSysOrganizationService(
			ISysOrganizationService sysOrganizationService) {
		this.sysOrganizationService = sysOrganizationService;
	}

	public List getSysOrgList() {
		return sysOrgList;
	}

	public void setSysOrgList(List sysOrgList) {
		this.sysOrgList = sysOrgList;
	}
}