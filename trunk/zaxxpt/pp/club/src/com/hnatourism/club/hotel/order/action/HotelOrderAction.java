package com.hnatourism.club.hotel.order.action;


import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.hotel.api.service.IHotelApiManager;
import com.hnatourism.club.hotel.api.service.IHotelNewApiManager;
import com.hnatourism.club.hotel.api.service.IHotelOrderService;
import com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderCancelVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailsReusltVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailsVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店订单action
 * 
 * 历史版本: 2011-9-5 v1.0.0 (lixun) 创建
 * 
 */
public class HotelOrderAction extends BaseAction{
	
	/**
	 * 酒店新版接口api
	 */
	private IHotelNewApiManager hotelNewApiManager;
	/**
	 * 接受hotel订单code
	 */
	private String code;
	/**
	 * 接受订单sts
	 */
	private String sts;
	/**
	 * 新酒店订单详情vo
	 */
	private HotelOrderDetailsVo hotelOrderDetailsVo;
	
	
	/**
	 * 查看订单详情
	 */
	private static final String VIEW_DETAILS = "viewDefails";
	
	/**
	 * 重定向订单详情
	 */
	private static final String R_VIEW_DETAILS="redirectViewDefails";
	
//	private static final String FORWORD_VIEW_DETAILS="forwordViewDetails";
	
	/**
	 * 酒店api
	 */
	private IHotelApiManager hotelApiManager;
	
	/**
	 * 酒店service
	 */
	private IHotelOrderService hotelOrderService;
	/**
	 * 查询条件封装
	 */
	private QueryHotelOrderVo queryVo;
	
	/**
	 * 向前台输出提示信息
	 */
	private String tipInfo;
	
	//保存提示信息的临时变量
	private static String tipTemp;

	/**
	 * 
	 * @description 【查看订单详情】
	 * @return
	 * @createTime 2011-9-5 上午11:17:44
	 * @author lixun
	 */
	public String viewDetails(){
//		http://210.51.165.170:9180/web/phone/order/hotel/order_hotel_detail.jsp?code=001825360&source=android&key=xxxx&syssource=xxxxxx
		setTipInfo(tipTemp);
		// gc
		tipTemp=null;
		try {
			MemberInfoVo user=UserUtil.getUser(getSession().getId());
			if(user == null ){
				return "notlogin";
			}
			HotelOrderDetailQueryVo qryVo = new HotelOrderDetailQueryVo();
			qryVo.setCode(code);
			qryVo.setKey("51666");
			HotelOrderDetailsReusltVo reusltVo = hotelNewApiManager.findOrderDetails(qryVo);
			hotelOrderDetailsVo = reusltVo.getResultBean();
			//GC
			qryVo = null ;
			
		} catch (Exception e) {
			log.error("查看订单详情失败....");
			//操作失败跳转到
			return VIEW_DETAILS;
		}
		return VIEW_DETAILS;
	}

	/**
	 * 
	 * @description 【取消订单】
	 * @return
	 * @createTime 2011-9-6 下午12:01:07
	 * @author lixun
	 */
	public String cancelOrder(){
		setTipInfo("");
//		http://210.51.165.170:9180/web/phone/order/hotel/order_hotel_cancel.jsp?memberId=3e2af952b29a421a8235779f14613f2a&code=001825360&source=android
		try {
			MemberInfoVo user=UserUtil.getUser(getSession().getId());
			if(user == null ){
				return "notlogin";
			}
			HotelOrderCancelVo cancelVo = new HotelOrderCancelVo();
			cancelVo.setMemberId(user.getId());
			cancelVo.setKey("51666");
			cancelVo.setCode(code);
			HotelOrderDetailsReusltVo resultVo = hotelNewApiManager.cancelOrder(cancelVo);
			hotelOrderDetailsVo = resultVo.getResultBean();
			//eidt by lixun 添加提示消息 
			tipTemp=hotelOrderDetailsVo.getRmk();
			//GC
			cancelVo = null;
		} catch (Exception e) {
			log.error("取消订单失败...");
			tipTemp="取消订单失败";
			return R_VIEW_DETAILS;
		}
		return R_VIEW_DETAILS;
	}
	
	/**
	 * 
	 * @description 会员确认订单
	 * @return
	 * @createTime 2011-10-8 下午02:44:38
	 * @author lixun
	 */
	public String verifyHotelOrder(){
		try {
			MemberInfoVo user=UserUtil.getUser(getSession().getId());
			if(user == null ){
				return "notlogin";
			}
			queryVo.setMemberId(user.getId());
			tipTemp = hotelOrderService.verifyHotelOrder(queryVo,user,getSession().getAttribute("createUser").toString());
			code=queryVo.getCode();
		} catch (BusinessException e) {
			log.error("确认订单失败...");
			tipTemp=e.getMessage();
			return R_VIEW_DETAILS;
		}
		return R_VIEW_DETAILS;
	}
	/**
	 * 
	 * @description 【退订酒店订单】
	 * @return
	 * @createTime 2011-9-7 下午05:27:48
	 * @author lixun
	 */
	public String unsubscribeOrder(){
		try {
			MemberInfoVo user=UserUtil.getUser(getSession().getId());
			if(user == null ){
				return "notlogin";
			}
			queryVo.setMemberId(user.getId());
//			hotelOrderDetailsVo=hotelApiManager.unsubscribeHotelOrder(queryVo);
		} catch (Exception e) {
			log.error("退订订单失败");
			tipTemp="退订订单失败";
			return R_VIEW_DETAILS;
		}
		return R_VIEW_DETAILS;
	}
	
	public IHotelApiManager getHotelApiManager() {
		return hotelApiManager;
	}

	public void setHotelApiManager(IHotelApiManager hotelApiManager) {
		this.hotelApiManager = hotelApiManager;
	}

	public QueryHotelOrderVo getQueryVo() {
		return queryVo;
	}

	public void setQueryVo(QueryHotelOrderVo queryVo) {
		this.queryVo = queryVo;
	}


	/**
	 * @return the hotelOrderDetailsVo
	 */
	public HotelOrderDetailsVo getHotelOrderDetailsVo() {
		return hotelOrderDetailsVo;
	}

	/**
	 * @param hotelOrderDetailsVo the hotelOrderDetailsVo to set
	 */
	public void setHotelOrderDetailsVo(HotelOrderDetailsVo hotelOrderDetailsVo) {
		this.hotelOrderDetailsVo = hotelOrderDetailsVo;
	}

	public void setTipInfo(String tipInfo) {
		this.tipInfo = tipInfo;
	}

	public String getTipInfo() {
		return tipInfo;
	}

	public IHotelOrderService getHotelOrderService() {
		return hotelOrderService;
	}

	public void setHotelOrderService(IHotelOrderService hotelOrderService) {
		this.hotelOrderService = hotelOrderService;
	}

	/**
	 * @return the hotelNewApiManager
	 */
	public IHotelNewApiManager getHotelNewApiManager() {
		return hotelNewApiManager;
	}

	/**
	 * @param hotelNewApiManager the hotelNewApiManager to set
	 */
	public void setHotelNewApiManager(IHotelNewApiManager hotelNewApiManager) {
		this.hotelNewApiManager = hotelNewApiManager;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the sts
	 */
	public String getSts() {
		return sts;
	}

	/**
	 * @param sts the sts to set
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
}
