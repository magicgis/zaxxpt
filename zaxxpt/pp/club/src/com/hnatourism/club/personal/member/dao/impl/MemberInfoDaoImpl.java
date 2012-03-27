package com.hnatourism.club.personal.member.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.personal.member.dao.IMemberInfoDao;
import com.hnatourism.club.personal.member.domain.MemberInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员信息
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberInfoDaoImpl extends AbstractIBatisDaoSupport 
		implements IMemberInfoDao {
	// log 
	private static final Log log = LogFactory.getLog(MemberInfoDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(MemberInfo domain) throws DataAccessException {
		return getPersistanceManager().find("findMemberInfoByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(MemberInfo domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findMemberInfoByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberInfo findById(String id) throws DataAccessException {
		return (MemberInfo) getPersistanceManager().load("findMemberInfoById", id);
	}
	/**
	 * 【根据CODE查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberInfo findByCode(String code) throws DataAccessException {
		return (MemberInfo) getPersistanceManager().load("findMemberInfoByCode", code);
	}
	/**
	 * 【根据CODE查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberInfo findByCodePw(HashMap<String, String> hm) throws DataAccessException {
		return (MemberInfo) getPersistanceManager().load("findMemberInfoByCodePw", hm);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		MemberInfo domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteMemberInfo", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(MemberInfo domain) throws DataAccessException {
		MemberInfo tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateMemberInfo", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(MemberInfo domain) throws DataAccessException {
		return getPersistanceManager().insert("insertMemberInfo", domain);
	}
	
}