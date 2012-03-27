package com.hnatourism.club.lounge.order.dao;

import java.util.List;

import com.hnatourism.club.lounge.order.domain.OrderLounge;
import com.hnatourism.club.lounge.order.vo.OrderLoungeGuestVo;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
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
public interface IOrderLoungeDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(OrderLounge domain) throws DataAccessException;

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
 	public Page findByWhere(OrderLounge domain,PageInfo pageInfo) throws DataAccessException;
 
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public OrderLounge findById(String id) throws DataAccessException;

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
	public int update(OrderLounge domain) throws DataAccessException;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(OrderLounge domain) throws DataAccessException;
	
	/**
	 * 【根据定单ID查出分销商帐号     机场休息室】
	 * @param orderId
	 * @return
	 * @author gaojie
	 */
	public String getSellerNoByOrderId(String orderId);
	
	/**
	 * 【根据定单ID查分公司帐号       机场休息室】
	 * @param orderId
	 * @return
	 * @author gaojie
	 */
	public String getSubCorpNoByOrderId(String orderId);
	
	/**
	 * 【通过机场休息室定单ID查出二个帐号  】
	 * @param orderId
	 * @return
	 * @author luanxiaodong
	 */
	public MemberAccountVo getAccountAndCardNo(String orderId);
	
	public OrderLoungeGuestVo getSignPriceOfOrderLongeGuest(String orderId);
}
