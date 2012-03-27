package com.hnatourism.club.golf.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.golf.order.service.IGolfPlayService;
import com.hnatourism.club.golf.order.service.IGolfSubmitService;
import com.hnatourism.club.golf.order.vo.GolfOrderPlayVo;
import com.hnatourism.club.golf.order.vo.GolfOrderStatusVo;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.golf.order.vo.GolfPayStatusVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫预订操作
 * 
 * 历史版本:2011-08-5 v1.0.0 (高杰) 创建:
 * 
 */
public class GolfSubmitServiceImpl implements IGolfSubmitService
{
	private IGolfPlayService golfPlayServ;
	public void setGolfPlayServ(IGolfPlayService golfPlayServ) {
		this.golfPlayServ = golfPlayServ;
	}


	@Override
	public String addBook(GolfOrderVo golfOrder) throws Exception
	{
		golfOrder.setId("11111111");
		//golfOrder.setSts('1');
		//golfOrder.setPaySts('1');
		//golfOrder.setConsumerSts('1');
		//golfOrder.setOperateSts('1');
		
		List<GolfOrderPlayVo> playlist=new ArrayList<GolfOrderPlayVo>();
		//String[] playerlist=golfOrder.getPlayer().split(", ");
		//for(int i=0;i<playerlist.length;i++)
		//{
		//	GolfOrderPlayVo play=new GolfOrderPlayVo();
		//	play.setName(playerlist[i]);
		//	play.setOrderid(golfOrder.getId());
		//	playlist.add(play);
		//}
		golfPlayServ.addPlaylist(playlist);
		
		//调用插入接口
		
		return golfOrder.getId();
	}

	
	public Object detailOrder(String orderId) throws Exception
	{
		GolfOrderStatusVo golfOrderStatus=new GolfOrderStatusVo();
		golfOrderStatus.setId('1');
		golfOrderStatus.setName("等待确认");
		
		GolfPayStatusVo golfPayStatus=new GolfPayStatusVo();
		golfPayStatus.setId('1');
		golfPayStatus.setName("测试支付状态");
		
		GolfSiteVo site=new GolfSiteVo();
		site.setRmk("疑问致电客服中心950719");
		
		GolfOrderVo golfOrder=new GolfOrderVo();
		golfOrder.setId("1111111");
//		golfOrder.setCount(11);
//		golfOrder.setBookTime("2011年8月5日");
//		golfOrder.setAmountPrice(1000);
//		golfOrder.setAdditionalFee(100);
//		golfOrder.setOrderStatus(golfOrderStatus);
//		golfOrder.setPayStatus(golfOrderStatus);
//		golfOrder.setSite(site);
		
		
		
		return golfOrder;
	}
}
