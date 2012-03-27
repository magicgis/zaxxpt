package com.xunruan.framekork.web.interceptor;

/*
 * Copyright (c) 2002-2006 by OpenSymphony
 * All rights reserved.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**
 * An abstract interceptor that provides simple access to before/after callouts.
 *
 * @author Jason Carreira
 */
public abstract class AroundInterceptor implements Interceptor {

    protected transient Log log = LogFactory.getLog(getClass());

    public void destroy() {
    }

    public void init() {
    }

    public String intercept(ActionInvocation invocation) throws Exception {
        String result = null;

        try {
	        before(invocation);
	        result = invocation.invoke();
	        after(invocation, result);
        }
        finally {
        	doFinally(invocation);
        }

        return result;
    }

    /**
     * Called after the invocation has been executed.
     *
     * @param result the result value returned by the invocation
     */
    protected void after(ActionInvocation dispatcher, String result) throws Exception {
    	
    }

    /**
     * Called before the invocation has been executed.
     */
    protected void before(ActionInvocation invocation) throws Exception {
    	
    }
    
    protected void doFinally(ActionInvocation invocation) throws Exception {
    	
    }
}
