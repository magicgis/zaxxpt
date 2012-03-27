package com.hnatourism.club.order.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.service.BaseAbstractService;
import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.order.dao.IOrderPointsExchangeDao;
import com.hnatourism.club.order.domain.OrderPointsExchange;
import com.hnatourism.club.order.service.IOrderPointsExchangeService;
import com.hnatourism.club.order.web.vo.OrderPointsExchangeVo;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.dao.IMemberInfoDao;
import com.hnatourism.club.personal.member.dao.impl.MemberAccountDaoImpl;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.domain.MemberInfo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.domain.BaseUser;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.exception.ValidateException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.web.vo.AbstractVo;
import com.hnatourism.framework.web.vo.BaseUserVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:积分兑换订单
 * 
 * 历史版本:
 *					2011-10-12 v1.0.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class OrderPointsExchangeServiceImpl extends BaseAbstractService 
		implements IOrderPointsExchangeService {
	private static final Log log = LogFactory.getLog(OrderPointsExchangeServiceImpl.class);
	private IOrderPointsExchangeDao orderPointsExchangeDao;
	private IMemberAccountDao memberAccountDao;
	private IMemberInfoDao memberInfoDao;
	
  /**
	 * 【新增】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public Object insert(AbstractVo vo,HttpSession session) throws BusinessException {
	      MemberInfoVo memberInfo = UserUtil.getUser(session.getId());
		  MemberAccount memberAccount=memberAccountDao.findByMember(memberInfo.getId());
		  
      OrderPointsExchange domain = new OrderPointsExchange();
		  BeanUtils.copyProperties((OrderPointsExchangeVo) vo, domain);
		  //
		  domain.setId(SnoGerUtil.getUUID());
		  domain.setCode(SnoGerUtil.getOrderNo());
		  domain.setContact(memberInfo.getMobile());
		  domain.setSts(String.valueOf(1));
		  domain.setOperateSts(String.valueOf(0));
		  domain.setCreateUser(memberInfo.getCode());
		  domain.setOwner(memberAccount.getCardNo());
		  domain.setOrganizationId(memberAccount.getOrganizationId());
		  domain.setCreateTime(com.hnatourism.club.common.util.DateUtils.getCurrentDate());
  		return orderPointsExchangeDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return orderPointsExchangeDao.delete(id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public int update(AbstractVo vo) throws BusinessException {
	  //BaseUserVo user = UserUtil.getUserVo();
	  //validate data
//		validateData(vo);
//
//	  OrderPointsExchange domain = new OrderPointsExchange();
//		BeanUtils.copyProperties((OrderPointsExchangeVo) vo, domain);
//		//domain.setUpdateUser(user.getUsername());
//		domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		//return orderPointsExchangeDao.update(domain);
		 return 0;
	}
	
	 public int update(AbstractVo vo,HttpSession session) throws BusinessException {
		 MemberInfoVo memberInfo = UserUtil.getUser(session.getId());
		  //validate data
			
		  OrderPointsExchange domain = new OrderPointsExchange();
			BeanUtils.copyProperties((OrderPointsExchangeVo) vo, domain);
			domain.setUpdateUser(memberInfo.getUsername());
			domain.setUpdateTime(com.hnatourism.club.common.util.DateUtils.getCurrentDate());
			return orderPointsExchangeDao.update(domain);
		}
		
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
	  OrderPointsExchange domain = new OrderPointsExchange();
		BeanUtils.copyProperties((OrderPointsExchangeVo) vo, domain);
		List<OrderPointsExchange> list = orderPointsExchangeDao.findByWhere(domain);
		OrderPointsExchangeVo returnVo = null;
		List<OrderPointsExchangeVo> voList = new ArrayList();
		for (OrderPointsExchange temp : list) {
			returnVo = new OrderPointsExchangeVo();
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
	  OrderPointsExchange domain = new OrderPointsExchange();
		BeanUtils.copyProperties((OrderPointsExchangeVo) vo, domain);
		Page page = orderPointsExchangeDao.findByWhere(domain,pageInfo);
		OrderPointsExchangeVo returnVo = null;
		List<OrderPointsExchangeVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			OrderPointsExchange orderPointsExchange=(OrderPointsExchange)temp;
			returnVo = new OrderPointsExchangeVo();
			BeanUtils.copyProperties(orderPointsExchange, returnVo);
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
		OrderPointsExchange domain = orderPointsExchangeDao.findById(id);
		OrderPointsExchangeVo vo = null;
		if(domain != null){
		   vo = new OrderPointsExchangeVo();
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
    OrderPointsExchangeVo checkVo = (OrderPointsExchangeVo)vo;
	  
	  OrderPointsExchangeVo qryVo = new OrderPointsExchangeVo();
	  
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

	public IOrderPointsExchangeDao getOrderPointsExchangeDao() {
		return orderPointsExchangeDao;
	}

	public void setOrderPointsExchangeDao(IOrderPointsExchangeDao orderPointsExchangeDao) {
		this.orderPointsExchangeDao = orderPointsExchangeDao;
	}

	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}

	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
	}

	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	@Override
	public Object insert(AbstractVo vo) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取用户可兑换积分
	 */
	@Override
	public Integer getRemainingPoints(MemberInfoVo memberInfoVo)
			throws BusinessException {
		// TODO Auto-generated method stub
		Integer remainingPoints=0; //剩余积分
		
		Integer countPoint=0;//总积分
		Integer consumerPoint=0;//消费使用积分
		Integer consumerRPoint=0;//退款返还积分
		Integer currentlyTradingPoint=0;//当前正在交易积分
		 MemberAccount memberAccount=memberAccountDao.findByMember(memberInfoVo.getId());
		
		 countPoint=orderPointsExchangeDao.getRemainingPoints("findCountPointByUserAccount", memberAccount.getCardNo());
		 consumerPoint=orderPointsExchangeDao.getRemainingPoints("findConsumerPointNMByUserAccount", memberAccount.getCardNo());
		 consumerRPoint=orderPointsExchangeDao.getRemainingPoints("findConsumerRPointByUserAccount", memberAccount.getCardNo());
		 currentlyTradingPoint=orderPointsExchangeDao.getRemainingPoints("findC_T_PointByUserAccount", memberAccount.getCardNo());
		 
		 if(countPoint==null)countPoint=0;
		 if(consumerPoint==null)consumerPoint=0;
		 if(consumerRPoint==null)consumerRPoint=0;
		 if(currentlyTradingPoint==null)currentlyTradingPoint=0;
		 
		remainingPoints=countPoint-consumerPoint+consumerRPoint-currentlyTradingPoint;
		return remainingPoints;
	}

	@Override
	public Integer getRemainingPoints(String methond, String cardNo)
			throws BusinessException {
		// TODO Auto-generated method stub
		return orderPointsExchangeDao.getRemainingPoints(methond, cardNo);
	}
	
}