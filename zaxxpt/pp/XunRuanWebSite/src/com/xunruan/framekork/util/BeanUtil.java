package com.xunruan.framekork.util;



import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BigIntegerConverter;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.CharacterConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimeConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;



/**
 * @author wenz
 */
public class BeanUtil {
	
	static {
		
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
        ConvertUtils.register(new BigIntegerConverter(null), BigInteger.class);
        ConvertUtils.register(new BooleanConverter(null), Boolean.class);
        ConvertUtils.register(new ByteConverter(null), Byte.class);
        ConvertUtils.register(new CharacterConverter(null), Character.class);
        ConvertUtils.register(new DoubleConverter(null), Double.class);
        ConvertUtils.register(new FloatConverter(null), Float.class);
        ConvertUtils.register(new IntegerConverter(null), Integer.class);
        ConvertUtils.register(new LongConverter(null), Long.class);
        ConvertUtils.register(new ShortConverter(null), Short.class);
        ConvertUtils.register(new SqlDateConverter(null), Date.class);
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        ConvertUtils.register(new SqlTimeConverter(null), Time.class);
        ConvertUtils.register(new SqlTimestampConverter(null), Timestamp.class);
	}
	
	public static Object copyProperty(Object bean, String name, Object val) throws Exception {
		try {
			BeanUtils.copyProperty(bean, name, val);
			return bean;
		} catch (Exception e) {
			throw new Exception("copy propreties error.", e);
		}
	}
	public static Object copyProperties(Object src, Object dest) throws Exception {
		try {
			BeanUtils.copyProperties(dest, src);
			return src;
		} catch (Exception e) {
			throw new Exception("copy propreties error.", e);
		}
	}
	public static Object getProperty(Object bean, String property) throws Exception {
		try {
			return PropertyUtils.getProperty(bean, property);
		} catch (Exception e) {
			try {
				return ClassUtils.getPrivateFieldValue(bean, property, true);
			} catch (RuntimeException e1) {
				throw new Exception("get proprety error: '" + property + "'", e);
			}
		}
	}
	public static void setProperty(Object bean, String property, Object value) throws Exception {
		try {
			PropertyUtils.setProperty(bean, property, value);
		} catch (Exception e) {
			try {
				ClassUtils.setPrivateFieldValue(bean, property, true);
			} catch (RuntimeException e1) {
				throw new Exception("set proprety error: '" + property + "' with value '" + value + "'.", e);
			}
		}
	}
	
	public static List<?> getProperty(List<?> beans, String property) throws Exception{
		List<Object> ret = new ArrayList<Object>();
		int i = 0;
		for(Object o : beans) ret.add(getProperty(o, property));
		return ret;
	}
	
	public static Object getPropertyIfExist(Object bean, String property) {
		try {
			return getProperty(bean, property);
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
