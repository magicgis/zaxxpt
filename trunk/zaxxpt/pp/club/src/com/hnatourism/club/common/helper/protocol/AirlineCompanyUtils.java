package com.hnatourism.club.common.helper.protocol;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * 【航空公司的name与code转换工具类】
 * @author liuwei
 *
 */
public class AirlineCompanyUtils {
	public static Map<String, String> AIR_COMPANYS = new HashMap<String, String>();
	static{
		AIR_COMPANYS.put("", "不限制");
		AIR_COMPANYS.put("3U", "川航");
		AIR_COMPANYS.put("8C","东星");
		AIR_COMPANYS.put("8L","祥鹏");
		AIR_COMPANYS.put("9C","春秋");
		AIR_COMPANYS.put("BK","奥凯");
		AIR_COMPANYS.put("CA","国航");
		AIR_COMPANYS.put("CN","大新华");
		AIR_COMPANYS.put("CX","国泰");
		AIR_COMPANYS.put("CY","英安");
		AIR_COMPANYS.put("CZ","南航");
		AIR_COMPANYS.put("EU","成航");
		AIR_COMPANYS.put("FM","上航");
		AIR_COMPANYS.put("G5","华夏");
		AIR_COMPANYS.put("GS","天航");
		AIR_COMPANYS.put("HO","吉祥");
		AIR_COMPANYS.put("HU","海航");
		AIR_COMPANYS.put("JD","首航");
		AIR_COMPANYS.put("KA","港龙");
		AIR_COMPANYS.put("KN","联航");
		AIR_COMPANYS.put("KY","昆航");
		AIR_COMPANYS.put("MF","厦航");
		AIR_COMPANYS.put("MU","东航");
		AIR_COMPANYS.put("N8","港航");
		AIR_COMPANYS.put("NS","东航");
		AIR_COMPANYS.put("OQ","重航");
		AIR_COMPANYS.put("PN","西部");
		AIR_COMPANYS.put("SC","山航");
		AIR_COMPANYS.put("VD","鲲鹏");
		AIR_COMPANYS.put("ZH","深航");
	}
	/**
	 * 【根据name得到code】
	 * @param name
	 * @return
	 */
	public static String getCodeByName(String code){
		Iterator ite = AIR_COMPANYS.keySet().iterator();
		String key ="";
		while(ite.hasNext()){
			key = (String)ite.next();;
			if(key.equals(code)){
				code = AIR_COMPANYS.get(key);
				break;
			}
		}
		return  code ;
	}
	
	/**
	 * 【根据code得到name】
	 * @param code
	 * @return name
	 */
	public static String getNameByCode(String code){
		String name = "";
		if(AIR_COMPANYS.get(code)!=null){
			name = AIR_COMPANYS.get(code);
		}
		return  name ;
	}
	
//	public static Integer getLogoIdByName(String logoName) {
//		logoName = getCodeByName(logoName);
//		if(logoName==null || logoName.equals("")){
//			return null;
//		}
//		logoName="l_"+logoName.toLowerCase();
//		Log.i("logoId",logoName);
//		Integer id = null ;
//		Field field;
//		try {
//			field = R.drawable.class.getDeclaredField(logoName);
//			id =field.getInt(new R());
//			Log.i("logoId",id+"");
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return id;
//		
//	}
}
