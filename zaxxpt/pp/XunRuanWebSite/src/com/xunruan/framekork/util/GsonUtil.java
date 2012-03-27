package com.xunruan.framekork.util;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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
	
	public static void main(String[] args) {
		List<Map<String, String>> list=new ArrayList<Map<String, String>>();
		Map map1=new HashMap<String, String>();
		map1.put("name","wenzheng");
		map1.put("se", "男");
		map1.put("password", "111111");
		Map map2=new HashMap<String, String>();
		map2.put("name","rongwenqiang");
		map2.put("se", "女");
		map2.put("password", "222222");
		Map map3=new HashMap<String, String>();
		map3.put("name","小春");
		map3.put("se", "男");
		map3.put("password", "333333");
		list.add(map1);list.add(map2);list.add(map3);
		try {
			String gson=GsonUtil.objectToJson(list);
			System.out.println(gson);
			StringBuffer s=new StringBuffer(gson.subSequence(0, gson.length()-1));
			System.out.println("\n"+s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
