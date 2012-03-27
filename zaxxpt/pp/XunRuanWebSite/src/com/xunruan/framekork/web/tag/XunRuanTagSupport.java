package com.xunruan.framekork.web.tag;


import java.util.Iterator;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.views.util.ContextUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.TextParseUtil;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author wenz
 * @version 1.0
 * 2012 -02-13
 */
public abstract class XunRuanTagSupport extends BodyTagSupport {
	private final Log log = LogFactory.getLog(XunRuanTagSupport.class);
	

	protected String findString(String expr) {
        return (String) findValue(expr, String.class);
    }

    protected Object findValue(String expr) {
        if (expr == null) {
            return null;
        }

        if (altSyntax()) {
            // does the expression start with %{ and end with }? if so, just cut it off!
            if (expr.startsWith("%{") && expr.endsWith("}")) {
                expr = expr.substring(2, expr.length() - 1);
            }
        }

        ValueStack valueStack=getStack();
        Iterator<Object> iterator=valueStack.getRoot().iterator();
        while(iterator.hasNext()){
        	Object object=iterator.next();
        	System.out.println(object);
        }
        return valueStack.findValue(expr);
    }

    protected Object findValue(String expr, Class<?> toType) {
        if (altSyntax() && toType == String.class) {
            return TextParseUtil.translateVariables('%', expr, getStack());
        } else {
            if (altSyntax()) {
                // does the expression start with %{ and end with }? if so, just cut it off!
                if (expr.startsWith("%{") && expr.endsWith("}")) {
                    expr = expr.substring(2, expr.length() - 1);
                }
            }

            return getStack().findValue(expr, toType);
        }
    }
    
    private boolean altSyntax() {
        return ContextUtil.isUseAltSyntax(getStack().getContext());
    }
    
    public ValueStack getStack() {
        return ActionContext.getContext().getValueStack();
    }
}
