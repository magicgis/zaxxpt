package com.hnatourism.club.golf.api;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.lounge.prod.vo.LoungeInfoVo;

public class ParameterHandler {

	
	
	/**
	 * 方法处理
	 * @param method
	 * @param peremeter
	 * @return
	 */
	public static String [] methodsHandler(String method){
		List<String> list=new ArrayList<String>();
		//更新订单
		if("modifyGlofOrder".equals(method)){
			list.add(method);
			list.add("api_saveGlofOrder_log");
			list.add("modifyGlofPriceAmount");
		}else if("api_saveGolfOrder".equals(method)){
			list.add(method);
			list.add("api_saveGlofOrder_log");
			list.add("api_saveOrderGlofPlayer");
			list.add("api_saveOrderContact");
			list.add("modifyGlofPriceAmount");
		}else if("Papi_saveGolfOrder".equals(method)){
			list.add(method.substring(1));
			list.add("api_saveOrderGlofPlayer");
			list.add("api_saveOrderContact");
			list.add("modifyGlofPriceAmount");
		}else if("api_saveGolfOrderException".equals(method)){
			list.add(method);
			list.add("api_saveGlofOrder_log");
			//list.add("updateGlofOrder");
		}else if("modifyGlofOrderExp".equals(method)){
			list.add(method);
			list.add("api_saveGlofOrder_log");
		}else if("modifyGlofOrderCancel".equals(method)){
			list.add(method);
			list.add("modifyGlofPriceAmountCancel");
			list.add("api_saveGlofOrder_log");
		}else{
			list.add(method);
		}
		//订单取消
		//modifyGlofOrderCancel
		//异常订单确认
		//modifyGlofOrderExp
		String [] methods=new String[list.size()];
		for(int i=0;i<list.size();i++){
			methods[i]=String.valueOf(list.get(i));
		}
		return methods;
	}
	
