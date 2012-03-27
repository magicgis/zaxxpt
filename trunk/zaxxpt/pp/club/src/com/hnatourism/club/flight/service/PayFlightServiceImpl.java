package com.hnatourism.club.flight.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.helper.flight.OrderFlightDetailResponseMessage;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.pay.PayInterfaceApiServerImpl;
import com.hnatourism.club.pay.PayVo;
import com.hnatourism.club.pay.order.service.IOrderBillService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.utils.StringUtils;
//add by wuyuhu
public class PayFlightServiceImpl {
		private static final Log log = LogFactory.getLog(PayFlightServiceImpl.class);
		//定单服务
		private IOrderBillService orderBill2Service;
		// 支付服务
		private PayInterfaceApiServerImpl ipay;
		
	/*
	 * 通过订单id分润
	 */
	public String profitPay(OrderFlightDetailResponseMessage orderFlightDetailResponseMessage,MemberInfoVo memberInfoVo)  {
		String retStr = "";
		try{
		if(!"00".equals(orderFlightDetailResponseMessage.getSts())){
			return "此订单不可能支付";
		}
		// 取得订单表
		if (!StringUtils.isEmpty(orderFlightDetailResponseMessage.getCode())) {
			// 取得memberinfo
			if (null != memberInfoVo) {
				//账户类信息
				MemberAccountVo memberAccount = memberInfoVo.getMemberAccount();
				//分公司信息
				MemberAccountVo cropAccount=memberInfoVo.getMemberCropAccount();
				// 取得account
				if (memberAccount != null && cropAccount !=null) {
					//设置订单的总底价
					double allSignPrice = 0.0;
					allSignPrice = orderFlightDetailResponseMessage.getTotalTicketPricePar().doubleValue();
					//log.info("打印底价》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》"+allSignPrice);
					//调用role表
					MemberRoleVo memberRole_domain = memberAccount.getMemberRole();
					//调用计算方法
					SubRunBean subRunBean = new SubRunBean();
					//用户托管账户
					subRunBean.setCardNo(memberAccount.getCardNo());
					//用户角色code
					subRunBean.setRoleCode(memberRole_domain.getCode());
					//产品类型
					subRunBean.setProdType("F");
					//直减
					subRunBean.setPrivilegeType("1");
					//成本价
					subRunBean.setOrderSignprice(allSignPrice);
					//订单总价
					subRunBean.setOrderPrice(Double.parseDouble(orderFlightDetailResponseMessage.getTotalMoney()));
					//附加总价
					subRunBean.setOrderExPrice(orderFlightDetailResponseMessage.getTotalConstructionFee().doubleValue()+orderFlightDetailResponseMessage.getTotalBaf().doubleValue());
					//按单附加费总和
					subRunBean.setAttOrderLowPrice(orderFlightDetailResponseMessage.getTotalConstructionFee().doubleValue()+orderFlightDetailResponseMessage.getTotalBaf().doubleValue());
					// 判断非空
					//log.info("打印保险价格》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》"+orderFlightDetailResponseMessage.getTotalinsurance());
					if(StringUtils.isNotBlank(orderFlightDetailResponseMessage.getTotalinsurance())
							&& !"null".equals(orderFlightDetailResponseMessage.getTotalinsurance())){
						//log.info("判断非空》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》"+orderFlightDetailResponseMessage.getTotalinsurance());
						subRunBean.setAttOrderLowPrice(orderFlightDetailResponseMessage.getTotalConstructionFee().doubleValue()+orderFlightDetailResponseMessage.getTotalBaf().doubleValue()+Double.parseDouble(orderFlightDetailResponseMessage.getTotalinsurance()));
						subRunBean.setOrderExPrice(orderFlightDetailResponseMessage.getTotalConstructionFee().doubleValue()+orderFlightDetailResponseMessage.getTotalBaf().doubleValue()+Double.parseDouble(orderFlightDetailResponseMessage.getTotalinsurance()));
					}
					String source=orderFlightDetailResponseMessage.getOutBookingFlight().getFlightOrigin();
					if("GW".equalsIgnoreCase(source)){
						source=PropertiesUtils.getVal("sysProps","platformAccount_GW");
					}
					else if("B2B".equalsIgnoreCase(source)){
						source=PropertiesUtils.getVal("sysProps","platformAccount_B2B");
					}
					else{
						source=PropertiesUtils.getVal("sysProps","platformAccount_PEK");
					}
					//供应商账户
					subRunBean.setSellerCardNo(source);
					//平台分润账户
					subRunBean.setPlatformAccount(PropertiesUtils.getVal("sysProps","platformAccount"));
					//分公司分润账户
					subRunBean.setSubCorpAccount(cropAccount.getAccount());
					//反积分用户账户
					subRunBean.setAccount(memberAccount.getAccount());
					//订单code
					subRunBean.setOrderCode(orderFlightDetailResponseMessage.getCode());
					//订单Id
					subRunBean.setOrderId(orderFlightDetailResponseMessage.getOrderId());
					//正常订单
					subRunBean.setOrderType("N");
					//按人附加费总和
					subRunBean.setAttPepoLowPrice(Double.valueOf(0));
					subRunBean = SubRunUtils.profitMoney(subRunBean);
					initialize();
					//插入orderbill表
					orderBill2Service.insertOrderBill(subRunBean,memberInfoVo);
					//调用支付接口
					PayVo payvo=new PayVo();
					payvo = ipay.payUrl(memberAccount.getCardNo(),
								orderFlightDetailResponseMessage.getCode(),
								SubRunUtils.doubleHandler(subRunBean
										.getOrderPrice().toString(), 2),
								subRunBean.getSellerDetail(), subRunBean
										.getDetails(), PropertiesUtils.getVal(
										"payInterface", "payCallBackUrl"));
						retStr = payvo.getRespCode();
					log.error("分润正常结束："+payvo.getErrMsg());
				}
			}
			log.error("分润正常结束："+retStr);
			////System.out.println("分润正常结束："+retStr);
			}
		}
			catch(Exception e){
			log.error("分润异常结束！",e);
		}
			return retStr;
	}
	// 初始化
	private void initialize() {
		try {
			// jdbc
			if (null == orderBill2Service) {
				orderBill2Service = (IOrderBillService) BeanUtils
						.getBeanObj("orderBill2Service");
			}
		} catch (Exception e) {
			// 初始化失败
			log.debug("机票支付接口失败");
		}
	}
	public IOrderBillService getOrderBill2Service() {
		return orderBill2Service;
	}
	public void setOrderBill2Service(IOrderBillService orderBill2Service) {
		this.orderBill2Service = orderBill2Service;
	}
	public static Log getLog() {
		return log;
	}
	public PayInterfaceApiServerImpl getIpay() {
		return ipay;
	}
	public void setIpay(PayInterfaceApiServerImpl ipay) {
		this.ipay = ipay;
	}
}
