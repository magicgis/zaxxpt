package com.xunruan.framekork.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

import com.xunruan.framekork.cache.util.KeyUtils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public class MethodCacheInterceptor
{

	private static final Log log = LogFactory.getLog(MethodCacheInterceptor.class);
	private Cache cache;

	public MethodCacheInterceptor()
	{
	}

	public Object methodAround(ProceedingJoinPoint joinPoint)
		throws Throwable
	{
		Object params[] = joinPoint.getArgs();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getSignature().getDeclaringTypeName();
		Object key = KeyUtils.getKey(className, methodName, params);
		log.info((new StringBuilder("Key HashCode:")).append(key).toString());
		Element data = cache.get(key);
		Object result = null;
		if (data == null)
			try
			{
				result = joinPoint.proceed();
				cache.put(new Element(key, result));
			}
			catch (Throwable e)
			{
				throw e;
			}
		else
			result = data.getObjectValue();
		return result;
	}

	public void setCache(Cache cache)
	{
		this.cache = cache;
	}

}
