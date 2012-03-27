package com.hnatourism.club.lounge.prod.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.lounge.prod.dao.IFlightAirlineComDao;
import com.hnatourism.club.lounge.prod.dao.IFlightAirportDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:航空公司
 * 
 * 历史版本:2011-08-19 v1.1.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class FlightAirlineComDaoImpl extends AbstractIBatisDaoSupport 
		implements IFlightAirlineComDao {
	// log 
	private static final Log log = LogFactory.getLog(FlightAirlineComDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object findByCode(String code) throws DataAccessException {
		System.out.println(this.getPersistanceManager());
		return getPersistanceManager().find("findFlightAirlineComByCode", code);
	}
}