package com.hnatourism.club.lounge.prod.dao;

import java.util.HashMap;
import java.util.List;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场信息表
 * 
 * 历史版本:2011-08-19 v1.1.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface IFlightAirportDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * 2011-08-15 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public Object findByCode(String code) throws DataAccessException;
}
