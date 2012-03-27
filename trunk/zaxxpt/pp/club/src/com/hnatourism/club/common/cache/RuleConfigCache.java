package com.hnatourism.club.common.cache;


import com.hnatourism.club.member.rule.service.IRuleConfigService;
import com.hnatourism.club.member.rule.vo.RuleConfigDetailVo;
import com.hnatourism.framework.cache.abstractcache.AbstractEhCache;
import com.hnatourism.framework.core.daosupport.ConnectionManager;
import com.hnatourism.framework.core.exception.BusinessException;


public class RuleConfigCache extends AbstractEhCache{
	// service
	private IRuleConfigService ruleConfigService;
	/** 
	 * @description 【加载缓存】
	 * @see com.hnatourism.framework.cache.abstractcache.IDataCache#loadCache()
	 * @author zhoufeng
	 */
	@Override
	public void loadCache() throws Exception {
		try {
			RuleConfigDetailVo ruleConfigDetailVo = new RuleConfigDetailVo();
			ruleConfigDetailVo = ruleConfigService.findAllRuleConfig();
			
			put("RULE_CONFIG_DETAIL_VO", ruleConfigDetailVo);
		} catch (Exception e) {
			throw new BusinessException("loadCache", e);

		} finally {
			ConnectionManager.freeConnection();
		}
	}
	
	
//	/**
//	 * @description 【根据编码获取值】
//	 * @param airportCode
//	 * @return
//	 * @author zhoufeng
//	 */
//	public static String getValueByCode(String code) {
//		Map<String, String> ruleConfigMap  = (Map<String, String>) CacheDataManager.get("RULE_CONFIG_MAP"); 
//		String value = ruleConfigMap.get(code);
//		return value;
//	}

	public IRuleConfigService getRuleConfigService() {
		return ruleConfigService;
	}
	public void setRuleConfigService(IRuleConfigService ruleConfigService) {
		this.ruleConfigService = ruleConfigService;
	}
	
	
}
