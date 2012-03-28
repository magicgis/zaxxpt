package com.sunshine.framework.tag.component;

import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.components.ContextBean;
import org.apache.struts2.util.MakeIterator;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.jsp.IteratorStatus;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.sunshine.framework.service.Popedom;
import com.sunshine.framework.service.impl.FunctionPopedomImpl;

/***
 * 
 *@author wenz
 *@Date 2012-3-27上午10:21:57
 *
 *@version 1.0
 *@see com.sunshine.framework.tag.component.FunctionIterator
 ***/
@StrutsTag(name="sPopeDomiIerator", tldTagClass="com.sunshine.framework.tag.SourcePopedomIteratorTag", description="Iterate over a iterable value")
public class FunctionIterator extends ContextBean{
	 private static final Logger LOG = LoggerFactory.getLogger(FunctionIterator.class);

	    protected Iterator iterator;
	    /***  IteratorStatus 迭代元素的索引
	     * int getCount()返回当前迭代了几个元素   
		 * int getIndex()返回当前元素索引   
		 * boolean isEven()当然的索引是否偶数   
		 * boolean isFirst()当前是否第一个元素   
		 * boolean isLast()   
		 * boolean isOdd()当前元素索引是否奇数 
	     */
	    protected IteratorStatus status;
	    protected Object oldStatus;
	    protected IteratorStatus.StatusState statusState;
	    protected String statusAttr;
	    //资源父级ID
	    protected String value;
	    protected String beginStr;
	    protected Integer begin;
	    protected String endStr;
	    protected Integer end;
	    protected String stepStr;
	    protected Integer step;
	    protected String varList;
	    protected boolean filterSource=true;
	    protected Popedom popedom;
	    
	    public FunctionIterator(ValueStack stack) {
	        super(stack);
	    }
	    
	    public boolean start(Writer writer) {
	        //Create an iterator status if the status attribute was set.
	        if (statusAttr != null) {
	            statusState = new IteratorStatus.StatusState();
	            status = new IteratorStatus(statusState);
	        }

	        if (beginStr != null)
	            begin = (Integer) findValue(beginStr,  Integer.class);

	        if (endStr != null)
	            end = (Integer) findValue(endStr,  Integer.class);

	        if (stepStr != null)
	            step = (Integer) findValue(stepStr,  Integer.class);

	        ValueStack stack = getStack();

	        //获取资源信息
//	        Object iteratorTarget = findValue(value);
	        popedom=new FunctionPopedomImpl();
	        Object iteratorTarget=null;
	        if(filterSource)
	        	 iteratorTarget= popedom.filterSource();
	        else
	        	iteratorTarget= popedom.getPopedom();
	        iterator = MakeIterator.convert(iteratorTarget);
	        

	        if (begin != null) {
	            //default step to 1
	            if (step == null)
	                step = 1;

	            if (iterator == null) {
	                //classic for loop from 'begin' to 'end'
	                iterator = new CounterIterator(begin, end, step, null);
	            } else if (iterator != null) {
	                //only arrays and lists are supported
	                if (iteratorTarget.getClass().isArray()) {
	                    Object[] values = (Object[]) iteratorTarget;
	                    if (end == null)
	                        end = step > 0 ? values.length - 1 : 0;
	                    iterator = new CounterIterator(begin, end, step, Arrays.asList(values));
	                } else if (iteratorTarget instanceof List) {
	                    List values = (List) iteratorTarget;
	                    if (end == null)
	                        end = step > 0 ? values.size() - 1 : 0;
	                    iterator = new CounterIterator(begin, end, step, values);
	                } else {
	                    //so the iterator is not based on an array or a list
	                    LOG.error("Incorrect use of the iterator tag. When 'begin' is set, 'value' must be" +
	                            " an Array or a List, or not set at all. 'begin', 'end' and 'step' will be ignored");
	                }
	            }
	        }

	        stack.getContext().put(varList, iterator);
	        // get the first
	        if ((iterator != null) && iterator.hasNext()) {
	            Object currentValue = iterator.next();
	            stack.push(currentValue);

	            String var = getVar();

	            if ((var != null) && (currentValue != null)) {
	                //pageContext.setAttribute(id, currentValue);
	                //pageContext.setAttribute(id, currentValue, PageContext.REQUEST_SCOPE);
	                putInContext(currentValue);
	            }

	            // Status object
	            if (statusAttr != null) {
	                statusState.setLast(!iterator.hasNext());
	                oldStatus = stack.getContext().get(statusAttr);
	                stack.getContext().put(statusAttr, status);
	            }

	            return true;
	        } else {
	            super.end(writer, "");
	            return false;
	        }
	    }

