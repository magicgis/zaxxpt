package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

import com.sunshine.framework.entity.SystemUsers;
import com.test.entity.SystemUsersMapper;
import com.test.service.UsersService;

public class TestProject  extends SimpleJdbcTestUtils{

	
	
	
	public static void main(String[] args) {
		try {
//			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
////			SystemUsersMapper systemUsersMapper=(SystemUsersMapper)context.getBean("systemUsersMapper");
////			System.out.println(systemUsersMapper.selectByExample(null).size());
//			SqlSessionFactory sqlSessionFactory=(SqlSessionFactory)context.getBean("sqlSessionFactory");
//			Connection conn=sqlSessionFactory.openSession().getConnection();
//			if(!conn.isClosed()){
//				System.out.println(conn);
//				PreparedStatement pre=conn.prepareStatement("select * from SYSTEM_ROLE");
//				ResultSet re=pre.getResultSet();
//				System.out.println(re);
//				System.out.println(re.next());
//				while (re.next()) {
//					System.out.println(re.getString(0));
//					
//				}
//			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","test","Root123456789");
			System.out.println(conn);
			PreparedStatement pre=conn.prepareStatement("select * from SYSTEM_ROLE");
			ResultSet re=pre.getResultSet();
			System.out.println(re);
			System.out.println(re.next());
			while (re.next()) {
				System.out.println(re.getString(0));
			}
//			insert into SYSTEM_USERS values('123456789aaa','aaa','123456','1','1','证书aaa',sysdate,1,sysdate,'admin',1,'');
//			insert into SYSTEM_USERS values('123456789admin','admin','123456','1','1','证书admin',sysdate,1,sysdate,'admin',1,'');
//			insert into SYSTEM_USERS values('123456789bbb','bbb','123456','1','1','证书bbb',sysdate,1,sysdate,'admin',1,'');
//			insert into SYSTEM_USERS values('123456789ccc','ccc','123456','1','1','证书ccc',sysdate,1,sysdate,'admin',1,'');

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
