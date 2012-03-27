package com.xunruan.site.test;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class TestBase {

	
	public TestBase(){
		
		System.out.println("create TestBase Class");
	}
	 
	 protected  static void testMethod(){
		 System.out.println("mehtod...");
		 
		 PropertyPlaceholderConfigurer proper=new PropertyPlaceholderConfigurer();
	 }
}
