package com.xunruan.framekork.util;


import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.hnatourism.framework.utils:
//			StringUtils, DateUtils, ValidateRegexUtils, ValidateUtils

public class DateFormatUtils extends org.apache.commons.lang.time.DateFormatUtils
{

	private static final Log log = LogFactory.getLog(DateFormatUtils.class);

	public DateFormatUtils()
	{
	}

	public static String formatTimestamp(Timestamp timestamp, String format)
	{
		if (timestamp == null || format == null)
			return null;
		else
			return format(timestamp, format);
	}

	public static String formatDateStr(String dateStr, String format)
	{
		StringBuffer dateSb = new StringBuffer();
		if (StringUtils.isNotEmpty(dateStr))
		{
			String dateArr[] = dateStr.split(" ");
			if (dateArr.length > 2)
			{
				Date date = DateUtils.getDate(Integer.parseInt(dateArr[5]), dateArr[1], Integer.parseInt(dateArr[2]));
				dateSb.append(format(date, format));
			} else
			{
				dateSb.append(dateStr);
			}
		}
		return dateSb.toString();
	}

	public static String formatFlightDate(String dateStr, String format, boolean isAddZero)
	{
		String departureDateStr = null;
		if (StringUtils.isNotEmpty(dateStr))
			departureDateStr = formatFlightDate(dateStr, format);
		if (isAddZero && departureDateStr.length() == 4)
			departureDateStr = (new StringBuilder("0")).append(departureDateStr).toString();
		return departureDateStr;
	}

	public static String formatFlightDate(String dateStr)
	{
		StringBuffer dateSb = new StringBuffer();
		if (StringUtils.isNotEmpty(dateStr))
		{
			Date date = null;
			try
			{
				String dateFormat = "yyyy-MM-dd hh:mm:ss";
				if (ValidateUtils.validate(dateStr, ValidateRegexUtils.ISO_DATE_FORMAT))
					dateFormat = "yyyy-MM-dd";
				date = DateUtils.parseDate(dateStr, new String[] {
					dateFormat
				});
			}
			catch (ParseException e)
			{
				log.error("��ʽ���������ڴ���", e);
			}
			dateSb.append(format(date, "ddMMMyy", Locale.US));
		}
		return dateSb.toString();
	}

	public static String formatFlightDate(String dateStr, String format)
	{
		StringBuffer dateSb = new StringBuffer();
		if (StringUtils.isNotEmpty(dateStr))
		{
			Date date = null;
			try
			{
				date = DateUtils.parseDate(dateStr, new String[] {
					format
				});
			}
			catch (ParseException e)
			{
				log.error("��ʽ���������ڴ���", e);
			}
			Calendar c = DateUtils.getCalendar(date);
			int i = c.get(2);
			dateSb.append(c.get(5)).append(DateUtils.MONTH_ENAME[i]);
		}
		return dateSb.toString();
	}

	public static String formatFlightTime(String dateStr, String format)
	{
		StringBuffer dateSb = new StringBuffer();
		String formatDateStr = null;
		if (StringUtils.isNotEmpty(dateStr))
		{
			if ("HHmm".equals(format))
			{
				formatDateStr = dateStr.substring(11, 16);
				formatDateStr = formatDateStr.replace(":", "");
			}
			dateSb.append(formatDateStr);
		}
		return dateSb.toString();
	}

	public static void main(String args[])
	{
		System.out.println((new StringBuilder("==========")).append(formatFlightDate("2010-01-02 22:22:22", "yyyy-MM-dd mm:hh:ss")).toString());
		System.out.println((new StringBuilder("==========")).append(formatFlightDate("2010-01-02 22:22:22")).toString());
	}

}
