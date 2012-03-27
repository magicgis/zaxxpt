package com.xunruan.framekork.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.xunruan.framekork.lang.Application;

public abstract class BaseAction extends ActionSupport implements Preparable,Action {

	private String message;
	private String errorMessage[];
	protected final transient Log log = LogFactory.getLog(BaseAction.class);



	public Map getMapFromRequest()
	{
		Map map = new HashMap();
		Map parameterMap = getRequest().getParameterMap();
		if (parameterMap != null && parameterMap.size() > 0)
		{
			String name;
			String value;
			for (Iterator iterator = parameterMap.keySet().iterator(); iterator.hasNext(); map.put(name, value))
			{
				Object obj = iterator.next();
				name = String.valueOf(obj);
				value = getRequest().getParameter(name);
			}
		}
		return map;
	}

	protected Application getApplication()
	{
		return Application.get();
	}
	protected HttpServletRequest getRequest()
	{
		return getApplication().getRequest();
	}

	protected HttpSession getSession()
	{
		return getApplication().getSession();
	}

	protected HttpServletResponse getResponse()
	{
		return getApplication().getResponse();
	}

	protected ServletContext getServletContext()
	{
		return getApplication().getServletContext();
	}

	/***
	 * 获取请求Ip地址，为防止用户使用代理则从请求头部信息中获取，忽略使用多级代理方式
	 * @return IP
	 */
	public String getIp(){
		return getApplication().getIp(); 

	}

	protected void writeString(String returnInfo)
		throws IOException
	{
		HttpServletResponse response = getResponse();
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.write(returnInfo);
		out.close();
	}

	protected void writeString(Object returnInfo, String type)
		throws IOException
	{
		String str = null;
		if ("xml".equals(type) || "html".equals(type))
		{
			getResponse().setContentType((new StringBuilder("text/")).append(type).append("; charset=UTF-8").toString());
			if (returnInfo instanceof String)
				str = (String)returnInfo;
			else
			if (returnInfo instanceof Integer)
				str = String.valueOf(returnInfo);
		} else
		if ("gson".equals(type))
		{
			Gson gson = new Gson();
			if (returnInfo instanceof List)
				str = gson.toJson((List)returnInfo);
			else
			if (returnInfo instanceof String)
				str = gson.toJson((String)returnInfo);
			else
			if (returnInfo instanceof Integer)
				str = gson.toJson(String.valueOf(returnInfo));
		} else
		if ("from".equals(type))
			str = (String)returnInfo;
		else
			"json".equals(type);
		writeString(str);
	}


	public String[] getErrorMessage()
	{
		return errorMessage;
	}


	public String getMessage()
	{
//		Application.get().getm
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
	/***
	 * prepare方法由PrepareInterceptor拦截器调用执行
	 * 如果每次调用action都执行同样的业务逻辑则可重写此方法并实现业务逻辑
	 * @author wenz
	 */
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
}
