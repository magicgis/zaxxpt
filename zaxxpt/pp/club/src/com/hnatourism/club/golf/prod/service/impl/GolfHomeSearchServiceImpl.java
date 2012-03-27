package com.hnatourism.club.golf.prod.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.golf.prod.service.IGolfHomeSearchService;
import com.hnatourism.club.golf.prod.vo.HnaProCityVo;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.club.golf.prod.vo.GolfTypeVo;
import com.hnatourism.framework.BusinessException;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.web.vo.AbstractVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫首页查寻显示接口
 * 
 * 历史版本:2011-08-03 v1.0.0 (栾晓东) 创建:
 * 
 */
public class GolfHomeSearchServiceImpl implements IGolfHomeSearchService
{
	/**
	 * 高尔夫前台查寻页面。通过省份、下场时期、球场类型、球场名称。
	 * @param vo
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Page findByWhere(AbstractVo vo, PageInfo pageInfo)
			throws BusinessException {
		Page page=new Page();
		
		//1.通过调用dao得到相应数据

		List<GolfInfoVo> list=new ArrayList<GolfInfoVo>();
		
		//第一个产品。。。。。。。。。。。。。。。。。。。。。。。。。。。
		GolfInfoVo golfInfoVo1=new GolfInfoVo();
		golfInfoVo1.setName("1北京大运河球场");//球场名称
		golfInfoVo1.setCity("010");//省份
				HnaProCityVo cityVo=new HnaProCityVo();
				//cityVo.setName("河北省");//省份
		golfInfoVo1.setCityVo(cityVo);
		//球场类型
			GolfSiteVo golfSiteVo=new GolfSiteVo();
			GolfTypeVo golfTypeVo=new GolfTypeVo();
			golfTypeVo.setName("练习场");
			//golfSiteVo.setGolfType(golfTypeVo);//类型给场地
			//golfInfoVo1.setGolfsite(golfSiteVo);//场地给高尔夫信息
			
		golfInfoVo1.setSts("未封场");//当前状态
	
		//查看所有场地
		//-------------------------------------------------------------------
		golfInfoVo1.setGolfsitelist(null);
		//-------------------------------------------------------------------
		//golfInfoVo1.setPrice("2元/球");//价格
		//包含项目？？？？？？？？？？？？？？？没找到。
		list.add(golfInfoVo1);
		
		
		
		
		
		
		
		
		
		//第二个产品。。。。。。。。。。。。。。。。。。。。。。。。。。。
		GolfInfoVo golfInfoVo2=new GolfInfoVo();
		golfInfoVo2.setName("2大运河球场");//球场名称
		golfInfoVo2.setCity("010");//省份
		//球场类型
		GolfSiteVo golfSiteVo22=new GolfSiteVo();
		GolfTypeVo golfTypeVo22=new GolfTypeVo();
		golfTypeVo22.setName("练习场");
		//golfSiteVo22.setGolfType(golfTypeVo22);//类型给场地
		//golfInfoVo2.setGolfsite(golfSiteVo22);//场地给高尔夫信息
		
		golfInfoVo2.setSts("未封场");//当前状态
		//查看所有场地
		//-------------------------------------------------------------------
		golfInfoVo1.setGolfsitelist(null);
		//-------------------------------------------------------------------
		//产品名称（练习场的为空）
		//golfInfoVo2.setPrice("2元/球");//价格
		//包含项目？？？？？？？？？？？？？？？？？？？？？？？？？
		
		
		
		
		
		
		
		
		//第三个产品。。。。。。。。。。。。。。。。。。。。。。。。。。。
		GolfInfoVo golfInfoVo3=new GolfInfoVo();
		golfInfoVo3.setName("武汉大运河球场");//球场名称
		golfInfoVo3.setCity("100000001304");//省份
		//球场类型
			GolfSiteVo golfSiteVo3=new GolfSiteVo();
			GolfTypeVo golfTypeVo3=new GolfTypeVo();//球场VO
			golfTypeVo3.setName("球场");//场名：球场
			//golfSiteVo3.setGolfType(golfTypeVo3);
			///golfInfoVo3.setGolfsite(golfSiteVo3);
			
			golfInfoVo3.setSts("未封场");//当前状态
		//查看所有场地
		//-------------------------------------------------------------------
		List<GolfSiteVo> listSite3=new ArrayList<GolfSiteVo>();
		GolfSiteVo golfSiteVo11=null;
		for(int i=0;i<4;i++){
			golfSiteVo11=new GolfSiteVo();
			golfSiteVo11.setName("A场的"+i);
				GolfPriceVo golfPriceVo=new GolfPriceVo();
				golfPriceVo.setPrice(200d);
			//golfSiteVo11.setPrice(golfPriceVo);
			listSite3.add(golfSiteVo11);
		}
		golfInfoVo3.setGolfsitelist(listSite3);
		//-------------------------------------------------------------------
		//产品名称（球场的是18洞包间）
		//golfInfoVo3.setPrice("2元/球");//价格
		//包含项目？？？？？？？？？？？？？？？？？？？？？？？？？
		list.add(golfInfoVo3);
		list.add(golfInfoVo2);
		
		page.setData(list);
			pageInfo.setCurrentPageNum(1);
			pageInfo.setTotalGroupNum(1);
			pageInfo.setTotalRowCount(1);
			pageInfo.setGroupsOfPage(1);
		page.setPageInfo(pageInfo);
		return page;
	}
	

}
