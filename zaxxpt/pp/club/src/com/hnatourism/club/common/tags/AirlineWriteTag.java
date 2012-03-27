package com.hnatourism.club.common.tags;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.lang.StringUtils;

import com.hnatourism.club.common.cache.FlightCache;
import com.hnatourism.framework.cache.CacheDataManager;

/**
 * 机场信息标签
 * 
 * @author 
 * @version
 */
public class AirlineWriteTag extends TagSupport {

	/** 机场三字码 */
	private String key;

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		if(StringUtils.isEmpty(key)){
			return 0;
		}
		StringBuffer buff = new StringBuffer("");
//		String [] cityKey=FlightCache.getAirlineCorp();
//		for(int i=0;i<cityKey.length;i++){
//			if(key.equals(cityKey[i])){
				buff.append(FlightCache.companyName(key));
//				break;
//			}
//		}
		try {
			pageContext.getOut().write(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