	/**
	 * 传入参数处理
	 * @param methods
	 * @param peremeter
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public static  HashMap parameterHandler(String [] methods,String peremeter) throws Exception{
		HashMap<String,List<HashMap>>  hm=new HashMap<String,List<HashMap>> ();
		hm.clear();
		
		HashMap parameterhm=urlPremeter2Map(peremeter);
		
		for(String method:methods){
			List<HashMap> list=new ArrayList<HashMap>();
			HashMap hm1=new HashMap();
			hm1.clear();
			if("api_saveGlofOrder_log".equals(method)){
				hm1.put("id", UUID.randomUUID().toString().replace("-", ""));
				hm1.put("orderId",parameterhm.get("id"));
				hm1.put("content", parameterhm.get("content"));
				hm1.put("type", "1");
				hm1.put("createUser", parameterhm.get("createUser"));
				hm1.put("createTime", new Date());
			}else if("api_saveGolfOrder".equals(method)){
				//System.out.println("===================method");
				hm1.put("id", parameterhm.get("id"));
				hm1.put("siteId",parameterhm.get("siteId"));
				hm1.put("bookTime", parameterhm.get("bookTime"));
				hm1.put("totalBall", parameterhm.get("totalBall"));
				hm1.put("createTime", new Date());
				hm1.put("price", parameterhm.get("price"));
				hm1.put("additionalFee", parameterhm.get("additionalFee"));
				hm1.put("amountPrice", parameterhm.get("amountPrice"));
				hm1.put("memberCode", parameterhm.get("memberCode"));
				hm1.put("count", parameterhm.get("count"));
				hm1.put("consumerSts", "0");
				hm1.put("operateSts", "0");//锁定
				hm1.put("paySts", "0");
				hm1.put("sts", parameterhm.get("sts"));
				hm1.put("rmk", "");
				hm1.put("code",parameterhm.get("orderCode"));
				hm1.put("profitAmount", parameterhm.get("profitAmount"));
				hm1.put("profit", parameterhm.get("profit"));
				hm1.put("signPrice", parameterhm.get("signPrice"));
				if(parameterhm.get("golfType").toString().equalsIgnoreCase("1"))
				{
					hm1.put("confirmTime", parameterhm.get("bookTime"));
				}
				else
				{
					hm1.put("confirmTime", "");
				}
				if(parameterhm.get("createUser")!=null&&!parameterhm.get("createUser").toString().equalsIgnoreCase(""))
				{
					hm1.put("createUser", parameterhm.get("createUser").toString());
					hm1.put("source", parameterhm.get("source").toString());
				}
				else
				{
					hm1.put("createUser", parameterhm.get("memberCode").toString());
					hm1.put("source", "51666");
				}
			}else if("api_saveOrderGlofPlayer".equals(method)){
				//System.out.println("===================method");
				String name_str=parameterhm.get("playerName").toString().replace("_", "/");
				String[] namelist=name_str.split(",");
				for(int i=1;i<namelist.length;i++)
				{
					HashMap hm2=new HashMap();
					hm2.put("id", UUID.randomUUID().toString().replace("-", ""));
					hm2.put("orderId",parameterhm.get("id"));
					hm2.put("sts",0);
					hm2.put("name", namelist[i]);
					hm2.put("orderType", "NML");
					hm2.put("createUser", parameterhm.get("memberCode"));
					hm2.put("createTime", new Date());
					
					list.add(hm2);
				}
				
				hm1.put("id", UUID.randomUUID().toString().replace("-", ""));
				hm1.put("orderId",parameterhm.get("id"));
				hm1.put("sts",0);
				hm1.put("name", namelist[0]);
				hm1.put("createUser", parameterhm.get("memberCode"));
				hm1.put("createTime", new Date());
			}else if("api_saveOrderContact".equals(method)){
				//System.out.println("===================method");
				hm1.put("id", UUID.randomUUID().toString().replace("-", ""));
				hm1.put("orderId",parameterhm.get("id"));
				hm1.put("orderCode","11111");
				hm1.put("rmk","");
				hm1.put("phone",parameterhm.get("mobile"));
				hm1.put("mobile",parameterhm.get("mobile"));
				hm1.put("email",parameterhm.get("email"));
				hm1.put("city","");
				hm1.put("confirmMode","");
				hm1.put("prodType",parameterhm.get("prodType"));
				hm1.put("address", "");
				hm1.put("name", parameterhm.get("contactName"));
				hm1.put("createUser", parameterhm.get("memberCode"));
				hm1.put("createTime", new Date());
			}else if("api_saveGolfOrderException".equals(method)){
				//System.out.println("===================method");
				hm1.put("id", UUID.randomUUID().toString().replace("-", ""));
				hm1.put("orderId",parameterhm.get("id"));
				hm1.put("paySts", "0");
				hm1.put("consumerSts", "0");
				hm1.put("operateSts", "0");
				if("M".equals( parameterhm.get("type").toString().toUpperCase())){
					hm1.put("sts", "7");
				}
				if("R".equals( parameterhm.get("type").toString().toUpperCase())){
					hm1.put("sts", "4");
				}
				hm1.put("type", parameterhm.get("type"));
				hm1.put("feeRate", parameterhm.get("feeRate"));
				hm1.put("fee", parameterhm.get("fee"));
				hm1.put("price", parameterhm.get("price"));
				hm1.put("rmk", parameterhm.get("rmk"));
				hm1.put("code", SnoGerUtil.getOrderNo());
				hm1.put("createUser", parameterhm.get("createUser"));
				hm1.put("bookTime", parameterhm.get("bookTime"));
				hm1.put("createTime", new Date());
				//多人员处理
				hm1.put("playerIds", parameterhm.get("playerIds"));
			}else if("modifyGlofOrder".equals(method)){
				//System.out.println("===================method");
				hm1.put("id", parameterhm.get("id"));
				hm1.put("sts", parameterhm.get("sts"));
				hm1.put("updateUser", parameterhm.get("createUser"));
				hm1.put("updateTime", new Date());
			}else if("modifyGlofPriceAmount".equals(method)){
				//System.out.println("=========updateGlofPriceAmount==========method");
				hm1.put("id", parameterhm.get("priceid"));
				hm1.put("amount", parameterhm.get("amount"));
				if( parameterhm.get("createUser")!=null){
					hm1.put("updateUser", parameterhm.get("createUser"));
				}
				hm1.put("updateTime", new Date());
			}else if("modifyGlofOrderExp".equals(method)){
				//System.out.println("===================method");
				hm1.put("id", parameterhm.get("expOrderId"));
//				hm1.put("expOrderId", parameterhm.get("id"))
				hm1.put("sts", parameterhm.get("sts"));
				hm1.put("updateUser", parameterhm.get("createUser"));
				hm1.put("updateTime", new Date());
			}
			else{
				
				if(parameterhm==null){
					//System.out.println("===null=======");
				}else{
					//System.out.println("===parameterhm.size()======="+parameterhm.size());
				}
				hm1=parameterhm;
			}
			list.add(hm1);
			hm.put(method, list);
		}
		return hm;
	}
	
	////////////////////工具方法///////////////////////////
	/**
	 * 提取url参数
	 */
	public  static HashMap<String,Object> urlPremeter2Map(String premeters) throws Exception{
		HashMap<String,Object> hm=new HashMap<String,Object>();
		hm.clear();
		String [] premeterArray=premeters.split("&&");
		if(premeters.indexOf("&&")<0){
			premeterArray=premeters.split("&");
		}
		if(premeterArray.length!=0 && !"".equals(premeters)){
			for(String premeter:premeterArray){
				//System.out.println(premeter);
				String name=premeter.substring(0,premeter.indexOf("="));
				String value=premeter.substring(premeter.indexOf("=")+1);
				if(name!=null && !"".equals(name)){
					if("null".equals(value)){
						hm.put(name, null);
					}else{
						SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						if(value.indexOf("-")>0&&value.indexOf(":")>0){
							if(value.indexOf("/")>0){
								sf=new SimpleDateFormat("yyyy-MM-dd/HH:mm");
							}else if(!value.contains("-")){
								sf=new SimpleDateFormat("HH:mm");
							}
							//System.out.println(value);
							hm.put(name, sf.parse(value));
						}else{
							hm.put(name,value);
						}
						
					}
				}
			}
		}else{
			hm=null;
		}
		
		return hm;
	}
	
