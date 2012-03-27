package com.hnatourism.club.pay.order.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.pay.order.dao.IOrderBillDao;
import com.hnatourism.club.pay.order.domain.OrderBill;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.framework.utils.StringUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:账单表
 * 
 * 历史版本: 2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderBillDaoImpl extends AbstractIBatisDaoSupport implements
		IOrderBillDao {
	private static final Log log = LogFactory.getLog(OrderBillDaoImpl.class);

	private JdbcDaoSupport jdbcDaoSupport;

	/**
	 * 【根据条件查询】 @author 苏忆
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findBillByWhere(OrderBill domain, PageInfo pageInfo) {
		StringBuffer selectBySql = new StringBuffer(
				" select a.id as accountid,a.role_id as roleid,a.type,b.name as rolename, "
						+ " a.account,a.trade_no,a.trade_time,a.amount,a.update_time as updatetime "
						+ " ,a.update_user as updateuser,a.create_time createtime,a.create_user createuser,"
						+ " a.order_type as ordertype,a.prod_type productname,a.order_code as ordercode,a.transaction_type,a.commission,a.status "
						+ " ,a.PROD_TYPE as producttype from order_bill a  left join   sys_role b on a.ROLE_ID=b.id where 1=1 ");

		// 交易号
		if (StringUtils.isNotBlank(domain.getTradeNo())) {
			selectBySql.append(" and  a.trade_no like '%"
					+ domain.getTradeNo().trim() + "%'");
		}
		// 日期比较
		if (domain.getStartDate() != null && domain.getEndDate() != null) {
			if (domain.getStartDate().equals(domain.getEndDate())) {
				selectBySql.append(" and  a.trade_time like to_date ('"
						+ domain.getStartDate().toLocaleString().substring(0, 9)
						+ "','yyyy-mm-dd') ");
			} else {
				selectBySql.append(" and  a.trade_time between to_date('"
						+ domain.getStartDate().toLocaleString()
								.substring(0, 9)
						+ "','yyyy-mm-dd') and to_date('"
						+ domain.getEndDate().toLocaleString().substring(0, 9)
						+ "','yyyy-mm-dd') ");
			}
		} else if (domain.getStartDate() != null && domain.getEndDate() == null) {
			selectBySql.append(" and  a.trade_time >= to_date('"
					+ domain.getStartDate().toLocaleString().substring(0, 9)
					+ "','yyyy-mm-dd')   ");
		} else if (domain.getStartDate() == null && domain.getEndDate() != null) {
			selectBySql.append(" and  a.trade_time <= to_date ('"
					+ domain.getEndDate().toLocaleString().substring(0, 9)
					+ "','yyyy-mm-dd') ");
		}
		// 参数集合
		List<Object> param = new ArrayList<Object>();

		selectBySql.append(" order by a.trade_time desc");
		List list = null;
		if (pageInfo == null) {
			list = jdbcDaoSupport.find(selectBySql.toString(), new Object[] {});
		} else {
			Page page = jdbcDaoSupport.find(selectBySql.toString(), param
					.toArray(), pageInfo);
			if (page != null && page.getData() != null) {
				list = page.getData();
			}
		}
		return list;
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(OrderBill domain) throws DataAccessException {

		return getPersistanceManager().find("findOrderBillByWhere2", domain);
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
	public Page findByWhere(OrderBill domain, PageInfo pageInfo)
			throws DataAccessException {

		return this.getPersistanceManager().find("findOrderBillByWhere2",
				domain, pageInfo);
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * 
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public com.hnatourism.club.pay.order.domain.OrderBill findById(String id) throws DataAccessException {
		return (com.hnatourism.club.pay.order.domain.OrderBill) getPersistanceManager()
				.load("findOrderBillById2", id);
	}

	/**
	 * 【删除】（系统生成方法）
	 * 
	 * @param id
	 * @throws DataAccessException
	 */
	public int delete(String id) throws DataAccessException {
		com.hnatourism.club.pay.order.domain.OrderBill domain = findById(id);
		if (domain == null) {
			throw new DataAccessException("", "ID = '" + id
					+ "' object not exist");
		}
		return getPersistanceManager().delete("deleteOrderBill2", id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * 
	 * @param domain
	 * @throws DataAccessException
	 */
	public int update(OrderBill domain) throws DataAccessException {
		OrderBill tmp = findById(domain.getId());
		if (tmp == null) {
			throw new DataAccessException("", "ID = '" + domain.getId()
					+ "' object not exist");
		}
		return getPersistanceManager().update("updateOrderBill2", domain);
	}

	/**
	 * 【新增】（系统生成方法）
	 * 
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public Object insert(OrderBill domain) throws DataAccessException {
		return getPersistanceManager().insert("insertOrderBill2", domain);
	}

	public JdbcDaoSupport getJdbcDaoSupport() {
		return jdbcDaoSupport;
	}

	public void setJdbcDaoSupport(JdbcDaoSupport jdbcDaoSupport) {
		this.jdbcDaoSupport = jdbcDaoSupport;
	}

}