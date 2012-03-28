package com.sunshine.framework.interceptor;

import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sunshine.framework.action.BaseAction;
import com.sunshine.framework.context.ConfigConstant;
import com.sunshine.framework.entity.ActionException;
import com.sunshine.framework.util.SysLogger;

public class BaseInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 9128375967857206865L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String intercept(ActionInvocation invocation) throws ActionException {
		String invokeResult = null;
		BaseAction action = (BaseAction) invocation.getAction();	
//		action.setRequest(ServletActionContext.getRequest());
//		action.setResponse(ServletActionContext.getResponse());
//		action.setSession(ServletActionContext.getRequest().getSession());
		String actionName = action.getClass().getName();
		String path = ServletActionContext.getRequest().getContextPath();
		ServletActionContext.getRequest().getSession().setAttribute("path", path);

		String url = ServletActionContext.getRequest().getRequestURL().toString();
		url = url.substring(0, url.indexOf(path));
		ConfigConstant.sysUrl = url + path;
		String URI = ServletActionContext.getRequest().getRequestURI();
		ServletActionContext.getRequest().setAttribute("URI", URI.substring(0,URI.lastIndexOf("_")));
		// 过滤  Action 或  Action Method Begin
		String actionClass = actionName.substring(actionName.lastIndexOf(".")+1); 
		String actionNameMethod = URI.substring(URI.lastIndexOf("/")+1, URI.length());
		boolean isSkip = false;
		List<String> interceptor = ConfigConstant.strutsInterceptor;
		for (String struts : interceptor) 
			if (actionClass.equals(struts)) {
				isSkip = true;
				break;
			}
		if (isSkip == false)
			for (String struts : interceptor)
				if (actionNameMethod.equals(struts)) {
					isSkip = true;
					break;
				}
		// 过滤Action或Action的Method   End
		
		// Session 超时  & 权限控制
		if (isSkip == false) {
			if(ServletActionContext.getRequest().getSession().getAttribute(ConfigConstant.LOGIN_ENTITY) == null)
				return "overtime";
			
		}
		try {
			invokeResult = invocation.invoke();
		} catch (Exception e) {
			SysLogger.error("Action error when invoke method.",e);
			throw new ActionException(e);
		}
		return invokeResult;
	}
	
}

