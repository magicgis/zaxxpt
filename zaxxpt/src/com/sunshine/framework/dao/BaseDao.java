package com.sunshine.framework.dao;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.DataException;
import com.sunshine.framework.entity.PageEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;
import com.sunshine.framework.util.BeanUtils;
import com.sunshine.framework.util.SysLogger;
import com.system.user.entity.UserEntity;
/***
 * 默认数据库访问DAO
 * @author ralphone.zhuo
 *
 */
public  class BaseDao extends JdbcTemplate{

	
	public void delete(BaseEntity entity) throws DataException {
		try {
			Class<? extends BaseEntity> eClass = entity.getClass();
			String tableName = eClass.getAnnotation(TableMethod.class)
					.TableName();
			Field[] fields = eClass.getDeclaredFields();
			StringBuilder buffer = new StringBuilder();
			List valueList = new ArrayList();
			List<Integer> typeList = new ArrayList<Integer>();
			buffer.append("delete from ");
			buffer.append(tableName);
			buffer.append(" where ");
			for (Field field : fields) {
				field.setAccessible(true);
				Object fieldVal = field.get(entity);
				if (BeanUtils.isObjectNotNull(fieldVal)) {
					if (field.isAnnotationPresent(FieldMethod.class)) {
						FieldMethod fieldMethod = field
								.getAnnotation(FieldMethod.class);
						if (fieldMethod.IsField()) {
							String type = field.getType().getName();
							String fieldName = field.getName();
							buffer.append(fieldName);
							buffer.append(" = ? and ");
							valueList.add(fieldVal);
							typeList.add(valueType(type));
						}
					}
				}
			}
			String sql=buffer.toString();
			sql=sql.trim();
			if(sql.endsWith("and")){
				sql=sql.substring(0,sql.length()-3);
			}
			int[] typeArrInt = typeChange(typeList);
			this.update(sql, valueList.toArray(),typeArrInt);
		} catch (Exception e) {
			SysLogger.error("DataException caught when delete entity.",e);
			throw new DataException(e);
		}
	}


	public void deleteById(String id, Class<? extends BaseEntity> entity)
			throws DataException {
		try {
			String tableName = entity.getAnnotation(TableMethod.class)
					.TableName();
			Field[] fields = entity.getDeclaredFields();
			for (Field f : fields) {
				if (f.isAnnotationPresent(FieldMethod.class)) {
					FieldMethod method = f.getAnnotation(FieldMethod.class);
					if (method.IsPK()) {
						String fieldName = f.getName();
						String sql="delete from " + tableName + " where "
						+ fieldName + " = ? ";
						this.update(sql, new Object[]{id});
					}
				}
			}
		} catch (Exception e) {
			SysLogger.error("DataException caught when delete entity by id.",e);
			throw new DataException(e);
		}
	}


	public void deleteBySql(String sql,Object[] args) throws DataException {
		try{
			this.update(sql, args);
		}catch(Exception e){
			SysLogger.error("DataException caught when delete entity by sql.",e);
			throw new DataException(e);
		}
	}


	public void insert(BaseEntity entity) throws DataException {
		try{
		Class eClass=entity.getClass();
		String tableName=((TableMethod) eClass.getAnnotation(TableMethod.class)).TableName();
		Field[] fields=eClass.getDeclaredFields();
		StringBuilder fieldBuffer=new StringBuilder();
		StringBuilder valueBuffer=new StringBuilder();
		fieldBuffer.append("insert into "+tableName+"(");
		valueBuffer.append(" values(");
		List valueList = new ArrayList();
		List<Integer> typeList = new ArrayList<Integer>();
		for(Field field:fields){
			if(field.isAnnotationPresent(FieldMethod.class)){
				FieldMethod fieldMethod=field.getAnnotation(FieldMethod.class);
				if(fieldMethod.IsField()){
					field.setAccessible(true);
					String fieldName=field.getName();
					Object fieldVal=field.get(entity);
					String type=field.getType().getName();
					if(fieldMethod.IsPK()&&fieldMethod.AutoKey()){
						fieldBuffer.append(fieldName+",");
						valueBuffer.append("sys_guid(),");
					}else{
						if(BeanUtils.isObjectNotNull(fieldVal)){
							fieldBuffer.append(fieldName+",");
							valueBuffer.append("?,");
							valueList.add(fieldVal);
							typeList.add(valueType(type));
						}
					}
				}
			}
		}
		String fieldsql=fieldBuffer.toString();
		fieldsql=fieldsql.trim();
		if(fieldsql.endsWith(",")){
			fieldsql=fieldsql.substring(0,fieldsql.length()-1);
		}
		String valuesql=valueBuffer.toString();
		valuesql=valuesql.trim();
		if(valuesql.endsWith(",")){
			valuesql=valuesql.substring(0,valuesql.length()-1);
		}
		String sql=fieldsql+")"+valuesql+")";
		int[] typeArrInt = typeChange(typeList);
		this.update(sql, valueList.toArray(),typeArrInt);
		}catch(Exception e){
			SysLogger.error("DataException caught when insert an entity.",e);
			throw new DataException(e);
		}
	}


