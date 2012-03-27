package com.hnatourism.club.personal.member.web.action;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.personal.member.service.IMemberInvoiceService;
import com.hnatourism.club.personal.member.web.vo.MemberInvoiceVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员发票表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberInvoiceAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(MemberInvoiceAction.class);
	// service
	private IMemberInvoiceService memberInvoiceService;
	// vo
  	private MemberInvoiceVo memberInvoiceVo;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
	  try{
			memberInvoiceService.insert(memberInvoiceVo);
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
			memberInvoiceService.delete(memberInvoiceVo.getId());
			//memberInvoiceService.delete(memberInvoice);
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
			memberInvoiceService.update(memberInvoiceVo);
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
		 	  memberInvoiceService.findByWhere(memberInvoiceVo);
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
	  	memberInvoiceService.findById(memberInvoiceVo.getId());
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
	public IMemberInvoiceService getMemberInvoiceService() {
		return memberInvoiceService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setMemberInvoiceService(IMemberInvoiceService memberInvoiceService) {
		this.memberInvoiceService = memberInvoiceService;
	}

	/**
	 * get Vo
	 * @return
	 */
	public MemberInvoiceVo getMemberInvoiceVo() {
		return memberInvoiceVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setMemberInvoiceVo(MemberInvoiceVo memberInvoiceVo) {
		this.memberInvoiceVo = memberInvoiceVo;
	}
}