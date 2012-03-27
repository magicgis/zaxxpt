package com.xunruan.framekork.cache;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.PatternMatchUtils;

import com.xunruan.framekork.cache.util.KeyUtils;

public class NameMatchCacheInterceptor
implements MethodInterceptor
{

private static final Log log = LogFactory.getLog(NameMatchCacheInterceptor.class);
private Map attributes;

public NameMatchCacheInterceptor()
{
}

public Object invoke(MethodInvocation methodInvocation)
	throws Throwable
{
	Object params[] = methodInvocation.getArguments();
	Method method = methodInvocation.getMethod();
	String className = methodInvocation.getThis().getClass().getName();
	Object key = KeyUtils.getKey(className, method.getName(), params);
	log.info((new StringBuilder("Key HashCode:")).append(key).toString());
	Cache cache = getCache(method);
	Element data = cache.get(key);
	Object result = null;
	if (data == null)
		try
		{
			result = methodInvocation.proceed();
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

public Cache getCache(Method method)
{
	String methodName = method.getName();
	Cache cache = (Cache)attributes.get(methodName);
	if (cache == null)
	{
		String bestNameMatch = null;
		Iterator it = attributes.keySet().iterator();
		do
		{
			if (!it.hasNext())
				break;
			String mappedName = (String)it.next();
			if (isMatch(methodName, mappedName) && (bestNameMatch == null || bestNameMatch.length() <= mappedName.length()))
			{
				cache = (Cache)attributes.get(mappedName);
				bestNameMatch = mappedName;
			}
		} while (true);
	}
	return cache;
}

protected boolean isMatch(String methodName, String mappedName)
{
	return PatternMatchUtils.simpleMatch(mappedName, methodName);
}

public void setAttributes(Map attributes)
{
	this.attributes = attributes;
}

}
