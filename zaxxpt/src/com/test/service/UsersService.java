package com.test.service;

import java.util.List;

import com.sunshine.framework.entity.SystemUsers;

/***
 *@author wenz
 *@Date 2012-3-28ионГ11:50:41
 *@version 1.0
 *@see com.test.service.UsersService
 ***/
public interface UsersService {

	public SystemUsers getUsers(String id);
	
	public void testMybatis();
	
	public List<SystemUsers> getUsersAll();
}
