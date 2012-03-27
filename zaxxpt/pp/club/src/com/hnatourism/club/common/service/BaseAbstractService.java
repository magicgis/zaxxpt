package com.hnatourism.club.common.service;

import java.util.List;

import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.exception.ValidateException;
import com.hnatourism.framework.core.service.AbstractService;
import com.hnatourism.framework.web.vo.AbstractVo;

/**
 * 【单表操作service基类】
 * @author zhangyun
 *
 */
public abstract class BaseAbstractService extends AbstractService{
	/**
	 * 根据条件查询
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public abstract List findByWhere(AbstractVo vo) throws BusinessException;
	/**
	 * 根据条件查询
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public abstract Page findByWhere(AbstractVo vo,PageInfo pageInfo) throws BusinessException;

	/**
	 * 删除
	 * @param id
	 * @throws BusinessException
	 */
	public abstract int delete(String id) throws BusinessException;

	/**
	 * 根据ID查询
	 * @param id
	 * @throws BusinessException
	 */
	public abstract AbstractVo findById(String id) throws BusinessException;

	/**
	 * 新增
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public abstract Object insert(AbstractVo vo) throws BusinessException;

	/**
	 * 修改
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public abstract int update(AbstractVo vo) throws BusinessException;
	
	/**
	 * @description 【校验唯一性】
	 * @param vo
	 * @throws BusinessException
	 */
	public abstract boolean checkUniqueness(AbstractVo vo) throws BusinessException;
	
	/**
	 * @description 【服务端验证数据合法性】
	 * @param vo
	 * @return
	 * @throws ValidateException
	 * @author zhangyun
	 */
	public abstract void validateData(AbstractVo vo) throws ValidateException;
}
