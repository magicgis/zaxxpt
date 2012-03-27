package com.hnatourism.club.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import com.hnatourism.club.common.Constants;
import com.hnatourism.framework.utils.DateFormatUtils;
import com.hnatourism.framework.utils.StringUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:日期处理
 * 
 * 历史版本:
 *					2010-07-21 v1.0.0 (hna) 创建:
 * 
 */
public class DateUtils extends com.hnatourism.framework.utils.DateUtils {

	/**
	 * @description 【取得当前日期】
	 * 默认格式 yyyy-MM-dd HH:mm:ss,如果格式错误,直接返回new Date
	 * @return String
	 * @createTime 2010-7-23 下午02:06:50
	 * @author wang-wl
	 */
	public static Date getCurrentDate() {
		// 当前时间
		Date date = new Date();
		try {
			//默认格式
			String format = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(format);

			String dateStr = DateFormatUtils.format(new Date(), format);
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			date = new Date();
		}   
		return date;
	}
	
	/**
	 * @description 【取得当前日期】
	 * @param format
	 * @return
	 * @createTime 2010-7-23 下午03:01:53
	 * @author wang-wl
	 * @throws ParseException 
	 */
	public static Date getCurrentDate(String format) throws ParseException {
		// 默认格式 yyyy-MM-dd
		return String2Date(getCurrentDateStr(format),format);
	}
	

	/**
	 * @description 【取得当前日期】
	 * 默认格式 yyyy-MM-dd HH:mm:ss
	 * @return String
	 * @createTime 2010-7-23 下午02:06:50
	 * @author wang-wl
	 */
	public static String getCurrentDateStr() {
		// 默认格式 yyyy-MM-dd
		String format = "yyyy-MM-dd";
		return getCurrentDateStr(format);
	}
	
	/**
	 * @description 【得到当前的时间】精确到毫秒，格式为：hh:mm:ss
	 * @return Date
	 * @createTime 2010-7-23 下午02:06:50
	 * @author wang-wl
	 */
	public static String getCurrentTimeStr() {
		// 默认格式 yyyy-MM-dd
		String format = "HH:mm:ss";
		return getCurrentDateStr(format);
	}

	/**
	 * @description 【取得当前日期】
	 * @return String
	 * @createTime 2010-7-23 下午02:06:50
	 * @author wang-wl
	 */
	public static String getCurrentDateStr(String format) {
		// 按格式取得时间
		return DateFormatUtils.format(new Date(), format);
	}

	/**
	 * @description 【字符转化为时间】
	 * @param dateStr
	 * @param format
	 * @return
	 * @createTime 2010-7-23 下午02:38:17
	 * @author wang-wl
	 * @throws ParseException 
	 */
	public static Date String2Date(String dateStr) throws ParseException {
		//默认格式
		String format = "yyyy-MM-dd HH:mm:ss";
		return String2Date(dateStr,format);
	}

	/**
	 * @description 【字符转化为时间】
	 * @param dateStr
	 * @param format
	 * @return
	 * @createTime 2010-7-23 下午02:38:17
	 * @author wang-wl
	 * @throws ParseException 
	 */
	public static Date String2Date(String dateStr, String format) throws ParseException {
		if (StringUtils.isEmpty(dateStr))
			return null;

		// 格式化时间
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(dateStr);

		return date;
	}

	/**
	 * @description 【转化为Timestamp】
	 * @param dateStr
	 * @return
	 * @createTime 2010-7-23 下午02:39:12
	 * @author wang-wl
	 * @throws ParseException 
	 */
	public static Timestamp Date2Timestamp(String dateStr) throws ParseException {
		if (StringUtils.isEmpty(dateStr))
			return null;
		// 转化为日期格式后转化为转化为Timestamp
		String format = "yyyy-MM-dd HH:mm:ss";
		Date date = String2Date(dateStr, format);

		return Date2Timestamp(date);
	}
	
