package com.hnatourism.club.member.log.service.impl;

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
import com.hnatourism.club.member.log.dao.ILogOperateDao;
import com.hnatourism.club.member.log.service.ILogOperateService;
import com.hnatourism.club.member.log.domain.LogOperate;
import com.hnatourism.club.member.log.web.vo.LogOperateVo;
import com.hnatourism.club.common.service.BaseAbstractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员操作日志表
 * 
 * 历史版本:
 *					2011-10-17 v1.0.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class LogOperateServiceImpl extends BaseAbstractService 
		implements ILogOperateService {
	private static final Log log = LogFactory.getLog(LogOperateServiceImpl.class);
	private ILogOperateDao logOperateDao;
	
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
      LogOperate domain = new LogOperate();
		  BeanUtils.copyProperties((LogOperateVo) vo, domain);
		  //
		  domain.setCreateUser(user.getUsername());
		  domain.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
  		return logOperateDao.insert(domain);
	}
	
	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws BusinessException
	 */
	 @Override
	public int delete(String id) throws BusinessException {
		return logOperateDao.delete(id);
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

	  LogOperate domain = new LogOperate();
		BeanUtils.copyProperties((LogOperateVo) vo, domain);
//		domain.setUpdateUser(user.getUsername());
//		domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return logOperateDao.update(domain);
	}
	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	 @Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
	  LogOperate domain = new LogOperate();
		BeanUtils.copyProperties((LogOperateVo) vo, domain);
		List<LogOperate> list = logOperateDao.findByWhere(domain);
		LogOperateVo returnVo = null;
		List<LogOperateVo> voList = new ArrayList();
		for (LogOperate temp : list) {
			returnVo = new LogOperateVo();
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
	  LogOperate domain = new LogOperate();
		BeanUtils.copyProperties((LogOperateVo) vo, domain);
		Page page = logOperateDao.findByWhere(domain,pageInfo);
		LogOperateVo returnVo = null;
		List<LogOperateVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			LogOperate logOperate=(LogOperate)temp;
			returnVo = new LogOperateVo();
			BeanUtils.copyProperties(logOperate, returnVo);
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
		LogOperate domain = logOperateDao.findById(id);
		LogOperateVo vo = null;
		if(domain != null){
		   vo = new LogOperateVo();
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
    LogOperateVo checkVo = (LogOperateVo)vo;
	  
	  LogOperateVo qryVo = new LogOperateVo();
	  
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

	public ILogOperateDao getLogOperateDao() {
		return logOperateDao;
	}

	public void setLogOperateDao(ILogOperateDao logOperateDao) {
		this.logOperateDao = logOperateDao;
	}
}