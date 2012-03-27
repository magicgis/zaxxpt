package com.hnatourism.club.hotel.api.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.hnatourism.club.hotel.api.service.impl.HotelApiManagerImpl;
import com.hnatourism.framework.BusinessException;
import com.hnatourism.framework.utils.IpUtils;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.utils.StringUtils;

/**
 * 酒店请求调用帮助类
 *
 */
public class HotelRequestHelper {
	/**
	 *  日志
	 */
	private static final Log log = LogFactory.getLog(HotelApiManagerImpl.class);
	/**
	 * 酒店接口服务器地址
	 */
	public static final String API_SERVICE_HOTEL = PropertiesUtils.getVal("api_server_hotel");
	
	// 酒店详情调用URL-new
	public static final String API_URL_HOTEL_DETAIL = "/web/phone/prod/hotel/viewHotel.jsp";
	// 酒店详情调用URL-new 
	public static final String API_URL_HOTEL_VIEWHOTEL = "/web/phone/prod/hotel/viewHotel.jsp";
	// 酒店查询调用URL
	public static final String API_URL_HOTEL_SEARCH = "/web/phone/prod/hotel/hotel_search.jsp";
	// 酒店查询调用URL-new 
	public static final String API_URL_HOTEL_SEARCHALL = "/web/phone/prod/hotel/searchAllHotels.jsp";
	// 基于位置地图找店调用URL
	public static final String API_URL_HOTEL_SEARCH_MAP = "/web/phone/prod/hotel/hotel_search_map.jsp";
	// 酒店预定调用URL-new
	public static final String API_URL_HOTEL_BOOK = "/web/phone/book/bookHotel.jsp";
	// 酒店订单查询调用URL
	public static final String API_URL_HOTEL_ORDER_SEARCH = "/web/phone/order/hotel/order_hotel_search.jsp";
	// 酒店预定调用URL
	public static final String API_URL_HOTEL_ORDER_DETAIL = "/web/phone/order/hotel/order_hotel_detail.jsp";
	// 酒店订单取消调用URL
	public static final String API_URL_HOTEL_ORDER_CANCEL = "/web/phone/order/hotel/order_hotel_cancel.jsp";
	// 酒店房型房价房态调用URL
	public static final String API_URL_HOTEL_ROOM_SEARCH = "/web/phone/prod/hotel/searchRoom.jsp";
	// 酒店担保查询URL
	public static final String API_URL_HOTEL_GUARANTEE= "/web/phone/book/queryHotelGuarantee.jsp";
	// 酒店订单状态修改URL add by lixun
	public static final String API_URL_HOTEL_ORDERSTS_UPDATE= "/web/phone/order/hotel/order_hotel_pay.jsp";
	//**********************************************************
	// 公共调用部分
	//**********************************************************
	/**
	 * 调用接口取得返回封装数据
	 * @param returnStr
	 * @param className
	 * @return
	 */
	public static Object findObjectByApi(String urlStr,StringBuffer params,Class className) {
		// 调用接口取得返回数据
		String lines = connection(urlStr,params);
		// 封装数据
		return string2Vo(lines, className);
	}

	/**
	 * post方式发送请求
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String sendByPost(String url,String params) throws Exception{
		String retStr="";
		try{
			//创建url
			URL urlObj = new URL(url);	
			
			//打开http连接
			HttpURLConnection httpConn = (HttpURLConnection)(urlObj.openConnection());
			
			//设置http连接属性
			httpConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
					
			//发送请求数据,并设置为utf-8编码
			OutputStream out = httpConn.getOutputStream();
			out.write(params.getBytes("UTF-8"));
			out.close();
			
			//接受响应数据
			InputStream isr = httpConn.getInputStream();
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			int b;
			while ((b = isr.read()) != -1) {
				bao.write(b);
			}
			isr.close();
			
			//关闭http连接
			httpConn.disconnect();
			
			//返回响应数据,并设置为utf-8编码
			retStr=new String(bao.toByteArray(), "UTF-8");
		}
		catch(Exception e){
			log.error("post方式发送请求异常", e);
			throw new BusinessException("error","网络异常",e);
		}
		
		return retStr;
	}
	
	/**
	 * 调用接口
	 * @param urlStr
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String connection(String urlStr,StringBuffer params) {
		String res = "";
		try {
			res =  sendByPost(urlStr.toString(),params.toString());
		} catch (Exception e) {
			log.error("访问酒店api时网络超时@HotelRequestHelper.connection()"+urlStr+"?"+params,e);
		}
		return res;

//		// 返回结果
//		String lines = "";
//		InputStream in = null;
//		BufferedReader rd = null;
//		HttpURLConnection httpURLConnection = null;
//		try {
//			httpURLConnection = IpUtils.openHttpConnection(urlStr, params, true, "UTF-8", "POST");
//			if(httpURLConnection == null){
//				log.error("网络异常");
//			} else {
//				// 连接调用
//				httpURLConnection.setConnectTimeout(60000);
//				httpURLConnection.setReadTimeout(60000);
//				in = httpURLConnection.getInputStream();
//				rd = new BufferedReader(new InputStreamReader(in, "utf-8"));
//				String line;
//				// 取得返回数据
//				while ((line = rd.readLine()) != null) {
//					lines = lines + line;
//				}
//				////System.out.println("lines="+lines);
//			}
//		} catch (IOException e) {
//			log.error("访问酒店api时网络超时@HotelRequestHelper.connection()"+urlStr+"?"+params,e);
//		} finally {
//			try {
//				if(rd != null){
//					rd.close();
//					in.close();
//					rd = null;
//				}
//				if(null != httpURLConnection){
//					httpURLConnection.disconnect();
//					httpURLConnection=null;
//				}
//
//			} catch (IOException e) {
//				log.error(e);
//			} 
//		}
//		return lines;
	}
	
	/**
	 * 封装数据
	 * @param returnStr
	 * @param className
	 * @return
	 */
	public static Object string2Vo(String returnStr,Class className) {
		Object obj = null;
		try {
			if(StringUtils.isNotBlank(returnStr)){
				Gson gson = new Gson();
				obj = gson.fromJson(returnStr, className);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}
	
}
