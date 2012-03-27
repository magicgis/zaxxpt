package com.hnatourism.club.common.helper.protocol;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.PropertiesUtils;

public class HttpUtils {

	/**
	 * 【获取服务器上的json字符串】
	 * 
	 * @param conn
	 * @return json格式的字符串
	 * @throws IOException
	 */
	public static String getJsonFromServer(HttpURLConnection conn)
			throws IOException {
		if (conn == null) {
			// return Constants.NETWORKBUG;
		}
		StringBuffer jsonBuffer = new StringBuffer();
		BufferedReader reader = null;
		InputStream stream = null;
		String jsonString = "";
		String isOpenProxy = PropertiesUtils.getVal("sysProps", "isOpenProxy");
		if ("true".equals(isOpenProxy)) {
			System.setProperty("proxyHost", "10.2.32.3");
			System.setProperty("proxyPort", "808");
			System.setProperty("proxyUser", "xfeng_gong");
			System.setProperty("proxyPassword", "123456");
		}
		stream = conn.getInputStream();
		reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
		String line = "";
		while ((line = reader.readLine()) != null) {
			jsonBuffer.append(line);
		}
		reader.close();
		jsonString = jsonBuffer.toString();

		return jsonString;
	}

	public static String getPostJosnFromServer(URL url, String postStr)
			throws IOException {

		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		httpConn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		httpConn.setRequestProperty("User-Agent", "android");

		httpConn.setRequestMethod("POST");

		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();

		out.write(postStr.getBytes("UTF-8"));
		out.close();

		// Read the response and write it to standard out.
		InputStream isr = httpConn.getInputStream();
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		int b;
		while ((b = isr.read()) != -1) {
			bao.write(b);
		}
		isr.close();
		httpConn.disconnect();
		return new String(bao.toByteArray(), "UTf-8");
	}

	/**
	 * 【通过url获得connection】
	 * 
	 * @param urlStr
	 * @return HttpURLConnection 对象
	 */
	public static HttpURLConnection getConnection(String urlStr) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(30 * 1000);
			conn.setRequestMethod("GET");
			conn.connect();
		} catch (Exception e) {
			// Log.e("connectionError", "HttpURLConnection is error");
			return conn;
		}
		return conn;
	}

	/**
	 * 【检查url的网络状态是否通畅】
	 * 
	 * @param urlStr
	 * @return true为网络畅通 false为网络不通
	 */
	public static boolean validateUrl(String urlStr) {
		boolean netStatus = false;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(20 * 1000);
			conn.setReadTimeout(20 * 1000);
			conn.setRequestMethod("GET");
			conn.connect();
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				netStatus = true;
			}
		} catch (Exception e) {
			// Log.e("netError", "network is not ok");
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return netStatus;
	}

	/**
	 * post请求
	 * 
	 * @param urlStr
	 * @param params
	 * @return
	 */
	public static HttpURLConnection getConnection(String urlStr, String params) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Length", String.valueOf(params
					.getBytes().length));
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.connect();
			conn.getOutputStream().write(params.getBytes("UTF-8"));
		} catch (Exception e) {
			// Log.e("connectionError", "HttpURLConnection is error");
			return conn;
		}
		return conn;
	}
	
	/**
	 * 参数格式转换
	 * 
	 * @param urlStr
	 * @param params
	 * @return
	 */
	public static String changeCode(String valueStr) throws BusinessException{
		try {
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化（现在已经使用）
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
			String strTemp = new String(valueStr.getBytes()); 
			valueStr = java.net.URLEncoder.encode(strTemp,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new BusinessException("统一联合登陆参数解析异常。",e);
		}
		return valueStr;
	}

}