	public void insertBySql(String sql,Object[] args) throws DataException {
		try{
			this.update(sql, args);
		}catch(Exception e){
			SysLogger.error("DataException caught when insert an entity.",e);
			throw new DataException(e);
		}
	}


	public List selectBySql(String sql,Object[] args,final Class resultType) throws DataException {
		
		List list=this.query(sql, args, new RowMapper(){

			public Object mapRow(ResultSet rs, int arg) throws SQLException {
				try {
					ResultSetMetaData meta=rs.getMetaData();
					Object obj = resultType.newInstance();
					int count=meta.getColumnCount();
					for(int i=1;i<=count;i++){
						String colName=meta.getColumnName(i);
						Object value=rs.getObject(i);
						String na=colName.toLowerCase();
							Field field=resultType.getDeclaredField(colName.toLowerCase());
							if(BeanUtils.isObjectNotNull(field)){
								field.setAccessible(true);
								field.set(obj, value);
							}
						
					}
				return obj;
				} catch (Exception e) {
					SysLogger.error("DataException caught when qruey.",e);
				}
				return null;
			}
			
		});
		return list;
	}

	public Map selectBySql(String sql,Object[] args) throws DataException {
		return this.queryForMap(sql, args);
	}
	public BaseEntity selectById(String id,final Class<? extends BaseEntity> entity) throws DataException {
		BaseEntity resultEntity=null;
		try {
			String tableName = entity.getAnnotation(TableMethod.class)
					.TableName();
			Field[] fields = entity.getDeclaredFields();
			
			BaseEntity entityQuery=entity.newInstance();
			for (Field f : fields) {
				if (f.isAnnotationPresent(FieldMethod.class)) {
					FieldMethod method = f.getAnnotation(FieldMethod.class);
					if (method.IsPK()) {
						f.setAccessible(true);
						f.set(entityQuery, id);
					}
				}
			}
			List list=this.select(entityQuery);
			if(list!=null&&list.size()>0){
				resultEntity=(BaseEntity) list.get(0);
			}
		} catch (Exception e) {
			SysLogger.error("DataException caught when qruey an entity by id.",e);
			throw new DataException(e);
		}
		return resultEntity;
	}	
	

