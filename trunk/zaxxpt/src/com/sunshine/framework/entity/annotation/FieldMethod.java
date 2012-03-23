package com.sunshine.framework.entity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/***
 * �ֶ�ӳ��ע��
 * @author ralphone.zhuo
 *
 */
@Retention(RetentionPolicy.RUNTIME)    
@Target({ElementType.FIELD})
public @interface FieldMethod {

	// ���ݿ��ֶ�
	boolean IsField() default true;
	
	// �ɲ�ѯ
	boolean IsFind() default false;
	
	// �����ظ�
	boolean notReplace() default false;
	
	// ����Ŀ���&�ֶ�  (��: com.Table2.pid)
	String Join() default "";
	
	// ���ع���Ŀ���&�ֶ� ��: (com.Table2.name)
	String JoinReturn() default "";
	
	// ����ֵ��Oracle��,�ڱ�ϵͳ��,������������String��Ϊ��������,ֻ����ע�����ô˷�����ΪTrue
	boolean IsDate() default false;
	
	// ����ֵ��Oracle��,�ڱ�ϵͳ��,������������String��Ϊ��������,ֻ����ע�����ô˷�����ΪTrue
	boolean IsDateTime() default false;
	
	// ���Oracle���������ֶδ��� (yyyy-MM-dd HH24:mi:ss)
	String ToFunction() default ""; 
	
	// ����
	String Sort() default "";
	
	// �Զ���������
	boolean AutoKey() default false;
	
	// ����ǰ���ַ����
	String PrefixKey() default "TPK";
	
	// ��������ֵ(Ҫע�����Ŀ����ǰ���Ѵ���)
	String DeriveKey() default "";
	
	// �ֶ�(����)��������
	String Description() default "";
	
	// Ĭ��ֵ
	String Default() default "";
	
	boolean IsPK() default false;
}
