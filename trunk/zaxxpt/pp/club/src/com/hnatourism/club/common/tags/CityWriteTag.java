package com.hnatourism.club.common.tags;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
	*城市标签 vo wuyuhu
	*2011-8-23
	*/	
import com.hnatourism.club.common.cache.FlightCache;
import com.hnatourism.club.flight.web.vo.FlightCacheVo;
import com.hnatourism.framework.utils.ListUtils;

public class CityWriteTag extends TagSupport {

	private static final long serialVersionUID = -4562658229993463433L;
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private String key = null;
	
	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {
		StringBuffer buff = new StringBuffer("");
		List listAllCities = getDicts();
		if(!ListUtils.isEmpty(listAllCities)){
			for(int i=0;i<listAllCities.size();i++){
				FlightCacheVo flightCacheVo=(FlightCacheVo)listAllCities.get(i);
				if(key.equals(flightCacheVo.getCode())){
					buff.append(flightCacheVo.getName());
					break;
				}
			}
		}
		try {
			pageContext.getOut().write(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	private List getDicts() {
//		IDataCache dataCache = LoadDataManager.get("CityareaCache");
		List<FlightCacheVo>  flightCacheVoList=FlightCache.cityAllList();
		return flightCacheVoList;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
}
