package com.hnatourism.club.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.member.rule.vo.RuleConfigVo;

/**
 * 得到政企的分润数据
 * @author hanlengyu
 *
 */
public class RuleConfigProfit
{
	private static String subCorpPoint;//分公司分点
	private static String platformPoint;//平台分点
	private static String profitpoint;//平台和分公司分点    ALL为全分
	private static String memberFlowpoint;//会员享受最低点    ALL为全分
	
	
	/**
	 * 得到政企管家分润的4个数据点
	 * @param 产品类型
	 * @param 分润规则集合
	 * @param 企业ID
	 * @return
	 */
	public static Map<String, String> setRuleParam(String prodType, List<RuleConfigVo> ruleConfigList, String crop)
	{
		Map<String, String> result=new HashMap<String, String>();
		
		Iterator<RuleConfigVo> iterator_rc=ruleConfigList.iterator();
		while(iterator_rc.hasNext())
		{
			RuleConfigVo rule=iterator_rc.next();
			
			if(rule.getCode().equalsIgnoreCase("I_GF_PROFIT_RATE_"+crop))
			{
				String[] rate=rule.getValue().split(":");
				subCorpPoint=rate[0];
				platformPoint=rate[1];
			}
			else if(rule.getCode().equalsIgnoreCase("I_GF_PROFIT_POINT_"+crop))
			{
				profitpoint=rule.getValue();
			}
			else if(rule.getCode().equalsIgnoreCase("I_GF_LOW_POINT_"+crop))
			{
				memberFlowpoint=rule.getValue();
			}
		}
		
		result.put("subCorpPoint", subCorpPoint);
		result.put("platformPoint", platformPoint);
		result.put("profitpoint", profitpoint);
		result.put("memberFlowpoint", memberFlowpoint);
		
		return result;
	}
}
