/**
 * ComUtil.java 1.0.0
 * 系统名(XXXXXXX)
 * 业务区分(共通方法处理类)
 * 履历：
 * NO      	日期     		Ver           	更新者		内容
 * 1     	2009-08-01		V1.0.0          孙洪涛		初版
 */
package com.xunruan.framekork.util;

import java.security.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;

public class ComUtil {
	/**
	 * 将字符串转换成32位MD5码
	 * 
	 * @param strValue 字符串参数
	 * @return String MD5码
	 */
	public final static String strMD5To32byte(String strValue) {
		return strMD5(strValue);
	}
	
	/**
	 * 字符串转换MD5码方法过程
	 * 
	 * @param strValue 字符串参数
	 * @return String MD5码
	 */
	public final static String strMD5(String strValue) {
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
							'a', 'b', 'c', 'd','e', 'f'};
		try {
			byte[] strTemp = strValue.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return String.valueOf(str);
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	  * 将传入的unicode编码转换为字符串
	  * 
	  * @param unicode
	  */
	public static String getUnicodeToString(String unicode){
		if (null == unicode || "".equals(unicode)) {
			return unicode;
		}
		StringBuffer str = new StringBuffer();
		int i = 0;
		while (i < unicode.length()) {
			if (unicode.charAt(i) == '\\'){
				int j = Integer.parseInt(unicode.substring(i + 2, i + 6), 16);
				str.append((char) j);
				i += 6;
			} else {
				str.append(unicode.charAt(i));
				i++;
			}
		}
		return str.toString();
	}
	
	/**
	 * 将传入的字符串转换为unicode编码
	 * 
	 * @param strValue
	 */
	public static String getStringToUnicode(String strValue){
		 String unicode = "";
		 String[] ss = new String[strValue.length()];
		 for (int i = 0; i < strValue.length(); i++) {
			 ss[i] = Integer.toHexString((int) strValue.charAt(i) & 0xffff);
			 if (ss[i].length() == 1) {
				 ss[i] = "000" + ss[i].toUpperCase();
			 } else if (ss[i].length() == 2) {
				 ss[i] = "00" + ss[i].toUpperCase();
			 } else if (ss[i].length() == 3) {
				 ss[i] = '0' + ss[i].toUpperCase();
			 } else {
				 ss[i] = ss[i].toUpperCase();
			 }
			 unicode += "\\u" + ss[i];
		 }
		 return unicode;
	}

	/**
	  * 从服务器端下载文件
	  * 
	  * @param downloadPath 文件地址
	  * @throws Exception
	  */
	public static void downloadFile(HttpServletResponse response, String downloadPath) throws Exception {
		InputStream file;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String fileName = null;
		try {
			fileName = downloadPath.substring(downloadPath.lastIndexOf("/") + 1, downloadPath.length());
			fileName = URLEncoder.encode(fileName, "UTF-8");
			file = new FileInputStream(downloadPath);
			bis = new BufferedInputStream(file);
			bos = new BufferedOutputStream(response.getOutputStream());
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "GBK"));
			response.setContentType("application/x-msdownload");
			response.setCharacterEncoding("UTF-8");
			byte[] buff = new byte[20480];
			int n = -1;
			while ((n = bis.read(buff, 0, buff.length)) != -1) {
				bos.write(buff, 0, n);
			}
			bos.flush();
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			throw new Exception("没有发现文件", e);
		} catch (IOException e) {
			throw new Exception("读写文件错误", e);
		}
	}
	
	/**
	 * 分页处理
	 * 
	 * @param curPage
	 * @param totalPage
	 * @return
	 */
	public static int[] getPage(int curPage, int totalPage){
		int index = 0;
		int[] numbers = null;
		if (totalPage <= 5) {
			index = 1;
			numbers = new int[totalPage];
			for (int i = 0; i < totalPage; i++){
				numbers[i] = i;
			}
		} else {
			numbers = new int[5];
			int temp = (curPage - 1) - (5 / 2);
			if (temp < 0){
				index = 1;
			}else{
				index = curPage - 2;
			}
			
			temp = (5 / 2) - (totalPage - curPage);
			
			if (temp > 0){
				index -= temp;
			}
			for (int i = 0; i < 5; i++){
				numbers[i] = index + i;
			}
		}
		return numbers;
	}
	
	/**
	 * 取得当前时间
	 * 
	 * @return
	 */
	public static Date getNowTime(){
		Date date = new Date();
		return date;
	}
	
	/**
	 * 将时间转换成指定格式
	 * 
	 * @param date
	 * @param formatType
	 * @return
	 */
	public static String getFormatDate(Date date, int formatType){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.format(date);
	}
	
	/**
	 * 将文件复制到指定位置
	 * 
	 * @param sFile 源地址
	 * @param oFile 新地址
	 * @return
	 */
	public static void fileCopy(String sFile, String oFile) {
		File file = new File(sFile);

		if (!file.exists()) {
			System.out.println(sFile + " not have");
			return;
		}
		
		File fileb = new File(oFile);

		if (file.isFile()) {
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(file);
				fos = new FileOutputStream(fileb);
				byte[] bb = new byte[ (int) file.length()];
				fis.read(bb);
				fos.write(bb);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (file.isDirectory()) {
			if (!fileb.exists()) {
				fileb.mkdir();
			}
			String[] fileList;
			fileList = file.list();
			for (int i = 0; i < fileList.length; i++) {
				fileCopy(sFile + "/" + fileList[i], oFile + "/" + fileList[i]);
			}
		}
	}
}