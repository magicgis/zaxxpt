package com.hnatourism.club.personal.member.service;

import java.util.List;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.service.IService;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.personal.member.domain.MemberSts;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.OrderBillVo;
import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员状态表
 * 
 * 历史版本:2011-08-24 v1.1.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface IOrderBillService extends IService {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	public Page findByAccount(String account,int currentPage) throws BusinessException;
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
	//分润前插入数据
	public void insertOrderBill(SubRunBean subRunBean,String createUser);
	/**
	 * 【修改】（系统生成方法）
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public int updateClear(AbstractVo vo) throws BusinessException;
	public Object myInsert(OrderBillVo billVo, MemberInfoVo user)throws BusinessException;
}