package com.hnatourism.club.golf.order.service.impl;
import java.util.Date;

import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.order.service.GolfOrderService;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫定单业务层实现。
 * 
 * 历史版本:2011-08-06 v1.0.0 (栾晓东) 创建:
 * 
 */
public class GolfOrderServiceImpl implements GolfOrderService
{	
	//定单ID
	private String orderId;
	//退场的理由
	private String reason;
	//改期的时间
	private String updateTime;
	
	//定单
	private GolfOrderVo golfOrderVo;
	
	/**
	 * 根据定单ID找出定单信息。
	 */
	@Override
	public GolfOrderVo getOrderById(String id) {
		/*
			ApiClient client=new ApiClient();//得到API客户端。
			Gson gson = new Gson();//拿到google 的Gson
			Type collectionType = new TypeToken<List<GolfOrderVo>>(){}.getType(); //得到集合类型。
			List<GolfOrderVo> golfOrderVoList=(List<GolfOrderVo>)gson.fromJson(client.getHtml("/api/apiServer.action?method=api_findGolfOrderById&&id="+id),collectionType);//通过集合类型根据传的id找出一个定单放到List的第0项中去。
			golfOrderVo=golfOrderVoList.get(0);
		*/	
			
		GolfOrderVo golfOrderVo2=new GolfOrderVo();
		golfOrderVo2.setId(id);
		golfOrderVo2.setSts("1");
		golfOrderVo2.setCreateTime(new Date());
					GolfSiteVo site=new GolfSiteVo();
					
					site.setRmk("场地规则！1，2，3.");
					site.setEndTime("2011-08-08");
					site.setName("A场地");
		golfOrderVo2.setGolfSiteVo(site);
					GolfInfoVo info=new GolfInfoVo();
		golfOrderVo2.setGolfInfoVo(info);
		return golfOrderVo2;
	}
	/**
	 * 将申请退场的  定单ID  与    退场理由     提交。
	 * @param orderId	定单Id
	 * @param rmk	退场理由
	 */
	@Override
	public void saveOrUpdateRmk(String orderId,String paySts,String rmk) {
//		ApiClient client=new ApiClient();//得到API客户端。
		ApiClient.getHtml("/api/apiServer.action?method=api_insertGolfOrderException&&orderId="+orderId+"&&paySts="+paySts+"&&rmk="+rmk);
		
	}
	/**
	 * 将申请退场的  定单ID  与   改期时间     提交。
	 * @param orderId	定单Id
	 * @param updateTime	改期时间
	 */
	@Override
	public void saveOrUpdateTime(String orderId,String paySts,String updateTime) {
//		ApiClient client=new ApiClient();//得到API客户端。
		ApiClient.getHtml("/api/apiServer.action?method=api_insertGolfOrderException&&orderId=");
	}
	
	
	//getter setter ................方法
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public GolfOrderVo getGolfOrderVo() {
		return golfOrderVo;
	}
	public void setGolfOrderVo(GolfOrderVo golfOrderVo) {
		this.golfOrderVo = golfOrderVo;
	}
}
