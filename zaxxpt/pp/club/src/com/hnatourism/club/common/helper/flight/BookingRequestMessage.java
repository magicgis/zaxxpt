package com.hnatourism.club.common.helper.flight;

import java.util.List;

import com.hnatourism.club.common.helper.protocol.RequestMessage;
import com.hnatourism.club.flight.book.BookingFlightVo;
import com.hnatourism.club.flight.passenger.MemberPassengerVo;
import com.hnatourism.club.flight.web.vo.FlightContactVo;
import com.hnatourism.club.flight.web.vo.FlightItineraryVo;
import com.hnatourism.framework.utils.DateFormatUtils;
/**
	*机票预订请求串 wuyuhu
	*/	

public class BookingRequestMessage extends RequestMessage {
	
	private String memberId;
	private String prodType;
	private String orderSts;
	private String paySts;
	private String source;
	private BookingFlightVo bookingGoFlightVo;
	private BookingFlightVo bookingReturnFlightVo;
	private FlightContactVo flightContactVo;
	private FlightItineraryVo flightItineraryVo;
	private List<MemberPassengerVo> flightPassengerVoList;
	private String rmk;
	private String isFirst;
	

	@Override
	public String getRequsetString() {
		StringBuffer sb = new StringBuffer("");
		sb.append(BASE_REQUEST_URL);
		if(bookingReturnFlightVo==null){
			if("SZ".equals(bookingGoFlightVo.getFlightOrigin())||"GW".equals(bookingGoFlightVo.getFlightOrigin())){
				sb.append("/order/flight/flightApplyBooking.jsp?");
			}else{
				sb.append("/order/flight/flightBooking.jsp?");
			}
		}else{
			if("SZ".equals(bookingGoFlightVo.getFlightOrigin())){
				sb.append("/order/flight/flightApplyBooking.jsp?");
			}else if("GW".equals(bookingGoFlightVo.getFlightOrigin()) || "GW".equals(bookingReturnFlightVo.getFlightOrigin())){
				sb.append("/order/flight/flightApplyBooking.jsp?");
			}else{
				sb.append("/order/flight/flightBooking.jsp?");
			}
		}
		sb.append("memberId="+memberId);
		sb.append("&isFirst="+isFirst);
		sb.append("&prodType="+prodType);
		sb.append("&source="+source);
		//去程机票信息
		sb.append(getGoFlightParam());
		//行程单信息
		sb.append(getFlightItineraryParam());
		//联系人信息
		sb.append(getFlightContactParam());
		//乘机人信息
		sb.append(getPsnParam());
		//订单状态
		sb.append("&orderSts="+orderSts);
		//支付状态
		sb.append("&paySts="+paySts);
		//航班类型
		sb.append("&bookingGoFlightVo.prodType="+bookingGoFlightVo.getProdType());
		
		if("1".equals(prodType)){
			//返程信息
			sb.append(getReturnFlightParam());
			//航班类型
			sb.append("&bookingReturnFlightVo.prodType="+bookingReturnFlightVo.getProdType());
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * 拼接去程机票信息
	 * @return
	 */
	public String getGoFlightParam(){
		//转换舱位数量  >9时转换成A
		String cabinSeatNum = bookingGoFlightVo.getCabinSeatNum();
		if(">9".equals(cabinSeatNum)){
			cabinSeatNum ="A";
		}
		StringBuffer sb = new StringBuffer("");
		sb.append("&bookingGoFlightVo.adultBaf="+bookingGoFlightVo.getAdultBaf())
		.append("&bookingGoFlightVo.adultConstructionFee="+bookingGoFlightVo.getAdultConstructionFee())
		.append("&bookingGoFlightVo.adultNum="+bookingGoFlightVo.getAdultNum())
		.append("&bookingGoFlightVo.adultTicketPrice="+bookingGoFlightVo.getAdultTicketPrice())
		.append("&bookingGoFlightVo.adultTicketPricePar="+bookingGoFlightVo.getAdultTicketPricePar())
		.append("&bookingGoFlightVo.aircraftType="+bookingGoFlightVo.getAircraftType())
		.append("&bookingGoFlightVo.airlineCompany="+bookingGoFlightVo.getAirlineCompany())
		.append("&bookingGoFlightVo.airlineCompanyCode="+bookingGoFlightVo.getAirlineCompanyCode())
		.append("&bookingGoFlightVo.arrivalAirport="+bookingGoFlightVo.getArrivalAirport())
		.append("&bookingGoFlightVo.arrivalAirportCode="+bookingGoFlightVo.getArrivalAirportCode())
		.append("&bookingGoFlightVo.arrivalCity="+bookingGoFlightVo.getArrivalCity())
		.append("&bookingGoFlightVo.arrivalDate="+DateFormatUtils.format(bookingGoFlightVo.getArrivalDate(),"yyyy-MM-dd HH:mm:ss"))
		.append("&bookingGoFlightVo.arrivalDateStr="+DateFormatUtils.format(bookingGoFlightVo.getArrivalDate(),"yyyy-MM-dd"))
		.append("&bookingGoFlightVo.arrivalTimeStr="+DateFormatUtils.format(bookingGoFlightVo.getArrivalDate(),"HH:mm"))
		.append("&bookingGoFlightVo.cabinCode="+bookingGoFlightVo.getCabinCode())
		.append("&bookingGoFlightVo.cabinPriceOld="+bookingGoFlightVo.getCabinPriceOld())
		.append("&bookingGoFlightVo.cabinSeatNum="+cabinSeatNum)
		.append("&bookingGoFlightVo.changeInfo="+bookingGoFlightVo.getChangeInfo())
		.append("&bookingGoFlightVo.childBaf="+bookingGoFlightVo.getChildBaf())
		.append("&bookingGoFlightVo.childConstructionFee="+bookingGoFlightVo.getChildConstructionFee())
		.append("&bookingGoFlightVo.childNum="+bookingGoFlightVo.getChildNum())
		.append("&bookingGoFlightVo.childTicketPrice="+bookingGoFlightVo.getChildTicketPrice())
		.append("&bookingGoFlightVo.childTicketPricePar="+bookingGoFlightVo.getChildTicketPricePar())
		.append("&bookingGoFlightVo.departureAirport="+bookingGoFlightVo.getDepartureAirport())
		.append("&bookingGoFlightVo.departureAirportCode="+bookingGoFlightVo.getDepartureAirportCode())
		.append("&bookingGoFlightVo.departureCity="+bookingGoFlightVo.getDepartureCity())
		.append("&bookingGoFlightVo.departureDate="+DateFormatUtils.format(bookingGoFlightVo.getDepartureDate(),"yyyy-MM-dd HH:mm:ss"))
		.append("&bookingGoFlightVo.departureDateStr="+DateFormatUtils.format(bookingGoFlightVo.getDepartureDate(),"yyyy-MM-dd"))
		.append("&bookingGoFlightVo.departureTimeStr="+DateFormatUtils.format(bookingGoFlightVo.getDepartureDate(),"HH:mm"))
		.append("&bookingGoFlightVo.departureTerminal="+bookingGoFlightVo.getDepartureTerminal())
		.append("&bookingGoFlightVo.arrivalTerminal="+bookingGoFlightVo.getArrivalTerminal())
		.append("&bookingGoFlightVo.discount="+bookingGoFlightVo.getDiscount())
		.append("&bookingGoFlightVo.flightNo="+bookingGoFlightVo.getFlightNo())
		.append("&bookingGoFlightVo.flightType="+bookingGoFlightVo.getFlightType())
		.append("&bookingGoFlightVo.orderType="+"0")
		.append("&bookingGoFlightVo.personNum="+bookingGoFlightVo.getPersonNum())
		.append("&bookingGoFlightVo.policyCode="+bookingGoFlightVo.getPolicyCode())
		.append("&bookingGoFlightVo.source="+bookingGoFlightVo.getSource())
		.append("&bookingGoFlightVo.ticketPrice="+bookingGoFlightVo.getAdultTicketPrice())
		.append("&bookingGoFlightVo.ticketType="+bookingGoFlightVo.getTicketType())
		.append("&bookingGoFlightVo.totalBaf="+bookingGoFlightVo.getTotalBaf())
		.append("&bookingGoFlightVo.totalConstructionFee="+bookingGoFlightVo.getTotalConstructionFee())
		.append("&bookingGoFlightVo.totalMoney="+bookingGoFlightVo.getTotalMoney())
		.append("&bookingGoFlightVo.totalTicketPrice="+bookingGoFlightVo.getTotalTicketPrice())
		.append("&bookingGoFlightVo.totalCommissionRate="+bookingGoFlightVo.getTotalCommissionRate())
		.append("&bookingGoFlightVo.flightOrgin="+bookingGoFlightVo.getFlightOrigin());
		return sb.toString();
	}
	
	/**
	 * 拼接去程机票信息
	 * @return
	 */
	public String getReturnFlightParam(){
		//转换舱位数量  >9时转换成A
		String cabinSeatNum = bookingReturnFlightVo.getCabinSeatNum();
		if(">9".equals(cabinSeatNum)){
			cabinSeatNum ="A";
		}
		StringBuffer sb = new StringBuffer("");
		sb.append("&bookingReturnFlightVo.adultBaf="+bookingReturnFlightVo.getAdultBaf())
		.append("&bookingReturnFlightVo.adultConstructionFee="+bookingReturnFlightVo.getAdultConstructionFee())
		.append("&bookingReturnFlightVo.adultNum="+bookingReturnFlightVo.getAdultNum())
		.append("&bookingReturnFlightVo.adultTicketPrice="+bookingReturnFlightVo.getAdultTicketPrice())
		.append("&bookingReturnFlightVo.adultTicketPricePar="+bookingReturnFlightVo.getAdultTicketPricePar())
		.append("&bookingReturnFlightVo.aircraftType="+bookingReturnFlightVo.getAircraftType())
		.append("&bookingReturnFlightVo.airlineCompany="+bookingReturnFlightVo.getAirlineCompany())
		.append("&bookingReturnFlightVo.airlineCompanyCode="+bookingReturnFlightVo.getAirlineCompanyCode())
		.append("&bookingReturnFlightVo.arrivalAirport="+bookingReturnFlightVo.getArrivalAirport())
		.append("&bookingReturnFlightVo.arrivalAirportCode="+bookingReturnFlightVo.getArrivalAirportCode())
		.append("&bookingReturnFlightVo.arrivalCity="+bookingReturnFlightVo.getArrivalCity())
		.append("&bookingReturnFlightVo.arrivalDate="+DateFormatUtils.format(bookingReturnFlightVo.getArrivalDate(),"yyyy-MM-dd HH:mm:ss"))
		.append("&bookingReturnFlightVo.arrivalDateStr="+DateFormatUtils.format(bookingReturnFlightVo.getArrivalDate(),"yyyy-MM-dd"))
		.append("&bookingReturnFlightVo.arrivalTimeStr="+DateFormatUtils.format(bookingReturnFlightVo.getArrivalDate(),"HH:mm"))
		.append("&bookingReturnFlightVo.departureTerminal="+bookingReturnFlightVo.getDepartureTerminal())
		.append("&bookingReturnFlightVo.arrivalTerminal="+bookingReturnFlightVo.getArrivalTerminal())
		.append("&bookingReturnFlightVo.cabinCode="+bookingReturnFlightVo.getCabinCode())
		.append("&bookingReturnFlightVo.cabinPriceOld="+bookingReturnFlightVo.getCabinPriceOld())
		.append("&bookingReturnFlightVo.cabinSeatNum="+cabinSeatNum)
		.append("&bookingReturnFlightVo.changeInfo="+bookingReturnFlightVo.getChangeInfo())
		.append("&bookingReturnFlightVo.childBaf="+bookingReturnFlightVo.getChildBaf())
		.append("&bookingReturnFlightVo.childConstructionFee="+bookingReturnFlightVo.getChildConstructionFee())
		.append("&bookingReturnFlightVo.childNum="+bookingReturnFlightVo.getChildNum())
		.append("&bookingReturnFlightVo.childTicketPrice="+bookingReturnFlightVo.getChildTicketPrice())
		.append("&bookingReturnFlightVo.childTicketPricePar="+bookingReturnFlightVo.getChildTicketPricePar())
		.append("&bookingReturnFlightVo.departureAirport="+bookingReturnFlightVo.getDepartureAirport())
		.append("&bookingReturnFlightVo.departureAirportCode="+bookingReturnFlightVo.getDepartureAirportCode())
		.append("&bookingReturnFlightVo.departureCity="+bookingReturnFlightVo.getDepartureCity())
		.append("&bookingReturnFlightVo.departureDate="+DateFormatUtils.format(bookingReturnFlightVo.getDepartureDate(),"yyyy-MM-dd HH:mm:ss"))
		.append("&bookingReturnFlightVo.departureDateStr="+DateFormatUtils.format(bookingReturnFlightVo.getDepartureDate(),"yyyy-MM-dd"))
		.append("&bookingReturnFlightVo.departureTimeStr="+DateFormatUtils.format(bookingReturnFlightVo.getDepartureDate(),"HH:mm"))
		.append("&bookingReturnFlightVo.discount="+bookingReturnFlightVo.getDiscount())
		.append("&bookingReturnFlightVo.flightNo="+bookingReturnFlightVo.getFlightNo())
		.append("&bookingReturnFlightVo.flightType="+bookingReturnFlightVo.getFlightType())
		.append("&bookingReturnFlightVo.orderType="+"0")
		.append("&bookingReturnFlightVo.personNum="+bookingReturnFlightVo.getPersonNum())
		.append("&bookingReturnFlightVo.policyCode="+bookingReturnFlightVo.getPolicyCode())
		.append("&bookingReturnFlightVo.source="+bookingReturnFlightVo.getSource())
		.append("&bookingReturnFlightVo.ticketPrice="+bookingReturnFlightVo.getAdultTicketPrice())
		.append("&bookingReturnFlightVo.ticketType="+bookingReturnFlightVo.getTicketType())
		.append("&bookingReturnFlightVo.totalBaf="+bookingReturnFlightVo.getTotalBaf())
		.append("&bookingReturnFlightVo.totalConstructionFee="+bookingReturnFlightVo.getTotalConstructionFee())
		.append("&bookingReturnFlightVo.totalMoney="+bookingReturnFlightVo.getTotalMoney())
		.append("&bookingReturnFlightVo.totalTicketPrice="+bookingReturnFlightVo.getTotalTicketPrice())
		.append("&bookingReturnFlightVo.totalCommissionRate="+bookingReturnFlightVo.getTotalCommissionRate())
		.append("&bookingReturnFlightVo.flightOrgin="+bookingReturnFlightVo.getFlightOrigin());
		return sb.toString();
	}
	
	/**
	 * 拼接乘机人信息
	 * @return
	 */
	public String getPsnParam(){
		StringBuffer sb = new StringBuffer("");
		for(int i =0;i<flightPassengerVoList.size();i++){
			MemberPassengerVo mpasvo = flightPassengerVoList.get(i);
			sb.append("&flightPassengerVoList["+i+"].flightPassengerVo.name=")
			.append(mpasvo.getName())
			.append("&flightPassengerVoList["+i+"].flightPassengerVo.type=")
			.append(mpasvo.getType())
			.append("&flightPassengerVoList["+i+"].flightPassengerVo.certType=")
			.append(mpasvo.getCertType())
			.append("&flightPassengerVoList["+i+"].flightPassengerVo.certNo=")
			.append(mpasvo.getCertNo())
			.append("&flightPassengerVoList["+i+"].flightPassengerVo.goInsuranceNum=")
			.append(mpasvo.getGoInsuranceNum())
			.append("&flightPassengerVoList["+i+"].flightPassengerVo.returnInsuranceNum=")
			.append(mpasvo.getReturnInsuranceNum());
		}
		 sb.append("&passengerNum="+flightPassengerVoList.size());
		 
		return sb.toString();
	}
	
	/**
	 * 拼接联系人信息
	 * @return
	 */
	public String getFlightContactParam(){
		StringBuffer sb = new StringBuffer("");
		sb.append("&flightContactVo.email="+flightContactVo.getEmail())
		.append("&flightContactVo.mobile="+flightContactVo.getMobile())
		.append("&flightContactVo.name="+flightContactVo.getName())
		.append("&flightContactVo.id="+flightContactVo.getId())
		.append("&rmk="+rmk);
		return sb.toString();
	}
	
	/**
	 * 拼接行程单信息
	 * @return
	 */
	public String getFlightItineraryParam(){
		StringBuffer sb = new StringBuffer("");
		sb.append("&flightItineraryVo.address="+flightItineraryVo.getAddress())
		.append("&flightItineraryVo.city="+flightItineraryVo.getCity())
		.append("&flightItineraryVo.deliveryType="+flightItineraryVo.getDeliveryType())
		.append("&flightItineraryVo.mobile="+flightItineraryVo.getMobile())
		.append("&flightItineraryVo.postCode="+flightItineraryVo.getPostCode())
		.append("&flightItineraryVo.catchUser="+flightItineraryVo.getCatchUser());
		return sb.toString();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public BookingFlightVo getBookingGoFlightVo() {
		return bookingGoFlightVo;
	}

	public void setBookingGoFlightVo(BookingFlightVo bookingGoFlightVo) {
		this.bookingGoFlightVo = bookingGoFlightVo;
	}

	public FlightContactVo getFlightContactVo() {
		return flightContactVo;
	}

	public void setFlightContactVo(FlightContactVo flightContactVo) {
		this.flightContactVo = flightContactVo;
	}

	public FlightItineraryVo getFlightItineraryVo() {
		return flightItineraryVo;
	}

	public void setFlightItineraryVo(FlightItineraryVo flightItineraryVo) {
		this.flightItineraryVo = flightItineraryVo;
	}

	public List<MemberPassengerVo> getFlightPassengerVoList() {
		return flightPassengerVoList;
	}

	public void setFlightPassengerVoList(
			List<MemberPassengerVo> flightPassengerVoList) {
		this.flightPassengerVoList = flightPassengerVoList;
	}

	public BookingFlightVo getBookingReturnFlightVo() {
		return bookingReturnFlightVo;
	}

	public void setBookingReturnFlightVo(BookingFlightVo bookingReturnFlightVo) {
		this.bookingReturnFlightVo = bookingReturnFlightVo;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public String getOrderSts() {
		return orderSts;
	}

	public void setOrderSts(String orderSts) {
		this.orderSts = orderSts;
	}

	public String getPaySts() {
		return paySts;
	}

	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	
	
	
}
