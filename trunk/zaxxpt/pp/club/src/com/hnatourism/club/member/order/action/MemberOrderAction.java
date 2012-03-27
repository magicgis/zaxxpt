package com.hnatourism.club.member.order.action;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.helper.flight.OrderFlightSearchResponseMessage;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.flight.web.vo.OrderDetailVo;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.hotel.api.service.IHotelNewApiManager;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderResultVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:个人订单管理
 * 
 * 历史版本: 2011-8-10 v1.0.0 (lixun) 创建
 * 
 */
public class MemberOrderAction extends BaseAction {

	private static final String ERROR = "error";
	private static final String SUCCESS = "success";

	// 酒店订单查询api,酒店需要调用的外部接口
	private IHotelNewApiManager hotelNewApiManager;

	// //查询订单状态 废弃
	// private String sts;
	// 个人休息室订单列表
	private List<OrderLoungeVo> loungeOrders = new ArrayList<OrderLoungeVo>();
	// 高尔夫订单列表
	private List<GolfOrderVo> golfOrders = new ArrayList<GolfOrderVo>();
	// 机票订单列表
	private List<OrderDetailVo> flightOrders = new ArrayList<OrderDetailVo>();
	// // 酒店订单列表
	// private List<HotelOrderVo> hotelOrders = new ArrayList<HotelOrderVo>();
	// 错误提示信息
	private String errorInfo;

	// 需要返回的tab也的序列
	private int tabIndex;

	// private

