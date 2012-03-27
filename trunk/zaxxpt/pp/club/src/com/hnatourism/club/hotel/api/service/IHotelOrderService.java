package com.hnatourism.club.hotel.api.service;

import com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.exception.BusinessException;

/**
 * 查询酒店订单接口
 * 
 * @author 苏忆 20110905
 */
public interface IHotelOrderService {
	/**
	 * 
	 * @description 确认酒店订单
	 * @param queryVo
	 * @param member
	 * @param createUser
	 * @return
	 * @throws BusinessException
	 * @createTime 2011-11-22 下午07:02:33
	 * @author lixun
	 */
	public String verifyHotelOrder(QueryHotelOrderVo queryVo,
			MemberInfoVo member, String createUser) throws BusinessException;
	// /**
	// * 查询酒店订单详情
	// * @param HotelInfoVo
	// * @return
	// */
	// public HotelVo findHotelOrderById(HotelInfoVo hotel);
	//	
	// /**
	// *更改订单状态
	// * @param HotelInfoVo
	// * @return
	// */
	// public HotelVo updateHotelOrderSts(HotelInfoVo hotel);
	// public boolean verifyHotelOrder(QueryHotelOrderVo queryVo, String
	// createUser)throws BusinessException;
}
