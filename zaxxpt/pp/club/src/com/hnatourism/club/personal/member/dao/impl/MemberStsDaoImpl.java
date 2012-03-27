package com.hnatourism.club.personal.member.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.personal.member.dao.IMemberStsDao;
import com.hnatourism.club.personal.member.domain.MemberSts;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员状态表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberStsDaoImpl extends AbstractIBatisDaoSupport 
		implements IMemberStsDao {
	// log 
	private static final Log log = LogFactory.getLog(MemberStsDaoImpl.class);

	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberSts findByMember(String memberId) throws DataAccessException {
		return (MemberSts) getPersistanceManager().load("findMemberStsByMember", memberId);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(MemberSts domain) throws DataAccessException {
		return getPersistanceManager().find("findMemberStsByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(MemberSts domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findMemberStsByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberSts findById(String id) throws DataAccessException {
		return (MemberSts) getPersistanceManager().load("findMemberStsById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		MemberSts domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteMemberSts", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(MemberSts domain) throws DataAccessException {
		MemberSts tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateMemberSts", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(MemberSts domain) throws DataAccessException {
		return getPersistanceManager().insert("insertMemberSts", domain);
	}
	
}