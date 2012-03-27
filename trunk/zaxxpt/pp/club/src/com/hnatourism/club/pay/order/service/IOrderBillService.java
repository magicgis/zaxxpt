package com.hnatourism.club.pay.order.service;

import java.util.List;

import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.pay.order.domain.OrderBill;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.service.IService;
import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:账单表
 * 
 * 历史版本:
 *					2011-08-09 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface IOrderBillService extends IService {
	 /**
	 * 查询账单
	 * @param 苏忆
	 * @return
	 * @throws BusinessException
	 */
	public List<OrderBill> findBillByWhere(OrderBill vo, PageInfo pageInfo) throws BusinessException;
  /**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public Object insert(AbstractVo vo) throws BusinessException;
	
	/**
	 *  【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	public int delete(String id) throws BusinessException;

	/**
	 * 【修改】（系统生成方法）
	 * @param domain
	 * @throws BusinessException
	 */
	public int update(AbstractVo vo) throws BusinessException;

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws BusinessException
	 */
	public List findByWhere(AbstractVo vo) throws BusinessException;
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
  public Page findByWhere(AbstractVo vo,PageInfo pageInfo) throws BusinessException;
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AbstractVo findById(String id) throws BusinessException;
	public void insertOrderBill(SubRunBean subRunBean,MemberInfoVo user);
	/**
	 * @author gujianliang
	 * @2011-9-2
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public  int updateClear(AbstractVo vo) throws BusinessException;
	public void insertOrderChangeBill(SubRunBean subRunBean);
	public void insertOrderReturnBill(SubRunBean subRunBean);
	public String getTradeNoByOrderId(String string);
}