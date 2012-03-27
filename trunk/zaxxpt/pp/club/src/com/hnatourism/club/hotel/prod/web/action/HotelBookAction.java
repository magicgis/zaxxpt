package com.hnatourism.club.hotel.prod.web.action;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.hotel.api.service.IHotelNewApiManager;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelBookResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelBookVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelDetailsBaseVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelDetailsQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelDetailsResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelGuaranteeQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelGuaranteeResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailsReusltVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailsVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomBaseInfoVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomRateVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomResultVo;
import com.hnatourism.club.hotel.prod.web.vo.HotelReturnMessage;
import com.hnatourism.club.hotel.prod.web.vo.Passenger;
import com.hnatourism.club.hotel.prod.web.vo.Result;
import com.hnatourism.club.personal.member.service.IOrderBillService;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberPassengerVo;
import com.hnatourism.club.personal.member.web.vo.OrderBillVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转到酒店预订页
 * 
 * 历史版本: ${2011.9.5} v1.0.0 (高杰) 创建
 * 
 */
public class HotelBookAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 酒店新版接口
	 */
	private IHotelNewApiManager hotelNewApiManager;

	// 新api 酒店详情vo
	private HotelDetailsBaseVo hotel;
	// 新api HotelRoomRateVo 房型房价
	private List<HotelRoomRateVo> rateVos;
	private String hcode;
	private String rcode;
	private String city;
	private String idate;
	private String odate;
	private String adate;
	private String rmk;
	private int Room;// 与页面对应，不能改，否则页面的JS无效
	private String pname;
	private Long signPrice;
	private String contactName;
	private String contactPhone;
	private String contactEmail;
	private long date_distance;
	private MemberInfoVo member;
	private List<MemberPassengerVo> passengerlist;

	private String orderCode;
	private String orderId;
	private Long amountPrice;
	private String message;
	// 房型计划编码 新增加的
	private String roomPlanCode;
	// 页面显示用 预订房型
	private String roomName;
	// 佣金比例
	private String customCommission;
	// 城市code来源
	private String citySource;
	// 支付类型
	private String payType;
	/**
	 * 账单服务
	 */
	private IOrderBillService orderBillService;

	/**
	 * @description 【跳转到酒店预订】
	 * @return
	 * @createTime 2011-11-15 下午03:31:11
	 * @author zhanghan
	 */
	public String toBook() {
		try {
			if (UserUtil.getUser(getSession().getId()) == null) {
				// session.setAttribute("backlink", "hotelbook");
				return "notlogin";
			} else {
				member = UserUtil.getUser(getSession().getId());
			}

			// 常旅客 查询改为查询c站数据库 调用接口
			// 调接口返回数据 字符串
			String serverIP = Constants.API_SERVER_XHLX;
			String returnStr = ApiClient
					.getHtml(serverIP
							+ "/web/phone/prod/flight/memberPassengerSearch.jsp?memberId="
							+ member.getId());
			log
					.info("url:"
							+ serverIP
							+ "/web/phone/prod/flight/memberPassengerSearch.jsp?memberId="
							+ member.getId());
			// 获取 HotelReturnMessage类型
			Type type_hotel = new TypeToken<HotelReturnMessage>() {
			}.getType();
			// 将字符串转换成对象
			HotelReturnMessage hotelReturnMessage = null;
			try {
				hotelReturnMessage = (HotelReturnMessage) GsonUtil
						.jsonToObject(returnStr, type_hotel);
			} catch (Exception e) {
				hotelReturnMessage = new HotelReturnMessage();
				Result result = new Result();
				result.setResultCode("NULL");
				hotelReturnMessage.setResult(result);
				log.error("网络异常,返回结果错误：", e);
			}
			// 判断是否获取成功
			if (hotelReturnMessage.getResult().getResultCode() == null
					|| hotelReturnMessage.getResult().getResultCode()
							.equals("")) {
				// 成功 获取常用旅客list
				passengerlist = new ArrayList<MemberPassengerVo>();
				List<Passenger> list = hotelReturnMessage.getPassenger();
				for (Passenger temp : list) {
					MemberPassengerVo vo = new MemberPassengerVo();
					vo.setId(temp.getId());
					vo.setName(temp.getName());
					vo.setType(temp.getType());
					vo.setCertNo(temp.getCertNo());
					vo.setCertType(temp.getCertType());
					// 增加到list
					passengerlist.add(vo);
				}
			}

			// 声明
			Calendar icalendar = Calendar.getInstance();
			Calendar ocalendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// 酒店信息 新api
			HotelDetailsQueryVo qryVo = new HotelDetailsQueryVo();
			qryVo.setHotelCode(hcode);
			qryVo.setIdate(idate);
			qryVo.setOdate(odate);
			HotelDetailsResultVo rsVo = hotelNewApiManager
					.findHotelDetails(qryVo);
			// GC
			qryVo = null;

			hotel = rsVo.getResultBean().getHotel();// 酒店基本信息
			// city = rsVo.getResultBean().getCitycode();//酒店所属城市code
			// 取海航的citycode

			// 房间列表
			HotelRoomQueryVo qryRoomVo = new HotelRoomQueryVo();
			qryRoomVo.setCity(city);
			qryRoomVo.setHotelCode(hcode);
			qryRoomVo.setIdate(idate);
			qryRoomVo.setOdate(odate);
			if (!StringUtils.isBlank(citySource)) {
				qryRoomVo.setCitySource(citySource);// 设置城市code来源
			}
			HotelRoomResultVo rsRoom = hotelNewApiManager
					.findHotelRoomList(qryRoomVo);
			// GC
			qryRoomVo = null;

			// resultBean
			for (HotelRoomBaseInfoVo temp : rsRoom.getResultBean()) {
				// 匹配所订的房型 根据roomPlanCode 去匹配，点击预订的时候需要把roomPlanCode传递过来
				if (temp.getRoomPlanCode().equals(roomPlanCode)) {
					roomName = temp.getName();
					payType = temp.getPayType();
					rateVos = temp.getRateList();
					rcode = temp.getCode();// 获取房间code 提交订单需要
					break;
				}
			}
			// 计算分润价格
			calculateSalePrice(rateVos);
			icalendar.setTime(sdf.parse(idate));
			ocalendar.setTime(sdf.parse(odate));
			// //86400000 =一天的毫秒数
			date_distance = ((ocalendar.getTimeInMillis() - icalendar
					.getTimeInMillis()) / 86400000);
		} catch (Exception e) {
			log.error("", e);
		}
		return "success";
	}

	/**
	 * @description 【酒店预订】
	 * @return
	 * @createTime 2011-11-15 下午03:31:42
	 * @author zhanghan
	 */
	public String bookHotel() {
		try {
			// 取客户信息
			// MemberAccountVo memberAccount = null;
			// MemberRoleVo memberRole = null;
			if (UserUtil.getUser(getSession().getId()) == null) {
				return "notlogin";
			} else {
				member = UserUtil.getUser(getSession().getId());
				if (member.getMemberAccount() == null) {
					return "notlogin";
				}

				// memberRole = memberAccount.getMemberRole();
			}

			// 新版api 预订参数设置
			HotelBookVo bookVo = new HotelBookVo();
			bookVo.setMemberId(member.getId());
			bookVo.setIsFirst("0");// 是否是新用户预订，1为是，0为否 俱乐部的应该全都是0，必须登录才能预订，存在账号
			bookVo.setRmk(rmk);
			bookVo.setTotalMoney(amountPrice.toString());
			bookVo.setHcode(hcode);// 酒店编码
			bookVo.setRcode(rcode);// 房型编码
			bookVo.setIdate(idate);
			bookVo.setOdate(odate);
			bookVo.setAdate(adate);
			bookVo.setPnum(Room);
			// 联系人参数
			bookVo.setPname(pname.replace(", ", ","));
			bookVo.setContact_name(contactName);
			bookVo.setContact_mobile(contactPhone);
			bookVo.setContact_email(contactEmail);
			bookVo.setContact_phone(contactPhone);
			// 发票
			bookVo.setInvoice_needtype("N");// 是否需要发票 Y 是 ，N否

			bookVo.setRoomPlanCode(roomPlanCode);// 必填 房型计划编码
			bookVo.setPayType(payType);// 必填 支付类型:1-现付,2-预付 暂时用预付，俱乐部 应该是都可以预订的！

			// if ("1".equals(payType)) {
			// payTypeProcess(bookVo);// 预付现付处理
			// }

			//
			// bookVo.setPayType("2");//暂时写为预付确保订单生成
			// 计算 渠道自定义佣金比例 (总价-优惠价)/总价
			// 总价 没有分润的销售价*天数*房间数
			// Double t = tempPrice;// * date_distance;
			// 比例
			// Double rate = (tempPrice - amountPrice) / tempPrice;

			bookVo.setCustomCommission(customCommission);// TODO 必填 渠道自定义佣金比例
			// 应该从哪去取？

			HotelBookResultVo rsVo = hotelNewApiManager.bookHotel(bookVo);
			// 判断调用接口是否成功
			if (null != rsVo) {// 调接口成功
				// 如果消息为空 则预定成功
				if (StringUtils.isEmpty(rsVo.getResult().getMessage())) {
					orderCode = rsVo.getResultBean().getCode();
					// orderId=rsVo.getResultBean().getOrderId(); //没有这个返回参数
					amountPrice = Long.parseLong(rsVo.getResultBean()
							.getTotalMoney());
					// 酒店信息
					MemberInfoVo user = UserUtil.getUser(getSession().getId());
					HotelOrderDetailQueryVo qryVo = new HotelOrderDetailQueryVo();
					qryVo.setCode(orderCode);
					qryVo.setKey(Constants.CLUB_ORDER_SOURCE);// 必选 key
					// 新华旅行网分配的唯一授权码
					// 必填 51666

					HotelOrderDetailsReusltVo hotelOrderDetailsReusltVo = hotelNewApiManager
							.findOrderDetails(qryVo);

					getSession().setAttribute("hotelOrderDetailsVo",
							hotelOrderDetailsReusltVo);

					// 预订成 账单表插入相应数据 参数：会员账号 订单vo
					// 2011-11-22 zhanghan 注释掉 此处不需要生成账单表 在订单确认之后再生成账单表
					// addOrderBill(memberAccount.getCardNo(),hotelOrderDetailsReusltVo.getResultBean());

				} else// 消息不为空 预订失败
				{
					orderId = "";
					orderCode = "";
					amountPrice = 0l;
					log.error(rsVo.getResult().getMessage());
					getSession().setAttribute("hotelErrorMessage", "预订酒店失败");
				}
			} else {// 调接口失败
				getSession().setAttribute("hotelErrorMessage", "timeout");
			}
		} catch (Exception e) {
			orderId = "";
			orderCode = "";
			amountPrice = 0l;
			getSession().setAttribute("hotelErrorMessage", "网络异常，预订酒店失败！");
			// 输出错误日志 修改 lixun editDate 2011-10-13 14:48
			log.error("预订酒店失败", e);
		}

		return "success";
	}

	/**
	 * @description 【订单预订成功生成账单表数据】
	 * @param cardNo
	 * @param resultBean
	 * @createTime 2011-11-18 下午01:18:48
	 * @author zhanghan
	 * @throws BusinessException
	 */
	private void addOrderBill(String cardNo, HotelOrderDetailsVo resultBean)
			throws BusinessException {
		OrderBillVo billVo = new OrderBillVo();
		billVo.setType("chinapnr");// 俱乐部 都是chinapnr
		billVo.setAccount(cardNo);
		// billVo.setTradeNo();//没交易 没有交易号
		// billVo.setTradeTime(tradeTime);
		billVo.setAmount(Double.parseDouble(resultBean.getTotalMoney()));
		billVo.setOrderType("N");
		billVo.setOrderId(resultBean.getOrderId());
		billVo.setProdType("L");
		billVo.setOrderCode(resultBean.getCode());
		billVo.setTransactionType("0");// 消费
		billVo.setStatus("00");// 状态(00:未支付,01:支付成功,02:支付失败,03:审核中)
		billVo.setRmk("新预订酒店账单数据");
		orderBillService.myInsert(billVo, UserUtil
				.getUser(getSession().getId()));
	}

	private SubRunBean getSubRunBean() {
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

	// 价格计算
	private void calculateSalePrice(List<HotelRoomRateVo> rateVos) {
		// 判断是否直减标志
		boolean isMINUS = member == null
				|| member.getMemberAccount().getPrivilegeType() == null
				|| member.getMemberAccount().getPrivilegeType()
						.equalsIgnoreCase("MINUS");
		// 计算分润
		SubRunBean subRunBean = getSubRunBean();
		// customCommission
		Double tempPrice = 0.0D;
		Double tempTotalPrice = 0.0D;
		if (!ListUtils.isEmpty(rateVos)) {
			for (HotelRoomRateVo rateVo : rateVos) {
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
				tempPrice += Double.parseDouble(rateVo.getSalePrice());
				tempTotalPrice += salePrice;
			}
			BigDecimal oldPrice = new BigDecimal(tempPrice);
			BigDecimal newPrice = new BigDecimal(tempTotalPrice);
			customCommission = oldPrice.subtract(newPrice).divide(oldPrice, 3,
					BigDecimal.ROUND_CEILING).toString();
		}
	}

	// 酒店预付现付处理
	private void payTypeProcess(HotelBookVo bookVo) throws Exception {
		HotelGuaranteeQueryVo queryVo = new HotelGuaranteeQueryVo();
		queryVo.setHotelCode(hcode);
		queryVo.setRoomPlanCode(roomPlanCode);
		queryVo.setCheckInDate(idate);
		queryVo.setCheckOutDate(odate);
		queryVo.setRoomAmount(bookVo.getPnum() + "");
		String[] adates = adate.split("-");
		queryVo.setArriveDate(adates[0]);
		queryVo.setLastArriveDate(adates[1]);
		HotelGuaranteeResultVo gResultVo = hotelNewApiManager
				.findBookGuarantee(queryVo);
		// if (gResultVo.getResultBean() != null) {
		// if ("1".equals(gResultVo.getResultBean())) {

		bookVo.setCredit_name(PropertiesUtils.getVal("payInterface",
				"creditName"));
		bookVo.setCredit_cardNum(PropertiesUtils.getVal("payInterface",
				"creditCardNum"));
		bookVo.setCredit_cardType(PropertiesUtils.getVal("payInterface",
				"creditCardType"));
		bookVo.setCredit_expireDate(PropertiesUtils.getVal("payInterface",
				"creditExpireDate"));
		bookVo.setCredit_idNum(PropertiesUtils.getVal("payInterface",
				"creditIdNum"));
		bookVo.setCredit_idType(PropertiesUtils.getVal("payInterface",
				"creditIdType"));
		// }
		// }
		// gc
		adates = null;
		gResultVo = null;
		queryVo = null;
	}

	public String showHotelContract() {
		return "success";
	}

	/**
	 * @return the hotel
	 */
	public HotelDetailsBaseVo getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 *            the hotel to set
	 */
	public void setHotel(HotelDetailsBaseVo hotel) {
		this.hotel = hotel;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public long getDate_distance() {
		return date_distance;
	}

	public void setDate_distance(long dateDistance) {
		date_distance = dateDistance;
	}

	public MemberInfoVo getMember() {
		return member;
	}

	public void setMember(MemberInfoVo member) {
		this.member = member;
	}

	public List<MemberPassengerVo> getPassengerlist() {
		return passengerlist;
	}

	public void setPassengerlist(List<MemberPassengerVo> passengerlist) {
		this.passengerlist = passengerlist;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public int getRoom() {
		return Room;
	}

	public void setRoom(int Room) {
		this.Room = Room;
	}

	/**
	 * @return the roomPlanCode
	 */
	public String getRoomPlanCode() {
		return roomPlanCode;
	}

	/**
	 * @param roomPlanCode
	 *            the roomPlanCode to set
	 */
	public void setRoomPlanCode(String roomPlanCode) {
		this.roomPlanCode = roomPlanCode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * @param roomName
	 *            the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	/**
	 * @return the orderBillService
	 */
	public IOrderBillService getOrderBillService() {
		return orderBillService;
	}

	/**
	 * @param orderBillService
	 *            the orderBillService to set
	 */
	public void setOrderBillService(IOrderBillService orderBillService) {
		this.orderBillService = orderBillService;
	}

	/**
	 * @return the citySource
	 */
	public String getCitySource() {
		return citySource;
	}

	/**
	 * @param citySource
	 *            the citySource to set
	 */
	public void setCitySource(String citySource) {
		this.citySource = citySource;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getHcode() {
		return hcode;
	}

	public void setHcode(String hcode) {
		this.hcode = hcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Long getAmountPrice() {
		return amountPrice;
	}

	public void setAmountPrice(Long amountPrice) {
		this.amountPrice = amountPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<HotelRoomRateVo> getRateVos() {
		return rateVos;
	}

	public void setRateVos(List<HotelRoomRateVo> rateVos) {
		this.rateVos = rateVos;
	}

	public Long getSignPrice() {
		return signPrice;
	}

	public void setSignPrice(Long signPrice) {
		this.signPrice = signPrice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	/**
	 * @return the hotelNewApiManager
	 */
	public IHotelNewApiManager getHotelNewApiManager() {
		return hotelNewApiManager;
	}

	/**
	 * @param hotelNewApiManager
	 *            the hotelNewApiManager to set
	 */
	public void setHotelNewApiManager(IHotelNewApiManager hotelNewApiManager) {
		this.hotelNewApiManager = hotelNewApiManager;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getCustomCommission() {
		return customCommission;
	}

	public void setCustomCommission(String customCommission) {
		this.customCommission = customCommission;
	}

	public long getTotalPrice() {
		Long temp = 0L;
		if (!ListUtils.isEmpty(rateVos)) {
			for (HotelRoomRateVo rateVo : rateVos) {
				temp += Long.valueOf(rateVo.getSalePrice());
			}
		}
		return temp;
	}
}
