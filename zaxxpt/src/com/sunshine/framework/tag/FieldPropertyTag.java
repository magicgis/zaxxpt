package com.sunshine.framework.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunshine.framework.tag.component.FieldProperty;


/***
 *@author wenz
 *@Date 2012-3-27上午10:21:57
 *@version 1.0
 *@see com.sunshine.framework.tag.FieldPropertyTag
 ***/
public class FieldPropertyTag extends ComponentTagSupport {

	/**
	 * 字段权限验证
	 */
	private static final long serialVersionUID = 5699441986895641L;

		private String defaultValue;
	    private String value;
	    private String displayValue="*****";
	    private String displayMode="read";
	    private String source;
	    private String table;
	    private String field;
	    private String id;
	    private boolean escapeHtml = true;
	    private boolean escapeJavaScript = false;
	    private boolean escapeXml = false;
	    private boolean escapeCsv = false;

	    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
	        return new FieldProperty(stack);
	    }

	    protected void populateParams() {
	        super.populateParams();

	        FieldProperty tag = (FieldProperty) component;
	        tag.setDefault(defaultValue);
	        tag.setValue(value);
	        tag.setDisplayValue(displayValue);
	        tag.setDisplayMode(displayMode);
	        tag.setSource(source);
	        tag.setTable(table);
	        tag.setEscape(escapeHtml);
	        tag.setEscapeJavaScript(escapeJavaScript);
	        tag.setEscapeXml(escapeXml);
	        tag.setEscapeCsv(escapeCsv);
	        tag.setField(field);
	        tag.setId(id);
	    }

	    public void setDefault(String defaultValue) {
	        this.defaultValue = defaultValue;
	    }

	    public void setEscape(boolean escape) {
	        this.escapeHtml = escape;
	    }

	    public void setEscapeHtml(boolean escapeHtml) {
	        this.escapeHtml = escapeHtml;
	    }

	    public void setEscapeJavaScript(boolean escapeJavaScript) {
	        this.escapeJavaScript = escapeJavaScript;
	    }
	    
	    public void setValue(String value) {
	        this.value = value;
	    }

	    public void setDefaultValue(String defaultValue) {
	        this.defaultValue = defaultValue;
	    }

	    public void setEscapeCsv(boolean escapeCsv) {
	        this.escapeCsv = escapeCsv;
	    }

	    public void setEscapeXml(boolean escapeXml) {
	        this.escapeXml = escapeXml;
	    }

		public void setDisplayValue(String displayValue) {
			this.displayValue = displayValue;
		}

		public void setDisplayMode(String displayMode) {
			this.displayMode = displayMode;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public void setTable(String table) {
			this.table = table;
		}

		public void setField(String field) {
			this.field = field;
		}

		public void setId(String id) {
			this.id = id;
		}
	    
	    
}
