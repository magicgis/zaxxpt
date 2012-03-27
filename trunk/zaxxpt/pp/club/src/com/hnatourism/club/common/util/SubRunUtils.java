package com.hnatourism.club.common.util;

/**
 * 
 */


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.member.rule.vo.RuleConfigDetailVo;
import com.hnatourism.framework.cache.CacheDataManager;
import com.hnatourism.framework.utils.PropertiesUtils;

/**
 * @author gujianliang
 * @2011-8-31
 */
public class SubRunUtils {
	
	private static final Log log = LogFactory.getLog(SubRunUtils.class);
	
	//取得分润规则
	//private static 	RuleConfigDetailVo ruleConfigDetailVo = (RuleConfigDetailVo) CacheDataManager.get("RULE_CONFIG_DETAIL_VO");
	/**
	 * 会员分点
	 */
	private static String MEMBER_POINT="memberPoint";//会员分点
	/**
	 * 平台和分公司分点
	 */
	private static String PROFIT_POINT="profitpoint";//平台和分公司分点
	/**
	 * 分公司分点
	 */
	private static String SUBCORP_POINT="subCorpPoint";//分公司分点
	/**
	 * 平台分点
	 */
	private static String PLATFORM_POINT="platformPoint";//平台分点
	
	//用户角色
	private static String ROLE_GOLD="GOLD";
	private static String ROLE_PLATINUM="PLATINUM";
	private static String ROLE_DIAMOND="DIAMOND";
	private static String ROLE_GOVERNMENT="GOVERNMENT";
	
	//产品
	private static String PRO_GF="GF";
	private static String PRO_L="L";
	private static String PRO_F="F";
	private static String PRO_H="H";
	//用户获得的返点
	private static String memberPointStr;

	//平台收用户手续费费率  目前 费率为汇付费率
	private static String platFormFeeRate=PropertiesUtils.getVal("payInterface", "fund_fee");
	/**
	 * 计算平台  分公司分润点
	 * @author gujianliang
	 * @2011-9-1
	 * @param roleCode  会员code
	 * @param prodType  会员类型
	 * @param subCorpPoint 分公司分润点
	 * @param platformPoint 平台分润点
	 */
	public static Map<String,BigDecimal> subRun(String roleCode,String prodType,BigDecimal subCorpPoint,BigDecimal platformPoint,BigDecimal memberPoint,BigDecimal salerPoint){
		
		//取得分润规则
		RuleConfigDetailVo ruleConfigDetailVo = (RuleConfigDetailVo) CacheDataManager.get("RULE_CONFIG_DETAIL_VO");
		
		Map<String,BigDecimal>  map=new HashMap<String,BigDecimal>();
		//用户享受最低点
		BigDecimal memberFlowpoint=new BigDecimal(0);
		//平台和分公司分润点
		BigDecimal profitpoint=new BigDecimal(0);
		
		if(roleCode.equals(ROLE_GOLD) && prodType.equals(PRO_GF)){
			subCorpPoint = new BigDecimal(ruleConfigDetailVo.getGgfprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getGgfprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getGgfprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getGgfprofitpoint());
			}
		//金管家  -- 机票
		}else if(roleCode.equals(ROLE_GOLD) && prodType.equals(PRO_F)){
			subCorpPoint = new BigDecimal(ruleConfigDetailVo.getGfprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getGfprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getGfprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getGfprofitpoint());
			}
			
