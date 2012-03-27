package com.hnatourism.club.personal.member.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import com.hnatourism.club.personal.member.dao.IMemberPassengerDao;
import com.hnatourism.club.personal.member.service.IMemberPassengerService;
import com.hnatourism.club.personal.member.domain.MemberPassenger;
import com.hnatourism.club.personal.member.web.vo.MemberPassengerVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员常用旅客信息
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class MemberPassengerServiceImpl extends BaseAbstractService 
		implements IMemberPassengerService {
	private static final Log log = LogFactory.getLog(MemberPassengerServiceImpl.class);
	private IMemberPassengerDao memberPassengerDao;
	
	/**
	 * 【新增】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public Object insert(AbstractVo vo) throws BusinessException {
		
		MemberPassenger domain = new MemberPassenger();
		BeanUtils.copyProperties((MemberPassengerVo) vo, domain);
		return memberPassengerDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return memberPassengerDao.delete(id);
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
		MemberPassenger domain = new MemberPassenger();
		BeanUtils.copyProperties((MemberPassengerVo) vo, domain);
		
		return memberPassengerDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		MemberPassenger domain = new MemberPassenger();
		BeanUtils.copyProperties((MemberPassengerVo) vo, domain);
		List<MemberPassenger> list = memberPassengerDao.findByWhere(domain);
		MemberPassengerVo returnVo = null;
		List<MemberPassengerVo> voList = new ArrayList();
		for (MemberPassenger temp : list) {
			returnVo = new MemberPassengerVo();
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
		public Page findByMember(String memberId,int currentPage) throws BusinessException {
			Page page=new Page();
			List<MemberPassengerVo> mplist=new ArrayList<MemberPassengerVo>();
			List mplist_temp = memberPassengerDao.findByMember(memberId);
			PageInfo pageinfo=new PageInfo();
			pageinfo.setRowsOfPage(20);
			
			int sum=mplist_temp.size();
			int pagesum=0;
			if(sum%pageinfo.getRowsOfPage()>0)
			{
				pagesum=sum/pageinfo.getRowsOfPage()+1;
			}
			else
			{
				pagesum=sum/pageinfo.getRowsOfPage();
			}
			int start=(currentPage-1)*pageinfo.getRowsOfPage();
			int end=0;
			if(currentPage==pagesum||pagesum==0)
			{
				end=sum;
			}
			else
			{
				end=currentPage*pageinfo.getRowsOfPage();
			}
			
			for(int i=start;i<end;i++)
			{
				MemberPassengerVo mp=new MemberPassengerVo();
				BeanUtils.copyProperties(mplist_temp.get(i), mp);
				
				mplist.add(mp);
			}
			
			pageinfo.setTotalPageCount(pagesum);
			pageinfo.setTotalRowCount(sum);
			pageinfo.setCurrentPageNum(currentPage);
			page.setData(mplist);
			page.setPageInfo(pageinfo);
			
			return page;
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
		MemberPassenger domain = new MemberPassenger();
		BeanUtils.copyProperties((MemberPassengerVo) vo, domain);
		Page page = memberPassengerDao.findByWhere(domain,pageInfo);
		MemberPassengerVo returnVo = null;
		List<MemberPassengerVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			MemberPassenger memberPassenger=(MemberPassenger)temp;
			returnVo = new MemberPassengerVo();
			BeanUtils.copyProperties(memberPassenger, returnVo);
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
		MemberPassenger domain = memberPassengerDao.findById(id);
		MemberPassengerVo vo = null;
		if(domain != null){
		 vo = new MemberPassengerVo();
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
		MemberPassengerVo checkVo = (MemberPassengerVo)vo;
		MemberPassengerVo qryVo = new MemberPassengerVo();
		
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
	 *  get memberPassengerDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public IMemberPassengerDao getMemberPassengerDao() {
		return memberPassengerDao;
	}

	/**
	 *  set memberPassengerDao
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void setMemberPassengerDao(IMemberPassengerDao memberPassengerDao) {
		this.memberPassengerDao = memberPassengerDao;
	}
}