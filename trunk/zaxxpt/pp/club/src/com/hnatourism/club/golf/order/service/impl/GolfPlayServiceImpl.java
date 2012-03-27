package com.hnatourism.club.golf.order.service.impl;

import java.util.List;

import com.hnatourism.club.golf.order.service.IGolfPlayService;
import com.hnatourism.club.golf.order.vo.GolfOrderPlayVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫打球人员操作
 * 
 * 历史版本:2011-08-5 v1.0.0 (高杰) 创建:
 * 
 */
public class GolfPlayServiceImpl implements IGolfPlayService
{
	@Override
	public void addPlaylist(List<GolfOrderPlayVo> playerList) throws Exception
	{
		for(int i=0;i<playerList.size();i++)
		{
			GolfOrderPlayVo play=new GolfOrderPlayVo();
			play.setId("11111");
			//play.setSts('1');
			play.setRmk("111");
		}
	}
}
