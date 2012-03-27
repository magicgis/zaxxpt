package com.hnatourism.club.lounge.prod.action;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.lounge.prod.service.ILoungeRoomService;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:休息室房间表
 * 
 * 历史版本:
 *					2011-08-10 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class LoungeRoomAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(LoungeRoomAction.class);
	// service
	private ILoungeRoomService loungeRoomService;
	// vo
  	private LoungeRoomVo loungeRoomVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			loungeRoomService.insert(loungeRoomVo);
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
			loungeRoomService.delete(loungeRoomVo.getId());
			//loungeRoomService.delete(loungeRoom);
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
			loungeRoomService.update(loungeRoomVo);
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
		 	  loungeRoomService.findByWhere(loungeRoomVo);
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
	  	loungeRoomService.findById(loungeRoomVo.getId());
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
	public ILoungeRoomService getLoungeRoomService() {
		return loungeRoomService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setLoungeRoomService(ILoungeRoomService loungeRoomService) {
		this.loungeRoomService = loungeRoomService;
	}

	/**
	 * get Vo
	 * @return
	 */
	public LoungeRoomVo getLoungeRoomVo() {
		return loungeRoomVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setLoungeRoomVo(LoungeRoomVo loungeRoomVo) {
		this.loungeRoomVo = loungeRoomVo;
	}
}