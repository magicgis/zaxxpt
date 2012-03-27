/**
 * 
 */
package com.hnatourism.club.golf.order.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.golf.log.dao.ILogGolfOrderDao;
import com.hnatourism.club.golf.order.dao.IOrderGlofDao;
import com.hnatourism.club.golf.order.service.IOrderGolfSubRunService;
import com.hnatourism.club.golf.order.vo.GolfOrderLogVo;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.pay.IPayInterfaceApiServer;
import com.hnatourism.club.pay.PayVo;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.dao.IMemberInfoDao;
import com.hnatourism.club.personal.member.dao.IMemberRoleDao;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.domain.MemberInfo;
import com.hnatourism.club.personal.member.domain.MemberRole;
import com.hnatourism.club.personal.member.service.IOrderBillService;
import com.hnatourism.club.product.base.dao.IProdCaptchaDao;
import com.hnatourism.club.product.base.domain.ProdCaptcha;
import com.hnatourism.framework.utils.PropertiesUtils;


/**
 * @author gujianliang
 * @2011-9-19
 */
public class OrderGolfSubRunServiceImpl implements IOrderGolfSubRunService{

	private static final Log log = LogFactory.getLog(OrderGolfSubRunServiceImpl.class);
	private IProdCaptchaDao prodCaptchaDao;
	private ILogGolfOrderDao logGolfOrderDao;
	private IMemberInfoDao memberInfoDao;
	private IMemberAccountDao memberAccountDao;
	private IMemberRoleDao memberRoleDao;
	private IOrderBillService orderBillService;
	private IOrderGlofDao orderGlofDao;
	private IPayInterfaceApiServer payServer;
	
	/**
	 * 
	 * @description 支付分润
	 * @see com.hnatourism.club.golf.order.service.IOrderGolfSubRunService#payAndSubRun(java.lang.String, java.lang.String)
	 * @createTime
	 * @author 
	 */
	@Override
	public PayVo payAndSubRun(String orderId,String createUser) {
		// 关联场地
		GolfOrderVo glof = new GolfOrderVo();
		glof = orderGlofDao.findById(orderId);
		DateUtils date= new DateUtils();
		Date currentTime = date.getCurrentDate();
		// 订单日志domain
		GolfOrderLogVo logGolfOrder= new GolfOrderLogVo();
		
		//支付成功调用分润
		PayVo payVo = profitPay(orderId,createUser);
		  if(("SUCCESS").equals(payVo.getRespCode())){
			// 消费验证码
			ProdCaptcha prodCaptcha = new ProdCaptcha();
			prodCaptcha.setId(SnoGerUtil.getUUID());
			prodCaptcha.setCode(SnoGerUtil.getCaptchaCode());
			prodCaptcha.setCreateTime(DateUtils.getCurrentDate());
			prodCaptcha.setMemberId(glof.getMemberCode());
			prodCaptcha.setOrderCode(glof.getCode());
			prodCaptcha.setType("GF");
			prodCaptcha.setSts("0");
			prodCaptcha.setCreateUser(createUser);
			prodCaptchaDao.insert(prodCaptcha);

			glof.setPaySts("1");//支付状态-->支付成功
			glof.setSts("2");   //订单状态-->预定成功
			glof.setOperateSts("0");//锁定状态-->未锁定
			orderGlofDao.update(glof);

			//前台预定时已经减去了相应的预定球数
			//预定成功暂时不用
			logGolfOrder.setId(SnoGerUtil.getUUID());
			logGolfOrder.setContent(Constants.OrderLogInfo.ORDER_SUCCESS);
			logGolfOrder.setOrderId(orderId);// 设置订单ID
			logGolfOrder.setType("2");
			logGolfOrder.setCreateUser(createUser);
			logGolfOrder.setCreateTime(currentTime);
			logGolfOrderDao.insert(logGolfOrder);
			//return  true; //处理完成
		  }
//		  else{
//			  return false;
//		  }
		return payVo;
	}

