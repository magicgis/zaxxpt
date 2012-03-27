package com.hnatourism.club.personal.member.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.service.BaseAbstractService;
import com.hnatourism.club.personal.member.dao.IMemberInfoDao;
import com.hnatourism.club.personal.member.domain.MemberInfo;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.service.IMemberStsService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
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
 * 功能描述:会员信息
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class MemberInfoServiceImpl extends BaseAbstractService 
		implements IMemberInfoService {
	private static final Log log = LogFactory.getLog(MemberInfoServiceImpl.class);
	private IMemberInfoDao memberInfoDao;
	private IMemberRoleService memberRoleServ;
	private IMemberStsService memberStsServ;
	private IMemberAccountService memberAccountServ;
	
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
		MemberInfo domain = new MemberInfo();
		// copy vo Properties to domain
		BeanUtils.copyProperties((MemberInfoVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return memberInfoDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return memberInfoDao.delete(id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public int update(AbstractVo vo) throws BusinessException
	{
		
		MemberInfo domain = new MemberInfo();
		BeanUtils.copyProperties((MemberInfoVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return memberInfoDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		MemberInfo domain = new MemberInfo();
		BeanUtils.copyProperties((MemberInfoVo) vo, domain);
		List<MemberInfo> list = memberInfoDao.findByWhere(domain);
		MemberInfoVo returnVo = null;
		List<MemberInfoVo> voList = new ArrayList();
		for (MemberInfo temp : list) {
			returnVo = new MemberInfoVo();
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
		MemberInfo domain = new MemberInfo();
		BeanUtils.copyProperties((MemberInfoVo) vo, domain);
		Page page = memberInfoDao.findByWhere(domain,pageInfo);
		MemberInfoVo returnVo = null;
		List<MemberInfoVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			MemberInfo memberInfo=(MemberInfo)temp;
			returnVo = new MemberInfoVo();
			BeanUtils.copyProperties(memberInfo, returnVo);
			voList.add(returnVo);
		}
		page.setData(voList);
		return page;
	}
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 * 2011-08-23 v1.1.0 (高杰):
	 */
	 @Override
	public AbstractVo findById(String id) throws BusinessException
	{
		MemberInfo domain = memberInfoDao.findById(id);
		MemberInfoVo vo = null;
		if(domain != null){
		 vo = new MemberInfoVo();
			 BeanUtils.copyProperties(domain, vo);
		}
		
		return vo;
	}
		/**
		 * 【根据ID查询】（系统生成方法）
		 * @param id
		 * @throws BusinessException
		 * 2011-08-23 v1.1.0 (高杰):
		 */
		 @Override
		public AbstractVo findByCode(String code) throws BusinessException
		{
			MemberInfo domain = memberInfoDao.findByCode(code);
			MemberInfoVo vo = null;
			if(domain != null){
			 vo = new MemberInfoVo();
				 BeanUtils.copyProperties(domain, vo);
			}

			MemberAccountVo account=(MemberAccountVo)memberAccountServ.findByMember(vo.getId());
			if(account!=null)
			{
				vo.setMemberRole((MemberRoleVo)memberRoleServ.findById(account.getRole()));
			}
			vo.setMemberSts((MemberStsVo)memberStsServ.findByMember(vo.getCode()));
			
			return vo;
		}
		 /**
		 * 【根据ID查询】（系统生成方法）
		 * @param id
		 * @throws BusinessException
		 * 2011-08-23 v1.1.0 (高杰):
		 */
		 @Override
		public AbstractVo findByCodeLogin(String code) throws BusinessException
		{
			MemberInfo domain = memberInfoDao.findByCode(code);
			MemberInfoVo vo = null;
			if(domain != null){
			 vo = new MemberInfoVo();
				 BeanUtils.copyProperties(domain, vo);
			}
			
			return vo;
		}
			/**
			 * 【根据ID查询】（系统生成方法）
			 * @param id
			 * @throws BusinessException
			 * 2011-08-23 v1.1.0 (高杰):
			 */
			 @Override
			public AbstractVo findByCodePw(String code, String pw) throws BusinessException
			{
				 HashMap<String, String> hm=new HashMap<String, String>();
				 hm.put("code", code);
				 hm.put("pw", pw);
				 
				MemberInfo domain = memberInfoDao.findByCodePw(hm);
				MemberInfoVo vo = null;
				if(domain != null){
				 vo = new MemberInfoVo();
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
		MemberInfoVo checkVo = (MemberInfoVo)vo;
		MemberInfoVo qryVo = new MemberInfoVo();
		
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
	 *  get memberInfoDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	/**
	 *  set memberInfoDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	public void setMemberRoleServ(IMemberRoleService memberRoleServ) {
		this.memberRoleServ = memberRoleServ;
	}

	public void setMemberStsServ(IMemberStsService memberStsServ) {
		this.memberStsServ = memberStsServ;
	}

	public void setMemberAccountServ(IMemberAccountService memberAccountServ) {
		this.memberAccountServ = memberAccountServ;
	}
}