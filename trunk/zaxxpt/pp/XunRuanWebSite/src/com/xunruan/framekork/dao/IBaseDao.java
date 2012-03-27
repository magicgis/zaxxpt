package com.xunruan.framekork.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.xunruan.framekork.domain.BaseDomain;
import com.xunruan.framekork.lang.PageInfo;


/***
 * 
 * @author wenz
 * 数据库操基础接口
 * 2011-12-15 16:25
 * @param <E> 操作的对象
 */
public  interface IBaseDao<E extends BaseDomain> {

	/***
	 * 向数据库中插入数据
	 * @param e  插入数据的对象
	 * @return
	 */
	public  Object insert(E e);
	/***
	 * 修改数据
	 * @param e  修改的对象
	 * @return
	 */
	public  Object update(E e);
	
	/***
	 * 删除数据
	 * @param e 删除对象
	 * @return
	 */
	public  Object delete(E e);
	
	/***
	 * 查询所有数据
	 * @param classs  类对象
	 * @return
	 */
	public   List<E> find(Class<E> classs);
	
	
	/***
	 * 查询所有数据
	 * @param classs  类对象
	 * @param page    分页对象
	 * @return
	 */
	public   PageInfo<E> find(Class<E> classs,PageInfo<E> page);
	
	/***
	 * 通过Id查询数据
	 * @param classs  类对象
	 * @param id  数据Id
	 * @return
	 */
	public  E findById(Class<E> classs,String id);
	
	/***
	 * 通过对象的参数查询数据
	 * @param e  对象
	 * @return
	 */
	public   List<E>  findByParam(E e);
	
	/***
	 * 通过对象的参数查询数据
	 * @param e  对象
	 * @param page    分页对象
	 * @return
	 */
	public   PageInfo<E>  findByParam(E e,PageInfo<E> page);
	
	/**
	 *  通过字段名称与字段值查询数据
	 * @param classs  类对象
	 * @param param  字段名称
	 * @param value  字段值
	 * @return
	 */
	public   List<E>  findByParam(Class<E> classs,String param,String value);
	
	/**
	 *  通过字段名称与字段值查询数据
	 * @param classs  类对象
	 * @param page    分页对象
	 * @param param  字段名称
	 * @param value  字段值
	 * @return
	 */
	public   PageInfo<E>  findByParam(Class<E> classs,PageInfo<E> page,String param,String value);
	
	/***
	 * 通过hql查询分页
	 * @param page  分页信息
	 * @param hql   hql语句
	 * @return  分页信息
	 */
	public PageInfo<E> findByHql(PageInfo<E> page,String hql);
	
	/***
	 * 通过hql查询分页
	 * @param page  分页信息
	 * @param hql   hql语句
	 * @param map   hql语句中的占位符的值
	 * @return  分页信息
	 */
	public PageInfo<E> findByHql(PageInfo<E> page,String hql,Map<String, Object> map);
	
	
	/***
	 * 通过hql查询分页
	 * @param page  分页信息
	 * @param hql   hql语句
	 * @param e   hql语句中的占位符的值
	 * @return  分页信息
	 */
	public PageInfo<E> findByHql(PageInfo<E> page,String hql,E e);
	
	
	/***
	 * 通过hql语句查询信息
	 * @param hql   hql语句
	 * @return 信息集合
	 */
	public List<E> findByHql(String hql);
	
	/***
	 * 通过hql语句查询信息
	 * @param e   hql语句中的占位符的值
	 * @param hql  hql语句
	 * @return  信息集合
	 */
	public List<E> findByHql(E e,String hql);
	
	/***
	 * 通过hql语句查询信息
	 * @param map   hql语句中的占位符的值
	 * @param hql   hql语句
	 * @return 信息集合
	 */
	public List<E> findByHql(Map<String, Object> map,String hql);
	
	
	
  
	
}
