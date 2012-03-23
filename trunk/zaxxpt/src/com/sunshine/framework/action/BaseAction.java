package com.sunshine.framework.action;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;


import com.opensymphony.xwork2.ActionSupport;
import com.sunshine.framework.context.ConfigConstant;
import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.ActionException;
import com.sunshine.framework.entity.PageEntity;
import com.sunshine.framework.entity.SearchEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.service.BaseService;
import com.sunshine.framework.util.BeanUtils;
import com.sunshine.framework.util.SysLogger;
import com.system.log.service.LogService;
import com.system.user.entity.UserEntity;

/***
 * Action 基本类
 * @author ralphone.zhuo
 *
 */


public abstract class BaseAction extends ActionSupport implements 
		ServletRequestAware, ServletResponseAware {
	public HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private BaseService service;
	private String selectId;
	private SearchEntity searchEntity;
	private PageEntity pageEntity;
	private Map<String, Class<? extends BaseEntity>> entityMap = new HashMap();
	private LogService logService;
	private String menuid;
	public BaseAction(){
		registerEntity();
	}
	public String enter() throws ActionException {
		// 清空查询&分页Session
		
		session.removeAttribute(ConfigConstant.SEARCH);
		
		UserEntity userEntity = (UserEntity)session.getAttribute(ConfigConstant.LOGIN_ENTITY);
		this.getLogService().save(this.getMenuid(), "", userEntity.getUsername() + " 进入模块", userEntity.getId(), request.getRemoteAddr());
		
		return "enter";
	}
	//信息列表（分页）
	public String query() throws ActionException  {
		try{
		
		if (session.getAttribute(ConfigConstant.SEARCH) != null)
			setSearchEntity((SearchEntity)session.getAttribute(ConfigConstant.SEARCH));
		else  searchEntity=new SearchEntity();	
		session.removeAttribute(ConfigConstant.SEARCH);
		String pageNo=request.getParameter("page");
		int page=1;
		if(BeanUtils.isNotEmpty(pageNo)){
			page=Integer.parseInt(pageNo);
		}
		pageEntity=new PageEntity();
		pageEntity.setPage(page);
		List<BaseEntity> list = getService().query(entityMap.get(ConfigConstant.MASTER), getSearchEntity(), getPageEntity());
		
		UserEntity userEntity = (UserEntity)session.getAttribute(ConfigConstant.LOGIN_ENTITY);
		
		this.getLogService().save(this.getMenuid(), "", userEntity.getUsername() + " 进行查询", userEntity.getId(), request.getRemoteAddr());
//		this.getLogService().save(this.getMenuid(), "", " 进行查询", null, request.getRemoteAddr());
		request.setAttribute(ConfigConstant.MASTER, list);
		request.setAttribute(ConfigConstant.SEARCH, searchEntity);
		request.setAttribute(ConfigConstant.PAGE, pageEntity);
		}catch(Exception e){
			SysLogger.error("Action query method error.",e);
			throw new ActionException(e);
		}
		return "list";
	}
	
	//详细信息
	public String view() throws ActionException {
		
		if (!entityMap.isEmpty()) {
			try{
			Class masterClass = entityMap.get(ConfigConstant.MASTER);
			// 查询主表
			BaseEntity entity = this.getService().selectById(selectId,
					masterClass);
			
			UserEntity userEntity = (UserEntity)session.getAttribute(ConfigConstant.LOGIN_ENTITY);
			this.getLogService().save(this.getMenuid(), "", userEntity.getUsername() + " 进行详细内容查看", userEntity.getId(), request.getRemoteAddr());
			
			request.setAttribute(ConfigConstant.MASTER, entity);
			// 查询子表
			if (entity != null && entityMap.size() > 1) {
				Set keySet = entityMap.keySet();
				Iterator iter = keySet.iterator();
				while (iter.hasNext()) {
					String key = (String) iter.next();
					if (!key.equalsIgnoreCase(ConfigConstant.MASTER)) {
						Class childClass = entityMap.get(key);
						List child = this.getService().selectChild(childClass,
								entity);
						if (child != null && child.size() > 0) {
							request.setAttribute(key, child);
						}
					}
				}
			}
			}catch(Exception e){
				SysLogger.error("Action view method error.",e);
				throw new ActionException(e);
			}
		}
		return "view";
	}

	public String edit() throws ActionException {
		// 未增加令牌，重复校验
		
		if (!entityMap.isEmpty()) {
			try{
			Class masterClass = entityMap.get(ConfigConstant.MASTER);
			BaseEntity master = copyProperties(masterClass);
			BaseEntity newEntity = this.getService().modify(master);

			UserEntity userEntity = (UserEntity)session.getAttribute(ConfigConstant.LOGIN_ENTITY);
			this.getLogService().save(this.getMenuid(), "", userEntity.getUsername() + " 进行编辑", userEntity.getId(), request.getRemoteAddr());
			
			request.setAttribute(ConfigConstant.MASTER, newEntity);
			}catch(Exception e){
				SysLogger.error("Action edit method error.",e);
				throw new ActionException(e);
			}
		}
		return "edit";
	}

	public String add() throws ActionException {
		
		if (!entityMap.isEmpty()) {
			try {
				Class masterClass = entityMap.get(ConfigConstant.MASTER);
				BaseEntity master = copyProperties(masterClass);
				if (BeanUtils.isObjectNotNull(master)) {
					this.getService().insert(master);

					UserEntity userEntity = (UserEntity)session.getAttribute(ConfigConstant.LOGIN_ENTITY);
					this.getLogService().save(this.getMenuid(), "", userEntity.getUsername() + " 进行添加", userEntity.getId(), request.getRemoteAddr());
					
					// 添加子表
					if (master != null && entityMap.size() > 1) {
						Set keySet = entityMap.keySet();
						Iterator iter = keySet.iterator();
						while (iter.hasNext()) {
							String key = (String) iter.next();
							if (!key.equalsIgnoreCase(ConfigConstant.MASTER)) {
								Class childClass = entityMap.get(key);
								BaseEntity child = copyProperties(childClass);
								if (BeanUtils.isObjectNotNull(child)) {
									this.getService().addChild(master, child);
								}
							}
						}
					}
				}

			} catch (Exception e) {
				SysLogger.error("Action add method error.",e);
				throw new ActionException(e);
			}
		}
		return "add";
	}

	public String delete() throws ActionException {
		
		if (!entityMap.isEmpty()) {
			try{
			Class masterClass = entityMap.get(ConfigConstant.MASTER);
			BaseEntity master=entityOnlyId(selectId,masterClass);
			// 删除主表
			this.getService().deleteById(selectId,masterClass);
			

			UserEntity userEntity = (UserEntity)session.getAttribute(ConfigConstant.LOGIN_ENTITY);
			this.getLogService().save(this.getMenuid(), "", userEntity.getUsername() + " 进行删除", userEntity.getId(), request.getRemoteAddr());
			
			// 查询子表
			if (entityMap.size() > 1) {
				Set keySet = entityMap.keySet();
				Iterator iter = keySet.iterator();
				while (iter.hasNext()) {
					String key = (String) iter.next();
					if (!key.equalsIgnoreCase(ConfigConstant.MASTER)) {
						Class childClass = entityMap.get(key);
						this.getService().deleteChild(childClass, master);
					}
				}
			}
			}catch(Exception e){
				SysLogger.error("Action delete method error.",e);
				throw new ActionException(e);
			}
		}
		return "delete";
	}

	private BaseEntity copyProperties(Class<? extends BaseEntity> masterClass)
			throws ActionException {
		Class actionClass=this.getClass();
		BaseEntity entity=null;
		Field[] fields=actionClass.getDeclaredFields();
		for(Field field:fields){
			if(field.getType()== masterClass){
				try {
					field.setAccessible(true);
					entity=(BaseEntity) field.get(this);
				} catch (IllegalArgumentException e) {
					throw new ActionException(e);
				} catch (IllegalAccessException e) {
					throw new ActionException(e);
				}
			}
		}
		return entity;
	}	

	private BaseEntity entityOnlyId(String id,Class<? extends BaseEntity> entityClass) throws ActionException{
		Field[] fields=entityClass.getDeclaredFields();
		Object obj=null;
		try{
		 obj=entityClass.newInstance();
		for(Field f:fields){
			if(f.isAnnotationPresent(FieldMethod.class)){
				FieldMethod fieldMethod=f.getAnnotation(FieldMethod.class);
				if(fieldMethod.IsPK()){
					f.setAccessible(true);
					f.set(obj, id);
					break;
				}
			}
		}
		}catch(Exception e){
			throw new ActionException(e);
		}
		
		BaseEntity entity=(BaseEntity)obj;
		
		
		return entity;
	}
	public abstract void registerEntity();

	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {

		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}


	public BaseService getService() {
		return service;
	}

	public void setService(BaseService service) {
		this.service = service;
	}

	public String getSelectId() {
		return selectId;
	}

	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}

	public Map<String, Class<? extends BaseEntity>> getEntityMap() {
		return entityMap;
	}

	public void setEntityMap(Map<String, Class<? extends BaseEntity>> entityMap) {
		this.entityMap = entityMap;
	}
	public HttpSession getSession() {
		return session;
	}
	
	public SearchEntity getSearchEntity() {
		return searchEntity;
	}
	public void setSearchEntity(SearchEntity searchEntity) {
		this.searchEntity = searchEntity;
	}
	public PageEntity getPageEntity() {
		return pageEntity;
	}
	public void setPageEntity(PageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	
}
