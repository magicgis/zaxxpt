package com.hnatourism.club.golf.prod.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.golf.api.ApiService;
import com.hnatourism.club.golf.prod.service.IGolfHomeService;
import com.hnatourism.club.golf.prod.vo.HnaProCityVo;
import com.hnatourism.club.golf.prod.vo.GolfImageVo;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;



/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫首页显示接口
 * 
 * 历史版本:2011-08-02 v1.0.0 (高杰) 创建:
 * 
 */
public class GolfHomeServiceImpl implements IGolfHomeService
{
	private ApiService apiService;
	public void setApiService(ApiService apiService) {
		this.apiService = apiService;
	}


	@Override
	public Map<String,Object> findByComm() throws Exception
	{
		// 查询图片球场列表
		// 查询城市列表
		// 查询城市对应的球场列表，赋值给城市VO
		
		Map<String, Object> result=new HashMap<String, Object>();
		
		
		//查询推荐城市及其高尔夫产品
		//List<HnaProCityVo> citylist=(List<HnaProCityVo>)apiService.execute("api_findGolfInfoByRecommendCity",false, new HnaProCityVo());
		////System.out.println(citylist);
		
		result.put("city", get_list_city());
		
		return result;
	}
	
	
	private List<Object> get_list_city()
	{
		List<Object> citylist=new ArrayList<Object>();
		
//		HnaProCityVo city1=new HnaProCityVo();
//		city1.setCode("1111111");
//		city1.setName("北京");
//		city1.setGolflist(get_list_golf_price());
//		citylist.add(city1);
//
//		HnaProCityVo city2=new HnaProCityVo();
//		city2.setCode("2222222");
//		city2.setName("上海");
//		city2.setGolflist(get_list_golf_price());
//		citylist.add(city2);
//
//		HnaProCityVo city3=new HnaProCityVo();
//		city3.setCode("3333333");
//		city3.setName("天津");
//		city3.setGolflist(get_list_golf_price());
//		citylist.add(city3);
//
//		HnaProCityVo city4=new HnaProCityVo();
//		city4.setCode("4444444");
//		city4.setName("重庆");
//		city4.setGolflist(get_list_golf_price());
//		citylist.add(city4);
//
//		HnaProCityVo city5=new HnaProCityVo();
//		city5.setCode("5555555");
//		city5.setName("深圳");
//		city5.setGolflist(get_list_golf_price());
//		citylist.add(city5);
		
		return citylist;
	}
	
	
	private List<Object> get_list_golf_price()
	{
		List<Object> golflistprice=new ArrayList<Object>();
		
		GolfInfoVo gho1=new GolfInfoVo();
		gho1.setId("1111111");
		gho1.setName("北京大兴京城高尔夫俱乐部");
		//gho1.setPrice("200/人");
		golflistprice.add(gho1);

		GolfInfoVo gho2=new GolfInfoVo();
		gho2.setId("22222222");
		gho2.setName("华堂国际高尔夫俱乐部");
		//gho2.setPrice("300/人");
		golflistprice.add(gho2);

		GolfInfoVo gho3=new GolfInfoVo();
		gho3.setId("3333333");
		gho3.setName("北京高润高尔夫俱乐部");
		//gho3.setPrice("300/人");
		golflistprice.add(gho3);

		GolfInfoVo gho4=new GolfInfoVo();
		gho4.setId("4444444");
		gho4.setName("北京天竺乡村运动俱乐部");
		//gho4.setPrice("500/人");
		golflistprice.add(gho4);

		GolfInfoVo gho5=new GolfInfoVo();
		gho5.setId("5555555");
		gho5.setName("北京香江高尔夫球中心");
		//gho5.setPrice("350/人");
		golflistprice.add(gho5);

		GolfInfoVo gho6=new GolfInfoVo();
		gho6.setId("6666666");
		gho6.setName("北京大运河高尔夫俱乐部");
		//gho6.setPrice("650/人");
		golflistprice.add(gho6);

		GolfInfoVo gho7=new GolfInfoVo();
		gho7.setId("7777777");
		gho7.setName("北京伯爵园高尔夫俱乐部");
		//gho7.setPrice("450/人");
		golflistprice.add(gho7);

		GolfInfoVo gho8=new GolfInfoVo();
		gho8.setId("8888888");
		gho8.setName("佳伟高尔夫俱乐部");
		//gho8.setPrice("450/人");
		golflistprice.add(gho8);
		
		return golflistprice;
	}
}
