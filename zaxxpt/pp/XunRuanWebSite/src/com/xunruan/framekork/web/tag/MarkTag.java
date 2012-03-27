package com.xunruan.framekork.web.tag;

/**
 * 
 */

import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;

import com.xunruan.framekork.util.StringUtil;


/**
 * @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public class MarkTag extends XunRuanTagSupport {
	
	private String value;
	protected String isStack="false";
	
	public int doStartTag() throws javax.servlet.jsp.JspException {
		try {
			pageContext.getOut().print(getOutput());
		} catch (java.io.IOException ex) {
			throw new JspException(ex.getMessage(), ex);
		}
		return SKIP_BODY;
	}

	private String getOutput() {
		String val = null;
		if(null!=isStack&&"true".equals(isStack))val = (String) this.findValue(this.getValue());
		else val=this.getValue();
		String outStr = new String();
		if(StringUtil.isEmpty(val)) return "";
		if(val.length() > 8)  outStr = val.substring(0, val.length() - 8) + "****" + val.substring(val.length()-4);
		else outStr = val;
		return outStr;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIsStack() {
		return isStack;
	}

	public void setIsStack(String isStack) {
		this.isStack = isStack;
	}
	
}
