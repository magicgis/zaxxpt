package com.hnatourism.club.base.service.impl;

import java.util.List;

import com.hnatourism.club.base.dao.ISysRoleDao;
import com.hnatourism.club.base.dao.ISysRoleUserDao;
import com.hnatourism.club.base.domain.SysRole;
import com.hnatourism.club.base.domain.SysRoleUser;
import com.hnatourism.club.base.service.ISysRoleUserService;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.service.AbstractService;
import com.hnatourism.framework.utils.SequenceHelper;
@SuppressWarnings("unchecked")
public class SysRoleUserServiceImpl extends AbstractService implements ISysRoleUserService {
	private ISysRoleUserDao sysRoleUserDao;	
	
	private ISysRoleDao sysRoleDao;	
	
	public ISysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}

	public void setSysRoleDao(ISysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	public ISysRoleUserDao getSysRoleUserDao() {
		return sysRoleUserDao;
	}

	public void setSysRoleUserDao(ISysRoleUserDao sysRoleUserDao) {
		this.sysRoleUserDao = sysRoleUserDao;
	}

	/**
	 * 根据条件查询用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(SysRoleUser domain) throws BusinessException {
		return sysRoleUserDao.findByWhere(domain);
	}

	/**
	 * 删除用户权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(String id) throws BusinessException {
		sysRoleUserDao.delete(id);
	}

	/**
	 * 根据ID查询用户权限记录
	 * @param id
	 * @throws BusinessException
	 */
	public SysRoleUser findById(String id) throws BusinessException {
		return sysRoleUserDao.findById(id);
	}

	/**
	 * 新增用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(SysRoleUser domain) throws BusinessException {
		return sysRoleUserDao.insert(domain);
	}

	/**
	 * 修改用户权限记录
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public void update(SysRoleUser domain) throws BusinessException {
		sysRoleUserDao.update(domain);
	}

	public List findRoleName(SysRoleUser domain) throws BusinessException{
		return sysRoleUserDao.findRoleName(domain);
	}
	
	public List<SysRoleUser> findByUserId(String sysUserId) throws BusinessException{
		List<SysRoleUser> list = null;
		if(sysUserId != null && !"".equals(sysUserId)){
			list = sysRoleUserDao.findByUserId(sysUserId);
		}
		return list;
	}
	
	public void delByRoleId(String sysRoleId) throws BusinessException{
		List<SysRoleUser> list = null;
		if(sysRoleId != null && !"".equals(sysRoleId)){
			sysRoleUserDao.delByRoleId(sysRoleId);
		}
	}
	//根据userid取得角色code
	public String getRolecodeByUserId(String userId) throws BusinessException{
		String rolecode = "";
		List<SysRoleUser> list = sysRoleUserDao.findByUserId(userId);
		if(list != null && list.size()>0){
			SysRoleUser sysRoleUser = new SysRoleUser();
			sysRoleUser = list.get(0);
			SysRole sysRole = new SysRole();
			sysRole = sysRoleDao.findById(sysRoleUser.getSysRoleId());
			rolecode = sysRole.getCode();
		}
		return rolecode;
	}
	
	
	public void saveSystemRoleUser(String sysUserId,String roles) throws BusinessException{		
		if(roles != null && roles.trim().length() > 0){
			roles = roles.trim().substring(0,roles.trim().length() - 1);
		}
		String[] ids = roles.split( "," );
		if(ids != null && ids.length > 0){
			//删除所有此用户在中间表中的数据SYSTEM_ROLE_USER
			sysRoleUserDao.deleteBySystemUserId(sysUserId);
			if(roles != null && roles.trim().length() > 0){
				List<SysRole> list=sysRoleDao.retriveRoleByRoleIds(roles);
				SysRoleUser sysroleuser = null;
				for(SysRole role : list){
					sysroleuser = new SysRoleUser();
					sysroleuser.setSysUserId(sysUserId);
					sysroleuser.setSysRoleId(role.getId());
					sysroleuser.setId(SequenceHelper.next());
					sysRoleUserDao.insert(sysroleuser);
				}
			}
		}		
	}
}