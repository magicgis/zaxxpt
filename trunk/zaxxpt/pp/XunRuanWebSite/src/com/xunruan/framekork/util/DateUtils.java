package com.xunruan.framekork.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateUtils extends DateUtil {

	public static String SQL_PATTERN = "yyyy-MM-dd";
	/**
	 * @description 【取得当前日期时间】
	 * 默认格式 yyyy-MM-dd HH:mm:ss,如果格式错误,直接返回new Date
	 * @return String
	 * @createTime 2010-7-23 下午02:06:50
	 * @author wenz
	 */
	public static Date getCurrentDateTime() {
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
	
	
	/***
	 * 将String字符串日期格式化为Date类型日期
	 * @param str
	 * @return
	 * @author wenz
	 * @throws Exception
	 */
	public static Date  formate(String str)throws Exception{
		str=str.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").trim();
		StringBuffer dateBuffer=new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i)))
				dateBuffer.append(str.charAt(i));
		}
		String pattern="yyyyMMdd";
		if(dateBuffer.length()==14)
			pattern="yyyyMMddHHmmss";
		else if(dateBuffer.length()==12)
			pattern="yyyyMMddHHmm";
		else if(dateBuffer.length()==10)
			pattern="yyyyMMddHH";
		SimpleDateFormat  format=new SimpleDateFormat(pattern);
		return format.parse(str);
	}
	
	/**
	 * @description 【取得当前日期】
	 * 默认格式 yyyy-MM-dd,如果格式错误,直接返回new Date
	 * @return String
	 * @createTime 2011-12-15  15:51
	 * @author wenz
	 */
	public static Date getCurrentDate() {
		// 当前时间
		Date date = new Date();
		try {
			//默认格式
			String format = "yyyy-MM-dd";
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
	 * @author wenz
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
	 * @author wenz
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
	 * @author wenz
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
	 * @author wenz
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
	 * @author wenz
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
	 * @author wenz
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
	 * @author wenz
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
	 * @author wenz
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
	 * 格式化日期 
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
	 
	 
	 /**
	  * 获取时间差 几天
	  * @author wenz
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
	  * @author wenz
	  * @2011-10-12
	  * @param endDate
	  * @return
	  */
	 public static String comDate(Date endDate,Integer expiredDay){
		   Integer day=comDate(new Date(),endDate);
		   return String.valueOf(expiredDay+day);
	 }
	 
	 public static String getYYYYMMDD_HHMMSS() {
		return getYYYYMMDD() + " " + getHHMMSS();
	}
	    
	public static String getYYYYMMDD(){
	   	return getYYYYMMDD(new Date());
    }
	    
	public static String getSql(){
	   	return format(new Date(),SQL_PATTERN);
	}
	    
	public static String getCalcSql(Object o,Object o2){
			return getByPattern(calcDate(o,o2), SQL_PATTERN);
	}
	    
	 public static Date calcDate(Object o,Object o2){
	    	Date date ;
	    	if(o == null) date = new Date();
	    	if(o instanceof Date) 
	    		date = (Date)o;
	    	else if(o instanceof String)
	    		date = parseDate((String)o, "yyyyMMdd");
	    	else
	    		date = new Date();
	    	
	    	if(o2 instanceof String && ((String)o2).matches("^[+-]?.*")){
	    		Pattern p = Pattern.compile("(?i)\\s*[+]?((\\d+)|([-]?\\d+))([ymdabc])");
	    		Matcher m = p.matcher((String)(o2));
	    		if(m.matches()){
	    			if(m.group(4).toLowerCase().equals("y"))
	    				return addFieldValue(date, Calendar.YEAR, Integer.parseInt(m.group(1)));
	    			else if(m.group(4).toLowerCase().equals("m"))
	    				return addFieldValue(date, Calendar.MONTH, Integer.parseInt(m.group(1)));
	    			else if(m.group(4).toLowerCase().equals("a"))
	    				return addFieldValue(date, Calendar.HOUR, Integer.parseInt(m.group(1)));
	    			else if(m.group(4).toLowerCase().equals("b"))
	    				return addFieldValue(date, Calendar.MINUTE, Integer.parseInt(m.group(1)));
	    			else if(m.group(4).toLowerCase().equals("c"))
	    				return addFieldValue(date, Calendar.SECOND, Integer.parseInt(m.group(1)));
	    			else
	    				return addFieldValue(date, Calendar.DATE, Integer.parseInt(m.group(1)));
	    		}
	    		
	    	}
	    	return date;
	    }
	    public static String getYYYY(Date date){
	    	SimpleDateFormat f = new SimpleDateFormat("yyyy");
	    	return f.format(date);
	    }
	    
	    public static Date getSybaseDate()
	    {
	    	return forSybase(getSql());
	    }
	    public static String getByPattern(Date date, String pattern) {
	    	SimpleDateFormat f = new SimpleDateFormat(pattern);
	    	return f.format(date);
	    }
	    
	    public static String getYYYYMMDD(Date date) {
	    	SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
	    	return f.format(date);
	    }
	    public static String getDispaly(Date date) {
	    	SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd");
	    	return f.format(date);
	    }
	    public static String getHHMMSS(){
	    	return getHHMMSS(new Date());
	    }
	    
	    public static String getHHMMSS(Date date) {
	    	SimpleDateFormat f = new SimpleDateFormat("HHmmss");
	    	return f.format(date);
	    }
	    
	    /**
	     * 季度，如一季度返回2008/1 
	     */
	    @SuppressWarnings("deprecation")
		public static String getQuarter(Date date) {
	    	int quarter = date.getMonth() / 3 + 1;
	    	return getYYYY(date) + "/" + quarter;
	    }
	    public static Date getDayStart(Date date){
	    	return fromYYYYMMDD(getYYYYMMDD(date));
	    }
	    public static boolean isCurrentDate(Date date) {
	    	return getYYYYMMDD().equals(getYYYYMMDD(date));
	    }
	    
	    public static Date fromYYYYMMDD(String date) {
	    	return parseDate(date, "yyyyMMdd");
	    }
	    public static Date fromYYYYMM(String date) {
	    	return parseDate(date,"yyyyMM");
	    }
	    public static Date forSybase(String date) {
	    	return parseDate(date, SQL_PATTERN);
	    }
	    
	    
		public static String format(String date, String pattern){
	    	for (int i = 0; i < date.length(); i++) {
				if(!Character.isDigit(date.charAt(i)))
					return date;
			}
	    	try {
	    		if(14==date.length())
	    		{
	    			SimpleDateFormat f = new SimpleDateFormat(pattern);
	    			return f.format(DateUtil.parseDate(date, "yyyyMMddHHmmSS"));
	    		}else if(8==date.length())
	    		{
	    			SimpleDateFormat f = new SimpleDateFormat(pattern);
	    			return f.format(DateUtil.parseDate(date, "yyyyMMdd"));
	    		}
			} catch (Exception e) {
				// TODO: handle exception
			}
				return date;
			
	    }
	    
	    public static Date parseDate(String date, String pattern) {
	    	SimpleDateFormat f = new SimpleDateFormat(pattern);
	    	f.setLenient(false);
	    	try {
				return f.parse(date);
			} catch (ParseException e) {
				return null;
			}
	    }
	    
	    public static Date getNextYear()
	    {
	    	Calendar calendar=Calendar.getInstance();
	    	calendar.setTime(new Date());
	    	calendar.add(Calendar.YEAR, 1);
	    	return calendar.getTime() ;
	    }
	    public static Date getNextDay()
	    {
	    	Calendar calendar=Calendar.getInstance();
	    	calendar.setTime(new Date());
	    	calendar.add(Calendar.DATE, 1);
	    	return calendar.getTime() ;
	    }
	    public static String getPreMonth()
	    {
	    	Calendar calendar=Calendar.getInstance();
	    	calendar.setTime(new Date());
	    	calendar.add(Calendar.MONTH, 1);
	    	return  getYYYYMMDD(calendar.getTime()).substring(0, "yyyyMM".length());
	    }
	    public static Date getLastDateOfMonth(int year, int month) {
			if (month == 12) return parseDate(year + "1231", "yyyyMMdd");
	    	month = month + 1;
			Date date = parseDate(year + (month > 9 ? "" + month : "0"+month), "yyyyMM");
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DAY_OF_MONTH, -1);
			return c.getTime();
	    }

	    public static Date getFirstDateOfMonth(int year, int month) {
			return parseDate(year + (month > 9 ? "" + month : "0"+month), "yyyyMM");
	    }
	    
	    public static Date getFirstDateOfMonth(Date date) {
	    	Calendar c = Calendar.getInstance();
	    	c.setTime(date);
	    	return getFirstDateOfMonth(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1);
	    }
	    
	    public static Date getFirstDateOfThreeMonthAgo(Date date) {
	    	Calendar c = Calendar.getInstance();
	    	c.setTime(date);
	    	return getFirstDateOfMonth(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+3);
	    }
	    
	    public static Date getLastDateOfMonth(Date date) {
	    	Calendar c = Calendar.getInstance();
	    	c.setTime(date);
	    	return getLastDateOfMonth(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1);
	    }
	    
	    public static Date digestParts(Date date, String pattern) {
			SimpleDateFormat fmt = new SimpleDateFormat(pattern);
			String str = fmt.format(date);
			try {
				return fmt.parse(str);
			} catch (ParseException exc) {
				throw new IllegalArgumentException("illegal pattern '" + pattern
						+ "' . ", exc);
			}
		}
	    
	    public static Date addFieldValue(Date date, int field, int val){
	    		Calendar c = Calendar.getInstance();
	    		c.setTime(date);
	    		c.add(field, val);
	    		return c.getTime();
	   }
	    
	    /**
		 * n天前的日期
		 */
		public static Date getSomeDaysBeforeDate(int n) {
			return addFieldValue(new Date(), Calendar.DAY_OF_MONTH, 1 - n);
		}
		
		public static Date getSomeDaysBeforeDate(int n, Date date) {
			return addFieldValue(date, Calendar.DAY_OF_MONTH, -n);
		}
		
		/**
		 * n天后的日期
		 */
		public static Date getSomeDaysAfterDate(int n) {
			return addFieldValue(new Date(), Calendar.DAY_OF_MONTH, n);
		}
		
		public static Date getSomeDaysAfterDate(int n, Date date) {
			return addFieldValue(date, Calendar.DAY_OF_MONTH, n);
		}
		
		/**
		 * c1 > c2返回true
		 */
		public static boolean compareTo(Date d1, Date d2) {
			return d1.after(d2);
		}
		
		public static Date trimHMSS(Date date) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			return c.getTime();
		}
		
		/**
		 * 计算两日期之间相差天数
		 * @param date1
		 * @param date2
		 * @return
		 */
		public static long subByDay(Date date1, Date date2) {
			return (trimHMSS(date1).getTime()-trimHMSS(date2).getTime())/(24*60*60*1000);
		}
		/**
		 * 计算两日期之间相差小时数
		 * @param date1
		 * @param date2
		 * @return
		 */
		public static long subByHour(Date date1, Date date2) {
			return (trimHMSS(date1).getTime()-trimHMSS(date2).getTime())/(60*60*1000);
		}
		/**
		 * 计算两月份之差
		 * @return
		 */
		public static int subByMonth(String mon1, String mon2) {
			String year1 = mon1.substring(0, 4);
			String year2 = mon2.substring(0, 4);
			String month1 = mon1.substring(4, 6);
			String month2 = mon2.substring(4, 6);

			int yearcount = Integer.parseInt(year2) - Integer.parseInt(year1);
			int monthcount = Integer.parseInt(month2) - Integer.parseInt(month1);
			
			int count = yearcount * 12 + monthcount;
			return Math.abs(count);
				
			/*
			Date date1 = fromYYYYMM(mon1);
			Date date2 = fromYYYYMM(mon2);
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			int count = 0;
			if(date1.after(date2)){
				c1.setTime(date2);
				c2.setTime(date1);
			}
			else {
				c1.setTime(date1);c2.setTime(date2);
			}
			while(!c1.equals(c2)){
				c1.add(Calendar.MONTH, 1);
				count ++ ;
			}*/
		}
		

}
