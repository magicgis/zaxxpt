package com.hnatourism.club.common.helper.flight;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.flight.book.BookingFlightVo;
import com.hnatourism.club.flight.web.vo.FlightCancelVo;
import com.hnatourism.club.flight.web.vo.FlightContactVo;
import com.hnatourism.club.flight.web.vo.FlightItineraryVo;
import com.hnatourism.club.flight.web.vo.FlightModifyVo;
import com.hnatourism.club.flight.web.vo.MemberPassengerVo;
import com.hnatourism.club.flight.web.vo.OrderFlightLogVo;
import com.hnatourism.framework.utils.StringUtils;

/**
*机票详情 解析类 wuyuhu
*/
public class OrderFlightDetailResponseMessage extends ResponseMessage {
	
	private String resultCode;
	private String message;
	private String orderId;
	private String code;
	private Date createTime;
	private Date createDate;
	private String totalMoney;
	private String actualMoney;
	private String sts;
	private String totalinsurance;
	private String insuranceNum;
	private String insurancePrice;
	private String insuranceSts;
	private String payType;
	private String paySts;
	private String flightType;
	private BookingFlightVo outBookingFlight;
	private BookingFlightVo inBookingFlight;
	private List<MemberPassengerVo> flightPassenger;
	private FlightContactVo contact;
	private BigDecimal totalBaf;
	private BigDecimal totalConstructionFee;
	private BigDecimal totalTicketPrice;
	private String deliveryFee;
	private BigDecimal totalTicketPricePar;
	private FlightItineraryVo flightItineraryVo;
	private String source;
	private String rmk;
	private List<OrderFlightLogVo> orderFlightLogList;
	//退票单详情
	private List<FlightCancelVo> flightCancelVoList;
	//改期单详情
	private List<FlightModifyVo> flightModifyVoList;

	public List<FlightModifyVo> getFlightModifyVoList() {
		return flightModifyVoList;
	}

	public void setFlightModifyVoList(List<FlightModifyVo> flightModifyVoList) {
		this.flightModifyVoList = flightModifyVoList;
	}

	public List<OrderFlightLogVo> getOrderFlightLogList() {
		return orderFlightLogList;
	}

	public void setOrderFlightLogList(List<OrderFlightLogVo> orderFlightLogList) {
		this.orderFlightLogList = orderFlightLogList;
	}

