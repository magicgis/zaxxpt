package com.hnatourism.club.common.dao;


import java.util.List;

import com.hnatourism.club.common.domain.SysOrganization;
import com.hnatourism.club.common.web.vo.SysOrganizationVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:组织机构表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface ISysOrganizationDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(SysOrganization domain) throws DataAccessException;

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
 	public Page findByWhere(SysOrganization domain,PageInfo pageInfo) throws DataAccessException;
 
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public SysOrganization findById(String id) throws DataAccessException;

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException ;

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(SysOrganization domain) throws DataAccessException;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(SysOrganization domain) throws DataAccessException;
	/**
	 * 【通过组织机构名称、组织机构类型来查出组织情况】
	 * @param sysOrganizationVo
	 * @param pageInfo
	 * @return
	 * @author luanxiaodong
	 */
	public Page findOrganizationByJDBC(SysOrganizationVo sysOrganizationVo,
			PageInfo pageInfo);

	public List<SysOrganization> findOrganizations();
	
	public List findByType(String type) throws Exception;
}
