package com.hnatourism.club.hotel.prod.service.impl;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.hotel.api.service.HotelRequestHelper;
import com.hnatourism.club.hotel.common.Tool;
import com.hnatourism.club.hotel.order.vo.HotelOrderContactVo;
import com.hnatourism.club.hotel.order.vo.HotelOrderParemVo;
import com.hnatourism.club.hotel.order.vo.OrderResultVo;
import com.hnatourism.club.hotel.prod.service.IHotelBookService;
import com.hnatourism.club.hotel.prod.web.vo.HotelVo;
import com.hnatourism.club.hotel.prod.web.vo.QryHotelVo;
import com.hnatourism.club.hotel.prod.web.vo.QryRoomVo;
import com.hnatourism.framework.core.service.AbstractService;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转到酒店预订页
 * 
 * 历史版本: ${2011.9.5} v1.0.0 (高杰) 创建
 * 
 */
public class HotelBookServiceImpl extends AbstractService implements IHotelBookService
{
	/**
	 * 查询酒店详细信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public HotelVo findHotelDetail(QryHotelVo qryHotelVo)
	{
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_DETAIL;
		StringBuffer params = new StringBuffer();
		params.append("origin=").append(qryHotelVo.getOrigin());
		params.append("&hotelCode=").append(qryHotelVo.getHotelCode());
		params.append("&idate=").append(qryHotelVo.getIdate());
		params.append("&odate=").append(qryHotelVo.getOdate());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		
		// 调用接口取得返回数据
		HotelVo hotelVo = (HotelVo)HotelRequestHelper.findObjectByApi(urlStr,params,HotelVo.class);
		
		// 返回
		return hotelVo;
	}
	
	/**
	 * 查询酒店房型详细信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public HotelVo findHotelRoomList(QryRoomVo qryRoomVo) throws Exception
	{
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_ROOM_SEARCH;
		StringBuffer params = new StringBuffer();
		params.append("city=").append(qryRoomVo.getCity());
		params.append("&hotelCode=").append(qryRoomVo.getHotelCode());
		params.append("&idate=").append(qryRoomVo.getIdate());
		params.append("&odate=").append(qryRoomVo.getOdate());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		
		// 调用接口取得返回数据
		HotelVo hotelVo = (HotelVo)HotelRequestHelper.findObjectByApi(urlStr,params,HotelVo.class);
		
		// 返回
		return hotelVo;
	}
	
	/**
	 * 预订酒店
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public OrderResultVo newHotelOrder(HotelOrderParemVo hotelOrderParemVo, HotelOrderContactVo hotelOrderContact) throws Exception
	{
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_BOOK;
		StringBuffer params = new StringBuffer();
		params.append("memberId=").append(hotelOrderParemVo.getMemberId());
		params.append("&hcode=").append(hotelOrderParemVo.getHcode());
		params.append("&rcode=").append(hotelOrderParemVo.getRcode());
		params.append("&idate=").append(hotelOrderParemVo.getIdate());
		params.append("&odate=").append(hotelOrderParemVo.getOdate());
		params.append("&adate=").append(hotelOrderParemVo.getAdate());
		params.append("&rmk=").append(Tool.transCoding(hotelOrderParemVo.getRmk()));
		params.append("&pnum=").append(hotelOrderParemVo.getPnum());
		params.append("&pname=").append(Tool.transCoding(hotelOrderParemVo.getPname()));
		params.append("&totalMoney=").append(hotelOrderParemVo.getTotalMoney());
		params.append("&isFirst=").append("0");
		params.append("&contact.name=").append(Tool.transCoding(hotelOrderContact.getName()));
		params.append("&contact.mobile=").append(hotelOrderContact.getMobile());
		params.append("&contact.email=").append(hotelOrderContact.getEmail());
		params.append("&contact.phone=").append(hotelOrderContact.getMobile());
		params.append("&invoice.needtype=").append("N");
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		//修改日志输出 	lixun 	editDate 2011-10-13 14:51
		log.info("酒店预定参数：urlStr: "+urlStr+"  params: "+params.toString());
		// 调用接口取得返回数据
		OrderResultVo orderresult = (OrderResultVo)HotelRequestHelper.findObjectByApi(urlStr,params,OrderResultVo.class);
//		System.out.println("酒店预定信息："+orderresult.getResult().getMessage());
		// 返回
		return orderresult;
//		return null;
	}
}
