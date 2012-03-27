package com.hnatourism.club.hotel.api.service;

import java.util.List;

import com.hnatourism.club.hotel.order.vo.HotelOrderDetailsVo;
import com.hnatourism.club.hotel.order.vo.HotelOrderVo;
import com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo;
import com.hnatourism.club.hotel.prod.web.vo.HotelVo;
import com.hnatourism.club.hotel.prod.web.vo.QryHotelVo;


/**
 * 酒店接口管理接口
 *
 */
public interface IHotelApiManager {
	/**
	 * 查询酒店详情
	 * @param qryHotelVo
	 * @return
	 */
	public HotelVo findHotelDetail(QryHotelVo qryHotelVo);

	/**
	 * 
	 * @description 【查询酒店订单】
	 * @param queryVo
	 * @return
	 * @createTime 2011-9-5 下午04:58:46
	 * @author lixun
	 */
	public List<HotelOrderVo> findHotelOrderList(QueryHotelOrderVo queryVo);
	
	/**
	 * 
	 * @description 【查看订单详情】
	 * @param queryVo
	 * @return
	 * @createTime 2011-9-5 下午07:18:24
	 * @author lixun
	 */
	public HotelOrderDetailsVo findHotelOrderDetails(QueryHotelOrderVo queryVo);

	/**
	 * 
	 * @description 【取消酒店订单】
	 * @param queryVo
	 * @return
	 * @createTime 2011-9-6 下午12:04:58
	 * @author lixun
	 */
	public HotelOrderDetailsVo cancelHotelOrder(QueryHotelOrderVo queryVo);

	/**
	 * 查询酒店列表信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public String findHotelList(QryHotelVo qryHotelVo) ;
	/**
	 * 查询酒店房型列表信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public String findRoomList(QryHotelVo qryHotelVo) ;
//	/**
//	 * 
//	 * @description 【退订酒店订单】
//	 * @param queryVo
//	 * @return
//	 * @createTime 2011-9-7 下午05:40:02
//	 * @author lixun
//	 */
//	public HotelOrderDetailsVo unsubscribeHotelOrder(QueryHotelOrderVo queryVo);

	/**
	 * 更改订单确认操作
	 */
	public boolean modifyHotelOrderSts(QueryHotelOrderVo queryVo);
}
