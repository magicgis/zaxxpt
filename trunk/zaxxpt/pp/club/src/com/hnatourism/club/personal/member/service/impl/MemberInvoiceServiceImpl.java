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
import com.hnatourism.club.personal.member.dao.IMemberInvoiceDao;
import com.hnatourism.club.personal.member.service.IMemberInvoiceService;
import com.hnatourism.club.personal.member.domain.MemberInvoice;
import com.hnatourism.club.personal.member.web.vo.MemberInvoiceVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员发票表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class MemberInvoiceServiceImpl extends BaseAbstractService 
		implements IMemberInvoiceService {
	private static final Log log = LogFactory.getLog(MemberInvoiceServiceImpl.class);
	private IMemberInvoiceDao memberInvoiceDao;
	
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
		MemberInvoice domain = new MemberInvoice();
		// copy vo Properties to domain
		BeanUtils.copyProperties((MemberInvoiceVo) vo, domain);
		// createUser
		//domain.setCreateUser(user.getUsername());
		// createTime
		//domain.setCreateTime(DateUtils.getCerrentDate());
		return memberInvoiceDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return memberInvoiceDao.delete(id);
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

		MemberInvoice domain = new MemberInvoice();
		BeanUtils.copyProperties((MemberInvoiceVo) vo, domain);
		//domain.setUpdateUser(user.getUsername());
		//domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return memberInvoiceDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		MemberInvoice domain = new MemberInvoice();
		BeanUtils.copyProperties((MemberInvoiceVo) vo, domain);
		List<MemberInvoice> list = memberInvoiceDao.findByWhere(domain);
		MemberInvoiceVo returnVo = null;
		List<MemberInvoiceVo> voList = new ArrayList();
		for (MemberInvoice temp : list) {
			returnVo = new MemberInvoiceVo();
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
		MemberInvoice domain = new MemberInvoice();
		BeanUtils.copyProperties((MemberInvoiceVo) vo, domain);
		Page page = memberInvoiceDao.findByWhere(domain,pageInfo);
		MemberInvoiceVo returnVo = null;
		List<MemberInvoiceVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			MemberInvoice memberInvoice=(MemberInvoice)temp;
			returnVo = new MemberInvoiceVo();
			BeanUtils.copyProperties(memberInvoice, returnVo);
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
		MemberInvoice domain = memberInvoiceDao.findById(id);
		MemberInvoiceVo vo = null;
		if(domain != null){
		 vo = new MemberInvoiceVo();
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
		MemberInvoiceVo checkVo = (MemberInvoiceVo)vo;
		MemberInvoiceVo qryVo = new MemberInvoiceVo();
		
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
	 *  get memberInvoiceDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public IMemberInvoiceDao getMemberInvoiceDao() {
		return memberInvoiceDao;
	}

	/**
	 *  set memberInvoiceDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setMemberInvoiceDao(IMemberInvoiceDao memberInvoiceDao) {
		this.memberInvoiceDao = memberInvoiceDao;
	}
}