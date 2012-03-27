package com.hnatourism.club.personal.member.web.action;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.order.service.IOrderPointsExchangeService;
import com.hnatourism.club.pay.IPayInterfaceApiServer;
import com.hnatourism.club.pay.PayVo;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.service.IOrderBillService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员常用旅客信息
 * 
 * 历史版本:2011-08-23 v1.1.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderBillAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(OrderBillAction.class);
	// service
	private IOrderBillService orderBillService;
	private IMemberAccountService memberAccountServ;
	private IPayInterfaceApiServer payInterfaceApiServ;
	private IOrderPointsExchangeService orderPointsExchangeService;
  	private List orderbilllist;
  	private PageInfo pageInfo;
  	private PayVo payInfo;
  	private int page;
  	private Integer currentlyTradingPoint=0;

	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()
	{
		return "success";
	}
	
  	/**
	 * 【删除】（系统生成方法）
	 */
	public String del()
	{
		return "success";
	}
	
	/**
	 * 【修改】（系统生成方法）
	 * @return
	 */
	public String modify()
	{
		return "success";
	}
	
  	/**
	 * 
	 */
	public String search()
	{
		 try
		 {
			 MemberInfoVo vo = UserUtil.getUser(getSession().getId());
			 if(vo==null)
			 {
				 return "notlogin";
			 }
			 
			 MemberAccountVo account=vo.getMemberAccount();
			 Page pageresult=orderBillService.findByAccount(account.getCardNo(),page==0?1:page);
			 orderbilllist=pageresult.getData();
			 pageInfo=pageresult.getPageInfo();
			 if(payInterfaceApiServ==null){
				 System.out.println("payInterfaceApiServ is null");
			 /////////////////////////////////////
				 
			 
			 }
			 if(account==null){
				 System.out.println("account is null");
			 }
			 if(account.getCardNo()==null){
				 System.out.println("account.getCardNo() is null");
			 }
			 
			 //余额
			 payInfo=payInterfaceApiServ.findBalance(account.getCardNo());
			 //当前正在出售的积分
			 currentlyTradingPoint=orderPointsExchangeService.getRemainingPoints("findC_T_PointByUserAccount", account.getCardNo());
			 //余额-正在出售的积分
			// payInfo.setAcctBal(String.valueOf(new BigDecimal(payInfo.getAcctBal()).subtract(new BigDecimal(currentlyTradingPoint))));
		 }
		 catch(Exception e)
		 {
			 log.error("");
			 e.printStackTrace();
		 }
		return "success";
	}
	
	/**
	 * 
	 * @return
	 */
	public String toAdd()
	{
		return "success";
	}
	
	/**
	 * 
	 * @return
	 */
	public String toModify()
	{
		return "success";
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
	  	//memberPassengerService.findById(memberPassengerVo.getId());
	  }
		catch(Exception e){
			log.error("",e);
		}
		return TO_VIEW;
	}
	/**
	 * @return the orderBillService
	 */
	public IOrderBillService getOrderBillService() {
		return orderBillService;
	}

	/**
	 * @param orderBillService the orderBillService to set
	 */
	public void setOrderBillService(IOrderBillService orderBillService) {
		this.orderBillService = orderBillService;
	}

	public List getOrderbilllist() {
		return orderbilllist;
	}

	public void setOrderbilllist(List orderbilllist) {
		this.orderbilllist = orderbilllist;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public IMemberAccountService getMemberAccountServ() {
		return memberAccountServ;
	}

	public void setMemberAccountServ(IMemberAccountService memberAccountServ) {
		this.memberAccountServ = memberAccountServ;
	}

	public PayVo getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(PayVo payInfo) {
		this.payInfo = payInfo;
	}

	public IPayInterfaceApiServer getPayInterfaceApiServ() {
		return payInterfaceApiServ;
	}

	public void setPayInterfaceApiServ(IPayInterfaceApiServer payInterfaceApiServ) {
		this.payInterfaceApiServ = payInterfaceApiServ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public IOrderPointsExchangeService getOrderPointsExchangeService() {
		return orderPointsExchangeService;
	}

	public void setOrderPointsExchangeService(
			IOrderPointsExchangeService orderPointsExchangeService) {
		this.orderPointsExchangeService = orderPointsExchangeService;
	}

	public Integer getCurrentlyTradingPoint() {
		return currentlyTradingPoint;
	}

	public void setCurrentlyTradingPoint(Integer currentlyTradingPoint) {
		this.currentlyTradingPoint = currentlyTradingPoint;
	}

	
}