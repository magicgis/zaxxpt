package com.hnatourism.club.personal.member.web.action;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.personal.member.service.IMemberStsService;
import com.hnatourism.club.personal.member.web.vo.MemberStsVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员状态表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberStsAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(MemberStsAction.class);
	// service
	private IMemberStsService memberStsService;
	// vo
  	private MemberStsVo memberStsVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			memberStsService.insert(memberStsVo);
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
			memberStsService.delete(memberStsVo.getId());
			//memberStsService.delete(memberSts);
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
			memberStsService.update(memberStsVo);
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
		 	  memberStsService.findByWhere(memberStsVo);
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
	  	memberStsService.findById(memberStsVo.getId());
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
	public IMemberStsService getMemberStsService() {
		return memberStsService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setMemberStsService(IMemberStsService memberStsService) {
		this.memberStsService = memberStsService;
	}

	/**
	 * get Vo
	 * @return
	 */
	public MemberStsVo getMemberStsVo() {
		return memberStsVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setMemberStsVo(MemberStsVo memberStsVo) {
		this.memberStsVo = memberStsVo;
	}
}