package com.xunruan.framekork.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xunruan.framekork.util.StringUtil;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheDataManager
{

	private static Log log = LogFactory.getLog(CacheDataManager.class);
	private static CacheManager cacheManager;

	public CacheDataManager()
	{
	}

	public static Object get(Object key)
	{
		return get("eternal", key);
	}

	public static void put(Object key, Object value)
	{
		put("eternal", key, value);
	}

	public static void remove(Object key)
	{
		remove("eternal");
	}

	public static void clear()
	{
		clear("eternal");
	}

	private static Cache getCache(String cacheName)
	{
		if (!cacheManager.cacheExists(cacheName))
		{
			log.debug((new StringBuilder("cache '")).append(cacheName).append("' not exists").toString());
			return null;
		} else
		{
			Cache cache = cacheManager.getCache(cacheName);
			return cache;
		}
	}

	public static Object get(String cacheName, Object key)
	{
		if (StringUtil.isEmpty(cacheName) || key == null)
			return null;
		Cache cache = getCache(cacheName);
		if (cache != null)
		{
			Element el = cache.get(key);
			if (el != null)
				return el.getObjectValue();
		}
		return null;
	}

	public static void remove(String cacheName, Object key)
	{
		if (StringUtil.isEmpty(cacheName) || key == null)
			return;
		Cache cache = getCache(cacheName);
		if (cache != null)
			cache.remove(key);
	}

	public static void clear(String cacheName)
	{
		if (StringUtil.isEmpty(cacheName))
			return;
		Cache cache = getCache(cacheName);
		if (cache != null)
			cache.removeAll();
	}

	public static void put(String cacheName, Object key, Object value)
	{
		if (StringUtil.isEmpty(cacheName) || key == null || value == null)
			return;
		Cache cache = getCache(cacheName);
		if (cache != null)
			cache.put(new Element(key, value));
	}

	public void setCacheManager(CacheManager cacheManager)
	{
		cacheManager = cacheManager;
	}

}