	/**
	 * url赋值到对象
	 */
	public  static Object urlPremeter2Object(String premeters,Class<?> clazz) throws Exception{
		
		PropertyDescriptor[] props = null;
		//由Introspector获取指定对象所有的可注入方法
    	props = Introspector.getBeanInfo(clazz,Object.class).getPropertyDescriptors();
    	//实例化指定的对象
		Object obj = clazz.newInstance();
		HashMap<String,Object> hm=urlPremeter2Map(premeters);
		if(hm!=null){
			for(int i=0;i<props.length;i++){
				if(hm.get(props[i].getName())!=null){
					if(props[i].getPropertyType()==Date.class){
						props[i].getWriteMethod().invoke(obj,hm.get(props[i].getName()));
					}else if(props[i].getPropertyType()==Double.class){
						String dateStr=String.valueOf(hm.get(props[i].getName()));
						props[i].getWriteMethod().invoke(obj,Double.valueOf(dateStr));
					}else{
						props[i].getWriteMethod().invoke(obj, hm.get(props[i].getName()));
					}
					
				}
			}
		}
		return obj;
	}
	
	/**
	 * 提取对象参数
	 */
	public static HashMap<String,String> objMethd2Map(Object... objs) throws Exception{
		
		HashMap<String,String> hm=new HashMap<String,String>();
		
		if(objs==null)
			return null;
		
		for(Object obj:objs){
			if(obj!=null){
				Field [] fields=obj.getClass().getDeclaredFields();
				for(Field field:fields){
					String value=String.valueOf(obj.getClass().getDeclaredMethod("get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1)).invoke(obj));
					if(value!=null && !"".equals(value) && !"null".equals(value)){
						hm.put(field.getName(), value.trim());
					}
				}
			}
		}
		return hm;
		
	}
	
	/**
	 * map 转换对象
	 * @author gujianliang
	 * @2011-8-23
	 * @param map
	 * @param obj
	 * @return
	 * @throws  Exception 
	 */
	public static Object map2Object(Map map,Object obj) {
		if(obj!=null){
			Field [] fields=obj.getClass().getDeclaredFields();
			try {
			for(Field field:fields){
				if(map.get(field.getName())==null)continue;
				if(field.getType()==String.class){
					obj.getClass().getDeclaredMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1),String.class).invoke(obj,map.get(field.getName()));
				}else if(field.getType()==Double.class){
					obj.getClass().getDeclaredMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1),Double.class).invoke(obj,Double.valueOf(map.get(field.getName()).toString()));
				}else if(field.getType()==Long.class){
					obj.getClass().getDeclaredMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1),Long.class).invoke(obj,Long.valueOf(map.get(field.getName()).toString()));
				}else if(field.getType()==Integer.class){
					obj.getClass().getDeclaredMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1),Integer.class).invoke(obj,Integer.valueOf(map.get(field.getName()).toString()));
				}else if(field.getType()==Date.class){
					String str=map.get(field.getName()).toString();
					Date date=null;
					SimpleDateFormat sf=null;
					String [] formats=new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd/HH:mm:ss","yyyy-MM-dd HH:mm","yyyy-MM-dd","EEE MMM dd HH:mm:ss 'CST' yyyy"};
					for(String strFormat:formats){
						sf=new SimpleDateFormat(strFormat);
						if(str!=null){
						    try{
						    	if(str.indexOf("CST")>0){
						    		sf=new SimpleDateFormat(strFormat, Locale.US);
						    	}
								date=sf.parse(str);
							}catch(ParseException e){}
						}
					}
					if(date!=null){
						obj.getClass().getDeclaredMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1),Date.class).invoke(obj,date);
					}
				}
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return obj;
	}
	
	public static void main(String [] args) throws Exception{
		//LoungeInfoVo  loungeInfoVo=(LoungeInfoVo) urlPremeter2Object("method=sss&&id=222&&name=werwer",LoungeInfoVo.class);
		//System.out.println(loungeInfoVo.getId());
		//System.out.println(loungeInfoVo.getName());
		System.out.println(17/20);
	}
}
