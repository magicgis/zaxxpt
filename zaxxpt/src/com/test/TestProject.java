package com.test;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

import com.sunshine.framework.entity.SystemUsers;
import com.test.service.UsersService;

public class TestProject  extends SimpleJdbcTestUtils{

	
	
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UsersService usersService=(UsersService)context.getBean("usersService");
			List<SystemUsers> list=usersService.getUsersAll();
			System.out.println(list);
			System.out.println(usersService.getUsers("123456789aaa"));
			usersService.testMybatis(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
