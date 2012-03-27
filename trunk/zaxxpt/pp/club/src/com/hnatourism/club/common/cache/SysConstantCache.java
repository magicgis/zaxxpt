package com.hnatourism.club.common.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.bidimap.DualHashBidiMap;

import com.hnatourism.club.common.dao.ISysConstantDao;
import com.hnatourism.club.common.domain.SysConstant;
import com.hnatourism.framework.cache.CacheDataManager;
import com.hnatourism.framework.cache.abstractcache.AbstractEhCache;
import com.hnatourism.framework.utils.MapUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.web.tag.Item;

@SuppressWarnings("unchecked")
public class SysConstantCache extends AbstractEhCache {
	//常量表查询服务接口
	private ISysConstantDao sysConstantDao = null;
	
	/** 
	 * @description 【加载缓存】
	 * @see com.hnatourism.framework.cache.abstractcache.IDataCache#loadCache()
	 * @author zhangyun
	 */
	@Override
	public void loadCache() throws Exception {
		SysConstant domain = new SysConstant();
		domain.setStatus("1");
		List list = sysConstantDao.findByWhere(domain);
		Map<String, SysConstant> sysConstantMap = new HashMap<String, SysConstant>();
		Map<String, String> constantMap = new DualHashBidiMap();
		Map<String, SysConstant> constantTypeMap = new HashMap<String, SysConstant>();
		for (Object obj : list) {
			SysConstant sysConstant = (SysConstant) obj;
			List tmp = (List) get(sysConstant.getConTyp());
			if (tmp == null) {
				tmp = new ArrayList();
			}
			Item item = new Item();
			item.setName(sysConstant.getConNam());
			item.setValue(sysConstant.getConVal());
			tmp.add(item);
			put(sysConstant.getConTyp(), tmp);
			if(sysConstant.getCode() != null){
				sysConstantMap.put(sysConstant.getCode(), sysConstant);
				constantMap.put(sysConstant.getCode(), sysConstant.getConVal());
				constantTypeMap.put(MapUtils.getKey(sysConstant, new String[]{"conTyp","code"}), sysConstant);
			}
		}
		put("SYS_CONSTANT_MAP", sysConstantMap);
		put("CONSTANT_MAP", constantMap);
		put("SYS_TYPE_CONSTANT_MAP", constantTypeMap);
	}
	/**
	 * 根据类型获取常量名称和值
	 * @param type
	 * @return
	 */
	public static List getConstant(String type) {
		List<Item> constantVal = null;
		if(StringUtils.isEmpty(type)){
			return constantVal;
		}
		constantVal = (List<Item>) CacheDataManager.get(type);   
		return constantVal;
	}
	/**
	 * 根据常量值找相应的常量名
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @deprecated 过度方法，以后将被getConstantName方法取代，暂时还用这个方法，因为现在数据还不完善
	 * @author zhangyun
	 */
	public static String getName(String type, String value) {
		List<Item> list = (List) CacheDataManager.get(type);
		String constantName = null;
		for (Item item : list) {
			if (item.getValue().equals(value)) {
				constantName = item.getName();
				break;
			}
		}
		return constantName;
	}
	
	/**
	 * @description 【通过code获取常量值】
	 * @param code
	 * @return
	 * @author zhangyun
	 */
	public static String getConstantVal(String type, String code) {
		String constantVal = null;
		if(StringUtils.isEmpty(type)||StringUtils.isEmpty(code)){
			return constantVal;
		}
		Map<String,SysConstant> map = (Map<String,SysConstant>) CacheDataManager.get("SYS_TYPE_CONSTANT_MAP");   
		SysConstant sysConstant = (SysConstant)map.get(type+"&"+code);
		if(sysConstant == null){
			return constantVal;
		}
		return sysConstant.getConVal();
	}
	/**
	 * @description 【通过code获取常量值】
	 * @param code
	 * @return
	 * @author zhangyun
	 */
	public static String getConstantVal(String code) {
		String constantVal = null;
		if(StringUtils.isEmpty(code)){
			return constantVal;
		}
		Map<String,SysConstant> map = (Map<String,SysConstant>) CacheDataManager.get("SYS_CONSTANT_MAP");   
		SysConstant sysConstant = (SysConstant)map.get(code);
		if(sysConstant == null){
			return constantVal;
		}
		return sysConstant.getConVal();
	}
	
	/**
	 * @description 【通过code获取常量名】
	 * @param code
	 * @return
	 * @author zhangyun
	 */
	public static String getConstantName(String code) {
		String constantName = null;
		if(StringUtils.isEmpty(code)){
			return constantName;
		}
		Map<String,SysConstant> map = (Map<String,SysConstant>) CacheDataManager.get("SYS_CONSTANT_MAP");   
		SysConstant sysConstant = (SysConstant)map.get(code);
		if(sysConstant != null && StringUtils.isNotEmpty(sysConstant.getConNam())){
			constantName = sysConstant.getConNam();
		}
		return constantName;
	}
	/**
	 * @description 【通过常量值获取常量名】
	 * @param val
	 * @return
	 * @author zhangyun
	 */
	public static String getConstantNameByVal(String val) {
		DualHashBidiMap map = (DualHashBidiMap) CacheDataManager.get("CONSTANT_MAP");  
		String constantCode = (String)map.getKey(val);
		return getConstantName(constantCode);
	}
	public ISysConstantDao getSysConstantDao() {
		return sysConstantDao;
	}
	public void setSysConstantDao(ISysConstantDao sysConstantDao) {
		this.sysConstantDao = sysConstantDao;
	}
	
	

}
