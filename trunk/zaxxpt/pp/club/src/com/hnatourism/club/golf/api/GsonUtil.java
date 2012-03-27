package com.hnatourism.club.golf.api;

import java.lang.reflect.Type;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hnatourism.framework.utils.StringUtils;

public class GsonUtil {

	/**
	 * json 转换  object 
	 * @param json
	 * @param objectType  Type type = new TypeToken<List<user>>() {  }.getType(); 
	 * @return
	 */
	public static Object jsonToObject(String json,Type objectType){
		if(StringUtils.isEmpty(json) || objectType == null){
			return null;
		}
		GsonBuilder builder=new GsonBuilder();
		Gson gson=builder.create();
		return gson.fromJson(json,objectType);
	}
	//Type type = new TypeToken<List<user>>() {  }.getType(); 
	
	/**
	 * 对象转json
	 * @param obj
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static  String  objectToJson(Object obj) throws SQLException, Exception{
		String json="";
		GsonBuilder builder=new GsonBuilder();
		//格式化输入日期		修改 	 lixun 
		//builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		//不转换没有@Expose注解的字段
//		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson=builder.create();
		json=gson.toJson(obj);
		//System.out.println(json);
		return json;
	}
	
	private static Gson gsonStatic=null;
	static {
		GsonBuilder builder=new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		gsonStatic=builder.create();
	}
	public static  String  objectToJsonAndFormat(Object obj) throws SQLException, Exception{
		return gsonStatic.toJson(obj);
	}
}
