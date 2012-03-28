package com.sunshine.framework.tag.component;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.components.Property;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.sunshine.framework.service.Popedom;
import com.sunshine.framework.service.impl.FieldPopedomImpl;


/***
 * 
 *@author wenz
 *@Date 2012-3-27上午10:21:57
 *@version 1.0
 *@see com.sunshine.framework.tag.component.FieldProperty
 ***/
@StrutsTag(name="fpopedomProperty", tldBodyContent="empty", tldTagClass="com.sunshine.framework.tag.FieldPopedomPropertyTag",
	    description="Print out expression which evaluates against the stack")
public class FieldProperty extends Component {

	 private static final Logger LOG = LoggerFactory.getLogger(FieldProperty.class);

	    public FieldProperty(ValueStack stack) {
	        super(stack);
	    }

	    private Popedom popedom;
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

	    @StrutsTagAttribute(description="The default value to be used if <u>value</u> attribute is null")
	    public void setDefault(String defaultValue) {
	        this.defaultValue = defaultValue;
	    }

	    @StrutsTagAttribute(description="Deprecated. Use 'escapeHtml'. Whether to escape HTML", type="Boolean", defaultValue="true")
	    public void setEscape(boolean escape) {
	        this.escapeHtml = escape;
	    }

	    @StrutsTagAttribute(description="Whether to escape HTML", type="Boolean", defaultValue="true")
	    public void setEscapeHtml(boolean escape) {
	        this.escapeHtml = escape;
	    }

	    @StrutsTagAttribute(description="Whether to escape Javascript", type="Boolean", defaultValue="false")
	    public void setEscapeJavaScript(boolean escapeJavaScript) {
	        this.escapeJavaScript = escapeJavaScript;
	    }

	    @StrutsTagAttribute(description="Value to be displayed", type="Object", defaultValue="&lt;top of stack&gt;")
	    public void setValue(String value) {
	        this.value = value;
	    }

	    public void setDefaultValue(String defaultValue) {
	        this.defaultValue = defaultValue;
	    }

	    @StrutsTagAttribute(description="Whether to escape CSV (useful to escape a value for a column)", type="Boolean", defaultValue="false")
	    public void setEscapeCsv(boolean escapeCsv) {
	        this.escapeCsv = escapeCsv;
	    }

	    @StrutsTagAttribute(description="Whether to escape XML", type="Boolean", defaultValue="false")
	    public void setEscapeXml(boolean escapeXml) {
	        this.escapeXml = escapeXml;
	    }
	    
	    @StrutsTagAttribute(description="字段权限受控时显示的值默认为*****", type="String", defaultValue="*****")
	    public void setDisplayValue(String displayValue) {
			this.displayValue = displayValue;
		}

	    @StrutsTagAttribute(description="字段显示模式read为读取模式（用于查询显示），write为写入模式（用户修改和新增值）", type="String", defaultValue="read")
		public void setDisplayMode(String displayMode) {
			this.displayMode = displayMode;
		}

	    @StrutsTagAttribute(description="字段所属于的数据源", type="String")
		public void setSource(String source) {
			this.source = source;
		}

	    @StrutsTagAttribute(description="字段所属于的表", type="String")
		public void setTable(String table) {
			this.table = table;
		}
	    
	    @StrutsTagAttribute(description="字段", type="String")
		public void setField(String field) {
			this.field=field;
		}
	    
	    @StrutsTagAttribute(description="默认使用对象ID验证如ID为空则使用资源+表+字段", type="String")
		public void setId(String id) {
			this.id = id;
		}

		@SuppressWarnings("unused")
		public boolean start(Writer writer) {
	        boolean result = super.start(writer);
	        try {
	        	popedom=new FieldPopedomImpl();
	        	boolean bol=false;
	        	if(id!=null&&!"".equals(id))
	        		bol=popedom.verifyPopedom(id);
	        	else
	        		bol=popedom.verifyPopedom(source,table,field);
	        	if(!bol){
	        		if(displayMode.equals("write")){
	        			writer.write(displayValue);
	        		}else{
	        			if (value == null) {
	        				value = "top";
	        			}
	        			else {
	        				value = stripExpressionIfAltSyntax(value);
	        			}
	        			// exception: don't call findString(), since we don't want the
	        			//            expression parsed in this one case. it really
	        			//            doesn't make sense, in fact.
	        			Property
	        			String actualValue = (String) getStack().findValue(value, String.class, throwExceptionOnELFailure);
	        			if (actualValue != null) {
	        				writer.write(prepare(actualValue));
	        			} else if (defaultValue != null) {
	        				writer.write(prepare(defaultValue));
	        			}
	        		}
	        	}else{
	        		writer.write(displayValue);
	        	}
				
			} catch (Exception e) {
				if (LOG.isInfoEnabled()) {
					LOG.info("Could not print out value '" + value + "'", e);
				}
			}

	        return result;
	    }

	    private String prepare(String value) {
	    	String result = value;
	        if (escapeHtml) {
	        	result = StringEscapeUtils.escapeHtml(result);
	        }
	        if (escapeJavaScript) {
	        	result = StringEscapeUtils.escapeJavaScript(result);
	        }
	        if (escapeXml) {
	        	result = StringEscapeUtils.escapeXml(result);
	        }
	        if (escapeCsv) {
	            result = StringEscapeUtils.escapeCsv(result);
	        }

	        return result;
	    }
}
