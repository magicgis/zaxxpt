package com.hnatourism.club.golf.api;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.common.Constants;


/**
 * 调用接口客户端
 *
 */
public class ApiClient {
	// log
	private static final Log log = LogFactory.getLog(ApiClient.class);
	
	
	/**
	 * 取得数据
	 * @param address
	 * @return
	 */
	public static String getHtml(String address) {
		address=address.replace(" ", "");
		if(!address.startsWith("http://")){
			address=Constants.API_SERVER_DOMAIN+address;
		}
		log.info("调用api:  "+ address);
//		System.out.println(address);
		StringBuffer html = new StringBuffer();
		String result = null;
		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			BufferedInputStream in = new BufferedInputStream(conn
					.getInputStream());

			try {
				String inputLine;
				byte[] buf = new byte[4096];
				int bytesRead = 0;
				while (bytesRead >= 0) {
					inputLine = new String(buf, 0, bytesRead, "ISO-8859-1");
					html.append(inputLine);
					bytesRead = in.read(buf);
					inputLine = null;
				}
				buf = null;
			} finally {
				in.close();
				conn = null;
				url = null;
			}
			result = new String(html.toString().trim().getBytes("ISO-8859-1"),"utf-8").replace("&quot;", "\"");
			log.info("调用api result:  "+ result);
		} catch (Exception e) {
			result="没有找到地址："+address;
			log.error(e);
			e.printStackTrace();
		}
		html = null;
		//System.out.println("reslut:"+result);
		return result;
	}
	
	/**
	 * @param args
	 */
			public static void main(String[] args) {
				// TODO Auto-generated method stub
		       //查找详细
		       // //System.out.println("详细:"+getHtml("http://localhost:8080/club/api/apiServer.action?method=f_golf_img_ById&&id=1111"));
		        //搜索
		       ////System.out.println("搜索:"+getHtml("http://localhost:8080/club/api/apiServer.action?method=api_findGolfInfoBySearch&&city=1111&&time=null&&name=北京&&type=null&&id=1111"));
				//查找订单
				////System.out.println("订单:"+getHtml("http://localhost:8080/club/api/apiServer.action?method=api_findGolfOrderById&&id=1"));
				//读取推荐城市
				////System.out.println("推荐城市:"+getHtml("http://localhost:8080/club/api/apiServer.action?method=api_findHnaProCity_comm"));
				//读取全部订单
				////System.out.println("读取全部订单:"+getHtml("http://localhost:8080/club/api/apiServer.action?method=api_findAllOrder"));
				//机场查询接口:
				////System.out.println("机场查询接口:"+getHtml("http://localhost:8080/club/api/apiServer.action?method=findLoungeByWhere"));
				////System.out.println("高尔夫异常订单:"+getHtml("/api/apiServer.action?method=api_findGolfOrderExcepByOrder&&orderId=029e3fd372434d27b645e6044d3ad1f2"));
				//				//System.out.println("机场订单查询接口:"+getHtml("http://localhost:8080/club/api/apiServer.action?method=findLoungeOrder"));
				//http://localhost:8080/club/api/apiServer.action?method=findLoungeInfoByComm
				////System.out.println("休息室搜索接口:"+getHtml("http://localhost:8080/club/api/apiServer.action?method=searchLounge"));
				
				////System.out.println("订单详细:"+getHtml("/api/apiServer.action?method=findLoungeOrderDetail&&id=LO_000001"));
				////System.out.println("休息室订单退订:"+getHtml("/api/apiServer.action?method=unsubscribeLoungeOrder&&id=LO_000001&&rmk=退一个人&&createUser=aaa&&guestIds=1,2"));
//				//System.out.println("订单详细:"+getHtml("/api/apiServer.action?method=findLoungeOrderDetail&&id=LO_000001"));
//				//System.out.println("休息室订单退订:"+getHtml("/api/apiServer.action?method=unsubscribeLoungeOrder&&id=LO_000001&&rmk=退一个人&&createUser=aaa&&guestIds=1,2additionalItemId=1,2"));
//				//System.out.println("订单详细:"+getHtml("/api/apiServer.action?method=findLoungeOrderDetail&&id=LO_000001"));
				
				//N代表normal 正常订单确认,    E代表exception 异常订单确认
//				//System.out.println("确认订单"+getHtml("http://localhost:8080/club/api/apiServer.action?method=verifyLoungeOrder&&id=73d6cd7d17114624a22100c0f826fba5&&type=N"));
				
				////System.out.println("取消订单:"+getHtml("/api/apiServer.action?method=cancelLoungeOrder&&id=LO_000001"));
				
				////System.out.println("休息室订单改期:"+getHtml("/api/apiServer.action?method=rescheduleLoungeOrder&&id=LO_000001&&startTime=2011-02-02/18:20&&endTime=2011-02-02/18:20&&createUser=aaa&&guestIds=1,2&&additionalItemId=1,2"));

//				//System.out.println("休息室订单改期:"+getHtml("/api/apiServer.action?method=rescheduleLoungeOrder&&id=LO_000001&&startTime=2011-02-02/18:20&&endTime=2011-02-02/18:20&&createUser=aaa&&guestIds=1,2"));
				
			////System.out.println("休息室退改信息:"+getHtml("/api/apiServer.action?method=findLoungeOrderException&&orderId=LO_000001"));
				
				//机场休息室订单日志查询
//				//System.out.println(getHtml("/apiJson/apiJsonService.action?method=findLoungeOrderLog&&orderId=b28923647d524678808124b00a0dfa5f"));
//				//System.out.println(getHtml("/api/apiServer.action?method=findLoungeOrderLog&&orderId=b28923647d524678808124b00a0dfa5f"));
				
				String str="a-b;c-d;";
				//System.out.println(str.replaceAll("(.*?)-(.*?);", "$2;"));
				System.out.println(getHtml("http://210.51.165.168:8380/web/phone/book/hotel_booking.jsp?memberId=1b19e865ed8742318ebc0e6a0283e0b6&hcode=0000130565&rcode=0000608560&idate=2011-09-26&odate=2011-09-30&adate=12:00-14:00&pnum=1&pname=娃儿&totalMoney=1592&isFirst=0&contact.name=高杰高杰&contact.mobile=18701690817&contact.email=123@123.com&contact.phone=18701690817&invoice.needtype=N&source=51666"));
				
			}

}
