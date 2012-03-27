/**
 * 项目名称:酒店预订系统
 * 
 * 功能描述:系统常量管理
 * 
 * 历史版本:
 *	2010-03-24 v1.0.0 (liulibo) 创建:
 * 
 */
package com.hnatourism.club.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.BusinessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.ConnectionManager;
import com.hnatourism.framework.core.daosupport.jdbc.support.JdbcDAOSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.club.common.dao.ISysConstantDao;
import com.hnatourism.club.common.domain.SysConstant;

@SuppressWarnings("unchecked")
public class SysConstantDaoImpl extends AbstractIBatisDaoSupport implements
		ISysConstantDao {

	private JdbcDAOSupport jdbcDAOSupport;

	/**
	 * 根据条件查询系统常量记录
	 * 
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysConstant domain) throws BusinessException {
		List list = new ArrayList();
		PageInfo pageInfo = (PageInfo) ContextHolder.getContext().getAttribute(
				PageInfo.PAGEINFO);
		if (pageInfo == null) {
			list = getPersistanceManager().find("findSysConstantByWhere",
					domain);
		} else {
			Page page = this.getPersistanceManager().find(
					"findSysConstantByWhere", domain, pageInfo);
			ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO,
					page.getPageInfo());
			list = page.getData();
		}
		return list;
	}

	/**
	 * 根据ID查询系统常量记录
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysConstant findById(String id) throws BusinessException {
		return (SysConstant) getPersistanceManager().load(
				"findSysConstantById", id);
	}

	/**
	 * 根据Code查询系统常量记录
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysConstant findByCode(String code) {
		SysConstant domain = null;
		try {
			ConnectionManager.getConnection();
			String sql = "select * from sys_constant t where t.code = ?";
			List<String> values = new ArrayList<String>();
			values.add(code);
			domain = (SysConstant) this.jdbcDAOSupport.findObj(sql, values,
					SysConstant.class);

		} catch (Exception e) {
			throw new DataAccessException("SysConstantDaoImpl.findByCode", e);

		} finally {
			ConnectionManager.freeConnection();
		}
		return domain;
	}

	/**
	 * 删除系统常量记录
	 * 
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException {
		SysConstant domain = findById(id);
		if (domain == null) {
			throw new BusinessException("", "ID = '" + id
					+ "' object not exist");
		}
		getPersistanceManager().delete("deleteSysConstant", id);
	}

	/**
	 * 修改系统常量记录
	 * 
	 * @param domain
	 * @throws BusinessException
	 */
	public void update(SysConstant domain) throws BusinessException {
		SysConstant tmp = findById(domain.getId());
		if (tmp == null) {
			throw new BusinessException("", "ID = '" + domain.getId()
					+ "' object not exist");
		}
		getPersistanceManager().update("updateSysConstant", domain);
	}

	/**
	 * 新增系统常量记录
	 * 
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysConstant domain) throws BusinessException {
		return getPersistanceManager().insert("insertSysConstant", domain);
	}

	public List findByType(String type) {
		return getPersistanceManager().find("findByType", type);
	}

	public void setJdbcDAOSupport(JdbcDAOSupport jdbcDAOSupport) {
		this.jdbcDAOSupport = jdbcDAOSupport;
	}
}