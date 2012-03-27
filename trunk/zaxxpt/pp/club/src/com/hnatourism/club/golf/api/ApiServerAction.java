package com.hnatourism.club.golf.api;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hnatourism.club.common.service.IPriceValidatorService;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.loungeserver.IloungeApiService;
import com.hnatourism.club.loungeserver.LoungeRegistrationCenter;
import com.hnatourism.framework.web.action.BaseAction;


public class ApiServerAction extends BaseAction{

	private static final Log log = LogFactory.getLog(ApiServerAction.class);
	
	private static String SUCCESS="success";
	
	private ApiService apiService;
	private String jsonStr="结果为空或操作失败！请检查操作条件！";
	private String method="";
	private String peremeter="";
	private HashMap<String,List<Map>> parameterMap=new HashMap<String,List<Map>>();
	private String [] methods;
	//休息室方法注册中心
	private LoungeRegistrationCenter loungeRegistrationCenter;
	//价格验证
	private IPriceValidatorService priceValidatorService;
	//会员id
	private String memberId="";
	
	public String execute(){
		//处理接口
		IloungeApiService loungeApiService;
		HttpServletRequest request= ServletActionContext.getRequest();
		try {
			String queryStr=request.getQueryString();
			String queryStr1=URLDecoder.decode(new String(queryStr.getBytes("ISO8859-1")),"UTF-8");
			queryStr1=queryStr1.replace(" ", "");
			if(queryStr1.indexOf("&&")>0){
				peremeter=queryStr1.substring(queryStr1.indexOf("&&")+2);
			}
			Date startTime=new Date();
			
			if(method.indexOf("Lounge")>=0){
				loungeApiService=(IloungeApiService) loungeRegistrationCenter.getClass().getDeclaredMethod(method).invoke(loungeRegistrationCenter);
				loungeApiService.init(peremeter,String.class);
				loungeApiService.parameterHandler();
				loungeApiService.execute();
				loungeApiService.endHandler();
				jsonStr=GsonUtil.objectToJson(loungeApiService.getResult());
			}else{
				methods=ParameterHandler.methodsHandler(method);
				
				if(methods!=null || methods.length!=0){
					//System.out.println("peremeter==========="+peremeter);
					parameterMap=ParameterHandler.parameterHandler(methods, peremeter);
					//价格验证
					if("api_saveGolfOrder".equals(method)){
						GolfOrderVo golfOrderVo=new GolfOrderVo();
						golfOrderVo=(GolfOrderVo) ParameterHandler.map2Object( parameterMap.get(method).get(0),golfOrderVo);
						Boolean bool=priceValidatorService.validatPrice(golfOrderVo, memberId);
						if(bool){
							jsonStr=GsonUtil.objectToJson(apiService.handler(methods,parameterMap));
						}else{
							log.info("价格被篡改!订单已被舍弃");
						}
					}else{
						jsonStr=GsonUtil.objectToJson(apiService.handler(methods,parameterMap));
					}
					
					//System.out.println("==============================="+jsonStr);
				}
			}
			Date endtTime=new Date();
			log.info(" =====execute:method ["+method+"] use time ：["+TimeDistance.getDistanceTime_MS(startTime, endtTime)+"]");
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonStr="error";
		}
		
		return SUCCESS;
	}
	
	public String executeWithFormat(){
		//处理接口
		IloungeApiService loungeApiService;
		HttpServletRequest request= ServletActionContext.getRequest();
		try {
			String queryStr=request.getQueryString();
			String queryStr1=URLDecoder.decode(new String(queryStr.getBytes("ISO8859-1")),"UTF-8");
			queryStr1=queryStr1.replace(" ", "");
			if(queryStr1.indexOf("&&")>0){
				peremeter=queryStr1.substring(queryStr1.indexOf("&&")+2);
			}
			Date startTime=new Date();
			
			if(method.indexOf("Lounge")>=0){
				loungeApiService=(IloungeApiService) loungeRegistrationCenter.getClass().getDeclaredMethod(method).invoke(loungeRegistrationCenter);
				loungeApiService.init(peremeter,String.class);
				loungeApiService.parameterHandler();
				loungeApiService.execute();
				loungeApiService.endHandler();
				//对象转json 并且进行格式化
				jsonStr=GsonUtil.objectToJsonAndFormat(loungeApiService.getResult());
			}else{
				methods=ParameterHandler.methodsHandler(method);
				
				if(methods!=null || methods.length!=0){
					//System.out.println("peremeter==========="+peremeter);
					parameterMap=ParameterHandler.parameterHandler(methods, peremeter);
					//对象转json 并且进行格式化
					jsonStr=GsonUtil.objectToJsonAndFormat(apiService.handler(methods,parameterMap));
					//System.out.println("==============================="+jsonStr);
				}
			}
			Date endtTime=new Date();
			log.info(" =====execute:method ["+method+"] use time ：["+TimeDistance.getDistanceTime_MS(startTime, endtTime)+"]");
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonStr="error";
		}
		
		return SUCCESS;
	}


	
	
	public HashMap<String, List<Map>> getParameterMap() {
		return parameterMap;
	}



	public void setParameterMap(HashMap<String, List<Map>> parameterMap) {
		this.parameterMap = parameterMap;
	}



	public String[] getMethods() {
		return methods;
	}



	public void setMethods(String[] methods) {
		this.methods = methods;
	}

	public ApiService getApiService() {
		return apiService;
	}



	public void setApiService(ApiService apiService) {
		this.apiService = apiService;
	}



	public String getMethod() {
		return method;
	}



	public void setMethod(String method) {
		this.method = method;
	}



	public String getPeremeter() {
		return peremeter;
	}



	public void setPeremeter(String peremeter) {
		this.peremeter = peremeter;
	}

	


	public LoungeRegistrationCenter getLoungeRegistrationCenter() {
		return loungeRegistrationCenter;
	}



	public void setLoungeRegistrationCenter(
			LoungeRegistrationCenter loungeRegistrationCenter) {
		this.loungeRegistrationCenter = loungeRegistrationCenter;
	}



	public IPriceValidatorService getPriceValidatorService() {
		return priceValidatorService;
	}

	public void setPriceValidatorService(
			IPriceValidatorService priceValidatorService) {
		this.priceValidatorService = priceValidatorService;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
