/**
 * 
 */
package com.hnatourism.club.pay;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.order.dao.IOrderPointsExchangeDao;

/**
 * @author gujianliang
 * @2011-8-26
 */
public class PayInterfaceApiServerImpl  implements IPayInterfaceApiServer{

	private static final Log log = LogFactory.getLog(PayInterfaceApiServerImpl.class);
	private PayInterfaceApi pif=new PayInterfaceApi();
	private IOrderPointsExchangeDao orderPointsExchangeDao;
	private String msg="";
	
	/**
	 * 判断余额是否满足
	 * @param account 用户账户
	 * @param amount 需要金额
	 * @return  满足为 true
	 * @throws Exception
	 */
	public Boolean insufficientBalance(String account,Double amount)throws Exception{
		PayVo payVo=findBalance(account);
		if(!"SUCCESS".equals(payVo.getRespCode())){
			log.info(payVo.getErrMsg());
			msg="余额查询失败";
			return false;
		}
		//当前正在出售的积分
		Integer currentlyTradingPoint=orderPointsExchangeDao.getRemainingPoints("findC_T_PointByUserAccount", account);
		BigDecimal balance=new BigDecimal(payVo.getAcctBal());
		Integer resultD=balance.subtract(new BigDecimal(currentlyTradingPoint+amount)).signum();
		return resultD>=0?true:false;
	}
	 
	/**
	 * 余额查询
	 * @author gujianliang
	 * @2011-8-24
	 * @param userId 帐号号
	 * @return  respCode 如果为 SUCCESS 则为成功 否则为异常 请看 ErrMsg
	 * @throws Exception
	 */
	public PayVo findBalance(String userId) throws Exception{
		log.info("==================余额查询====================");
		PayVo payvo=new PayVo();
		payvo.setUsrId(userId);
		//余额查询
		payvo=pif.call(payvo,"balanceUrl");
		log.info("[余额查询]payvo.getAddress():"+payvo.getAddress());
		if("SUCCESS".equals(payvo.getErrMsg()) 
				|| "成功".equals(payvo.getErrMsg()) 
				|| "000000".equals(payvo.getRespCode())){
			payvo.setRespCode("SUCCESS");
		}else{
			log.info(payvo.getErrMsg());
		}
		return payvo;
	}
	
	/**
	 * 修改密码
	 * @author gujianliang
	 * @2011-8-24
	 * @param usrId
	 * @param oldPassword
	 * @param newPassword
	 * @return  respCode 如果为 SUCCESS 则为成功 否则为异常 请看 ErrMsg
	 * @throws Exception
	 */
	public PayVo modifyPaw(String usrId,String oldPassword,String newPassword) throws Exception{
		log.info("==================修改密码====================");
		PayVo payvo=new PayVo();
		payvo.setUsrId(usrId);
		payvo.setOldTransPwd(oldPassword);
		payvo.setNewTransPwd(newPassword);
		//修改密码
		payvo=pif.call(payvo,"modifyPaw");
		log.info("[修改密码]payvo.getAddress():"+payvo.getAddress());
		if("SUCCESS".equals(payvo.getErrMsg()) || "000000".equals(payvo.getRespCode())){
			payvo.setRespCode("SUCCESS");
		}else{
			log.info(payvo.getErrMsg());
		}
		return payvo;
	}
	
	/**
	 * 分润
	 * @author gujianliang
	 * @2011-8-24
	 * @param usrId  用户帐号号
	 * @param orderId 订单id
	 * @param totalFee 支付费用
	 * @param sellerDetail 格式如     商家用户号^金额^content
	 * @param details 分润格式如  hongtao^20.00^content|hongtao^20.00^content|hongtao^20.00^content
	 * @return  respCode 如果为 SUCCESS 则为成功 否则为异常 请看 ErrMsg
	 * @throws Exception
	 */
	public PayVo payUrl(String usrId,String orderId,String totalFee,String sellerDetail,String details,String callBackUrl) throws Exception{
		log.info("==================支付分润====================");
		PayVo payvo=new PayVo();
		msg="";
		if(!insufficientBalance(usrId,Double.valueOf(totalFee))){
			payvo.setRespCode("FAIL");
			msg="可用余额不足!"+msg;
			payvo.setErrMsg(msg);
			return payvo;
		}
		payvo.setBuyer_account(usrId);//000001067133 
		payvo.setOrderId(orderId);
		payvo.setPayType("1");
		payvo.setPaymentType("3");
		payvo.setTotal_fee(totalFee);
		payvo.setNotify_url(callBackUrl);
		payvo.setSeller_details(sellerDetail);
		payvo.setDetails(details);
		payvo=pif.call(payvo,"payUrl");
		log.info("[支付分润]payvo.getAddress():"+payvo.getAddress());
		if("SUCCESS".equals(payvo.getErrMsg()) || "000000".equals(payvo.getRespCode())){
			payvo.setRespCode("SUCCESS");
		}else{
			log.info(payvo.getErrMsg());
		}
		return payvo;
	}
	
	
	/**
	 * 收款用户签约
	 * @author gujianliang
	 * @2011-8-25
	 * @param account  帐号号
	 * @param signedAccount 签约后的帐号名  现在规定与帐号相同
	 * @param backUrl 回调url  可以为 localhost
	 * @return
	 * @throws Exception
	 */
	public PayVo sign(String account,String signedAccount,String backUrl) throws Exception{
		log.info("==================签约帐号====================");
		PayVo payvo=new PayVo();
		payvo.setAccount(account);
		payvo.setSigned_account(signedAccount);
		payvo.setNotify_url(backUrl);
		payvo.setType("3");
		payvo=pif.call(payvo,"signUrl");
		log.info("[签约帐号]payvo.getAddress():"+payvo.getAddress());
		return payvo;
	}
	
