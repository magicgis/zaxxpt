package com.xunruan.framekork.web.tag.components.enumer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;
import com.xunruan.framekork.web.tag.components.XunRuanModel;
/***
 *  @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public class EnumerModel extends XunRuanModel {

    public EnumerModel(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        super(stack, req, res);
    }
}
