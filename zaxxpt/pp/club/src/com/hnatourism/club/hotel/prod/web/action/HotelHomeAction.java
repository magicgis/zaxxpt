package com.hnatourism.club.hotel.prod.web.action;

import java.util.List;
import com.hnatourism.club.golf.prod.vo.HnaProCityVo;
import com.hnatourism.club.hotel.prod.service.IHotelHomeService;
import com.hnatourism.club.hotel.prod.web.vo.HotelInfoVo;
import com.hnatourism.club.hotel.prod.web.vo.HotelVo;
import com.hnatourism.club.hotel.prod.web.vo.QryHotelVo;
import com.hnatourism.framework.web.action.BaseAction;
/**
 * 项目名称:海航旅业club系统系统
 * 
 * 功能描述:首页及搜索
 * 
 * 历史版本: ${2011.9.5} v1.0.0 (${周峰}) 创建
 * 
 */
public class HotelHomeAction extends BaseAction{
	
	private List<HotelInfoVo> hotellist_image;//图片展示的球场
	private List<HnaProCityVo> citylist;//推荐城市列表
	private String serverPath;
	private HotelInfoVo hotelInfoVo;
	private QryHotelVo qryHotelVo;
	private HotelVo hotelVo;
	private IHotelHomeService hotelHomeService;

	//初始化首页
	public String initHotelHome(){
		return "success";
	}

	public List<HotelInfoVo> getHotellist_image() {
		return hotellist_image;
	}
	public void setHotellist_image(List<HotelInfoVo> hotellistImage) {
		hotellist_image = hotellistImage;
	}
	public List<HnaProCityVo> getCitylist() {
		return citylist;
	}
	public void setCitylist(List<HnaProCityVo> citylist) {
		this.citylist = citylist;
	}
	public String getServerPath() {
		return serverPath;
	}
	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}
	public IHotelHomeService getHotelHomeService() {
		return hotelHomeService;
	}
	public void setHotelHomeService(IHotelHomeService hotelHomeService) {
		this.hotelHomeService = hotelHomeService;
	}
	public HotelInfoVo getHotelInfoVo() {
		return hotelInfoVo;
	}
	public void setHotelInfoVo(HotelInfoVo hotelInfoVo) {
		this.hotelInfoVo = hotelInfoVo;
	}
	public QryHotelVo getQryHotelVo() {
		return qryHotelVo;
	}
	public void setQryHotelVo(QryHotelVo qryHotelVo) {
		this.qryHotelVo = qryHotelVo;
	}
	public HotelVo getHotelVo() {
		return hotelVo;
	}
	public void setHotelVo(HotelVo hotelVo) {
		this.hotelVo = hotelVo;
	}
	
}
