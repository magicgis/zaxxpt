package com.xunruan.framekork.dao.sql;


/***
 * 2012-02-16
 * @author wenz
 * @version 1.0
 */
public class SQLTitle {

	public static final String SELECT=" select ";
	public static final String EQ=" = ";
	public static final String NOTEQ=" <> ";
	public static final String GREATER=" > ";
	public static final String GREATEREQ=" >= ";
	public static final String LESS=" < ";
	public static final String LESSEQ=" <= ";
	public static final String LEFTBRACE=" ( ";
	public static final String RIGHTBRACE=" ) ";
	public static final String POINT=".";
	public static final String LIKE=" like";
	public static final String ISNULL=" is null ";
	public static final String ISNOTNULL=" is not null ";
	public static final String AS=" as  ";
	public static final String DOMAIN1=" domain1";
	public static final String DOMAIN2=" domain2";
	public static final String DOMAIN3=" domain3";
	public static final String DOMAIN4=" domain4";
	public static final String COUNT=" count(*) ";
	public static final String GROUP_BY=" gourp by ";
	public static final String WHERE=" where 1=1";
	public static final String FROM=" from ";
	public static final String ASC=" asc ";
	public static final String DESC=" desc ";
	public static final String ORDER_BY=" order by ";
	public static final String BETWEEN=" between ";
	public static final String AND=" and ";
	public static final String IN=" in ";
	public static final String OR=" or ";
	public static final String NOT=" not ";
	public static final String TOP=" top ";
	public static final String LEFT_OUTER_JOIN=" left outer join ";
	public static final String RIGHT_OUTER_JOIN=" right outer join ";
	public static final String FULL_OUTER_JOIN=" full outer join ";
	
	
	public SQLTitle(){
		
	}
	
	/***
	 *COUNT(value)  统计
	 * @param value  字段
	 * @return 函数
	 */
	public static String getCount(String value){
		return "count("+value+")";
	}
	
	
	/***
	 *SUM(value)  求和
	 * @param value  字段
	 * @return 函数
	 */
	public static String getSum(String value){
		return "sum("+value+")";
	}
	
	/***
	 *MIN(value)  获取最小值
	 * @param value  字段
	 * @return 函数
	 */
	public static String getMin(String value){
		return "min("+value+")";
	}
	
	/***
	 *MAX(value)  获取最大值
	 * @param value  字段
	 * @return 函数
	 */
	public static String getMax(String value){
		return "max("+value+")";
	}
	
	/***
	 *AVG(value)求平方
	 * @param value  字段
	 * @return 函数
	 */
	public static String getAvg(String value){
		return "avg("+value+")";
	}
	
	
	/***
	 *REPLACE('string','s1','s2') string  希望被替换的字符或变量   s1      被替换的字符串  s2      要替换的字符串
	 * @param value  字段
	 * @param start  被替换的字符串
	 * @param count   要替换的字符串
	 * @return 函数
	 */
	public static String getReplace(String value,String s1,String s2){
		return "replace("+value+","+s1+","+s2+")";
	}
	
	/***
	 *SUBSTR(string,start,count) 取子字符串,从start开始,取count个
	 * @param value  字段
	 * @param start  开始索引
	 * @param count  长度
	 * @return 函数
	 */
	public static String getSubstr(String value,int start,int count){
		return "substr("+value+","+start+","+count+")";
	}
	
	/***
	 *UPPER 返回字符串,并将所有的字符大写
	 * @param value  字段
	 * @return 函数
	 */
	public static String getUpper(String value){
		return "upper("+value+")";
	}
	
	/***
	 *LOWER 返回字符串,并将所有的字符小写
	 * @param value  字段
	 * @return 函数
	 */
	public static String getLower(String value){
		return "lower("+value+")";
	}
	
	/***
	 *LENGTH 返回字符串的长度;
	 * @param value  字段
	 * @return 函数
	 */
	public static String getLength(String value){
		return "length("+value+")";
	}
	
	/***
	 *INITCAP 返回字符串并将字符串的第一个字母变为大写;
	 * @param value 字段
	 * @return 函数
	 */
	public static String getInitcap(String value){
		return "initcap("+value+")";
	}
	
	
	/***
	 *CONCAT 连接两个字符串
	 * @param value1     字段
	 * @param value2     字段
	 * @return 函数
	 */
	public static String getConcat(String value1,String value2){
		return "concat("+value1+","+value2+")";
	}
	
	/***
	 * CHR 给出整数,返回对应的字符;
	 * @param value   字段
	 * @return 函数
	 */
	public static String getChr(int value){
		return "chr("+value+")";
	}
	
	/***
	 * ASCII 返回与指定的字符对应的十进制数;
	 * @param value 字段
	 * @return 函数
	 */
	public static String getAscii(char value){
		return "ascii("+value+")";
	}
	
	/***
	 * 开平方根 比如传入 144 则开平方根为12
	 * @param value   字段
	 * @return 函数
	 */
	public static String getSqrt(int value){
		return "sqrt("+value+")";
	}
}
