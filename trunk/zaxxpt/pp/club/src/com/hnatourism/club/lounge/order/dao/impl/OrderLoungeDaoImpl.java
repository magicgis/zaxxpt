package com.hnatourism.club.lounge.order.dao.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeDao;
import com.hnatourism.club.lounge.order.domain.OrderLounge;
import com.hnatourism.club.lounge.order.vo.OrderLoungeGuestVo;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室订单表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderLoungeDaoImpl extends AbstractIBatisDaoSupport 
		implements IOrderLoungeDao {
	// log 
	private static final Log log = LogFactory.getLog(OrderLoungeDaoImpl.class);
	
	/**
	 * jdbc支持
	 */
	private JdbcDaoSupport jdbcDaoSupport;
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(OrderLounge domain) throws DataAccessException {
		return getPersistanceManager().find("findOrderLoungeByWhere", domain);
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(OrderLounge domain,PageInfo pageInfo) throws DataAccessException {
			return this.getPersistanceManager().find("findOrderLoungeByWhere", domain, pageInfo);
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public OrderLounge findById(String id) throws DataAccessException {
		return (OrderLounge) getPersistanceManager().load("findOrderLoungeById", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		OrderLounge domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '"+id+ "' object not exist");
		}	
		return getPersistanceManager().delete("deleteOrderLounge", id);
	}

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(OrderLounge domain) throws DataAccessException {
		OrderLounge tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '"+domain.getId()+ "' object not exist");
		}
		return getPersistanceManager().update("updateOrderLounge", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(OrderLounge domain) throws DataAccessException {
		return getPersistanceManager().insert("saveOrderLounge", domain);
	}
	
	/**
	 * 【根据定单ID查出分销商帐号     机场休息室】
	 * @param orderId
	 * @return
	 * @author gaojie
	 */
	public String getSellerNoByOrderId(String orderId) {
		StringBuffer selectBySql = new StringBuffer("");
		// 机场休息室定单表
		selectBySql.append("select ma.account from order_lounge ol join ");
		// 休息室房间表
		selectBySql.append(" LOUNGE_ROOM lr on ol.room_id=lr.id join  ");
		// 机场休息室产品表
		selectBySql.append(" LOUNGE_INFO li on lr.lounge_id=li.id join  ");
		//会员帐户表
		selectBySql.append(" MEMBER_ACCOUNT ma on li.organization_id=ma.member_id ");
		
		selectBySql.append(" where 1=1 and ma.user_type='CORP' ");//帐户表是CORP的。
		
		// 参数集合
		List<Object> param = new ArrayList<Object>();
		
		if(null != orderId && !StringUtils.isBlank(orderId)){
			selectBySql.append("  and ol.id = ? ");
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
	 * 【根据定单ID查分公司帐号       机场休息室】
	 * @param orderId
	 * @return
	 * @author gaojie
	 */
	public String getSubCorpNoByOrderId(String orderId) {
		StringBuffer selectBySql = new StringBuffer("");
		// 机场休息室表
		selectBySql.append("select mat.account from order_lounge ol join  ");
		// 会员信息表
		selectBySql.append("MEMBER_INFO@B2C_LINK mi on ol.member_id=mi.id join  ");
		// 会员帐户表（1）
		selectBySql.append("MEMBER_ACCOUNT ma on mi.id=ma.member_id join ");
		//会员帐户表（2）
		selectBySql.append("MEMBER_ACCOUNT mat on ma.organization_id=mat.member_id ");
		
		selectBySql.append("where 1=1 and mat.user_type='CORP' ");//帐户表是CORP的。
		
		// 参数集合
		List<Object> param = new ArrayList<Object>();
		
		if(null != orderId && !StringUtils.isBlank(orderId)){
			selectBySql.append(" and ol.id = ? ");
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
	
	/**
	 * 【通过机场休息室定单ID查出二个帐号  】
	 * @param orderId
	 * @return
	 * @author gaojie
	 */
	public MemberAccountVo getAccountAndCardNo(String orderId) {
		//会员帐户表
		StringBuffer sql =new StringBuffer("select ma.account,ma.card_no from member_account ma join  ");
		//机场休息室定单表
		sql.append("order_lounge ol on ma.member_id=ol.member_id  ");	
		sql.append("where 1=1 ");
		
		//参数集合
		List<Object> param =new ArrayList<Object>();
		
		// 条件..订单号
		if (StringUtils.isNotBlank(orderId)) {
			sql.append("  and ol.id = ? ");
			param.add(orderId);
		}
		//查询结果集合
		List serachList =new ArrayList(); //查询语句和参数数组
		serachList=jdbcDaoSupport.find(sql.toString(),param.toArray());
		
		//会员帐号Vo
		MemberAccountVo vo = new MemberAccountVo();
		Object temp = serachList.get(0);//万一没查出来可能会出空指针------------------
			Map map=(HashMap) temp;
			try {
				vo = map2memberAccountVo(map);
				// 异常该如何处理?
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		return vo;
	}
	
	
	/**
	 * gaojie
	 */
	@Override
	public OrderLoungeGuestVo getSignPriceOfOrderLongeGuest(String orderId) {
		//定单休息室顾客表
		StringBuffer sql =new StringBuffer("select sum(t.additional_sign_price) as signprice from order_lounge_guest t where 1=1 ");
		
		//参数集合
		List<Object> param =new ArrayList<Object>();
		
		// 条件..订单号
		if (StringUtils.isNotBlank(orderId)) {
			sql.append(" and t.order_id=? ");
			param.add(orderId);
		}
		//查询结果集合
		List serachList =new ArrayList(); //查询语句和参数数组
		serachList=jdbcDaoSupport.find(sql.toString(),param.toArray());
		
		//会员帐号Vo
		OrderLoungeGuestVo vo = new OrderLoungeGuestVo();
		Object temp = serachList.get(0);//万一没查出来可能会出空指针------------------
			Map map=(HashMap) temp;
			try {
				vo = map2OrderLoungeGuestVo(map);
				// 异常该如何处理?
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		return vo;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws ParseException
	 * @author gaojie
	 */
	private MemberAccountVo map2memberAccountVo(Map map)throws ParseException {
		MemberAccountVo vo = new MemberAccountVo();
		
		//订单ID
		String account = String.valueOf(map.get("account"));
			if(account==null||account.equals("")||account.equals("null"))
				account=null;
		vo.setAccount(account);//帐户
		String card_no = String.valueOf(map.get("card_no"));
		if(card_no==null||card_no.equals("")||card_no.equals("null"))
			card_no=null;
		vo.setCardNo(card_no);//卡号
		return vo;
	}
	
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws ParseException
	 * @author gaojie
	 */
	private OrderLoungeGuestVo map2OrderLoungeGuestVo(Map map)throws ParseException {
		OrderLoungeGuestVo vo = new OrderLoungeGuestVo();
		
		//订单ID
		String signprice = String.valueOf(map.get("signprice"));
			if(signprice==null||signprice.equals("")||signprice.equals("null"))
				signprice="0";
			
		vo.setAdditionalSignPrice(Double.parseDouble(signprice));//帐户
		return vo;
	}
	

	/**
	 * @return the jdbcDaoSupport
	 */
	public JdbcDaoSupport getJdbcDaoSupport() {
		return jdbcDaoSupport;
	}
	/**
	 * @param jdbcDaoSupport the jdbcDaoSupport to set
	 */
	public void setJdbcDaoSupport(JdbcDaoSupport jdbcDaoSupport) {
		this.jdbcDaoSupport = jdbcDaoSupport;
	}
}