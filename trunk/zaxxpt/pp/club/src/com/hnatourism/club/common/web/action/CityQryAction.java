/**
 * 项目名称：海航旅业B2C
 *
 * 功能描述
 *
 * @ver 0.1
 * @author zhangyun
 */
package com.hnatourism.club.common.web.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;

import com.hnatourism.club.common.cache.FlightCache;
import com.hnatourism.club.common.domain.FlightAirport;
import com.hnatourism.club.common.domain.HnaProcity;
import com.hnatourism.framework.cache.CacheDataManager;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.StringUtils;

public class CityQryAction extends com.hnatourism.framework.web.action.BaseAction{
	
	private static List<HnaProcity> hnaProcityList;
	
	private String cityCode;
	/**
	 * 加载国家
	 * @return
	 */
	public void loadCountryArr(){
		List<HnaProcity> list = (List) CacheDataManager.get("COUNTRY");
		if(!ListUtils.isEmpty(list)){
			StringBuffer buff = new StringBuffer();
			HnaProcity hnaProcity = null;
			int count=0;
			for(int i=0;i<list.size();i++){
				hnaProcity = list.get(i);
				//如果国籍对应DomainCode则跳过
				if(StringUtils.isEmpty(hnaProcity.getDomainCode())){
					continue;
				}
				buff = getJsCountryArr("countryArr",buff, count++, hnaProcity);
			}
			try{
				writeString(buff.toString(), "gson");
			} 
			catch (IOException e){
				log.error("", e);
				setMessage(e.getMessage());
			}
		}
	}
	//去掉包含2个机场的城市
	/**
	 * 加载省份
	 * @return
	 */
	public void loadProvinces(){
		List<HnaProcity> list = (List) CacheDataManager.get("PROVINCE");
		if(!ListUtils.isEmpty(list)){
			StringBuffer buff = new StringBuffer();
			int count=0;
			for (HnaProcity hnaProcity : list) {
					buff = getJsCityArr("provinceArr",buff, count++, hnaProcity);
		
			}
			try{
				writeString(buff.toString(), "gson");
			} 
			catch (IOException e){
				setMessage("N");
				log.error(e.getMessage());
			}
		}
	}
	/**
	 * 查询热门机场
	 * @return
	 * @author zhangyun
	 */
	public void loadHotAirports(){
//		List<FlightAirport> list = (List) CacheDataManager.get("FLIGHT_AIRPORT");
//		Map<String, HnaProcity> cityObjMap = (Map<String, HnaProcity>) CacheDataManager.get("CITY_OBJ_MAP");
//		if(!ListUtils.isEmpty(list)){
//			StringBuffer buff = new StringBuffer();
//			FlightAirport flightAirport = null;
//			HnaProcity curCity = null;
//			String key = null;
//			List<String> slitFlightAirport = null;
//			int num = 0;
//			String flightAirportName="";
//			String flightAirportEname="";
//			LinkedMultiValueMap<String, Object> cityAirportMap = FlightCache.getSlitAirportMap();
//			labelo:for(int i=0;i<list.size();i++){
//				flightAirport = list.get(i);
////				if(flightAirport.get){
////					
////				}
//				curCity = cityObjMap.get(flightAirport.getCity());
//				key = flightAirport.getCity();
//				slitFlightAirport = (List)cityAirportMap.get(key);
//				if(!ListUtils.isEmpty(slitFlightAirport)){
//					for(int j = 0;j<slitFlightAirport.size();j++){
//						if(j!=0 || !slitFlightAirport.get(j).equals(flightAirport.getCode())){
//							continue labelo;
//						}
//						else{
////							flightAirportName=CityareaCache.getCityName(flightAirport.getCity());
//							if(curCity != null){
//							flightAirportEname = curCity.getSearchkey();
//							flightAirportName = curCity.getPcname();
//							}
//							break;
//						}
//					}
//				}
//				else{
//					flightAirportName=flightAirport.getName();
//					flightAirportEname= flightAirport.getAirportEname();
//				}
//			
////				buff.append( "@" + flightAirport.getAirportEname()+ "|" + flightAirport.getname() + "|" + flightAirport.getCode());
//				buff.append("airportArr[");
//				buff.append(num);
//				buff.append("]=new Array('','");
//				buff.append(flightAirport.getCode());
//				buff.append("','");
//				buff.append(flightAirportName);
//				buff.append("','");
//				buff.append(flightAirportEname);
////				buff.append("','');");
//				buff.append("','");
////				curCity = cityObjMap.get(flightAirport.getCity());
//				if(curCity != null){
//					buff.append(curCity.getShortname());
//				}
//				buff.append("');");
//				num++;
//			}
////			buff.append( "@" );
//			try{
//				writeString(buff.toString(), "gson");
//			} 
//			catch (IOException e){
//				e.printStackTrace();
//				setMessage(e.getMessage());
//			}
//		}
	}
	/**
	 * 查询机场
	 * @return
	 * @author zhangyun
	 */
	public void loadAirports(){
		List<FlightAirport> list = (List) CacheDataManager.get("FLIGHT_AIRPORT");
		Map<String, HnaProcity> cityObjMap = (Map<String, HnaProcity>) CacheDataManager.get("CITY_OBJ_MAP");
		String isDisplayCity = this.getRequest().getParameter("isDisplayCity");
		if(!ListUtils.isEmpty(list)){
			StringBuffer buff = new StringBuffer();
			FlightAirport flightAirport = null;
			HnaProcity curCity = null;
			String key = null;
			List<FlightAirport> slitFlightAirport = null;
			int num = 0;
			String flightAirportName="";
			String flightAirportEname="";
			LinkedMultiValueMap<String, Object> cityAirportMap = null;
			if(!"N".equals(isDisplayCity)){
				cityAirportMap = FlightCache.getSlitAirportMap();
			}
			labelo:for(int i=0;i<list.size();i++){
				flightAirport = list.get(i);
				//如果机场的城市字段为空则跳过
				if(StringUtils.isEmpty(flightAirport.getCity())){
					continue;
				}
				if(!"N".equals(isDisplayCity)){
					curCity = cityObjMap.get(flightAirport.getCity());
					//如果城市Code对应键值为空则跳过
					if(curCity==null){
						continue;
					}
				}
				key = flightAirport.getCity();
				if(!"N".equals(isDisplayCity)){
					if(StringUtils.isNotEmpty(key)){
						slitFlightAirport = (List)cityAirportMap.get(key);
					}
				}
				if(!ListUtils.isEmpty(slitFlightAirport)){
					for(int j = 0;j<slitFlightAirport.size();j++){
						if(j!=0 || !flightAirport.getCode().equals(slitFlightAirport.get(j).getCode())){
							continue labelo;
						}
						else{
//							flightAirportName=CityareaCache.getCityName(flightAirport.getCity());
							if(curCity != null){
							flightAirportEname = curCity.getSearchkey();
							flightAirportName = curCity.getPcname();
							}
							break;
						}
					}
				}
				else{
					flightAirportName=flightAirport.getName();
					flightAirportEname= flightAirport.getAirportEname();
				}
			
////				buff.append( "@" + flightAirport.getAirportEname()+ "|" + flightAirport.getname() + "|" + flightAirport.getCode());
//				if(("international".equals(this.getRequest().getParameter("area")) 
//						&& "2".equals(flightAirport.getSts()))
//						|| "all".equals(this.getRequest().getParameter("area"))
//						|| "1".equals(flightAirport.getSts())
//						){
//				buff = getJsAirportArr("airportArr",buff, num, curCity, flightAirport.getCode(), flightAirportName, flightAirportEname);
//				num++;
//				}
				
				if("international".equals(this.getRequest().getParameter("airArea"))){
					if("2".equals(flightAirport.getSts())){
					buff = getJsAirportArr("internationalAirportArr",buff,num, curCity, flightAirport, flightAirportName, flightAirportEname);
					num++;
					}
				}
				else if("all".equals(this.getRequest().getParameter("airArea"))){
					buff = getJsAirportArr("airportArr",buff, num, curCity, flightAirport, flightAirportName, flightAirportEname);
					num++;
				}
				else{
					if("1".equals(flightAirport.getSts())){
						buff = getJsAirportArr("airportArr",buff, num, curCity, flightAirport, flightAirportName, flightAirportEname);
						num++;
					}
				}
			}
//			buff.append( "@" );
			try{
				writeString(buff.toString(), "gson");
			} 
			catch (IOException e){
				log.error("", e);
				setMessage(e.getMessage());
			}
		}
	}
	// 判断是否是主机场 by wuyuhu
	public static String getTheMainAirPort(String Airport) {
		String airportMain;
		// 出发机场城市code
		String cityDeCode = FlightCache.getCityCodeByAirport(Airport);
		// 机场缓存
		Map airPortDeCode = FlightCache.getSlitAirportMap();
		// 出发机场list
		List deAirPortList = (List) airPortDeCode.get(cityDeCode);
		// 获取出发机场三字码
		if (null == FlightCache.getMainAirportCode(deAirPortList)) {
			airportMain = Airport;
		} else {
			airportMain = FlightCache.getMainAirportCode(deAirPortList);
		}
		return airportMain;
	}
	private StringBuffer getJsAirportArr(String arrName,StringBuffer buff,int index,HnaProcity curCity,FlightAirport code,String name,String ename){
		buff.append(arrName+"[");
		buff.append(index);
		buff.append("]=new Array('','");
		buff.append(curCity != null?getTheMainAirPort(code.getCode()):code.getCode());
		buff.append("','");
		buff.append(name);
		buff.append("','");
		if("1".equals(code.getSts())){
			buff.append(ename);
		}else{			
			//下拉匹配搜索字段使用城市的汉语拼音 edit by fanghw 2011.04.27
			//buff.append(code.getEname());			
			buff.append(code.getAirportEname());
		}
//		buff.append("','');");
		buff.append("','");
//		curCity = cityObjMap.get(flightAirport.getCity());
		if("1".equals(code.getSts())){
			if(curCity != null){
				buff.append(curCity.getShortname());
			}
		}
		else{
			//最后一个数组元素为城市的英文名称 edit by fanghw 2011.04.27
			//buff.append(ename);			
			buff.append(code.getEname());
		}
		buff.append("');");
		return buff;
	}
	/**
	  * 查询城市
	 * @return
	 * @author zhangyun 
	 */
	public void loadCities(){
		List<HnaProcity> list = (List) CacheDataManager.get("CITY");
		if(!ListUtils.isEmpty(list)){
			StringBuffer buff = new StringBuffer();
			for (HnaProcity hnaProcity : list) {
				if("2".equals(hnaProcity.getPctype())){
					buff.append("@" + hnaProcity.getSearchkey() + "|"
							+ hnaProcity.getPcname() + "|" 
							+ hnaProcity.getShortname() + "|"
							+ hnaProcity.getPccode() + "|"
							+ hnaProcity.getParentcode() + "|"
							+ hnaProcity.getArea());
				}
			}
			buff.append( "@" );
			try {
				writeString(buff.toString(), "from");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 加载城市
	 */
	public void loadCityArr(){
		List<HnaProcity> list = (List) CacheDataManager.get("CITY");
		if(!ListUtils.isEmpty(list)){
			StringBuffer buff = new StringBuffer();
			HnaProcity hnaProcity = null;
			int j = 0;
			for(int i=0;i<list.size();i++){
				hnaProcity = list.get(i);
//				buff.append( "@" + flightAirport.getAirportEname()+ "|" + flightAirport.getname() + "|" + flightAirport.getCode());
				if("international".equals(this.getRequest().getParameter("area")) 
						&& "2".equals(hnaProcity.getIsopen())){
					buff = getJsCityArr("internationalCityArr",buff, j, hnaProcity);
				j++;
				}
				else if("all".equals(this.getRequest().getParameter("area"))){
					buff = getJsCityArr("cityArr",buff, i, hnaProcity);
				}
				else{
					if("1".equals(hnaProcity.getIsopen())){
						buff = getJsCityArr("cityArr",buff, j, hnaProcity);
					j++;
					}
				}
			}
//			buff.append( "@" );
			try{
				writeString(buff.toString(), "gson");
			} 
			catch (IOException e){
				e.printStackTrace();
				setMessage(e.getMessage());
			}
		}
	}
	
	private StringBuffer getJsCityArr(String arrName,StringBuffer buff,int index,HnaProcity hnaProcity){
		buff.append(arrName+"[");
		buff.append(index);
		buff.append("]=new Array('").append(hnaProcity.getParentcode()).append("','");
		buff.append(hnaProcity.getPccode());
		buff.append("','");
		buff.append(hnaProcity.getPcname());
		buff.append("','");
		buff.append(hnaProcity.getSearchkey());
		buff.append("','").append(hnaProcity.getShortname()).append("');");
		return buff;
	}
	private StringBuffer getJsCountryArr(String arrName,StringBuffer buff,int index,HnaProcity hnaProcity){
		buff.append(arrName+"[");
		buff.append(index);
		buff.append("]=new Array('").append(hnaProcity.getParentcode()).append("','");
		buff.append(hnaProcity.getDomainCode());
		buff.append("','");
		buff.append(hnaProcity.getPcname());
		buff.append("','");
		buff.append(hnaProcity.getPccode());
		buff.append("','").append(hnaProcity.getSearchkey()).append("');");
		return buff;
	}
	/**
	 * 加载热门城市
	 */
	public void loadHotCityArr(){
		List<HnaProcity> list = (List) CacheDataManager.get("CITY");
		if(!ListUtils.isEmpty(list)){
			StringBuffer buff = new StringBuffer();
			HnaProcity hnaProcity = null;
			for(int i=0;i<list.size();i++){
				hnaProcity = list.get(i);
				if(StringUtils.isEmpty(hnaProcity.getIshot())){
					continue;
				}
//				buff.append( "@" + flightAirport.getAirportEname()+ "|" + flightAirport.getname() + "|" + flightAirport.getCode());
				buff.append("commonCity[");
				buff.append(i);
				buff.append("]=new Array('").append(hnaProcity.getParentcode()).append("','");
				buff.append(hnaProcity.getPccode());
				buff.append("','");
				buff.append(hnaProcity.getPcname());
				buff.append("','");
				buff.append(hnaProcity.getSearchkey());
				buff.append("','").append(hnaProcity.getShortname()).append("');");
			}
//			buff.append( "@" );
			try{
				writeString(buff.toString(), "gson");
			} 
			catch (IOException e){
				e.printStackTrace();
				setMessage(e.getMessage());
			}
		}
	}
	/**
	 * 通过省份加载城市信息
	 */
	public void loadCitiesByProvince(){
		if(cityCode!=null && cityCode.trim().length()>0){
			List<HnaProcity> list = (List) CacheDataManager.get("CITY");
				StringBuffer buff = new StringBuffer();
				if(list!=null){
					for(HnaProcity hnaProcity : list){
						if(cityCode.equals(hnaProcity.getParentcode())){
							String cityCode = hnaProcity.getPccode();
							String cityName = hnaProcity.getPcname();
							buff.append( cityCode + "=" + cityName + ",");
						}
					}
					String resultStr = "";
					try{
						resultStr = buff.toString().substring( 0, buff.toString().length()-1 );
					}catch(Exception e){
						log.info( e.getMessage() );
					}
					try {
						writeString(buff.toString(), "text");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
	}
	/**
	 * 通过城市加载区域
	 */
	public void loadAreasByCity(){
//		if(cityCode!=null && cityCode.trim().length()>0){
//			CommonInfoBean commonInfoBean = new CommonInfoBean();
//			try
//			{
//				commonInfoBean = loadCommonInfoManager.getCommonInfoBean();
//			} catch ( ServiceException e1 )
//			{
//				e1.printStackTrace();
//			}
//			if(commonInfoBean!=null){
//				StringBuffer buff = new StringBuffer();
//				List<HnaCityarea> areaList = commonInfoBean.getAreaList();
//				if(areaList!=null){
//					for(HnaCityarea area : areaList){
//						if(cityCode.equals(area.getPccode())){
//							String areaCode = area.getCode();
//							String areaName = area.getCaname();
//							buff.append( areaCode + "=" + areaName + ",");
//						}
//					}
//					String resultStr = "";
//					try{
//						resultStr = buff.toString().substring( 0, buff.toString().length()-1 );
//					}catch(Exception e){
//						log.info( e.getMessage() );
//					}
//					this.getResponse().setCharacterEncoding("UTF-8"); 
//					this.getResponse().setContentType("text; charset=UTF-8");
//					try
//					{
//						getResponse().getWriter().write( resultStr );
//					} catch ( IOException e )
//					{
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		return null;
	}
	
	/**
	 * 机场
	 * @return
	 */
//	public String loadAirports(){
//		CommonInfoBean commonInfoBean = new CommonInfoBean();
//		try
//		{
//			commonInfoBean = loadCommonInfoManager.getCommonInfoBean();
//		} catch ( ServiceException e1 )
//		{
//			e1.printStackTrace();
//		}
//		if(commonInfoBean!=null){
//			List<AirportInfo> listAirport = commonInfoBean.getListAirport();
//			if(listAirport == null){
//				listAirport = airportInfoManager.getAll("airportEname,airportCode");
//			}
//			StringBuffer buff = new StringBuffer();
//			for(AirportInfo airportInfo : listAirport){
//				buff.append( "@" + airportInfo.getAirportEname()+ "|" + airportInfo.getAirportSname() + "|" + airportInfo.getAirportCode());
//			}
//			buff.append( "@" );
//			try
//			{
//				this.getResponse().setCharacterEncoding("UTF-8"); 
//				this.getResponse().setContentType("text; charset=UTF-8");
//				getResponse().getWriter().write( buff.toString() );
//			} catch ( IOException e )
//			{
//				e.printStackTrace();
//				setActionError( e.getMessage() );
//			}
//		}
//		return null;
//	}

	
	
	public static List<HnaProcity> getHnaProcityList(){
		return hnaProcityList;
	}

	
	public static void setHnaProcityList(List<HnaProcity> hnaProcityList)
	{
		CityQryAction.hnaProcityList = hnaProcityList;
	}

	public String getCityCode()
	{
		return cityCode;
	}

	
	public void setCityCode(String cityCode)
	{
		this.cityCode = cityCode;
	}

	
}