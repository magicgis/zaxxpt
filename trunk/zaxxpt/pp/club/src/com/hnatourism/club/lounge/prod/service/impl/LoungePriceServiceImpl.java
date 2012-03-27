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
import com.hnatourism.club.lounge.prod.dao.ILoungePriceDao;
import com.hnatourism.club.lounge.prod.service.ILoungePriceService;
import com.hnatourism.club.lounge.prod.domain.LoungePrice;
import com.hnatourism.club.lounge.prod.vo.LoungePriceVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室项目价格表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class LoungePriceServiceImpl extends BaseAbstractService 
		implements ILoungePriceService {
	private static final Log log = LogFactory.getLog(LoungePriceServiceImpl.class);
	private ILoungePriceDao loungePriceDao;
	
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
		LoungePrice domain = new LoungePrice();
		// copy vo Properties to domain
		BeanUtils.copyProperties((LoungePriceVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return loungePriceDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return loungePriceDao.delete(id);
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

		LoungePrice domain = new LoungePrice();
		BeanUtils.copyProperties((LoungePriceVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return loungePriceDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		LoungePrice domain = new LoungePrice();
		BeanUtils.copyProperties((LoungePriceVo) vo, domain);
		List<LoungePrice> list = loungePriceDao.findByWhere(domain);
		LoungePriceVo returnVo = null;
		List<LoungePriceVo> voList = new ArrayList();
		for (LoungePrice temp : list) {
			returnVo = new LoungePriceVo();
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
		LoungePrice domain = new LoungePrice();
		BeanUtils.copyProperties((LoungePriceVo) vo, domain);
		Page page = loungePriceDao.findByWhere(domain,pageInfo);
		LoungePriceVo returnVo = null;
		List<LoungePriceVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			LoungePrice loungePrice=(LoungePrice)temp;
			returnVo = new LoungePriceVo();
			BeanUtils.copyProperties(loungePrice, returnVo);
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
		LoungePrice domain = loungePriceDao.findById(id);
		LoungePriceVo vo = null;
		if(domain != null){
		 vo = new LoungePriceVo();
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
		LoungePriceVo checkVo = (LoungePriceVo)vo;
		LoungePriceVo qryVo = new LoungePriceVo();
		
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
	 *  get loungePriceDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public ILoungePriceDao getLoungePriceDao() {
		return loungePriceDao;
	}

	/**
	 *  set loungePriceDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setLoungePriceDao(ILoungePriceDao loungePriceDao) {
		this.loungePriceDao = loungePriceDao;
	}
}