	/**
	 * 
	 * @description 查询订单,主要用于控制个人中心查询的跳转
	 * @return
	 * @createTime 2011-8-10 上午10:34:06
	 * @author lixun
	 */
	public String showOrderHome() {
		try {
			// HttpSession
			// session=ServletActionContext.getRequest().getSession();
			// if(session.getAttribute("memberId")==null&&session.getAttribute("memid_d")==null){
			if (UserUtil.getUser(getSession().getId()) == null) {
				return "notlogin";
			}
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @description 异步查询机票
	 * @return
	 * @createTime 2011-8-13 上午11:43:35
	 * @author lixun
	 */
	public String ajaxTableFlightOrderAction() {
		// TODO 功能尚未实现
		try {
			MemberInfoVo user = UserUtil.getUser(getSession().getId());
			if (user == null) {
				return "notlogin";
			}
			Type type = new TypeToken<List<OrderDetailVo>>() {
			}.getType();
			String jsonStr = ApiClient.getHtml(Constants.API_SERVER_FLIGHT
					+ "/web/phone/order/flight/orderFlightSearch.jsp?memberId="
					+ user.getId());
			OrderFlightSearchResponseMessage orderFlightSearchResponseMessage = new OrderFlightSearchResponseMessage();
			orderFlightSearchResponseMessage.parseResponse(jsonStr);
			flightOrders = orderFlightSearchResponseMessage
					.getOrderDetailList();
			return SUCCESS;
		} catch (Exception e) {
			log.error("机票订单查询失败");
			errorInfo = "抱歉! 机票订单查询失败,请刷新重试...";
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @description 异步查询酒店
	 * @return
	 * @createTime 2011-8-13 上午11:44:03
	 * @author lixun
	 */
	public String ajaxTableHotelOrderAction() {
		log.info("MemberOrderAction.ajaxTableHotelOrderAction()");
		try {
			MemberInfoVo user = UserUtil.getUser(getSession().getId());
			if (user == null) {
				return "notlogin";
			}
			HotelOrderQueryVo queryVo = new HotelOrderQueryVo();
			// QueryHotelOrderVo queryVo = new QueryHotelOrderVo();
			// queryVo.setMemberId(user.getId());
			// hotelOrders = hotelApiManager.findHotelOrderList(queryVo);
			queryVo.setMemberid(user.getId());
			HotelOrderResultVo hotelOrderResultVo=hotelNewApiManager.findOrderList(queryVo);
			if(hotelOrderResultVo==null|| "SEARCH.ERROR.H10000".equals(hotelOrderResultVo.getResult().getResultCode())){
				errorInfo = "抱歉! 酒店订单查询失败,请刷新重试...";
			}else {
				getRequest().setAttribute("hotelOrders", hotelOrderResultVo.getResultList());
			}
			queryVo=null;
			return SUCCESS;
		} catch (Exception e) {
			log.error("酒店订单查询失败");
			errorInfo = "抱歉! 酒店订单查询失败,请刷新重试...";
			return SUCCESS;
			// return ERROR;
		}
	}

	/**
	 * 
	 * @description 异步查询高尔夫订单
	 * @return
	 * @createTime 2011-8-12 下午03:10:07
	 * @author lixun
	 */

	public String ajaxTableGolfOrderAction() {
		log.info("MemberOrderAction.ajaxTableGolfOrderAction()");
		try {
			MemberInfoVo user = UserUtil.getUser(getSession().getId());
			if (user == null) {
				return "notlogin";
			}
			// 在action中调用接口
			Type type = new TypeToken<List<GolfOrderVo>>() {
			}.getType();
			// 查询的订单转台
			String jsonStr = ApiClient
					.getHtml("/api/apiServer.action?method=api_findAllOrder&&memberCode="
							+ user.getCode());
			golfOrders = (List<GolfOrderVo>) GsonUtil.jsonToObject(jsonStr,
					type);
			return SUCCESS;
		} catch (Exception e) {
			log.error("高尔夫订单查询失败");
			errorInfo = "抱歉! 高尔夫订单查询失败,请刷新重试...";
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @description 异步查询休息室订单
	 * @return
	 * @createTime 2011-8-13 上午11:34:45
	 * @author lixun
	 */
	@SuppressWarnings("unchecked")
	public String ajaxTableLoungeOrderAction() {
		log.info("MemberOrderAction.ajaxTableLoungeOrderAction()");
		try {
			MemberInfoVo user = UserUtil.getUser(getSession().getId());
			if (user == null) {
				return "notlogin";
			}
			Type type = new TypeToken<List<OrderLoungeVo>>() {
			}.getType();
			String jsonStr = ApiClient
					.getHtml("/api/apiServer.action?method=findLoungeOrder&&memberId="
							+ user.getId());
			loungeOrders = (List<OrderLoungeVo>) GsonUtil.jsonToObject(jsonStr,
					type);
			return SUCCESS;
		} catch (Exception e) {
			log.error("机场休息室订单查询失败");
			errorInfo = "抱歉! 机场休息室订单查询失败,请刷新重试...";
			return SUCCESS;
		}
	}

	// setter & getter
	private static Object jsonToObjectAndFormat(String json, Type type) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		return gson.fromJson(json, type);
	}

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		// Date date=new Date("Oct 09, 2011 06:00:00 AM");
		Date date = null;
		try {
			date = dateFormat.parse("2010年10月10日");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
		System.out.println(dateFormat.format(date));
	}

	// public IHotelApiManager getHotelApiManager() {
	// return hotelApiManager;
	// }
	//
	// public void setHotelApiManager(IHotelApiManager hotelApiManager) {
	// this.hotelApiManager = hotelApiManager;
	// }

	public List<GolfOrderVo> getGolfOrders() {
		return golfOrders;
	}

	public List<OrderLoungeVo> getLoungeOrders() {
		return loungeOrders;
	}

	public void setLoungeOrders(List<OrderLoungeVo> loungeOrders) {
		this.loungeOrders = loungeOrders;
	}

	public void setGolfOrders(List<GolfOrderVo> golfOrders) {
		this.golfOrders = golfOrders;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	public int getTabIndex() {
		return tabIndex;
	}

	public List<OrderDetailVo> getFlightOrders() {
		return flightOrders;
	}

	public void setFlightOrders(List<OrderDetailVo> flightOrders) {
		this.flightOrders = flightOrders;
	}

	public IHotelNewApiManager getHotelNewApiManager() {
		return hotelNewApiManager;
	}

	public void setHotelNewApiManager(IHotelNewApiManager hotelNewApiManager) {
		this.hotelNewApiManager = hotelNewApiManager;
	}

	// public List<HotelOrderVo> getHotelOrders() {
	// return hotelOrders;
	// }
	//
	// public void setHotelOrders(List<HotelOrderVo> hotelOrders) {
	// this.hotelOrders = hotelOrders;
	// }

	// setter & getter end

}
