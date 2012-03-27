package com.hnatourism.club.golf.prod.action;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.golf.order.service.IOrderGolfSubRunService;
import com.hnatourism.club.golf.order.vo.GolfOrderLogVo;
import com.hnatourism.club.golf.order.vo.GolfOrderPlayVo;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.golf.order.vo.OrderContactVo;
import com.hnatourism.club.golf.prod.service.IGolfConfirmService;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.club.pay.PayVo;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:订单确认，提交
 * 
 * 历史版本: ${2011.8.4} v1.0.0 (${苏忆}) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class GolfConfirmAction extends BaseAction
{
	private List<GolfOrderVo> orderlist;  //练习场列表
	
	private static final long serialVersionUID = 8922017842741135405L;
	@Autowired
	private IGolfConfirmService golfConfirmServ;
	//订单对象
	private GolfOrderVo  order;    
	private GolfSiteVo golfSiteVo;
	private GolfInfoVo golfInfoVo;
	private GolfPriceVo golfPriceVo;
	private List<GolfOrderLogVo> golfOrderLogVoList;
	private String orderId ;
	private String priceid;
	private String expOrderId;
	private String amount;
	private String action;
	private List<GolfOrderPlayVo>  golfOrderPlayVoList;
	private String message="";
	private OrderContactVo orderContactVo=new OrderContactVo();
	private IOrderGolfSubRunService orderGolfSubRunService;
	
	/**
	 * 球场订单显示
	 */
	public String showFormalOrder()
	{
		try
		{
		Map<String, Object> result=golfConfirmServ.findOrderById(orderId);
		List<GolfOrderVo> orderList=(List<GolfOrderVo>)result.get("golfOrderVo"); 
		order=orderList.get(0);
		 golfSiteVo=order.getGolfSiteVo();
		 golfInfoVo=order.getGolfInfoVo();
		 golfPriceVo=order.getGolfPriceVo();
		 orderContactVo=order.getOrderContactVo();
		 golfOrderLogVoList=order.getGolfOrderLogVoList();
		 golfOrderPlayVoList=order.getGolfOrderPlayVoList();
		//order=(GolfOrderVo)result.get("golfOrderVo");
		//orderlist=(List<GolfOrderVo>)result.get("golfConfirmVolist");
		//order=result.get("golfOrderVo");
		}
		catch (Exception e)
		{
			message="操作失败";
			log.error("查询高尔夫订单失败",e);
			return "success";
		}
		
		return "success";
	}
	
	/**
	 * 更新订单状态
	 */
	public String updateOrderState()
	{
		message="";
		try
		{
			if(UserUtil.getUser(getSession().getId())==null)
			{
				return "notlogin";
			}
		if("confirmExp".equalsIgnoreCase(action)){
			message=golfConfirmServ.updateOrder(orderId,expOrderId,amount,action,getSession().getAttribute("createUser").toString(),11);
			//修改 	lixun 	加入操作提示信息
			if(message!=null&&!"false".equalsIgnoreCase(message)){
				message="确认订单成功";
			}else{
				message="确认订单失败";
			}
		}else {
			Map<String, Object> result=golfConfirmServ.findOrderById(orderId);
			List<GolfOrderVo> orderList=(List<GolfOrderVo>)result.get("golfOrderVo"); 
			order=orderList.get(0);
			golfPriceVo=order.getGolfPriceVo();
//			message="操作已成功";
			
			if(golfPriceVo!=null&&order!=null){
				Long amoutL=Long.valueOf(golfPriceVo.getAmount())+Long.valueOf(order.getTotalBall());
				amount=amoutL.toString();
			}
			if("confirm".equals(action)){
				if(order.getGolfSiteVo().getType()==1)
				{//练习场,直接进行确认的支付分润操作
					PayVo payVo=orderGolfSubRunService.payAndSubRun(orderId,getSession().getAttribute("createUser").toString());
					if("success".equalsIgnoreCase(payVo.getRespCode())){
						message=golfConfirmServ.updateOrder(orderId,priceid,amount,action,getSession().getAttribute("createUser").toString(),2);
					}else{
						if(null!=payVo.getErrMsg()&&(payVo.getErrMsg().indexOf("<")<0)){
							message=payVo.getErrMsg()+",确认订单失败";
						}else{
							message="确认订单失败";
						}
					}
				}else{//球场
					message=golfConfirmServ.updateOrder(orderId,priceid,amount,action,getSession().getAttribute("createUser").toString(),11);
				}
				//修改 	lixun 	加入操作提示信息
				if("true".equalsIgnoreCase(message)){
					message="确认订单成功";
				}else if("flase".equalsIgnoreCase(message)){
					message="确认订单失败";
				}
			}else{
				message=golfConfirmServ.updateOrder(orderId,priceid,amount,action,getSession().getAttribute("createUser").toString(),0);
				//修改 	lixun 	加入操作提示信息
				if(message!=null&&!"false".equalsIgnoreCase(message)){
					message="取消订单成功";
				}else{
					message="取消订单失败";
				}
			}
		}
		}
		catch (Exception e)
		{
			message="操作失败";
			log.error("修改高尔夫订单状态失败",e);
			e.printStackTrace();
		}
//		showFormalOrder();
		getSession().setAttribute("golfStatusUpdateMsg", message);
		return "updateSuccess";
	}
	
	
	
	
	public void setGolfConfirmServ(IGolfConfirmService golfConfirmServ) {
		this.golfConfirmServ = golfConfirmServ;
	}
	public GolfSiteVo getGolfSiteVo() {
		return golfSiteVo;
	}

	public void setGolfSiteVo(GolfSiteVo golfSiteVo) {
		this.golfSiteVo = golfSiteVo;
	}

	public GolfInfoVo getGolfInfoVo() {
		return golfInfoVo;
	}

	public void setGolfInfoVo(GolfInfoVo golfInfoVo) {
		this.golfInfoVo = golfInfoVo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GolfPriceVo getGolfPriceVo() {
		return golfPriceVo;
	}

	public void setGolfPriceVo(GolfPriceVo golfPriceVo) {
		this.golfPriceVo = golfPriceVo;
	}

	public List<GolfOrderLogVo> getGolfOrderLogVoList() {
		return golfOrderLogVoList;
	}

	public void setGolfOrderLogVoList(List<GolfOrderLogVo> golfOrderLogVoList) {
		this.golfOrderLogVoList = golfOrderLogVoList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public OrderContactVo getOrderContactVo() {
		return orderContactVo;
	}

	public void setOrderContactVo(OrderContactVo orderContactVo) {
		this.orderContactVo = orderContactVo;
	}

	public IGolfConfirmService getGolfConfirmServ() {
		return golfConfirmServ;
	}

	/**
	 * 页面属性
	 */
	public GolfOrderVo getOrder() {
		return order;
	}

	public List<GolfOrderVo> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<GolfOrderVo> orderlist) {
		this.orderlist = orderlist;
	}

	public void setOrder(GolfOrderVo order) { 
		this.order = order;
	}


	public String getPriceid() {
		return priceid;
	}

	public void setPriceid(String priceid) {
		this.priceid = priceid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public List<GolfOrderPlayVo> getGolfOrderPlayVoList() {
		return golfOrderPlayVoList;
	}

	public IOrderGolfSubRunService getOrderGolfSubRunService() {
		return orderGolfSubRunService;
	}

	public void setOrderGolfSubRunService(
			IOrderGolfSubRunService orderGolfSubRunService) {
		this.orderGolfSubRunService = orderGolfSubRunService;
	}

	public void setGolfOrderPlayVoList(List<GolfOrderPlayVo> golfOrderPlayVoList) {
		this.golfOrderPlayVoList = golfOrderPlayVoList;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setExpOrderId(String expOrderId) {
		this.expOrderId = expOrderId;
	}

	public String getExpOrderId() {
		return expOrderId;
	}

	
 

}
