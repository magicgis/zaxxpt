package com.hnatourism.club.hotel.prod.web.action;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.hotel.api.service.IHotelNewApiManager;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelDetailInfoVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelDetailsQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelDetailsResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelQueryResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomBaseInfoVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomRateVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomResultVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.product.base.service.RecommendProdService;
import com.hnatourism.club.product.base.vo.RecommendProdVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店信息
 * 
 * 历史版本: 2011-9-13 v1.0.0 (lixun) 创建
 * 
 */

public class HotelInfoAction extends BaseAction {
	/**
	 * 酒店首页显示的推荐酒店最大数量(推荐区域顶部)
	 */
	private static final int RECOM_HOTLE_AMOUNT_SERACH_TOP = 4;
	/**
	 * 酒店首页显示的推荐最大城市数量
	 */
	private static final int RECOM_CITY_AMOUNT_SERACH = 5;
	/**
	 * 酒店首页显示的推荐每个城市显示的酒店最大数量
	 */
	private static final int RECOM_HOTLE_AMOUNT_SERACH = 12;
	/**
	 * 首页显示的酒店区推荐区域的酒店显示条数最大数量
	 */
	private static final int RECOM_HOTEL_AMOUNT_INDEX = 5;
	/**
	 * 房间详情查询错误信息
	 */
	private static String errorMes;

	private MemberInfoVo member = null;

	// ///////////////////////////////////////////服务对象
	/**
	 * 酒店新版接口实现
	 */
	private IHotelNewApiManager hotelNewApiManager;
	/**
	 * 城市对应的产品推荐信息
	 */
	private Map<String, List<RecommendProdVo>> cityRecommendProdVos;
	// ///////////////////////////////////////////查询对象
	/**
	 * 酒店查询vo
	 */
	private HotelQueryVo hotelQueryVo;
	/**
	 * 酒店房型查询对象
	 */
	private HotelRoomQueryVo hotelRoomQueryVo;
	/**
	 * 酒店详情查询对象
	 */
	private HotelDetailsQueryVo hotelDetailsQueryVo;

	// ///////////////////////////////////////////查询结果对象
	/**
	 * 产品推荐
	 */
	private RecommendProdService recommendProdService;
	/**
	 * 推荐产品列表
	 */
	private List<RecommendProdVo> recommendProdVos;
	/**
	 * 酒店查询结果
	 */
	private HotelQueryResultVo hotelQueryResultVo;
	/**
	 * 酒店房型查询结果
	 */
	private HotelRoomResultVo hotelRoomResultVo;
	/**
	 * 酒店详情查询返回结果
	 */
	private HotelDetailsResultVo hotelDetailsResultVo;

	/**
	 * 酒店首页初始化
	 */
	public String initHotelHome() {
		return "toIndex";
	}

	/**
	 * 
	 * @description 【查看酒店详情】
	 * @return
	 * @createTime 2011-9-13 下午07:23:20
	 * @author lixun
	 */
	public String findHotelDetails() {
		hotelDetailsResultVo = hotelNewApiManager
				.findHotelDetails(hotelDetailsQueryVo);
		if (hotelDetailsResultVo != null
				&& hotelDetailsResultVo.getResultBean() != null) {
			HotelDetailInfoVo detailInfoVo = hotelDetailsResultVo
					.getResultBean();
			if (detailInfoVo != null) {
				hotelRoomQueryVo = new HotelRoomQueryVo();
				hotelRoomQueryVo.setCity(detailInfoVo.getCitycode());
				hotelRoomQueryVo.setCitySource("hbe");
				hotelRoomQueryVo.setHotelCode(hotelDetailsQueryVo
						.getHotelCode());
				hotelRoomQueryVo.setIdate(hotelDetailsQueryVo.getIdate());
				hotelRoomQueryVo.setOdate(hotelDetailsQueryVo.getOdate());
				hotelRoomResultVo = hotelNewApiManager
						.findHotelRoomList(hotelRoomQueryVo);
				if (hotelRoomResultVo != null
						&& !ListUtils
								.isEmpty(hotelRoomResultVo.getResultBean())) {
					// 计算分润价格
					calculateSalePrice(hotelRoomResultVo.getResultBean());
				}
				// 房型信息
				getRequest().setAttribute("rooms",
						hotelRoomResultVo.getResultBean());
				// 避免前台获取信息是参数过长
				getRequest().setAttribute("hotel",
						hotelDetailsResultVo.getResultBean().getHotel());
				getRequest().setAttribute("details",
						hotelDetailsResultVo.getResultBean().getDetails());
			}
		}
		return "details";
	}