	/**
	 * 代扣签约
	 * @author gujianliang
	 * @2011-8-25
	 * @param account  帐号号
	 * @param signedAccount 签约后的帐号名  现在规定与帐号相同
	 * @param backUrl 回调url  可以为 localhost
	 * @return
	 * @throws Exception
	 */
	@Override
	public PayVo addUrl(String account, String signedAccount, String backUrl)
			throws Exception {
		log.info("==================代扣签约====================");
		PayVo payvo=new PayVo();
		payvo.setAccount(account);
		payvo.setSigned_account(signedAccount);
		payvo.setNotify_url(backUrl);
		payvo.setType("3");
		payvo=pif.call(payvo,"addUrl");
		if("SUCCESS".equals(payvo.getErrMsg()) || "000000".equals(payvo.getRespCode())){
			payvo.setRespCode("SUCCESS");
		}else{
			log.info(payvo.getErrMsg());
		}
		log.info("[代扣签约帐号]payvo.getAddress():"+payvo.getAddress());
		return payvo;
	}
	/**
	 * 充值
	 * @author gujianliang
	 * @2011-8-25
	 * @param account  帐户
	 * @param accountOrderId  自定义充值订单id
	 * @param amont 充值钱数
	 * @param backUrl 回调url
	 * @return
	 * @throws Exception
	 */
	public PayVo depOnlineSave(String account,String accountOrderId,String amont,String merPriv,String backUrl) throws Exception{
		PayVo payvo=new PayVo();
		payvo.setOperId(account);//000001067133 
		payvo.setOrdId(accountOrderId);
		payvo.setOrdAmt(doubleHandler(amont,2));
		payvo.setNotifyUrl(backUrl);
		payvo.setMerPriv(merPriv);
		payvo=pif.call(payvo,"depOnlineSaveUrl");
		log.info("[在线充值]payvo.getAddress():"+payvo.getAddress());
		return payvo;
	}
	
	/**
	 * 退款
	 * @author gujianliang
	 * @2011-8-26
	 * @param orderId 订单号
	 * @param tradeNo 交易码
	 * @param fee 手续费
	 * @param amount 总金额
	 * @param sellerDetails 产品提供商号
	 * @param details 分润详细
	 * @param descrition 描述
	 * @param backUrl 回调url
	 * @return
	 * @throws Exception
	 */
	public PayVo payback(String orderId,String tradeNo,String fee,String amount,String sellerDetails,String details,String descrition,String backUrl) throws Exception{
		
		log.info("==================退款====================");
		PayVo payvo=new PayVo();
		payvo.setPayback_type("3");
		payvo.setOrderId(orderId);
		payvo.setTrade_no(tradeNo);
		//手续费四舍五入
		fee=String.valueOf(new BigDecimal(fee).setScale(2, BigDecimal.ROUND_HALF_UP));
		payvo.setRefund_fee(doubleHandler(fee,2));
		payvo.setRefund_amount(doubleHandler(amount,2));
		//payvo.setUnbalance("");
		payvo.setSeller_details(sellerDetails);
		payvo.setDetails(details);
		payvo.setDescrition(descrition);
		payvo.setNotify_url(backUrl);
		payvo=pif.call(payvo,"payback");
		log.info("[退款]payvo.getAddress():"+payvo.getAddress());
		if("SUCCESS".equals(payvo.getErrMsg()) || "000000".equals(payvo.getRespCode())){
			payvo.setRespCode("SUCCESS");
		}else{
			log.info(payvo.getErrMsg());
		}
		return payvo;
	}
	
	
	/**
	 * 小数点取值    后几位
	 * @author gujianliang
	 * @2011-8-26
	 * @param obj
	 * @param size
	 * @return
	 */
	public static String doubleHandler(String str,Integer size){
		
		str=str.trim();
		
		if(str==null && size==null){
			return null;
		}
		if(size>9){
			return null;
		}
		
		if(str.indexOf(".")>0){
			str=str+"000000000000";
			str=str.substring(0,str.indexOf(".")+(size+1));
		}else{
			str=str+".";
			for(int i=0;i<size;i++){
				str=str+"0";
			}
		}
		
		return str;
	}

	public IOrderPointsExchangeDao getOrderPointsExchangeDao() {
		return orderPointsExchangeDao;
	}

	public void setOrderPointsExchangeDao(
			IOrderPointsExchangeDao orderPointsExchangeDao) {
		this.orderPointsExchangeDao = orderPointsExchangeDao;
	}

	
}
