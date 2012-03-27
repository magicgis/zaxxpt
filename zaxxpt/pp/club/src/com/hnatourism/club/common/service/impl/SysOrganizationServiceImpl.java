package com.hnatourism.club.common.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.club.common.dao.ISysOrganizationDao;
import com.hnatourism.club.common.service.ISysOrganizationService;
import com.hnatourism.club.common.web.vo.SysOrganizationVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:组织机构表
 * 
 * 历史版本:2011-09-28 v1.1.0 (gaojie) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class SysOrganizationServiceImpl implements ISysOrganizationService {
	// log 
	private static final Log log = LogFactory.getLog(SysOrganizationServiceImpl.class);
	
	private ISysOrganizationDao sysOrganizationDao;
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByType(String type) throws Exception {
		return sysOrganizationDao.findByType(type);
	}

	public void setSysOrganizationDao(ISysOrganizationDao sysOrganizationDao) {
		this.sysOrganizationDao = sysOrganizationDao;
	}
}