package com.hnatourism.club.lounge.prod.service;

import java.util.List;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.service.IService;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场休息室产品信息表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface ILoungeInfoService extends IService {
	
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
	public List findByComm(AbstractVo vo) throws BusinessException;

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
}