package com.hnatourism.club.personal.member.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.personal.member.dao.IXlbBalanceDao;
import com.hnatourism.club.personal.member.domain.XlbBalance;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:金币账户信息
 * 
 * 历史版本:
 *					2010-07-16 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class XlbBalanceDaoImpl extends AbstractIBatisDaoSupport 
		implements IXlbBalanceDao {
	private static final Log log = LogFactory.getLog(XlbBalanceDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(XlbBalance domain) throws DataAccessException {
		return getPersistanceManager().find("findXlbBalanceByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(XlbBalance domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findXlbBalanceByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public XlbBalance findById(String id) throws DataAccessException {
		return (XlbBalance) getPersistanceManager().load("findXlbBalanceById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		XlbBalance domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteXlbBalance", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(XlbBalance domain) throws DataAccessException {
		XlbBalance tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateXlbBalance", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(XlbBalance domain) throws DataAccessException {
		return getPersistanceManager().insert("insertXlbBalance", domain);
	}


	/**
	 * @description 【通过用户ID查找】
	 * @param memberId
	 * @return
	 * @throws DataAccessException
	 * @createTime 2010-8-17 下午12:55:56
	 * @author lzb
	 */
	public XlbBalance findByMemberId(String memberId) throws DataAccessException{
		return (XlbBalance) getPersistanceManager().load("findXlbBalanceByMemberId", memberId);
	}
	
}