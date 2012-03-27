package com.xunruan.framekork.cache.listener;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

public class EhCacheEventListenerFactory extends CacheEventListenerFactory
{

	Log log;

	public EhCacheEventListenerFactory()
	{
		log = LogFactory.getLog(EhCacheEventListenerFactory.class);
	}

	public CacheEventListener createCacheEventListener(Properties properties)
	{
		return new CacheEventListener() {

			final EhCacheEventListenerFactory this$0;

			public void dispose()
			{
				log.info("dispose");
			}

			public void notifyElementEvicted(Ehcache ehcache, Element element)
			{
				log.info((new StringBuilder("移出(Evicted) :Key=")).append(element.getKey()).append(",value=").append(element.getValue()).toString());
			}

			public void notifyElementExpired(Ehcache ehcache, Element element)
			{
				log.info((new StringBuilder("过期(Expired) :Key=")).append(element.getKey()).append(",value=").append(element.getValue()).toString());
			}

			public void notifyElementPut(Ehcache ehcache, Element element)
				throws CacheException
			{
				log.info((new StringBuilder("缓存(Put) :Key=")).append(element.getKey()).append(",value=").append(element.getValue()).toString());
			}

			public void notifyElementRemoved(Ehcache ehcache, Element element)
				throws CacheException
			{
				log.info((new StringBuilder("删除(Removed) :Key=")).append(element.getKey()).append(",value=").append(element.getValue()).toString());
			}

			public void notifyElementUpdated(Ehcache ehcache, Element element)
				throws CacheException
			{
				log.info((new StringBuilder("更新(Updated) :Key=")).append(element.getKey()).append(",value=").append(element.getValue()).toString());
			}

			public void notifyRemoveAll(Ehcache ehcache)
			{
				log.info("RemoveAll");
			}

			public Object clone()
				throws CloneNotSupportedException
			{
				log.info("clone");
				return null;
			}

			
			{
				this$0 = EhCacheEventListenerFactory.this;
			}
		};
	}
}
