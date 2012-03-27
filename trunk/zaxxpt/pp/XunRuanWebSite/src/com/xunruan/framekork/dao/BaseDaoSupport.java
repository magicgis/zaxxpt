package com.xunruan.framekork.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.registry.infomodel.PersonName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xunruan.framekork.domain.BaseDomain;
import com.xunruan.framekork.lang.PageInfo;
import com.xunruan.framekork.util.ConverterUtil;
import com.xunruan.framekork.util.StringUtil;
import com.xunruan.site.domain.SysUser;

/***
 * 
 * @author wenz
 * 数据库操作
 * @param <E> 实体对象
 * @version 1.0
 */
public  abstract class  BaseDaoSupport<E extends BaseDomain> extends HibernateDaoSupport implements
		IBaseDao<E> {
	private static final Log log = LogFactory.getLog(BaseDaoSupport.class);
	private static final String FROM="FROM";
	private static final String COUNT="count(*)";

	public Object delete(E e) {
		// TODO Auto-generated method stub
		log.debug("deleting "+e+" instance");
		try {
			getHibernateTemplate().delete(e);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		return null;
	}

	public List<E> find(Class<E> classs) {
		// TODO Auto-generated method stub
		log.debug("finding all "+classs.getName()+" instances");
		try {
			String queryString = "from "+classs.getSimpleName();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public E findById(Class<E> classs,String id) {
		// TODO Auto-generated method stub
		log.debug("getting "+classs.getName()+" instance with id: " + id);
		try {
			E instance = (E) getHibernateTemplate().get(
					classs.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<E> findByParam(E e) {
		// TODO Auto-generated method stub
		log.debug("finding UserRole instance by example");
		try {
			List<E> results = getHibernateTemplate().findByExample(e);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<E> findByParam(Class<E> classs,String param, String value) {
		// TODO Auto-generated method stub
		log.debug("finding "+classs.getName()+" instance with property: " + param
				+ ", value: " + value);
		try {
			String queryString = "from "+classs.getName()+" as model where model."
					+ param + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public Object insert(E e) {
		// TODO Auto-generated method stub
		log.debug("insert "+e+" instance");
		try {
		 return getHibernateTemplate().save(e);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public Object update(E e) {
		// TODO Auto-generated method stub
		log.debug("update "+e+" instance");
		try {
		  getHibernateTemplate().update(e);
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
		return null;
	}
	
	protected List<E> findListByPage(final String hql,final int firstResult,final int maxResults){
		return getHibernateTemplate().execute(new HibernateCallback<List<E>>() {
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery(hql);
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
				return query.list();
			}
		});
	}

	protected List<E> findListByPage(final String hql,final int firstResult,final int maxResults,final Object obj){
		return getHibernateTemplate().execute(new HibernateCallback<List<E>>() {
			public List<E> doInHibernate(Session session) throws HibernateException,
					SQLException {
				try {
					
					Query query=session.createQuery(hql);
					query.setFirstResult(firstResult);
					query.setMaxResults(maxResults);
					if(obj instanceof Map)
						query.setProperties((Map)obj);
					else if(obj instanceof BaseDomain)
						query.setProperties((BaseDomain)obj);
					else
						throw new HibernateException("obj 对象类型不为Map或者Bean[BaseDomain]");
					List list=query.list();
					return list;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return null;
			}
		});
	}
	
	protected Long findCountByPage(final String hql){
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery(hql);
				return (Long)query.list().get(0);
			}
		});
	}
	
	protected Long findCountByPage(final String hql,final Object obj){
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery(hql);
				if(obj instanceof Map)
					query.setProperties((Map)obj);
				else if(obj instanceof BaseDomain)
					query.setProperties((BaseDomain)obj);
				else
					throw new HibernateException("obj 对象类型不为Map或者Bean[BaseDomain]");
				return (Long)query.list().get(0);
			}
		});
	}
	public PageInfo<E> find(Class<E> classs,PageInfo<E> page) {
		// TODO Auto-generated method stub
		log.debug("start find byPage");
		try {
			String hqlByList="from "+classs.getName();
			String hqlByCount="select "+COUNT+" from "+classs.getName();
			page.setRecordList(this.findListByPage(hqlByList, page.getStartIndex(), page.getRowsOfPage()));
			page.setTotalRowCount(this.findCountByPage(hqlByCount).intValue());
			log.debug("success find byPage");
		} catch (Exception e) {
			log.error("find failed", e);
			e.printStackTrace();
		}
		return page;
	}

	public PageInfo<E> findByParam(Class<E> classs, PageInfo<E> page, String param,
			String value) {
		//TODO Auto-generated method stub
		log.debug("start find byParamPage");
		try {
			String hqlByList="from "+classs.getName()+" as model where model."+param+"=:"+param;
			Map map=new HashMap();map.put(param, value);
			String hqlByCount="select "+COUNT+" from "+classs.getName()+" as model where model."+param+"=:"+param;
			page.setRecordList(this.findListByPage(hqlByList, page.getStartIndex(), page.getRowsOfPage(),map));
			page.setTotalRowCount(this.findCountByPage(hqlByCount,map).intValue());
			log.debug("success find byParamPage");
		} catch (Exception e) {
			log.error("find failed", e);
			e.printStackTrace();
		}
		return page;
	}

	public PageInfo<E> findByParam(E e, PageInfo<E> page) {
		// TODO Auto-generated method stub
		log.debug("start find byParamPage");
		try {
			Map<String, Object> map=ConverterUtil.ObjectFieldMap(e);
			StringBuffer hqlByList=new StringBuffer("from "+e.getClass().getName());
			StringBuffer hqlByCount=new StringBuffer("select "+COUNT+" from "+e.getClass().getName());
			StringBuffer whereHql=new StringBuffer(" as model where 1=1");
			Set<String> set=map.keySet();
			for (String string : set) {
				if(StringUtil.isNotEmpty(string))
					whereHql.append(" and "+string+"=:"+string);
			}
			hqlByList.append(whereHql);hqlByCount.append(whereHql);
			page.setRecordList(this.findListByPage(hqlByList.toString(), page.getStartIndex(), page.getRowsOfPage(),map));
			page.setTotalRowCount(this.findCountByPage(hqlByCount.toString(),map).intValue());
			log.debug("success find byParamPage");
		} catch (Exception ex) {
			// TODO: handle exception
			log.error("find failed", ex);
			ex.printStackTrace();
		}
		return page;
	}
	
	
	public List<E> findByHql(final String hql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<E>>() {
			public List<E> doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery(hql);
				return query.list();
			}
		});
	}

	public List<E> findByHql(final E e, final String hql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<E>>() {
			public List<E> doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery(hql);
				query.setProperties(e);
				return query.list();
			}
		});
	}

	public List<E> findByHql(final Map<String, Object> map,final String hql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<E>>() {
			public List<E> doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery(hql);
				query.setProperties(map);
				return query.list();
			}
		});
	}

	public PageInfo<E> findByHql(PageInfo<E> page, String hql) {
		// TODO Auto-generated method stub
		page.setRecordList(this.findListByPage(hql, page.getStartIndex(), page.getRowsOfPage()));
		int index=hql.toUpperCase().indexOf(FROM);
		if(index!=-1){
			hql="select "+COUNT+" "+hql.substring(index);
			page.setTotalRowCount(this.findCountByPage(hql).intValue());
		}else
			log.error("找不到FROM");
		return page;
	}
	
	public PageInfo<E> findByHql(PageInfo<E> page, String hql, E e) {
		// TODO Auto-generated method stub
		page.setRecordList(this.findListByPage(hql, page.getStartIndex(), page.getRowsOfPage(),e));
		int index=hql.toUpperCase().indexOf(FROM);
		if(index!=-1){
			hql="select "+COUNT+" "+hql.substring(index);
			page.setTotalRowCount(this.findCountByPage(hql,e).intValue());
		}else
			log.error("找不到FROM");
		return page;
	}

	public PageInfo<E> findByHql(PageInfo<E> page, String hql, Map<String, Object> map) {
		// TODO Auto-generated method stub
		page.setRecordList(this.findListByPage(hql, page.getStartIndex(), page.getRowsOfPage(),map));
		int index=hql.toUpperCase().indexOf(FROM);
		if(index!=-1){
			hql="select "+COUNT+" "+hql.substring(index);
			page.setTotalRowCount(this.findCountByPage(hql,map).intValue());
		}else
			log.error("找不到FROM");
		return page;
	}
}
