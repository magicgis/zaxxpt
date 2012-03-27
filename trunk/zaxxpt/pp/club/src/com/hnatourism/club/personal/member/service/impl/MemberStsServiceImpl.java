package com.hnatourism.club.personal.member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.service.BaseAbstractService;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.personal.member.dao.IMemberStsDao;
import com.hnatourism.club.personal.member.domain.MemberSts;
import com.hnatourism.club.personal.member.service.IMemberStsService;
import com.hnatourism.club.personal.member.web.vo.MemberStsVo;
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
 * 功能描述:会员状态表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class MemberStsServiceImpl extends BaseAbstractService 
		implements IMemberStsService {
	private static final Log log = LogFactory.getLog(MemberStsServiceImpl.class);
	private IMemberStsDao memberStsDao;
	
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
		MemberSts domain = new MemberSts();
		// copy vo Properties to domain
		BeanUtils.copyProperties((MemberStsVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUserCode());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return memberStsDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return memberStsDao.delete(id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public int update(AbstractVo vo) throws BusinessException {
//		BaseUserVo user = UserUtil.getUserVo();
		//validate data
		validateData(vo);

		MemberSts domain = new MemberSts();
		BeanUtils.copyProperties((MemberStsVo) vo, domain);
		//domain.setUpdateUser(user.getUserCode());
		//domain.setUpdateTime(DateUtils.getCurrentDate());
		return memberStsDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		MemberSts domain = new MemberSts();
		BeanUtils.copyProperties((MemberStsVo) vo, domain);
		List<MemberSts> list = memberStsDao.findByWhere(domain);
		MemberStsVo returnVo = null;
		List<MemberStsVo> voList = new ArrayList();
		for (MemberSts temp : list) {
			returnVo = new MemberStsVo();
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
		MemberSts domain = new MemberSts();
		BeanUtils.copyProperties((MemberStsVo) vo, domain);
		Page page = memberStsDao.findByWhere(domain,pageInfo);
		MemberStsVo returnVo = null;
		List<MemberStsVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			MemberSts memberSts=(MemberSts)temp;
			returnVo = new MemberStsVo();
			BeanUtils.copyProperties(memberSts, returnVo);
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
		MemberSts domain = memberStsDao.findById(id);
		MemberStsVo vo = null;
		if(domain != null){
		 vo = new MemberStsVo();
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
		public AbstractVo findByMember(String memberId) throws BusinessException {
			MemberSts domain = memberStsDao.findByMember(memberId);
			MemberStsVo vo = null;
			if(domain != null){
			 vo = new MemberStsVo();
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
		MemberStsVo checkVo = (MemberStsVo)vo;
		MemberStsVo qryVo = new MemberStsVo();
		
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
	 *  get memberStsDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public IMemberStsDao getMemberStsDao() {
		return memberStsDao;
	}

	/**
	 *  set memberStsDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setMemberStsDao(IMemberStsDao memberStsDao) {
		this.memberStsDao = memberStsDao;
	}
}