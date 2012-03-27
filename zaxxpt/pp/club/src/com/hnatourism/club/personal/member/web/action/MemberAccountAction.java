package com.hnatourism.club.personal.member.web.action;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员账户表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberAccountAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(MemberAccountAction.class);
	// service
	private IMemberAccountService memberAccountService;
	// vo
  	private MemberAccountVo memberAccountVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			memberAccountService.insert(memberAccountVo);
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
			memberAccountService.delete(memberAccountVo.getId());
			//memberAccountService.delete(memberAccount);
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
			memberAccountService.update(memberAccountVo);
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
		 	  memberAccountService.findByWhere(memberAccountVo);
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
	  	memberAccountService.findById(memberAccountVo.getId());
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
	public IMemberAccountService getMemberAccountService() {
		return memberAccountService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setMemberAccountService(IMemberAccountService memberAccountService) {
		this.memberAccountService = memberAccountService;
	}

	/**
	 * get Vo
	 * @return
	 */
	public MemberAccountVo getMemberAccountVo() {
		return memberAccountVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setMemberAccountVo(MemberAccountVo memberAccountVo) {
		this.memberAccountVo = memberAccountVo;
	}
}