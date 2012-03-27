package com.xunruan.framekork.cache.abstractcache;

public abstract interface IDataCache
{
  public abstract Object get(Object paramObject);

  public abstract void put(Object paramObject1, Object paramObject2);

  public abstract void remove(Object paramObject);

  public abstract void clear();

  public abstract void loadCache()
    throws Exception;
}
