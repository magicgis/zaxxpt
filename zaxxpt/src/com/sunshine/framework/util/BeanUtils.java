package com.sunshine.framework.util;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeanUtils {

	/**
	 * 判断<code>subClass</code>Class的子类
	 * 
	 * @param subClass
	 * @param superClass
	 * @return
	 */
	public static boolean isSubClass(Class subClass, Class superClass) {
		if (subClass == null || superClass == null)
			return false;
		if (subClass.equals(Object.class))
			return false;
		else {
			Class subClassSuper = subClass.getSuperclass();
			if (subClassSuper != null) {
				if (subClassSuper.equals(superClass))
					return true;
				else
					return isSubClass(subClass.getSuperclass(), superClass);
			} else {
				return false;
			}
		}
	}

	/**
	 * 判断List是否存在此对像
	 * 
	 * @param list
	 * @param key
	 * @return
	 */
	public static boolean listExists(List list, String key) {
		if (list == null)
			return false;

		for (int i = 0; i < list.size(); i++) {
			String o = (String) list.get(i);
			if (o == key)
				return true;
		}

		return false;
	}

	/**
	 * 为空判断
	 * 
	 * @param fields
	 * @return
	 */
	public static String isNull(String str, String ren) {
		if (str == null || str.length() == 0 || str.equals("null"))
			return ren;
		else
			return str;
	}

	/**
	 * 为空判断
	 * 
	 * @param fields
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0 || str.equals("null");
	}

	/**
	 * 不为空判断
	 * 
	 * @param fields
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && str.length() > 0;
	}

	/**
	 * 为空判断
	 * 
	 * @param fields
	 * @return
	 */
	public static boolean isObjectNull(Object fields) {
		boolean result = false;
		if (fields == null)
			result = true;
		return result;
	}

	/**
	 * 不为空判断
	 * 
	 * @param fields
	 * @return
	 */
	public static boolean isObjectNotNull(Object fields) {
		boolean result = false;
		if (fields != null)
			result = true;
		return result;
	}

	/**
	 * 字符串替换函数 sql = Util.replaceStr(sql, "@userid", baseAttrib.getUserid());
	 * 
	 * @param strSource
	 * @param strFrom
	 * @param strTo
	 * @return
	 */
	public static String replaceStr(String strSource, String strFrom,
			String strTo) {
		if (strSource == null)
			return null;

		int i = 0;
		if ((i = strSource.indexOf(strFrom, i)) >= 0) {
			char[] cSrc = strSource.toCharArray();
			char[] cTo = strTo.toCharArray();
			int len = strFrom.length();
			StringBuffer buf = new StringBuffer(cSrc.length);
			buf.append(cSrc, 0, i).append(cTo);
			i += len;
			int j = i;
			while ((i = strSource.indexOf(strFrom, i)) > 0) {
				buf.append(cSrc, j, i - j).append(cTo);
				i += len;
				j = i;
			}
			buf.append(cSrc, j, cSrc.length - j);
			return buf.toString();
		}
		return strSource;
	}

	/**
	 * 解决下载中文文件名的乱代码处理
	 * 
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					ex.printStackTrace();
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * GBK
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getChar(String str) throws Exception {
		if (str != null)
			str = new String(str.getBytes("iso-8859-1"), "GBK");
		return str;
	}

	/**
	 * 整型判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInt(String str) {
		if (str == null)
			return false;
		int sz = str.length();
		for (int i = 0; i < sz; i++)
			if (!Character.isDigit(str.charAt(i)))
				return false;

		return true;
	}

	/**
	 * support Numeric format:<br>
	 * "33" "+33" "033.30" "-.33" ".33" " 33." " 000.000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {
		int begin = 0;
		boolean once = true;
		if (str == null || str.trim().equals("")) {
			return false;
		}
		str = str.trim();
		if (str.startsWith("+") || str.startsWith("-")) {
			if (str.length() == 1) {
				// "+" "-"
				return false;
			}
			begin = 1;
		}
		for (int i = begin; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				if (str.charAt(i) == '.' && once) {
					// '.' can only once
					once = false;
				} else {
					return false;
				}
			}
		}
		if (str.length() == (begin + 1) && !once) {
			// "." "+." "-."
			return false;
		}
		return true;
	}

	/**
	 * support Integer format:<br>
	 * "33" "003300" "+33" " -0000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isInteger(String str) {
		int begin = 0;
		if (str == null || str.trim().equals(""))
			return false;

		str = str.trim();
		if (str.startsWith("+") || str.startsWith("-")) {
			if (str.length() == 1) {
				// "+" "-"
				return false;
			}
			begin = 1;
		}
		for (int i = begin; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * using Regular Expression
	 * 
	 * support Integer format:<br>
	 * "33" "003300" " -0000 "
	 * 
	 * Date: Jul 30, 2008
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIntegerRegex(String str) {
		Pattern pattern = Pattern.compile("^[+\\-]?\\d+$");
		Matcher matcher = pattern.matcher(str.trim());
		return matcher.matches();
	}

	/**
	 * using Regular Expression
	 * 
	 * support Numeric format:<br>
	 * "33" "+33" "033.30" "-.33" ".33" " 000.000 "
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNumericRegex(String str) {
		Pattern pattern = Pattern.compile("^[+\\-]?((\\d*\\.\\d+)|(\\d+))$");
		Matcher matcher = pattern.matcher(str.trim());
		return matcher.matches();
	}

	/**
	 * 判断是否为Email
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		if (str == null || str.trim().equals(""))
			return false;

		String email1 = "@";
		String email2 = ".";
		if ((str.indexOf(email1) != -1) && (str.indexOf(email2) != -1))
			return true;
		else
			return false;
	}
	/**
	 * 判断是否为中文
	 * @return
	 */
	public static boolean isCNStr(String str){
		
		if (str == null || str.trim().equals(""))
			return false;

		Pattern pattern = Pattern
				.compile("^[\u4e00-\u9fa5]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	/**
	 * 正则判断是否为数字字母组合
	 * @param str
	 * @return
	 */
	public static boolean isNumAndChar(String str){
		if (str == null || str.trim().equals(""))
			return false;

		Pattern pattern = Pattern
				.compile("^[A-Za-z0-9]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	/**
	 * 正则判断是否为字母组合
	 * @param str
	 * @return
	 */
	public static boolean isEnStr(String str){
		if (str == null || str.trim().equals(""))
			return false;

		Pattern pattern = Pattern
				.compile("^[A-Za-z]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	/**
	 * 正则判断是否为Email
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmailRegex(String str) {
		if (str == null || str.trim().equals(""))
			return false;

		Pattern pattern = Pattern
				.compile("^[_a-zA-Z0-9]+(\\.[_a-zA-Z0-9]+)*@[a-zA-Z0-9_-]+(\\.[a-z0-9A-Z-_]+)+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 字符转数字
	 * 
	 * @param intstr
	 * @return
	 */
	public static int stringToInt(String intstr) {
		if (intstr == null) {
			return 0;
		}
		Integer integer;
		integer = Integer.valueOf(intstr);
		return integer.intValue();
	}

	/**
	 * 数字转字符
	 * 
	 * @param value
	 * @return
	 */
	public static String intToString(int value) {
		Integer integer = new Integer(value);
		return integer.toString();
	}

	/**
	 * 字符转小数
	 * 
	 * @param floatstr
	 * @return
	 */
	public static float stringToFloat(String floatstr) {
		Float floatee;
		floatee = Float.valueOf(floatstr);
		return floatee.floatValue();
	}

	/**
	 * 小数转字符
	 * 
	 * @param value
	 * @return
	 */
	public static String floatToString(float value) {
		Float floatee = new Float(value);
		return floatee.toString();
	}

	/**
	 * 要求舍入后返回BigDecimal类型
	 * 
	 * @param dou
	 *            待舍入的数字
	 * @param scale
	 *            返回的BigDecimal对象的标度（scale）
	 * @param roundmode
	 *            舍入模式
	 * @return
	 */
	public static BigDecimal getRound(double dou, int scale, int roundmode) {
		BigDecimal paramNumber = new BigDecimal(dou);
		// 然后调用paramNumber的setScale方法，该方法返回一个 BigDecimal对象temp，
		// 返回值的标度为第一个参数指定的值，标度为大小表示小数部分的位数
		// 第二个参数指定了paramNumber对象到temp对象的舍入模式，如四舍五入等。
		return paramNumber.setScale(scale, roundmode);
		// 实际可以一条语句实现：return new BigDecimal(dou).setScale(0, roundmode);
	}

	/**
	 * 得到一个格式化日期返回Date
	 * 
	 * @return
	 */
	public static Date getFormatDate(Date d) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ed = simpleDateFormat.format(d);
		Date temp = new Date();
		try {
			temp = simpleDateFormat.parse(ed);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return temp;
	}

	/**
	 * 得到一个格式化日期返回Date
	 * 
	 * @return
	 */
	public static Date getFormatDateTime(Date d) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String ed = simpleDateFormat.format(d);
		Date temp = new Date();
		try {
			temp = simpleDateFormat.parse(ed);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return temp;
	}

	/**
	 * 得到一个格式化日期返回String
	 * 
	 * @return
	 */
	public static String getFormatDateStr() {
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(d);
	}

	/**
	 * 得到一个格式化日期返回String
	 * 
	 * @return
	 */
	public static String getFormatDateTimeStr() {
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(d);
	}

	/**
	 * 得到一个格式化日期做为文件名返回String
	 * 
	 * @return
	 */
	public static String getFormatDateTime2FileStr() {
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		return simpleDateFormat.format(d);
	}

	/**
	 * 把字符转为日期时间
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getFormatDateStr(String dateStr) {
		if (isNotEmpty(dateStr)) {
			String strDate2 = null;
			try {
				SimpleDateFormat df = null;
				Date dDate = null;
				try {
					df = new SimpleDateFormat("yyyy-MM-dd");
					dDate = df.parse(dateStr);
				} catch (Exception e) {
					SysLogger.error("BeanUtils getFormatDateStr() Format ERROR! " + dateStr, e);
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				strDate2 = format.format(dDate);
			} catch (Exception e) {
				SysLogger.error("BeanUtils getFormatDateStr() Format ERROR! " + dateStr, e);
			}
			return strDate2;
		} else {
			return null;
		}
	}
	
	/**
	 * 把字符转为日期时间
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getFormatDateTimeStr(String dateStr) {
		if (isNotEmpty(dateStr)) {
			String strDate2 = null;
			try {
				SimpleDateFormat df = null;
				Date dDate = null;
				try {
					df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
					dDate = df.parse(dateStr);
				} catch (Exception e) {
					df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					dDate = df.parse(dateStr);
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				strDate2 = format.format(dDate);
			} catch (Exception e) {
				SysLogger.error("BeanUtils getFormatDateTimeStr() Format ERROR! " + dateStr, e);
			}
			return strDate2;
		} else {
			return null;
		}
	}

	/**
	 * 把字符转为日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getStringToDate(String dateStr) throws Exception {
		if (isNotEmpty(dateStr)) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date temp = null;
			try {
				temp = simpleDateFormat.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new Exception(e);
			}
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * 把字符转为日期时间
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getStringToDateTime(String dateStr) throws Exception {
		if (isNotEmpty(dateStr)) {
			if (dateStr.length() == 10)
				dateStr += " 00:00:00";
			if (dateStr.length() == 16)
				dateStr += ":00";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date temp = null;
			try {
				temp = simpleDateFormat.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new Exception(e);
			}
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * 日期转字符
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateToString(Date date) {
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			return simpleDateFormat.format(date);
		} else {
			return null;
		}
	}

	/**
	 * 日期时间转字符
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTimeToString(Date date) {
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return simpleDateFormat.format(date);
		} else {
			return null;
		}
	}

	/**
	 * HH时间转字符
	 * 
	 * @param date
	 * @return
	 */
	public static String getHourlyToString() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
		return simpleDateFormat.format(date);
	}

	/**
	 * 字符转SQL日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static java.sql.Date stringToDate(String dateStr) {
		return java.sql.Date.valueOf(dateStr);
	}

	/**
	 * SQL日期转字符
	 * 
	 * @param datee
	 * @return
	 */
	public static String dateToString(java.sql.Date datee) {
		return datee.toString();
	}

	/**
	 * 字符转Java日期
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(date);
	}

	/**
	 * Java日期转字符
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String parseStr(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	/**
	 * 字符转Java日期时间
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDateTime(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.parse(date);
	}

	/**
	 * Java时间日期转字符
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String parseStrTime(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	/**
	 * 取出当前日期
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getCurrentDateTime() throws ParseException {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * 取出当前日期年月日
	 * 
	 * @return
	 */
	public static String getCurrentStrDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		return format.format(cal.getTime());
	}

	/**
	 * 取出当前日期年月日时分秒
	 * 
	 * @return
	 */
	public static String getCurrentStrDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return format.format(cal.getTime());
	}

	/**
	 * 取出昨天日期,返回Java日期类型
	 * 
	 * @return
	 */
	public static Date getYesterDayDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 取出昨天日期,返回字符类型
	 * 
	 * @return
	 */
	public static String getYesterDayDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return format.format(cal.getTime());
	}

	/**
	 * 取出明天日期,返回Java日期类型
	 * 
	 * @return
	 */
	public static Date getTomorrowDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		return cal.getTime();
	}

	public static String getLastDay(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(parseDate(date));
		cal.add(Calendar.DATE, -1);
		return format.format(cal.getTime());
	}

	public static Date getNextDay() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	public static String getNextDay(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(parseDate(date));
		cal.add(Calendar.DATE, 1);
		return format.format(cal.getTime());
	}

	public static String getCurrentWeekStart() throws ParseException {
		Calendar cal = Calendar.getInstance();
		Calendar calstart = (Calendar) cal.clone();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		calstart.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_WEEK)
				- dayOfWeek);
		return parseStr(calstart.getTime());
	}

	public static String getCurrentWeekEnd() throws ParseException {
		Calendar cal = Calendar.getInstance();
		Calendar calend = (Calendar) cal.clone();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		calend.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_WEEK)
				- dayOfWeek);
		return parseStr(calend.getTime());
	}

	public static String getLastWeekStart() throws ParseException {
		Calendar cal = Calendar.getInstance();
		Calendar calstart = (Calendar) cal.clone();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		calstart.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_WEEK)
				- dayOfWeek);
		calstart.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_WEEK)
				- dayOfWeek);
		calstart.add(Calendar.DATE, -7);
		return parseStr(calstart.getTime());
	}

	public static String getLastWeekEnd() throws ParseException {
		Calendar cal = Calendar.getInstance();
		Calendar calend = (Calendar) cal.clone();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		calend.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_WEEK)
				- dayOfWeek);
		calend = (Calendar) cal.clone();
		calend.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_WEEK)
				- dayOfWeek);
		calend.add(Calendar.DATE, -7);
		return parseStr(calend.getTime());
	}

	public static String getTheWeekStart(Date date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Calendar calstart = (Calendar) cal.clone();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		calstart.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_WEEK)
				- dayOfWeek);
		return parseStr(calstart.getTime());
	}

	public static String getTheWeekEnd(Date date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Calendar calend = (Calendar) cal.clone();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		calend.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_WEEK)
				- dayOfWeek);
		return parseStr(calend.getTime());
	}

	public static String getTheWeekStart(int weekofyear) throws ParseException {
		Calendar cal = Calendar.getInstance();
		Calendar calstart = (Calendar) cal.clone();
		calstart.add(Calendar.DATE, cal.getActualMinimum(Calendar.WEEK_OF_YEAR)
				- weekofyear);
		return parseStr(calstart.getTime());
	}

	public static String getTheWeekEnd(int weekofyear) throws ParseException {
		Calendar cal = Calendar.getInstance();
		Calendar calend = (Calendar) cal.clone();
		calend.add(Calendar.DATE, cal.getActualMaximum(Calendar.WEEK_OF_YEAR)
				- weekofyear);
		return parseStr(calend.getTime());
	}

	/**
	 * 取出当前月
	 * 
	 * @return
	 */
	public static String getCurrentMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Calendar cal = Calendar.getInstance();
		return format.format(cal.getTime());
	}

	/**
	 * 取出本月第一天的日期
	 * 
	 * @return
	 */
	public static String getLastMonthStart() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int dayOfMoth = cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.MONTH, -1);
		Calendar calstart = (Calendar) cal.clone();
		calstart.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH)
				- dayOfMoth);
		return format.format(calstart.getTime());
	}

	/**
	 * 取出本月最后天的日期
	 * 
	 * @return
	 */
	public static String getLastMonthEnd() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int dayOfMoth = cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.MONTH, -1);
		Calendar calend = (Calendar) cal.clone();
		calend.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH)
				- dayOfMoth);
		return format.format(calend.getTime());
	}

	public static String getCurrentMonthStart() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int dayOfMoth = cal.get(Calendar.DAY_OF_MONTH);
		Calendar calstart = (Calendar) cal.clone();
		calstart.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH)
				- dayOfMoth);
		return format.format(calstart.getTime());
	}

	public static String getCurrentMonthEnd() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int dayOfMoth = cal.get(Calendar.DAY_OF_MONTH);
		Calendar calend = (Calendar) cal.clone();
		calend.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH)
				- dayOfMoth);
		return format.format(calend.getTime());
	}

	public static String getCurrentYear() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Calendar cal = Calendar.getInstance();
		return format.format(cal.getTime());
	}

	public static int getDays(Date startdate, Date enddate)
			throws ParseException {
		Calendar starttime = Calendar.getInstance();
		Calendar endtime = Calendar.getInstance();
		starttime.setTime(startdate);
		endtime.setTime(enddate);

		long subtime = endtime.getTime().getTime()
				- starttime.getTime().getTime();

		int days = (int) (subtime / 86400000);
		return days;
	}

	public static int getMinute(Date startdate, Date enddate)
			throws ParseException {
		Calendar starttime = Calendar.getInstance();
		Calendar endtime = Calendar.getInstance();

		long subtime = endtime.getTimeInMillis() - starttime.getTimeInMillis();

		long result = subtime / (1000 * 60);
		return (int) result;
	}

	/**
	 * 比较两个时间中的差
	 * 
	 * @param date
	 * @param now
	 * @return
	 * @throws ParseException
	 */
	public static String getDateTimeCompare(Date date, Date now)
			throws ParseException {
		long l = now.getTime() - date.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		// return ""+day+"天"+hour+"小时"+min+"分"+s+"秒";
		return "" + ((day * 24) + hour) + "时" + min + "分";
	}

	/**
	 * 取出今天
	 * 
	 * @return
	 */
	public static String getToDay(Date date) {
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		if (today.format(date.getTime()).equals(today.format(c.getTime())))
			return "今天";
		return null;
	}

	/**
	 * 取出昨天
	 * 
	 * @return
	 */
	public static String getYesterDay(Date date) {
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		if (today.format(date.getTime()).equals(today.format(c.getTime())))
			return "昨天";
		return null;
	}

	/**
	 * 取出前天
	 * 
	 * @return
	 */
	public static String getBeforeYesterDay(Date date) {
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -2);
		if (today.format(date.getTime()).equals(today.format(c.getTime())))
			return "前天";
		return null;
	}

	/**
	 * 指定时间与现在时间的差值
	 * 
	 * @param strTime
	 * @return
	 * @throws Exception
	 */
	public static long getGap(String strTime) throws Exception {
		long slong = getStringToDateTime(getCurrentStrDate() + " " + strTime)
				.getTime();
		long gap = System.currentTimeMillis() - slong;
		long awaitTime = gap * -1;
		if (gap >= 0)
			awaitTime = 24 * 60 * 60 * 1000 - gap;
		return awaitTime;
	}
	
	/**
	 * HTML
	 * @param inputString
	 * @return
	 */
	public static String Html2Text(String inputString) {
        String htmlStr = inputString; //含html标签的字符串
        String textStr ="";
	      Pattern p_script;
	      Matcher m_script;
	      Pattern p_style;
	      Matcher m_style;
	      Pattern p_html;
	      Matcher m_html;
	  	   
	      try {
	    	  String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
	    	  String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
	    	  String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式
	      
	          p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
	          m_script = p_script.matcher(htmlStr);
	          htmlStr = m_script.replaceAll(""); //过滤script标签
	
	          p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
	          m_style = p_style.matcher(htmlStr);
	          htmlStr = m_style.replaceAll(""); //过滤style标签
	      
	          p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
	          m_html = p_html.matcher(htmlStr);
	          htmlStr = m_html.replaceAll(""); //过滤html标签
	      
	          textStr = htmlStr.replaceAll("[\\n|\\r|\\t|  ]","");//过滤空格换行Tab符
	      
	      } catch (Exception e) {
	    	  SysLogger.error("HTML2TXT ERROR", e);
	      }
	   
	      return textStr;//返回文本字符串
	}  
	/**
	  * MD5
	  * @param str
	  * @return
	  * @throws Exception
	  */
	 public static String getMD5Str(String str) {  
       MessageDigest messageDigest = null;  
 
       try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();  
			messageDigest.update(str.getBytes("UTF-8"));
       } catch (Exception e) {
			e.printStackTrace();
		}			
 
       byte[] byteArray = messageDigest.digest();  
 
       StringBuffer md5StrBuff = new StringBuffer();  
 
       for (int i = 0; i < byteArray.length; i++) {              
           if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
               md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
           else  
               md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
       }  
 
       return md5StrBuff.toString();  
   }  

}
