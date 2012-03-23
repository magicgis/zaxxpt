package com.sunshine.framework.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.sunshine.framework.dao.BaseDao;
import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.DataException;
import com.sunshine.framework.entity.PageEntity;
import com.sunshine.framework.entity.SearchEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;

import com.sunshine.framework.util.BeanUtils;
/***
 * Service»ù±¾Àà
 * @author ralphone.zhuo
 *
 */
public class BaseService {
	private BaseDao dao;
	

	
	public void delete(BaseEntity entity) throws DataException {
		this.getDao().delete(entity);
	}

	
	public void deleteById(String id, Class<? extends BaseEntity> entity)
			throws DataException {
		this.getDao().deleteById(id, entity);
	}

	
	public void deleteBySql(String sql, Object[] args) throws DataException {
		this.deleteBySql(sql, args);
	}

	
	public void insert(BaseEntity entity) throws DataException {
		this.getDao().insert(entity);
	}

	
	public void insertBySql(String sql, Object[] args) throws DataException {
		this.getDao().insertBySql(sql, args);
	}

	
	public List selectBySql(String sql, Object[] args,Class resultType)
			throws DataException {
		return (List) this.getDao().selectBySql(sql, args,resultType);
	}

	public Map selectBySql(String sql,Object[] args) throws DataException {
		return this.getDao().queryForMap(sql, args);
	}
	
	public BaseEntity selectById(String id, Class<? extends BaseEntity> entity)
			throws DataException {
		return this.getDao().selectById(id, entity);
	}

	
	public List select(BaseEntity entity) throws DataException {
		return this.getDao().select(entity);
	}

	
	public void modifyBySql(String sql, Object[] args) throws DataException {
		this.getDao().modifyBySql(sql, args);
	}

	
	public BaseEntity modify(BaseEntity entity) throws DataException {
		this.getDao().modify(entity);
		return entity;
	}

	
	public List selectChild(Class<? extends BaseEntity> child, BaseEntity master) throws DataException {
		// TODO Auto-generated method stub
		Class masterClass=master.getClass();
		Field[] cf=child.getDeclaredFields();
		BaseEntity childIns;
		try {
			childIns = child.newInstance();
		} catch (InstantiationException ex) {
			throw new DataException(ex);
		} catch (IllegalAccessException ex) {
			throw new DataException(ex);
		}
		for(Field field:cf){
			if(field.isAnnotationPresent(FieldMethod.class)){
				FieldMethod fieldMethod=field.getAnnotation(FieldMethod.class);
				if(fieldMethod.IsField()){
					String deriveKey=fieldMethod.DeriveKey();
					if(BeanUtils.isNotEmpty(deriveKey)){
						String parentClass=deriveKey.substring(0,deriveKey.lastIndexOf("."));
						if(parentClass.equals(masterClass.getName())){
							String keyField=deriveKey.substring(deriveKey.lastIndexOf(".")+1, 
									deriveKey.length());
							try {
								Field key=masterClass.getField(keyField);
								key.setAccessible(true);
								Object value=key.get(master);
								field.set(childIns, value);
								break;
							} catch (SecurityException e) {
								throw new DataException(e);
							} catch (NoSuchFieldException e) {
								throw new DataException(e);
							} catch (IllegalArgumentException e) {
								throw new DataException(e);
							} catch (IllegalAccessException e) {
								throw new DataException(e);
							} 
						}
					}
				}
			}
		}
		List list=this.getDao().select(childIns);
		return list;
	}
	public void deleteChild(Class<? extends BaseEntity> child, BaseEntity master) throws DataException {
		// TODO Auto-generated method stub
		Class masterClass=master.getClass();
		Field[] cf=child.getDeclaredFields();
		for(Field field:cf){
			if(field.isAnnotationPresent(FieldMethod.class)){
				FieldMethod fieldMethod=field.getAnnotation(FieldMethod.class);
				if(fieldMethod.IsField()){
					String deriveKey=fieldMethod.DeriveKey();
					if(BeanUtils.isNotEmpty(deriveKey)){
						String parentClass=deriveKey.substring(0,deriveKey.lastIndexOf("."));
						if(parentClass.equals(masterClass.getName())){
							String keyField=deriveKey.substring(deriveKey.lastIndexOf(".")+1, 
									deriveKey.length());
							try {
								Field key=masterClass.getField(keyField);
								key.setAccessible(true);
								Object value=key.get(master);
								this.getDao().deleteById(value.toString(), child);
								break;
							} catch (SecurityException e) {
								throw new DataException(e);
							} catch (NoSuchFieldException e) {
								throw new DataException(e);
							} catch (IllegalArgumentException e) {
								throw new DataException(e);
							} catch (IllegalAccessException e) {
								throw new DataException(e);
							} 
						}
					}
				}
			}
		}
		
	}

	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	
	public List<BaseEntity> query(Class<? extends BaseEntity> entity,
			SearchEntity searchEntity, PageEntity pageEntity)
			throws DataException {
		String tableName= entity.getAnnotation(TableMethod.class).TableName();
		String sql="select * from "+tableName +" t ";
		String cmd=searchEntity.getSearchCmd();
		if(BeanUtils.isNotEmpty(cmd)){
			sql=sql+" where "+cmd;
		}
		Field[] fields=entity.getDeclaredFields();
		StringBuilder buffer=new StringBuilder();
		for(Field field:fields){
			field.isAnnotationPresent(FieldMethod.class);
			FieldMethod fieldMethod=field.getAnnotation(FieldMethod.class);
			if(BeanUtils.isNotEmpty(fieldMethod.Sort())){
				String sort=fieldMethod.Sort();
				String name= field.getName();
				buffer.append(" t."+name+" ");
				buffer.append(sort);
				buffer.append(",");
			}
			}
		if(buffer.length()>0)buffer.insert(0, " order by ");
		buffer.insert(0, sql);
		sql=buffer.toString();
		sql=sql.substring(0,sql.length());
		List list=this.getDao().query(sql,entity,pageEntity);
		return list;
	}

	
	public void addChild(BaseEntity master, BaseEntity child)
			throws DataException {
		
		Class childClass=child.getClass();
		if(BeanUtils.isObjectNull(child)){
			try {
				child=(BaseEntity) childClass.newInstance();
			} catch (InstantiationException e) {
				throw new DataException(e);
			} catch (IllegalAccessException e) {
				throw new DataException(e);
			}
		}
		Class masterClass=master.getClass();
		Field[] fields=childClass.getDeclaredFields();
		for(Field field:fields){
			if(field.isAnnotationPresent(FieldMethod.class)){
				FieldMethod fieldMethod=field.getAnnotation(FieldMethod.class);
				if(BeanUtils.isNotEmpty(fieldMethod.DeriveKey())){
					String deriveKey=fieldMethod.DeriveKey();
					String parentClass=deriveKey.substring(0,deriveKey.lastIndexOf("."));
					if(parentClass.equalsIgnoreCase(masterClass.getName())){
						String keyField=deriveKey.substring(deriveKey.lastIndexOf(".")+1, 
								deriveKey.length());
						try {
							field.setAccessible(true);
							Field key=masterClass.getField(keyField);
							key.setAccessible(true);
							Object keyValue=key.get(master);
							field.set(child, keyValue);
							this.getDao().insert(child);
							break;
						} catch (IllegalArgumentException e) {
							throw new DataException(e);
						} catch (IllegalAccessException e) {
							throw new DataException(e);
						} catch (SecurityException e) {
							throw new DataException(e);
						} catch (NoSuchFieldException e) {
							throw new DataException(e);
						}
					}	
				}
			}
		}

	}
	
	
}