	@Override
	protected void parseBody(JSONObject obj){
		JSONObject result = (JSONObject) obj.get("result");
		resultCode = (String) result.get("resultCode");
		message = (String) result.get("message");
		orderId = (String) obj.get("orderId");
		code = (String) obj.get("code");
		String createTimeStr = (String) obj.get("createTime");
		String createDateStr = (String)obj.get("createDate");
		totalMoney = (String) obj.get("totalMoney");
		actualMoney = (String) obj.get("actualMoney");	
		deliveryFee = (String)((JSONObject)obj.get("itinerary")).get("deliveryFee");
		totalinsurance = (String)obj.get("totalinsurance");
		sts = (String) obj.get("sts");
		payType = (String) obj.get("payType");
		paySts = (String) obj.get("paySts");
		flightType = (String) obj.get("flightType");
		source =(String) obj.get("source");
		rmk = (String) obj.get("rmk");
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			createTime = fmt.parse(createTimeStr);
			createDate = fmt2.parse(createDateStr);
		}catch (ParseException e){
			e.printStackTrace();
		}
		//解析联系人信息
		parseFlightContact((JSONObject)obj.get("contact"));
		//解析乘机人信息
		paraseFlightpassenger((JSONArray)obj.get("flightPassenger"));
		//配送方式
		parseFlightItinerary((JSONObject)obj.get("itinerary"));
		//解析去程航班信息
		outBookingFlight = parseBookingFlight((JSONObject)obj.get("outBookingFlight"));
		outBookingFlight.setFlightType("1");
		//解析返程航班信息
		if(null!=(JSONObject)obj.get("inBookingFlight")){
			inBookingFlight = parseBookingFlight((JSONObject)obj.get("inBookingFlight"));
			inBookingFlight.setFlightType("2");
		}
		//解析订单日志信息
		orderFlightLogList = parseOrderLogList((String)obj.get("orderLogs"));
		//解析退票单信息
		parseFlightCancel((JSONArray)obj.get("flightReturn"));
		//解析该签单信息
		parseFlightModify((JSONArray)obj.get("flightModify"));
	}

	private void parseFlightModify(JSONArray flightModifyArray) {
		if(flightModifyArray!=null){
			flightModifyVoList = new ArrayList<FlightModifyVo>();
			for(int i=0; i<flightModifyArray.size(); i++){
				JSONObject flightModify = (JSONObject)flightModifyArray.get(i);
				FlightModifyVo flightModifyVo = new FlightModifyVo();
				flightModifyVo.setId((String)flightModify.get("id"));
				flightModifyVo.setOrderCode((String)flightModify.get("orderCode"));
				flightModifyVo.setBookingFlightId((String)flightModify.get("bookingFlightId"));
				flightModifyVo.setPassengerId((String)flightModify.get("passengerId"));
				flightModifyVo.setApplyNo((String)flightModify.get("applyNo"));
				flightModifyVo.setApplyUserTel((String)flightModify.get("applyUserTel"));
				flightModifyVo.setApplyUserCode((String)flightModify.get("applyUserCode"));
				try {
					flightModifyVo.setApplyDate(DateUtils.String2Date((String)flightModify.get("applyDate"), "yyyy-MM-dd HH:mm:ss"));
					flightModifyVo.setCreateTime(DateUtils.String2Date((String)flightModify.get("createTime"), "yyyy-MM-dd HH:mm:ss"));
					flightModifyVo.setUpdateTime(DateUtils.String2Date((String)flightModify.get("updateTime"), "yyyy-MM-dd HH:mm:ss"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				flightModifyVo.setCreateUserCode((String)flightModify.get("createUserCode"));
				flightModifyVo.setApplyOrderType((String)flightModify.get("applyOrderType"));
				flightModifyVo.setState((String)flightModify.get("state"));
				flightModifyVo.setCabinCode((String)flightModify.get("cabinCode"));
				flightModifyVo.setTicketPrice(new BigDecimal((String)flightModify.get("ticketPrice")));
				flightModifyVo.setDisc((String)flightModify.get("disc"));
				flightModifyVo.setModifyfee(new BigDecimal((String)flightModify.get("modifyfee")));
				flightModifyVo.setCreateUser((String)flightModify.get("createUser"));
				flightModifyVo.setUpdateUser((String)flightModify.get("updateUser"));
				flightModifyVo.setType((String)flightModify.get("type"));
				flightModifyVo.setSource((String)flightModify.get("source"));
				
				List<MemberPassengerVo> moFlightPassenger = new ArrayList<MemberPassengerVo>();
				JSONArray jsonMoFlightPassenger = (JSONArray)flightModify.get("flightPassenger");
				for (int j = 0; j < jsonMoFlightPassenger.size(); j++) {
					JSONObject jsonReMemberPassenger = (JSONObject)jsonMoFlightPassenger.get(j);
					MemberPassengerVo reMemberPassengerVo = new MemberPassengerVo();
					reMemberPassengerVo.setId((String)jsonReMemberPassenger.get("passengerId"));
					reMemberPassengerVo.setName((String)jsonReMemberPassenger.get("name"));
					reMemberPassengerVo.setType((String)jsonReMemberPassenger.get("type"));
					reMemberPassengerVo.setCertType((String)jsonReMemberPassenger.get("certType"));
					reMemberPassengerVo.setCertNo((String)jsonReMemberPassenger.get("certNo"));
					reMemberPassengerVo.setEtNo((String)jsonReMemberPassenger.get("etNo"));
					reMemberPassengerVo.setInsurance((String)jsonReMemberPassenger.get("insurance"));
					reMemberPassengerVo.setInsuranceCode((String)jsonReMemberPassenger.get("insuranceCode"));
					reMemberPassengerVo.setInsuranceNum((String)jsonReMemberPassenger.get("insuranceNum"));
					reMemberPassengerVo.setInsuranceSts((String)jsonReMemberPassenger.get("insuranceSts"));
					reMemberPassengerVo.setTicketSts((String)jsonReMemberPassenger.get("ticketSts"));
					reMemberPassengerVo.setTicketPrice((String)jsonReMemberPassenger.get("ticketPrice"));
					reMemberPassengerVo.setCommission((String)jsonReMemberPassenger.get("commission"));
					reMemberPassengerVo.setTotalCommission((String)jsonReMemberPassenger.get("commissionRate"));
					reMemberPassengerVo.setBafPrice((String)jsonReMemberPassenger.get("bafPrice"));
					reMemberPassengerVo.setConstructionPrice((String)jsonReMemberPassenger.get("constructionPrice"));
					reMemberPassengerVo.setPnr((String)jsonReMemberPassenger.get("pnr"));
					moFlightPassenger.add(reMemberPassengerVo);
				}
				flightModifyVo.setFlightPassenger(moFlightPassenger);
				flightModifyVoList.add(flightModifyVo);
			}
		}
	}

	private void parseFlightCancel(JSONArray flightCancelArray) {
		if(flightCancelArray!=null){
			flightCancelVoList = new ArrayList<FlightCancelVo>();
			for(int i=0; i<flightCancelArray.size(); i++){
				JSONObject flightCancel = (JSONObject)flightCancelArray.get(i);
				FlightCancelVo flightCancelVo = new FlightCancelVo();
				flightCancelVo.setId((String)flightCancel.get("id"));
				flightCancelVo.setOrderCode((String)flightCancel.get("orderCode"));
				flightCancelVo.setApplyNo((String)flightCancel.get("applyNo"));
				flightCancelVo.setPassengerId((String)flightCancel.get("passengerId"));
				flightCancelVo.setApplyMoney(new BigDecimal((String)flightCancel.get("applyMoney")));
				flightCancelVo.setReturnMoney(new BigDecimal((String)flightCancel.get("returnMoney")));
				flightCancelVo.setReturnRate(new BigDecimal((String)flightCancel.get("returnRate")));
				flightCancelVo.setProcedureFee(new BigDecimal((String)flightCancel.get("procedureFee")));
				flightCancelVo.setConstructionFee(new BigDecimal((String)flightCancel.get("constructionFee")));
				flightCancelVo.setBaf(new BigDecimal((String)flightCancel.get("baf")));
				flightCancelVo.setInsurance(new BigDecimal((String)flightCancel.get("insurance")));
				flightCancelVo.setAirOilInsurFee(new BigDecimal((String)flightCancel.get("airOilInsurFee")));
				flightCancelVo.setAnnexrefundment(new BigDecimal((String)flightCancel.get("annexrefundment")));
				flightCancelVo.setApplyUserTel((String)flightCancel.get("applyUserTel"));
				flightCancelVo.setApplyUserCode((String)flightCancel.get("applyUserCode"));
				flightCancelVo.setCreateUserCode((String)flightCancel.get("createUserCode"));
				flightCancelVo.setReturnType((String)flightCancel.get("returnType"));
				flightCancelVo.setCheckUserCode((String)flightCancel.get("checkUserCode"));
				flightCancelVo.setCheckContent((String)flightCancel.get("checkContent"));
				try {
					flightCancelVo.setApplyDate(DateUtils.String2Date((String)flightCancel.get("applyDate"), "yyyy-MM-dd HH:mm:ss"));
					flightCancelVo.setCreateTime(DateUtils.String2Date((String)flightCancel.get("createTime"), "yyyy-MM-dd HH:mm:ss"));
					flightCancelVo.setUpdateTime(DateUtils.String2Date((String)flightCancel.get("updateTime"), "yyyy-MM-dd HH:mm:ss"));
					flightCancelVo.setCheckDate(DateUtils.String2Date((String)flightCancel.get("checkDate"), "yyyy-MM-dd HH:mm:ss"));
					flightCancelVo.setCheckDateT(DateUtils.String2Date((String)flightCancel.get("checkDateT"), "yyyy-MM-dd HH:mm:ss"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				flightCancelVo.setCheckUserCodeT((String)flightCancel.get("checkUserCodeT"));
				flightCancelVo.setCheckContentT((String)flightCancel.get("checkContentT"));
				flightCancelVo.setApplyOrderType((String)flightCancel.get("applyOrderType"));
				flightCancelVo.setApplyOrderType((String)flightCancel.get("applyOrderType"));
				flightCancelVo.setState((String)flightCancel.get("state"));
				flightCancelVo.setDisc((String)flightCancel.get("disc"));
				flightCancelVo.setCreateUser((String)flightCancel.get("createUser"));
				flightCancelVo.setUpdateUser((String)flightCancel.get("updateUser"));
				flightCancelVo.setSource((String)flightCancel.get("source"));
				
				List<MemberPassengerVo> reFlightPassenger = new ArrayList<MemberPassengerVo>();
				JSONArray jsonReFlightPassenger = (JSONArray)flightCancel.get("flightPassenger");
				for (int j = 0; j < jsonReFlightPassenger.size(); j++) {
					JSONObject jsonReMemberPassenger = (JSONObject)jsonReFlightPassenger.get(j);
					MemberPassengerVo reMemberPassengerVo = new MemberPassengerVo();
					reMemberPassengerVo.setId((String)jsonReMemberPassenger.get("passengerId"));
					reMemberPassengerVo.setName((String)jsonReMemberPassenger.get("name"));
					reMemberPassengerVo.setType((String)jsonReMemberPassenger.get("type"));
					reMemberPassengerVo.setCertType((String)jsonReMemberPassenger.get("certType"));
					reMemberPassengerVo.setCertNo((String)jsonReMemberPassenger.get("certNo"));
					reMemberPassengerVo.setEtNo((String)jsonReMemberPassenger.get("etNo"));
					reMemberPassengerVo.setInsurance((String)jsonReMemberPassenger.get("insurance"));
					reMemberPassengerVo.setInsuranceCode((String)jsonReMemberPassenger.get("insuranceCode"));
					reMemberPassengerVo.setInsuranceNum((String)jsonReMemberPassenger.get("insuranceNum"));
					reMemberPassengerVo.setInsuranceSts((String)jsonReMemberPassenger.get("insuranceSts"));
					reMemberPassengerVo.setTicketSts((String)jsonReMemberPassenger.get("ticketSts"));
					reMemberPassengerVo.setTicketPrice((String)jsonReMemberPassenger.get("ticketPrice"));
					reMemberPassengerVo.setCommission((String)jsonReMemberPassenger.get("commission"));
					reMemberPassengerVo.setTotalCommission((String)jsonReMemberPassenger.get("commissionRate"));
					reMemberPassengerVo.setBafPrice((String)jsonReMemberPassenger.get("bafPrice"));
					reMemberPassengerVo.setConstructionPrice((String)jsonReMemberPassenger.get("constructionPrice"));
					reMemberPassengerVo.setPnr((String)jsonReMemberPassenger.get("pnr"));
					reFlightPassenger.add(reMemberPassengerVo);
				}
				flightCancelVo.setFlightPassenger(reFlightPassenger);
				flightCancelVoList.add(flightCancelVo);
			}
			
		}
	}

	private List<OrderFlightLogVo> parseOrderLogList(String allLogs) {
		// TODO Auto-generated method stub
		List<OrderFlightLogVo> list = new ArrayList<OrderFlightLogVo>();
		String[] logs = allLogs.split("    ");
//		System.out.println(logs.length);
		for(String log : logs){
			String[] str = log.split("   ");
			if(str.length==1)break;
			OrderFlightLogVo flightLogVo = new OrderFlightLogVo();
			flightLogVo.setCreateTime(str[0]);
			flightLogVo.setContent(str[1]);
			list.add(flightLogVo);
		}
		return list;
	}

	/**
	 * 解析乘机人信息
	 * @param flightPassengerJSONArr
	 * @author  wuyuhu
	 */
	private void paraseFlightpassenger(JSONArray flightPassengerJSONArr) {
		flightPassenger = new ArrayList<MemberPassengerVo>();
		double totalBafF=0.0;
		double totalConstructionFeeF=0.0;
		double totalTicketPriceF=0.0;
		double totalTicketPriceParF=0.0;
		double totalTicketPriceParTF=0.0;
		if(flightPassengerJSONArr != null && !flightPassengerJSONArr.isEmpty()){
			for (int i = 0; i < flightPassengerJSONArr.size(); i++) {
				JSONObject flightPassJSONObj = (JSONObject)flightPassengerJSONArr.get(i);
				MemberPassengerVo passenger = new MemberPassengerVo();
				passenger.setId((String)flightPassJSONObj.get("passengerId"));
				passenger.setName((String)flightPassJSONObj.get("name"));
				passenger.setType((String)flightPassJSONObj.get("type"));
				passenger.setFlightType((String)flightPassJSONObj.get("flightType"));
				passenger.setCertType((String)flightPassJSONObj.get("certType"));
				passenger.setCertNo((String)flightPassJSONObj.get("certNo"));
				passenger.setEtNo((String)flightPassJSONObj.get("etNo"));
				passenger.setTicketSts((String)flightPassJSONObj.get("ticketSts"));
				passenger.setPnr((String)flightPassJSONObj.get("pnr"));
				passenger.setTicketPrice((String)flightPassJSONObj.get("ticketPrice"));
				passenger.setBafPrice((String)flightPassJSONObj.get("bafPrice"));
				passenger.setConstructionPrice((String)flightPassJSONObj.get("constructionPrice"));
				passenger.setTotalCommission((String)flightPassJSONObj.get("commissionRate"));
				passenger.setCommission((String)flightPassJSONObj.get("commission"));
				passenger.setInsurance((String)flightPassJSONObj.get("insurance"));
				passenger.setInsuranceCode((String)flightPassJSONObj.get("insuranceCode"));
				passenger.setInsuranceSts((String)flightPassJSONObj.get("insuranceSts"));
				passenger.setInsuranceNum((String)flightPassJSONObj.get("insuranceNum"));
				totalBafF+=Double.parseDouble(passenger.getBafPrice());
				totalConstructionFeeF+=Double.parseDouble(passenger.getConstructionPrice());
				totalTicketPriceF+=Double.parseDouble(passenger.getTicketPrice());
				totalTicketPriceParF=Double.parseDouble(passenger.getCommission())+Double.parseDouble(passenger.getTicketPrice());
				totalTicketPriceParTF+=new BigDecimal(totalTicketPriceParF).multiply(new BigDecimal(1).subtract(new BigDecimal(passenger.getTotalCommission()).divide(new BigDecimal(100)))).setScale(0,BigDecimal.ROUND_UP).doubleValue();
				//totalTicketPriceParTF+=new BigDecimal(totalTicketPriceParF).multiply(new BigDecimal(1).subtract(new BigDecimal(passenger.getTotalCommission()))).setScale(0,BigDecimal.ROUND_UP).doubleValue();
				
				//System.out.println(i + " passenger.getBafPrice()="+passenger.getBafPrice());
				//System.out.println(i + " passenger.getConstructionPrice()="+passenger.getConstructionPrice());
				//System.out.println(i + " passenger.getTicketPrice()="+passenger.getTicketPrice());
				//System.out.println(i + " passenger.getCommission()="+passenger.getCommission());
				//System.out.println(i + " passenger.getTotalCommission()="+passenger.getTotalCommission());
				
				//System.out.println(i + " totalTicketPriceParF="+totalTicketPriceParF + ",totalTicketPriceParTF" +totalTicketPriceParTF);

				flightPassenger.add(passenger);
			}
			totalBaf=new BigDecimal(totalBafF);
			totalConstructionFee=new BigDecimal(totalConstructionFeeF);
			totalTicketPrice=new BigDecimal(totalTicketPriceF);
			totalTicketPricePar=new BigDecimal(totalTicketPriceParTF);
			//System.out.println(" totalBaf="+totalBaf);
			//System.out.println(" totalConstructionFee="+totalConstructionFee);
			//System.out.println(" totalTicketPrice="+totalTicketPrice);
			//System.out.println(" 产品签约价totalTicketPricePar="+totalTicketPricePar);
	}
	}
	/**
	 * 解析航班信息
	 * @param bookingFlightJsonObj
	 * @author  wuyuhu
	 * @return
	 */
	private BookingFlightVo parseBookingFlight(JSONObject bookingFlightJsonObj) {
		BookingFlightVo flightVo = new BookingFlightVo();
		flightVo.setDepartureAirportCode((String)bookingFlightJsonObj.get("depAirportCode"));
		flightVo.setDepartureAirport((String)bookingFlightJsonObj.get("depAirportCN"));
		flightVo.setArrivalAirportCode((String)bookingFlightJsonObj.get("arrAirportCode"));
		flightVo.setArrivalAirport((String)bookingFlightJsonObj.get("arrAirportCN"));
		flightVo.setAirlineCompany((String)bookingFlightJsonObj.get("airlineCompany"));
		flightVo.setAirlineCompanyCode((String)bookingFlightJsonObj.get("airlineCompanyCode"));
		flightVo.setFlightNo((String)bookingFlightJsonObj.get("flightNo"));
		flightVo.setCabinCode((String)bookingFlightJsonObj.get("cabinCode"));
		flightVo.setPnr((String)bookingFlightJsonObj.get("pnr"));
		flightVo.setCabinRule((String)bookingFlightJsonObj.get("cabinRule"));
		flightVo.setCabinPrice(StringUtils.isEmpty((String)bookingFlightJsonObj.get("cabinPrice"))?null:new BigDecimal((String)bookingFlightJsonObj.get("cabinPrice")));
		Date departureDate = null;
		Date arrDate=null;
		try{
			departureDate =DateUtils.parseDate((String)bookingFlightJsonObj.get("departureDate")+" "+(String)bookingFlightJsonObj.get("departureTime")+":00");
			arrDate =DateUtils.parseDate((String)bookingFlightJsonObj.get("departureDate")+" "+(String)bookingFlightJsonObj.get("arrivalTime")+":00");
			   if (arrDate.before(departureDate)) {
					DateUtils.addDays(arrDate,1);
				}
		}catch (ParseException e){
			e.printStackTrace();
		}
		flightVo.setDepartureDateStr((String)bookingFlightJsonObj.get("departureDate"));
		flightVo.setDepartureDate(departureDate);
		flightVo.setArrivalDate(arrDate);
		flightVo.setSpendTime(String.valueOf(DateUtils.getIntervalHours(departureDate, arrDate)));
		flightVo.setDepartureTimeStr((String)bookingFlightJsonObj.get("departureTime"));
		flightVo.setArrivalTimeStr((String)bookingFlightJsonObj.get("arrivalTime"));
		flightVo.setFlightOrigin((String)bookingFlightJsonObj.get("flightOrgin"));
		flightVo.setDepartureTerminal((String)bookingFlightJsonObj.get("departureTerminal"));
		flightVo.setArrivalTerminal((String)bookingFlightJsonObj.get("arrivalTerminal"));
		return flightVo;
	}

	/**
	 * 解析联系人信息
	 * @param flightContactJsonObj
	 * @author  wuyuhu
	 */
	private void parseFlightContact(JSONObject flightContactJsonObj) {
		if(flightContactJsonObj == null) return ;
		contact = new FlightContactVo();
		contact.setName((String)flightContactJsonObj.get("name"));
		contact.setMobile((String)flightContactJsonObj.get("phone"));
		contact.setEmail((String)flightContactJsonObj.get("email"));
	}
	//配送方式 
	private void parseFlightItinerary(JSONObject flightItineraryJsonObj) {
		if(flightItineraryJsonObj == null) return ;
		flightItineraryVo = new FlightItineraryVo();
		flightItineraryVo.setDeliveryType((String)flightItineraryJsonObj.get("deliveryType"));
		flightItineraryVo.setCatchUser((String)flightItineraryJsonObj.get("catchUser"));
		flightItineraryVo.setCity((String)flightItineraryJsonObj.get("city"));
		flightItineraryVo.setAddress((String)flightItineraryJsonObj.get("address"));
		flightItineraryVo.setPostCode((String)flightItineraryJsonObj.get("postcode"));
		flightItineraryVo.setMobile((String)flightItineraryJsonObj.get("mobile"));
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(String actualMoney) {
		this.actualMoney = actualMoney;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPaySts() {
		return paySts;
	}

	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public BookingFlightVo getOutBookingFlight() {
		return outBookingFlight;
	}

	public void setOutBookingFlight(BookingFlightVo outBookingFlight) {
		this.outBookingFlight = outBookingFlight;
	}

	public BookingFlightVo getInBookingFlight() {
		return inBookingFlight;
	}

	public void setInBookingFlight(BookingFlightVo inBookingFlight) {
		this.inBookingFlight = inBookingFlight;
	}

	public List<MemberPassengerVo> getFlightPassenger() {
		return flightPassenger;
	}

	public void setFlightPassenger(List<MemberPassengerVo> flightPassenger) {
		this.flightPassenger = flightPassenger;
	}

	public FlightContactVo getContact() {
		return contact;
	}

	public void setContact(FlightContactVo contact) {
		this.contact = contact;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getTotalTicketPrice() {
		return totalTicketPrice;
	}

	public void setTotalTicketPrice(BigDecimal totalTicketPrice) {
		this.totalTicketPrice = totalTicketPrice;
	}


	public BigDecimal getTotalBaf() {
		return totalBaf;
	}

	public void setTotalBaf(BigDecimal totalBaf) {
		this.totalBaf = totalBaf;
	}

	public BigDecimal getTotalConstructionFee() {
		return totalConstructionFee;
	}

	public void setTotalConstructionFee(BigDecimal totalConstructionFee) {
		this.totalConstructionFee = totalConstructionFee;
	}

	public FlightItineraryVo getFlightItineraryVo() {
		return flightItineraryVo;
	}

	public void setFlightItineraryVo(FlightItineraryVo flightItineraryVo) {
		this.flightItineraryVo = flightItineraryVo;
	}

	/**
	 * @return the deliveryFee
	 */
	public String getDeliveryFee() {
		return deliveryFee;
	}

	/**
	 * @param deliveryFee the deliveryFee to set
	 */
	public void setDeliveryFee(String deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public BigDecimal getTotalTicketPricePar() {
		return totalTicketPricePar;
	}

	public void setTotalTicketPricePar(BigDecimal totalTicketPricePar) {
		this.totalTicketPricePar = totalTicketPricePar;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getTotalinsurance() {
		return totalinsurance;
	}

	public void setTotalinsurance(String totalinsurance) {
		this.totalinsurance = totalinsurance;
	}

	public String getInsuranceNum() {
		return insuranceNum;
	}

	public void setInsuranceNum(String insuranceNum) {
		this.insuranceNum = insuranceNum;
	}

	public String getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(String insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public String getInsuranceSts() {
		return insuranceSts;
	}

	public void setInsuranceSts(String insuranceSts) {
		this.insuranceSts = insuranceSts;
	}

	public List<FlightCancelVo> getFlightCancelVoList() {
		return flightCancelVoList;
	}

	public void setFlightCancelVoList(List<FlightCancelVo> flightCancelVoList) {
		this.flightCancelVoList = flightCancelVoList;
	}
	
	

}
