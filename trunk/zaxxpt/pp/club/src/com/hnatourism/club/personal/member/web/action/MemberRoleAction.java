package com.hnatourism.club.personal.member.web.action;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员角色表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberRoleAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(MemberRoleAction.class);
	// service
	private IMemberRoleService memberRoleService;
	// vo
  	private MemberRoleVo memberRoleVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			memberRoleService.insert(memberRoleVo);
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
			memberRoleService.delete(memberRoleVo.getId());
			//memberRoleService.delete(memberRole);
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
			memberRoleService.update(memberRoleVo);
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
		 	  memberRoleService.findByWhere(memberRoleVo);
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
	  	memberRoleService.findById(memberRoleVo.getId());
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
	public IMemberRoleService getMemberRoleService() {
		return memberRoleService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setMemberRoleService(IMemberRoleService memberRoleService) {
		this.memberRoleService = memberRoleService;
	}

	/**
	 * get Vo
	 * @return
	 */
	public MemberRoleVo getMemberRoleVo() {
		return memberRoleVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setMemberRoleVo(MemberRoleVo memberRoleVo) {
		this.memberRoleVo = memberRoleVo;
	}
}