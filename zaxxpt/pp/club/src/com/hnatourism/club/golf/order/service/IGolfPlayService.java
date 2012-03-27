package com.hnatourism.club.golf.order.service;

import java.util.List;

import com.hnatourism.club.golf.order.vo.GolfOrderPlayVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫打球人员操作
 * 
 * 历史版本:2011-08-5 v1.0.0 (高杰) 创建:
 * 
 */
public interface IGolfPlayService
{
	/**
	 * 批量添加打球人员
	 * @param 打球人员VO集合
	 * @throws Exception
	 */
	public void addPlaylist(List<GolfOrderPlayVo> playerList) throws Exception;
}
