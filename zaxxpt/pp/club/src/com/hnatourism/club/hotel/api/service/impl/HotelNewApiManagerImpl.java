package com.hnatourism.club.hotel.api.service.impl;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.hotel.api.service.HotelRequestHelper;
import com.hnatourism.club.hotel.api.service.IHotelNewApiManager;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelBookResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelBookVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelDetailsQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelDetailsResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelGuaranteeQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelGuaranteeResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderCancelVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailsReusltVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderStsUpdateResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderStsUpdateVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelQueryResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomResultVo;
import com.hnatourism.framework.core.service.AbstractService;
import com.hnatourism.framework.utils.StringUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:新版酒店接口管理实现类
 * 
 * 历史版本: 2011-08-09 v1.0.0
 * 
 */
public class HotelNewApiManagerImpl extends AbstractService implements
		IHotelNewApiManager {
	// /**
	// * 日志
	// */
	// private static final Log log =
	// LogFactory.getLog(HotelNewApiManagerImpl.class);
	@Override
	public HotelBookResultVo bookHotel(HotelBookVo bookVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_BOOK;
		StringBuffer params = new StringBuffer();
		// 设置请求参数
		params.append("memberId=").append(bookVo.getMemberId());// memberId 必填项
		params.append("&isFirst=").append(bookVo.getIsFirst());// isFirst 必填项
		// 是否是新用户预订，1为是，0为否
		// 俱乐部的应该全都是0，必须登录才能预订，存在账号
		if (!StringUtils.isBlank(bookVo.getRmk())) {
			params.append("&rmk=").append(bookVo.getRmk());// 备注
		}
		params.append("&totalMoney=").append(bookVo.getTotalMoney());// totalMoney
		// 必填
		// 订单金额
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);// 必填
		// 酒店房型信息
		params.append("&hcode=").append(bookVo.getHcode());// 必填 酒店编码
		params.append("&rcode=").append(bookVo.getRcode());// 必填 房型编码
		params.append("&idate=").append(bookVo.getIdate());// 必填 入住时间 YYYY-MM-DD
		params.append("&odate=").append(bookVo.getOdate());// 必填 离店时间YYYY-MM-DD
		params.append("&adate=").append(bookVo.getAdate());// 必填 预计到点时间
		// HH:MM-HH:MM
		params.append("&pnum=").append(bookVo.getPnum());// 必填 入住人数
		params.append("&pname=").append(bookVo.getPname());// 必填 入住人姓名
		// 多人使用逗号“，“分隔
		params.append("&contact.name=").append(bookVo.getContact_name());// 必填
		// 联系人
		params.append("&contact.phone=").append(bookVo.getContact_phone());// 必填
		// 联系电话
		params.append("&contact.mobile=").append(bookVo.getContact_mobile());// 必填
		// 预订手机号
		params.append("&contact.email=").append(bookVo.getContact_email());// 必填
		// 电子邮箱
		// 发票信息
		params.append("&invoice.needtype=")
				.append(bookVo.getInvoice_needtype());// 必填 是否需要发票 Y 是 ，N否
		if (!StringUtils.isBlank(bookVo.getInvoice_needtype())
				&& bookVo.getInvoice_needtype().toUpperCase().equals("Y")) {
			params.append("&invoice.head=").append(bookVo.getInvoice_head());// 发票抬头
			// 个人
			params.append("&invoice.person=")
					.append(bookVo.getInvoice_person());// 发票收件人
			params.append("&invoice.mobile=")
					.append(bookVo.getInvoice_mobile());// 发票收件人电话
			params.append("&invoice.address=").append(
					bookVo.getInvoice_address());// 发票收件地址
			params.append("&invoice.zipcode=").append(
					bookVo.getInvoice_zipcode());// 发票邮编
			params.append("&invoice.deliverytype=").append(
					bookVo.getInvoice_deliverytype());// 邮寄方式
		}

		// params.append("&key=").append(bookVo.getKey());//必填
		// params.append("&syssource=").append(bookVo.getSyssource());//选填 系统来源

		params.append("&roomPlanCode=").append(bookVo.getRoomPlanCode());// 必填
		// 房型计划编码
		params.append("&payType=").append(bookVo.getPayType());// 必填
		// 支付类型:1-现付,2-预付

		if (!StringUtils.isBlank(bookVo.getCredit_name())) {
			params.append("&credit.name=").append(bookVo.getCredit_name());// 持卡人姓名
		}
		if (!StringUtils.isBlank(bookVo.getCredit_cardNum())) {
			params.append("&credit.cardNum=")
					.append(bookVo.getCredit_cardNum());// 信用卡号码
		}
		if (!StringUtils.isBlank(bookVo.getCredit_cardType())) {
			params.append("&credit.cardType=").append(
					bookVo.getCredit_cardType());// 信用卡卡种
		}
		if (!StringUtils.isBlank(bookVo.getCredit_expireDate())) {
			params.append("&credit.expireDate=").append(
					bookVo.getCredit_expireDate());// 信用卡有效期
		}
		if (!StringUtils.isBlank(bookVo.getCredit_idNum())) {
			params.append("&credit.idNum=").append(bookVo.getCredit_idNum());// 证件号码
		}
		if (!StringUtils.isBlank(bookVo.getCredit_idType())) {
			params.append("&credit.idType=").append(bookVo.getCredit_idType());// 证件类型
		}
		params.append("&customCommission=")
				.append(bookVo.getCustomCommission());// 必填 渠道自定义佣金比例
		// System.out.println(urlStr+"?"+params);
		HotelBookResultVo vo = (HotelBookResultVo) HotelRequestHelper
				.findObjectByApi(urlStr, params, HotelBookResultVo.class);

		return vo;
	}

	@Override
	public HotelOrderDetailsReusltVo cancelOrder(HotelOrderCancelVo cancelVo) {
		// 实例请求：http://210.51.165.170:9180/web/phone/order/hotel/order_hotel_cancel.jsp?memberId=3e2af952b29a421a8235779f14613f2a&code=001825360&source=android&key=xxxx&syssource=xxxxxx
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_ORDER_CANCEL;
		StringBuffer params = new StringBuffer();
		params.append("memberId=").append(cancelVo.getMemberId());// 必选 memberId
		params.append("&code=").append(cancelVo.getCode());// 必选 code
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);// 必选
		// params.append("&key=").append(cancelVo.getKey());// 必选key 俱乐部 不需要传递

		HotelOrderDetailsReusltVo vo = (HotelOrderDetailsReusltVo) HotelRequestHelper
				.findObjectByApi(urlStr, params,
						HotelOrderDetailsReusltVo.class);
		return vo;
	}

	@Override
	public HotelDetailsResultVo findHotelDetails(HotelDetailsQueryVo queryVo) {
		// TODO 查看酒店详情
		// http://210.51.165.170:9180/web/phone/prod/hotel/viewHotel.jsp?hotelCode=0000130486&idate=2011-10-25&odate=2011-10-26&source=iphone&key=iphone20110907
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_VIEWHOTEL;
		StringBuffer params = new StringBuffer();
		params.append("hotelCode=").append(queryVo.getHotelCode());// hotelCode
		// 酒店code 必填
		params.append("&idate=").append(queryVo.getIdate());// idate 入住日期 必填
		params.append("&odate=").append(queryVo.getOdate());// odate 离店日期 必填
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);// source
		// 客户端类型_客户端名称_渠道_版本号来源，如android_hotel_xhlx_v1.0
		// 必填
		// params.append("?key=").append(queryVo.getCity());//key 新华旅行网分配的唯一授权码
		// 必填 51666 //暂时没有验证
		// if(queryVo.getSyssource()!=null){
		// params.append("&syssource=").append(queryVo.getSyssource());//系统来源 选填
		// }
		HotelDetailsResultVo hotelVo = (HotelDetailsResultVo) HotelRequestHelper
				.findObjectByApi(urlStr, params, HotelDetailsResultVo.class);
		return hotelVo;
	}

	@Override
	public HotelQueryResultVo findHotelList(HotelQueryVo queryVo) {
		// TODO 查询酒店
		// 示例请求地址
		// http://210.51.165.170:9180/web/phone/prod/hotel/searchAllHotels.jsp?city=0101&idate=2011-10-23&odate=2011-10-24&citySource=hbe&pageSize=10&pageNum=0&sortField=distance&sortTyso=asc&x=116.3256&y=39.928&source=iphone
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_SEARCHALL;
		StringBuffer params = new StringBuffer();
		params.append("city=").append(queryVo.getCity());// city 城市code 必填
		params.append("&citySource=").append("hna");// citySource 城市code来源
		// 必填,设置成hbe即可
		params.append("&idate=").append(queryVo.getIdate());// idate 入住日期 必填
		params.append("&odate=").append(queryVo.getOdate());// odate 离店日期 必填
		if (StringUtils.isNotEmpty(queryVo.getPageSize())) {
			params.append("&pageSize=").append(queryVo.getPageSize());// 分页大小 选填
			params.append("&pageNum=").append(queryVo.getPageNum());// 选填,从0开始
		}
		if (StringUtils.isNotEmpty(queryVo.getSortField())) {
			params.append("&sortField=").append(queryVo.getSortField());// sortField
			// 排序字段
			// 选填,price----------价格,star-----------星级,distance-----距离(必须传当前客户端的GPS经纬度坐标)
			params.append("&pageNum=").append(queryVo.getPageNum());// 选填,从0开始
			params.append("&sortType=").append(queryVo.getSortType());// sortType
			// 排序方式
			// 选填asc-----------升序,desc---------降序
		}
		if (StringUtils.isNotEmpty(queryVo.getFilterAreaType())) {
			params.append("&filterAreaType=").append(
					queryVo.getFilterAreaType());// sortField 排序字段
			// 选填,price----------价格,star-----------星级,distance-----距离(必须传当前客户端的GPS经纬度坐标)
			params.append("&filterAreaCode=").append(
					queryVo.getFilterAreaCode());// 选填,从0开始
		}
		if (StringUtils.isNotEmpty(queryVo.getQword())) {
			params.append("&qword=").append(queryVo.getQword());// qword 酒店查询关键字
			// 选填,
		}
		if (StringUtils.isNotEmpty(queryVo.getFilterPrice())) {
			params.append("&filterPrice=").append(queryVo.getFilterPrice());
		}
		if (StringUtils.isNotEmpty(queryVo.getFilterStar())) {
			params.append("&filterStar=").append(queryVo.getFilterStar());
		}
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);// source
		// 来源 必填
		// params.append("&key=").append(queryVo.getKey());//新华旅行网分配的唯一授权码 必填
		// 51666 //暂时没有验证
		// if(queryVo.getSyssource()!=null){
		// params.append("&syssource=").append(queryVo.getSyssource());//系统来源 选填
		// }
		HotelQueryResultVo hotelVo = (HotelQueryResultVo) HotelRequestHelper
				.findObjectByApi(urlStr, params, HotelQueryResultVo.class);
		return hotelVo;
	}

	@Override
	public HotelRoomResultVo findHotelRoomList(HotelRoomQueryVo queryVo) {
		// TODO 查询房型房态
		// http://210.51.165.170:9180/web/phone/prod/hotel/searchRoom.jsp?city=0101&hotelCode=0000131359&idate=2011-06-01&odate=2011-06-03&source=android&key=xxxx&syssource=xxxxxx
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_ROOM_SEARCH;
		StringBuffer params = new StringBuffer();
		if (queryVo.getCity() != null) {
			params.append("city=").append(queryVo.getCity());// city 城市code
		}
		params.append("&hotelCode=").append(queryVo.getHotelCode());// hotelCode
		// 酒店code 必填
		params.append("&citySource=").append(queryVo.getCitySource());// citySource
		// 城市code来源
		// 必填
		params.append("&idate=").append(queryVo.getIdate());// idate 入住日期 必填
		params.append("&odate=").append(queryVo.getOdate());// odate 离店日期 必填
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);// source
		// 客户端类型_客户端名称_渠道_版本号来源，如android_hotel_xhlx_v1.0
		// 必填
		// params.append("&key=").append(queryVo.getCity());//key 新华旅行网分配的唯一授权码
		// 必填 51666 //暂时没有验证
		// if(queryVo.getSyssource()!=null){
		// params.append("&syssource=").append(queryVo.getSyssource());//系统来源 选填
		// }
		HotelRoomResultVo hotelVo = (HotelRoomResultVo) HotelRequestHelper
				.findObjectByApi(urlStr, params, HotelRoomResultVo.class);
		return hotelVo;
	}

	@Override
	public HotelOrderDetailsReusltVo findOrderDetails(
			HotelOrderDetailQueryVo queryVo) {
		// TODO 查看订单详情
		// http://210.51.165.170:9180/web/phone/order/hotel/order_hotel_detail.jsp?code=001825360&source=android&key=xxxx&syssource=xxxxxx
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_ORDER_DETAIL;
		StringBuffer params = new StringBuffer();
		params.append("code=").append(queryVo.getCode());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		// params.append("&key=").append(queryVo.getKey());//必选 key
		// 新华旅行网分配的唯一授权码 必填 51666
		// if(queryVo.getSyssource()!=null){
		// params.append("&syssource=").append(queryVo.getSyssource());//系统来源 选填
		// }
		HotelOrderDetailsReusltVo hotelVo = (HotelOrderDetailsReusltVo) HotelRequestHelper
				.findObjectByApi(urlStr, params,
						HotelOrderDetailsReusltVo.class);
		return hotelVo;
	}

	@Override
	public HotelOrderResultVo findOrderList(HotelOrderQueryVo queryVo) {
		// TODO 查询订单列表
		// http://210.51.165.170:9180/web/phone/order/hotel/order_hotel_search.jsp?memberId=3e2af952b29a421a8235779f14613f2a&source=android&key=xxxx&syssource=xxxxxx
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_ORDER_SEARCH;
		StringBuffer params = new StringBuffer();
		params.append("memberId=").append(queryVo.getMemberid());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		// params.append("&key=").append(queryVo.getKey());//必选 key
		// 新华旅行网分配的唯一授权码 必填 51666
		// if(queryVo.getSyssource()!=null){
		// params.append("&syssource=").append(queryVo.getSyssource());//系统来源 选填
		// }
		HotelOrderResultVo hotelVo = (HotelOrderResultVo) HotelRequestHelper
				.findObjectByApi(urlStr, params, HotelOrderResultVo.class);
		return hotelVo;
	}

	@Override
	public HotelGuaranteeResultVo findBookGuarantee(
			HotelGuaranteeQueryVo queryVo) {
		// TODO　酒店担保查询
		// http://210.51.165.170:9180/web/phone/book/queryHotelGuarantee.jsp?
		// hotelCode=0000147626&roomPlanCode=0001512200&checkInDate=2011-10-11&checkOutDate=2011-10-12&roomAmount=1&arriveDate=20:00&lastArriveDate=24:00
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_GUARANTEE;
		StringBuffer params = new StringBuffer();
		params.append("hotelCode=").append(queryVo.getHotelCode()).append(
				"&&roomPlanCode=").append(queryVo.getHotelCode()).append(
				"&checkInDate=").append(queryVo.getHotelCode()).append(
				"&checkOutDate=").append(queryVo.getHotelCode()).append(
				"&roomAmount=").append(queryVo.getHotelCode()).append(
				"&arriveDate=").append(queryVo.getHotelCode()).append(
				"&lastArriveDate=").append(queryVo.getHotelCode());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		HotelGuaranteeResultVo hotelVo = (HotelGuaranteeResultVo) HotelRequestHelper
				.findObjectByApi(urlStr, params, HotelGuaranteeResultVo.class);
		return hotelVo;
	}

	@Override
	public HotelOrderStsUpdateResultVo updateOrderStatus(
			HotelOrderStsUpdateVo updateVo) {
		// http://localhost:9485/B2C/web/phone/order/hotel/order_hotel_pay.jsp?memberId=3a7a2907686e4336a9dbf33b1c175630&orderCode=005623760&paySts=YZF&source=51666
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL
				+ HotelRequestHelper.API_URL_HOTEL_ORDERSTS_UPDATE;
		StringBuffer params = new StringBuffer();
		params.append("memberId=").append(updateVo.getMemberid());
		params.append("&orderCode=").append(updateVo.getOrderCode());
		params.append("&paySts=").append(updateVo.getPaySts());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		HotelOrderStsUpdateResultVo hotelVo = (HotelOrderStsUpdateResultVo) HotelRequestHelper
		.findObjectByApi(urlStr, params, HotelOrderStsUpdateResultVo.class);
		return hotelVo;
	}

}