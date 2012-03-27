package com.xunruan.framekork.web.tag.components.enumer;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.util.ContainUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.util.ValueStack;
import com.xunruan.framekork.util.ArrayUtil;
import com.xunruan.framekork.util.StringUtil;
import com.xunruan.framekork.web.tag.components.XunRuanComponent;
import com.xunruan.site.domain.Constant;

/**
 * 统一的枚举值显示生成组件。支持枚举值的select/checkbox/radio/span/text/combo等的显示代码生成。
 * 枚举值的获取支持框架统一的枚举提供者机制。
 * 
  *  @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public class EnumerComponent extends XunRuanComponent {
//	@Autowired public EnumerService enumerService;
	/**
	 * 指定枚举值类型：
	 * 请参考ebank.tld文件
	 * 
	 * 这里还支持扩展机制，实现了EnumerProvider接口的类可以提供更多的enumer类型
	 */
	private String type; 
	/**
	 * 指定枚举值的名称，对不同的类型，此属性的含义不同：
	 * 请参考ebank.tld文件
	 */
	private String items;
	private String params;
	// TODO: pagable
	private String pagable;
	// 如果include和exclude同时指定值，则只满足include
	private String exclude;	
	private String include;
	private String appendix;
	
	/**
	 * 这两个属性用于定制显示的数据格式，若提供则使用这里给预的表达式进行求值。
	 * 否则使用配置文件中配置的enumer.diaplay.typexxxx进行求值。
	 * 仅用于领域对象类型的枚举。
	 */
	private String exprname;
	private String exprvalue;

	private String output;
	private String defaultIndex;
	private String autoEvent;
	private String grid; // 是否使用grid布局
	private String split; // for text
	private String nullPrompt; // for select，radio
	private String nullValue; // for select，radio
	private String checkAll; // for checkbox
	/**
	 * 用于指定传递到客户端的其它信息，可指定领域对象的任意属性。
	 * 格式为: voucherName=name,voucherType=type,acctKind,...
	 * 只有当枚举类型为DomainObjectEnumer时，此选项才起作用。此时等号
	 * 左边为生成到客户端的名称，等号右边为以enumer.getBean()
	 * 为根对象的OGNL表达式，表达式可省略，此时表达式与名称相同。
	 * 目前仅支持在select的option中传递信息，同时会生成相应的隐藏字段
	 */
	private String extraInfo; 
	private String escape;
	
	private String var;

	public EnumerComponent(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}
	
    @SuppressWarnings("unchecked")
	protected void evaluateExtraParams() {
    	super.evaluateExtraParams();

        if (StringUtil.isNotEmpty(type)) {
            addParameter("type", findString(type));
        }
        if (StringUtil.isNotEmpty(items)) {
            addParameter("items", findString(items));
        }
        if (StringUtil.isNotEmpty(pagable)) {
            addParameter("pagable", findValue(pagable, Boolean.class));
        }
        if (StringUtil.isNotEmpty(exclude)) {
            addParameter("exclude", findString(exclude));
        }
        if (StringUtil.isNotEmpty(include)) {
            addParameter("include", findString(include));
        }
        if (StringUtil.isNotEmpty(appendix)) {
            addParameter("appendix", findValue(appendix, Map.class));
        }
        if (StringUtil.isNotEmpty(output)) {
            addParameter("output", findString(output));
        }
        if (StringUtil.isNotEmpty(var)) {
            addParameter("var", findString(var));
        }
        
        if (StringUtil.isNotEmpty(autoEvent)) {
            addParameter("autoEvent", findValue(autoEvent, Boolean.class));
        }
        if (StringUtil.isNotEmpty(grid)) {
            addParameter("grid", findValue(grid, Integer.class));
        }
        if (StringUtil.isNotEmpty(split)) {
            addParameter("split", findString(split));
        }
        if (StringUtil.isNotEmpty(nullPrompt)) {
            addParameter("nullPrompt", findString(nullPrompt));
        }
        if (StringUtil.isNotEmpty(nullValue)) {
            addParameter("nullValue", findString(nullValue));
        }
        if (StringUtil.isNotEmpty(checkAll)) {
            addParameter("checkAll", findValue(checkAll, Boolean.class));
        }
        if (StringUtil.isNotEmpty(extraInfo)) {
            addParameter("extraInfo", findString(extraInfo));
        }
        if (StringUtil.isNotEmpty(escape)) {
            addParameter("escape", findValue(escape, Boolean.class));
        }
        if (this.parameters.get("escape") == null) this.addParameter("escape", true);

        List<Constant> list = getList();
    	parameters.put("list", list);
    	parameters.put("listSize", list.size());
    	parameters.put("listKey", "value");
    	parameters.put("listValue", "longname");

        if (StringUtil.isNotEmpty(defaultIndex) && StringUtil.isEmpty(this.getParameters().get("nameValue"))) {
            Integer index = (Integer) findValue(defaultIndex, Integer.class);
            if (index != null) {
            	String nameValue = "";
            	List<Object> value = new ArrayList<Object>();
            	for (int i = 0; i < list.size(); i++) {
            		Constant e = list.get(i);
            		if (index == i) {
            			this.addParameter("nameValue", ""+e.getValue());
            			this.addParameter("value", e.getValue());
            			break;
            		}
        			nameValue += e.getValue() + ",";
        			value.add(e.getValue());
            	}
            	if (index < 0) {
        			this.addParameter("nameValue", nameValue);
        			this.addParameter("value", value);
            	}
            }
        }
        // 
        if (StringUtil.isNotEmpty(this.getParameters().get("nameValue")) && StringUtil.isNotEmpty(this.getParameters().get("var"))) {
        	String var = this.getParameter("var") + "Selected";
        	List<Constant> selected = new ArrayList<Constant>();
        	for (Constant en : list) {
        		if (this.isSelected("")) {
        			selected.add(en);
        		}
        	}
            stack.getContext().put(var, selected);
            stack.setValue("#attr['" + var + "']", selected, false);
        }
        
        String extraInfo = (String) this.getParameters().get("extraInfo");
		if (StringUtil.isNotEmpty(extraInfo)) {
	    	Map<String, String> extraInfoMap = new LinkedHashMap<String, String>();
	    	Map<String, String> extraInfoValueMap = new LinkedHashMap<String, String>();
			List<String> infoes = StringUtil.split(extraInfo);
			String script = "";
			for (String info : infoes) {
				String name = info, expr = info;
				int idx = info.indexOf("=");
				if (idx == 0) throw new IllegalArgumentException("Extrainfo's format error: '" + extraInfo + "'.");
				else if (idx > 0) {
					name = info.substring(0, idx);
					expr = info.substring(idx+1);
				}
				
				List<Object> vals = new ArrayList<Object>();
	    		for (Constant enumer : list) {
	    			if (this.isSelected("")) {
	    				Object val = this.findValueInObject(enumer, expr);
	    				if (StringUtil.isNotEmpty(val)) vals.add(val);
	    			}
	    		}
				extraInfoMap.put(name, expr);
	    		extraInfoValueMap.put(name, vals.isEmpty() ? "" : ArrayUtil.join(vals));
				script += "$$(\""+name+"\", this.options[this.selectedIndex].getAttribute(\""+name+"\"));";
			}
			this.addParameter("extraInfoMap", extraInfoMap);
			this.addParameter("extraInfoValueMap", extraInfoValueMap);
			this.addParameter("extraInfoScript", script);
		}
    }
    
    // TODO：需要优化, 对于span, text等类型不需要获取list
    @SuppressWarnings("unchecked")
	private List<Constant> getList() {
    	List<Constant> ret=null;
//    	String type = this.getParameter("type");
//    	String items = this.getParameter("items");
//
//		Params params = new Params().addAll(this.getParameters());
//		if(StringUtil.isNotEmpty(this.params)) {
//			Map extraParams = (Map)super.findValue(this.params, Map.class);
//			if (extraParams != null) params.addAll(extraParams);
//		}
//		
//    	if ("valuestack".equals(type)) {
//    		List<?> list = (List<?>)this.findValue(items, List.class);
//    		ret = this.enumerService.getEnumers(list, this.exprname, this.exprvalue);
//    	}
//    	else {
//    		ret = this.enumerService.getEnumers(type, items, params, this.exprname, this.exprvalue);
//    	}
//
//    	if (StringUtil.isNotEmpty(this.getParameter("include")) || StringUtil.isNotEmpty(this.getParameter("exclude"))) {
//        	List<Enumer> list = new ArrayList<Enumer>();
//        	for (Enumer e : ret) {
//        		if (acceptable(e)) list.add(e);
//        	}
//        	ret = list;
//    	}
//
//		Map<?, ?> appendix = (Map<?, ?>)this.getParameters().get("appendix");
//    	if (appendix != null) {
//    		List<Enumer> list = new ArrayList<Enumer>();
//    		list.addAll(ret);
//    		list.addAll(EnumerUtil.map2EnumerList(appendix));
//    		ret = list;
//    	}
//    	
//    	String var = this.getParameter("var");
//    	if (StringUtil.isNotEmpty(var)) {
//            stack.getContext().put(var, ret);
//            stack.setValue("#attr['" + var + "']", ret, false);
//    	}
    	
    	return ret;
    }
    
    private boolean acceptable(Constant e) {
    	if (StringUtil.isNotEmpty(this.getParameter("include"))) {
    		return ArrayUtil.in(this.getParameter("include"), e.getValue());
    	}
    	else if (StringUtil.isNotEmpty(this.getParameter("exclude"))) {
    		return !ArrayUtil.in(this.getParameter("exclude"), e.getValue());
    	}
		return true;
	}

	public boolean isSelected(String key) {
    	return this.contains(this.getParameters().get("nameValue"), key);
    }

    public boolean contains(Object obj1, Object obj2) {
        return ContainUtil.contains(ArrayUtil.asArray(obj1), obj2);
    }
	
	//~ getter and setter

	public void setAutoEvent(String autoEvent) {
		this.autoEvent = autoEvent;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	public void setSplit(String split) {
		this.split = split;
	}

	public void setNullPrompt(String nullPrompt) {
		this.nullPrompt = nullPrompt;
	}

	public void setDefaultIndex(String defaultIndex) {
		this.defaultIndex = defaultIndex;
	}

	public void setCheckAll(String checkAll) {
		this.checkAll = checkAll;
	}

	public void setPagable(String pagable) {
		this.pagable = pagable;
	}

	public void setExclude(String exclude) {
		this.exclude = exclude;
	}

	public void setInclude(String include) {
		this.include = include;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public void setEscape(String escape) {
		this.escape = escape;
	}

	public void setExprname(String exprname) {
		this.exprname = exprname;
	}

	public void setExprvalue(String exprvalue) {
		this.exprvalue = exprvalue;
	}

	public void setNullValue(String nullValue) {
		this.nullValue = nullValue;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}

}
