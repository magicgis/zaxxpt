package com.xunruan.framekork.util;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import com.xunruan.framekork.lang.Application;

import ognl.Ognl;
import ognl.OgnlException;


/**
 * 在OGNL表达式求值时可使用的工具方法集合。
 * 命名规则：
 * 1、不带参数的get方法遵循Java Bean命名规范，以便在表达式中直接以属性的方式访问方法；
 * 2、带参数的方法全部以$开头，以便在OGNL表达式中能明确地与其它方法调用区分开；
 * 
 * 
 * 
 * @author wenz
 */
public class OgnlUtil extends _ArrayUtil {

	public static final OgnlUtil INSTANCE = new OgnlUtil();
	protected OgnlUtil() {}
	public static String $mac(String s){
		return Md5Encrypt.md5(s);
	}
	
	public static Object $ioc(String name) {
		return Application.get().getBean(name);
	}
	
	//过滤器
//	public static <T> List<T> $filter(List<T> list, String name) {
//	}
	
	//对象的获取
//	public static <T> List<T> $objects(String type, String filterName) {
//	}
	
	
	public static Object $iif(Object test, Object trueValue, Object falseValue) {
		if (!StringUtil.isBlank(test) && test instanceof Boolean && (Boolean)test) 
			return trueValue;
		return falseValue;
	}
	
	public static Object $iif(Object test, Object value) {
		return $iif(test, value, "");
	}
	
	public static Object $iif(Object test) {
		return $iif(test, test);
	}
	
	public static String $randomAlphanumeric(int expectLen) {
		return StringUtil.randomAlphanumeric(expectLen);
	}
	

	public static Application getSystem() {
		return Application.get();
	}
	
	/**
	 * 用于在某个对象上执行一个OGNL表达式，主要在FTL模板中使用，如：
	 * <#assign listValue=action.join(action.ognl('#this.{name}', field.fields), "+' '+") />
	 */
	public static Object $ognl(String ognlExpression, Object obj) {
		if (StringUtil.isEmpty(obj)) return null;
		try {
			return Ognl.getValue(ognlExpression, obj);
		} catch (OgnlException e) {
			return "ognl error: '" + ognlExpression + "' with '" + obj + "': "+e.getMessage();
		}
	}	
}
abstract class _MiscUtil {
	
	public static String $capitalFirst(String s) {
		return StringUtil.capitalFirst(s);
	}
	
	public static String $uncapitalFirst(String s) {
		return StringUtil.uncapitalFirst(s);
	}
}
abstract class _DateUtil extends _MiscUtil {

	public static String datePattern = "yyyyMMdd";
	
	public static String getToday() {
		return DateUtils.getYYYYMMDD(new Date());
	}
	public static String getPreToday() {
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(new Date());
    	calendar.add(Calendar.DATE, -1);
    	return  DateUtils.getYYYYMMDD(calendar.getTime()).substring(0, "yyyyMMDD".length());
	}
	public static String getHHMMSS(){
	   return DateUtils.getHHMMSS(new Date());
	}
	
	public static String getFirstDateOfMonth() {
		return DateUtils.getYYYYMMDD(DateUtils.getFirstDateOfMonth(new Date()));
	}
	public static String getFirstDateOfThreeMonthAgo() {
		return DateUtils.getYYYYMMDD(DateUtils.getFirstDateOfMonth(new Date()));
	}
    public static String getPreMonth()
    {
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(new Date());
    	calendar.add(Calendar.MONTH, 1);
    	return  DateUtils.getYYYYMMDD(calendar.getTime()).substring(0, "yyyyMM".length());
    }
    public static String getLastMonth()
    {
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(new Date());
    	calendar.add(Calendar.MONTH, -1);
    	return  DateUtils.getYYYYMMDD(calendar.getTime()).substring(0, "yyyyMM".length());
    }
	/**
	 * 一个月(30天)前日的日期
	 */
	public static Date $beforeDate(int day) {
		return DateUtils.getSomeDaysBeforeDate(day);
	}
	
	/**
	 * 后多少天的日期
	 */
	public static Date $afterDate(int day) {
		return DateUtils.getSomeDaysAfterDate(day);
	}

	// 日期比较
	public static long $compareDate(Object o1, Object o2) throws ParseException {
		String d1, d2;
		if(o1 instanceof String && o1.toString().length() == 6) o1 = o1 + "01";
		if(o2 instanceof String && o2.toString().length() == 6) o2 = o2 + "01";
		d1 = o1 instanceof Date ? DateUtils.getByPattern((Date)o1, _DateUtil.datePattern) : o1.toString();
		d2 = o2 instanceof Date ? DateUtils.getByPattern((Date)o2, _DateUtil.datePattern) : o2.toString();
		return (DateUtil.parseDate(d1, _DateUtil.datePattern).getTime() - 
				DateUtil.parseDate(d2, _DateUtil.datePattern).getTime())/(24*60*60*1000);
	}
	public static String $formatDate(Object o1) throws ParseException {
		if(o1 instanceof Calendar) return DateUtils.format(((Calendar)o1).getTime(), _DateUtil.datePattern);
		if(o1 instanceof Date)  return DateUtils.format((Date)o1, _DateUtil.datePattern);
		return StringUtil.nullable(o1);
	}
	public static String $formatDate(Object o1, String pattern) throws ParseException {
		if(null!=o1 && o1 instanceof String)
			return o1.toString().substring(0,4)+pattern+o1.toString().substring(4,6)+pattern+o1.toString().substring(6,8);
		return StringUtil.nullable(o1);
	}
	public static Date $parseDate(Object o1, String pattern) throws ParseException {
		if (o1 == null) return null;
		return DateUtil.parseDate(o1.toString(), pattern);
	}
	//是否当天
	public static boolean $isToday(Object o1) throws ParseException {
		if (o1 == null) return false;
		Date d1 = o1 instanceof Date ? (Date)o1 : DateUtil.parseDate(o1.toString(), datePattern);
		return DateUtils.isCurrentDate(d1);
	}

