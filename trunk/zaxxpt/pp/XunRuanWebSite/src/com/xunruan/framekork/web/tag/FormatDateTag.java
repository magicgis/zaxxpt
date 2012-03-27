package com.xunruan.framekork.web.tag;

/**
 * 
 */

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.jsp.JspException;

import com.xunruan.framekork.util.ClassUtils;
import com.xunruan.framekork.util.DateUtil;
import com.xunruan.framekork.util.DateUtils;
import com.xunruan.framekork.util.StringUtil;


/**
 * 格式化日期  格式为 yyyyMMdd
 * 
 * @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public class FormatDateTag extends XunRuanTagSupport {

	protected String value;
	protected String pattern;	
	protected String isStack="false";

	public int doStartTag() throws javax.servlet.jsp.JspException {
		try {
			pageContext.getOut().print(getOutput());
		} catch (java.io.IOException ex) {
			throw new JspException(ex.getMessage(), ex);
		}
		return SKIP_BODY;
	}
	
	protected String getOutput() {
		if("now".equals(this.getValue())) return DateUtils.format(new Date(), getPattern()); 
		Object val =null;
		if(null!=isStack&&"true".equals(isStack)) val = this.findValue(this.getValue());
		else val=this.getValue();
		if (val == null) return "";
		if (val instanceof String)  return DateUtils.format(val.toString(), getPattern());
		else if (val instanceof Calendar) return DateUtils.format(((Calendar)val).getTime(), getPattern());
		else if (val instanceof Date) return DateUtils.format((Date)val, getPattern());
		try {
			// 支持Oracle TIMESTAMP/DATE类型
			return DateUtils.format((Date)ClassUtils.invokePrivateMethod(val, "timestampValue", null, null), getPattern());
		} catch (Exception e) {
		}
		throw new IllegalArgumentException("类型错误: " + val.getClass().getName() + ", " + val);
	
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	protected String getPattern() {
		if(!StringUtil.isEmpty(pattern)) return pattern; 
		return  "yyyyMMdd";
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
