package com.hnatourism.club.loungeserver.order;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.club.lounge.order.dao.ILogLoungeOrderDao;
import com.hnatourism.club.loungeserver.LoungeApiService;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:机场休息室日志查询
 * 
 * 历史版本: 2011-9-9 v1.0.0 (lixun) 创建
 * 
 */
public class LoungeOrderLogServiceImpl extends LoungeApiService implements ILoungeOrderLogApiService{
	private ILogLoungeOrderDao logLoungeOrderDao;
	public void endHandler() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		try{
			HashMap<String, Object> perm=(HashMap<String, Object>)super.permeters;
			super.returnObj=logLoungeOrderDao.findByOrderId((String) perm.get("orderId"));
		}catch (Exception e) {
			super.permeters="";
		}
	}

	
	@Override
	public void init(Object permeters, Type type) {
		super.permeters = permeters;
		super.type = type;
	}

	@Override
	public void parameterHandler() throws Exception {
		super.permeters = ParameterHandler.urlPremeter2Map((String) super.permeters);
	}

	@Override
	public Object getResult() {
		return super.returnObj;
	}

	public ILogLoungeOrderDao getLogLoungeOrderDao() {
		return logLoungeOrderDao;
	}

	public void setLogLoungeOrderDao(ILogLoungeOrderDao logLoungeOrderDao) {
		this.logLoungeOrderDao = logLoungeOrderDao;
	}

}
