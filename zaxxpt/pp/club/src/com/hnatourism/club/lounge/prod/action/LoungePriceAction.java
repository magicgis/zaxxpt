package com.hnatourism.club.lounge.prod.action;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.lounge.prod.service.ILoungePriceService;
import com.hnatourism.club.lounge.prod.vo.LoungePriceVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室项目价格表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LoungePriceAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(LoungePriceAction.class);
	// service
	private ILoungePriceService loungePriceService;
	// vo
  	private LoungePriceVo loungePriceVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			loungePriceService.insert(loungePriceVo);
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
			loungePriceService.delete(loungePriceVo.getId());
			//loungePriceService.delete(loungePrice);
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
			loungePriceService.update(loungePriceVo);
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
		 	  loungePriceService.findByWhere(loungePriceVo);
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
	  	loungePriceService.findById(loungePriceVo.getId());
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
	public ILoungePriceService getLoungePriceService() {
		return loungePriceService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setLoungePriceService(ILoungePriceService loungePriceService) {
		this.loungePriceService = loungePriceService;
	}

	/**
	 * get Vo
	 * @return
	 */
	public LoungePriceVo getLoungePriceVo() {
		return loungePriceVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setLoungePriceVo(LoungePriceVo loungePriceVo) {
		this.loungePriceVo = loungePriceVo;
	}
}