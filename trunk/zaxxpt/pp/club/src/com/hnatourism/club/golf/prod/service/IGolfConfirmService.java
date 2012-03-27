package com.hnatourism.club.golf.prod.service;
import java.util.Map;

import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.golf.prod.vo.GolfConfirmVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:订单确认查询业务
 * 
 * 历史版本:2011-08-4 v1.0.0 (苏忆) 创建:
 * 
 */
public interface IGolfConfirmService {
	/**
	 * 得到高尔夫练习场预订页面需要的练习场信息和登录者信息
	 * @param 高尔夫订单id
	 * @return 1）高尔夫订单详情  2）预定球场信息 
	 * @return 3）预订信息 	    4）联系人信息 
	 * @throws Exception
	 */
	public Map<String, Object>  findOrderById(String orderId) throws Exception;
	
	/**
	 * 更新订单状态
	 * @param 高尔夫订单id
	 * @throws Exception
	 */
	public String updateOrder(String orderId,String priceid,String amount,String action,String createUser,int sts) throws Exception;
}