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
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
import com.hnatourism.club.lounge.prod.service.ILoungeInfoService;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
import com.hnatourism.club.lounge.prod.vo.LoungeInfoVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:机场休息室产品信息表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeInfoServiceImpl extends BaseAbstractService 
		implements ILoungeInfoService {
	private static final Log log = LogFactory.getLog(LoungeInfoServiceImpl.class);
	private ILoungeInfoDao loungeInfoDao;
	
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
		LoungeInfo domain = new LoungeInfo();
		// copy vo Properties to domain
		BeanUtils.copyProperties((LoungeInfoVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return loungeInfoDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return loungeInfoDao.delete(id);
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

		LoungeInfo domain = new LoungeInfo();
		BeanUtils.copyProperties((LoungeInfoVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return loungeInfoDao.update(domain);
	}
		
		/**
		 * 【根据条件查询】（系统生成方法）
		 * @param vo
		 * @return
		 * @throws BusinessException
		 */
		 @Override
		public List findByComm(AbstractVo vo) throws BusinessException {
			LoungeInfo domain = new LoungeInfo();
			BeanUtils.copyProperties((LoungeInfoVo) vo, domain);
			List<LoungeInfo> list = loungeInfoDao.findByWhere(domain);
			LoungeInfoVo returnVo = null;
			List<LoungeInfoVo> voList = new ArrayList();
			for (LoungeInfo temp : list) {
				returnVo = new LoungeInfoVo();
				BeanUtils.copyProperties(temp, returnVo);
				voList.add(returnVo);
			}
			return voList;
		}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		LoungeInfo domain = new LoungeInfo();
		BeanUtils.copyProperties((LoungeInfoVo) vo, domain);
		List<LoungeInfo> list = loungeInfoDao.findByWhere(domain);
		LoungeInfoVo returnVo = null;
		List<LoungeInfoVo> voList = new ArrayList();
		for (LoungeInfo temp : list) {
			returnVo = new LoungeInfoVo();
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
		LoungeInfo domain = new LoungeInfo();
		BeanUtils.copyProperties((LoungeInfoVo) vo, domain);
		Page page = loungeInfoDao.findByWhere(domain,pageInfo);
		LoungeInfoVo returnVo = null;
		List<LoungeInfoVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			LoungeInfo loungeInfo=(LoungeInfo)temp;
			returnVo = new LoungeInfoVo();
			BeanUtils.copyProperties(loungeInfo, returnVo);
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
		LoungeInfo domain = loungeInfoDao.findById(id);
		LoungeInfoVo vo = null;
		if(domain != null){
		 vo = new LoungeInfoVo();
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
		LoungeInfoVo checkVo = (LoungeInfoVo)vo;
		LoungeInfoVo qryVo = new LoungeInfoVo();
		
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
	 *  get loungeInfoDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public ILoungeInfoDao getLoungeInfoDao() {
		return loungeInfoDao;
	}

	/**
	 *  set loungeInfoDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setLoungeInfoDao(ILoungeInfoDao loungeInfoDao) {
		this.loungeInfoDao = loungeInfoDao;
	}
}