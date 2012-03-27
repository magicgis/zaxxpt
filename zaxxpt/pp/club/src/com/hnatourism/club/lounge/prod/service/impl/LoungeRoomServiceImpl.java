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
import com.hnatourism.club.lounge.prod.dao.ILoungeRoomDao;
import com.hnatourism.club.lounge.prod.service.ILoungeRoomService;
import com.hnatourism.club.lounge.prod.domain.LoungeRoom;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室房间表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeRoomServiceImpl extends BaseAbstractService 
		implements ILoungeRoomService {
	private static final Log log = LogFactory.getLog(LoungeRoomServiceImpl.class);
	private ILoungeRoomDao loungeRoomDao;
	
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
		LoungeRoom domain = new LoungeRoom();
		// copy vo Properties to domain
		BeanUtils.copyProperties((LoungeRoomVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return loungeRoomDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return loungeRoomDao.delete(id);
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

		LoungeRoom domain = new LoungeRoom();
		BeanUtils.copyProperties((LoungeRoomVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return loungeRoomDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		LoungeRoom domain = new LoungeRoom();
		BeanUtils.copyProperties((LoungeRoomVo) vo, domain);
		List<LoungeRoom> list = loungeRoomDao.findByWhere(domain);
		LoungeRoomVo returnVo = null;
		List<LoungeRoomVo> voList = new ArrayList();
		for (LoungeRoom temp : list) {
			returnVo = new LoungeRoomVo();
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
		LoungeRoom domain = new LoungeRoom();
		BeanUtils.copyProperties((LoungeRoomVo) vo, domain);
		Page page = loungeRoomDao.findByWhere(domain,pageInfo);
		LoungeRoomVo returnVo = null;
		List<LoungeRoomVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			LoungeRoom loungeRoom=(LoungeRoom)temp;
			returnVo = new LoungeRoomVo();
			BeanUtils.copyProperties(loungeRoom, returnVo);
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
		LoungeRoom domain = loungeRoomDao.findById(id);
		LoungeRoomVo vo = null;
		if(domain != null){
		 vo = new LoungeRoomVo();
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
		LoungeRoomVo checkVo = (LoungeRoomVo)vo;
		LoungeRoomVo qryVo = new LoungeRoomVo();
		
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
	 *  get loungeRoomDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public ILoungeRoomDao getLoungeRoomDao() {
		return loungeRoomDao;
	}

	/**
	 *  set loungeRoomDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setLoungeRoomDao(ILoungeRoomDao loungeRoomDao) {
		this.loungeRoomDao = loungeRoomDao;
	}
}