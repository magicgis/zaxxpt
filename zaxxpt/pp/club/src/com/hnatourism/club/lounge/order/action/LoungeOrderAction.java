package com.hnatourism.club.lounge.order.action;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.lounge.order.dao.impl.OrderLoungeExceptionDaoImpl;
import com.hnatourism.club.lounge.order.service.IOrderLoungeGuestService;
import com.hnatourism.club.lounge.order.vo.LogLoungeOrderVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeExceptionVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeGuestVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:休息室订单
 * 
 * 历史版本: 2011-8-16 v1.0.0 (lixun) 创建
 * 
 */
public class LoungeOrderAction extends BaseAction {

	private String id;
	// private String action;
	private OrderLoungeVo orderLoungeVo;
	private IMemberInfoService memberInfoServ;
	// 是否显示 退改按钮
	private Boolean isShowRM = false;

	private String type;
	// 用于直接接受时间的字符串，不用vo中的属性，因为vo的属性默认会直接转换格式
	private String startTime;
	private String endTime;
	//用于显示贵宾间小时数
	private long hours;
	
	private String msg;

	private static String resultMsg="";
	///////////////LOR 代表lounge _ order _room
	/**
	 * 贵宾间
	 */
	public static final String LOR_TYPE_VIPROOM = "1";
	/**
	 * 贵宾厅
	 */
	public static final String LOR_TYPE_VIPHALL = "2";
	/**
	 * 两舱休息室
	 */
	public static final String LOR_TYPE_CAPSULE = "3";

	//休息室顾客表
	private IOrderLoungeGuestService orderLoungeGuestServiceImpl;
	//休息室订单状态操作结果编码L =lounge,o=option,m=messagecode
	/**
	 * 订单日志
	 */
	private List<LogLoungeOrderVo> logLoungeOrderVoList;

	/**
	 * 
	 * @description 【确认休息室订单】
	 * @return
	 * @createTime 2011-9-8 下午12:03:03
	 * @author lixun
	 */
	public String verifyLoungeOrder() {
		try {
			HttpSession session = getSession();
			if (UserUtil.getUser(session.getId()) == null
					&& session.getAttribute("memid_d") == null) {
				return "notlogin";
			}
			
			MemberInfoVo member=UserUtil.getUser(session.getId());
			
			resultMsg=ApiClient
					.getHtml("/api/apiServer.action?method=verifyLoungeOrder&&id="
							+ orderLoungeVo.getId() + "&&type=" + type
							+"&&createUser="+session.getAttribute("createUser").toString()
							+"&&rolecode="+member.getMemberAccount().getMemberRole().getCode()
							+"&&memberCode="+member.getCode());
			return "viewDetail";
		} catch (Exception e) {
			log.error("休息室订单确认失败@LoungeOrderAction.verifyLoungeOrder()",e);
			return "viewDetail";
		}
	}

	/**
	 * 
	 * @description 取消订单
	 * @return
	 * @createTime 2011-8-15 下午07:49:44
	 * @author lixun
	 */
	public String cancelLoungeOrder() {
		try {
			if (UserUtil.getUser(getSession().getId()) == null) {
				return "notlogin";
			}
			resultMsg=ApiClient
					.getHtml("/api/apiServer.action?method=cancelLoungeOrder&&id="
							+ id);
			return "viewDetail";
		} catch (Exception e) {
			// 订单取消失败
			log.error("订单取消失败", e);
			return "error";
		}
	}

	/**
	 * 
	 * @description 查看订单详情
	 * @return
	 * @createTime 2011-8-15 下午08:20:55
	 * @author lixun
	 */
	public String viewOrderDetail() {
		msg=resultMsg;
		resultMsg="";
		try {
			if (UserUtil.getUser(getSession().getId()) == null) {
				return "notlogin";
			}
			// "method=findLoungeOrderDetail?"
			Type type = new TypeToken<OrderLoungeVo>() {
			}.getType();
			String jsonStr = ApiClient
					.getHtml("/api/apiServer.action?method=findLoungeOrderDetail&&id="
							+ id);
			orderLoungeVo = (OrderLoungeVo) GsonUtil
					.jsonToObject(jsonStr, type);
			if("1".equals(orderLoungeVo.getLoungeRoomVo().getType())){
				hours=LoungeOrderAction.compareDateTime(orderLoungeVo.getStartTime(), orderLoungeVo.getEndTime());
			}
			// 按钮显示控制
			// 主订单状态为预订成功,并且未消费的订单才能申请退改
			if ("2".equals(orderLoungeVo.getSts())&& "0".equals(orderLoungeVo.getConsumerSts())) {
				// 处于异常状态
				if (orderLoungeVo.getLoungeExceptionVoList() != null
						&& orderLoungeVo.getLoungeExceptionVoList().size() > 0) {
					// 当前的异常订单
					OrderLoungeExceptionVo exceptionVo = orderLoungeVo
							.getLoungeExceptionVoList().get(0);
					if (!"4".equals(exceptionVo.getSts())
							&& !"7".equals(exceptionVo.getSts())
							&& !"10".equals(exceptionVo.getSts())
							&& !"11".equals(exceptionVo.getSts())) {
						isShowRM = true;
					}
					if(isShowRM){
						//假定不能退改,如果有人员处于可与退改退改状态就进行退改的显示
						isShowRM=!isShowRM;
						for(OrderLoungeGuestVo guestVo:orderLoungeVo.getOrderLoungeGuestVoList()){
							if("0".equals(guestVo.getConsumerSts())){
								isShowRM=!isShowRM;
								break;
							}
						}
					}
				}else {
					isShowRM = true;
				}

			}
			startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm")
				.format(new Date(System.currentTimeMillis()));
			//获得日志
			logLoungeOrderVoList = orderLoungeVo.getLogLoungeOrderVoList();//将日志赋值
			return "view";
			
		} catch (Exception e) {
			// 查看订单详情失败
			e.printStackTrace();
			log.error("查看休息室订单详情失败@LoungeOrderAction.viewOrderDetail()",e);
			return "view";
		}
	}