	public List select(BaseEntity entity) throws DataException {
		List list=null;
		try {
			final Class<? extends BaseEntity> eClass = entity.getClass();
			String tableName = eClass.getAnnotation(TableMethod.class)
					.TableName();
			Field[] fields = eClass.getDeclaredFields();
			StringBuilder buffer = new StringBuilder();
			StringBuilder joinBuffer = new StringBuilder();
			List valueList = new ArrayList();
			buffer.append("select t.* from ");
			buffer.append(tableName+" t ");
			buffer.append(" where ");
			for (Field field : fields) {
				field.setAccessible(true);
				Object fieldVal = field.get(entity);
				if (BeanUtils.isObjectNotNull(fieldVal)) {
					if (field.isAnnotationPresent(FieldMethod.class)) {
						FieldMethod fieldMethod = field
								.getAnnotation(FieldMethod.class);
						if (fieldMethod.IsField()) {
							String type = field.getType().getName();
							String fieldName = field.getName();
							buffer.append(fieldName);
							buffer.append(" = ? and ");
							valueList.add(fieldVal);
							String joinMethod=fieldMethod.Join();
							if(BeanUtils.isNotEmpty(joinMethod)){
								String joinClass = fieldMethod.Join().substring(0,fieldMethod.Join().lastIndexOf("."));
								String joinField = fieldMethod.Join().substring(fieldMethod.Join().lastIndexOf(".") + 1);
								Class join=Class.forName(joinClass);
								TableMethod tableMethod = (TableMethod)join.getAnnotation(TableMethod.class);
								String joinTableName=tableMethod.TableName();
								String subJoinName=" "+joinTableName+"_";
								String leftSql=" left join "+joinTableName+subJoinName
												+" on t."+fieldName+" = "+subJoinName+"."+joinField	+" ";
							
								buffer.insert(buffer.indexOf("from")+5, leftSql);
								// d.插入关联表的字段在Form前
		    					if (BeanUtils.isNotEmpty(fieldMethod.JoinReturn())) {
				        			String[] joinReturn = fieldMethod.JoinReturn().split(",");
				        			StringBuffer joinreturnstr = new StringBuffer();
				        			for (String jr : joinReturn) {
				        				joinreturnstr.append(",");
				        				joinreturnstr.append(subJoinName);
				        				joinreturnstr.append(".");
				        				joinreturnstr.append(jr.substring(jr.lastIndexOf(".")+1));
				        			}
				        			buffer.insert(buffer.indexOf(" from "), joinreturnstr);
		    					}
							}
						}
					}
				}
			}
			String sql=buffer.toString();
			sql=sql.trim();
			if(sql.endsWith("and")){
				sql=sql.substring(0,sql.length()-3);
			}
			sql=sql.trim();
			if(!sql.endsWith("where")){
				list=this.query(sql, valueList.toArray(),new RowMapper(){
				
					public BaseEntity mapRow(ResultSet set, int arg) throws SQLException {
						try {
							ResultSetMetaData meta=set.getMetaData();
								BaseEntity obj=eClass.newInstance();
								int count=meta.getColumnCount();
								for(int i=1;i<=count;i++){
									String colName=meta.getColumnName(i);
									Object value=set.getObject(i);
									String na=colName.toLowerCase();
										Field field=eClass.getDeclaredField(colName.toLowerCase());
										if(BeanUtils.isObjectNotNull(field)){
											field.setAccessible(true);
											field.set(obj, value);
										}
									
								}
								return obj;
						} catch (Exception e) {
							SysLogger.error("DataException caught when qruey.",e);
						}
						return null;
					}});
			}			
		} catch (Exception e) {
			SysLogger.error("DataException caught when qruey.",e);
			throw new DataException(e);
		}
		return list;
	}

	
	public static void main(String[] args) throws DataException {
		BaseDao d=new BaseDao();
		UserEntity user=new UserEntity();
		d.select(user);
	}

	public void modifyBySql(String sql,Object[] args) throws DataException {
		try{
			this.update(sql, args);
		}catch(Exception e){
			SysLogger.error("DataException caught when edit.",e);
			throw new DataException(e);
		}
	}


	public void modify(BaseEntity entity) throws DataException {
		
		try {
			Class<? extends BaseEntity> eClass = entity.getClass();
			String tableName = eClass.getAnnotation(TableMethod.class)
					.TableName();
			Field[] fields = eClass.getDeclaredFields();
			StringBuilder buffer = new StringBuilder();
			StringBuilder whereBuffer = new StringBuilder();
			List valueList = new ArrayList();
			List<Integer> typeList = new ArrayList<Integer>();
			buffer.append("update ");
			buffer.append(tableName);
			buffer.append(" set ");
			String id="";
			for (Field field : fields) {
				field.setAccessible(true);
				Object fieldVal = field.get(entity);
				if (BeanUtils.isObjectNotNull(fieldVal)) {
					if (field.isAnnotationPresent(FieldMethod.class)) {
						FieldMethod fieldMethod = field
								.getAnnotation(FieldMethod.class);
						if (fieldMethod.IsField()) {
							String type = field.getType().getName();
							String fieldName = field.getName();
							if(fieldMethod.IsPK()){
								whereBuffer.append(fieldName);
								whereBuffer.append(" = ?");
								id=fieldVal.toString();
							}else{
								buffer.append(fieldName);
								buffer.append(" = ? , ");
								valueList.add(fieldVal);
								typeList.add(valueType(type));
							}				
						}
					}
				}
			}
			String sql=buffer.toString();
			sql=sql.trim();
			if(sql.endsWith(",")){
				sql=sql.substring(0,sql.length()-1);
			}
			if(whereBuffer.length()<=0){
				throw new DataException("Entity try to update with a NULL primary key value");
			}else{
				whereBuffer.insert(0, " where ");
				sql=sql+whereBuffer.toString();
				valueList.add(id);
				typeList.add(valueType("java.lang.String"));
				int[] typeArrInt = typeChange(typeList);
				this.update(sql, valueList.toArray(),typeArrInt);
			}
			
		} catch (Exception e) {
			SysLogger.error("DataException caught when update.",e);
			throw new DataException(e);
		}
	}
	

