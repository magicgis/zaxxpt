package com.hnatourism.club.common.util;

import java.util.Random;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

import com.hnatourism.framework.utils.RandomUtils;
import com.hnatourism.framework.utils.StringUtils;

/**
* ClassName: SnoGerUtil
* Author: 
* CreateTime:  
* Description:
* Modify： 2010-03-24, wang, 追加UUID编码
**/

public class SnoGerUtil extends RandomUtils{
	private static Random random = new Random();
	private static String snoConfig = "applicationContext.xml";
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(snoConfig);
	/**
	 * @description 【用于定制订单号】
	 * @return
	 * @author zhangyun
	 */
	public static synchronized String getOrderNo() {
		String orderNo = null;
		orderNo = getOracleSeq();
		return orderNo;
	}
	
	/**
	 * 生成模块编码前缀的订单号，格式为：模块编号 + 获取9位oracle的序列
	 */
	public static synchronized String getOrderNo(String moduleName) {
		String orderNo = null;
		if(StringUtils.isNotEmpty(moduleName)){
			orderNo = getOracleSeq(moduleName);
		}
		return orderNo;
	}

	/**
	 * @description 【获取9位oracle的序列】
	 * @return
	 * @author zhangyun
	 */
	public static synchronized String getOracleSeq() {
		OracleSequenceMaxValueIncrementer service = (OracleSequenceMaxValueIncrementer) applicationContext.getBean("incre");
		String seq = service.nextStringValue();
		int index = 9-seq.length();
		StringBuffer sb = new StringBuffer();
		if(index>0){
			for(int i = 0;i<index; i++){
				sb.append("0");
			}
		}
		return sb.toString()+seq;
	}
	/**
	 * @description 【获取oracle的序列，增加模块名】
	 * @param moduleName
	 * @return
	 * @author zhangyun
	 */
	public static synchronized String getOracleSeq(String moduleName) {
		return  moduleName + getOracleSeq();
	}
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
	 * @author zhangyun
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
	
//	public static synchronized String getOrderCode(String orderCode) {
//		if(StringUtils.isEmpty(orderCode)) return null;
//		return orderCode.substring(orderCode.length()-16,orderCode.length());
//	}
	/**
	 * 生成订单数字编码，格式为：yyMMdd + 6 随机数
	 */
	public static synchronized String getOrderNumber() {
		return getRandomTimestamp("yyyyMMdd", 6);
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
	 * 获取验证码 默认6位
	 * @return
	 */
	public static synchronized String getCaptchaCode() {
		return getCaptchaCode(6);
	}
	
	/**
	 * 获取验证码
	 * @param RandomLen 位数
	 * @return
	 */
	public static synchronized String getCaptchaCode(int length) {
		StringBuffer buffer = new StringBuffer();
		int randomSelect = 0;
		for (int i = 0; i < length; i++) {
//			System.out.println("random.nextFloat()="+random.nextFloat());
			randomSelect = (int) (random.nextFloat() * 100) % 3;
			buffer.append(getRandomChar(randomSelect));
		}
		return buffer.toString().toUpperCase();
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
 
	
//		//System.out.println(getBatchNo());
//		;
//		//System.out.println(getBusNumber("yyMM",5));
		for(int i=0;i<20;i++){
		//System.out.println(rand.nextInt(6));
		}

	}
}
