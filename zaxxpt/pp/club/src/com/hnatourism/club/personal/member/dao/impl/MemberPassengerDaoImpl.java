package com.hnatourism.club.personal.member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.club.personal.member.dao.IMemberPassengerDao;
import com.hnatourism.club.personal.member.domain.MemberPassenger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员常用旅客信息
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberPassengerDaoImpl extends AbstractIBatisDaoSupport 
		implements IMemberPassengerDao {
	// log 
	private static final Log log = LogFactory.getLog(MemberPassengerDaoImpl.class);
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(MemberPassenger domain) throws DataAccessException {
		return getPersistanceManager().find("findMemberPassengerByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(MemberPassenger domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findMemberPassengerByWhere", domain, pageInfo);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByMember(String memberId) throws DataAccessException {
		return getPersistanceManager().find("findMemberPassengerByMember", memberId);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberPassenger findById(String id) throws DataAccessException {
		return (MemberPassenger) getPersistanceManager().load("findMemberPassengerById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		MemberPassenger domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteMemberPassenger", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(MemberPassenger domain) throws DataAccessException {
		MemberPassenger tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateMemberPassenger", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(MemberPassenger domain) throws DataAccessException {
		return getPersistanceManager().insert("insertMemberPassenger", domain);
	}
	
}