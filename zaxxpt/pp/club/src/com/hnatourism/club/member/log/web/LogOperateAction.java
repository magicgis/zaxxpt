package com.hnatourism.club.member.log.web;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.member.log.service.ILogOperateService;
import com.hnatourism.club.member.log.web.vo.LogOperateVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员操作日志表
 * 
 * 历史版本:
 *					2011-10-17 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LogOperateAction extends BaseAction {
	private static final Log log = LogFactory.getLog(LogOperateAction.class);
	private ILogOperateService logOperateService;
  private LogOperateVo logOperateVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			logOperateService.insert(logOperateVo);
		}
		catch(BusinessException e){
				log.error("",e);
		}
		catch(Exception e){
				log.error("",e);
		}
		return TO_SEARCH;
	}
	
  /**
	 * 【删除】（系统生成方法）
	 */
	public String del(){
		try{
			logOperateService.delete(logOperateVo.getId());
			//logOperateService.delete(logOperate);
		}
		catch(BusinessException e){
				log.error("",e);
		}
		catch(Exception e){
				log.error("",e);
		}
		return TO_SEARCH;
	}
	
	/**
	 * 【修改】（系统生成方法）
	 * @return
	 */
	public String modify()  {
		try{
			logOperateService.update(logOperateVo);
		}
		catch(BusinessException e){
				log.error("",e);
		}
		catch(Exception e){
				log.error("",e);
		}
		return TO_SEARCH;
	}
	
  /**
	 * 
	 */
	public String search()  {
		 try{
		 	  logOperateService.findByWhere(logOperateVo);
		 }
		 catch(BusinessException e){
				log.error("",e);
		 }
		 catch(Exception e){
				log.error("",e);
		 }
		 return TO_SEARCH;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toAdd(){
		return TO_ADD;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toModify(){
		return TO_MODIFY;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toSearch(){
		return TO_SEARCH;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toView(){
		try{
	  	logOperateService.findById(logOperateVo.getId());
	  }
		catch(Exception e){
			log.error("",e);
		}
		return TO_VIEW;
	}
	
	public ILogOperateService getLogOperateService() {
		return logOperateService;
	}

	public void setLogOperateService(ILogOperateService logOperateService) {
		this.logOperateService = logOperateService;
	}
	
	public LogOperateVo getLogOperateVo() {
		return logOperateVo;
	}

	public void setLogOperateVo(LogOperateVo logOperateVo) {
		this.logOperateVo = logOperateVo;
	}
}