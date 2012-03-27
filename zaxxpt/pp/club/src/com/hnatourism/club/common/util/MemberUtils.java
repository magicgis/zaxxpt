package com.hnatourism.club.common.util;

import java.io.UnsupportedEncodingException;

import com.hnatourism.club.common.helper.protocol.Constants;
import com.hnatourism.framework.utils.StringUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:复选框处理处理
 * 
 * 历史版本:
 *					2011-05-09 v1.0.0 (hna) 创建:
 * 
 */
public class MemberUtils{
	//MD5加密key
	private static final String KEY = "hG1jPAWw";
	/**
	 * 获取登陆
	 * @return
	 */
	public static String getLoginString(String isource,String src) {
		String url = null;
		if(StringUtils.isNotEmpty(isource) && isource.equals(Constants.SOURCE_IHZLY)){
			url = getHzlyURL(src);
		}
		return url;
	}
	
	/**
	 * 获取惠众联银链接
	 * @param src 0: 登陆 1:注册
	 * @return url
	 * @author lk-yin
	 * 
	 */
	private static String getHzlyURL(String src){
		// 登陆注册用地址
		String url = Constants.HzlyParam.URL_HZLY_LOGIN;
		StringBuilder sb = new StringBuilder();
		String coopid = Constants.HzlyParam.COOPID;
		String rurl = Constants.HzlyParam.RURL;
		String mkt = String.valueOf(System.currentTimeMillis());
		sb.append(url+"?");
		sb.append("coopid="+coopid);
		sb.append("&src="+src);
		sb.append("&rurl="+getEncodeString(rurl));
		sb.append("&mkt="+mkt);
		//获取签名
		StringBuilder signSb = new StringBuilder();
		signSb.append(coopid+"#"+src+"#"+rurl+"#"+mkt+"#"+KEY);
		String sign = Md5Encrypt.md5(signSb.toString());
		sb.append("&sign="+sign);
		return sb.toString();
	}
	
		/**
		 * 对参数进行url编码
		 * @return
		 */
	private static String getEncodeString(String str) {
		String tempStr = new String(str.getBytes()); 
		try {
			str = java.net.URLEncoder.encode(tempStr,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args){
		System.out.println(getLoginString("ihzly","0"));
	}
}
