package com.hnatourism.club.hotel.api.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.Constants;
import com.hnatourism.club.hotel.api.service.HotelRequestHelper;
import com.hnatourism.club.hotel.api.service.IHotelApiManager;
import com.hnatourism.club.hotel.order.vo.HotelOrderDetailsVo;
import com.hnatourism.club.hotel.order.vo.HotelOrderVo;
import com.hnatourism.club.hotel.order.vo.OrderResultVo;
import com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo;
import com.hnatourism.club.hotel.prod.web.vo.HotelVo;
import com.hnatourism.club.hotel.prod.web.vo.QryHotelVo;
import com.hnatourism.framework.core.service.AbstractService;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店接口管理实现类
 * 
 * 历史版本: 2011-08-09 v1.0.0
 * 
 */
public class HotelApiManagerImpl extends AbstractService implements
		IHotelApiManager {
	/**
	 *  日志
	 */
	private static final Log log = LogFactory.getLog(HotelApiManagerImpl.class);
	
	/**
	 * 查询酒店详细信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public HotelVo findHotelDetail(QryHotelVo qryHotelVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_DETAIL;
		StringBuffer params = new StringBuffer();
//		params.append("origin=").append(qryHotelVo.getOrigin());
		params.append("hotelCode=").append(qryHotelVo.getHotelCode());
		params.append("&idate=").append(qryHotelVo.getIdate());
		params.append("&odate=").append(qryHotelVo.getOdate());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		
		// 调用接口取得返回数据
		HotelVo hotelVo = (HotelVo)HotelRequestHelper.findObjectByApi(urlStr,params,HotelVo.class);
		
		// 返回
		return hotelVo;
	}
	/**
	 * 查询酒店列表信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public String findHotelList(QryHotelVo qryHotelVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_SEARCH;
		StringBuffer params = new StringBuffer();
		String jsonStr = new String();
		
		params.append("city=").append(qryHotelVo.getCitycode());
		params.append("&idate=").append(qryHotelVo.getIdate());
		params.append("&odate=").append(qryHotelVo.getOdate());
		params.append("&citySource=hbe");
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);

		if(qryHotelVo.getHotelname() != null && !qryHotelVo.getHotelname().trim().equals("")){
			params.append("&name=");
			params.append(qryHotelVo.getHotelname());
		}
		if(qryHotelVo.getPrice() != null && !qryHotelVo.getPrice().trim().equals("")){
			params.append("&price=");
			params.append(qryHotelVo.getPrice());
		}
		if(qryHotelVo.getStar() != null && !qryHotelVo.getStar().trim().equals("")){
			params.append("&star=");
			params.append(qryHotelVo.getStar());
		}
		// B2C城市查询
		params.append("&cityType=").append(qryHotelVo.getCityType());
		
		jsonStr = HotelRequestHelper.connection(urlStr,params);
		// 调用接口取得返回数据
		return jsonStr;
	}
	/**
	 * 查询酒店房型列表信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public String findRoomList(QryHotelVo qryHotelVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_ROOM_SEARCH;
		StringBuffer params = new StringBuffer();
		String jsonStr = new String();
		params.append("hotelCode=").append(qryHotelVo.getHotelCode());
		params.append("&city=").append(qryHotelVo.getCitycode());
		params.append("&idate=").append(qryHotelVo.getIdate());
		params.append("&odate=").append(qryHotelVo.getOdate());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		if(qryHotelVo.getHotelname() != null && !qryHotelVo.getHotelname().trim().equals("")){
			params.append("&name=");
			params.append(qryHotelVo.getHotelname());
		}
		if(qryHotelVo.getPrice() != null && !qryHotelVo.getPrice().trim().equals("")){
			params.append("&price=");
			params.append(qryHotelVo.getPrice());
		}
		if(qryHotelVo.getStar() != null && !qryHotelVo.getStar().trim().equals("")){
			params.append("&star=");
			params.append(qryHotelVo.getStar());
		}
		log.info("访问酒店房型接口!@HotelApiManagerImpl.findRoomList()&ursStr="+urlStr+"?"+params);
		jsonStr = HotelRequestHelper.connection(urlStr,params);
		// 调用接口取得返回数据
		return jsonStr;
	}
	/**
	 * 查询酒店订单详细信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public HotelVo findHotelOrderDetail(QryHotelVo qryHotelVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_ORDER_DETAIL;
		StringBuffer params = new StringBuffer();
		params.append("origin=").append(qryHotelVo.getOrigin());
		params.append("&hotelCode=").append(qryHotelVo.getHotelCode());
		params.append("&idate=").append(qryHotelVo.getIdate());
		params.append("&odate=").append(qryHotelVo.getOdate());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		
		// 调用接口取得返回数据
		return (HotelVo)HotelRequestHelper.findObjectByApi(urlStr,params,HotelVo.class);
	}
	/**
	 * 查询酒店订单列表信息
	 * 1.封装参数
	 * 2.调用接口取得数据
	 * 3.如果有需要处理数据
	 * 4.返回数据，如果为空则没有取到
	 * @param qryHotelVo
	 * @return
	 */
	public HotelVo findHotelOrderList(QryHotelVo qryHotelVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_ORDER_SEARCH;
		StringBuffer params = new StringBuffer();
		params.append("origin=").append(qryHotelVo.getOrigin());
		params.append("&hotelCode=").append(qryHotelVo.getHotelCode());
		params.append("&idate=").append(qryHotelVo.getIdate());
		params.append("&odate=").append(qryHotelVo.getOdate());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		
		// 调用接口取得返回数据
		return (HotelVo)HotelRequestHelper.findObjectByApi(urlStr,params,HotelVo.class);
	}

	/**
	 * 
	 * @description 【查询酒店订单】
	 * @see com.hnatourism.club.hotel.api.service.IHotelApiManager#findHotelOrderList(com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo)
	 * @createTime 2011-9-5 下午04:59:40
	 * @author lixun
	 */
	@Override
	public List<HotelOrderVo> findHotelOrderList(QueryHotelOrderVo queryVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_ORDER_SEARCH;
		StringBuffer params = new StringBuffer();
		params.append("memberId=").append(queryVo.getMemberId());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		OrderResultVo hotelVo= (OrderResultVo)HotelRequestHelper.findObjectByApi(urlStr,params,OrderResultVo.class);
		if(hotelVo==null){
			return null;
		}
		return hotelVo.getResultList();
	}
	
	/**
	 * 
	 * @description 【查看订单详情】
	 * @see com.hnatourism.club.hotel.api.service.IHotelApiManager#findHotelOrderDetails(com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo)
	 * @createTime 2011-9-5 下午07:19:02
	 * @author lixun
	 */
	@Override
	public HotelOrderDetailsVo findHotelOrderDetails(QueryHotelOrderVo queryVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_ORDER_DETAIL;
		StringBuffer params = new StringBuffer();
		params.append("code=").append(queryVo.getCode());
		params.append("&source=").append(Constants.CLUB_ORDER_SOURCE);
		OrderResultVo hotelVo= (OrderResultVo)HotelRequestHelper.findObjectByApi(urlStr,params,OrderResultVo.class);
		if(hotelVo==null){
			return null;
		}
		HotelOrderDetailsVo result=hotelVo.getResultBean();
		return result;
	}
	
	/**
	 * 
	 * @description 【取消酒店订单】
	 * @see com.hnatourism.club.hotel.api.service.IHotelApiManager#cancelHotelOrder(com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo)
	 * @createTime 2011-9-6 下午01:04:12
	 * @author lixun
	 */
	@Override
	public HotelOrderDetailsVo cancelHotelOrder(QueryHotelOrderVo queryVo) {
		String urlStr = HotelRequestHelper.API_SERVICE_HOTEL + HotelRequestHelper.API_URL_HOTEL_ORDER_CANCEL;
		StringBuffer params = new StringBuffer();
		params.append("memberId=")
				.append(queryVo.getMemberId())
				.append("&code=")
				.append(queryVo.getCode())
				.append("&source=")
				.append(Constants.CLUB_ORDER_SOURCE);
		OrderResultVo hotelVo= (OrderResultVo)HotelRequestHelper.findObjectByApi(urlStr,params,OrderResultVo.class);
		if(hotelVo!=null){
			return hotelVo.getResultBean();
			
		}else {
			return null;
		}
	}
	
	/**
	 * 
	 * @description 酒店订单更改
	 * @see com.hnatourism.club.hotel.api.service.IHotelApiManager#verifyHotelOrder(com.hnatourism.club.hotel.order.vo.QueryHotelOrderVo)
	 * @createTime 2011-10-8 下午04:14:23
	 * @author lixun
	 */
	@Override
	public boolean modifyHotelOrderSts(QueryHotelOrderVo queryVo) {
		if(!"SC".equalsIgnoreCase(queryVo.getSts())){//1、判断是否已取消
			return false;
		}else {
			try {
				//更新订单状态
				return true;
			} catch (Exception e) {
				return false;
			}
		}

//		String sellerNo=orderLoungeDao.getSellerNoByOrderId(orderLounge.getId()); ///分销商分润账户     order_lounge    lounge_room    lounge_info   member_account   account
//		String subCorpNo=orderLoungeDao.getSubCorpNoByOrderId(orderLounge.getId());//分公司分润账户
//		MemberAccountVo accountAndCardNo = orderLoungeDao.getAccountAndCardNo(orderLounge.getId());
//		String fromAccount=accountAndCardNo.getCardNo();	//现金来源账户
//		OrderLoungeGuest ole=new OrderLoungeGuest();
//		ole.setOrderId(orderLounge.getId());
//		Integer pepleCount=orderLoungeGuestDao.findByWhere(ole).size();
//		
//		float price=orderLounge.getPrice().floatValue();		//总价
//		float signprice=orderLounge.getSignPrice().floatValue();	//底价
//		String type=orderLounge.getProfit();		//直减1 返积分2
//		float exPrice=orderLounge.getAdditionalFee().floatValue();		//附加价格
//		
//		
//		//调用计算方法
//		SubRunBean subRunBean = new SubRunBean();
//
//		subRunBean.setRoleCode(permeMap.get("rolecode").toString());
//		subRunBean.setProdType("L");
//		subRunBean.setPrivilegeType(type);
//		subRunBean.setOrderSignprice(Double.valueOf(signprice*pepleCount));
//		subRunBean.setOrderPrice(Double.valueOf(price));
//		subRunBean.setOrderExPrice(Double.valueOf(exPrice));
//		subRunBean.setOrderRetPrice(Double.valueOf(orderLounge.getProfitAmount()));
//		subRunBean.setSellerCardNo(sellerNo);
//		subRunBean.setPlatformAccount(PropertiesUtils.getVal("sysProps","platformAccount"));
//		subRunBean.setSubCorpAccount(subCorpNo);
//		subRunBean.setAccount(fromAccount);
//		subRunBean.setOrderCode(orderLounge.getCode());
//		subRunBean.setOrderType("N");
//		subRunBean.setCardNo(fromAccount);
//		subRunBean.setAttPepoLowPrice(Double.valueOf(orderLoungeDao.getSignPriceOfOrderLongeGuest(orderLounge.getId()).getAdditionalSignPrice()));
//		subRunBean.setAttOrderLowPrice(Double.valueOf(orderLounge.getAdditionalSignPrice()));
//		subRunBean.setOrderId(orderLounge.getId());
//		
//		subRunBean = SubRunUtils.profitMoney(subRunBean);
//		
//		//插入orderbill表
//		orderBillService.insertOrderBill(subRunBean,permeMap.get("createUser").toString());
//		//调用支付接口
//		PayVo payvo=new PayVo();
//		try {
//			payvo = payInterfaceApiServerImpl.payUrl(fromAccount,
//					orderLounge.getCode(),
//					SubRunUtils.doubleHandler(subRunBean.getOrderPrice().toString(), 2),
//					subRunBean.getSellerDetail(),
//					subRunBean.getDetails(),PropertiesUtils.getVal("payInterface","payCallBackUrl"));
//		} catch (Exception e) {
//			throw new Exception("payError");
//		}
//		String result= payvo.getRespCode();
//		if("000000".equals(result) || "SUCCESS".equals(result)){
//			super.returnObj = "支付成功";
//			
//			// 生成验证码
//			ProdCaptcha prodCaptcha = new ProdCaptcha();
//			prodCaptcha.setId(SnoGerUtil.getUUID());
//			prodCaptcha.setCode(SnoGerUtil.getCaptchaCode());
//			prodCaptcha.setCreateTime(DateUtils.getCurrentDate());
//			prodCaptcha.setMemberId(orderLounge.getMemberId());
//			prodCaptcha.setOrderCode(orderLounge.getCode());
//			prodCaptcha.setType("L");
//			prodCaptcha.setSts("0");
//			prodCaptcha.setCreateUser(permeMap.get("memberCode").toString());
//			prodCaptchaDao.insert(prodCaptcha);
//
//			logLoungeOrder.setId(SnoGerUtil.getUUID());
//			logLoungeOrder.setContent("预定成功!");
//			logLoungeOrder.setType("2");
//			logLoungeOrder.setOrderId(orderLounge.getId());// 设置订单ID
//			logLoungeOrder.setCreateTime(DateUtils.getCurrentDate());
//			logLoungeOrder.setCreateUser(permeMap.get("memberCode").toString());
//			logLoungeOrderDao.insert(logLoungeOrder);
//			// 支付状态改为已支付
//			orderLounge.setPaySts("1");
//			orderLounge.setSts("2");
//			// 处理完订单之后要把该订单解锁
//			orderLounge.setOperateSts("0");
//			// 更新订单状态
//			orderLoungeDao.update(orderLounge);
//		}else{
////			super.returnObj = "支付失败";
//			throw new Exception("payError");
//		}
	
	}
	/**
	 * 调试方法 
	 * 注意此调用接口需要连接外网
	 */
	public static void main(String[] args) {
		HotelApiManagerImpl hotelApiManagerImpl = new HotelApiManagerImpl();
		QryHotelVo qryHotelVo = new QryHotelVo();
		qryHotelVo.setOrigin("HBE");
		qryHotelVo.setHotelCode("0000130440");
		qryHotelVo.setIdate("2011-09-21");
		qryHotelVo.setOdate("2011-09-23");
		hotelApiManagerImpl.findHotelDetail(qryHotelVo);
	}
}