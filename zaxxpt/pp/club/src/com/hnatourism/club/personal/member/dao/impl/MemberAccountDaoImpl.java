package com.hnatourism.club.personal.member.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.utils.StringUtils;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员账户表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberAccountDaoImpl extends AbstractIBatisDaoSupport 
		implements IMemberAccountDao {
	// log 
	private static final Log log = LogFactory.getLog(MemberAccountDaoImpl.class);
	
	private JdbcDaoSupport jdbcDaoSupport;
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(MemberAccount domain) throws DataAccessException {
		return getPersistanceManager().find("findMemberAccountByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(MemberAccount domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findMemberAccountByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberAccount findById(String id) throws DataAccessException {
		return (MemberAccount) getPersistanceManager().load("findMemberAccountById", id);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberAccount findByCardNo(String cardNo) throws DataAccessException {
		return (MemberAccount) getPersistanceManager().load("findMemberAccountById", cardNo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public MemberAccount findByMember(String memberId) throws DataAccessException {
		return (MemberAccount) getPersistanceManager().load("findMemberAccountByMember", memberId);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		MemberAccount domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteMemberAccount", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(MemberAccount domain) throws DataAccessException {
		MemberAccount tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateMemberAccount", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(MemberAccount domain) throws DataAccessException {
		return getPersistanceManager().insert("insertMemberAccount", domain);
	}
	
	/**
	 * 根据会员ID查询分公司账号
	 * @author Zhangxiaochun
	 */
	public String getSubCorpNoByOrderId(String memberId) throws DataAccessException{
		StringBuffer selectBySql = new StringBuffer("");
		selectBySql.append(" select ac.account ");
		selectBySql.append(" from member_account a left join member_account ac on a.organization_id = ac.member_id  ");
		// 参数集合
		List<Object> param = new ArrayList<Object>();
		if(null != memberId && !StringUtils.isBlank(memberId)){
			selectBySql.append(" where a.member_id=? "); 
			param.add(memberId);
		}
 		List searchList = jdbcDaoSupport.find(selectBySql.toString(), param.toArray());
 		
		Object temp = searchList.get(0);//万一没查出来可能会出空指针------------------
		Map map = (HashMap) temp;
		String sellerNo = null;
		sellerNo=String.valueOf(map.get("account"));
		if(sellerNo.equals("null")||sellerNo.equals("")||sellerNo==null)//如果取出来的是null值,否则返回取出来的值！
			sellerNo=null;
		return sellerNo;
	}
	
	public JdbcDaoSupport getJdbcDaoSupport() {
		return jdbcDaoSupport;
	}
	public void setJdbcDaoSupport(JdbcDaoSupport jdbcDaoSupport) {
		this.jdbcDaoSupport = jdbcDaoSupport;
	}
	
}