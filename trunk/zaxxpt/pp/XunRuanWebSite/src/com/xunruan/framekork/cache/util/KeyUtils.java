package com.xunruan.framekork.cache.util;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class KeyUtils
{

	public KeyUtils()
	{
	}

	public static  Object getKey(String className, String methodName, Object params[])
	{
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(className).append(methodName);
		Object aobj[];
		int j = (aobj = params).length;
		for (int i = 0; i < j; i++)
		{
			Object obj = aobj[i];
			hashCodeBuilder.append(obj != null ? ((Object) (Integer.valueOf(obj.hashCode()))) : obj);
		}

		return Integer.valueOf(hashCodeBuilder.toHashCode());
	}
}