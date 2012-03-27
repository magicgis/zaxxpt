package com.hnatourism.club.member.rule.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.hnatourism.club.common.service.BaseAbstractService;
import com.hnatourism.club.member.rule.dao.IRuleConfigDao;
import com.hnatourism.club.member.rule.domain.RuleConfig;
import com.hnatourism.club.member.rule.service.IRuleConfigService;
import com.hnatourism.club.member.rule.vo.RuleConfigDetailVo;
import com.hnatourism.club.member.rule.vo.RuleConfigVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.exception.ValidateException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.DateUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.UserUtil;
import com.hnatourism.framework.web.vo.AbstractVo;
import com.hnatourism.framework.web.vo.BaseUserVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:规则配置表
 * 
 * 历史版本:
 *					2011-08-23 v1.0.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class RuleConfigServiceImpl extends BaseAbstractService 
		implements IRuleConfigService {
	private static final Log log = LogFactory.getLog(RuleConfigServiceImpl.class);
	private IRuleConfigDao ruleConfigDao;
	
	 /*
	 * 查询所有的分润规则
	 * 
	 */
	public RuleConfigDetailVo findAllRuleConfig(){
		RuleConfig domain = new RuleConfig();
		RuleConfigDetailVo domain_vo = new RuleConfigDetailVo();
		//domain.setType("PROFIT");
		domain.setSts("1");
		List<RuleConfig> list = ruleConfigDao.findByWhere(domain);
		for(RuleConfig vo:list){
			if(vo.getCode().equals("G_F_LOW_POINT")){
				domain_vo.setGflowpoint(vo.getValue());
			}else if(vo.getCode().equals("G_H_LOW_POINT")){
				domain_vo.setGhlowpoint(vo.getValue());
				
			}else if(vo.getCode().equals("G_F_PROFIT_POINT")){
				domain_vo.setGfprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("G_GF_PROFIT_POINT")){
				domain_vo.setGgfprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("G_L_PROFIT_POINT")){
				domain_vo.setGlprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("G_H_PROFIT_POINT")){
				domain_vo.setGhprofitpoint(vo.getValue());
				
			}else if(vo.getCode().equals("G_F_PROFIT_RATE")){
				domain_vo.setGfprofitrates(vo.getValue().split(":")[0]);
				domain_vo.setGfprofitratee(vo.getValue().split(":")[1]);
			}else if(vo.getCode().equals("G_H_PROFIT_RATE")){
				domain_vo.setGhprofitrates(vo.getValue().split(":")[0]);
				domain_vo.setGhprofitratee(vo.getValue().split(":")[1]);
			}else if(vo.getCode().equals("G_GF_PROFIT_RATE")){
				domain_vo.setGgfprofitrates(vo.getValue().split(":")[0]);
				domain_vo.setGgfprofitratee(vo.getValue().split(":")[1]);
			}else if(vo.getCode().equals("G_L_PROFIT_RATE")){
				domain_vo.setGlprofitrates(vo.getValue().split(":")[0]);
				domain_vo.setGlprofitratee(vo.getValue().split(":")[1]);
				
			}else if(vo.getCode().equals("I_F_PROFIT_POINT")){
				domain_vo.setIfprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("I_H_PROFIT_POINT")){
				domain_vo.setIhprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("I_GF_PROFIT_POINT")){
				domain_vo.setIgfprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("I_L_PROFIT_POINT")){
				domain_vo.setIlprofitpoint(vo.getValue());
				
			}else if(vo.getCode().equals("I_F_LOW_POINT")){
				domain_vo.setIflowpoint(vo.getValue());
			}else if(vo.getCode().equals("I_H_LOW_POINT")){
				domain_vo.setIhlowpoint(vo.getValue());
				
			}else if(vo.getCode().equals("I_F_M_PROFIT_POINT")){
				domain_vo.setIfmprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("I_H_M_PROFIT_POINT")){
				domain_vo.setIhmprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("I_GF_M_PROFIT_POINT")){
				domain_vo.setIgfmprofitpoint(vo.getValue());
			}else if(vo.getCode().equals("I_L_M_PROFIT_POINT")){
				domain_vo.setIlmprofitpoint(vo.getValue());
				
			}else if(vo.getCode().equals("I_F_PROFIT_RATE")){
				domain_vo.setIfprofitrates(vo.getValue().split(":")[0]);
				domain_vo.setIfprofitratee(vo.getValue().split(":")[1]);
			}else if(vo.getCode().equals("I_H_PROFIT_RATE")){
				domain_vo.setIhprofitrates(vo.getValue().split(":")[0]);
				domain_vo.setIhprofitratee(vo.getValue().split(":")[1]);
			}else if(vo.getCode().equals("I_GF_PROFIT_RATE")){
				domain_vo.setIgfprofitrates(vo.getValue().split(":")[0]);
				domain_vo.setIgfprofitratee(vo.getValue().split(":")[1]);
			}else if(vo.getCode().equals("I_L_PROFIT_RATE")){
				domain_vo.setIlprofitrates(vo.getValue().split(":")[0]);
				domain_vo.setIlprofitratee(vo.getValue().split(":")[1]);
			}
			
		}
		return domain_vo;
	 }
  /**
	 * 【新增】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public Object insert(AbstractVo vo) throws BusinessException {
	    BaseUserVo user = UserUtil.getUserVo();
	    //validate data
		  validateData(vo);
		  //validate uniqueness
		  if (!checkUniqueness(vo)) {
			  throw new BusinessException("notUnique");
		  }
      RuleConfig domain = new RuleConfig();
		  BeanUtils.copyProperties((RuleConfigVo) vo, domain);
		  //
		  domain.setCreateUser(user.getUsername());
		  domain.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
  		return ruleConfigDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return ruleConfigDao.delete(id);
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

	  RuleConfig domain = new RuleConfig();
		BeanUtils.copyProperties((RuleConfigVo) vo, domain);
		domain.setUpdateUser(user.getUsername());
		domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return ruleConfigDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
	  RuleConfig domain = new RuleConfig();
		BeanUtils.copyProperties((RuleConfigVo) vo, domain);
		List<RuleConfig> list = ruleConfigDao.findByWhere(domain);
		RuleConfigVo returnVo = null;
		List<RuleConfigVo> voList = new ArrayList();
		for (RuleConfig temp : list) {
			returnVo = new RuleConfigVo();
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
	  RuleConfig domain = new RuleConfig();
		BeanUtils.copyProperties((RuleConfigVo) vo, domain);
		Page page = ruleConfigDao.findByWhere(domain,pageInfo);
		RuleConfigVo returnVo = null;
		List<RuleConfigVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			RuleConfig ruleConfig=(RuleConfig)temp;
			returnVo = new RuleConfigVo();
			BeanUtils.copyProperties(ruleConfig, returnVo);
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
		RuleConfig domain = ruleConfigDao.findById(id);
		RuleConfigVo vo = null;
		if(domain != null){
		   vo = new RuleConfigVo();
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
		public List findByCrop(String crop) throws BusinessException {
			 List<RuleConfig> list = ruleConfigDao.findByCrop(crop);
			 List<RuleConfigVo> voList = new ArrayList();
			 RuleConfigVo returnVo = null;
			 for (RuleConfig temp : list) {
					returnVo = new RuleConfigVo();
					BeanUtils.copyProperties(temp, returnVo);
					voList.add(returnVo);
				}
			return voList;
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
    RuleConfigVo checkVo = (RuleConfigVo)vo;
	  
	  RuleConfigVo qryVo = new RuleConfigVo();
	  
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

	public IRuleConfigDao getRuleConfigDao() {
		return ruleConfigDao;
	}

	public void setRuleConfigDao(IRuleConfigDao ruleConfigDao) {
		this.ruleConfigDao = ruleConfigDao;
	}
}