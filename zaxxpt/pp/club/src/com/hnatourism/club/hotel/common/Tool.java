package com.hnatourism.club.hotel.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Tool
{
	/**
	 * 对url传递的特殊字符编码
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String transCoding(String str) throws UnsupportedEncodingException
	{
		if(str!=null)
		{
			str=URLEncoder.encode(str, "UTF-8");
		}
		return str;
	}
}
