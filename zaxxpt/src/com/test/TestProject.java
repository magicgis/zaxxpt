package com.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

import com.test.service.UserService;

public class TestProject  extends SimpleJdbcTestUtils{

	
	
	
	public void testIbatis(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService)context.getBean("userService");
		int count=userService.countAll();
		System.out.println(count);
	}
	
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserService userService=(UserService)context.getBean("userService");
			int count=userService.countAll();
			System.out.println(count);
//			DataSource dataSource=(DataSource)context.getBean("dataSource");
//			Connection conn=dataSource.getConnection();
//			System.out.println(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
