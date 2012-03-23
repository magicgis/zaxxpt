package com.test.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.test.dao.UserDao;


public class UserServiceImpl extends SqlSessionDaoSupport implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public int countAll() {
    	System.out.println(getSqlSession());
        return this.userDao.countAll();
    }
}