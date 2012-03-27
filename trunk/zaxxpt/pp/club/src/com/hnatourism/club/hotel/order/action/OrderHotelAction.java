//package com.hnatourism.club.hotel.order.action;
//
//
//import com.hnatourism.club.common.util.UserUtil;
//import com.hnatourism.club.hotel.api.service.IHotelApiManager;
//import com.hnatourism.club.hotel.order.vo.HotelOrderDetailsVo;
//import com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo;
//import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
//import com.hnatourism.framework.web.action.BaseAction;
//
///**
// * 项目名称:海航旅业B2C系统系统
// * 
// * 功能描述:酒店订单action
// * 
// * 历史版本: 2011-9-5 v1.0.0 (lixun) 创建
// * 
// */
//public class OrderHotelAction extends BaseAction{
//	
//	/**
//	 * 查看订单详情
//	 */
//	private static final String VIEW_DETAILS = "viewDefails";
//	
////	private static final String FORWORD_VIEW_DETAILS="forwordViewDetails";
//	
//	/**
//	 * 酒店api
//	 */
//	private IHotelApiManager hotelApiManager;
//	/**
//	 * 查询条件封装
//	 */
//	private QueryHotelOrderVo queryVo;
//	
//	/**
//	 * 酒店订单详情vo
//	 */
//	private HotelOrderDetailsVo hotelOrderDetailsVo;
//	
//	/**
//	 * 向前台输出提示信息
//	 */
//	private String tipInfo;
//
//	/**
//	 * 
//	 * @description 【查看订单详情】
//	 * @return
//	 * @createTime 2011-9-5 上午11:17:44
//	 * @author lixun
//	 */
//	public String viewDetails(){
////		http://210.51.165.170:9180/web/phone/order/hotel/order_hotel_detail.jsp?code=001825360&source=android
//		try {
//			MemberInfoVo user=UserUtil.getUser(getSession().getId());
//			if(user == null ){
//				return "notlogin";
//			}
//			queryVo.setMemberId(user.getId());
//			hotelOrderDetailsVo=hotelApiManager.findHotelOrderDetails(queryVo);
//		} catch (Exception e) {
//			log.error("查看订单详情失败....");
//			//操作失败跳转到
//			return VIEW_DETAILS;
//		}
//		return VIEW_DETAILS;
//	}
//
//	/**
//	 * 
//	 * @description 【取消订单】
//	 * @return
//	 * @createTime 2011-9-6 下午12:01:07
//	 * @author lixun
//	 */
//	public String cancelOrder(){
////		http://210.51.165.170:9180/web/phone/order/hotel/order_hotel_cancel.jsp?memberId=3e2af952b29a421a8235779f14613f2a&code=001825360&source=android
//		try {
//			MemberInfoVo user=UserUtil.getUser(getSession().getId());
//			if(user == null ){
//				return "notlogin";
//			}
//			queryVo.setMemberId(user.getId());
//			hotelOrderDetailsVo=hotelApiManager.cancelHotelOrder(queryVo);
//		} catch (Exception e) {
//			log.error("取消订单失败...");
//			setTipInfo("取消订单失败");
//			viewDetails();
//		}
//		return VIEW_DETAILS;
//	}
//	
//	/**
//	 * 
//	 * @description 【退订酒店订单】
//	 * @return
//	 * @createTime 2011-9-7 下午05:27:48
//	 * @author lixun
//	 */
//	public String unsubscribeOrder(){
//		try {
//			MemberInfoVo user=UserUtil.getUser(getSession().getId());
//			if(user == null ){
//				return "notlogin";
//			}
//			queryVo.setMemberId(user.getId());
////			hotelOrderDetailsVo=hotelApiManager.unsubscribeHotelOrder(queryVo);
//		} catch (Exception e) {
//			log.error("退订订单失败...");
//			setTipInfo("退订订单失败...");
//			viewDetails();
//		}
//		return VIEW_DETAILS;
//	}
//	
//	public IHotelApiManager getHotelApiManager() {
//		return hotelApiManager;
//	}
//
//	public void setHotelApiManager(IHotelApiManager hotelApiManager) {
//		this.hotelApiManager = hotelApiManager;
//	}
//
//	public QueryHotelOrderVo getQueryVo() {
//		return queryVo;
//	}
//
//	public void setQueryVo(QueryHotelOrderVo queryVo) {
//		this.queryVo = queryVo;
//	}
//
//	public HotelOrderDetailsVo getHotelOrderDetailsVo() {
//		return hotelOrderDetailsVo;
//	}
//
//	public void setHotelOrderDetailsVo(HotelOrderDetailsVo hotelOrderDetailsVo) {
//		this.hotelOrderDetailsVo = hotelOrderDetailsVo;
//	}
//
//	public void setTipInfo(String tipInfo) {
//		this.tipInfo = tipInfo;
//	}
//
//	public String getTipInfo() {
//		return tipInfo;
//	}
//
//}
