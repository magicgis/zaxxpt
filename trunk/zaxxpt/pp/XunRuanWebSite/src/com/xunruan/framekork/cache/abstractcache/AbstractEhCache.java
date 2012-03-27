package com.xunruan.framekork.cache.abstractcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public abstract class AbstractEhCache
	implements IDataCache
	{
	private Cache cache;
	
	public void clear()
	{
	  this.cache.removeAll();
	}
	
	public void put(Object key, Object value) {
	  this.cache.put(new Element(key, value));
	}
	
	public void remove(Object key) {
	  this.cache.remove(key);
	}
	
	public Object get(Object key) {
	  Element element = this.cache.get(key);
	  if (element == null)
	    return null;
	
	  return element.getObjectValue();
	}
	
	public void setCache(Cache cache) {
	  this.cache = cache;
	}
}