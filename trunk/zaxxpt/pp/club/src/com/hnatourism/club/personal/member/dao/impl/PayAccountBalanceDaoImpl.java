package com.hnatourism.club.personal.member.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.personal.member.dao.IPayAccountBalanceDao;
import com.hnatourism.club.personal.member.domain.PayAccountBalance;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:资金账户信息
 * 
 * 历史版本:
 *					2010-07-13 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class PayAccountBalanceDaoImpl extends AbstractIBatisDaoSupport 
		implements IPayAccountBalanceDao {
	private static final Log log = LogFactory.getLog(PayAccountBalanceDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(PayAccountBalance domain) throws DataAccessException {
		return getPersistanceManager().find("findPayAccountBalanceByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(PayAccountBalance domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findPayAccountBalanceByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public PayAccountBalance findById(String id) throws DataAccessException {
		return (PayAccountBalance) getPersistanceManager().load("findPayAccountBalanceById", id);
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public PayAccountBalance findByMemberId(String memberId) throws DataAccessException {
		return (PayAccountBalance) getPersistanceManager().load("findPayAccountBalanceByMemberId", memberId);
	}
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		PayAccountBalance domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deletePayAccountBalance", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(PayAccountBalance domain) throws DataAccessException {
		PayAccountBalance tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updatePayAccountBalance", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(PayAccountBalance domain) throws DataAccessException {
		return getPersistanceManager().insert("insertPayAccountBalance", domain);
	}
	/**
	 *  【根据用户id获取网站账户信息】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public PayAccountBalance findByMId(String memberId) throws DataAccessException{
		PayAccountBalance payAccountBalance =new PayAccountBalance();
		payAccountBalance.setMemberId(memberId);
		List list = findByWhere(payAccountBalance);
		if(list!=null && list.size()>0){
			payAccountBalance = (PayAccountBalance)list.get(0);
			return payAccountBalance;
		}
		return null;
	}
	
}