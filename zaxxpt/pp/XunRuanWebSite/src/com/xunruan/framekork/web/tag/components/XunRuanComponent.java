package com.xunruan.framekork.web.tag.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;
import org.apache.struts2.components.template.Template;

import com.opensymphony.xwork2.util.ValueStack;

/***
 *  @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public abstract class XunRuanComponent extends UIBean {
	public static final String CLASS_SUFFIX = "Component";
	protected String defaultTemplate;
	public XunRuanComponent(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
        this.defaultTemplate = populateDefaultTemplate(this.getClass());
    }
	
    @SuppressWarnings("unchecked")
	protected void evaluateExtraParams() {
//    	super.evaluateExtraParams();
//    	if (RequestContext.get().getSession() != null)
//    		this.addParameter("skin", RequestContext.get().getSession().get("skin"));
//    	// UIBean中默认根据name或value属性到值栈中获取nameValue的值，若UIBean中取不到值，则到parameters中取值
//        if (StringUtil.isEmpty(this.parameters.get("nameValue")) && this.name != null && evaluateNameValue()) {
//            final Class valueClazz = getValueClassType();
//            Object value = RequestContext.get().getParameters().get(this.name);
//            if (valueClazz != null && value != null) {
//            	value = DataTypeUtil.convert(value, valueClazz);
//            } 
//            addParameter("nameValue", value);
//        }
    }
	
	
	protected static String populateDefaultTemplate(Class<?> clazz) {
		String ret = clazz.getSimpleName();
		if (ret.endsWith(CLASS_SUFFIX)) {
			return ret.substring(0, ret.length() - CLASS_SUFFIX.length()).toLowerCase();
		}
		return null;
	}

    @Override protected Template buildTemplateName(String myTemplate, String myDefaultTemplate) {
        String template = myDefaultTemplate;

        if (myTemplate != null) {
            template = findString(myTemplate);
        }

        String componentDir = this.getClass().getPackage().getName().replace('.', '/');
		String templateDir, theme;
		if (componentDir.lastIndexOf("/") >= 0) {
			templateDir = componentDir.substring(0, componentDir.lastIndexOf("/"));
			theme = componentDir.substring(componentDir.lastIndexOf("/") + 1, componentDir.length());
		}
		else {
			templateDir = componentDir;
			theme = "";
		}

        return new Template(templateDir, theme, template);

    }

	public String getDefaultTemplateDir() {
		return super.getTemplateDir();
	}
	
	/**
	 * freemarker模板名,必须
	 */
	protected String getDefaultTemplate() {
		return this.defaultTemplate;
	}
    
    public Object findValueInObject(Object root, String expr) {
    	this.stack.push(root);
    	try {
    		return this.findValue(expr);
    	}
    	finally {
    		this.stack.pop();
    	}
    }
    
    public Object findStringInObject(Object root, String expr) {
    	this.stack.push(root);
    	try {
    		return this.findString(expr);
    	}
    	finally {
    		this.stack.pop();
    	}
    }
    
    public String getParameter(String name) {
    	return (String) this.getParameters().get(name);
    }
}

