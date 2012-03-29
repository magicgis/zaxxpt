package com.test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

import com.test.entity.BaseDomainMapper;


public class TestProject  extends SimpleJdbcTestUtils{

	
	
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			BaseDomainMapper baseDomainMapper=(BaseDomainMapper)context.getBean("baseDomainMapper");
			Map<String,Object> baseResultMap=new HashMap<String,Object>();
			baseResultMap.put("id", "123456789qqq");
			baseResultMap.put("username", "admin");
			baseResultMap.put("password", "123456");
			baseResultMap.put("levels", 1);
			baseResultMap.put("cert", 2);
			baseResultMap.put("certinfo", "证书信息qqq");
			baseResultMap.put("certtime", Timestamp.valueOf("2012-03-29 16:00:00"));
			baseResultMap.put("popedommodel", 1);
			baseResultMap.put("createtime", Timestamp.valueOf("2012-03-29 16:00:00"));
			baseResultMap.put("createuser", "admin");
			baseResultMap.put("sts", 2);
			baseResultMap.put("remark", "");
			baseDomainMapper.selectByExample(null);
//			insert into SYSTEM_USERS_ROLE values('123456789ur111','123456789admin','123456789111');
//			insert into SYSTEM_USERS_ROLE values('123456789ur222','123456789admin','123456789333');
//			insert into SYSTEM_USERS_ROLE values('123456789ur333','123456789admin','123456789444');
//			insert into SYSTEM_USERS_ROLE values('123456789ur444','123456789aaa','123456789444');
//			insert into SYSTEM_USERS_ROLE values('123456789ur555','123456789aaa','123456789222');
//			insert into SYSTEM_USERS_ROLE values('123456789ur666','123456789bbb','123456789333');
//
//			insert into SYSTEM_ROLE values('123456789111','管理员',1,sysdate,'admin',1,'');
//			insert into SYSTEM_ROLE values('123456789222','程序员',1,sysdate,'admin',1,'');
//			insert into SYSTEM_ROLE values('123456789333','经理',1,sysdate,'admin',1,'');
//			insert into SYSTEM_ROLE values('123456789444','工程师',1,sysdate,'admin',1,'');
//
//
//
//
//			insert into SYSTEM_USERS values('123456789admin','admin','123456','1','1','证书admin',sysdate,1,sysdate,'admin',1,'');
//			insert into SYSTEM_USERS values('123456789aaa','aaa','123456','1','1','证书aaa',sysdate,1,sysdate,'admin',1,'');
//			insert into SYSTEM_USERS values('123456789bbb','bbb','123456','1','1','证书bbb',sysdate,1,sysdate,'admin',1,'');
//			insert into SYSTEM_USERS values('123456789ccc','ccc','123456','1','1','证书ccc',sysdate,1,sysdate,'admin',1,'');

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
