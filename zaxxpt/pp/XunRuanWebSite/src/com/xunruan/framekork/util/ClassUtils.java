package com.xunruan.framekork.util;



import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author wenz
 * 
 */
public class ClassUtils {
	private static Class<?>[] SimpleClass = new Class<?>[] {
		Object.class,
		Class.class,
		Date.class,
		java.sql.Date.class,
		java.sql.Timestamp.class,
		String.class,
		Boolean.class,
		Character.class,
		Byte.class,
		Short.class,
		Integer.class,
		Long.class,
		Float.class,
		Double.class, 
		Void.class};
	public static boolean isSimpleClass(Class<?> c) {
		if (c.isPrimitive()) return true;
		for (Class<?> c1 : SimpleClass)
			if (c1 == c) return true;
		return false;
	}
	
	public static boolean isCollectionOrArray(Class<?> c) {
		if (c.isArray()) return true;
		if (Collection.class.isAssignableFrom(c)) return true;
		return false;
	}
	
	public static <A extends Annotation> List<A> getAnnotationsWithSuper(Class<?> clazz, Class<A> annotationClass) {
		List<A> ret = new ArrayList<A>();
		while (clazz != Object.class) {
			ret.add(clazz.getAnnotation(annotationClass));
			clazz = clazz.getSuperclass();
		}
		return ret;
	}
	
	public static Annotation[] getAnnotationsWithSuper(Class<?> clazz) {
		List<Annotation> ret = new ArrayList<Annotation>();
		while (clazz != Object.class) {
			ret.addAll(Arrays.asList(clazz.getAnnotations()));
			clazz = clazz.getSuperclass();
		}
		return ret.toArray(new Annotation[ret.size()]);
	}
	
	public static Object create(String clazz) throws Exception {
		return create(Class.forName(clazz));
	}
	
	public static <E> E create(Class<E> clazz) throws Exception {
		return clazz.newInstance();
	}
	
