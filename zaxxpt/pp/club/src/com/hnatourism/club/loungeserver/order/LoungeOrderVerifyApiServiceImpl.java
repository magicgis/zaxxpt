package com.hnatourism.club.loungeserver.order;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.common.util.SubRunUtils;
import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.club.lounge.order.dao.ILogLoungeOrderDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeExceptionDao;
import com.hnatourism.club.lounge.order.dao.IOrderLoungeGuestDao;
import com.hnatourism.club.lounge.order.domain.LogLoungeOrder;
import com.hnatourism.club.lounge.order.domain.OrderLounge;
import com.hnatourism.club.lounge.order.domain.OrderLoungeException;
import com.hnatourism.club.lounge.order.domain.OrderLoungeGuest;
import com.hnatourism.club.lounge.prod.dao.ILoungeRoomDao;
import com.hnatourism.club.lounge.prod.domain.LoungeRoom;
import com.hnatourism.club.loungeserver.LoungeApiService;
import com.hnatourism.club.pay.IPayInterfaceApiServer;
import com.hnatourism.club.pay.PayVo;
import com.hnatourism.club.personal.member.service.IOrderBillService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.product.base.dao.IProdCaptchaDao;
import com.hnatourism.club.product.base.domain.ProdCaptcha;
import com.hnatourism.framework.utils.PropertiesUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:休息室订单状态确认
 * 
 * 历史版本: 2011-9-8 v1.0.0 (lixun) 创建
 * 
 */
