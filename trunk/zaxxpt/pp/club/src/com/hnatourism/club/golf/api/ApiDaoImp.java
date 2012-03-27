package com.hnatourism.club.golf.api;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.hnatourism.club.golf.order.vo.GolfOrderExceptionVo;
import com.hnatourism.club.golf.order.vo.GolfOrderPlayVo;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import common.Logger;

public class ApiDaoImp extends AbstractIBatisDaoSupport  implements IApiDao{
	
	final static Logger log=Logger.getLogger(ApiDaoImp.class);
	
	/**
	 * 处理方法  
	 * @param findMethod
	 * @param objs
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public  Object  handler(String [] methods,HashMap<String,List<Map>> hm) throws SQLException, Exception{
		
		Object returnObj = null;
		for(String method:methods){
			if(method.indexOf("save")>=0|| method.indexOf("insert")>=0){
				returnObj=false;
				for(Map hashM:hm.get(method)){
					returnObj=this.getPersistanceManager().insert(method,hashM);
					if("api_saveGolfOrderException".equals(method)){
						api_insertGolfOrderExceptionHandler(returnObj,hashM);
					}
					log.info("insert method "+method);
				}
				returnObj=true;
			}else if(method.indexOf("update")>=0  || method.indexOf("modify")>=0){
				returnObj=false;
				for(Map hashM:hm.get(method)){
					this.getPersistanceManager().update(method,hashM);
					log.info("update method "+method);
				}
				returnObj=true;
			}else{
				if(hm.get(method)!=null){
					returnObj= this.getPersistanceManager().find(method,hm.get(method).get(0));
				}else{
					returnObj= this.getPersistanceManager().find(method);
				}
				log.info("find method"+method);
			}
		}
		return returnObj;
	}
	
	
	public void api_insertGolfOrderExceptionHandler(Object obj,Map hashMap){
		String playerIds=hashMap.get("playerIds").toString();
		if(playerIds==null || "".equals(playerIds)){
			return;
		}
		GolfOrderExceptionVo  gev=(GolfOrderExceptionVo)obj;
		String[] playerIdsArray=playerIds.split(",");
		for(int i=0;i<playerIdsArray.length;i++)
		{
			GolfOrderPlayVo  gop=(GolfOrderPlayVo)this.getPersistanceManager().load("api_findGlofPlayerById", playerIdsArray[i]);
			
			if(gop!=null){
				//是否是退场
				if("4".equals(hashMap.get("sts").toString())){
					//将消费状态置为
					gop.setSts("2");
					this.getPersistanceManager().update("modifyOrderGlofPlayer", gop);
				}
				HashMap hm2=new HashMap();
				hm2.put("id", UUID.randomUUID().toString().replace("-", ""));
				hm2.put("orderId",hashMap.get("id").toString());
				hm2.put("sts",gop.getSts());
				hm2.put("name", gop.getName());
				hm2.put("orderType", "EXC");
				hm2.put("createUser", hashMap.get("createUser").toString());
				hm2.put("createTime", new Date());
				this.getPersistanceManager().insert("api_saveOrderGlofPlayer",hm2);
			}
		}
		
	}
}
