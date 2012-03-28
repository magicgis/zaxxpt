package com.sunshine.framework.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ContextBeanTag;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunshine.framework.tag.component.FunctionIterator;

/***
 * 
 *@author wenz
 *@Date 2012-3-27ÉÏÎç10:21:57
 *@version 1.0
 *@see com.sunshine.framework.tag.FunctionIteratorTag
 ***/
public class FunctionIteratorTag extends ContextBeanTag{
	 private static final long serialVersionUID = -1827978135193581901L;

	    protected String statusAttr;
	    protected String value;
	    protected String begin;
	    protected String end;
	    protected String step;
	    protected String varList;
	    protected boolean filterSource=true;

	    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
	        return new FunctionIterator(stack);
	    }

	    protected void populateParams() {
	        super.populateParams();

	        FunctionIterator tag = (FunctionIterator) getComponent();
	        tag.setStatus(statusAttr);
	        tag.setValue(value);
	        tag.setBegin(begin);
	        tag.setEnd(end);
	        tag.setStep(step);
	    }

	    public void setStatus(String status) {
	        this.statusAttr = status;
	    }

	    public void setValue(String value) {
	        this.value = value;
	    }

	    public void setBegin(String begin) {
	        this.begin = begin;
	    }

	    public void setEnd(String end) {
	        this.end = end;
	    }

	    public void setStep(String step) {
	        this.step = step;
	    }

	    public int doEndTag() throws JspException {
	        component = null;
	        return EVAL_PAGE;
	    }

	    public void setVarList(String varList) {
			this.varList = varList;
		}
	    
		public void setFilterSource(boolean filterSource) {
			this.filterSource = filterSource;
		}


		public int doAfterBody() throws JspException {
	        boolean again = component.end(pageContext.getOut(), getBody());

	        if (again) {
	            return EVAL_BODY_AGAIN;
	        } else {
	            if (bodyContent != null) {
	                try {
	                    bodyContent.writeOut(bodyContent.getEnclosingWriter());
	                } catch (Exception e) {
	                    throw new JspException(e.getMessage());
	                }
	            }
	            return SKIP_BODY;
	        }
	    }
}