			//会员最低点分润点
			if("ALL".equals(ruleConfigDetailVo.getGflowpoint())){
				memberFlowpoint=salerPoint;
			}else{
				memberFlowpoint=new BigDecimal(ruleConfigDetailVo.getGflowpoint());
			}
			//金管家  -- 机场
		}else if(roleCode.equals(ROLE_GOLD) && prodType.equals(PRO_L)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getGlprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getGlprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getGlprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getGlprofitpoint());
			}
		}else if(roleCode.equals(ROLE_GOLD) && prodType.equals(PRO_H)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getGhprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getGhprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getGhprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getGhprofitpoint());
			}
			
			//会员最低点分润点
			if("ALL".equals(ruleConfigDetailVo.getGhlowpoint())){
				memberFlowpoint=salerPoint;
			}else{
				memberFlowpoint=new BigDecimal(ruleConfigDetailVo.getGhlowpoint());
			}
		}else if(roleCode.equals(ROLE_PLATINUM) && prodType.equals(PRO_GF)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIgfprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIgfprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getIgfprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getIgfprofitpoint());
			}
		}else if(roleCode.equals(ROLE_PLATINUM) && prodType.equals(PRO_F)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIfprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIfprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getIfprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getIfprofitpoint());
			}
			
			//会员最低点分润点
			if("ALL".equals(ruleConfigDetailVo.getIflowpoint())){
				memberFlowpoint=salerPoint;
			}else{
				memberFlowpoint=new BigDecimal(ruleConfigDetailVo.getIflowpoint());
			}
		}else if(roleCode.equals(ROLE_PLATINUM) && prodType.equals(PRO_L)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIlprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIlprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getIlprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getIlprofitpoint());
			}
		}else if(roleCode.equals(ROLE_PLATINUM) && prodType.equals(PRO_H)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIhprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIhprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getIhprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getIhprofitpoint());
			}
			
			//会员最低点分润点
			if("ALL".equals(ruleConfigDetailVo.getIhlowpoint())){
				memberFlowpoint=salerPoint;
			}else{
				memberFlowpoint=new BigDecimal(ruleConfigDetailVo.getIhlowpoint());
			}
		}else if(roleCode.equals(ROLE_DIAMOND) && prodType.equals(PRO_GF)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIgfprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIgfprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getIgfprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getIgfprofitpoint());
			}
			
		}else if(roleCode.equals(ROLE_DIAMOND) && prodType.equals(PRO_F)){
			subCorpPoint = new BigDecimal(ruleConfigDetailVo.getIfprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIfprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getIfprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getIfprofitpoint());
			}
			
			//会员最低点分润点
			if("ALL".equals(ruleConfigDetailVo.getIflowpoint())){
				memberFlowpoint=salerPoint;
			}else{
				memberFlowpoint=new BigDecimal(ruleConfigDetailVo.getIflowpoint());
			}
		}else if(roleCode.equals(ROLE_DIAMOND) && prodType.equals(PRO_L)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIlprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIlprofitratee());
			
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getIlprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getIlprofitpoint());
			}
		}else if(roleCode.equals(ROLE_DIAMOND) && prodType.equals(PRO_H)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIhprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIhprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getIhprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getIhprofitpoint());
			}
			
			//会员最低点分润点
			if("ALL".equals(ruleConfigDetailVo.getIhlowpoint())){
				memberFlowpoint=salerPoint;
			}else{
				memberFlowpoint=new BigDecimal(ruleConfigDetailVo.getIhlowpoint());
			}
		}else if(roleCode.equals(ROLE_GOVERNMENT) && prodType.equals(PRO_GF)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIgfprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIgfprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getGgfprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getGgfprofitpoint());
			}
		}else if(roleCode.equals(ROLE_GOVERNMENT) && prodType.equals(PRO_F)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIfprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIfprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getGfprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getGfprofitpoint());
			}
			
			//会员最低点分润点
			if("ALL".equals(ruleConfigDetailVo.getGflowpoint())){
				memberFlowpoint=salerPoint;
			}else{
				memberFlowpoint=new BigDecimal(ruleConfigDetailVo.getGflowpoint());
			}
		}else if(roleCode.equals(ROLE_GOVERNMENT) && prodType.equals(PRO_L)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIlprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIlprofitratee());
			
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getGlprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getGlprofitpoint());
			}
		}else if(roleCode.equals(ROLE_GOVERNMENT) && prodType.equals(PRO_H)){
			subCorpPoint =  new BigDecimal(ruleConfigDetailVo.getIhprofitrates());
			platformPoint =  new BigDecimal(ruleConfigDetailVo.getIhprofitratee());
			//平台和分公司分润点
			if("ALL".equals(ruleConfigDetailVo.getGhprofitpoint())){
				profitpoint=salerPoint;
			}else{
				profitpoint=new BigDecimal(ruleConfigDetailVo.getGhprofitpoint());
			}
			
			//会员最低点分润点
			if("ALL".equals(ruleConfigDetailVo.getGhlowpoint())){
				memberFlowpoint=salerPoint;
			}else{
				memberFlowpoint=new BigDecimal(ruleConfigDetailVo.getGhlowpoint());
			}
		}
		
		
		//如果分润点小与最地点salerPoint
		if(salerPoint.doubleValue()<(memberFlowpoint.add(profitpoint)).doubleValue()){
			memberPoint=memberFlowpoint;//先满足用户最低点   不管怎么样都要满足 用户最低点
			//如果供应商返点大于分用户最低点 相减
			if(salerPoint.doubleValue()>=memberFlowpoint.doubleValue()){
				profitpoint=salerPoint.subtract(memberPoint);//剩下平台分
			}
		}else{
			//用户返点 = 销售商返点-- 平台和分公司的分润点
			memberPoint=salerPoint.subtract(profitpoint);
		}
		
		//四舍五入
		// 会员分点
		memberPoint = memberPoint.setScale(2, BigDecimal.ROUND_HALF_UP);;
		// 平台
		profitpoint = profitpoint.setScale(2, BigDecimal.ROUND_HALF_UP);
		// 分公司分点
		subCorpPoint = subCorpPoint.setScale(2, BigDecimal.ROUND_HALF_UP);
		// 平台分点
		platformPoint = platformPoint.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		log.info("memberPoint:"+memberPoint);
		map.put(MEMBER_POINT, memberPoint);//会员分点
		map.put(PROFIT_POINT, profitpoint);//平台和分公司分点
		
		map.put(SUBCORP_POINT, subCorpPoint);//分公司分点
		map.put(PLATFORM_POINT, platformPoint);//平台分点
		
		return map;
	}
	
	
	/**
	 * 政企管家会员分润点
	 * @author gujianliang
	 * @2011-9-15
	 * @param subCorpPoint 分公司分润点
	 * @param platformPoint 平台分润点
	 * @param memberPoint 会员分润点
	 * @param salerPoint 产品提供商提供点
	 * @param profitpoint1 平台分公司分点
	 * @param memberFlowpoint1 会员享受最低点
	 * @return
	 */
	public static Map<String,BigDecimal> subRun_GV(BigDecimal subCorpPoint,BigDecimal platformPoint,BigDecimal memberPoint,BigDecimal salerPoint,String profitpoint1,String memberFlowpoint1){
		
		Map<String,BigDecimal>  map=new HashMap<String,BigDecimal>();
		
		//用户享受最低点
		BigDecimal memberFlowpoint=new BigDecimal(0);
		//平台和分公司分润点
		BigDecimal profitpoint=new BigDecimal(0);
		
		//平台和分公司分润点
		if("ALL".equals(profitpoint1)){
			profitpoint=salerPoint;
		}
		
		//会员最低点分润点
		if("ALL".equals(memberFlowpoint1)){
			memberFlowpoint=salerPoint;
		}else{
			memberFlowpoint=new BigDecimal(memberFlowpoint1);
		}

		//如果分润点小与最地点salerPoint
		if(salerPoint.doubleValue()<(memberFlowpoint.add(profitpoint)).doubleValue()){
			memberPoint=memberFlowpoint;//先满足用户最低点   不管怎么样都要满足 用户最低点
			//如果供应商返点大于分用户最低点 相减
			if(salerPoint.doubleValue()>=memberFlowpoint.doubleValue()){
				profitpoint=salerPoint.subtract(memberPoint);//剩下平台分
			}
		}else{
			//用户返点 = 销售商返点-- 平台和分公司的分润点
			memberPoint=salerPoint.subtract(profitpoint);
		}
		map.put(MEMBER_POINT, memberPoint);//会员分点
		log.info("政企：memberPoint:"+memberPoint);
		return map;
	}
	/**
	 * 获取购买价
	 * @author gujianliang
	 * @2011-8-31
	 * @param sunRunBean 对象中传入参数：roleCode-会员code，prodType-产品类型，prodSalePrice-产品销售价，prodSignprice-产品签约价
	 * @return
	 */
	public static Double getProdPrice(SubRunBean subRunBean){
		
		BigDecimal price=new BigDecimal(0);
		String fileds="roleCode,prodType,prodSalePrice,prodSignprice";
		if(objFildsIsNull(subRunBean,fileds)){
			log.info("传入参数不完整");
			return null;
		}
		BigDecimal salerPoint=new BigDecimal(0);//默认为0.0       不传值时计算返点  否则不计算
		BigDecimal salPrice=new BigDecimal(subRunBean.getProdSalePrice()).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal signPrice=new BigDecimal(subRunBean.getProdSignprice()).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		if(subRunBean.getSalerPoint()==null){
			//计算商家返点
			salerPoint=(salPrice.subtract(signPrice)).divide(signPrice,2,BigDecimal.ROUND_HALF_DOWN);
			salerPoint=salerPoint.multiply(new BigDecimal(100));
		}else{
			salerPoint=new BigDecimal(subRunBean.getSalerPoint()).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		}
		BigDecimal attPrice=new BigDecimal(0);
		if(subRunBean.getAttPrice()!=null){
			attPrice=new BigDecimal(subRunBean.getAttPrice()).setScale(2,BigDecimal.ROUND_HALF_DOWN);	//附加费用    可以加 可以不加  不加默认为 没有
		}
		
		
		BigDecimal memberPoint=new BigDecimal(0);
		
		BigDecimal subCorpPoint =new BigDecimal(subRunBean.getSubCorpPoint()).setScale(2,BigDecimal.ROUND_HALF_DOWN);//分公司分点
		BigDecimal platformPoint=new BigDecimal(subRunBean.getPlatformPoint()).setScale(2,BigDecimal.ROUND_HALF_DOWN);//平台分点
		String profitpoint=subRunBean.getProfitpoint();//平台和分公司分点    ALL为全分
		String memberFlowpoint=subRunBean.getMemberFlowpoint();//会员享受最低点    ALL为全分
		
		Map<String,BigDecimal> map=null;
		//如果是政企管家
		if(ROLE_GOVERNMENT.equals(subRunBean.getRoleCode())){
			 map=subRun_GV(subCorpPoint,platformPoint,memberPoint,salerPoint,profitpoint,memberFlowpoint);
		}else{
			 map=subRun(subRunBean.getRoleCode(),subRunBean.getProdType(),subCorpPoint,platformPoint,memberPoint,salerPoint);
		}
		
		
		memberPoint=map.get(MEMBER_POINT);
		memberPointStr=String.valueOf(memberPoint);
		BigDecimal prodsalePrice=new BigDecimal(subRunBean.getProdSalePrice()).setScale(2,BigDecimal.ROUND_HALF_DOWN);;
		BigDecimal prodsignPrice=new BigDecimal(subRunBean.getProdSignprice()).setScale(2,BigDecimal.ROUND_HALF_DOWN);;
		price=prodsalePrice.subtract(prodsignPrice.multiply(memberPoint.divide(new BigDecimal(100)))).add(attPrice);
		
		log.info("salerPoint:"+salerPoint);
		log.info("subRunBean.getProdSalePrice():"+prodsalePrice.setScale(2,BigDecimal.ROUND_HALF_DOWN));
		log.info("subRunBean.getProdSignprice():"+prodsignPrice.setScale(2,BigDecimal.ROUND_HALF_DOWN));
		//小数点后取2位   进位  凑整
		return Double.valueOf(String.valueOf(price.setScale(2, BigDecimal.ROUND_HALF_EVEN)));
	};
	
	/**
	 * 分润计算
	 * @author gujianliang
	 * @2011-8-31
	 * @param subRunBean 传入参数 AttPepoLowPrice-单收费项目按人收费项低价费用总和,AttOrderLowPrice 单收费项目按单收费项低价费用总和,roleCode 用户code,prodType 产品类型,privilegeType 直减或返积分标识1为直减2返积分,orderSignprice 订单产品签约价总价,orderPrice 订单总价,orderExPrice 附加项总价,sellerCardNo 产品提供商帐号,platformAccount 平台帐号,subCorpAccount 分公司帐号,account 个人分润帐号
	 * @return
	 */
	public static SubRunBean profitMoney(SubRunBean subRunBean){
		
		String fileds="AttPepoLowPrice,AttOrderLowPrice,roleCode,prodType,privilegeType,orderSignprice,orderPrice,orderExPrice,sellerCardNo,platformAccount,subCorpAccount";
		if(objFildsIsNull(subRunBean,fileds)){
			log.info("传入参数不完整");
			return null;
		}
		//分公司分润点
		String subCorpPoint = "0.0";
		//平台分润点
		String platformPoint = "0.0";
		
		String roleCode=subRunBean.getRoleCode();
		String prodType=subRunBean.getProdType();
		String type=subRunBean.getPrivilegeType();
		BigDecimal retPrice=new  BigDecimal(0);
		BigDecimal signprice=new  BigDecimal(subRunBean.getOrderSignprice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal price=new  BigDecimal(subRunBean.getOrderPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal exPrice=new  BigDecimal(subRunBean.getOrderExPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		String sellerNo=subRunBean.getSellerCardNo();
		String platformNo=subRunBean.getPlatformAccount();
		String subCorpNo=subRunBean.getSubCorpAccount();
		String memberNo=subRunBean.getAccount();
		
		
		//平台收用户手续费   2011-11-29 谷建亮  add
		BigDecimal platFormFee=new BigDecimal(0);
		if(platFormFeeRate!=null){
			platFormFee=price.multiply(new BigDecimal(platFormFeeRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		//账单总金额 减去 平台收取的手续费
		BigDecimal de_price=price.subtract(platFormFee);
		
		//按照单收费低价总和
		BigDecimal attOrderLowPrice=new BigDecimal(subRunBean.getAttOrderLowPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//按照人收费单收费项目低价总和
		BigDecimal attPepoLowPrice=new BigDecimal(subRunBean.getAttPepoLowPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//误差金额
		BigDecimal deviationPrice=new BigDecimal(subRunBean.getDeviationPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);//可有可无
		
		BigDecimal subCorpPoint1 =new BigDecimal(0);
		BigDecimal platformPoint1=new BigDecimal(0);
		BigDecimal memberPoint=new BigDecimal(0);
		BigDecimal salerPoint=new BigDecimal(0);
		Map<String,BigDecimal> map=subRun(roleCode,prodType,subCorpPoint1,platformPoint1,memberPoint,salerPoint);
		subCorpPoint=String.valueOf(map.get(SUBCORP_POINT));
		platformPoint=String.valueOf(map.get(PLATFORM_POINT));
		
		//判断是否需要返款
		if(type == null || !"2".equals(type.trim())){
			//直减
			retPrice = new BigDecimal(0);
		}else{
			retPrice=new BigDecimal(subRunBean.getOrderRetPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
			if(retPrice == null){
				retPrice = new BigDecimal(0);
			}
		}
		
		//取得用户账户，需要打的钱数
		BigDecimal memberNoMoney = retPrice;
		// 取得销售商账户需要的钱
		BigDecimal sellerNoMoney = signprice.add(attOrderLowPrice).add(attPepoLowPrice);
		//附加项利润
		BigDecimal attPrice=exPrice.subtract(attOrderLowPrice).subtract(attPepoLowPrice);
		//取得剩余平台和分公司的钱
//		Double remainMoney = price-sellerNoMoney-memberNoMoney-attPrice-deviationPrice;//单收费项目不参与分润
		log.info("price:"+price);
		log.info("sellerNoMoney:"+sellerNoMoney);
		log.info("memberNoMoney:"+memberNoMoney);
		log.info("deviationPrice:"+deviationPrice);
		//判断扣除手续费后 是否够支付   2011-11-29 add
		if((de_price.subtract(sellerNoMoney).subtract(memberNoMoney).subtract(deviationPrice)).doubleValue()<=0.0){
			de_price=price;
		}
		BigDecimal remainMoney = de_price.subtract(sellerNoMoney).subtract(memberNoMoney).subtract(deviationPrice);//单收费项目参与分润
		//取得分公司的钱
		BigDecimal subCorpNoMoney = (new BigDecimal(subCorpPoint).multiply(remainMoney)).divide(new BigDecimal(subCorpPoint).add(new BigDecimal(platformPoint)));
		
		sellerNoMoney=sellerNoMoney.setScale(2, BigDecimal.ROUND_DOWN);
		subCorpNoMoney=subCorpNoMoney.setScale(2,BigDecimal.ROUND_HALF_DOWN);
		memberNoMoney=memberNoMoney.setScale(2,BigDecimal.ROUND_DOWN);
		
		//谷建亮 添加 解决 double 精度问题 
		BigDecimal platformNoMoney=new BigDecimal(0);
		platformNoMoney=price.subtract(subCorpNoMoney).subtract(sellerNoMoney).subtract(memberNoMoney);
		platformNoMoney=platformNoMoney.setScale(2, BigDecimal.ROUND_DOWN);
		//给供应商的钱   四舍五入  取两位小数
		String sellerDetail = sellerNo+"^"+doubleHandler(String.valueOf(sellerNoMoney),2)+"^content";
		String details ="";
		
		if(platformNoMoney.doubleValue()>0.0){
			details=details+platformNo+"^"+doubleHandler(String.valueOf(platformNoMoney),2)+"^content";
		}
		if(subCorpNoMoney.doubleValue()>0.0){
			details=details+"|"+subCorpNo+"^"+doubleHandler(String.valueOf(subCorpNoMoney),2)+"^content";
		}
		//没有返积分时不给用户打钱
		//个人返点处理
		if(memberNoMoney!=null  && memberNo!=null){
			if( memberNoMoney.doubleValue()> 0.0){
				details += "|"+memberNo+"^"+doubleHandler(String.valueOf(memberNoMoney),2)+"^content";
			}
		}
		if(details.startsWith("|")){
			details=details.substring(1);
		}
		
		log.info("==============================");
		log.info("用户支付:"+price.setScale(2, BigDecimal.ROUND_DOWN));
		log.info("供应商收费:"+sellerNoMoney.setScale(2, BigDecimal.ROUND_DOWN));
		log.info("分公司利润:"+subCorpNoMoney.setScale(2, BigDecimal.ROUND_HALF_DOWN));
		log.info("平台分润点:"+platformNoMoney.setScale(2, BigDecimal.ROUND_DOWN));
		log.info("个人返点:"+memberNoMoney.setScale(2, BigDecimal.ROUND_DOWN));
		
		subRunBean.setSubCorpNoMoney(subCorpNoMoney.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
		subRunBean.setSellerMoney(sellerNoMoney.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
		subRunBean.setPlatformNoMoney(doubleHandlerRD(String.valueOf(platformNoMoney.setScale(2, BigDecimal.ROUND_DOWN)),2));
		subRunBean.setOrderPrice(doubleHandlerRD(String.valueOf(price),2));
		subRunBean.setDetails(details);
		subRunBean.setSellerDetail(sellerDetail);
		
		return subRunBean;
	}
	
	/**
	 * 退款
	 * @author gujianliang
	 * @2011-8-31
	 * @param subRunBean  传入参数：AttOrderLowPrice 单收费项目按单收费签约价总价,AttPepoLowPrice单收费项目按人收费签约价总价,returnPrice 退给用户的金额,orderExPrice 附加项金额,orderPrice 订单总金额,prodSignprice 产品签约价,sellerCardNo 产品提供商帐号,platformAccount 平台帐号,subCorpAccount 分公司帐号,account 个人分润帐号,AmountMoney 个人分润金额,fee 平台收的手续费暂时为0,sellerfee 产品提供商扣除手续费
	 * @return
	 */
	public static SubRunBean profitBackMoney(SubRunBean subRunBean){
		/**
		 * 验证参数是否为null
		 */
		String fileds="AttOrderLowPrice,AttPepoLowPrice,returnPrice,orderExPrice,orderPrice,prodSignprice,sellerCardNo,platformAccount,subCorpAccount,AmountMoney,fee,sellerfee";
		if(objFildsIsNull(subRunBean,fileds)){
			log.info("传入参数不完整");
			return null;
		}
		/**
		 * 初始化参数
		 */
		//分公司分润点
		String subCorpPoint = "0.0";
		//平台分润点
		String platformPoint = "0.0";
		//退给用户的金额
		BigDecimal returnPrice=new BigDecimal(subRunBean.getReturnPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//异常订单总价格价格
		BigDecimal price=new BigDecimal(subRunBean.getOrderPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//低价(签约价)
		BigDecimal prodSignprice=new BigDecimal(subRunBean.getProdSignprice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//销售附加家总和
		BigDecimal orderExPrice=new BigDecimal(subRunBean.getOrderExPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//按照单收费低价总和
		BigDecimal attOrderLowPrice=new BigDecimal(subRunBean.getAttOrderLowPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//按照人收费单收费项目低价总和
		BigDecimal attPepoLowPrice=new BigDecimal(subRunBean.getAttPepoLowPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//附加项利润
		BigDecimal attPrice=orderExPrice.subtract(attOrderLowPrice).subtract(attPepoLowPrice);
		//误差金额
		BigDecimal deviationPrice=new BigDecimal(subRunBean.getDeviationPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);//可有可无
		//账户
		String sellerNo=subRunBean.getSellerCardNo();
		String platformNo=subRunBean.getPlatformAccount();
		String subCorpNo=subRunBean.getSubCorpAccount();
		String memberNo=subRunBean.getAccount();
		/**
		 * 退款手续费处理
		 */
		//平台收的手续费 暂时没有 为0   非汇付手续费
		BigDecimal fee=new BigDecimal(subRunBean.getFee()).setScale(2,BigDecimal.ROUND_HALF_UP);  //暂时没有 为0
		//供应商扣除费用
		BigDecimal sellerfee=new BigDecimal(subRunBean.getSellerfee()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//平台代收汇付手续费   2011-11-29 谷建亮  add
		BigDecimal platFormFee=new BigDecimal(0);
		if(platFormFeeRate!=null){
			platFormFee=price.multiply(new BigDecimal(platFormFeeRate));
			//四舍五入
			platFormFee=platFormFee.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		//账单总金额 减去 平台收取的手续费
		BigDecimal de_price=price.subtract(platFormFee);
		
		/**
		 * 计算平台 和分公司的分润点
		 */
		BigDecimal subCorpPoint1 =new BigDecimal(0);
		BigDecimal platformPoint1=new BigDecimal(0);
		BigDecimal memberPoint=new BigDecimal(0);
		BigDecimal salerPoint=new BigDecimal(0);
		Map<String,BigDecimal> map=subRun(subRunBean.getRoleCode(),subRunBean.getProdType(),subCorpPoint1,platformPoint1,memberPoint,salerPoint);
		subCorpPoint=String.valueOf(map.get(SUBCORP_POINT));
		platformPoint=String.valueOf(map.get(PLATFORM_POINT));
		
		/**
		 * 分润计算
		 */
		//用户银帐号的钱  个人返点
		BigDecimal memberNoMoney=new BigDecimal(subRunBean.getAmountMoney()).setScale(2,BigDecimal.ROUND_HALF_UP);
		//扣除供应商的钱
		BigDecimal sellerMoney=prodSignprice.add(attOrderLowPrice).add(attPepoLowPrice);
		sellerMoney=sellerMoney.setScale(2, BigDecimal.ROUND_DOWN);
		//判断扣除手续费后 是否够支付   2011-11-29 add
		if((de_price.subtract(sellerMoney).subtract(memberNoMoney).subtract(deviationPrice)).doubleValue()<=0){
			de_price=price;
		}
		//取得剩余平台和分公司的钱
		BigDecimal remainMoney = de_price.subtract(sellerMoney).subtract(memberNoMoney).subtract(deviationPrice);//单收费项目参与分润
		//取得分公司的钱
		BigDecimal subCorpNoMoney = (new BigDecimal(subCorpPoint).multiply(remainMoney)).divide(new BigDecimal(subCorpPoint).add(new BigDecimal(platformPoint)));
		//取得平台的钱
		//分公司一定要四舍五入 否则 会有1分钱 让 平台支付
		subCorpNoMoney=subCorpNoMoney.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		memberNoMoney=memberNoMoney.setScale(2, BigDecimal.ROUND_DOWN);
		//退款金额的汇付手续费  四舍五入
		BigDecimal huifFee=returnPrice.multiply(new BigDecimal(PropertiesUtils.getVal("payInterface","fund_fee"))).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		BigDecimal platformNoMoney=new BigDecimal(0);
		//供应商应退金额=供应商实收金额-手续费
		BigDecimal sellerNoMoney_bg=sellerMoney.subtract(sellerfee);
		sellerNoMoney_bg=sellerNoMoney_bg.setScale(2, BigDecimal.ROUND_DOWN);
		//平台退款=总退金额-供应商退金额-分公司退金额-个人分润账号退金额
		platformNoMoney=returnPrice.subtract(subCorpNoMoney).subtract(sellerNoMoney_bg).subtract(memberNoMoney);
		platformNoMoney=platformNoMoney.setScale(2, BigDecimal.ROUND_DOWN);
		
		/**
		 * 拼支付时规定字符串
		 */
		String strSellerNoMoney = sellerNoMoney_bg.toString(); 
		String sellerDetail = sellerNo+"^"+strSellerNoMoney+"^content";
		String details ="";
		
		if(platformNoMoney.doubleValue()>0.0){
			details=details+platformNo+"^"+doubleHandler(String.valueOf(platformNoMoney),2)+"^content";
		}
		//手续费扣除 平台账户为负数处理  将之前的手续费 给用户    不判断手续费
		if(platformNoMoney.doubleValue()<0.0){
			platformNoMoney=new BigDecimal(0);
		}
		
		if(subCorpNoMoney.doubleValue()>0.0){
			details=details+"|"+subCorpNo+"^"+doubleHandler(String.valueOf(subCorpNoMoney),2)+"^content";
		}
		
		//没有返积分时不给用户打钱
		String strMemberNoMoney = doubleHandler(String.valueOf(memberNoMoney),2);
		//个人返点处理
		if(memberNo!=null && memberNoMoney!=null){
			if(memberNoMoney.doubleValue() != 0.0){
				details += "|"+memberNo+"^"+strMemberNoMoney+"^content";
			}
		}
		
		if(details.startsWith("|")){
			details=details.substring(1);
		}
		log.info("==============================");
		log.info("用户收款:"+returnPrice.setScale(2, BigDecimal.ROUND_DOWN));
		log.info("供应商退款:"+sellerNoMoney_bg.setScale(2, BigDecimal.ROUND_DOWN));
		log.info("分公司退款:"+subCorpNoMoney);
		log.info("平台分退款:"+platformNoMoney.setScale(2, BigDecimal.ROUND_DOWN));
		log.info("个人分润退款:"+memberNoMoney.setScale(2, BigDecimal.ROUND_DOWN));
		/**
		 * 返回值赋值
		 */
		subRunBean.setReturnPrice(returnPrice.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
		subRunBean.setSubCorpNoMoney(subCorpNoMoney.doubleValue());
		subRunBean.setPlatformNoMoney(doubleHandlerRD(String.valueOf(platformNoMoney.setScale(2, BigDecimal.ROUND_DOWN)),2));
		subRunBean.setSellerMoney(Double.valueOf(strSellerNoMoney));
		subRunBean.setAmountMoney(memberNoMoney.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
		//price=price-sellerfee-fee;//总给用户退的钱数
		//subRunBean.setOrderPrice(doubleHandlerRD(String.valueOf(price),2));
		subRunBean.setDetails(details);
		subRunBean.setSellerDetail(sellerDetail);
		return subRunBean;
	}
	
	
	/**
	 * 改期
	 * @author gujianliang
	 * @2011-8-31
	 * @param subRunBean 传入参数SellerMoney 改期补额,AmountMoney 支付总钱数,SellerCardNo 产品提供商帐号,PlatformAccount 平台帐号
	 * @return
	 */
	public static SubRunBean changeMoney(SubRunBean subRunBean){
		
		String fileds="SellerMoney,AmountMoney,SellerCardNo,PlatformAccount";
		if(objFildsIsNull(subRunBean,fileds)){
			log.info("传入参数不完整");
			return null;
		}
		//产品提供商钱数
		Double sellerMoney=subRunBean.getSellerMoney();
		//支付总钱数
		Double price=subRunBean.getAmountMoney();
		//产品提供商帐号
		String sellerNo=subRunBean.getSellerCardNo();
		//平台帐号
		String platformNo=subRunBean.getPlatformAccount();
		//打给供应商的钱
		String sellerDetail = sellerNo+"^"+doubleHandler(String.valueOf(sellerMoney),2)+"^content";
		
		String details = "";
		//剩下的钱打给平台
		if(sellerMoney < price){
			details = platformNo+"^"+doubleHandler(String.valueOf(price-sellerMoney),2)+"^content";
		}

		subRunBean.setPlatformNoMoney(price-sellerMoney);
		subRunBean.setDetails(details);
		subRunBean.setSellerDetail(sellerDetail);
		
		return subRunBean;
	}
	/**
	 * 小数点取值    后几位
	 * @author gujianliang
	 * @2011-8-26
	 * @param obj
	 * @param size
	 * @return
	 */
	public static String doubleHandler(String str,Integer size){
		str=str.trim();
		if(str==null && size==null){
			return null;
		}
		if(size>9){
			return null;
		}
		if(str.indexOf(".")>0){
			str=str+"000000000000";
			str=str.substring(0,str.indexOf(".")+(size+1));
		}else{
			str=str+".";
			for(int i=0;i<size;i++){
				str=str+"0";
			}
		}
		return str;
	}
	
	/**
	 * 小数点处理
	 * @author gujianliang
	 * @2011-9-1
	 * @param str
	 * @param size
	 * @return
	 */
	public static Double doubleHandlerRD(String str,Integer size){
		str=doubleHandler(str,size);
		return Double.valueOf(str);
	}
	
	
	/**
	 * 判断对象中指定字段是否为null
	 * @author gujianliang
	 * @2011-9-1
	 * @param obj
	 * @param filds  逗号间隔
	 * @return
	 */
	public static Boolean objFildsIsNull(Object obj,String filds){
		Boolean retur=false;
		String [] fildsArray=filds.split(",");
		for(String fild:fildsArray){
			fild=fild.substring(0,1).toUpperCase()+fild.substring(1);
			try {
				Object ob=obj.getClass().getMethod("get"+fild).invoke(obj);
				if(ob==null){
					log.error("fild is null : "+fild);
					retur=true;
				}else{
					if("".equals(String.valueOf(ob))){
						log.error("fild is '' : "+fild);
						retur=true;
					}
				}
			} catch (Exception e) {
				retur=true;
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return retur;
	}


	
	public static String getMemberPointStr() {
		return memberPointStr;
	}


	public static void setMemberPointStr(String memberPointStr) {
		SubRunUtils.memberPointStr = memberPointStr;
	}


	public static void main(String [] args){
//		   double i = 3.856;
//
//		   // 舍掉小数取整
//		   //System.out.println("舍掉小数取整:Math.floor(3.856)=" + (int) Math.floor(i));
//
//		   // 四舍五入取整
//		   //System.out.println("四舍五入取整:(3.856)="
//		     + new BigDecimal(i).setScale(0, BigDecimal.ROUND_HALF_UP));
//
//		   // 四舍五入保留两位小数
//		   //System.out.println("四舍五入保留两位小数:(3.856)="
//		     + new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_UP));
//
//		   // 凑整，取上限
//		   //System.out.println("凑整:Math.ceil(3.856)=" + (int) Math.ceil(i));
//
//		   // 舍掉小数取整
//		   //System.out.println("舍掉小数取整:Math.floor(-3.856)=" + (int) Math.floor(-i));
//		   // 四舍五入取整
//		   //System.out.println("四舍五入取整:(-3.856)="
//		     + new BigDecimal(-i).setScale(0, BigDecimal.ROUND_HALF_UP));
//
//		   // 四舍五入保留两位小数
//		   //System.out.println("四舍五入保留两位小数:(-3.856)="
//		     + new BigDecimal(-i).setScale(2, BigDecimal.ROUND_HALF_UP));
//
//		   // 凑整，取上限
//		   //System.out.println("凑整(-3.856)=" + (int) Math.ceil(-i));
//		   
//		   // 进位保留两位小数
//		   //System.out.println("进位保留两位小数:(3.854)="
//		     + new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
		
		////System.out.println()doubleHandler("34.56788",2);
		String str="asdfsdf,asdfsdfsdf；sdfsdf,";
		System.out.println(new BigDecimal(3.1).setScale(0, BigDecimal.ROUND_UP));
		}


}
