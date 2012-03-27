package com.hnatourism.club.hotel.api.service.impl;

import java.net.ConnectException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.util.RuleConfigProfit;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.hotel.api.service.IHotelNewApiManager;
import com.hnatourism.club.hotel.api.service.IHotelOrderService;
import com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailsReusltVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderDetailsVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderStsUpdateResultVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelOrderStsUpdateVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomBaseInfoVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomQueryVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomRateVo;
import com.hnatourism.club.hotel.prod.web.newapivo.HotelRoomResultVo;
import com.hnatourism.club.pay.IPayInterfaceApiServer;
import com.hnatourism.club.pay.PayVo;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.dao.IMemberInfoDao;
import com.hnatourism.club.personal.member.dao.IMemberRoleDao;
import com.hnatourism.club.personal.member.service.IOrderBillService;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.OrderBillVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.PropertiesUtils;

/**
 * @author 苏忆 20110905
 */
public class HotelOrderServiceImpl implements IHotelOrderService {

	private static final Log log = LogFactory
			.getLog(HotelOrderServiceImpl.class);

	private IPayInterfaceApiServer payInterfaceApiServer;
	private IHotelNewApiManager hotelNewApiManager;
	private IMemberInfoDao memberInfoDao;
	private IMemberAccountDao memberAccountDao;
	private IOrderBillService orderBillService;
	private IMemberRoleDao memberRoleDao;

