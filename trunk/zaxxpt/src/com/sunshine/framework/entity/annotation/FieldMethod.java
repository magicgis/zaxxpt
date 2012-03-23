package com.sunshine.framework.entity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/***
 * 字段映射注释
 * @author ralphone.zhuo
 *
 */
@Retention(RetentionPolicy.RUNTIME)    
@Target({ElementType.FIELD})
public @interface FieldMethod {

	// 数据库字段
	boolean IsField() default true;
	
	// 可查询
	boolean IsFind() default false;
	
	// 不能重复
	boolean notReplace() default false;
	
	// 关联目标表&字段  (例: com.Table2.pid)
	String Join() default "";
	
	// 返回关联目标表&字段 例: (com.Table2.name)
	String JoinReturn() default "";
	
	// 因移值到Oracle中,在本系统中,所有日期类型String做为属性类型,只是在注释上用此方法设为True
	boolean IsDate() default false;
	
	// 因移值到Oracle中,在本系统中,所有日期类型String做为属性类型,只是在注释上用此方法设为True
	boolean IsDateTime() default false;
	
	// 针对Oracle日期类型字段处理 (yyyy-MM-dd HH24:mi:ss)
	String ToFunction() default ""; 
	
	// 排序
	String Sort() default "";
	
	// 自动生成主键
	boolean AutoKey() default false;
	
	// 主键前三字符标记
	String PrefixKey() default "TPK";
	
	// 派生主键值(要注意的是目标在前面已处理)
	String DeriveKey() default "";
	
	// 字段(方法)中文描述
	String Description() default "";
	
	// 默认值
	String Default() default "";
	
	boolean IsPK() default false;
}
