package com.hnatourism.club.member.rule.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.member.rule.dao.IRuleConfigDao;
import com.hnatourism.club.member.rule.domain.RuleConfig;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:规则配置表
 * 
 * 历史版本:
 *					2011-08-23 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class RuleConfigDaoImpl extends AbstractIBatisDaoSupport 
		implements IRuleConfigDao {
	private static final Log log = LogFactory.getLog(RuleConfigDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(RuleConfig domain) throws DataAccessException {
		return getPersistanceManager().find("findRuleConfigByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(RuleConfig domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findRuleConfigByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public RuleConfig findById(String id) throws DataAccessException {
		return (RuleConfig) getPersistanceManager().load("findRuleConfigById", id);
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public RuleConfig findByCode(String code) throws DataAccessException {
		return (RuleConfig) getPersistanceManager().load("findRuleConfigByCode", code);
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public List<RuleConfig> findByCrop(String crop) throws DataAccessException {
		return (List<RuleConfig>) getPersistanceManager().find("findRuleConfigByCrop", crop);
	}
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		RuleConfig domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteRuleConfig", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(RuleConfig domain) throws DataAccessException {
		RuleConfig tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateRuleConfig", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(RuleConfig domain) throws DataAccessException {
		return getPersistanceManager().insert("insertRuleConfig", domain);
	}
	
}