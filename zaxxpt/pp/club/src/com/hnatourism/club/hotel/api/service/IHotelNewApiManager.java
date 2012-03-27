package com.hnatourism.club.hotel.api.service;

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

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:新版酒店接口管理接口
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public interface IHotelNewApiManager {
	/**
	 * 
	 * @description 酒店查询
	 * @param queryVo
	 * @return 酒店查询的信息
	 * @createTime 2011-11-14 下午02:58:45
	 * @author lixun
	 */
	public HotelQueryResultVo findHotelList(HotelQueryVo queryVo);
	
	/**
	 * 
	 * @description 查询酒店房型房态
	 * @param queryVo
	 * @return	酒店房型信息
	 * @createTime 2011-11-14 下午02:59:58
	 * @author lixun
	 */
	public HotelRoomResultVo findHotelRoomList(HotelRoomQueryVo queryVo);
	
	/**
	 * 
	 * @description 酒店详情查询
	 * @param queryVo
	 * @return	酒店详情信息
	 * @createTime 2011-11-14 下午03:02:14
	 * @author lixun
	 */
	public HotelDetailsResultVo findHotelDetails(HotelDetailsQueryVo queryVo);
	
	/**
	 * 
	 * @description 酒店预订
	 * @param bookVo
	 * @return 返回酒店预订结果的信息
	 * @createTime 2011-11-14 下午03:03:22
	 * @author lixun
	 */
	public HotelBookResultVo bookHotel(HotelBookVo bookVo);
	
	/**
	 * 
	 * @description 查询订单列表
	 * @param queryVo
	 * @return 订单列表返回
	 * @createTime 2011-11-14 下午03:06:10
	 * @author lixun
	 */
	public HotelOrderResultVo findOrderList(HotelOrderQueryVo queryVo);
	
	/**
	 * 
	 * @description 查询订单详情
	 * @param queryVo
	 * @return	返回订单详情信息
	 * @createTime 2011-11-14 下午03:08:49
	 * @author lixun
	 */
	public HotelOrderDetailsReusltVo findOrderDetails(HotelOrderDetailQueryVo queryVo);
	
	/**
	 * 
	 * @description 取消订单
	 * @param cancelVo
	 * @return 成功返回订详情信息,失败则在result 的message 中返回失败信息
	 * @createTime 2011-11-14 下午03:11:18
	 * @author lixun
	 */
	public HotelOrderDetailsReusltVo cancelOrder(HotelOrderCancelVo cancelVo);
	
	/**
	 * 
	 * @description 酒店现付担保查询
	 * @param queryVo
	 * @return 返回酒店现付预订担保查询结果
	 * @createTime 2011-11-17 上午10:32:35
	 * @author lixun
	 */
	public HotelGuaranteeResultVo findBookGuarantee(HotelGuaranteeQueryVo queryVo);
	
	/**
	 * 
	 * @description 更新订单状态
	 * @param updateVo
	 * @return
	 * @createTime 2011-11-22 下午06:34:02
	 * @author lixun
	 */
	public HotelOrderStsUpdateResultVo updateOrderStatus(HotelOrderStsUpdateVo updateVo);
	
}
