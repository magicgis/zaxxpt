package com.hnatourism.club.golf.prod.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.golf.prod.service.IGolfProdViewService;
import com.hnatourism.club.golf.prod.vo.HnaProCityVo;
import com.hnatourism.club.golf.prod.vo.GolfImageVo;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import java.lang.reflect.Type;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫产品详细
 * 
 * 历史版本:2011-08-02 v1.0.0 (周峰) 创建:
 * 
 */
public class GolfProdViewServiceImpl implements IGolfProdViewService
{
	@Override
	public GolfInfoVo findById(String id) throws Exception
	{
//		//取得产品信息
//		GolfImageVo imageforlist1 = new GolfImageVo();
//		imageforlist1.setPath("img1.jpg");
//		GolfImageVo imageforlist2 = new GolfImageVo();
//		imageforlist2.setPath("img7.jpg");
//		GolfImageVo imageforlist3 = new GolfImageVo();
//		imageforlist3.setPath("img8.jpg");
//		GolfImageVo imageforlist4 = new GolfImageVo();
//		imageforlist4.setPath("img10.jpg");
//		GolfImageVo imageforlist5 = new GolfImageVo();
//		imageforlist5.setPath("img10.jpg");
//		GolfImageVo imageforlist6 = new GolfImageVo();
//		imageforlist6.setPath("img10.jpg");
//		GolfImageVo imageforlist7 = new GolfImageVo();
//		imageforlist7.setPath("img10.jpg");
//		GolfImageVo imageforlist8 = new GolfImageVo();
//		imageforlist8.setPath("img10.jpg");
//		
//		List<GolfImageVo> imagelist = new ArrayList();
//		imagelist.add(imageforlist1);
//		imagelist.add(imageforlist2);
//		imagelist.add(imageforlist3);
//		imagelist.add(imageforlist4);
//		imagelist.add(imageforlist5);
//		imagelist.add(imageforlist6);
//		imagelist.add(imageforlist7);
//		imagelist.add(imageforlist8);
//		
//		GolfImageVo imagevo = new GolfImageVo();
//		imagevo.setPath("img5.jpg");
//		
//		GolfInfoVo vo = new GolfInfoVo();
//		vo.setId("88");
//		vo.setName("北京大运河球场");
//		vo.setCity(Long.valueOf(10010));
//		vo.setCourseData("18洞72杆");
//		vo.setCourseDescription("湖国际高尔夫球会属会员球场，位于风景如画的湖南省长沙位于风景如画的湖南省长沙位于风景如画的湖南省长沙位于风景如画的湖南省长沙位于风景如画的湖南省长沙；福区青竹湖畔，距市区12分钟车程，球会目前已建成27洞山地及10000平方米的会所服务区 ...");
//		vo.setDesigner("威廉史密斯");
//		vo.setFacilityInformation("中餐厅&nbsp;西餐厅&nbsp;会所酒店&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室&nbsp;会议室");
//		vo.setFairwayGrass("小麦禾");
//		vo.setFairwayLength(Long.valueOf(1900));
//		vo.setGolfimage(imagevo);
//		vo.setGolfiamgelist(imagelist);
//		vo.setGreenGrass("澳大利亚草");
//		vo.setSetupTime(new Date());
//		vo.setStadiumArea(Long.valueOf(3200));
//		vo.setSts("");
//		
		//GolfInfoVo vo = new GolfInfoVo();
		Type type = new TypeToken<List<GolfInfoVo>>(){  }.getType(); 
		String jsonStr = ApiClient.getHtml("/api/apiServer.action?method=f_golf_img_ById&&id="+id);
		List<GolfInfoVo> list = (List<GolfInfoVo>)GsonUtil.jsonToObject(jsonStr,type);
		list.get(0);
		
		
		return list.get(0);
	}

}
