package com.xunruan.framekork.web.tag;

/**
 */

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.xunruan.framekork.util.StringUtil;


/**
 * 实现用户访问控制的标签
 * @author wwenz
 * 2012-02-13
 *
 */
public class AccessTag extends XunRuanTagSupport {
	private static final Logger log = LogManager.getLogger(AccessTag.class);

	private String transName;
	private boolean isMenu = true;
	private boolean not = false;

	private String evaluatedTransName;
	//是否有子标签，默认为没有
	private boolean hasChild = false;
	//有子标签时，若一个子标签能被访问，则父标签也认为可以访问，
	//本属性由子标签设置（子标签能访问时设置该为真，否则不设置）
	private boolean childAccessed = false;
	
	//~
	
	public void release() {
		super.release();
		transName = null;
		evaluatedTransName = null;
		hasChild = false;
		childAccessed = false;
		not = false;
		isMenu = true;
	}
	
	public int doStartTag() throws JspException {
		//在tomcat中属性可能不能被正确初始化，下面的语句用于清除状态
		evaluatedTransName = null;
		hasChild = false;
		childAccessed = false;
		return super.doStartTag();
	}

    public int doEndTag() throws JspException {
		AccessTag parent = getParentTag();
		if (parent != null) parent.hasChild = true;
		
		boolean access = canAccess();
		if (!access && log.isDebugEnabled()) log.debug("cannot access:"+this.getTransName());
		access = not ? !access : access;
		
		if (access) {
			if (parent != null) parent.childAccessed = true;
			writeBody();
		}
		
		return super.doEndTag();
    }
    
    private AccessTag getParentTag() {
    	Tag tag = getParent();
    	while (tag != null && !(tag instanceof AccessTag)) {
    		tag = tag.getParent();
    	}
    	if (tag instanceof AccessTag) 
    		return (AccessTag)tag;
    	return null;
    }
    
    private boolean canAccess() {
    	//如果有子标签，则如果子标签都不能被访问，则本标签也不能被访问
    	if (hasChild && !childAccessed) return false;
    	//默认情况下，可以被访问
    	return true;
    }
    
    private void writeBody() throws JspException {
    }
    
    
    
    
	
	//~ getter and setter

	public String getTransName() {
		if (evaluatedTransName == null && !StringUtil.isEmpty(transName)) {
			this.evaluatedTransName = this.findString(this.transName);
		}
		return evaluatedTransName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public boolean isNot() {
		return not;
	}

	public void setNot(boolean not) {
		this.not = not;
	}

	public boolean isMenu() {
		return isMenu;
	}

	public void setMenu(boolean menu) {
		this.isMenu = menu;
	}
}
