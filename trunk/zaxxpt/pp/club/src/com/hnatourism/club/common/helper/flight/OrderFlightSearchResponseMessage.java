package com.hnatourism.club.common.helper.flight;

import java.util.ArrayList;
import java.util.List;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.flight.web.vo.OrderDetailVo;
/**
*订单列表解析类 wuyuhu
*/

public class OrderFlightSearchResponseMessage extends ResponseMessage {
	
	private String resultCode;
	private String message;
	private List<OrderDetailVo> orderDetailList;
	

	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		JSONObject result = (JSONObject) obj.get("result");
		resultCode = (String) result.get("resultCode");
		message = (String) result.get("message");
		parseOrderDetail((JSONArray)obj.get("fOrderList"));
	}

	/**
	 * 解析订单列表
	 * @param orderListJSONArr
	 */
	private void parseOrderDetail(JSONArray orderListJSONArr) {
		if(orderListJSONArr != null && !orderListJSONArr.isEmpty()){
			orderDetailList = new ArrayList<OrderDetailVo>();
			for (int i = 0; i < orderListJSONArr.size(); i++) {
				JSONObject orderJSONObj = (JSONObject)orderListJSONArr.get(i);
				OrderDetailVo order = new OrderDetailVo();
				order.setOrderId((String)orderJSONObj.get("orderId"));
				order.setCode((String)orderJSONObj.get("code"));
				order.setTotalMoney((String)orderJSONObj.get("totalMoney"));
				order.setCreateTime((String)orderJSONObj.get("createTime"));
				order.setDepAirportCode((String)orderJSONObj.get("depAirportCode"));
				order.setArrAirportCode((String)orderJSONObj.get("arrAirportCode"));
				order.setSts((String)orderJSONObj.get("sts"));
				order.setType((String)orderJSONObj.get("type"));
				order.setRmk((String)orderJSONObj.get("rmk"));
				orderDetailList.add(order);
			}
		}
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<OrderDetailVo> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetailVo> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
}
