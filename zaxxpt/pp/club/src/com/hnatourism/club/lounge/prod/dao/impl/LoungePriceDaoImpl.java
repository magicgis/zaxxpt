package com.hnatourism.club.lounge.prod.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.lounge.prod.dao.ILoungePriceDao;
import com.hnatourism.club.lounge.prod.domain.LoungePrice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室项目价格表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LoungePriceDaoImpl extends AbstractIBatisDaoSupport 
		implements ILoungePriceDao {
	// log 
	private static final Log log = LogFactory.getLog(LoungePriceDaoImpl.class);

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * 2011-08-15 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findByRoom(LoungePrice domain) throws DataAccessException {
		return getPersistanceManager().find("findLoungePriceByRoom", domain);
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * 2011-08-15 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findByRoomTypeN(LoungePrice domain) throws DataAccessException {
		return getPersistanceManager().find("findLoungePriceByRoomTypeN", domain);
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * 2011-08-15 v1.1.0 (高杰) 创建:
	 * @throws DataAccessException
	 */
	public List findByRoomTypeS(LoungePrice domain) throws DataAccessException {
		return getPersistanceManager().find("findLoungePriceByRoomTypeS", domain);
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByRoomMin(LoungePrice domain) throws DataAccessException {
		return getPersistanceManager().find("findLoungePriceByRoomMin", domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(LoungePrice domain) throws DataAccessException {
		return getPersistanceManager().find("findLoungePriceByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(LoungePrice domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findLoungePriceByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public LoungePrice findById(String id) throws DataAccessException {
		return (LoungePrice) getPersistanceManager().load("findLoungePriceById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		LoungePrice domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteLoungePrice", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(LoungePrice domain) throws DataAccessException {
		LoungePrice tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateLoungePrice", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(LoungePrice domain) throws DataAccessException {
		return getPersistanceManager().insert("insertLoungePrice", domain);
	}
	
}