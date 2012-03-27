package com.hnatourism.club.lounge.prod.action;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.lounge.prod.service.ILoungeLimitService;
import com.hnatourism.club.lounge.prod.vo.LoungeLimitVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室不预定时间维护
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeLimitAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(LoungeLimitAction.class);
	// service
	private ILoungeLimitService loungeLimitService;
	// vo
  	private LoungeLimitVo loungeLimitVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			loungeLimitService.insert(loungeLimitVo);
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
			loungeLimitService.delete(loungeLimitVo.getId());
			//loungeLimitService.delete(loungeLimit);
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
			loungeLimitService.update(loungeLimitVo);
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
		 	  loungeLimitService.findByWhere(loungeLimitVo);
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
	  	loungeLimitService.findById(loungeLimitVo.getId());
	  }
		catch(Exception e){
			log.error("",e);
		}
		return TO_VIEW;
	}

	/**
	 * get Servive
	 * @return
	 */
	public ILoungeLimitService getLoungeLimitService() {
		return loungeLimitService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setLoungeLimitService(ILoungeLimitService loungeLimitService) {
		this.loungeLimitService = loungeLimitService;
	}

	/**
	 * get Vo
	 * @return
	 */
	public LoungeLimitVo getLoungeLimitVo() {
		return loungeLimitVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setLoungeLimitVo(LoungeLimitVo loungeLimitVo) {
		this.loungeLimitVo = loungeLimitVo;
	}
}