package com.hnatourism.club.lounge.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeGuestDao;
import com.hnatourism.club.lounge.order.domain.OrderLoungeGuest;
import com.hnatourism.club.lounge.order.service.IOrderLoungeGuestService;
import com.hnatourism.club.lounge.order.vo.OrderLoungeGuestVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.exception.ValidateException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.UserUtil;
import com.hnatourism.framework.web.vo.AbstractVo;
import com.hnatourism.framework.web.vo.BaseUserVo;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室订单退改表
 * 
 * 历史版本:
 *				2011-11-23 wenz 创建:
 * 
 */
public class OrderLoungeGuestServiceImpl implements
		IOrderLoungeGuestService {

	private IOrderLoungeGuestDao orderLoungeGuestDaoImpl;
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	@Override
	public int delete(String id) throws BusinessException {
		// TODO Auto-generated method stub
		return orderLoungeGuestDaoImpl.delete(id);
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	@Override
	public AbstractVo findById(String id) throws BusinessException {
		// TODO Auto-generated method stub
		OrderLoungeGuest domain = orderLoungeGuestDaoImpl.findById(id);
		OrderLoungeGuestVo vo = null;
		if(domain != null){
		 vo = new OrderLoungeGuestVo();
			 BeanUtils.copyProperties(domain, vo);
		}
		return vo;
	}


	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		// TODO Auto-generated method stub
		OrderLoungeGuest domain = new OrderLoungeGuest();
		BeanUtils.copyProperties((OrderLoungeGuestVo) vo, domain);
		List<OrderLoungeGuest> list = orderLoungeGuestDaoImpl.findByWhere(domain);
		OrderLoungeGuestVo returnVo = null;
		List<OrderLoungeGuestVo> voList = new ArrayList();
		for (OrderLoungeGuest temp : list) {
			returnVo = new OrderLoungeGuestVo();
			BeanUtils.copyProperties(temp, returnVo);
			voList.add(returnVo);
		}
		return voList;
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Page findByWhere(AbstractVo vo, PageInfo pageInfo)
			throws BusinessException {
		// TODO Auto-generated method stub
		OrderLoungeGuest domain = new OrderLoungeGuest();
		BeanUtils.copyProperties((OrderLoungeGuestVo) vo, domain);
		Page page = orderLoungeGuestDaoImpl.findByWhere(domain,pageInfo);
		OrderLoungeGuestVo returnVo = null;
		List<OrderLoungeGuestVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			OrderLoungeGuest orderLoungeGuest=(OrderLoungeGuest)temp;
			returnVo = new OrderLoungeGuestVo();
			BeanUtils.copyProperties(orderLoungeGuest, returnVo);
			voList.add(returnVo);
		}
		page.setData(voList);
		return page;
	}

	/**
	 * 【新增】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Object insert(AbstractVo vo) throws BusinessException {
		BaseUserVo user = UserUtil.getUserVo();
		// validate data
//		validateData(vo);
		// validate uniqueness
//		if (!checkUniqueness(vo)) {
//			 throw new BusinessException("notUnique");
//		}
		OrderLoungeGuest domain = new OrderLoungeGuest();
		// copy vo Properties to domain
		BeanUtils.copyProperties((OrderLoungeGuestVo) vo, domain);
		domain.setCreateUser(user.getUserCode());
		domain.setCreateTime(DateUtils.getCurrentDate());
		return orderLoungeGuestDaoImpl.insert(domain);
	}

	/**
	 * 【修改】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public int update(AbstractVo vo) throws BusinessException {
		// TODO Auto-generated method stub
		BaseUserVo user = UserUtil.getUserVo();
		//validate data
//		validateData(vo);

		OrderLoungeGuest domain = new OrderLoungeGuest();
		BeanUtils.copyProperties((OrderLoungeGuestVo) vo, domain);
		domain.setUpdateUser(user.getUserCode());
		domain.setUpdateTime(DateUtils.getCurrentDate());
		return orderLoungeGuestDaoImpl.update(domain);
	}
	
	/**
	 * 【校验唯一性】（系统生成方法）通常在insert,update前使用
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public boolean checkUniqueness(AbstractVo vo) throws BusinessException {
		boolean isUnique = false;
		OrderLoungeGuestVo checkVo = (OrderLoungeGuestVo)vo;
		OrderLoungeGuestVo qryVo = new OrderLoungeGuestVo();
		
		//start
		//qryVo.set...(checkVo.get...());
		//end
		
		List voList = findByWhere(qryVo);
		if(ListUtils.isEmpty(voList)){
			isUnique = true;
		}
		return isUnique;
	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void validateData(AbstractVo vo) throws ValidateException {
	
	}

	public IOrderLoungeGuestDao getOrderLoungeGuestDaoImpl() {
		return orderLoungeGuestDaoImpl;
	}

	public void setOrderLoungeGuestDaoImpl(
			IOrderLoungeGuestDao orderLoungeGuestDaoImpl) {
		this.orderLoungeGuestDaoImpl = orderLoungeGuestDaoImpl;
	}


	
}