public class LoungeOrderVerifyApiServiceImpl extends LoungeApiService implements
		ILoungeOrderVerifyApiService {

	private ILogLoungeOrderDao logLoungeOrderDao;
	private IOrderLoungeDao orderLoungeDao;
	private IOrderLoungeExceptionDao orderLoungeExceptionDao;
	private IOrderBillService orderBillService;
	private IPayInterfaceApiServer payInterfaceApiServerImpl;
	private IOrderLoungeGuestDao orderLoungeGuestDao;
	private ILoungeRoomDao loungeRoomDao;
	private IProdCaptchaDao prodCaptchaDao;

	/**
	 * 等待会员确认
	 */
	public static final String ORDER_STATUS_TEN="10";
	/**
	 * 待客服确认
	 */
	public static final String ORDER_STATUS_ONE="1";
	public static final String ORDER_STATUS_ELEVEN="11";
	@Override
	public void endHandler() {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		Map<String, Object> permeMap = (Map<String, Object>) super.permeters;
		PayVo payvo=new PayVo();
		try {
			LogLoungeOrder logLoungeOrder = new LogLoungeOrder();
			if ("N".equals(permeMap.get("type"))) {
				// 正常订单
				OrderLounge orderLounge = orderLoungeDao.findById(permeMap.get("id").toString());
				//需求修改为两舱或贵宾间直接分润
				if(ORDER_STATUS_ONE.equals(orderLounge.getSts())){
					//2舱直接支付+分润
					LoungeRoom lr=loungeRoomDao.findById(orderLounge.getRoomId());
					if(lr.getType().equalsIgnoreCase("3"))
					{
						String sellerNo=orderLoungeDao.getSellerNoByOrderId(orderLounge.getId()); ///分销商分润账户     order_lounge    lounge_room    lounge_info   member_account   account
						String subCorpNo=orderLoungeDao.getSubCorpNoByOrderId(orderLounge.getId());//分公司分润账户
						MemberAccountVo accountAndCardNo = orderLoungeDao.getAccountAndCardNo(orderLounge.getId());
						String fromAccount=accountAndCardNo.getCardNo();	//现金来源账户
						OrderLoungeGuest ole=new OrderLoungeGuest();
						ole.setOrderId(orderLounge.getId());
						Integer pepleCount=orderLoungeGuestDao.findByWhere(ole).size();
						
						float price=orderLounge.getPrice().floatValue();		//总价
						float signprice=orderLounge.getSignPrice().floatValue();	//底价
						String type=orderLounge.getProfit();		//直减1 返积分2
						float exPrice=orderLounge.getAdditionalFee().floatValue();		//附加价格
						
						
						//调用计算方法
						SubRunBean subRunBean = new SubRunBean();

						subRunBean.setRoleCode(permeMap.get("rolecode").toString());
						subRunBean.setProdType("L");
						subRunBean.setPrivilegeType(type);
						subRunBean.setOrderSignprice(Double.valueOf(signprice*pepleCount));
						subRunBean.setOrderPrice(Double.valueOf(price));
						subRunBean.setOrderExPrice(Double.valueOf(exPrice));
						subRunBean.setOrderRetPrice(Double.valueOf(orderLounge.getProfitAmount()));
						subRunBean.setSellerCardNo(sellerNo);
						subRunBean.setPlatformAccount(PropertiesUtils.getVal("sysProps","platformAccount"));
						subRunBean.setSubCorpAccount(subCorpNo);
						subRunBean.setAccount(accountAndCardNo.getAccount());//谷建亮  修改获取用户分润账号
						subRunBean.setOrderCode(orderLounge.getCode());
						subRunBean.setOrderType("N");
						subRunBean.setCardNo(fromAccount);
						subRunBean.setAttPepoLowPrice(Double.valueOf(orderLoungeDao.getSignPriceOfOrderLongeGuest(orderLounge.getId()).getAdditionalSignPrice()));
						subRunBean.setAttOrderLowPrice(Double.valueOf(orderLounge.getAdditionalSignPrice()));
						subRunBean.setOrderId(orderLounge.getId());
						
						subRunBean = SubRunUtils.profitMoney(subRunBean);
						
						//插入orderbill表
						orderBillService.insertOrderBill(subRunBean,permeMap.get("createUser").toString());
						//调用支付接口
						
						try {
							payvo = payInterfaceApiServerImpl.payUrl(fromAccount,
									orderLounge.getCode(),
									SubRunUtils.doubleHandler(subRunBean.getOrderPrice().toString(), 2),
									subRunBean.getSellerDetail(),
									subRunBean.getDetails(),PropertiesUtils.getVal("payInterface","payCallBackUrl"));
						} catch (Exception e) {
							throw new Exception("payError");
						}
						String result= payvo.getRespCode();
						if("000000".equals(result) || "SUCCESS".equals(result)){
							super.returnObj = "success";
							
							// 生成验证码
							ProdCaptcha prodCaptcha = new ProdCaptcha();
							prodCaptcha.setId(SnoGerUtil.getUUID());
							prodCaptcha.setCode(SnoGerUtil.getCaptchaCode());
							prodCaptcha.setCreateTime(DateUtils.getCurrentDate());
							prodCaptcha.setMemberId(orderLounge.getMemberId());
							prodCaptcha.setOrderCode(orderLounge.getCode());
							prodCaptcha.setType("L");
							prodCaptcha.setSts("0");
							prodCaptcha.setCreateUser(permeMap.get("memberCode").toString());
							prodCaptchaDao.insert(prodCaptcha);

							logLoungeOrder.setId(SnoGerUtil.getUUID());
							logLoungeOrder.setContent(Constants.OrderLogInfo.ORDER_SUCCESS);
							logLoungeOrder.setType("2");
							logLoungeOrder.setOrderId(orderLounge.getId());// 设置订单ID
							logLoungeOrder.setCreateTime(DateUtils.getCurrentDate());
							logLoungeOrder.setCreateUser(permeMap.get("memberCode").toString());
							logLoungeOrderDao.insert(logLoungeOrder);
							// 支付状态改为已支付
							orderLounge.setPaySts("1");
							orderLounge.setSts("2");
							// 处理完订单之后要把该订单解锁
							orderLounge.setOperateSts("0");
							// 更新订单状态
							orderLoungeDao.update(orderLounge);
						}else{
							throw new Exception("payError");
						}
					}
					else
					{
						orderLounge.setSts(ORDER_STATUS_ELEVEN);
					}
					
//					orderLounge.setCreateTime(new Date());
//					orderLounge.setCreateUser(permeMap.get("createUser").toString());
//					orderLoungeDao.update(orderLounge);
//					logLoungeOrder.setOrderId(orderLounge.getId());
//					logLoungeOrder.setContent("会员确认订单!");
//					logLoungeOrder.setCreateUser(permeMap.get("createUser").toString());
//					insertLog(logLoungeOrder);
					
				}else {
					super.returnObj = "该订单处于不可确认状态";
				}
			} else if ("E".equals(permeMap.get("type"))) {
				// 异常订单
				OrderLoungeException ole = orderLoungeExceptionDao
						.findById(permeMap.get("id").toString());
				
				if(ORDER_STATUS_TEN.equals(ole.getSts())){
					ole.setUpdateTime(new Date());
					ole.setUpdateUser(permeMap.get("createUser").toString());
					ole.setSts(ORDER_STATUS_ELEVEN);
					orderLoungeExceptionDao.update(ole);
					logLoungeOrder.setCreateUser(permeMap.get("createUser").toString());
					logLoungeOrder.setCreateTime(new Date());
					logLoungeOrder.setOrderId(ole.getOrderId());//张晓春修改.正常订单ID
					logLoungeOrder.setContent("会员已确认订单!");
					insertLog(logLoungeOrder);
				}else {
					super.returnObj = "该订单处于不可确认状态";
				}
			} else {
				super.returnObj = "发生系统错误！！！！";
			}
			// 记录日志
			super.returnObj = "success";
		} catch (Exception e) {
			e.printStackTrace();
			if("payError".equalsIgnoreCase(e.getMessage())){System.out.println(payvo.getErrMsg());
				super.returnObj = payvo.getErrMsg();
			}else {
				super.returnObj = "发生系统错误！！！！";
			}
		}

	}

	
	@Override
	public void init(Object permeters, Type type) {
		super.permeters = permeters;
		super.type = type;
	}

	@Override
	public void parameterHandler() throws Exception {
		super.permeters = ParameterHandler.urlPremeter2Map(String.valueOf(super.permeters));
	}

	@Override
	public Object getResult() {
		return super.returnObj;
	}

	/**
	 * 
	 * @description 【更新日志】
	 * @createTime 2011-9-8 下午03:47:44
	 * @author lixun
	 */
	private void insertLog(LogLoungeOrder logLoungeOrder){
		logLoungeOrder.setType("正常");
		logLoungeOrder.setId(UUID.randomUUID().toString().replace("-", ""));
		logLoungeOrder.setCreateTime(new Date());
//		logLoungeOrder.setUpdateUser("");
//		logLoungeOrder.setUpdateTime();
		logLoungeOrderDao.insert(logLoungeOrder);
	}
	// setter && getter

	public ILogLoungeOrderDao getLogLoungeOrderDao() {
		return logLoungeOrderDao;
	}

	public void setLogLoungeOrderDao(ILogLoungeOrderDao logLoungeOrderDao) {
		this.logLoungeOrderDao = logLoungeOrderDao;
	}

	public IOrderLoungeDao getOrderLoungeDao() {
		return orderLoungeDao;
	}

	public void setOrderLoungeDao(IOrderLoungeDao orderLoungeDao) {
		this.orderLoungeDao = orderLoungeDao;
	}

	public void setOrderLoungeExceptionDao(
			IOrderLoungeExceptionDao orderLoungeExceptionDao) {
		this.orderLoungeExceptionDao = orderLoungeExceptionDao;
	}

	public IOrderLoungeExceptionDao getOrderLoungeExceptionDao() {
		return orderLoungeExceptionDao;
	}

	public void setOrderBillService(IOrderBillService orderBillService) {
		this.orderBillService = orderBillService;
	}

	public void setPayInterfaceApiServerImpl(
			IPayInterfaceApiServer payInterfaceApiServerImpl) {
		this.payInterfaceApiServerImpl = payInterfaceApiServerImpl;
	}

	public void setOrderLoungeGuestDao(IOrderLoungeGuestDao orderLoungeGuestDao) {
		this.orderLoungeGuestDao = orderLoungeGuestDao;
	}

	public void setLoungeRoomDao(ILoungeRoomDao loungeRoomDao) {
		this.loungeRoomDao = loungeRoomDao;
	}

	public void setProdCaptchaDao(IProdCaptchaDao prodCaptchaDao) {
		this.prodCaptchaDao = prodCaptchaDao;
	}

	// setter && getter end
}
