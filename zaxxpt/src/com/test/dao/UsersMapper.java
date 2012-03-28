package com.test.dao;

import java.util.List;

import com.sunshine.framework.entity.SystemUsers;



public interface UsersMapper {

	

	public SystemUsers getUsers(String id);
	
	public List<SystemUsers> getUsersAll();
}
