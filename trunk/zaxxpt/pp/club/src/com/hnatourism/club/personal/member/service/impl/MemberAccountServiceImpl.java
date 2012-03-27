package com.hnatourism.club.personal.member.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.exception.DataAccessException;
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
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员账户表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class MemberAccountServiceImpl extends BaseAbstractService 
		implements IMemberAccountService {
	private static final Log log = LogFactory.getLog(MemberAccountServiceImpl.class);
	private IMemberAccountDao memberAccountDao;
	
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
		MemberAccount domain = new MemberAccount();
		// copy vo Properties to domain
		BeanUtils.copyProperties((MemberAccountVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return memberAccountDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return memberAccountDao.delete(id);
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

		MemberAccount domain = new MemberAccount();
		BeanUtils.copyProperties((MemberAccountVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return memberAccountDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		MemberAccount domain = new MemberAccount();
		BeanUtils.copyProperties((MemberAccountVo) vo, domain);
		List<MemberAccount> list = memberAccountDao.findByWhere(domain);
		MemberAccountVo returnVo = null;
		List<MemberAccountVo> voList = new ArrayList();
		for (MemberAccount temp : list) {
			returnVo = new MemberAccountVo();
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
		MemberAccount domain = new MemberAccount();
		BeanUtils.copyProperties((MemberAccountVo) vo, domain);
		Page page = memberAccountDao.findByWhere(domain,pageInfo);
		MemberAccountVo returnVo = null;
		List<MemberAccountVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			MemberAccount memberAccount=(MemberAccount)temp;
			returnVo = new MemberAccountVo();
			BeanUtils.copyProperties(memberAccount, returnVo);
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
		MemberAccount domain = memberAccountDao.findById(id);
		MemberAccountVo vo = null;
		if(domain != null){
		 vo = new MemberAccountVo();
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
		public AbstractVo findByCardNo(String cardNo) throws BusinessException {
			MemberAccount domain = memberAccountDao.findByCardNo(cardNo);
			MemberAccountVo vo = null;
			if(domain != null){
			 vo = new MemberAccountVo();
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
		 public AbstractVo findByMember(String memberId) throws DataAccessException
		 {
			 MemberAccount domain = memberAccountDao.findByMember(memberId);
			 MemberAccountVo vo = null;
			 if(domain != null){
				 vo = new MemberAccountVo();
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
		MemberAccountVo checkVo = (MemberAccountVo)vo;
		MemberAccountVo qryVo = new MemberAccountVo();
		
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
	 *  get memberAccountDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}

	/**
	 *  set memberAccountDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
	}
}