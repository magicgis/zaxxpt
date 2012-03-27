package com.hnatourism.framework.web.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;

import com.hnatourism.framework.cache.CacheDataManager;

/**
 * 扩展write标签，字符串按分隔符截取
 * 
 */
public class WriteTags extends com.hnatourism.framework.web.tag.WriteTag {

	/**
	 * 字符串分隔符
	 */
	private String regexValue = null;

	/**
	 * 显示分隔符 默认为空格
	 */
	private String regexShow = "&nbsp;";

	/**
	 * 标签实现
	 */
	public int doStartTag() throws JspException {
		// 拼接字符串
		StringBuffer results = new StringBuffer("");
		if ((this.getValue() != null) && (!(this.getValue().trim().equals("")))) {
			// 判断是否需要分隔
			String[] valueArr = null;
			if (regexValue != null && !"".equals(regexValue)) {
				valueArr = this.getValue().split(regexValue);
			} else {
				valueArr = new String[] { this.getValue() };
			}
			// 分隔后处理处理
			if (valueArr.length > 0) {
				String condspVal = regexShow;
				for (String value : valueArr) {
					condspVal = getSysConDspval(value);
					if (condspVal != null) {
						results.append(regexShow).append(condspVal);
					}
				}
			}
		}
		try {
			this.pageContext.getOut().write(results.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 缓冲常量表中取翻译
	 */
	protected String getSysConDspval(String conVal) {
		if (this.getType() == null) {
			return null;
		}
		List list = (List) CacheDataManager.get(this.getType());
		if ((list != null) && (!(list.isEmpty()))) {
			for (Iterator localIterator = list.iterator(); localIterator
					.hasNext();) {
				Object obj = localIterator.next();
				Item item = (Item) obj;
				if (item.getValue().equals(conVal)) {
					return item.getName();
				}
			}
		}
		return "";
	}

	/**
	 * @return the regexValue
	 */
	public String getRegexValue() {
		return regexValue;
	}

	/**
	 * @param regexValue
	 *            the regexValue to set
	 */
	public void setRegexValue(String regexValue) {
		this.regexValue = regexValue;
	}

	/**
	 * @return the regexShow
	 */
	public String getRegexShow() {
		return regexShow;
	}

	/**
	 * @param regexShow
	 *            the regexShow to set
	 */
	public void setRegexShow(String regexShow) {
		this.regexShow = regexShow;
	}

}