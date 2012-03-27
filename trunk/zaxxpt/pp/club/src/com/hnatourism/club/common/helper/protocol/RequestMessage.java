package com.hnatourism.club.common.helper.protocol;

import java.io.IOException;
import java.net.HttpURLConnection;

	/**
	*发送请求类 vo wuyuhu
	*2011-8-23
	*/	
public abstract class RequestMessage {
	//自动登录
	public static final String AUTO_LOGIN=Constants.SERVER_URL;
	//发布网址
	public static final String BASE_REQUEST_URL = AUTO_LOGIN + "/web/phone";

	//测试网址
//	public static final String BASE_REQUEST_URL =(("".equals(Constants.URL)||Constants.URL==null)?("http://www.xhlx.cn/web/phone"):(Constants.URL+ "/web/phone"));
	
	/**
	 * 请求字符串，和URL一起拼成访问接口
	 * 
	 * @return
	 */
	public abstract String getRequsetString();
	/**
	 * 发起request请求
	 * 
	 * @return
	 */
	public String excute() throws Exception{
		HttpURLConnection conn = HttpUtils.getConnection(getRequsetString());
		System.out.println(getRequsetString());
		//Log.i("url", getRequsetString());
		if(conn == null){
			throw new Exception("网络异常");
		}
		String parseResult = "";
		try{
			parseResult = HttpUtils.getJsonFromServer(conn);
		}catch(IOException e){
			e.printStackTrace();
			//throw new Exception("数据解析失败");
		}finally{
			if(null != conn){
				conn.disconnect();
				conn=null;
			}
		}
		return parseResult;
	}
	
	public String excute2() throws Exception{
		String urlStr=getRequsetString();
		String parseResult = "";
		String url= urlStr.substring(0,urlStr.indexOf("?"));
		String params=urlStr.substring(urlStr.indexOf("?")+1,urlStr.length());
		System.out.println(url);
		System.out.println(params);
		HttpURLConnection conn=null;
		try{
		 conn = HttpUtils.getConnection(url,params);
		//Log.i("url", getRequsetString());
		if(conn == null){
			throw new Exception("网络异常");
		}
		
			parseResult = HttpUtils.getJsonFromServer(conn);
		}catch(IOException e){
			e.printStackTrace();
			throw new Exception("数据解析失败");
		}
		finally{
			if(null != conn){
				conn.disconnect();
				conn=null;
			}
		}
		System.out.println(parseResult);
		return parseResult;
		//return null;
	}
}
