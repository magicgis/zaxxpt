package com.xunruan.framekork.web.tag;

/**
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xunruan.framekork.util.StringUtil;


/**
 * 生成客户端Cookie，优先使用客户端已传递的相同名称的Cookie值
 * 通过标签的value属性指定要生成的Cookie值，如果值为"RANDOM"，
 * 则系统随机生成12位字符串.
 * @author wenz
 * @verision 1.0
 * 2012-02-13
 * 
 */
public class CookieTag extends XunRuanTagSupport {
	
	private String name;
	private String value;
	private int maxAge = -1;
	private boolean secure = false;
	private boolean cover = false;
	
	public void release() {
		super.release();
		name = null;
		value = null;
		maxAge = -1;
		secure = false;
	}
	
	//此方法有问题，如果想要用此方法覆盖旧有的cookie里的值，用此方法达不到要求,增加一个参数，来判断是否要覆盖原cookie
	public int doStartTag() throws javax.servlet.jsp.JspException {
		Cookie cookie = new Cookie(name, getCookieValue());
		cookie.setMaxAge(maxAge);
		cookie.setSecure(secure);
		((HttpServletResponse) pageContext.getResponse()).addCookie(cookie);
		
		return SKIP_BODY;
	}
	
	private String getCookieValue() {
		if (!cover) {
			Cookie[] cs = ((HttpServletRequest) pageContext.getRequest()).getCookies();
			if (cs != null) {
				for (int i = 0; i < cs.length; i++) {
					if (name.equals(cs[i].getName())) return cs[i].getValue();
				}
			}
		}
		return StringUtil.isEmpty(value) ? StringUtil.randomAlphanumeric(12) : this.findString(value);
	}
	
	//~ getter and setter

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isCover() {
		return cover;
	}

	public void setCover(boolean cover) {
		this.cover = cover;
	}
}
