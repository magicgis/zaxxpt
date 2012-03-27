package com.hnatourism.club.lounge.prod.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.exception.ValidateException;
import com.hnatourism.framework.core.service.AbstractService;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.web.vo.AbstractVo;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.UserUtil;
import com.hnatourism.framework.utils.DateUtils;
import com.hnatourism.club.lounge.prod.dao.ILoungeOrderExceptionDao;
import com.hnatourism.club.lounge.prod.service.ILoungeOrderExceptionService;
import com.hnatourism.club.lounge.prod.domain.LoungeOrderException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室订单退改表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeOrderExceptionServiceImpl 
		implements ILoungeOrderExceptionService {
	private static final Log log = LogFactory.getLog(LoungeOrderExceptionServiceImpl.class);
	private ILoungeOrderExceptionDao loungeOrderExceptionDao;
	
	/**
	 * 【新增】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public Object insert(AbstractVo vo) throws BusinessException {
		//BaseUserVo user = UserUtil.getUserVo();
		// validate data
		validateData(vo);
		// validate uniqueness
		//if (!checkUniqueness(vo)) {
		//	 throw new BusinessException("notUnique");
		//}
		LoungeOrderException domain = new LoungeOrderException();
		// copy vo Properties to domain
		//BeanUtils.copyProperties((LoungeOrderExceptionVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return loungeOrderExceptionDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return loungeOrderExceptionDao.delete(id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public int update(AbstractVo vo) throws BusinessException {
		//BaseUserVo user = UserUtil.getUserVo();
		//validate data
		validateData(vo);

		LoungeOrderException domain = new LoungeOrderException();
		//BeanUtils.copyProperties((LoungeOrderExceptionVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return loungeOrderExceptionDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		LoungeOrderException domain = new LoungeOrderException();
		//BeanUtils.copyProperties((LoungeOrderExceptionVo) vo, domain);
		List<LoungeOrderException> list = loungeOrderExceptionDao.findByWhere(domain);
//		LoungeOrderExceptionVo returnVo = null;
//		List<LoungeOrderExceptionVo> voList = new ArrayList();
//		for (LoungeOrderException temp : list) {
//			returnVo = new LoungeOrderExceptionVo();
//			BeanUtils.copyProperties(temp, returnVo);
//			voList.add(returnVo);
//		}
		return null;
	}
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public Page findByWhere(AbstractVo vo,PageInfo pageInfo) throws BusinessException {
		LoungeOrderException domain = new LoungeOrderException();
		//BeanUtils.copyProperties((LoungeOrderExceptionVo) vo, domain);
		Page page = loungeOrderExceptionDao.findByWhere(domain,pageInfo);
//		LoungeOrderExceptionVo returnVo = null;
//		List<LoungeOrderExceptionVo> voList = new ArrayList();
//		for (Object temp : page.getData()) {
//			LoungeOrderException loungeOrderException=(LoungeOrderException)temp;
//			returnVo = new LoungeOrderExceptionVo();
//			BeanUtils.copyProperties(loungeOrderException, returnVo);
//			voList.add(returnVo);
//		}
//		page.setData(voList);
		return page;
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public AbstractVo findById(String id) throws BusinessException {
		LoungeOrderException domain = loungeOrderExceptionDao.findById(id);
//		LoungeOrderExceptionVo vo = null;
//		if(domain != null){
//		 vo = new LoungeOrderExceptionVo();
//			 BeanUtils.copyProperties(domain, vo);
//		}
		return null;
	}
	
//	/**
//	 * 【校验唯一性】（系统生成方法）通常在insert,update前使用
//	 * @param vo
//	 * @return
//	 * @throws BusinessException
//	 */
//	 @Override
//	public boolean checkUniqueness(AbstractVo vo) throws BusinessException {
//		boolean isUnique = false;
//		LoungeOrderExceptionVo checkVo = (LoungeOrderExceptionVo)vo;
//		LoungeOrderExceptionVo qryVo = new LoungeOrderExceptionVo();
//		
//		//start
//		//qryVo.set...(checkVo.get...());
//		//end
//		
//		List voList = findByWhere(qryVo);
//		if(ListUtils.isEmpty(voList)){
//			isUnique = true;
//		}
//		return isUnique;
//	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void validateData(AbstractVo vo) throws ValidateException {
	
	}

	/**
	 *  get loungeOrderExceptionDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public ILoungeOrderExceptionDao getLoungeOrderExceptionDao() {
		return loungeOrderExceptionDao;
	}

	/**
	 *  set loungeOrderExceptionDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setLoungeOrderExceptionDao(ILoungeOrderExceptionDao loungeOrderExceptionDao) {
		this.loungeOrderExceptionDao = loungeOrderExceptionDao;
	}
}