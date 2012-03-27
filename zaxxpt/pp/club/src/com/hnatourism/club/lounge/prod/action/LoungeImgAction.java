package com.hnatourism.club.lounge.prod.action;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.lounge.prod.service.ILoungeImgService;
import com.hnatourism.club.lounge.prod.vo.LoungeImgVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室产品图片表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeImgAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(LoungeImgAction.class);
	// service
	private ILoungeImgService loungeImgService;
	// vo
  	private LoungeImgVo loungeImgVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			loungeImgService.insert(loungeImgVo);
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
			loungeImgService.delete(loungeImgVo.getId());
			//loungeImgService.delete(loungeImg);
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
			loungeImgService.update(loungeImgVo);
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
		 	  loungeImgService.findByWhere(loungeImgVo);
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
	  	loungeImgService.findById(loungeImgVo.getId());
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
	public ILoungeImgService getLoungeImgService() {
		return loungeImgService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setLoungeImgService(ILoungeImgService loungeImgService) {
		this.loungeImgService = loungeImgService;
	}

	/**
	 * get Vo
	 * @return
	 */
	public LoungeImgVo getLoungeImgVo() {
		return loungeImgVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setLoungeImgVo(LoungeImgVo loungeImgVo) {
		this.loungeImgVo = loungeImgVo;
	}
}