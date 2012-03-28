package com.test.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;

import com.sunshine.framework.entity.SystemUsers;
import com.test.dao.UsersMapper;

/***
 *@author wenz
 *@Date 2012-3-28ионГ11:51:06
 *@version 1.0
 *@see com.test.service.UsersServiceImpl
 ***/
public class UsersServiceImpl implements UsersService {

	
	private UsersMapper usersMapper;
	
	private SqlSessionFactory sqlSessionFactory;
	/***
	 *
	 *@author wenz
	 *@Date 2012-3-28ионГ11:51:07
	 *@version 1.0
	 *@return getUsers
	 *@param 
	 ***/
	@Override
	public SystemUsers getUsers(String id) {
		return usersMapper.getUsers(id);
	}

	/***
	 *
	 *@author wenz
	 *@Date 2012-3-28ионГ11:51:07
	 *@version 1.0
	 *@return getUsersAll
	 *@param 
	 ***/
	@Override
	public List<SystemUsers> getUsersAll() {

		return usersMapper.getUsersAll();
	}
	
	
	public void testMybatis(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		System.out.println(sqlSession);
		try {
			System.out.println(sqlSession.getConnection().isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	
}
