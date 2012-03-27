package com.xunruan.site.cache;


import java.util.List;

import javax.annotation.Resource;


import com.xunruan.framekork.cache.abstractcache.AbstractEhCache;
import com.xunruan.framekork.dao.IBaseDao;
import com.xunruan.site.domain.Constant;

/***
 * 
 * @author wez
 * @version
 *
 */
public class ConstantCache extends AbstractEhCache {

	@Resource
	private IBaseDao<Constant> constantDao;
	
	public void loadCache() throws Exception {
		Constant domain = new Constant();
		List<Constant> listConstant=constantDao.find(Constant.class);
		put("CONSTANT_LIST", listConstant);
	}
	/**
	 * 根据代码获取常量名称和值
	 * @param type
	 * @author wenz
	 * @return
	 */
	public static List getValue(String code) {
		return null;
	}
	/**
	 * 根据常量值与代码找相应的名称
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @author wenz
	 */
	public static String getName(String type, String value) {
		return null;
	}
	
	public IBaseDao<Constant> getConstantDao() {
		return constantDao;
	}
	public void setConstantDao(IBaseDao<Constant> constantDao) {
		this.constantDao = constantDao;
	}

	
}