	/*
	 * 通过订单id分润
	 */
	public PayVo profitPay(String orderId,String createUser)  {
//		String retStr = "";
		PayVo payvo=null;
		try{
		
		GolfOrderVo orderGlof = orderGlofDao.findById(orderId);
		// 取得订单表
		if (orderGlof != null) {
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setCode(orderGlof.getMemberCode());
			List<MemberInfo> list = memberInfoDao.findByWhere(memberInfo);
			// 取得memberinfo
			if (list != null && list.size() > 0) {
				memberInfo = new MemberInfo();
				memberInfo = list.get(0);
				MemberAccount memberAccount = new MemberAccount();
				memberAccount.setMemberId(memberInfo.getId());
				List<MemberAccount> list_account = memberAccountDao
						.findByWhere(memberAccount);
				// 取得account
				if (list_account != null && list_account.size() > 0) {
					memberAccount = new MemberAccount();
					memberAccount = list_account.get(0);
					//设置订单的总底价
					double allSignPrice = 0.0;
					if(orderGlof.getTotalBall() == 0){//球场
						allSignPrice = orderGlof.getSignPrice()*orderGlof.getCount();
					}else{
						allSignPrice = orderGlof.getSignPrice()*orderGlof.getTotalBall()*100;
					}
					//调用role表
					MemberRole memberRole_domain = new MemberRole();
					memberRole_domain = memberRoleDao.findById(memberAccount.getRole());
//					//取得政企会员的分润比例
//					String rateGMember = "";
//					RuleConfig ruleConfig = new RuleConfig();
//					ruleConfig.setCode("I_GF_PROFIT_RATE_"+memberAccount.getOrganizationId());
//					List<RuleConfig> list_ruleConfig = ruleConfigDao.findByWhere(ruleConfig);
//					if(list_ruleConfig != null && list_ruleConfig.size()>0){
//						ruleConfig = list_ruleConfig.get(0);
//						rateGMember = ruleConfig.getValue();
//					}else{
//						ruleConfig.setCode("I_GF_PROFIT_RATE_");
//						List<RuleConfig> list_rule = ruleConfigDao.findByWhere(ruleConfig);
//						ruleConfig = list_ruleConfig.get(0);
//						rateGMember = ruleConfig.getValue();
//					}
					//调用计算方法
					SubRunBean subRunBean = new SubRunBean();
					subRunBean.setCardNo(memberAccount.getCardNo());//卡号
					subRunBean.setRoleCode(memberRole_domain.getCode());//角色
					subRunBean.setProdType("GF"); //产品类型 .
					subRunBean.setPrivilegeType(orderGlof.getProfit());//直减1 返积分2
					subRunBean.setOrderRetPrice(orderGlof.getProfitAmount().doubleValue());//返积分钱数
					subRunBean.setOrderSignprice(allSignPrice);//底价
					subRunBean.setOrderPrice(orderGlof.getPrice().doubleValue());//订单金额
					subRunBean.setOrderExPrice(orderGlof.getAdditionalFee().doubleValue());//附加价格总和
					subRunBean.setSellerCardNo(orderGlofDao.getSellerNoByOrderId(orderId));//产品提供商账户     DB
					subRunBean.setPlatformAccount(PropertiesUtils.getVal("sysProps","platformAccount"));////平台分润账户
					subRunBean.setSubCorpAccount(orderGlofDao.getSubCorpNoByOrderId(orderId)); //分公司分润账户
					subRunBean.setAccount(memberAccount.getAccount());//用户分润账户
					subRunBean.setOrderCode(orderGlof.getCode());//订单号
					subRunBean.setOrderId(orderId);//订单ID
					subRunBean.setOrderType("N");//订单type
					subRunBean.setAttPepoLowPrice(Double.valueOf(0));
					subRunBean.setAttOrderLowPrice(Double.valueOf(0));					
					subRunBean = SubRunUtils.profitMoney(subRunBean);

					//插入orderbill表
					orderBillService.insertOrderBill(subRunBean,createUser);
					//调用支付接口
					payvo=new PayVo();
					payvo = payServer.payUrl(memberAccount.getCardNo(),//卡号
							orderGlof.getCode(),//订单号
							SubRunUtils.doubleHandler(subRunBean.getOrderPrice().toString(), 2),
							subRunBean.getSellerDetail(),//产品提供商 
							subRunBean.getDetails(),//分润详细
							PropertiesUtils.getVal("payInterface","payCallBackUrl"));
//					retStr = payvo.getRespCode();
				}
			}
		}
//		log.info("分润正常结束："+retStr);
//		return retStr;
		}catch(Exception e){
			log.info("分润异常结束！"+payvo.getRespCode());
		}
		return payvo;
	}

	public IProdCaptchaDao getProdCaptchaDao() {
		return prodCaptchaDao;
	}

	public void setProdCaptchaDao(IProdCaptchaDao prodCaptchaDao) {
		this.prodCaptchaDao = prodCaptchaDao;
	}

	public ILogGolfOrderDao getLogGolfOrderDao() {
		return logGolfOrderDao;
	}

	public void setLogGolfOrderDao(ILogGolfOrderDao logGolfOrderDao) {
		this.logGolfOrderDao = logGolfOrderDao;
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

	public IMemberRoleDao getMemberRoleDao() {
		return memberRoleDao;
	}

	public void setMemberRoleDao(IMemberRoleDao memberRoleDao) {
		this.memberRoleDao = memberRoleDao;
	}

	public IOrderBillService getOrderBillService() {
		return orderBillService;
	}

	public void setOrderBillService(IOrderBillService orderBillService) {
		this.orderBillService = orderBillService;
	}

	public IOrderGlofDao getOrderGlofDao() {
		return orderGlofDao;
	}

	public void setOrderGlofDao(IOrderGlofDao orderGlofDao) {
		this.orderGlofDao = orderGlofDao;
	}

	public IPayInterfaceApiServer getPayServer() {
		return payServer;
	}

	public void setPayServer(IPayInterfaceApiServer payServer) {
		this.payServer = payServer;
	}
	
	
}
