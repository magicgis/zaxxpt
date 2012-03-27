/**
 * 
 */
package com.hnatourism.club.common.util;

/**
 * @author gujianliang
 * @2011-8-23
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


public class Sign {
	
	/**
	 * @model 生成业务请求签名
	 * @comment params 参数对，key 密匙, encodeing 编码
	 * @date 2010-12-28
	 * @return String;
	 */
	public static String signParameter(Map<String,String> params,String key,String encoding){
		StringBuffer sb = new StringBuffer() ;
		Set<String> names = params.keySet() ;
		for(String name:names){
			if(!name.equals("sign")){
				// 判断空 处理空字符串
				if(params.get(name)==null 
						|| params.get(name).trim().length() == 0){
					params.put(name, "");
				}
				sb.append(name).append("=").append(params.get(name).trim()).append("&") ;
			}
		}
		String paramString = sb.deleteCharAt(sb.lastIndexOf("&")).toString() ;
		String[] sort = paramString.split("&") ;
		//排序
		Arrays.sort(sort) ;
		StringBuffer md5Sb = new StringBuffer() ;
		for(int i=0;i<sort.length;i++){
			if (sort[i].split("=").length == 2 && sort[i].split("=")[1].trim().length() > 0) {
				md5Sb.append(sort[i]).append("&");
			}
		}
		String msgData = md5Sb.deleteCharAt(md5Sb.lastIndexOf("&")).append(key).toString() ;
		//md5加密
		String sign = md5(msgData, encoding);
		return sign;
	}
	
	
	 public static String md5(String str, String encoding)
	    {
	        MessageDigest messageDigest = null;
	        try
	        {
	            messageDigest = MessageDigest.getInstance("MD5");
	            messageDigest.reset();
	            messageDigest.update(str.getBytes(encoding));
	        }
	        catch(NoSuchAlgorithmException e)
	        {
	            System.out.println("NoSuchAlgorithmException caught!");
	            System.exit(-1);
	        }
	        catch(UnsupportedEncodingException e)
	        {
	            e.printStackTrace();
	        }
	        byte byteArray[] = messageDigest.digest();
	        StringBuffer md5StrBuff = new StringBuffer();
	        for(int i = 0; i < byteArray.length; i++)
	            if(Integer.toHexString(0xff & byteArray[i]).length() == 1)
	                md5StrBuff.append("0").append(Integer.toHexString(0xff & byteArray[i]));
	            else
	                md5StrBuff.append(Integer.toHexString(0xff & byteArray[i]));

	        return md5StrBuff.toString().toUpperCase().toLowerCase();
	    }
	
	
	 /**
		 * @model 生成业务请求签名
		 * @comment params 参数对，sign 签名
		 * @date 2010-12-28
		 * @return String;
		 */
		public static String map2URL(Map<String,String> params,String sign){
			StringBuffer sb = new StringBuffer() ;
			Set<String> names = params.keySet() ;
			for(String name:names){
				if(!name.equals("sign")){
					// 判断空 处理空字符串
					if(params.get(name)==null 
							|| params.get(name).trim().length() == 0){
						params.put(name, "");
					}
					sb.append(name).append("=").append(params.get(name).trim()).append("&") ;
				}
			}
			String paramString = sb.deleteCharAt(sb.lastIndexOf("&")).toString() ;
			paramString=paramString+"&sign="+sign;
			return paramString;
		}
	 
	 public static void main(String args[]){
		 System.out.println();
	 }
}

