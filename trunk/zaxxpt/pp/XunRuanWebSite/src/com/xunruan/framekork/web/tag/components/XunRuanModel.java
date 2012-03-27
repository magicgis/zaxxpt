package com.xunruan.framekork.web.tag.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.freemarker.tags.TagModel;

import com.opensymphony.xwork2.util.ValueStack;
/***
 *  @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public class XunRuanModel extends TagModel {

    public XunRuanModel(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        super(stack, req, res);
    }
    
    protected Component getBean() {
		return ComponentUtil.getBean(this.getClass(), "Model", stack, req, res);
    }

}
