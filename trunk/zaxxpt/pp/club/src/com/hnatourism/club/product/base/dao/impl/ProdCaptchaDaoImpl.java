package com.hnatourism.club.product.base.dao.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.product.base.dao.IProdCaptchaDao;
import com.hnatourism.club.product.base.domain.ProdCaptcha;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:消费验证码
 * 
 * 历史版本:
 *					2011-08-29 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class ProdCaptchaDaoImpl extends AbstractIBatisDaoSupport 
		implements IProdCaptchaDao {
	// log 
	private static final Log log = LogFactory.getLog(ProdCaptchaDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(ProdCaptcha domain) throws DataAccessException {
		return getPersistanceManager().find("findProdCaptchaByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(ProdCaptcha domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findProdCaptchaByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public ProdCaptcha findById(String id) throws DataAccessException {
		return (ProdCaptcha) getPersistanceManager().load("findProdCaptchaById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		ProdCaptcha domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteProdCaptcha", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(ProdCaptcha domain) throws DataAccessException {
		ProdCaptcha tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateProdCaptcha", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(ProdCaptcha domain) throws DataAccessException {
		return getPersistanceManager().insert("insertProdCaptcha", domain);
	}
	
}