package com.xunruan.framekork.util;

import java.util.HashMap;
import java.util.Map;

public class StringUtils extends org.apache.commons.lang.StringUtils
{

	public StringUtils()
	{
	}

	public static int indexOf(String str, String searchChar, int num)
	{
		int index = str.indexOf(searchChar);
		if (num > 1)
		{
			String arr[] = split(str, searchChar);
			int count = arr.length - 1;
			if (count < num)
				num = count;
			index = str.indexOf(arr[num - 1]) + arr[num - 1].length();
		}
		return index;
	}

	public static String toCenterUpperCase(String destStr)
	{
		if (isEmpty(destStr))
			return destStr;
		String attribute = destStr;
		if (destStr.contains("_"))
		{
			attribute = destStr.toLowerCase().trim();
			String str;
			for (int index = -1; (index = attribute.indexOf("_")) != -1; attribute = (new StringBuilder(String.valueOf(attribute.substring(0, index).trim()))).append(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString())
			{
				str = attribute.substring(index + 1).trim();
				if (!"".equals(str.trim()))
					continue;
				attribute = attribute.substring(0, index).trim();
				break;
			}

		}
		return attribute;
	}

	public static String firstToUpper(String str)
	{
		return (new StringBuilder(String.valueOf(str.substring(0, 1).toUpperCase()))).append(str.substring(1)).toString();
	}

	public static String firstToLower(String str)
	{
		return (new StringBuilder(String.valueOf(str.substring(0, 1).toLowerCase()))).append(str.substring(1)).toString();
	}

	public static String toSBC(String input)
	{
		String temp = "";
		for (int i = 0; i < input.length(); i++)
			temp = (new StringBuilder(String.valueOf(temp))).append(toSBC(input.charAt(i))).toString();

		return temp;
	}

	public static char toSBC(char input)
	{
		if (input > ' ' && input < '\177')
			input += '\uFEE0';
		return input;
	}

	public static String add(String destStr)
	{
		String numStr = isEmpty(destStr) ? "1" : (new StringBuilder(String.valueOf(Integer.parseInt(destStr) + 1))).toString();
		return numStr;
	}

	public static void main(String args[])
	{
		Map paraMap = new HashMap();
		paraMap.put("contents", "��ð�����");
		paraMap.put("memberName", "abc");
		paraMap.put("memberId", "abc");
		String destStr = "${contents}<br>�������${memberName}����������ע���ˡ�������ע��һ���ɣ�<a href=\"${host}/signup.action\">ע��</a> ";
		String str = "wsdasd1/1asdas1/1sdadssa/wdwedw";
		System.out.println(indexOf(str, "/", 3));
	}
}
