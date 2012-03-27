package com.hnatourism.club.member.log.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.member.log.dao.ILogOperateDao;
import com.hnatourism.club.member.log.domain.LogOperate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员操作日志表
 * 
 * 历史版本:
 *					2011-10-17 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LogOperateDaoImpl extends AbstractIBatisDaoSupport 
		implements ILogOperateDao {
	private static final Log log = LogFactory.getLog(LogOperateDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(LogOperate domain) throws DataAccessException {
		return getPersistanceManager().find("findLogOperateByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(LogOperate domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findLogOperateByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public LogOperate findById(String id) throws DataAccessException {
		return (LogOperate) getPersistanceManager().load("findLogOperateById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		LogOperate domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteLogOperate", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(LogOperate domain) throws DataAccessException {
		LogOperate tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateLogOperate", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(LogOperate domain) throws DataAccessException {
		return getPersistanceManager().insert("insertLogOperate", domain);
	}
	
}