	    public boolean end(Writer writer, String body) {
	        ValueStack stack = getStack();
	        if (iterator != null) {
	            stack.pop();
	        }

	        if (iterator!=null && iterator.hasNext()) {
	            Object currentValue = iterator.next();
	            stack.push(currentValue);

	            putInContext(currentValue);

	            // Update status
	            if (status != null) {
	                statusState.next(); // Increase counter
	                statusState.setLast(!iterator.hasNext());
	            }

	            return true;
	        } else {
	            // Reset status object in case someone else uses the same name in another iterator tag instance
	            if (status != null) {
	                if (oldStatus == null) {
	                    stack.getContext().put(statusAttr, null);
	                } else {
	                    stack.getContext().put(statusAttr, oldStatus);
	                }
	            }
	            super.end(writer, "");
	            return false;
	        }
	    }

	    class CounterIterator implements Iterator<Object> {
	        private int step;
	        private int end;
	        private int currentIndex;
	        private List<Object> values;

	        CounterIterator(Integer begin, Integer end, Integer step, List<Object> values) {
	            this.end = end;
	            if (step != null)
	                this.step = step;
	            this.currentIndex = begin - this.step;
	            this.values = values;
	        }

	        public boolean hasNext() {
	            int next = peekNextIndex();
	            return step > 0 ? next <= end : next >= end;
	        }

	        public Object next() {
	            if (hasNext()) {
	                int nextIndex = peekNextIndex();
	                currentIndex += step;
	                return value != null ? values.get(nextIndex) : nextIndex;
	            } else {
	                throw new IndexOutOfBoundsException("Index " + ( currentIndex + step) + " must be less than or equal to " + end);
	            }
	        }

	        private int peekNextIndex() {
	           return currentIndex + step;
	        }

	        public void remove() {
	            throw new UnsupportedOperationException("Values cannot be removed from this iterator");
	        }
	    }

	    @StrutsTagAttribute(description="If specified, an instanceof IteratorStatus will be pushed into stack upon each iteration",
	        type="Boolean", defaultValue="false")
	    public void setStatus(String status) {
	        this.statusAttr = status;
	    }

	    @StrutsTagAttribute(description="the iteratable source to iterate over, else an the object itself will be put into a newly created List")
	    public void setValue(String value) {
	        this.value = value;
	    }

	    @StrutsTagAttribute(description="if specified the iteration will start on that index", type="Integer", defaultValue="0")
	    public void setBegin(String begin) {
	        this.beginStr = begin;
	    }

	    @StrutsTagAttribute(description="if specified the iteration will end on that index(inclusive)", type="Integer",
	            defaultValue="Size of the 'values' List or array, or 0 if 'step' is negative")
	    public void setEnd(String end) {
	        this.endStr = end;
	    }

	    @StrutsTagAttribute(description="if specified the iteration index will be increased by this value on each iteration. It can be a negative " +
	            "value, in which case 'begin' must be greater than 'end'", type="Integer", defaultValue="1")
	    public void setStep(String step) {
	        this.stepStr = step;
	    }

	    @StrutsTagAttribute(description="保存当前迭代标签值", type="String")
		public void setVarList(String varList) {
			this.varList = varList;
		}
	    
	    @StrutsTagAttribute(description="是否过滤当前的资源权限", type="String")
	    public void setFilterSource(boolean filterSource) {
			this.filterSource = filterSource;
		}
	    
	    
}
