/**
 * 
 */
package com.hnatourism.club.pay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class URLConnectionUtil {
	private static final String SERVLET_POST = "POST";
	private static final String SERVLET_GET = "GET";
	private static final String SERVLET_DELETE = "DELETE";
	private static final String SERVLET_PUT = "PUT";

	private static String prepareParam(Map<String, Object> paramMap) {
		StringBuffer sb = new StringBuffer();
		if (paramMap.isEmpty()) {
			return "";
		} else {
			for (String key : paramMap.keySet()) {
				String value = (String) paramMap.get(key);
				if (sb.length() < 1) {
					sb.append(key).append("=").append(value);
				} else {
					sb.append("&").append(key).append("=").append(value);
				}
			}
			return sb.toString();
		}
	}

	public static void doPost(String urlStr, Map<String, Object> paramMap)
			throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(SERVLET_POST);
		String paramStr = prepareParam(paramMap);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		OutputStream os = conn.getOutputStream();
		os.write(paramStr.toString().getBytes("utf-8"));
		os.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn
				.getInputStream()));
		String line;
		String result = "";
		while ((line = br.readLine()) != null) {
			result += "\n" + line;
		}
		System.out.println(result);
		br.close();

	}

	public static void doGet(String urlStr, Map<String, Object> paramMap)
			throws Exception {
		String paramStr = prepareParam(paramMap);
		if (paramStr == null || paramStr.trim().length() < 1) {

		} else {
			urlStr += "?" + paramStr;
		}
		System.out.println(urlStr);
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(SERVLET_PUT);
		conn.setRequestProperty("Content-Type", "text/html; charset=UTF-8");

		conn.connect();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn
				.getInputStream()));
		String line;
		String result = "";
		while ((line = br.readLine()) != null) {
			result += "\n" + line;
		}
		System.out.println(result);
		br.close();
	}

	public static void doPut(String urlStr, Map<String, Object> paramMap)
			throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(SERVLET_PUT);
		String paramStr = prepareParam(paramMap);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		OutputStream os = conn.getOutputStream();
		os.write(paramStr.toString().getBytes("utf-8"));
		os.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn
				.getInputStream()));
		String line;
		String result = "";
		while ((line = br.readLine()) != null) {
			result += "\n" + line;
		}
		System.out.println(result);
		br.close();

	}

	public static void doDelete(String urlStr, Map<String, Object> paramMap)
			throws Exception {
		String paramStr = prepareParam(paramMap);
		if (paramStr == null || paramStr.trim().length() < 1) {
		} else {
			urlStr += "?" + paramStr;
		}
		System.out.println(urlStr);
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(SERVLET_DELETE);
		// 屏蔽掉的代码是错误的，java.net.ProtocolException: HTTP method DELETE doesn't
		// support output
		/*
		 * OutputStream os = conn.getOutputStream();
		 * os.write(paramStr.toString().getBytes("utf-8")); os.close();
		 */

		if (conn.getResponseCode() == 200) {
			System.out.println("成功");
		} else {
			System.out.println(conn.getResponseCode());
		}
	}

	public static void main(String[] args) throws Exception {
		String urlStr = "http://210.51.165.183:8120/chinapnrCardSystem/payAuto.do?details=hongtao1^10.00^content&total_fee=200.00&paymentType=3&notify_url=localhost:8080&seller_details=hongtao^20.00^content&payType=1&partner=918335&orderId=1234&buyer_account=clubtest&sign=62d228969cf7d5f651ae2e10ee983fc3";
		Map<String, Object> map = new HashMap<String, Object>();
		 URLConnectionUtil.doGet(urlStr, map);
		 URLConnectionUtil.doPost(urlStr, map);
		 URLConnectionUtil.doPut(urlStr, map);
		URLConnectionUtil.doDelete(urlStr, map);

	}
}