	/**
	 * 
	 * @description 退订订单
	 * @return
	 * @createTime 2011-8-17 下午04:20:46
	 * @author lixun
	 */
	public String unsubscribeOrder() {
		try {
			if (UserUtil.getUser(getSession().getId()) == null) {
				return "notlogin";
			}

			if (LOR_TYPE_VIPROOM.equals(orderLoungeVo.getLoungeRoomVo()
					.getType())) {
				// 如果是贵宾间就不传"&&guestIds="+guestIds人数的值
				resultMsg=ApiClient
						.getHtml("/api/apiServer.action?method=unsubscribeLoungeOrder&&id="
								+ orderLoungeVo.getId()
								+ "&&rmk="
								+ orderLoungeVo.getRmk()
								+ "&&createUser="
								+ getSession().getAttribute("createUser").toString());
			} else {
				// 如果是贵宾厅或二舱就要传这个改的人员参数了。
				String guestIds = "";
				String additionalItemIds = "";
				if (orderLoungeVo.getGuestIdArray() != null) {
					for (String str : orderLoungeVo.getGuestIdArray()) {
						guestIds = guestIds + str + ",";
					}
				}
				if (orderLoungeVo.getAdditionalItemIds() != null) {
					for (String str : orderLoungeVo.getAdditionalItemIds()) {
						additionalItemIds = additionalItemIds + str + ",";
					}
				}

				resultMsg=ApiClient
						.getHtml("/api/apiServer.action?method=unsubscribeLoungeOrder&&id="
								+ orderLoungeVo.getId()
								+ "&&rmk="
								+ orderLoungeVo.getRmk()
								+ "&&createUser="
								+ getSession().getAttribute("createUser").toString()
								+ "&&guestIds="
								+ guestIds
								+ "&&additionalItemId="
								+ additionalItemIds
								+ "&&operateSts=0");
			}
			// 返回到详情页面
			// return viewOrderDetail();
			return "viewDetail";
		} catch (Exception e) {
			// 查看订单详情失败
			log.error("退订休息室订单失败@LoungeOrderAction.unsubscribeOrder()",e);
			return "error";
		}
	}

	/**
	 * 
	 * @description 修改订单
	 * @return
	 * @createTime 2011-8-17 下午04:21:32
	 * @author lixun
	 */
	public String changeOrder() {
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			if (UserUtil.getUser(getSession().getId())== null) {
				return "notlogin";
			}
			String guestIds = "";
			if (orderLoungeVo.getGuestIdArray() != null) {
				for (String str : orderLoungeVo.getGuestIdArray()) {
					guestIds = guestIds + str + ",";
				}
			}
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
			 String startTime=sf.format(orderLoungeVo.getStartTime());
			 String endTimeStr="";
			 if(orderLoungeVo.getEndTime()!=null){
				 endTimeStr="&&endTime="+sf.format(orderLoungeVo.getEndTime());
			 }
			 resultMsg=ApiClient
					.getHtml("/api/apiServer.action?method=rescheduleLoungeOrder&&id="
							+ orderLoungeVo.getId()
							+ "&&startTime="
							+ startTime
							+endTimeStr
							+ "&&createUser="
							+ session.getAttribute("createUser").toString()
							+ "&&guestIds=" + guestIds + "&&operateSts=0");
			// 返回订单详情
			// return viewOrderDetail();
			return "viewDetail";
		} catch (Exception e) {
			// 查看订单详情失败
			log.error("修改休息室订单失败@LoungeOrderAction.changeOrder()",e);
			return "viewDetail";
		}
		// return "success";
	}

	
	///////////////////////////////辅助方法
	public static long compareDateTime(Date startDate,Date endDate){
		return  (endDate.getTime()-startDate.getTime())/3600000;
	}
	// setter && getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OrderLoungeVo getOrderLoungeVo() {
		return orderLoungeVo;
	}

	public void setOrderLoungeVo(OrderLoungeVo orderLoungeVo) {
		this.orderLoungeVo = orderLoungeVo;
	}

	public IMemberInfoService getMemberInfoServ() {
		return memberInfoServ;
	}

	public Boolean getIsShowRM() {
		return isShowRM;
	}

	public void setIsShowRM(Boolean isShowRM) {
		this.isShowRM = isShowRM;
	}

	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}

	// public String getAction() {
	// return action;
	// }
	//
	// public void setAction(String action) {
	// this.action = action;
	// }

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getHours() {
		return hours;
	}

	public List<LogLoungeOrderVo> getLogLoungeOrderVoList() {
		return logLoungeOrderVoList;
	}

	public void setLogLoungeOrderVoList(List<LogLoungeOrderVo> logLoungeOrderVoList) {
		this.logLoungeOrderVoList = logLoungeOrderVoList;
	}

	public IOrderLoungeGuestService getOrderLoungeGuestServiceImpl() {
		return orderLoungeGuestServiceImpl;
	}

	public void setOrderLoungeGuestServiceImpl(
			IOrderLoungeGuestService orderLoungeGuestServiceImpl) {
		this.orderLoungeGuestServiceImpl = orderLoungeGuestServiceImpl;
	}

	
	
	// setter && getter end

}
