package com.hnatourism.club.golf.prod.service.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.golf.api.ApiService;
import com.hnatourism.club.golf.prod.service.IGolfPracBookService;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.club.golf.prod.vo.GolfTimeMaintainVo;
import com.hnatourism.club.golf.prod.vo.GolfTypeVo;
import com.hnatourism.club.golf.prod.vo.LoginerVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫练习场预订页面显示接口
 * 
 * 历史版本:2011-08-03 v1.0.0 (高杰) 创建:
 * 
 */
public class GolfPracBookServiceImpl implements IGolfPracBookService
{
	private ApiService apiService;
	public void setApiService(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@Override
	public Map<String, Object> findByBook(String siteid) throws Exception
	{
		LoginerVo loginer=new LoginerVo();
		loginer.setContact("13940808143");
		loginer.setEmail("sjmn@163.com");
		loginer.setName("王老吉");

		Map<String, Object> result=new HashMap<String, Object>();
		result.put("login", loginer);
		
		return result;
	}

	
	private List<GolfTimeMaintainVo> get_list_maintain()
	{
		List<GolfTimeMaintainVo> fixtimelist=new ArrayList<GolfTimeMaintainVo>();
		
		GolfTimeMaintainVo bookfix1=new GolfTimeMaintainVo();
		bookfix1.setStartTime("10:00");
		bookfix1.setEndTime("12:00");
		GolfTimeMaintainVo bookfix2=new GolfTimeMaintainVo();
		bookfix2.setStartTime("14:50");
		bookfix2.setEndTime("15:10");
		
		fixtimelist.add(bookfix1);
		fixtimelist.add(bookfix2);
		
		return fixtimelist;
	}
}
