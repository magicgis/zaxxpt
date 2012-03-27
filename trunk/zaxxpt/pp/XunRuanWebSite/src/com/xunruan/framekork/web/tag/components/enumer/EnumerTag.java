package com.xunruan.framekork.web.tag.components.enumer;


import com.xunruan.framekork.web.tag.components.XunRuanUITag;

/***
 *  @author wenz
 * @verision 1.0
 * 2012-02-13
 *
 */
public class EnumerTag extends XunRuanUITag {
	private String type;
	private String items;
	private String params;
	private String pagable;
	private String exclude;	
	private String include;
	private String appendix;

	private String exprname;
	private String exprvalue;
	
	private String autoEvent;
	private String output;
	private String grid;
	private String split;
	private String nullPrompt;
	private String nullValue;
	private String defaultIndex;
	private String checkAll;
	private String extraInfo;
	private String escape;
	
	private String var;
	
	protected void populateParams() {
		super.populateParams();
		EnumerComponent c = (EnumerComponent)component;
		c.setType(type);
		c.setItems(items);
		c.setParams(params);
		c.setPagable(pagable);
		c.setExclude(exclude);	
		c.setInclude(include);
		c.setExprname(exprname);
		c.setAppendix(appendix);
		c.setExprvalue(exprvalue);
		c.setAutoEvent(autoEvent);
		c.setOutput(output);
		c.setGrid(grid);
		c.setSplit(split);
		c.setNullPrompt(nullPrompt);
		c.setNullValue(nullValue);
		c.setDefaultIndex(defaultIndex);
		c.setCheckAll(checkAll);
		c.setExtraInfo(extraInfo);
		c.setEscape(escape);
		c.setVar(var);
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getItems() {
		return items;
	}

	public String getPagable() {
		return pagable;
	}

	public String getExclude() {
		return exclude;
	}

	public String getInclude() {
		return include;
	}

	public String getAutoEvent() {
		return autoEvent;
	}

	public String getGrid() {
		return grid;
	}

	public String getSplit() {
		return split;
	}

	public String getNullPrompt() {
		return nullPrompt;
	}

	public String getDefaultIndex() {
		return defaultIndex;
	}

	public String getCheckAll() {
		return checkAll;
	}

	public void setItems(String items) {
		this.items = items;
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

	public void setAutoEvent(String autoEvent) {
		this.autoEvent = autoEvent;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getExprname() {
		return exprname;
	}

	public String getExprvalue() {
		return exprvalue;
	}

	public void setExprname(String exprname) {
		this.exprname = exprname;
	}

	public void setExprvalue(String exprvalue) {
		this.exprvalue = exprvalue;
	}

	public String getEscape() {
		return escape;
	}

	public void setEscape(String escape) {
		this.escape = escape;
	}

	public String getNullValue() {
		return nullValue;
	}

	public void setNullValue(String nullValue) {
		this.nullValue = nullValue;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getAppendix() {
		return appendix;
	}

	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}
}
