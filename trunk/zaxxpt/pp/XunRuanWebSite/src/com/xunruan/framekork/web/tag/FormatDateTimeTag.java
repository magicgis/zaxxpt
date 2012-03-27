package com.xunruan.framekork.web.tag;

/**
 * 
 */

/**
 * 格式化时间  格式为 yyyy-MM-dd HH:mm:ss
 * 
 * @author wenz
 * @verision 1.0
 * 2012-02-13
 */
public class FormatDateTimeTag extends FormatDateTag {

	protected String getPattern() {
		return  "yyyy-MM-dd HH:mm:ss";
	}
}
