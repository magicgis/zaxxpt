package com.hnatourism.club.pay;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.util.Sign;
import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.utils.StringUtils;


/**
 * @author gujianliang
 * @2011-8-22
 */
public class PayInterfaceApi {
	private static final Log log = LogFactory.getLog(PayInterfaceApi.class);
	//密钥 测试
	private String key=PropertiesUtils.getVal("payInterface","chinapnr_key");;
	//商户号 测试
 	private String partner=PropertiesUtils.getVal("payInterface","chinapnr_partner");;
 	//编码
 	private String encoding="GBK";
 	//接口资源文件名
 	private String  interFaceProperties="payInterface";
 	
 	/**
 	 * 接口调用
 	 * @author gujianliang
 	 * @2011-8-23
 	 * @param payvo  支付对象
 	 * @param cmdId  接口名
 	 * @return
 	 * @throws Exception
 	 */
	public PayVo call(PayVo payvo,String cmdId) throws Exception{
		//对象转map
		HashMap params=ParameterHandler.objMethd2Map(payvo);
		if(params.get("partner")==null){
			params.put("partner", partner);
		}
		Set set=params.entrySet();
		Iterator iter=set.iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> entry=(Entry<String, String>) iter.next();
			if(StringUtils.isBlank(entry.getValue())){
//				params.remove(entry.getKey());
				log.info("entry.getValue() is null ,entry.getKey()=" + entry.getKey());
			}
		}
		//签名
		String sign=Sign.signParameter(params, key, encoding);
		//转换url
		String [] arg=new String[]{Sign.map2URL(params, sign)};
		//调用地址
	    String address=MessageFormat.format(PropertiesUtils.getVal(interFaceProperties,cmdId), arg[0]);
	    log.info("支付调用 address："+address);
	    PayVo payVo =new PayVo();
	    //如果 不为充值
	    if(!"depOnlineSaveUrl".equals(cmdId) && !"signUrl".equals(cmdId)  && !"addUrl".equals(cmdId)){
	    	 String result=connection(address);
	    	 if(result!=null){
	 	    	if(result.indexOf("&")>0){
	 	    		ParameterHandler.map2Object(ParameterHandler.urlPremeter2Map(result),payVo);
	 	    	}else{
	 	    		if("SUCCESS".equals(result.trim())){
	 	    			payVo.setRespCode("000000");
	 	    		}else if(result.indexOf("已经支付")>0){
	 	    			payVo.setRespCode("000001");
	 	    		}
	 	    		payVo.setErrMsg(result);
	 	    	}
	 	    }else{
	 	    	payVo.setRespCode("111111");
	 	    	payVo.setErrMsg("error");
	 	    }
	    }
	    payVo.setAddress(address);
	    return payVo;
	}
	
	
	/**
	 * 调用接口
	 * @author gujianliang
	 * @2011-8-23
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public String connection(String address) throws Exception{
		log.info("address:  " + address);
		String html = "";
		URL url = new URL(address);
		URLConnection conn = url.openConnection();
		conn.setConnectTimeout(300000);
		conn.setReadTimeout(300000);
		//conn.setRequestProperty("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");  
		//conn.setRequestProperty("Accept-Encoding", "gzip,deflate");  
		InputStream urlStream = conn.getInputStream();   
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream,"gb2312"));  
	    String line = "";  
		while((line = reader.readLine()) != null) {  
			html=html+line;
		 }  
		 reader.close();  
		urlStream.close();  

		Field [] fields=PayVo.class.getDeclaredFields();
		String str=",SUCCESS";
		String [] strArray=str.split(",");
		for(String stra:strArray){
			if(html.indexOf(stra)<0){
				html=html.replace(stra.substring(1), stra);
			}
		}
		for(Field field:fields){
			if(html.indexOf(field.getName())<0){
				html=html.replace(field.getName().substring(1), field.getName());
			}
		}
			return html.toString();
	}
	
	/**
	 * @author gujianliang
	 * @2011-8-22
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws  Exception {
		// TODO Auto-generated method stub
//		6288801010808104    6288801010808104
//		6288803010808400     hongtao
//		6288801010808102     hongtao1
		
		PayInterfaceApi pif=new PayInterfaceApi();
		
		//System.out.println("==================余额查询===================");
		PayVo payvo=new PayVo();
		payvo.setUsrId("6288801010808116");
		//余额查询
		payvo=pif.call(payvo,"balanceUrl");
		System.out.println(payvo.getRespCode());
		System.out.println(payvo.getErrMsg());
		System.out.println(payvo.getAcctBal());
		System.out.println(payvo.getFrzBal());
		//System.out.println("======================================");
		
		
		//System.out.println("=================修改密码====================");
		PayVo payvo1=new PayVo();
		payvo1.setUsrId("6288801010808392");
		payvo1.setOldTransPwd("822638");
		payvo1.setNewTransPwd("111111");
		//528002
		//payvo1=pif.call(payvo1,"modifyPaw");
		System.out.println(payvo1.getRespCode());
		System.out.println(payvo1.getErrMsg());
		System.out.println(payvo1.getAcctBal());
		System.out.println(payvo1.getFrzBal());
		//System.out.println("======================================");
		
		//http://test.chinapnr.com/gau/UnifiedServlet?Version=10&CmdId=AutoPaySign&MerId=510136&MerDate=20110825&MerTime=182102&BgRetUrl=http://127.0.0.1&ChkValue=284E5BB43162E75B30334238DBA17F97CFD5F7273CDC61E01D5CCEBFDAD8AF4882A503F6D00C2115612F6C5D07AD244B51D6E34ED6B396CA322712523BE66650D3F20C73BC47F7C01B1B3235E10B962E0E08DFC137DC3193256730D037ACDEBC8CAA2AD0E51EC67EF952E156E423D56F83F45B7623E35302CCA16B62642A128D
		//System.out.println("==================ǩԼ�ʺ�====================");
		PayVo payvo3=new PayVo();//6288803010808384
		payvo3.setAccount("6288801010808033");
		payvo3.setSigned_account("6288801010808033");
		payvo3.setNotify_url("localhost");
		payvo3.setType("3");
		
		//�޸�����    ����Ա�ţ�6288801010808102      �˺ţ�000001041358 
		//payvo1=pif.call(payvo3,"signUrl");//signUrl   addUrl
		//System.out.println(payvo3.getRespCode());
		//System.out.println(payvo3.getErrMsg());
		//System.out.println(payvo3.getBatchNo());
		//System.out.println("======================================");

		//System.out.println("==================֧������====================");
		PayVo payvo2=new PayVo();
		payvo2.setBuyer_account("6288801010808116");//000001067133 
		payvo2.setOrderId("9876543112112");
		payvo2.setPayType("1");
		payvo2.setPaymentType("3");
		payvo2.setTotal_fee("238.00");
		payvo2.setNotify_url("localhost:8080");
		payvo2.setSeller_details("870674_kkkk^120.00^content");
		payvo2.setDetails("870674_plat^35.40^content|870674_hotel^82.60^content");//   ����Ա�ţ�6288803010808400      �˺ţ�000001053273 
		//�޸�����    ����Ա�ţ�6288801010808102      hongtao1  �˺ţ�000001041358 
		payvo2=pif.call(payvo2,"payUrl");
		System.out.println(payvo2.getRespCode());
		System.out.println(payvo2.getErrMsg());
		System.out.println(payvo2.getAcctBal());
		System.out.println(payvo2.getFrzBal());
		//System.out.println("Trade_no:"+payvo2.getTrade_no());
		//System.out.println("Trade_no:"+payvo2.getTradeNo());
		//System.out.println("======================================");
		//ǩԼ		http://210.51.165.183:8120/chinapnrCardSystem/sign.do?account=000001067366&signed_account=hongtao	

		
		//System.out.println("==================��ֵ====================");
		PayVo payvo5=new PayVo();
		payvo5.setOperId("clubtest");//000001067133 
		payvo5.setOrdId("1234567891");
		payvo5.setOrdAmt("1000.00");
		payvo5.setNotifyUrl("localhost");
		//payvo5=pif.call(payvo5,"depOnlineSaveUrl");
		//System.out.println(payvo5.getRespCode());
		//System.out.println(payvo5.getErrMsg());
		//System.out.println(payvo5.getAcctBal());
		//System.out.println(payvo5.getFrzBal());
		//System.out.println("======================================");

		
		//System.out.println("==================�˿�====================");
		PayVo payvo6=new PayVo();
		payvo6.setPayback_type("3");
		payvo6.setOrderId("9876543210");
		payvo6.setTrade_no("2011082601016525");
		payvo6.setRefund_fee("0.20");
		payvo6.setRefund_amount("200.00");
		//payvo6.setUnbalance("");
		payvo6.setSeller_details("hongtao1^190.00^content");
		payvo6.setDetails("6288801010808104^7.00^content|xhlxculb^2.80^content");
		payvo6.setDescrition("descrition");
		payvo6.setNotify_url("http://10.68.200.40:8080/club/api_payBack.jsp");
		//payvo6=pif.call(payvo6,"payback");
		//System.out.println(payvo6.getRespCode());
		//System.out.println(payvo6.getErrMsg());
		//System.out.println(payvo6.getAcctBal());
		//System.out.println(payvo6.getFrzBal());
		//System.out.println("=====================================û�иö�����֧����¼����ȷ�϶�����=");
		//http://10.68.200.174:8120/chinapnrCardSystem/payback.do?descrition=���ý���&refund_fee=0.00&trade_no=2011082601016220&details=6288801010808104^10.00^content&notify_url=http://10.68.200.40:8080/club/api_payBack.jsp&seller_details=hongtao1^190.00^content&partner=918335&OrdId=abc&refund_amount=200.00&payback_type=1&sign=d61f2569a82fcce21488ae2501a47de9	
		
	}
	
}
