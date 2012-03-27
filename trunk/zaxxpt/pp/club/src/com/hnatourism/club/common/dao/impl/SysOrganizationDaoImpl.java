package com.hnatourism.club.common.dao.impl;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.dao.ISysOrganizationDao;
import com.hnatourism.club.common.domain.SysOrganization;
import com.hnatourism.club.common.web.vo.SysOrganizationVo;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.utils.StringUtils;
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
public class SysOrganizationDaoImpl extends AbstractIBatisDaoSupport 
		implements ISysOrganizationDao {
	// log 
	private static final Log log = LogFactory.getLog(SysOrganizationDaoImpl.class);
	private JdbcDaoSupport jdbcDaoSupport;//Strin
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(SysOrganization domain) throws DataAccessException {
		return getPersistanceManager().find("findSysOrganizationByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(SysOrganization domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findSysOrganizationByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public SysOrganization findById(String id) throws DataAccessException {
		return (SysOrganization) getPersistanceManager().load("findSysOrganizationById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		SysOrganization domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteSysOrganization", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(SysOrganization domain) throws DataAccessException {
		SysOrganization tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateSysOrganization", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(SysOrganization domain) throws DataAccessException {
		return getPersistanceManager().insert("insertSysOrganization", domain);
	}
	/**
	 * 【通过组织机构名称、组织机构类型来查出组织情况】
	 * @param sysOrganizationVo
	 * @param pageInfo
	 * @return
	 * @author luanxiaodong
	 */
	public Page findOrganizationByJDBC(SysOrganizationVo domain,
			PageInfo pageInfo) {
		StringBuffer selectBySql = new StringBuffer("select so.id,so.name,so.l_name,l.name as superiorname,so.prod_type,so.type,so.sts,su.code as username  from sys_organization so ");
		selectBySql.append(" left join ");//有时候数据添的不完整，所以才加的左联
		selectBySql.append(" ( select sot.name,sor.organization_id  from sys_organization sot ");
		selectBySql.append("  join ");
		selectBySql.append("  sys_organization_relation sor on sot.id=sor.p_organization_id ");
		selectBySql.append("  group by sot.name,sor.organization_id ");
		selectBySql.append("  ) l on so.id=l.organization_id ");
		selectBySql.append("  left join ");//有时候数据添的不完整，所以才加的左联
		selectBySql.append("  sys_organization_user sou on so.id=sou.organization_id left join  ");//有时候数据添的不完整，所以才加的左联
		selectBySql.append("  sys_user su on sou.user_id=su.id where 1=1  ");
		
		// 参数集合
		List<Object> param = new ArrayList<Object>();
		if(null != domain.getLName() && !StringUtils.isBlank(domain.getLName())){
			selectBySql.append(" and so.l_name like '%"+domain.getLName().trim()+"%' ");
		}
		if(null != domain.getType()&&!StringUtils.isBlank(domain.getType())){
			selectBySql.append(" and  so.type=? ");
			param.add(domain.getType().trim());
		}
		if(null != domain.getProdType()&&!StringUtils.isBlank(domain.getProdType())){
			selectBySql.append(" and  so.prod_type=? ");
			param.add(domain.getProdType().trim());
		}
		if(null != domain.getSts() && !StringUtils.isBlank(domain.getSts())){
			selectBySql.append(" and  so.sts=? ");
			param.add(domain.getSts());
		}
		selectBySql.append(" order by so.l_name, so.type ");
		Page page2=new Page();
		List searchlist = null;
		if (pageInfo == null) {
			searchlist =jdbcDaoSupport.find(selectBySql.toString(), param.toArray());
		} else {
			Page page= jdbcDaoSupport.find(selectBySql.toString(), param.toArray(), pageInfo);
			page2.setPageInfo(page.getPageInfo());
			if (page != null && page.getData() != null) {
				searchlist = page.getData();
			}
		}
		
		SysOrganizationVo vo = new SysOrganizationVo();
		List<SysOrganizationVo> list = new ArrayList<SysOrganizationVo>();

		for (Object temp : searchlist) {
			Map map = (HashMap) temp;
			try {
				vo = mapData2infoVo(map);
				//TODO 异常该如何处理?
			} catch (ParseException e) {
				e.printStackTrace();
			}
			list.add(vo);
		}
		page2.setData(list);
		return page2;
	}
	/**
	 * 【取得组织列表，不包括已经创建产品的组织】
	 * @param sysOrganizationVo
	 * @param pageInfo
	 * @return
	 * @author luanxiaodong
	 */
	public List<SysOrganization> findOrganizations() {
		StringBuffer selectBySql = new StringBuffer("");
		selectBySql.append(" select * from sys_organization  ");
		selectBySql.append(" where sts = '1' and (prod_type='2' or prod_type='3') ");
		selectBySql.append(" and id not in ( ");
		selectBySql.append(" select distinct(organization_id) from golf_info t) ");
		
		List searchlist = new ArrayList();
		searchlist =jdbcDaoSupport.find(selectBySql.toString());
		
		SysOrganization domain = new SysOrganization();
		List<SysOrganization> list = new ArrayList<SysOrganization>();

		for (Object temp : searchlist) {
			Map map = (HashMap) temp;
			domain = new SysOrganization();
			try {
				domain.setId(String.valueOf(map.get("id")));
				domain.setProdType(String.valueOf(map.get("prod_type")));
				domain.setLName(String.valueOf(map.get("l_name")));
				//TODO 异常该如何处理?
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(domain);
		}

		return list;
	}
	private SysOrganizationVo mapData2infoVo(Map map)throws ParseException {
		SysOrganizationVo vo = new SysOrganizationVo();
		//组织机构ID
		vo.setId(String.valueOf(map.get("id")));
		
		//组织机构的名字（长名）
			String name = String.valueOf(map.get("l_name"));
			if(null == name||StringUtils.isBlank(name)||name.equals("null")){
				name=null;
			}
		vo.setLName(name);
		
		//组织机构的上级机构名字
			String superiorname = String.valueOf(map.get("superiorname"));
			if(null == superiorname||StringUtils.isBlank(superiorname)||superiorname.equals("null")){
				superiorname=null;
			}
		vo.setSuperiorName(superiorname);
		
		//单位名称
		String protype=String.valueOf(map.get("prod_type"));
		if(null == protype||StringUtils.isBlank(protype)||protype.equals("null")){
			protype=null;
		}
		vo.setProdType(protype);
		
		//组织机构类型
		String orgtype = String.valueOf(String.valueOf(map.get("type")));
		if(null == orgtype||StringUtils.isBlank(orgtype)||orgtype.equals("null")){
			orgtype=null;
		}
		vo.setType(orgtype);
		
		//组织机构状态
		String orgSts = String.valueOf(String.valueOf(map.get("sts")));
		if(null == orgSts||StringUtils.isBlank(orgSts)||orgSts.equals("null")){
			orgSts=null;
		}
		vo.setSts(orgSts);
		
		//管理这个组织机构的系统用户名
			String username = String.valueOf(map.get("username"));
			if(null == username||StringUtils.isBlank(username)||username.equals("null")){
				username=null;
			}
		vo.setUserName(username);
		return vo;
	}
	
	
	//getter ...  setter ...  
	public JdbcDaoSupport getJdbcDaoSupport() {
		return jdbcDaoSupport;
	}
	public void setJdbcDaoSupport(JdbcDaoSupport jdbcDaoSupport) {
		this.jdbcDaoSupport = jdbcDaoSupport;
	}
	@Override
	public List findByType(String type) throws Exception {
		// TODO Auto-generated method stub
		return getPersistanceManager().find("findSysOrganizationByType", type);
	}
	
	
	
}