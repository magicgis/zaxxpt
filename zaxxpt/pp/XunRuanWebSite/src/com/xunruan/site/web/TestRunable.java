package com.xunruan.site.web;

import java.io.File;
import java.util.Vector;

import com.xunruan.site.test.TestBase;



public class TestRunable extends TestBase implements Runnable{
	
	public TestRunable(){
		System.out.println("create TestRunable Class");
	}



	public static void main(String[] args) {
		TestRunable r=new TestRunable();
		System.out.println(r);
		Thread t2=new Thread(r);
		t2.start();
		Thread t3=new Thread(r);
		t3.start();
//		r.testMethod();
//		TestBase b=new TestBase();
		
	}


	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(this+""+i);
		}
	}
	
	public void aa(String...aaa){}
}
