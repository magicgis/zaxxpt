package com.hnatourism.club.personal.member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.personal.member.dao.IMemberRoleDao;
import com.hnatourism.club.personal.member.domain.MemberRole;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员角色表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberRoleDaoImpl extends AbstractIBatisDaoSupport 
		implements IMemberRoleDao {
	// log 
	private static final Log log = LogFactory.getLog(MemberRoleDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public MemberRole findByMember(String memberId) throws DataAccessException {
		return (MemberRole)getPersistanceManager().load("findMemberRoleByWhere", memberId);
	}
	
	/**
	 * 根据member查找     
	 * @param memberRole
	 * @author 谷建亮
	 * @return
	 * @throws DataAccessException
	 */
	public MemberRole findByMember(MemberRole memberRole) throws DataAccessException {
		return (MemberRole)getPersistanceManager().load("findMemberRoleByWhere", memberRole);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(MemberRole domain) throws DataAccessException {
		return getPersistanceManager().find("findMemberRoleByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(MemberRole domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findMemberRoleByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberRole findById(String id) throws DataAccessException {
		return (MemberRole) getPersistanceManager().load("findMemberRoleById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		MemberRole domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteMemberRole", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(MemberRole domain) throws DataAccessException {
		MemberRole tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateMemberRole", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(MemberRole domain) throws DataAccessException {
		return getPersistanceManager().insert("insertMemberRole", domain);
	}
	
}