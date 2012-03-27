package com.xunruan.framekork.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.util.DateFormatter;

import com.opensymphony.xwork2.conversion.impl.XWorkBasicConverter;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.util.ValueStack;
import com.xunruan.site.domain.SysUser;

/***
 * 
 * @author wenz
 *
 */
public class ConverterUtil extends XWorkBasicConverter {

	private static final Log log = LogFactory.getLog(ConverterUtil.class);
	private static  ConverterUtil converterUtil;
	
	
	public static ConverterUtil newInstance(){
		if(null==converterUtil) converterUtil=new ConverterUtil();
			return converterUtil;
	}
	
	/***
	 * 匹配类对象中 的字段
	 * @param classs  类对象
	 * @param name    字段名称
	 * @return 字段对象
	 * @author wenz
	 */
	public static Field matchField(Class classs,String name){
		Field[] fields=classs.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if(fields[i].getName().equals(name))
				return fields[i];
		}
		return null;
	}
	
	/***
	 * 匹配类对象中的方法
	 * @param classs  类对象
	 * @param name   方法名
	 * @return   方法对象
	 * @author wenz
	 */
	public static Method matchMethod(Class classs,String name){
		Method[] methods=classs.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			if(methods[i].getName().equals(name))
				return methods[i];
		}
		return null;
	}
	
	/***
	 * 将params中的参数转换到实体类中
	 * @param params  参数对象
	 * @param entity  实体类对象
	 * @return  实体类
	 */
	public static Object paramsToEntity(Map params,final Class entity){
		try {
			Set<Entry<String, Object>> entryseSet = params.entrySet(); 
			for(Map.Entry<String, Object> entry:entryseSet)
			{
				String key=entry.getKey();
				Field field=matchField(entity, key);
				if(null==field)continue;
				String methodName="set"+key.substring(0,1).toUpperCase()+""+key.substring(1);
				Method method=entity.getDeclaredMethod(methodName, field.getType());
				method.invoke(entity, params.get(key));
			}
			return entity.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/***
	 * 将源对象复制到目标对象中
	 * @param <E>  操作对象
	 * @param source  源对象
	 * @param target  目标对象
	 * @param emptyCover  true：为空覆盖  false：为空不覆盖 	 默认复制
	 * @return   target对象
	 * @author wenz
	 */
	public static <E> E copyBean(E source,E target,boolean emptyCover){
		try {
			Field[] fields=target.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				String  setMethodName="set"+fields[i].getName().substring(0,1).toUpperCase()+""+fields[i].getName().substring(1);
				String  getMethodName="get"+fields[i].getName().substring(0,1).toUpperCase()+""+fields[i].getName().substring(1);
				Method  setMethod=matchMethod(target.getClass(), setMethodName);
				Method  getMethod=matchMethod(target.getClass(), getMethodName);
				if(setMethod!=null&&null!=getMethod){
					Object value=getMethod.invoke(source, null);
					if(!emptyCover){
						if(value!=null&&!"".equals(value)){
							setMethod.invoke(target, value);
						}
					}else {
						setMethod.invoke(target, value);
					}
				}
			}
		} catch (Exception e) {
			log.error("",e);
		}
		return target;
	}
	
	
	/**
	 * 从Sring转换数据类型以及Date类型
	 * @param value 转换值
	 * @param classs  数据类型类对象  默认
	 * @param type  数据类型
	 * @return 转换完成的对象
	 */
	public static  Object string2Type(String value,Class classs,String type)
	{
		
		String typeName;
		if(classs==null&&type!=null)
			typeName=type;
		else
			typeName=classs.getName();
		if(null==value||"".equals(value))return value;
		if(null!=typeName)
		{
			try {
				if("int".equals(typeName))
				{
					if(StringUtil.isNumeric(value))
						return Integer.valueOf(value);
				}else if("short".equals(typeName))
				{
					return Short.valueOf(value);
				}else if("float".equals(typeName))
				{
					return Float.valueOf(value);
				}else if("long".equals(typeName))
				{
					return Long.valueOf(value);
				}else if("double".equals(typeName))
				{
					return Double.valueOf(value);
				}else if("char".equals(typeName))
				{
					return Character.valueOf(value.charAt(0));
				}else if("byte".equals(typeName))
				{
					return Byte.valueOf(value);
				}else if("boolean".equals(typeName))
				{
					return Boolean.valueOf(value);
				}else if("java.util.Date".equals(typeName)||"Date".equals(typeName))
				{
					return DateUtils.formate(value);
					
				}else if("java.sql.Timestamp".equals(typeName)||"Timestamp".equals(typeName)){
					Date date=DateUtils.formate(value);
					value=value.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").trim();
					String pattern="yyyyMMdd";
					if(value.length()==14)
						pattern="yyyyMMddHHmmss";
					else if(value.length()==12)
						pattern="yyyyMMddHHmm";
					else if(value.length()==10)
						pattern="yyyyMMddHH";
					return Timestamp.valueOf(DateFormatUtils.format(date,pattern));
				}
			} catch (Exception e) {
				log.error("类型转换错误："+e);
			}
		}
		return value;
	}
	
	
	
	/***
	 * 将Map值转换为Object对象
	 * @param <E> 转换的结果对象
	 * @param map  转换Map
	 * @param e  转换的结果对象
	 * @return
	 */
	public static <E> E MapToObject(Map<String, String> map,E e)throws Exception{
		try {
			Set<Entry<String, String>> entryseSet = map.entrySet(); 
			for(Map.Entry<String, String> entry:entryseSet)
			{
				String key=entry.getKey();
				Field field=matchField(e.getClass(), key);
				if(null==field)continue;
				String methodName="set"+key.substring(0,1).toUpperCase()+""+key.substring(1);
				Method method=e.getClass().getDeclaredMethod(methodName, field.getType());
				method.invoke(e, string2Type(map.get(key),field.getType(),null));
			}
			return e;
		} catch (Exception x) {
			throw new Exception();
		}
	}
	/***
	 * 
	 * @param e  对象
	 * @return   Map 类对象中的属性名称与值的对应
	 */
	public static Map<String, Object> ObjectFieldMap(Object obj){
		Class classs=obj.getClass();
		Map map=new HashMap<String, Object>();
		Field[] fields=classs.getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				Field field=matchField(classs, fields[i].getName());
				String  getMethodName="get"+fields[i].getName().substring(0,1).toUpperCase()+""+fields[i].getName().substring(1);
				Method method=matchMethod(classs, getMethodName);
				Object value=method.invoke(obj, null);
				if(null!=value)
					map.put(field.getName(), value);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("",e);
		}
		return map;
	}
	
	/***
	 * 
	 * @param <E>
	 * @param map
	 * @param e
	 * @return
	 * @throws Exception
	 */
	public static <E> Map  ObjectToMap(Map map,E e)throws Exception{
		Field[] fields=e.getClass().getFields();
		if(null==map)map=new HashMap();
		for (Field field : fields) {
			map.put(field.getName(), field.get(e));
		}
		return map;
	}
	
}
