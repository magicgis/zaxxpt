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
import com.hnatourism.club.lounge.prod.dao.ILoungeImgDao;
import com.hnatourism.club.lounge.prod.service.ILoungeImgService;
import com.hnatourism.club.lounge.prod.domain.LoungeImg;
import com.hnatourism.club.lounge.prod.vo.LoungeImgVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室产品图片表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeImgServiceImpl extends BaseAbstractService 
		implements ILoungeImgService {
	private static final Log log = LogFactory.getLog(LoungeImgServiceImpl.class);
	private ILoungeImgDao loungeImgDao;
	
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
		LoungeImg domain = new LoungeImg();
		// copy vo Properties to domain
		BeanUtils.copyProperties((LoungeImgVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return loungeImgDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return loungeImgDao.delete(id);
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

		LoungeImg domain = new LoungeImg();
		BeanUtils.copyProperties((LoungeImgVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return loungeImgDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		LoungeImg domain = new LoungeImg();
		BeanUtils.copyProperties((LoungeImgVo) vo, domain);
		List<LoungeImg> list = loungeImgDao.findByWhere(domain);
		LoungeImgVo returnVo = null;
		List<LoungeImgVo> voList = new ArrayList();
		for (LoungeImg temp : list) {
			returnVo = new LoungeImgVo();
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
		LoungeImg domain = new LoungeImg();
		BeanUtils.copyProperties((LoungeImgVo) vo, domain);
		Page page = loungeImgDao.findByWhere(domain,pageInfo);
		LoungeImgVo returnVo = null;
		List<LoungeImgVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			LoungeImg loungeImg=(LoungeImg)temp;
			returnVo = new LoungeImgVo();
			BeanUtils.copyProperties(loungeImg, returnVo);
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
		LoungeImg domain = loungeImgDao.findById(id);
		LoungeImgVo vo = null;
		if(domain != null){
		 vo = new LoungeImgVo();
			 BeanUtils.copyProperties(domain, vo);
		}
		return vo;
	}
		/**
		 * 【根据ID查询】（系统生成方法）
		 * @param id
		 * @throws BusinessException
		 */
		 @Override
		public AbstractVo findBySearch(String loungeId) throws BusinessException {
			LoungeImg domain = loungeImgDao.findBySearch(loungeId);
			LoungeImgVo vo = null;
			if(domain != null){
			 vo = new LoungeImgVo();
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
		LoungeImgVo checkVo = (LoungeImgVo)vo;
		LoungeImgVo qryVo = new LoungeImgVo();
		
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
	 *  get loungeImgDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public ILoungeImgDao getLoungeImgDao() {
		return loungeImgDao;
	}

	/**
	 *  set loungeImgDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setLoungeImgDao(ILoungeImgDao loungeImgDao) {
		this.loungeImgDao = loungeImgDao;
	}
}