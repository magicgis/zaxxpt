/**
 * 
 */
package com.xunruan.framekork.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ognl.OgnlValueStack;
import com.opensymphony.xwork2.ognl.OgnlValueStackFactory;
import com.opensymphony.xwork2.util.ValueStack;
import com.xunruan.framekork.util.OgnlUtil;

/**
 * @author wenz
 * @version 1.0
 *  2012-02-17
 *
 */
public class OgnlUtilInterceptor extends AroundInterceptor {

	@SuppressWarnings("unchecked")
	@Override
	protected void before(ActionInvocation invocation) throws Exception {
		OgnlUtil ognl = OgnlUtil.INSTANCE;
//		// 将工具类放到栈底
		invocation.getStack().getRoot().add(ognl);
		super.before(invocation);
	}
	
	public static void main(String[] args) {
		OgnlUtil ognl = OgnlUtil.INSTANCE;
//		System.out.println(ognl.$afterDate(8));
		OgnlValueStackFactory factory=new OgnlValueStackFactory();
		ValueStack valueStack=factory.createValueStack();
		valueStack.getRoot().add(ognl);
	}

}
