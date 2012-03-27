package com.hnatourism.club.golf.prod.service;


import java.util.Map;

import com.hnatourism.framework.BusinessException;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.web.vo.AbstractVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫首页查询业务
 * 
 * 历史版本:2011-08-2 v1.0.0 (栾晓东) 创建:
 * 
 */
@SuppressWarnings("rawtypes")
public interface IGolfHomeSearchService
{
	/**
	 * 高尔夫前台查寻页面。通过省份、下场时期、球场类型、球场名称。
	 * @param vo
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	public Page findByWhere(AbstractVo vo,PageInfo pageInfo) throws BusinessException;
}