	// 日期加一
	public static String $incDate(Object o1) {
		if (o1 == null) return null;
		Date d1 = o1 instanceof Date ? (Date)o1 : DateUtils.parseDate(o1.toString(), datePattern);
		return DateUtils.getByPattern(DateUtils.addFieldValue(d1, Calendar.DATE, 1), datePattern);
	}
	
	public static String $incYear(Object o1) {
		if (o1 == null) return null;
		Date d1 = o1 instanceof Date ? (Date)o1 : DateUtils.parseDate(o1.toString(), datePattern);
		return DateUtils.getByPattern(DateUtils.addFieldValue(d1, Calendar.YEAR, 1), datePattern);
	}
	
	public static String $incDate(Object o,Object o2) {
		Date date;
		if(o == null) date = new Date();
		if(o instanceof Date) 
			date = (Date)o;
		else if(o instanceof String && StringUtil.isNotEmpty(o))
			date = DateUtils.parseDate((String)o, datePattern);
		else
			date = new Date();
		
		if(o2 instanceof String) {
			String pattern = (String) o2;
			if (pattern.length() > 1) {
				String field = pattern.substring(pattern.length() - 1);
				String value = pattern.substring(0, pattern.length() - 1);
				if (value.startsWith("+")) value = value.substring(1);
				return DateUtils.getByPattern(DateUtils.addFieldValue(date, 
						"y".equalsIgnoreCase(field) ? Calendar.YEAR : 
							("m".equalsIgnoreCase(field) ? 
								Calendar.MONTH : Calendar.DATE), 
								Integer.parseInt(value)), datePattern);
			}
		}
		return "";
	}
}
abstract class _AmountUtil extends _DateUtil {
	
	public static String $bigAmount(Object s) {
		return BigAmountUtil.getBigAmount(StringUtil.nullable(s));
	}
}

abstract class _ArrayUtil extends _AmountUtil {
	
	public static boolean $in(Object o1, Object o2) {
		return ArrayUtil.in(o1, o2);
	}
	
	public static <E> Collection<E> $addAll(Collection<E> c1, Collection<E> c2) {
		c1.addAll(c2);
		return c1;
	}
	
	public static <E> Collection<E> $removeAll(Collection<E> c1, Collection<E> c2) {
		c1.removeAll(c2);
		return c1;
	}
	
	/**
	 * 将集合转换为Set，主要用于去除集合中重复存在的对象
	 * @param collection
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Set<Object> $toset(Collection<?> collection) {
		if (collection instanceof Set) return (Set<Object>) collection;
		Set<Object> ret = new TreeSet<Object>();
		for (Object o : collection) ret.add(o);
		return ret;
	}

	public static boolean $empty(Object obj) {
		return StringUtil.isEmpty(obj);
	}
	
	public static Collection<Object> $converseCollection(Collection<?> col) {
		Stack<Object> stack = new Stack<Object>();
		stack.addAll(col);
		Collection<Object> ret = new ArrayList<Object>();
		for (int i = stack.size(); i > 0; i-- ) {
			ret.add(stack.pop());
		}
		return ret;
	}
	
	
	public static List<Object> $toOneLevelList(Object o) {
		List<Object> ret = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(o) && o instanceof Collection) {
			List oo = (List)o;
			if(oo.get(0) instanceof Collection)//包含多重集合的情况
				for(Object ob : oo) {
					if(StringUtil.isNotEmpty(((List)ob).get(0)) && ((List)ob).get(0) instanceof Collection)
						$toOneLevelList(ob);
					else {
						for(Object obb : (List)ob)
							ret.add(obb);
					}
				}
			else {//一层集合，但是集合元素是用逗号分隔的
				for(Object ob : oo) {
					if(ob instanceof String)
						for(Object obb : StringUtil.split((String)ob))
							ret.add(obb);
				}
			}
		}
		return ret;
	}
	
	public static String[] $split(String o) {
		List<String> ret = StringUtil.split(o);
		return ret == null ? null : ret.toArray(new String[ret.size()]);
	}
	
	public static String[] $split(String o, String split) {
		List<String> ret = StringUtil.split(o,split);
		return ret == null ? null : ret.toArray(new String[ret.size()]);
	}
	
	public static int[] $arr(int count) {
		int[] ret = new int[count];
		for (int i = 0; i < count; i++) ret[i] = i;
		return ret;
	}
	
	public static String $join(Object o) {
		return ArrayUtil.join(o);
	}
	
	public static String $join(Object o, String split) {
		return ArrayUtil.join(o, split);
	}
	
	public static String $getJson(Object o) {
		try {
			return GsonUtil.objectToJson(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String $map2str(Map map) {
		return PackUtil.DEFAULT.pack(map);
	}
	
	public static String $maxstr(String s, int maxlength) {
		return StringUtil.maxstr(s, maxlength);
	}
	
	public static String $tosql(String s) {
		return StringUtil.tosql(s);
	}
}
