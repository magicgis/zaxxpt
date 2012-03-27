package com.hnatourism.club.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.common.service.BaseAbstractService;
import com.hnatourism.club.common.service.ICustomerProfitService;
import com.hnatourism.club.common.service.ISysWeatherService;
import com.hnatourism.club.member.rule.dao.IRuleConfigDao;
import com.hnatourism.club.member.rule.domain.RuleConfig;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;
import com.hnatourism.framework.core.service.AbstractService;
import com.hnatourism.framework.utils.DateFormatUtils;
import com.hnatourism.framework.utils.ListUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:客户分润
 * 
 * 历史版本:2010-08-30 v1.0.0 (gaojie) 创建:
 * 
 */
public class CustomerProfitServiceImpl implements ICustomerProfitService
{
	private IRuleConfigDao ruleConfigDao;
	private IMemberAccountDao memberAccountDao;
	
	
	/**
	 * 返回折扣值
	 * @param cityCode
	 * @return
	 */
	public Map<String, Object> cal_profit(Double price,String memberId,String goods)
	{
		int rate=0;
		int rate_share=0;
		int rate_low=0;
		int privilegeType=1;
		Map<String, Object> result=new HashMap<String, Object>();
		
		if(!memberId.equalsIgnoreCase("noid"))
		{
			MemberAccount account=memberAccountDao.findByMember(memberId);
			RuleConfig rc_share=null;
			RuleConfig rc_low=null;

			if(account!=null)
			{
				if(account.getPrivilegeType()!=null)
				{
					privilegeType=account.getPrivilegeType().equalsIgnoreCase("minus")?1:2;
				}
				if(account.getRole().equalsIgnoreCase("gold"))
				{
					if(goods.equalsIgnoreCase("gf"))
					{
						rc_share=ruleConfigDao.findByCode("G_GF_PROFIT_POINT");
					}
					else if(goods.equalsIgnoreCase("l"))
					{
						rc_share=ruleConfigDao.findByCode("G_L_PROFIT_POINT");
					}
				}
				else if(account.getRole().equalsIgnoreCase("PLATINUM"))
				{
					if(goods.equalsIgnoreCase("gf"))
					{
						rc_share=ruleConfigDao.findByCode("I_GF_PROFIT_POINT");
						rc_low=ruleConfigDao.findByCode("I_GF_LOW_POINT");
					}
					else if(goods.equalsIgnoreCase("l"))
					{
						rc_share=ruleConfigDao.findByCode("I_L_PROFIT_POINT");
						rc_low=ruleConfigDao.findByCode("I_L_LOW_POINT");
					}
				}
				else if(account.getRole().equalsIgnoreCase("DIAMOND"))
				{
					if(goods.equalsIgnoreCase("gf"))
					{
						rc_share=ruleConfigDao.findByCode("I_GF_PROFIT_POINT");
						rc_low=ruleConfigDao.findByCode("I_GF_LOW_POINT");
					}
					else if(goods.equalsIgnoreCase("l"))
					{
						rc_share=ruleConfigDao.findByCode("I_L_PROFIT_POINT");
						rc_low=ruleConfigDao.findByCode("I_L_LOW_POINT");
					}
				}
			}
			
			if(rc_share==null||rc_share.getValue().equalsIgnoreCase("all"))
			{
				rate_share=0;
			}
			else
			{
				rate_share=Integer.parseInt(rc_share.getValue());
			}
			if(rc_low==null||rc_low.getValue().equalsIgnoreCase("all"))
			{
				rate_low=0;
			}
			else
			{
				rate_low=Integer.parseInt(rc_low.getValue());
			}
			if(rate_share<rate_low)
			{
				rate=rate_low;
			}
			else
			{
				rate=rate_share;
			}
		}
		
		if(privilegeType==1)
		{
			if(price!=null&&!price.toString().equalsIgnoreCase(""))
			{
				price=price*(10-rate)/10;
			}
		}
		
		result.put("rate", rate);
		result.put("privilegeType", privilegeType);
		result.put("price", price!=null?price.floatValue():0);
		
		return result;
	}
	
	
	public Map<String, Object> anti_cal_profit(Double price,String memberId,String goods)
	{
		int rate=0;
		int privilegeType=0;
		Map<String, Object> result=new HashMap<String, Object>();
		
		if(!memberId.equalsIgnoreCase("noid"))
		{
			MemberAccount account=memberAccountDao.findByMember(memberId);
			RuleConfig rc=null;

			if(account!=null)
			{
				if(account.getPrivilegeType()!=null)
				{
					privilegeType=account.getPrivilegeType().equalsIgnoreCase("minus")?1:2;
				}
				if(account.getRole().equalsIgnoreCase("gold"))
				{
					rc=ruleConfigDao.findByCode("G_L_PROFIT_POINT");
				}
				else if(account.getRole().equalsIgnoreCase("PLATINUM"))
				{
					rc=ruleConfigDao.findByCode("I_L_PROFIT_POINT");
				}
				else if(account.getRole().equalsIgnoreCase("DIAMOND"))
				{
					rc=ruleConfigDao.findByCode("I_L_PROFIT_POINT");
				}
			}
			
			if(rc==null||rc.getValue().equalsIgnoreCase("all"))
			{
				rate=0;
			}
			else
			{
				rate=Integer.parseInt(rc.getValue());
			}
		}
		
		if(price!=null&&!price.toString().equalsIgnoreCase(""))
		{
			price=price*rate/10;
		}
		
		result.put("rate", rate);
		result.put("privilegeType", privilegeType);
		result.put("price", price);
		
		return result;
	}
	
	
	public IRuleConfigDao getRuleConfigDao() {
		return ruleConfigDao;
	}
	public void setRuleConfigDao(IRuleConfigDao ruleConfigDao) {
		this.ruleConfigDao = ruleConfigDao;
	}
	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}
	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
	}
}
