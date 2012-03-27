/**
 * 
 */
package com.hnatourism.club.pay;




/**
 * @author gujianliang
 * @2011-8-22
 */
public interface IPayInterfaceApiServer {
	
	public PayVo findBalance(String userId)throws Exception;
	public PayVo modifyPaw(String usrId,String oldPassword,String newPassword) throws Exception;
	public PayVo payUrl(String usrId,String orderId,String totalFee,String sellerDetail,String details,String callBackUrl) throws Exception;
	public PayVo sign(String account,String signedAccount,String backUrl) throws Exception;
	public PayVo addUrl(String account,String signedAccount,String backUrl) throws Exception;
	public PayVo depOnlineSave(String account,String accountOrderId,String amont,String merPriv,String backUrl) throws Exception;
	public PayVo payback(String orderId,String tradeNo,String fee,String amount,String sellerDetails,String details,String descrition,String backUrl) throws Exception;

	
}
