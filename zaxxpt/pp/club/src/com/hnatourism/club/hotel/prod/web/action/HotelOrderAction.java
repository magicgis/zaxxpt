//package com.hnatourism.club.hotel.prod.web.action;
//
//import com.hnatourism.framework.core.exception.BusinessException;
//import com.hnatourism.club.common.web.BaseAction;
//import com.hnatourism.club.hotel.api.service.IHotelOrderService;
//import com.hnatourism.club.hotel.prod.web.vo.HotelDetailVo;
//import com.hnatourism.club.hotel.prod.web.vo.HotelInfoVo;
//import com.hnatourism.club.hotel.prod.web.vo.HotelVo;
//import com.hnatourism.club.personal.member.service.IMemberAccountService;
//import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// * 项目名称:海航旅业B2C系统系统系统
// * 
// * 功能描述:酒店订单
// * 
// * 历史版本:
// * 
// * @author 苏忆 20110905
// * 
// */
//@SuppressWarnings("unchecked")
//public class HotelOrderAction extends BaseAction {
//	// 酒店订单详情
//	private HotelVo hotelVo = new HotelVo();
//	private HotelInfoVo hotel = new HotelInfoVo();
//	// 查询接口
//	IHotelOrderService iHotelOrderService;
//
//	/*
//	 * 加载订单详情 20110905
//	 */
//	@Override
//	public String toSearch() {
//		HotelInfoVo vo = new HotelInfoVo();
////		vo.setCode("001825360");
////		vo.setSource("android");
//		hotelVo = iHotelOrderService.findHotelOrderById(vo);
//		hotel = hotelVo.getResultBean();
//		return "orderDetail";
//	}
//
//	/*
//	 * 更改订单状态 20110905
//	 */
//	@Override
//	public String toModify() {
//		HotelInfoVo vo = new HotelInfoVo();
////		vo.setCode("001825360");
////		vo.setSource("android");
//		hotelVo = iHotelOrderService.updateHotelOrderSts(vo);
//		return "orderDetail";
//	}
//
//	@Override
//	public String add() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String del() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String modify() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String search() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String toAdd() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String toView() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public IHotelOrderService getiHotelOrderService() {
//		return iHotelOrderService;
//	}
//
//	public void setiHotelOrderService(IHotelOrderService iHotelOrderService) {
//		this.iHotelOrderService = iHotelOrderService;
//	}
//
//	public HotelVo getHotelVo() {
//		return hotelVo;
//	}
//
//	public void setHotelVo(HotelVo hotelVo) {
//		this.hotelVo = hotelVo;
//	}
//
//	public HotelInfoVo getHotel() {
//		return hotel;
//	}
//
//	public void setHotel(HotelInfoVo hotel) {
//		this.hotel = hotel;
//	}
//
//}