	/**
	 * 
	 * @description 【请添加描述】
	 * @see com.hnatourism.club.hotel.api.service.IHotelOrderService#verifyHotelOrder(com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo)
	 * @createTime 2011-10-8 下午05:43:53
	 * @author lixun
	 */
	@Override
	public String verifyHotelOrder(QueryHotelOrderVo queryVo,
			MemberInfoVo member, String createUser) throws BusinessException {
		String retStr = "";
		String result = "确认订单失败";
		HotelOrderDetailsVo hotelOrderDetailsVo = null;
		try {
			// 查出订单详情
			HotelOrderDetailQueryVo detailQueryVo = new HotelOrderDetailQueryVo();
			detailQueryVo.setCode(queryVo.getCode());
			HotelOrderDetailsReusltVo detailReusltVo = hotelNewApiManager
					.findOrderDetails(detailQueryVo);

			if (detailReusltVo == null
					|| detailReusltVo.getResultBean() == null) {
				throw new BusinessException("", "订单详情查询失败");
			}
			hotelOrderDetailsVo = detailReusltVo.getResultBean();
			// 查询房型取得低价
			HotelRoomQueryVo roomQueryVo = new HotelRoomQueryVo();
			roomQueryVo.setHotelCode(hotelOrderDetailsVo.getHcode());
			roomQueryVo.setCitySource("hbe");
			roomQueryVo.setIdate(hotelOrderDetailsVo.getIdate());
			roomQueryVo.setOdate(hotelOrderDetailsVo.getOdate());

			// log.info("---hotelNewApiManager.findHotelRoomList(roomQueryVo)------");
			HotelRoomResultVo roomResultVo = hotelNewApiManager
					.findHotelRoomList(roomQueryVo);

			List<HotelRoomRateVo> targetRateVos = null;
			if (roomResultVo != null
					&& !ListUtils.isEmpty(roomResultVo.getResultBean())) {
				List<HotelRoomBaseInfoVo> roomBaseInfoVos = roomResultVo
						.getResultBean();
				for (HotelRoomBaseInfoVo baseInfoVo : roomBaseInfoVos) {
					if (hotelOrderDetailsVo.getRcode().equals(
							baseInfoVo.getCode())) {
						targetRateVos = baseInfoVo.getRateList();
						break;
					}
				}
			}
			// log.info("---targetRateVos----111--");
			if (targetRateVos != null) {
				// log.info("---targetRateVos--2222----");
				// 计算低价
				Double orderSignpriceD = 0.0D;
				for (HotelRoomRateVo rateVo : targetRateVos) {
					Double temp = Double.valueOf(rateVo.getSalePrice());
					Double channelCostPrice = Double.valueOf(rateVo
							.getChannelCostPrice());
					temp = temp - temp
							* Constants.HotelBookConstants.HOTEL_MEMBER_POINT;
					if (temp < channelCostPrice) {
						channelCostPrice = temp;
					}
					orderSignpriceD += channelCostPrice;
				}
				orderSignpriceD *= Integer.parseInt(hotelOrderDetailsVo
						.getRnum());

				String privilegeType = "1";
				if (member.getMemberAccount().getPrivilegeType() != null
						&& member.getMemberAccount().getPrivilegeType()
								.equalsIgnoreCase("return")) {
					privilegeType = "2";
				}
				// 计算分润
				SubRunBean subRunBean = new SubRunBean();
				// subRunBean 传入参数 AttPepoLowPrice-单收费项目按人收费项低价费用总和,
				subRunBean.setAttPepoLowPrice(0D);
				// AttOrderLowPrice 单收费项目按单收费项低价费用总和,
				subRunBean.setAttOrderLowPrice(0D);
				// roleCode 用户code
				subRunBean.setRoleCode(member.getMemberAccount()
						.getMemberRole().getCode());
				// ,prodType 产品类型
				subRunBean.setProdType("H");
				// ,privilegeType 直减或返积分标识1为直减2返积分
				subRunBean.setPrivilegeType(privilegeType);
				// ,orderSignprice 订单产品签约价总价,
				subRunBean.setOrderSignprice(orderSignpriceD);
				// orderPrice 订单总价,
				subRunBean.setOrderPrice(Double.valueOf(hotelOrderDetailsVo
						.getTotalMoney()));
				// orderExPrice 附加项总价,
				subRunBean.setOrderExPrice(0D);
				// sellerCardNo 产品提供商帐号,
				subRunBean.setSellerCardNo(PropertiesUtils.getVal("sysProps",
						"platformAccount_HBE"));
				// platformAccount 平台帐号,
				subRunBean.setPlatformAccount(PropertiesUtils.getVal(
						"sysProps", "platformAccount"));
				// subCorpAccount 分公司帐号,
				subRunBean.setSubCorpAccount(member.getMemberCropAccount()
						.getAccount());
				// account 个人分润帐号
				subRunBean.setAccount(member.getMemberAccount().getAccount());

				if (!privilegeType.equalsIgnoreCase("1")) {
					if (member.getMemberAccount().getMemberRole().getCode()
							.equalsIgnoreCase("GOVERNMENT")) {
						Map<String, String> rule_result = RuleConfigProfit
								.setRuleParam("H", member.getRuleConfigList(),
										member.getMemberAccount()
												.getOrganizationId());
						subRunBean.setSubCorpPoint(Double
								.parseDouble(rule_result.get("subCorpPoint")));
						subRunBean.setPlatformPoint(Double
								.parseDouble(rule_result.get("platformPoint")));
						subRunBean.setProfitpoint(rule_result
								.get("profitpoint"));
						subRunBean.setMemberFlowpoint(rule_result
								.get("memberFlowpoint"));
					}
				}
				// 计算分润
				subRunBean = SubRunUtils.profitMoney(subRunBean);
				subRunBean.setOrderCode(hotelOrderDetailsVo.getCode());// 订单号
				subRunBean.setOrderId(hotelOrderDetailsVo.getOrderId());// 订单ID
				subRunBean.setOrderType("N");// 订单type。N,普通
				subRunBean.setCardNo(member.getMemberAccount().getCardNo());
				// 插入orderbill表
				orderBillService.insertOrderBill(subRunBean, createUser);
				// 调用支付接口
				PayVo payvo = new PayVo();
				// log.info(subRunBean.getSellerDetail()+"产品提供商");
				// log.info(subRunBean.getDetails()+"分润详细");
				// log.info(PropertiesUtils.getVal("payInterface","payCallBackUrl")+"回调");
				payvo = payInterfaceApiServer.payUrl(member.getMemberAccount()
						.getCardNo(),// 卡号
						hotelOrderDetailsVo.getCode(),// 订单号
						SubRunUtils.doubleHandler(hotelOrderDetailsVo
								.getTotalMoney(), 2), subRunBean
								.getSellerDetail(),// 产品提供商
						subRunBean.getDetails(),// 分润详细
						PropertiesUtils
								.getVal("payInterface", "payCallBackUrl"));
				retStr = payvo.getRespCode();
				// log.info("分润结束......retStr="+retStr +
				// ",payvo.getErrMsg="+payvo.getErrMsg());
				if ("SUCCESS".equals(retStr)) {
					if (updateOrderSts(hotelOrderDetailsVo, member)) {
						result = "确认订单成功";
					}
				} else {
					if ("该订单已经支付!".equalsIgnoreCase(payvo.getErrMsg())) {
						whenPayError(hotelOrderDetailsVo, member, result);
					} else {
						result = payvo.getErrMsg();
					}
				}
			}
			return result;
		} catch (ConnectException e) {
			log.error("网络连接异常", e);
			result = "确认订单时网络超时";
			return result;
		} catch (Exception e) {
			log.error("确认订单失败", e);
			result = "确认订单失败";
			return result;
		}
	}

