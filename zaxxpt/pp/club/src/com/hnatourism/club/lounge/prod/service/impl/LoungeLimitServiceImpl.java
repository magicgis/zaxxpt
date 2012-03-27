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
import com.hnatourism.framework.web.vo.BaseUserVo;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.UserUtil;
import com.hnatourism.framework.utils.DateUtils;
import com.hnatourism.club.lounge.prod.dao.ILoungeLimitDao;
import com.hnatourism.club.lounge.prod.service.ILoungeLimitService;
import com.hnatourism.club.lounge.prod.domain.LoungeLimit;
import com.hnatourism.club.lounge.prod.vo.LoungeLimitVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室不预定时间维护
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeLimitServiceImpl extends BaseAbstractService 
		implements ILoungeLimitService {
	private static final Log log = LogFactory.getLog(LoungeLimitServiceImpl.class);
	private ILoungeLimitDao loungeLimitDao;
	
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
		validateData(vo);
		// validate uniqueness
		if (!checkUniqueness(vo)) {
			 throw new BusinessException("notUnique");
		}
		LoungeLimit domain = new LoungeLimit();
		// copy vo Properties to domain
		BeanUtils.copyProperties((LoungeLimitVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return loungeLimitDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return loungeLimitDao.delete(id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public int update(AbstractVo vo) throws BusinessException {
		BaseUserVo user = UserUtil.getUserVo();
		//validate data
		validateData(vo);

		LoungeLimit domain = new LoungeLimit();
		BeanUtils.copyProperties((LoungeLimitVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return loungeLimitDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		LoungeLimit domain = new LoungeLimit();
		BeanUtils.copyProperties((LoungeLimitVo) vo, domain);
		List<LoungeLimit> list = loungeLimitDao.findByWhere(domain);
		LoungeLimitVo returnVo = null;
		List<LoungeLimitVo> voList = new ArrayList();
		for (LoungeLimit temp : list) {
			returnVo = new LoungeLimitVo();
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
	public Page findByWhere(AbstractVo vo,PageInfo pageInfo) throws BusinessException {
		LoungeLimit domain = new LoungeLimit();
		BeanUtils.copyProperties((LoungeLimitVo) vo, domain);
		Page page = loungeLimitDao.findByWhere(domain,pageInfo);
		LoungeLimitVo returnVo = null;
		List<LoungeLimitVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			LoungeLimit loungeLimit=(LoungeLimit)temp;
			returnVo = new LoungeLimitVo();
			BeanUtils.copyProperties(loungeLimit, returnVo);
			voList.add(returnVo);
		}
		page.setData(voList);
		return page;
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public AbstractVo findById(String id) throws BusinessException {
		LoungeLimit domain = loungeLimitDao.findById(id);
		LoungeLimitVo vo = null;
		if(domain != null){
		 vo = new LoungeLimitVo();
			 BeanUtils.copyProperties(domain, vo);
		}
		return vo;
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
		LoungeLimitVo checkVo = (LoungeLimitVo)vo;
		LoungeLimitVo qryVo = new LoungeLimitVo();
		
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

	/**
	 *  get loungeLimitDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public ILoungeLimitDao getLoungeLimitDao() {
		return loungeLimitDao;
	}

	/**
	 *  set loungeLimitDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setLoungeLimitDao(ILoungeLimitDao loungeLimitDao) {
		this.loungeLimitDao = loungeLimitDao;
	}
}