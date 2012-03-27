package com.xunruan.framekork.util;

import java.util.Random;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;


/**
* ClassName: SnoGerUtil
* Author: 
* CreateTime:  
* Description:
* Modify： 2010-03-24, wang, 追加UUID编码
**/

public class SnoGerUtil extends RandomUtils{
	private static Random random = new Random();


	/**
	 * @description 【生成33位编码 = 1位业务标志符 + 32位UUID编码】
	 * @param moduleName
	 * @return
	 * @2010-7-1 下午05:12:18
	 * @author wang-wl
	 */
	public static synchronized String getUUID(String moduleName) {
		if(StringUtils.isEmpty(moduleName) || moduleName.length()>1) return null;//by zhangyun  增加参数判断
		StringBuffer result = new StringBuffer(33);
		// 一位标志符
		result.append(moduleName.toUpperCase());//by zhangyun 转换大写
		UUID uuid = UUID.randomUUID();
		// 替换uuid中的'-',保证长度为32为
		result = result.append(uuid.toString().replaceAll("-", ""));

		return result.toString();
	}

	/**
	 * 获取业务流水
	 * @param dateFormat
	 * @param RandomLen
	 * @return
	 * @author zhangyun
	 */
	public static synchronized String getBusNumber(String dateFormat,int RandomLen) {
		return getRandomTimestamp(dateFormat, RandomLen);
	}
	/**
	 * 生成25位编码，格式为：yyMMddHHmmssSSS + 10 随机数
	 */
	public static synchronized String getBusNumber() {
		return getRandomTimestamp("yyMMddHHmmssSSS", 10);
	}

	/**
	 * @description 【获取25位编码】
	 * @param moduleName
	 * @return 
	 * @author wenzheng
	 */
	public static synchronized String getCode(String moduleName) {
		if(StringUtils.isEmpty(moduleName) || moduleName.length()>2) return null;
		StringBuffer result = new StringBuffer();
		result.append(moduleName.toUpperCase());
		//随即数位数
		int ID_BYTES = 7;
		if(moduleName.length() == 2){
			ID_BYTES = 6;
		}
		// 取时间
		result.append(getRandomTimestamp("yyyyMMddHHmmssSSS", ID_BYTES));
		return result.toString();
	}
	
	/**
	 * 生成订单数字编码，格式为：yyMMdd + 4 随机数
	 */
	public static synchronized String getOrderNumber() {
		return getRandomTimestamp("yyyyMMdd", 4);
	}

	/**
	 * 生成批处理编码，格式为：yyMMddHHmmssSSS + 10 随机数
	 */
	public static synchronized String getBatchNo() {
		return getRandomTimestamp("yyyyMMdd", 6);
	}

	/**
	 * 获取指定长度随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		return getRandomNumWithChar(length);
	}
	
	
	/**
	 * 获取指定最大长度随机数
	 * 
	 * @param length
	 * @return
	 */
	public static long getRandomNumber(int maxLength) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < maxLength; i++) {
			buffer.append(getRandomNumWithChar('2'));
		}
		return Long.parseLong(buffer.toString());
	}


	

	
	/**
	 * 获取随机字符
	 * 
	 * @param select
	 *            类型: 0:a-z 1:A-Z 2:0-9
	 * @return
	 */
	public static Character getRandomChar(int select) {
		int tempval = 0;
		if (select == 0) {
			tempval = (int) ((float) 'a' + random.nextFloat()
					* (float) ('z' - 'a'));
		} else if (select == 1) {
			tempval = (int) ((float) 'A' + random.nextFloat()
					* (float) ('Z' - 'A'));
		} else {
			tempval = (int) ((float) '0' + random.nextFloat()
					* (float) ('9' - '0'));
		}
		return new Character((char) tempval);
	}
}
