package com.hnatourism.club.personal.member.service.impl;

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
import com.hnatourism.club.personal.member.dao.IMemberRoleDao;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.domain.MemberRole;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员角色表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class MemberRoleServiceImpl extends BaseAbstractService 
		implements IMemberRoleService {
	private static final Log log = LogFactory.getLog(MemberRoleServiceImpl.class);
	private IMemberRoleDao memberRoleDao;
	
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
		MemberRole domain = new MemberRole();
		// copy vo Properties to domain
		BeanUtils.copyProperties((MemberRoleVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return memberRoleDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return memberRoleDao.delete(id);
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

		MemberRole domain = new MemberRole();
		BeanUtils.copyProperties((MemberRoleVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return memberRoleDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		MemberRole domain = new MemberRole();
		BeanUtils.copyProperties((MemberRoleVo) vo, domain);
		List<MemberRole> list = memberRoleDao.findByWhere(domain);
		MemberRoleVo returnVo = null;
		List<MemberRoleVo> voList = new ArrayList();
		for (MemberRole temp : list) {
			returnVo = new MemberRoleVo();
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
		MemberRole domain = new MemberRole();
		BeanUtils.copyProperties((MemberRoleVo) vo, domain);
		Page page = memberRoleDao.findByWhere(domain,pageInfo);
		MemberRoleVo returnVo = null;
		List<MemberRoleVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			MemberRole memberRole=(MemberRole)temp;
			returnVo = new MemberRoleVo();
			BeanUtils.copyProperties(memberRole, returnVo);
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
		MemberRole domain = memberRoleDao.findById(id);
		MemberRoleVo vo = null;
		if(domain != null){
		 vo = new MemberRoleVo();
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
			MemberRole domain = memberRoleDao.findByMember(memberId);
			MemberRoleVo vo = null;
			if(domain != null){
			  vo = new MemberRoleVo();
			  BeanUtils.copyProperties(domain, vo);
			}
			return vo;
		}
		 /**
		  * 【根据ID查询】 
		  * @param id
		  * @author 谷建亮
		  * @throws BusinessException
		  */
		 @Override
		 public AbstractVo findByMember(MemberRole memberRole) throws BusinessException {
			 MemberRole domain = memberRoleDao.findByMember(memberRole);
			 MemberRoleVo vo = null;
			 if(domain != null){
				 vo = new MemberRoleVo();
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
		MemberRoleVo checkVo = (MemberRoleVo)vo;
		MemberRoleVo qryVo = new MemberRoleVo();
		
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
	 *  get memberRoleDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public IMemberRoleDao getMemberRoleDao() {
		return memberRoleDao;
	}

	/**
	 *  set memberRoleDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setMemberRoleDao(IMemberRoleDao memberRoleDao) {
		this.memberRoleDao = memberRoleDao;
	}
}