	/**
	 * 
	 * @description 【显示推荐酒店-club 首页】
	 * @return
	 * @createTime 2011-9-22 下午03:58:32
	 * @author lixun
	 */
	public String findRecommInIndex() {
		try {
			recommendProdVos = recommendProdService.findByType("H", null,
					RECOM_HOTEL_AMOUNT_INDEX);
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
		return "viewRecommInIndex";
	}

	/**
	 * 
	 * @description 【显示酒店推荐--hotel 首页】
	 * @return
	 * @createTime 2011-9-22 下午03:59:47
	 * @author lixun
	 */
	public String findRecommInSearch() {
		try {
			// 查询推荐前X条
			recommendProdVos = recommendProdService.findByType("H", null,
					RECOM_HOTLE_AMOUNT_SERACH_TOP);
			// 查询X个城市推荐
			cityRecommendProdVos = recommendProdService.findByType("H",
					RECOM_CITY_AMOUNT_SERACH, RECOM_HOTLE_AMOUNT_SERACH);
		} catch (BusinessException e) {
			log.error("查询推荐酒店信息失败");
		}
		return "viewRecommInSearch";
	}

	/**
	 * 
	 * @description 酒店搜索
	 * @return
	 * @createTime 2011-11-14 下午05:10:56
	 * @author lixun
	 */
	public String search() {
		try {
			if (hotelQueryVo != null) {
				hotelQueryResultVo = hotelNewApiManager
						.findHotelList(hotelQueryVo);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return "toSearch";
	}

	/**
	 * 保存产品基本信息
	 * 
	 * @throws Exception
	 */
	public void searchRoomInfo() throws Exception {
		try {
			hotelRoomResultVo = hotelNewApiManager
					.findHotelRoomList(hotelRoomQueryVo);
			if (hotelRoomResultVo != null
					&& hotelRoomResultVo.getResultBean() != null) {
				member = UserUtil.getUser(getSession().getId());
				// 计算分润价格
				calculateSalePrice(hotelRoomResultVo.getResultBean());
			}
			Gson gson = new Gson();
			String jsonStr = gson.toJson(hotelRoomResultVo);
			writeString(jsonStr);
		} catch (Exception e) {
			log.error("查询房型信息失败@HotelInfoAction.searchRoomInfo()");
			writeString("{\"result\":{\"resultCode\":\"\",\"message\":\"查询房型失败\"}}");
		}
	}

	private SubRunBean getSubRunBean() {
		member = UserUtil.getUser(getSession().getId());
		SubRunBean subRunBean = new SubRunBean();
		subRunBean.setProdType("H");
		if (member != null) {
			subRunBean.setRoleCode(member.getMemberAccount().getMemberRole()
					.getCode());
			if ("GOVERNMENT".equalsIgnoreCase(member.getMemberAccount()
					.getMemberRole().getCode()))// 政企管家
			{
				Map<String, String> rule_result = RuleConfigProfit
						.setRuleParam("H", member.getRuleConfigList(), member
								.getMemberAccount().getOrganizationId());
				subRunBean.setSubCorpPoint(Double.parseDouble(rule_result
						.get("subCorpPoint")));
				subRunBean.setPlatformPoint(Double.parseDouble(rule_result
						.get("platformPoint")));
				subRunBean.setProfitpoint(rule_result.get("profitpoint"));
				subRunBean.setMemberFlowpoint(rule_result
						.get("memberFlowpoint"));
			}
		} else {
			// 默认金管家
			subRunBean.setRoleCode("GOLD");
		}
		return subRunBean;
	}

	private void calculateSalePrice(List<HotelRoomBaseInfoVo> resultBean) {
		// 判断是否直减标志
		boolean isMINUS = member == null
				|| member.getMemberAccount().getPrivilegeType() == null
				|| member.getMemberAccount().getPrivilegeType()
						.equalsIgnoreCase("MINUS");
		// 计算分润
		SubRunBean subRunBean = getSubRunBean();
		for (HotelRoomBaseInfoVo infoVo : resultBean) {
			if (infoVo != null && infoVo.getRateList() != null) {
				for (HotelRoomRateVo rateVo : infoVo.getRateList()) {
					if (isMINUS) {
						if (isMINUS) {
							Double salePrice = Double.parseDouble(rateVo.getSalePrice());
							if (isMINUS) {
								subRunBean.setProdSalePrice(Double.parseDouble(rateVo
										.getSalePrice()));
								salePrice = salePrice - salePrice
										* Constants.HotelBookConstants.HOTEL_MEMBER_POINT;
								if (salePrice <= Double.parseDouble(rateVo
										.getChannelCostPrice())) {
									rateVo.setSalePrice(new BigDecimal(salePrice).setScale(0,
													BigDecimal.ROUND_UP).toString());
								} else {
									// 按常规方式计算分润价格
									subRunBean.setProdSignprice(Double.parseDouble(rateVo
											.getChannelCostPrice()));
									rateVo.setSalePrice(new BigDecimal(SubRunUtils
											.getProdPrice(subRunBean)).setScale(0,
													BigDecimal.ROUND_UP).toString());
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * @return the errorMes
	 */
	public String getErrorMes() {
		String temp = errorMes;
		errorMes = "";
		return temp;
	}

	public MemberInfoVo getMember() {
		return member;
	}

	public void setMember(MemberInfoVo member) {
		this.member = member;
	}

	public IHotelNewApiManager getHotelNewApiManager() {
		return hotelNewApiManager;
	}

	public void setHotelNewApiManager(IHotelNewApiManager hotelNewApiManager) {
		this.hotelNewApiManager = hotelNewApiManager;
	}

	public Map<String, List<RecommendProdVo>> getCityRecommendProdVos() {
		return cityRecommendProdVos;
	}

	public void setCityRecommendProdVos(
			Map<String, List<RecommendProdVo>> cityRecommendProdVos) {
		this.cityRecommendProdVos = cityRecommendProdVos;
	}

	public HotelQueryVo getHotelQueryVo() {
		return hotelQueryVo;
	}

	public void setHotelQueryVo(HotelQueryVo hotelQueryVo) {
		this.hotelQueryVo = hotelQueryVo;
	}

	public RecommendProdService getRecommendProdService() {
		return recommendProdService;
	}

	public void setRecommendProdService(
			RecommendProdService recommendProdService) {
		this.recommendProdService = recommendProdService;
	}

	public List<RecommendProdVo> getRecommendProdVos() {
		return recommendProdVos;
	}

	public void setRecommendProdVos(List<RecommendProdVo> recommendProdVos) {
		this.recommendProdVos = recommendProdVos;
	}

	public HotelQueryResultVo getHotelQueryResultVo() {
		return hotelQueryResultVo;
	}

	public void setHotelQueryResultVo(HotelQueryResultVo hotelQueryResultVo) {
		this.hotelQueryResultVo = hotelQueryResultVo;
	}

	public HotelRoomQueryVo getHotelRoomQueryVo() {
		return hotelRoomQueryVo;
	}

	public void setHotelRoomQueryVo(HotelRoomQueryVo hotelRoomQueryVo) {
		this.hotelRoomQueryVo = hotelRoomQueryVo;
	}

	public HotelRoomResultVo getHotelRoomResultVo() {
		return hotelRoomResultVo;
	}

	public void setHotelRoomResultVo(HotelRoomResultVo hotelRoomResultVo) {
		this.hotelRoomResultVo = hotelRoomResultVo;
	}

	public HotelDetailsQueryVo getHotelDetailsQueryVo() {
		return hotelDetailsQueryVo;
	}

	public void setHotelDetailsQueryVo(HotelDetailsQueryVo hotelDetailsQueryVo) {
		this.hotelDetailsQueryVo = hotelDetailsQueryVo;
	}

	public HotelDetailsResultVo getHotelDetailsResultVo() {
		return hotelDetailsResultVo;
	}

	public void setHotelDetailsResultVo(
			HotelDetailsResultVo hotelDetailsResultVo) {
		this.hotelDetailsResultVo = hotelDetailsResultVo;
	}

}