	/**
	 * @description 【Timestamp转化为String】
	 * @param dateStr
	 * @return
	 * @createTime 2011-01-24 上午10:21:12
	 * @author lk-yin
	 * @throws ParseException 
	 */
	public static String Timestamp2Date(String timestampString) throws ParseException {
		if (StringUtils.isEmpty(timestampString))
			return null;
		Long timestamp = Long.parseLong(timestampString) * 1000;
		String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new java.util.Date(timestamp));
		return date;
	}

	/**
	 * @description 【转化为Timestamp】
	 * @param date
	 * @return
	 * @createTime 2010-7-23 下午02:39:12
	 * @author wang-wl
	 */
	public static Timestamp Date2Timestamp(Date date) {
		if (null == date)
			return null;
		// 格式化日期 精确到秒
		String dateStr = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		return Timestamp.valueOf(dateStr.toString());
	}
	/**
	 * @description 【获取日期区间】
	 * @param type
	 * @return
	 * @author wyh
	 * @modify by zhangyun 修改部分写法
	 */
	public static List<Date> getDatePeriod(int type) {
		// 返回时间段
		List<Date> list = new ArrayList<Date>();
		// 当前时间
		Date nowDate = DateUtils.getCurrentDate();
		// 获取当前时间日历
		Calendar calendar = DateUtils.getCalendar(nowDate);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		// 开始时间
		Date startTime = null;
		// 结束时间
		Date endTime = null;
		switch (type) {
		// 当天
		case 1:
			endTime = calendar.getTime();
			startTime = calendar.getTime();
			break;
		// 前三天
		case 2:
			endTime = calendar.getTime();
			startTime = DateUtils.addDay(calendar, -3);
			break;

		// 本周内
		case 3:
			int dayOfWeek = DateUtils.getDayOfWeek(nowDate);
			int endDateNum = 7 - dayOfWeek;
			endTime = DateUtils.addDay(calendar, endDateNum);
			startTime = DateUtils.addDay(calendar, -6);
			break;
		// 最近一个月
		case 4:
			endTime = calendar.getTime();
			startTime = DateUtils.addMonth(calendar, -1);
			break;
		// 最近三个月
		case 5:
			endTime = calendar.getTime();
			startTime = DateUtils.addMonth(calendar, -3);
			break;
		// 最近1年
		case 6:
			endTime = calendar.getTime();
			startTime = DateUtils.addYears(nowDate, -1);
			break;
		}
		list.add(startTime);
		list.add(endTime);
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
		return list;
	}
	
	/**
	 * 转换到时间类型（兼容Linux）
	 * @param DateStr(yyyy-MM-dd)
	 * @return
	 */
	public static Date toDate(String DateStr) {
		Date dt = new Date();
		String[] parts = DateStr.split("-");

		if (parts.length >= 3) {
			int years = Integer.parseInt(parts[0]);
			int months = Integer.parseInt(parts[1]) - 1;
			int days = Integer.parseInt(parts[2]);
			int hours = 0;
			int minutes = 0;
			int seconds = 0;
			GregorianCalendar gc = new GregorianCalendar(years, months, days,
					hours, minutes, seconds);
			dt = gc.getTime();
		}
		return dt;
	}
	/**
	 * 格式化
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date,String format){
		 SimpleDateFormat f = new SimpleDateFormat(format, Locale.getDefault());
		 return  f.format(date); 
	}

	 /**
	  * 用于返回指定日期格式的日期增加指定天数的日期
	  * 
	  * @param date
	  *            指定日期
	  * @param format
	  *            指定日期格式
	  * @param days
	  *            指定天数
	  * @return 指定日期格式的日期增加指定天数的日期
	  */
	 public static String getFutureDay(Date date, String format, int days) {
	  String future = "";
	  try {
	   Calendar calendar = GregorianCalendar.getInstance();
	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	   calendar.setTime(date);
	   calendar.add(Calendar.DATE, days);
	   date = calendar.getTime();
	   future = simpleDateFormat.format(date);
	  } catch (Exception e) {

	  }

	  return future;
	 }
	 
	 public static String getNextDay(Date date, String format, int days) {
		 String future = "";
		 try {
			 Calendar calendar = GregorianCalendar.getInstance();
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			 calendar.setTime(date);
			 date = calendar.getTime();
			 future = simpleDateFormat.format(date);
		 } catch (Exception e) {
			 
		 }
		 
		 return future;
	 }
	 
	 /**
	  * 获取时间差 几天
	  * @author gujianliang
	  * @2011-10-12
	  * @param begin  开始时间
	  * @param end 结束时间
	  * @return
	  * @throws Exception
	  */
	 public static Integer comDate(Date begin,Date end) {
		 long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
		   long day=between/(24*3600);
//		   long hour=between%(24*3600)/3600;
//		   long minute=between%3600/60;
//		   long second=between%60/60;
		   return Integer.valueOf(String.valueOf(day));
	 }
	 
	 /**
	  * 获取日期与当前时间相差的天数
	  * @author gujianliang
	  * @2011-10-12
	  * @param endDate
	  * @return
	  */
	 public static String comDate(Date endDate,Integer expiredDay){
		   Integer day=comDate(new Date(),endDate);
		   return String.valueOf(expiredDay+day);
	 }
	 
	 /**
	  * 积分兑换是否过期
	  * @author gujianliang
	  * @2011-10-12
	  * @param endDate
	  * @return
	  */
	 public static Boolean isExpired(Date endDate,Integer expiredDay){
		 Integer day=comDate(new Date(),endDate);
		 if(expiredDay+day>0){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 
	 public static void main(String[] args){
		 
		 
		 
//		 DateUtils.getDatePeriod(2);
//		 SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//		 try {
//			System.out.println(comDate(sf.parse("2011-10-11"),new Date()));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
