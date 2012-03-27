package com.xunruan.framekork.web.tag.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

/***
 * 
 * @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public abstract class XunRuanUITag extends AbstractUITag {

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		// TODO Auto-generated method stub
		return ComponentUtil.getBean(this.getClass(), "Tag", stack, req, res);
	}

}
