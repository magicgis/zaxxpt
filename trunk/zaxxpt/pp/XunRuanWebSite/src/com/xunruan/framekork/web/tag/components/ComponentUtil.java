package com.xunruan.framekork.web.tag.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

/***
 * 
 *  @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public class ComponentUtil {
	
	@SuppressWarnings("unchecked")
	public static Component getBean(Class<?> peerClass, String suffix, ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		try {
			Class<XunRuanComponent> clazz = (Class<XunRuanComponent>)Class.forName(getComponentClass(peerClass, suffix));
			Component ret = clazz.getConstructor(new Class[]{
					ValueStack.class, HttpServletRequest.class,
					HttpServletResponse.class
			}).newInstance(new Object[]{stack, req, res});

//	        ServiceLocator.getContainer().inject(ret);
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

	public static String getComponentClass(Class<?> peerClass, String suffix) {
		String ret = peerClass.getName();
		if (ret.endsWith(suffix)) {
			return ret.substring(0, ret.length() - suffix.length()) + XunRuanComponent.CLASS_SUFFIX;
		}
		
		throw new RuntimeException("类名必须以"+suffix+"结束");
	}
}

