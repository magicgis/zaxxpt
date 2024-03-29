package com.test.entity;

import com.test.entity.SystemUsersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseDomainMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSTEM_USERS
     *
     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
     */
    int countByExample(SystemUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSTEM_USERS
     *
     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
     */
    int deleteByExample(SystemUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSTEM_USERS
     *
     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
     */
//    int deleteByPrimaryKey(String id);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table SYSTEM_USERS
//     *
//     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
//     */
//    int insert(SystemUsers record);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table SYSTEM_USERS
//     *
//     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
//     */
//    int insertSelective(SystemUsers record);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table SYSTEM_USERS
//     *
//     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
//     */
       Map selectByExample(SystemUsersExample example);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table SYSTEM_USERS
//     *
//     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
//     */
//    SystemUsers selectByPrimaryKey(String id);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table SYSTEM_USERS
//     *
//     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
//     */
//    int updateByExampleSelective(@Param("record") SystemUsers record, @Param("example") SystemUsersExample example);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table SYSTEM_USERS
//     *
//     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
//     */
//    int updateByExample(@Param("record") SystemUsers record, @Param("example") SystemUsersExample example);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table SYSTEM_USERS
//     *
//     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
//     */
//    int updateByPrimaryKeySelective(SystemUsers record);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table SYSTEM_USERS
//     *
//     * @mbggenerated Thu Mar 29 08:38:23 GMT+08:00 2012
//     */
//    int updateByPrimaryKey(SystemUsers record);
}