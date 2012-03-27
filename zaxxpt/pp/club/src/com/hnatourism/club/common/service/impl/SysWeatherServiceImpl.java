package com.hnatourism.club.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.common.service.ISysWeatherService;
import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;
import com.hnatourism.framework.core.service.AbstractService;
import com.hnatourism.framework.utils.DateFormatUtils;
import com.hnatourism.framework.utils.ListUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:天气预报
 * wuyuhu
 * 
 */
public class SysWeatherServiceImpl extends AbstractService implements ISysWeatherService{
	// jdbc服务
	private JdbcDaoSupport jdbcDaoSupport;
	
	/**
	 * 	查询天气预报
	 */
	public String find(String cityCode){
		//当前时间
		String currentDate=DateFormatUtils.format(new Date(),"yyyy-MM-dd") ;
		//返回值
		String result=null;
		//sql
		String searchSql="select rmk from sys_weather where to_char(create_time,'yyyy-MM-dd')=? and city_code=? order by create_time desc";
		//参数
		List param=new ArrayList();
		param.add(currentDate);
		param.add(cityCode);
		//结果list
		List resultList=jdbcDaoSupport.find(searchSql, param.toArray());
		if(!ListUtils.isEmpty(resultList)){
			Map map=(Map)resultList.get(0);
			if(map.get("RMK")!=null){
				result=map.get("RMK").toString();
			}
		}
		return result;
	}
	
	public JdbcDaoSupport getJdbcDaoSupport() {
		return jdbcDaoSupport;
	}

	public void setJdbcDaoSupport(JdbcDaoSupport jdbcDaoSupport) {
		this.jdbcDaoSupport = jdbcDaoSupport;
	}
}