	/**
	 * 
	 * @description 更新酒店订单状态为已支付
	 * @param orderDetailsVo
	 * @param member
	 * @return
	 * @createTime 2011-11-22 下午07:15:26
	 * @author lixun
	 */
	private boolean updateOrderSts(HotelOrderDetailsVo orderDetailsVo,
			MemberInfoVo member) {
		boolean flag = false;
		HotelOrderStsUpdateVo updateVo = new HotelOrderStsUpdateVo();
		updateVo.setMemberid(member.getId());
		updateVo.setOrderCode(orderDetailsVo.getCode());
		updateVo.setPaySts("YZF");
		HotelOrderStsUpdateResultVo resultVo = hotelNewApiManager
				.updateOrderStatus(updateVo);
		if (resultVo != null && resultVo.getResult() != null
				&& resultVo.getResult().getResultCode() != null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * @description 当支付分润结束并且失败时进行处理
	 * @param detailReusltVo
	 *            订单详情
	 * @param member
	 *            会员信息
	 * @param result
	 *            返回结果
	 * @createTime 2011-11-23 上午09:57:52
	 * @author lixun
	 */
	private void whenPayError(final HotelOrderDetailsVo hotelOrderDetailsVo,
			MemberInfoVo member, String result) throws Exception {
		// 查询账单表
		OrderBillVo domain = new OrderBillVo();
		domain.setOrderCode(hotelOrderDetailsVo.getCode());
		domain.setType("H");
		// domain.setStatus("01");
		if (!ListUtils.isEmpty(orderBillService.findByWhere(domain))) {
			// 如果账单表操作成功则尝试重新更新订单状态
			if (updateOrderSts(hotelOrderDetailsVo, member)) {
				result = "确认订单成功";
			} else {
				result = "修改订单状态失败";
			}
		}
	}

	public IPayInterfaceApiServer getPayInterfaceApiServer() {
		return payInterfaceApiServer;
	}

	public void setPayInterfaceApiServer(
			IPayInterfaceApiServer payInterfaceApiServer) {
		this.payInterfaceApiServer = payInterfaceApiServer;
	}

	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}

	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
	}

	public IOrderBillService getOrderBillService() {
		return orderBillService;
	}

	public void setOrderBillService(IOrderBillService orderBillService) {
		this.orderBillService = orderBillService;
	}

	public IMemberRoleDao getMemberRoleDao() {
		return memberRoleDao;
	}

	public void setMemberRoleDao(IMemberRoleDao memberRoleDao) {
		this.memberRoleDao = memberRoleDao;
	}

	public IHotelNewApiManager getHotelNewApiManager() {
		return hotelNewApiManager;
	}

	public void setHotelNewApiManager(IHotelNewApiManager hotelNewApiManager) {
		this.hotelNewApiManager = hotelNewApiManager;
	}

}
