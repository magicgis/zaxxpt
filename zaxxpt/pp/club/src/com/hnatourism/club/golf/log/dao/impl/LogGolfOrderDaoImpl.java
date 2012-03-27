package com.hnatourism.club.golf.log.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.golf.log.dao.ILogGolfOrderDao;
import com.hnatourism.club.golf.order.vo.GolfOrderLogVo;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫订单日志表
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LogGolfOrderDaoImpl extends AbstractIBatisDaoSupport 
		implements ILogGolfOrderDao {
	private static final Log log = LogFactory.getLog(LogGolfOrderDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(GolfOrderLogVo domain) throws DataAccessException {
		return getPersistanceManager().find("findGolfOrderLogVoByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(GolfOrderLogVo domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findGolfOrderLogVoByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public GolfOrderLogVo findById(String id) throws DataAccessException {
		return (GolfOrderLogVo) getPersistanceManager().load("findGolfOrderLogVoById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		GolfOrderLogVo domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteGolfOrderLogVo", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(GolfOrderLogVo domain) throws DataAccessException {
		GolfOrderLogVo tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateGolfOrderLogVo", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(GolfOrderLogVo domain) throws DataAccessException {
		return getPersistanceManager().insert("api_saveGlofOrder_log_vo", domain);
	}
	
}