	public static <E> E createWithoutException(Class<E> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("Failure to create object, please make sure that the class'" + 
					clazz+"' has a empty constructor.", e);
		} 
	}
	
	public static Object invokeStaticMethod(Class<?> clazz, String methodName, Class<?>[] types, Object[] args) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Method m = getDeclaredMethodFromSuper(clazz, methodName, types);
		m.setAccessible(true);
		return m.invoke(clazz, args);
	}
	
	public static Object invokePrivateMethod(Object instance, String methodName, Class<?>[] types, Object[] args) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Method m = getDeclaredMethodFromSuper(instance.getClass(), methodName, types);
		m.setAccessible(true);
		return m.invoke(instance, args);
	}
	
	private static Object processInvocationException(Throwable e) {
		if (e instanceof IllegalArgumentException) 
			throw (IllegalArgumentException) e;
		if (e.getCause() instanceof IllegalArgumentException) 
			throw (IllegalArgumentException) e.getCause();
		if (e instanceof InvocationTargetException)
			e = ((InvocationTargetException)e).getTargetException();
		else if (e.getCause() instanceof InvocationTargetException)
			e = ((InvocationTargetException)e.getCause()).getTargetException();
		
		
		if (e instanceof RuntimeException) 
			throw (RuntimeException) e;
		else 
			throw new IllegalArgumentException(e);
	}
	/**
	 * 得到属性描述 PropertyDescriptor(PropertyDescriptor主要用于得到属性的get/set方法)。
	 * 当属性的setter方法的参数类型与getter方法的返回类型不一致时，本方法将无法获取对应的setter方法。当getter
	 * 方法实现的是接口中的方法时，即便本类的getter方法与setter方法类型一致，若setter方法类型与接口中声明的
	 * getter方法的类型不致时，也同样取不到setter方法。
	 * @see {@link #getMyPropertyDescriptor(Class, String)}
	 */
	public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String property) {
		try {
			PropertyDescriptor[] ps = java.beans.Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor p : ps) {
				if (property.equals(p.getName())) return p;
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static class MyPropertyDescriptor {
		private Method getter, setter, getters[];
		private String property;
		private Class<?> propertyType;
		public MyPropertyDescriptor(String property, Class<?> propertyType, Method getter, Method[] getters, Method setter) {
			this.getter = getter;
			this.getters = getters;
			this.propertyType = propertyType;
			this.property = property;
			this.setter = setter;
		}
		public Method getReadMethod() {
			return getter;
		}
		public Method[] getReadMethods() {
			return getters;
		}
		public Method getWriteMethod() {
			return setter;
		}
		public Class<?> getPropertyType() {
			return propertyType;
		}
		public String getProperty() {
			return property;
		}
	}
	/**
	 * 使用getPropertyDescriptor方法取不到setter方法时，可用本方法
	 */
	public static MyPropertyDescriptor getMyPropertyDescriptor(Class<?> clazz, String property) {
		try {
			PropertyDescriptor[] ps = java.beans.Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor p : ps) {
				if (property.equals(p.getName())) {
					Method setter = p.getWriteMethod();
					if (setter == null && p.getReadMethod() != null) {
						setter = findWriteMethodForAnyType(clazz, property, p.getReadMethod().getReturnType());
					}
					return new MyPropertyDescriptor(property, p.getPropertyType(), p.getReadMethod(), 
							findReadMethod(clazz, p.getReadMethod().getName()), setter);
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据给定的属性名称和类型查找给定类中的setter方法，只会返回public方法
	 */
	public static Method findWriteMethodForAnyType(Class<?> clazz, String property, Class<?> propertyType) {
		String name = "set" + StringUtil.capitalFirst(property);
		for (Method m : clazz.getMethods()) {
			if (name.equals(m.getName()) && m.getParameterTypes().length == 1 &&
					propertyType.isAssignableFrom(m.getParameterTypes()[0]))
				return m;
		}
		return null;
	}
	/**
	 * 查找指定类中指定属性对应的getter方法，本方法除返回clazz本身声明的方法外，
	 * 还会返回clazz的父类或接口中声明的同名方法。
	 */
	public static Method[] findReadMethod(Class<?> clazz, String methodName) {
		List<Method> ret = new ArrayList<Method>();
		for (Method m : clazz.getMethods()) {
			if (m.getParameterTypes().length == 0 && m.getName().equals(methodName))
				ret.add(m);
		}
		return ret.toArray(new Method[ret.size()]);
	}
	/**
	 * 得到private字段的值,不用通过get方法直接得到值
	 * @param obj
	 * @param name
	 * @return
	 */
	public static Object getPrivateFieldValue(Object obj, String name) {
		return getPrivateFieldValue(obj, name, false);
	}
	/**
	 * 得到private字段值,不用通过get方法直接得到值
	 * @param obj
	 * @param name
	 * @param throwException
	 * @return
	 */
	public static Object getPrivateFieldValue(Object obj, String name, boolean throwException) {
		try {
			Field f = getDeclaredFieldFromSuper(obj.getClass(), name);
			f.setAccessible(true);
			return f.get(obj);
		} catch (Exception e) {
			if (throwException)
				throw new RuntimeException(e);
			return null;
		}
	}
	/**
	 * 设置private字段的值,不用通过set方法直接设置值
	 * @param obj
	 * @param name
	 * @return
	 */
	public static void setPrivateFieldValue(Object obj, String name, Object value) {
		setPrivateFieldValue(obj, name, value, false);
	}
	/**
	 * 设置private字段值,不用通过set方法直接设置值
	 * @param obj
	 * @param name
	 * @param throwException
	 * @return
	 */
	public static void setPrivateFieldValue(Object obj, String name, Object value, boolean throwException) {
		try {
			Field f = getDeclaredFieldFromSuper(obj.getClass(), name);
			f.setAccessible(true);
			f.set(obj, value);
		} catch (Exception e) {
			if (throwException)
				throw new RuntimeException(e);
		}
	}
	/**
	 * 得到指定的class field
	 * @param clazz
	 * @param name
	 * @return Field
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static Field getDeclaredFieldFromSuper(Class<?> clazz, String name) throws NoSuchFieldException, SecurityException {
		if (clazz == null) throw new NoSuchFieldException(name);
		try {
			return clazz.getDeclaredField(name);
		} catch (NoSuchFieldException e) {
			return getDeclaredFieldFromSuper(clazz.getSuperclass(), name);
		}
	}
	public static Method getDeclaredMethodFromSuper(Class<?> clazz, String name, Class<?>[] parameterTypes) throws NoSuchMethodException, SecurityException {
		if (clazz == null) throw new NoSuchMethodException(name);
		try {
			return clazz.getDeclaredMethod(name, parameterTypes);
		} catch (NoSuchMethodException e) {
			return getDeclaredMethodFromSuper(clazz.getSuperclass(), name, parameterTypes);
		}
	}
	/**
	 * 得到去掉包后的class名称
	 * @param clazz
	 * @return
	 */
	public static String getShortClassName(Class<?> clazz) {
		return getShortClassName(clazz.getName());
	}
	/**
	 * 得到去掉包后的class名称
	 * @param name
	 * @return
	 */
	public static String getShortClassName(String name) {
		int index = name.lastIndexOf(".");
		if (index >= 0) {
			name = name.substring(index + 1);
		}
		return name;
	}
	public static String getPackageName(String className) {
		int index = className.lastIndexOf(".");
		if (index >= 0) {
			return className.substring(0, index);
		}
		return "";
	}
	public static Class<?> classForName(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
