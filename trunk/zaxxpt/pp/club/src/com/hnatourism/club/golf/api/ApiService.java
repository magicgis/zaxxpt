package com.hnatourism.club.golf.api;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiService {

	private IApiDao apiDao;
	
	
	/**
	 * 修改 保存操作  HashMap<String,HashMap>   string 为方法名 hashmap为参数
	 * @param findMethod
	 * @param isDefObject
	 * @param objs
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public Object handler(String [] findMethod,HashMap<String,List<Map>> hm) throws SQLException, Exception{
		Object result=apiDao.handler(findMethod, hm);
		return result;
	}
	
	
	public IApiDao getApiDao() {
		return apiDao;
	}

	public void setApiDao(IApiDao apiDao) {
		this.apiDao = apiDao;
	}
	
}
