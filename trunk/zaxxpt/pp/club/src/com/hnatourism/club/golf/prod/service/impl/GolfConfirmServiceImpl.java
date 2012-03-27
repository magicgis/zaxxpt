package com.hnatourism.club.golf.prod.service.impl;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.golf.prod.service.IGolfConfirmService;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫订单页显示接口
 * 
 * 历史版本:2011-08-04 v1.0.0 (苏忆) 创建:
 * 
 */
public class GolfConfirmServiceImpl implements IGolfConfirmService {
	@Override
	public Map<String, Object>  findOrderById(String orderId) throws Exception {
		// 查询订单详情
		Map<String, Object> result=new HashMap<String, Object>();
/*		Type type = new TypeToken<GolfOrderVo>(){  }.getType(); 
		String jsonStr = ApiClient.getHtml("/api/apiServer.action?method=api_findGolfOrderById&&id="+orderId);                     
		List<GolfOrderVo> list = (List<GolfOrderVo>)GsonUtil.jsonToObject(jsonStr,type);*/
		//GolfOrderVo golfOrderVo = (GolfOrderVo)GsonUtil.jsonToObject(jsonStr,type);
	
		Type type = new TypeToken<List<GolfOrderVo>>(){}.getType(); 
		String jsonStr = ApiClient.getHtml("/api/apiServer.action?method=api_findGolfOrderById&&id="+orderId);
		List<GolfOrderVo>  golfOrderVo = (List<GolfOrderVo>)GsonUtil.jsonToObject(jsonStr,type);
		
		result.put("golfOrderVo", golfOrderVo);
		return result;
	}

	@Override
	public String updateOrder(String orderId,String priceid,String amount,String action,String createUser,int sts) throws Exception {
		Type type = new TypeToken<String>(){}.getType(); 
		String jsonStr="";
		if(action.equalsIgnoreCase("confirm"))
		{
			jsonStr = ApiClient.getHtml("/api/apiServer.action?method=modifyGlofOrder&&id="+orderId+"&&sts="+sts+"&&content=订单已经确认&&priceid="+priceid+"&&amount="+amount+"&&createUser="+createUser);
		}
		else if(action.equalsIgnoreCase("cancel"))
		{
			jsonStr = ApiClient.getHtml("/api/apiServer.action?method=modifyGlofOrder&&id="+orderId+"&&sts="+sts+"&&content=订单已经取消&&priceid="+priceid+"&&amount="+amount+"&&createUser="+createUser);
		}else if("confirmExp".equalsIgnoreCase(action)){
			jsonStr = ApiClient.getHtml("/api/apiServer.action?method=modifyGlofOrderExp&&expOrderId="+priceid+"&&id="+orderId+"&&sts="+sts+"&&content=会员已经确认&&createUser="+createUser);//张晓春修改.改期会员确认后增加日志
		}
		return jsonStr;
	}
}
