package com.xunruan.framekork.util;



import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wenz
 *
 */
public class StringUtil {
	private static final Log log = LogFactory.getLog(StringUtil.class);
	
	
	/**
	 * 压缩XML字符串，去除无用的空格/tab/换行符
	 * 1、">"和"<"之间的所有空白字符全部去除;
	 * 2、"<"和">"之间的所有相邻空白仅保留一个;
	 */	
	public static String compactXml(String s) {
		StringBuffer ret = new StringBuffer();
		boolean valid = false;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isWhitespace(s.charAt(i))) {
				if (!valid) 
					continue;
				else if (i > 1 && Character.isWhitespace(s.charAt(i - 1)))
					continue;
			}
			if (s.charAt(i) == '<') valid = true;
			if (s.charAt(i) == '>') valid = false;
			ret.append(s.charAt(i));
		}
		return ret.toString();
	}
	
	
	public static boolean equals(Object s1, Object s2) {
		if (s1 == null && s2 == null) return true;
		if (s1 == null && s2 != null) return false;
		return s1.equals(s2);
	}
	
	/**
	 * 判断对象是否为空或仅包含空白字符
	 * @param s
	 * @return
	 */
	public static boolean isBlank(Object s) {
		return isEmptyOrBlank(s, true);
	}

	/**
	 * 判断给定对象s是否为空
	 * 如果s为null，返回真
	 * 如果s是0长字符串，返回真
	 * 如果s是字符串数组，且数组个数为0，返回真
	 * 如果s是字符串数组，且数组中的每个元素都是空字符串，返回真
	 * 如果s是集合，返回Collection.isEmpty
	 * 其它情况返回假
	 */
	public static boolean isEmpty(Object s) {
		return isEmptyOrBlank(s, false);
	}
	public static boolean isNotEmpty(Object s) {
		return !isEmptyOrBlank(s, false);
	}
	private static boolean isEmptyOrBlank(Object s, boolean trim) {
		if (s == null) return true;
		if (s instanceof String) {
			String ss = (String)s;
			return (trim ? ss.trim() : ss).length() == 0;
		}
		if (s instanceof Object[]) {
			for (Object o : (Object[])s) 
				if (!isEmptyOrBlank(o, trim)) return false;
			return true;
		}
		if (s instanceof Collection) {
			for (Object o : (Collection<?>)s) 
				if (!isEmptyOrBlank(o, trim)) return false;
			return true;
		}
		if (s instanceof Map) {
			return ((Map)s).isEmpty();
		}
		return false;
	}
	
	public static boolean isNumeric(String s) {
		if (s == null) return false;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) return false;
		}
		return true;
	}
	
	public static String randomAlphanumeric(int expectLen) {
		return RandomStringUtils.randomAlphanumeric(expectLen);
	}

	public static String nullable(Object s) {
		return s == null ? "" : s.toString();
	}
	
	public static String tosql(String s) {
		return nullable(s).replaceAll("'", "''");
	}
	public static String maxstr(String s, int maxlength) {
		return maxstr(s, "utf8", maxlength);
	}
	
	public static String maxstr(String s, String charset, int maxlength) {
		if (s == null) return null;
		try {
			if (s.getBytes(charset).length <= maxlength) return s;
			StringBuffer ret = new StringBuffer();
			int len = 0;
			for (int i = 0; i < s.length(); i++) {
				String ch = String.valueOf(s.charAt(i));
				ret.append(ch);
				// 用这种方式保证不会截取半个字符，但是否存在效率问题呢？
				len += ch.getBytes(charset).length;
				if (len + 3 > maxlength) break;
			}
			ret.append("...");
			return ret.toString();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getHtmlImgPath(String source){
		int startIndex=source.toUpperCase().indexOf("<IMG");
		String imgSource=source.substring(startIndex);
		startIndex=imgSource.toUpperCase().indexOf("SRC=\"");
		String pathImage=imgSource.substring(startIndex+5);
		int endIndex=pathImage.indexOf("\"");
		String path=pathImage.substring(0,endIndex);
		return path;
	}
	
	
	public static String rtrim(String s, String suffix) {
		if (s.endsWith(suffix)) return s.substring(0, s.length() - suffix.length());
		return s;
	}
	
	public static String capitalFirst(String s) {
		return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
	}
	
	public static String uncapitalFirst(String s) {
		return String.valueOf(s.charAt(0)).toLowerCase() + s.substring(1);
	}
	
	public static String rspace(String s, int n) {
		StringBuffer sb = new StringBuffer();
		sb.append(s);
		for (int i = 0; i < n - s.length(); i++)
			sb.append(" ");
		return sb.toString();
	}
	
	
	
	public static String lpadding(String s, int n, String padding) {
		StringBuffer strbuf = new StringBuffer();
		for (int i = 0; i < n - s.length(); i++) {
			strbuf.append(padding);
		}
		strbuf.append(s);
		return strbuf.toString();
	}
	
	public static String multiPadding(String str, int multi, char ch) {
		if (str.length() % multi == 0) return str;
		return StringUtil.padding(str, (str.length() / multi + 1) * multi, ch);
	}
	
	public static String padding(String str, int len, char ch) {
		for (int i = str.length(); i < len; i++) {
			str += ch;
		}
		return str;
	}
	
	public static String unPadding(String str, char ch) {
		while (str.charAt(str.length() - 1) == ch) str = str.substring(0, str.length() - 1);
		return str;
	}

	public static String space(int n) {
		return space(' ', n);
	}

	public static String space(char space, int n) {
		String ret = "";
		for (int i = 0; i < n; i++) ret += space;
		return ret;
	}
	
	public static boolean isNumber(String str) {
		return Pattern.matches("^(-?\\d+)(\\.\\d+)?$", str);
	}
	
	/**
	 * 取以"."分隔字符串中的前部，若字符串没有包含字符"."，则返回""
	 */
	public static String getFirstByDot(String str) {
		int index = str.indexOf(".");
		if (index == -1) return "";
		return str.substring(0, index);
	}
	
	/**
	 * 取以"."分隔字符串中的后部，若字符串没有包含字符"."，则返回""
	 */
	public static String getSecondByDot(String str) {
		int index = str.indexOf(".");
		if (index == -1) return str;
		return str.substring(index + 1, str.length());
	}
	
	/**
	 * 取以"."分隔字符串中的最后部部，若字符串没有包含字符"."，则返回""
	 */
	public static String getLastByDot(String str) {
		if(str == null) return "";
		int index = str.lastIndexOf(".");
		if (index == -1) return "";
		return str.substring(index + 1);
	}
	
	/**
	 * 将字符串s按空格和逗号拆分为列表
	 * 与String.split方法不同的地方是：本方法的返回结果中不包括零长字符串
	 */
	public static List<String> split(String s) {
		return split(s, "[\\s,]+");
	}
	
	/**
	 * 与String.split方法不同的地方是：本方法的返回结果中不包括零长字符串
	 */
	public static List<String> split(String input, String sep) {
		if (input == null) return null;
		int index = 0;
        List<String> matchList = new ArrayList<String>();
        Matcher m = Pattern.compile(sep).matcher(input);

        // Add segments before each match found
        while(m.find()) {
        	if (index < m.start()) {
                String match = input.subSequence(index, m.start()).toString();
                matchList.add(match);
        	}
            index = m.end();
        }
        
        if (index < input.length())
        matchList.add(input.subSequence(index, input.length()).toString());

       return matchList;
	}
	/**
	 * 得到类似str1,str2,str3的值
	 * @param limit
	 * @param args
	 * @return
	 */
	public static String join(String limit, String ... args) {
		if (args == null) return "";
		return join(limit, Arrays.asList(args));
	}
	/**
	 * 得到类似str1,str2,str3的值
	 * @param limit
	 * @param args
	 * @return
	 */
	public static String join(String limit, List<String> args) {
		if (args == null || args.size() == 0) return "";
		if (args.size() == 1) return args.get(0);
		
		StringBuffer ret = new StringBuffer();
		ret.append(args.get(0));
		for (int i = 1; i < args.size(); i++)
			ret.append(limit).append(args.get(i));
		return ret.toString();
	}
	
	public static String[] objArray2StrArray(Object[] array) {
		String[] ret = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			ret[i] = array[i].toString();
		}
		
		return ret;
	}
	
	public static String subString(String target,String name,String limit){
		int start=target.indexOf(name);
		target=target.substring(start);
		int end=target.indexOf(limit);
		return target.substring(0, end);
	}
	
	public static String dumphex(byte[] bytes) {
		StringBuffer ret = new StringBuffer();
		for (int i = 0; i < bytes.length;) {
			for (int j = 0; j < 16; j++) {
				String hex = i + j >= bytes.length ? ".." : Integer.toHexString(bytes[i+j]);
				if (hex.length() < 2) hex = "00" + hex;
				ret.append(hex.substring(hex.length() - 2, hex.length())).append(j == 7 ? "  " : " ");
			}
			ret.append(" ");
			for (int j = 0; j < 16; j++) {
				ret.append(i + j >= bytes.length ? "." : (char)bytes[i+j]);
			}
			ret.append("\n");
			i += 16;
		}
		return ret.toString();
	}
	
}