	public List query(String sql,final Class<? extends BaseEntity> entity, PageEntity pageEntity) throws DataException {
		int total=this.queryForInt("select count(*) from ("+sql+")");
		pageEntity.setRowCount(total);
		int size=pageEntity.getSizePage();
		int startIndex=(pageEntity.getPage()-1)*size+1;
		int endIndex=startIndex+size-1;
		if(endIndex>total)endIndex=total;
		StringBuilder buffer=new StringBuilder();
		buffer.append("select * from (select temp.*,rownum as oraclenum from (");
		buffer.append(sql);
		buffer.append(") temp )where oraclenum >=");
		buffer.append(startIndex);
		buffer.append(" and oraclenum <=");
		buffer.append(endIndex);
		SysLogger.info("INFO:query with page----"+buffer.toString());
		List list=this.query(buffer.toString(), new RowMapper(){

			public BaseEntity mapRow(ResultSet set, int arg) throws SQLException {
				try {
					ResultSetMetaData meta=set.getMetaData();
						BaseEntity obj=entity.newInstance();
						int count=meta.getColumnCount();
						for(int i=1;i<=count;i++){
							String colName=meta.getColumnName(i);
							Object value=set.getObject(i);
							String na=colName.toLowerCase();
							if(na.equalsIgnoreCase("oraclenum")==false){
								Field field=entity.getDeclaredField(colName.toLowerCase());
								if(BeanUtils.isObjectNotNull(field)){
									field.setAccessible(true);
									field.set(obj, value);
								}
							}
							
						}
						return obj;
				} catch (Exception e) {
					SysLogger.error("DataException caught when qruey with page.",e);
				}
				return null;
			}});
		return list;
	}
	
	
	private int valueType(String typeName){
		if(typeName.equalsIgnoreCase("java.lang.String")){
			return Types.VARCHAR;
		}else if(typeName.equalsIgnoreCase("java.lang.Integer")
				||typeName.equalsIgnoreCase("int")){
			return Types.INTEGER;
		}else if(typeName.equalsIgnoreCase("java.lang.Double")
				||typeName.equalsIgnoreCase("double")){
			return Types.DOUBLE;
		}else if(typeName.equalsIgnoreCase("java.lang.Float")
				||typeName.equalsIgnoreCase("float")){
			return Types.FLOAT;
		}else if(typeName.equalsIgnoreCase("java.lang.Long")
				||typeName.equalsIgnoreCase("long")){
			return Types.BIGINT;
		}else if(typeName.equalsIgnoreCase("java.lang.Boolean")
				||typeName.equalsIgnoreCase("boolean")){
			return Types.BOOLEAN;
		}else if(typeName.equalsIgnoreCase("java.lang.BigDecimal")){
			return Types.NUMERIC;
		}
		else if(typeName.equalsIgnoreCase("java.util.Date")){
			return Types.DATE;
		}
		else{
			return Types.OTHER;
		}
	}

	private int[] typeChange(List<Integer> typeList) {
		Object[] typeArr=typeList.toArray();
		int[] typeArrInt=new int[typeArr.length];
		for(int i=0;i<typeArr.length;i++){
			typeArrInt[i]=(Integer)typeArr[i];
		}
		return typeArrInt;
	}
	
}
