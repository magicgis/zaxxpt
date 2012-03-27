package com.hnatourism.club.order.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.order.service.IOrderPointsExchangeService;
import com.hnatourism.club.order.web.vo.OrderPointsExchangeVo;
import com.hnatourism.club.personal.member.domain.MemberInfo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:积分兑换订单
 * 
 * 历史版本:
 *					2011-10-12 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class OrderPointsExchangeAction extends BaseAction {
	private static final Log log = LogFactory.getLog(OrderPointsExchangeAction.class);
	private IOrderPointsExchangeService orderPointsExchangeService;
    private OrderPointsExchangeVo orderPointsExchangeVo=new OrderPointsExchangeVo();
    private List<OrderPointsExchangeVo>  orderPointsExchangeVoList=new ArrayList<OrderPointsExchangeVo>();
    private  PageInfo pageInfo=new PageInfo();
    //剩余积分
    private Integer remainingPoints=0;
	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()  {
		if(UserUtil.getUser(getSession().getId())==null)
		{
			return "notlogin";
		}
	  try{
			orderPointsExchangeService.insert(orderPointsExchangeVo,this.getSession());
		}
		catch(BusinessException e){
				log.error("",e);
				e.printStackTrace();
		}
		catch(Exception e){
				log.error("",e);
				e.printStackTrace();
		}
		orderPointsExchangeVo=new OrderPointsExchangeVo();
		search();
		return "listPage";
	}
	
  /**
	 * 【删除】（系统生成方法）
	 */
	public String del(){
		try{
			orderPointsExchangeService.delete(orderPointsExchangeVo.getId());
			//orderPointsExchangeService.delete(orderPointsExchange);
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
		if(UserUtil.getUser(getSession().getId())==null)
		{
			return "notlogin";
		}
		try{
			orderPointsExchangeService.update(orderPointsExchangeVo,this.getSession());
		}
		catch(BusinessException e){
				log.error("",e);
				e.printStackTrace();
		}
		catch(Exception e){
				log.error("",e);
				e.printStackTrace();
		}
		orderPointsExchangeVo=new OrderPointsExchangeVo();
		search();
		return "listPage";
	}
	
  /**
	 * 
	 */
	public String search()  {
		if(UserUtil.getUser(getSession().getId())==null)
		{
			return "notlogin";
		}
		 try{
			 MemberInfoVo memberInfoVo=UserUtil.getUser(this.getSession().getId());
			 orderPointsExchangeVo.setCreateUser(memberInfoVo.getCode());
			 Page page= orderPointsExchangeService.findByWhere(orderPointsExchangeVo,pageInfo);
			 orderPointsExchangeVoList=(List<OrderPointsExchangeVo>) page.getData();
			 pageInfo=page.getPageInfo();
		 }
		 catch(BusinessException e){
				log.error("",e);
		 }
		 catch(Exception e){
			 e.printStackTrace();
				log.error("",e);
		 }
		 return "listPage";
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String toAdd(){
		if(UserUtil.getUser(getSession().getId())==null)
		{
			return "notlogin";
		}
		MemberInfoVo memberInfoVo=UserUtil.getUser(this.getSession().getId());
		try {
			remainingPoints=orderPointsExchangeService.getRemainingPoints(memberInfoVo);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			log.error(e);
			e.printStackTrace();
		}
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
	  	orderPointsExchangeService.findById(orderPointsExchangeVo.getId());
	  }
		catch(Exception e){
			log.error("",e);
		}
		return TO_VIEW;
	}
	
	
	
	public List<OrderPointsExchangeVo> getOrderPointsExchangeVoList() {
		return orderPointsExchangeVoList;
	}

	public void setOrderPointsExchangeVoList(
			List<OrderPointsExchangeVo> orderPointsExchangeVoList) {
		this.orderPointsExchangeVoList = orderPointsExchangeVoList;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public IOrderPointsExchangeService getOrderPointsExchangeService() {
		return orderPointsExchangeService;
	}

	public void setOrderPointsExchangeService(IOrderPointsExchangeService orderPointsExchangeService) {
		this.orderPointsExchangeService = orderPointsExchangeService;
	}
	
	public OrderPointsExchangeVo getOrderPointsExchangeVo() {
		return orderPointsExchangeVo;
	}

	public void setOrderPointsExchangeVo(OrderPointsExchangeVo orderPointsExchangeVo) {
		this.orderPointsExchangeVo = orderPointsExchangeVo;
	}

	public Integer getRemainingPoints() {
		return remainingPoints;
	}

	public void setRemainingPoints(Integer remainingPoints) {
		this.remainingPoints = remainingPoints;
	}
	
}