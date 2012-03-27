package com.hnatourism.club.golf.order.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.golf.order.dao.IOrderGlofDao;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.utils.StringUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫订单表
 * 
 * 历史版本: 2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderGlofDaoImpl extends AbstractIBatisDaoSupport implements
		IOrderGlofDao {
	private static final Log log = LogFactory.getLog(OrderGlofDaoImpl.class);

	// jdbc支持
	private JdbcDaoSupport jdbcDaoSupport;
	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(GolfOrderVo domain) throws DataAccessException {
		return getPersistanceManager().find("findGolfOrderVoByWhere", domain);
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(GolfOrderVo domain, PageInfo pageInfo)
			throws DataAccessException {
		return this.getPersistanceManager().find("findGolfOrderVoByWhere",
				domain, pageInfo);
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * 
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public GolfOrderVo findById(String id) throws DataAccessException {
		return (GolfOrderVo) getPersistanceManager().load("findGolfOrderVoById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * 
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		GolfOrderVo domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '" + id
					+ "' object not exist");
		}
		return getPersistanceManager().delete("deleteGolfOrderVo", id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * 
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(GolfOrderVo domain) throws DataAccessException {
		GolfOrderVo tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '" + domain.getId()
					+ "' object not exist");
		}
		return getPersistanceManager().update("updateGolfOrderVo", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(GolfOrderVo domain) throws DataAccessException {
		return getPersistanceManager().insert("insertGolfOrderVo", domain);
	}

	/**
	 * @return the jdbcDaoSupport
	 */
	public JdbcDaoSupport getJdbcDaoSupport() {
		return jdbcDaoSupport;
	}

	/**
	 * @param jdbcDaoSupport
	 *            the jdbcDaoSupport to set
	 */
	public void setJdbcDaoSupport(JdbcDaoSupport jdbcDaoSupport) {
		this.jdbcDaoSupport = jdbcDaoSupport;
	}

	/**
	 * 【根据定单ID查出分销商帐号】
	 * @param orderId
	 * @return
	 * @author luanxiaodong
	 */
	public String getSellerNoByOrderId(String orderId) {//此方法已测，没问题！！！
		StringBuffer selectBySql = new StringBuffer("");
		// 定单高尔夫表
		selectBySql.append("select ma.account from order_glof og join ");
		// 高尔夫高尔夫场地表
		selectBySql.append(" GOLF_SITE gs on og.site_id=gs.id join ");
		// 高尔夫产品表
		selectBySql.append(" GOLF_INFO gi on gs.golf_id=gi.id join ");
		//会员帐户表
		selectBySql.append(" member_account ma on gi.organization_id=ma.member_id ");
		
		selectBySql.append(" where 1=1 and ma.user_type='CORP' ");//帐户表是CORP的。
		
		// 参数集合
		List<Object> param = new ArrayList<Object>();
		
		if(null != orderId && !StringUtils.isBlank(orderId)){
			selectBySql.append("  and og.id = ? ");
			param.add(orderId);
		}
 		List searchList = jdbcDaoSupport.find(selectBySql.toString(), param
				.toArray());
 		
		Object temp = searchList.get(0);//万一没查出来可能会出空指针------------------
		Map map = (HashMap) temp;
		String sellerNo = null;
		sellerNo=String.valueOf(map.get("account"));
		if(sellerNo.equals("null")||sellerNo.equals("")||sellerNo==null)//如果取出来的是null值,否则返回取出来的值！
			sellerNo=null;
		
		return sellerNo;
	}

	/**
	 * 【根据定单ID查分公司帐号】
	 * @param orderId
	 * @return
	 * @author luanxiaodong
	 */
	public String getSubCorpNoByOrderId(String orderId) {//未测，估计没什么问题！！！
		StringBuffer selectBySql = new StringBuffer("");
		// 定单高尔夫表
		selectBySql.append(" select mat.account from order_glof og join ");
		// 会员信息表
		selectBySql.append(" MEMBER_INFO@B2C_LINK mi on og.member_code=mi.code join ");
		// 会员帐户表（1）
		selectBySql.append(" MEMBER_ACCOUNT ma on mi.id=ma.member_id join ");
		//会员帐户表（2）
		selectBySql.append(" MEMBER_ACCOUNT mat on ma.organization_id=mat.member_id ");
		
		selectBySql.append(" where 1=1  and mat.user_type = 'CORP' ");//帐户表是CORP的。
		
		// 参数集合
		List<Object> param = new ArrayList<Object>();
		
		if(null != orderId && !StringUtils.isBlank(orderId)){
			selectBySql.append("  and og.id = ? ");
			param.add(orderId);
		}
 		List searchList = jdbcDaoSupport.find(selectBySql.toString(), param
				.toArray());
 		
		Object temp = searchList.get(0);//万一没查出来可能会出空指针------------------
		Map map = (HashMap) temp;
		String subCorpNo = null;
		subCorpNo=String.valueOf(map.get("account"));
		if(subCorpNo.equals("null")||subCorpNo.equals("")||subCorpNo==null)//如果取出来的是null值,否则返回取出来的值！
			subCorpNo=null;
		
		return subCorpNo;
	}
	
	
}