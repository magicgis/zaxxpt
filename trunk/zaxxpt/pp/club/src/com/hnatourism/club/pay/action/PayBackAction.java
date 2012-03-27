/**
 * 
 */
package com.hnatourism.club.pay.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hnatourism.club.personal.member.service.IOrderBillService;
import com.hnatourism.club.personal.member.web.vo.OrderBillVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * @author gujianliang
 * @2011-8-26
 */
public class PayBackAction extends BaseAction {

	private static final Log log = (Log) LogFactory.getLog(PayBackAction.class);
	private IOrderBillService orderBillService;
	private String returnMessage;

	/**
	 * 充值回调处理
	 * 
	 * @author gujianliang
	 * @2011-8-26
	 */
	public void saveBackUrlHandler() {
		log.info("==saveBackUrlHandler==");
		//String account = "clubtest";
		//String userName = "clubtest";

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String RespCode = request.getParameter("RespCode");
		String OrdId = request.getParameter("OrdId");
		String OrdAmt = request.getParameter("OrdAmt");
		String TradeNo = request.getParameter("TradeNo");
		String account=request.getParameter("MerPriv");//用户私有内容中放帐号
		
		try {

			if (RespCode != null && OrdId != null && OrdAmt != null
					&& TradeNo != null) {
				if ("000000".equals(RespCode)) {
					OrderBillVo obv = new OrderBillVo();
					obv.setAccount(account);
					obv.setOrderId(OrdId);
					obv.setOrderType("N");// 充值
					obv.setType("chinapnr");
					obv.setStatus("01");
					obv.setProdType("P");
					obv.setTradeNo(TradeNo);
					obv.setAmount(Double.valueOf(OrdAmt));
					obv.setTransactionType("3");
					List list=orderBillService.findByWhere(obv);
					if(list!=null){
						if(list.size()==0){
							obv.setTradeTime(new Date());
							obv.setUpdateTime(new Date());
							obv.setCreateTime(new Date());
							obv.setCreateUser("汇付回调");
							obv.setId(UUID.randomUUID().toString().replace("-", ""));
							orderBillService.insert(obv);
							returnMessage = "充值成功回调";
						}
					}else{
						obv.setTradeTime(new Date());
						obv.setUpdateTime(new Date());
						obv.setCreateTime(new Date());
						obv.setCreateUser("汇付回调");
						obv.setId(UUID.randomUUID().toString().replace("-", ""));
						orderBillService.insert(obv);
						returnMessage = "充值成功回调";
					}
					
					response.getWriter().println("SUCCESS");
				} else {
					returnMessage = "执行充值回调失败RespCode is not 000000  ["+RespCode+"]";
				}
				
			}else{
				returnMessage = "执行充值回调失败 RespCode == null or OrdId == null or OrdAmt == null TradeNo == null";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}
		log.info(returnMessage);

	}

	/**
	 * 支付回调处理
	 * pay/payBackAction!payCallBack.action
	 * @author gujianliang
	 * @throws BusinessException 
	 * @2011-8-26
	 */
	public void payCallBack() throws BusinessException {
		log.info("==payCallBack==");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String pay_info = request.getParameter("pay_info");
		String orderId = request.getParameter("orderId");
		String trade_no = request.getParameter("trade_no");
		String amount = request.getParameter("amount");
		String pay_accout = request.getParameter("pay_accout");
		String pay_time = request.getParameter("pay_time");
		
		log.info("==trade_no=="+trade_no);
		//BaseUserVo user = UserUtil.getUserVo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 分润支付插入账单表
		try {
			if (trade_no != null && pay_info != null && orderId != null
					&& amount != null && pay_accout!=null) {
				String status = "";
				if ("ok".equals(pay_info)) {
					status = "01";
				}else{
					status = "02";
				}
				OrderBillVo orderBill = new OrderBillVo();
				orderBill.setOrderCode(orderId);
				List<OrderBillVo> list = orderBillService.findByWhere(orderBill);
				for(int i=0;i<list.size();i++){
					orderBill = new OrderBillVo();
					orderBill = list.get(i);

					// 已经成功更新的不再处理
					if(trade_no.equalsIgnoreCase(orderBill.getTradeNo())
							&& "01".equalsIgnoreCase(orderBill.getStatus())){
						continue;
					}

					//orderBill.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
					//orderBill.setUpdateUser(user.getUsername());
					orderBill.setTradeNo(trade_no);   // 会员账户
					orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
					orderBill.setStatus(status);
					orderBillService.updateClear(orderBill);
				}
				
				response.getWriter().println("SUCCESS");
				log.info("应答汇付SUCCESS");
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(returnMessage);
	}

	/**
	 * 改期回调处理
	 * pay/payBackAction!payCallBack.action
	 * @author gujianliang
	 * @throws BusinessException 
	 * @2011-8-26
	 */
	public void payChangeCallBack() throws BusinessException {
		log.info("==payChangeCallBack==");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String pay_info = request.getParameter("pay_info");
		String orderId = request.getParameter("orderId");
		String trade_no = request.getParameter("trade_no");
		String amount = request.getParameter("amount");
		String pay_accout = request.getParameter("pay_accout");
		String pay_time = request.getParameter("pay_time");
		
		
		//BaseUserVo user = UserUtil.getUserVo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 分润支付插入账单表
		try {
			if (trade_no != null && pay_info != null && orderId != null
					&& amount != null && pay_accout!=null) {
				String status = "";
				if ("ok".equals(pay_info)) {
					status = "01";
				}else{
					status = "02";
				}
				OrderBillVo orderBill = new OrderBillVo();
				orderBill.setOrderCode(orderId);
				List<OrderBillVo> list = orderBillService.findByWhere(orderBill);
				for(int i=0;i<list.size();i++){
					orderBill = new OrderBillVo();
					orderBill = list.get(i);
					
					// 已经成功更新的不再处理
					if(trade_no.equalsIgnoreCase(orderBill.getTradeNo())
							&& "01".equalsIgnoreCase(orderBill.getStatus())){
						continue;
					}
					
					//orderBill.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
					//orderBill.setUpdateUser(user.getUsername());
					orderBill.setTradeNo(trade_no);   // 会员账户
					orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
					orderBill.setStatus(status);
					orderBillService.updateClear(orderBill);
				}
				
				response.getWriter().println("SUCCESS");
				log.info("应答汇付SUCCESS");
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(returnMessage);
	}
	/**
	 * 退款回调处理
	 * pay/payBackAction!payCallBack.action
	 * @author gujianliang
	 * @throws BusinessException 
	 * @2011-8-26
	 */
	public void payReturnCallBack() throws BusinessException {
		log.info("==payReturnCallBack==");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String pay_info = request.getParameter("pay_info");
		String orderId = request.getParameter("orderId");
		String trade_no = request.getParameter("trade_no");
		//String amount = request.getParameter("amount");
		//String pay_accout = request.getParameter("pay_accout");
		//String pay_time = request.getParameter("pay_time");
		String keep = request.getParameter("keep");
		log.info("==trade_no=="+trade_no);
		
		//BaseUserVo user = UserUtil.getUserVo();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// 分润支付插入账单表
		try { 
			if (trade_no != null &&  orderId != null && keep != null) {
			if (trade_no != null && orderId != null && keep != null ) {
				String status = "";
				status = "01";
				OrderBillVo orderBill = new OrderBillVo();
				orderBill.setOrderCode(keep);
				List<OrderBillVo> list = orderBillService.findByWhere(orderBill);
				for(int i=0;i<list.size();i++){
					orderBill = new OrderBillVo();
					orderBill = list.get(i);
					
					// 已经成功更新的不再处理
					if(trade_no.equalsIgnoreCase(orderBill.getTradeNo())
							&& "01".equalsIgnoreCase(orderBill.getStatus())){
						continue;
					}

					//orderBill.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
					//orderBill.setUpdateUser(user.getUsername());
					orderBill.setTradeNo(trade_no);   // 会员账户
					orderBill.setTradeTime(new Date());// 交易时间
					orderBill.setStatus(status);
					orderBillService.updateClear(orderBill);
				}
				
				response.getWriter().println("SUCCESS");
				log.info("应答汇付SUCCESS");
			}			
		} }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(returnMessage);
	}
	public IOrderBillService getOrderBillService() {
		return orderBillService;
	}

	public void setOrderBillService(IOrderBillService orderBillService) {
		this.orderBillService = orderBillService;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

}
