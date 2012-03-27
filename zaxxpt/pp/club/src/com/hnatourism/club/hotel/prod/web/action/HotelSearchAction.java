package com.hnatourism.club.hotel.prod.web.action;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.hotel.api.service.HotelRequestHelper;
import com.hnatourism.club.hotel.api.service.IHotelApiManager;
import com.hnatourism.club.hotel.prod.web.vo.HotelRoomVo;
import com.hnatourism.club.hotel.prod.web.vo.HotelVo;
import com.hnatourism.club.hotel.prod.web.vo.QryHotelVo;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.club.product.base.service.RecommendProdService;
import com.hnatourism.framework.web.action.BaseAction;
/**
 * 项目名称:海航旅业club系统系统
 * 
 * 功能描述:搜索
 * 
 * 历史版本: ${2011.9.5} v1.0.0 (${周峰}) 创建
 * 
 */
public class HotelSearchAction extends BaseAction{
	
	private QryHotelVo qryHotelVo;
	private HotelVo hotelVo;
	private String jsonStr;
	private IHotelApiManager hotelApiManager;
	
	private RecommendProdService recommendProdService;
	//搜索
	@SuppressWarnings("finally")
	public String search(){
		try
		{
			if(qryHotelVo != null){
				//参数
				//Encode编码
				//qryHotelVo.setHotelname(Tool.transCoding(qryHotelVo.getHotelname()));
				jsonStr = hotelApiManager.findHotelList(qryHotelVo);
				if(jsonStr.trim().equals("")){
					jsonStr = "{\"result\":{\"resultCode\":\"\",\"message\":\"<b>非常抱歉,没有查询到相关信息的酒店。</b><br/>	请重新查询。如有疑问，请你致电400-88-51666进行咨询。!\"}}";
				}
			}
		}
		catch (Exception e)
		{
			log.error(e);
			jsonStr = "{\"result\":{\"resultCode\":\"\",\"message\":\"<b>非常抱歉,没有查询到相关信息的酒店。</b><br/>	请重新查询。如有疑问，请你致电400-88-51666进行咨询。!\"}}";
		}finally{
			return "success";
		}
		
	}
	/**
	 * 保存产品基本信息
	 * @throws Exception 
	 * @throws Exception 
	 */
	public void searchRoomInfo() throws Exception {
		
		try {
			MemberInfoVo member=null;
			MemberAccountVo memberAccount=null;
			MemberRoleVo memberRole=null;
			if(UserUtil.getUser(getSession().getId())==null)
			{
				memberAccount=new MemberAccountVo();
				memberAccount.setPrivilegeType("MINUS");
				memberRole=new MemberRoleVo();
				memberRole.setCode("GOLD");
			}
			else
			{
				member=UserUtil.getUser(getSession().getId());
				memberAccount=member.getMemberAccount();
				memberRole=memberAccount.getMemberRole();
			}
			
			if(qryHotelVo != null){
				//参数
				jsonStr = hotelApiManager.findRoomList(qryHotelVo);
				if(jsonStr.trim().equals("")){
					jsonStr = "{\"result\":{\"resultCode\":\"\",\"message\":\"<b>非常抱歉,没有查询到相关信息的酒店。</b><br/>	请重新查询。如有疑问，请你致电400-88-51666进行咨询。!\"}}";
				}
				else
				{
					HotelVo hotel=(HotelVo)HotelRequestHelper.string2Vo(jsonStr,HotelVo.class);
					if(hotel.getResultBean().getRooms()!=null&&hotel.getResultBean().getRooms().size()>0)
					{
						Iterator iterator=hotel.getResultBean().getRooms().iterator();
						while(iterator.hasNext())
						{
							HotelRoomVo room=(HotelRoomVo)iterator.next();
							
							SubRunBean subRunBean=new SubRunBean();
							subRunBean.setProdSignprice(Double.parseDouble(room.getAvgPrice()));
							subRunBean.setProdType("H");
							subRunBean.setRoleCode(memberRole.getCode());
							
							if(memberRole.getCode().equalsIgnoreCase("GOVERNMENT"))
							{
								Map<String, String> rule_result=RuleConfigProfit.setRuleParam("H", member.getRuleConfigList(), memberAccount.getOrganizationId());
								subRunBean.setSubCorpPoint(Double.parseDouble(rule_result.get("subCorpPoint")));
								subRunBean.setPlatformPoint(Double.parseDouble(rule_result.get("platformPoint")));
								subRunBean.setProfitpoint(rule_result.get("profitpoint"));
								subRunBean.setMemberFlowpoint(rule_result.get("memberFlowpoint"));
							}
							
							if(memberAccount.getPrivilegeType()==null||memberAccount.getPrivilegeType().equalsIgnoreCase("MINUS"))
							{
								subRunBean.setProdSalePrice(Double.parseDouble(room.getCostAvgPrice().toString()));
								Double price_temp=SubRunUtils.getProdPrice(subRunBean);
								room.setPrice(new BigDecimal(price_temp).setScale(0, BigDecimal.ROUND_UP).longValue());
							}
						}
					}
					
					Gson gson=new Gson();
					jsonStr=gson.toJson(hotel);
				}
			}
			writeString(jsonStr);
		} catch (Exception e) {
			log.error(e);
			writeString("{\"result\":{\"resultCode\":\"\",\"message\":\"<b>非常抱歉,没有查询到相关信息的酒店。</b><br/>	请重新查询。如有疑问，请你致电400-88-51666进行咨询。!\"}}");
		}
	}
	
	
	
	public QryHotelVo getQryHotelVo() {
		return qryHotelVo;
	}
	public void setQryHotelVo(QryHotelVo qryHotelVo) {
		this.qryHotelVo = qryHotelVo;
	}
	public HotelVo getHotelVo() {
		return hotelVo;
	}
	public void setHotelVo(HotelVo hotelVo) {
		this.hotelVo = hotelVo;
	}
	public String getJsonStr() {
		return jsonStr;
	}
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	public IHotelApiManager getHotelApiManager() {
		return hotelApiManager;
	}
	public void setHotelApiManager(IHotelApiManager hotelApiManager) {
		this.hotelApiManager = hotelApiManager;
	}
	public RecommendProdService getRecommendProdService() {
		return recommendProdService;
	}
	public void setRecommendProdService(RecommendProdService recommendProdService) {
		this.recommendProdService = recommendProdService;
	}
	
}
