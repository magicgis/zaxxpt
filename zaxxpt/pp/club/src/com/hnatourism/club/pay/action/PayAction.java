/**
 * 
 */
package com.hnatourism.club.pay.action;

import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.pay.IPayInterfaceApiServer;
import com.hnatourism.club.pay.PayVo;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.web.action.BaseAction;

/**
 * @author gujianliang
 * @2011-8-26
 */
public class PayAction extends BaseAction {

	
	private PayVo payVo=new PayVo();
	private IPayInterfaceApiServer payInterfaceApiServer;
	private String returnMessage="操作成功";
	//充值回调url
	String onlineSaveBackUrl=PropertiesUtils.getVal("payInterface","depOnlinePayCallBackUrl");
	
	/**
	 * 充值
	 * @author gujianliang
	 * @2011-8-26
	 * @return
	 */
	public String depOnlineSave(){
		
		if (UserUtil.getUser(getSession().getId()) == null) {
			return "notlogin";
		}
		String account=UserUtil.getUser(this.getSession().getId()).getMemberAccount().getCardNo();
		String accountOrderId=String.valueOf(System.currentTimeMillis());
		try {
			payVo=payInterfaceApiServer.depOnlineSave(account, accountOrderId, payVo.getAccount(),account, onlineSaveBackUrl);
			//System.out.println("address============"+payVo.getAddress());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage="请求充值页面失败";
		}
		return "depOnlineSave";
	}

	
	/**
	 * 跳转到支付页面
	 * @author gujianliang
	 * @2011-8-27
	 * @return
	 */
	public String toPayPage(){
		if (UserUtil.getUser(getSession().getId()) == null) {
			return "notlogin";
		}
		return "toPayPage";
	}
	
	public PayVo getPayVo() {
		return payVo;
	}

	public void setPayVo(PayVo payVo) {
		this.payVo = payVo;
	}

	public IPayInterfaceApiServer getPayInterfaceApiServer() {
		return payInterfaceApiServer;
	}

	public void setPayInterfaceApiServer(
			IPayInterfaceApiServer payInterfaceApiServer) {
		this.payInterfaceApiServer = payInterfaceApiServer;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public String getOnlineSaveBackUrl() {
		return onlineSaveBackUrl;
	}

	public void setOnlineSaveBackUrl(String onlineSaveBackUrl) {
		this.onlineSaveBackUrl = onlineSaveBackUrl;
	}

	
}
