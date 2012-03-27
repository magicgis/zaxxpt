package com.xunruan.framekork.web.tag;

/**
 * 
 */

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;

import com.xunruan.framekork.util.BigAmountUtil;


/**
  *@author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public class FormatAmountTag extends XunRuanTagSupport {
	private static final String BIGAMOUNT = "bigamount";
	

	protected String isStack="false";
	private String value;
	private String pattern;
	public int doStartTag() throws javax.servlet.jsp.JspException {
		try {
			pageContext.getOut().print(getOutput());
		} catch (java.io.IOException ex) {
			throw new JspException(ex.getMessage(), ex);
		}
		return SKIP_BODY;
	}

	private String getOutput() {
		try {
			Double d ;
			if(null!=isStack&&"true".equals(isStack)) d=(Double)this.findValue(this.getValue(), Double.class);
			else d=Double.valueOf(this.getValue());
			if (d != null) {
				if (BIGAMOUNT.equals(this.pattern))
					return BigAmountUtil.getBigAmount(new BigDecimal(d).toString());
				else {
					return new DecimalFormat(this.pattern == null ? "##,###,###,###,##0.00" : this.pattern).format(d);
				}
			}
		} catch (Exception e) {
		}
		return "";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getIsStack() {
		return isStack;
	}

	public void setIsStack(String isStack) {
		this.isStack = isStack;
	}
	
}
