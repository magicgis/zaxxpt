package com.sunshine.framework.entity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/***
 * ±Ì”≥…‰◊¢ Õ
 * @author ralphone.zhuo
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableMethod {

	String TableName() default "";
	
	// ÷ß≥÷@rolesid,@deptid,@dutyid,@userid,@menuid
	String Scope() default "";
	
}
