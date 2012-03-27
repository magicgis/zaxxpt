package com.hnatourism.club.common.helper.flight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnatourism.club.common.helper.json.JSONArray;
import com.hnatourism.club.common.helper.json.JSONObject;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.helper.protocol.AirlineCompanyUtils;
import com.hnatourism.club.common.helper.protocol.ResponseMessage;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.flight.web.vo.FlightCabinInfoVo;
import com.hnatourism.club.flight.web.vo.FlightInfoVo;


/**
*解析机票列表 wuyuh
*/
public class SearchResponseMessage extends ResponseMessage {
	String arr;// 目的机场三字码
	String date;// 出发日期 格式为yyyyMMdd
	String dpt;// 出发机场三字码
	String backdate;//返回日期 格式yyyyMMdd
	String cabin;// 航位
	String carrier;// 航空公司
	String dptTime;// 起飞时间0(0不限；1为6-8点；2为)
	String fType;
	ArrayList<FlightInfoVo> outBoundsList;
	ArrayList<FlightInfoVo> inBoundsList;
	//去程出发时间用于过滤
	String deAirportDateStr;
	boolean isReturnFlight;
	public boolean IsReturnFlight() {
		return isReturnFlight;
	}

	public void setIsReturnFlight(boolean isReturnFlight) {
		this.isReturnFlight = isReturnFlight;
	}

	public String getDeAirportDateStr() {
		return deAirportDateStr;
	}

	public void setDeAirportDateStr(String deAirportDateStr) {
		this.deAirportDateStr = deAirportDateStr;
	}

	@Override
	protected void parseBody(JSONObject obj) throws ParseException {
		arr = (String) obj.get("arr");
		date = (String) obj.get("date");
		dpt = (String) obj.get("dpt");	
		backdate = (String)obj.get("backdate");
		cabin = (String) obj.get("cabin");
		carrier = (String) obj.get("carrier");
		dptTime = (String) obj.get("dptTime");
		// 全部去程数据
		
		outBoundsList = new ArrayList<FlightInfoVo>();
		inBoundsList = new ArrayList<FlightInfoVo>();
		
		JSONArray outBounds = (JSONArray) obj.get("outBounds");
		if (outBounds != null) {
			extractFlightInfos(outBounds, outBoundsList,"1");
		}
		JSONArray inBounds = (JSONArray) obj.get("inBounds");
		if (inBounds != null) {
			extractFlightInfos(inBounds, inBoundsList,"2");
		}

	}

	private void extractFlightInfos(JSONArray bounds,
			List<FlightInfoVo> boundsList,String flag) {

		FlightInfoVo flightInfoVo;
		for (int i = 0; i < bounds.size(); i++) {
			JSONObject info = (JSONObject) bounds.get(i);
			flightInfoVo = new FlightInfoVo();
			String year = date.substring(0,4);
			String month = date.substring(4, 6);
			String day = date.substring(6, 8);
			if("2".equals(flag)){
				 year = backdate.substring(0,4);
				 month = backdate.substring(4, 6);
				 day = backdate.substring(6, 8);
			}
			
			String date2 = year+"-"+month+"-"+day;
			String dptTime = (String)info.get("dptTime");
			dptTime = dptTime.substring(0,2)+":"+dptTime.substring(2,4);
			String arrTime = (String)info.get("arrTime");
			arrTime = arrTime.substring(0,2)+":"+arrTime.substring(2,4);
			if(true==isReturnFlight){
			try {
				Date reAriportDate=DateUtils.String2Date(year+"-"+month+"-"+day+" "+dptTime+":00");
				Date goAriportDate=DateUtils.String2Date(deAirportDateStr+":00");
				if(reAriportDate.before(goAriportDate)){
					continue;
				}
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			}
			flightInfoVo.setTripDate(date2+" "+dptTime+":00");
			flightInfoVo.setDepartureTime(dptTime);
			flightInfoVo.setArrivalDate(date2+" "+arrTime+":00");
			flightInfoVo.setArrivalTime(arrTime);
			flightInfoVo.setArrivalAirport((String) info.get("arrAirport"));
			flightInfoVo.setArrivalAirportCode((String) info.get("arrAirport"));
			flightInfoVo.setYprice((String) info.get("cabinYPrice"));
			flightInfoVo.setAirlineCompany(AirlineCompanyUtils.getCodeByName((String) info.get("carrier")));
			flightInfoVo.setAirlineCompanyCode((String) info.get("carrier"));
			flightInfoVo.setFlightNo((String) info.get("code"));
			flightInfoVo.setDepartureAirport((String) info.get("dptAirPort"));
			flightInfoVo.setDepartureAirportCode((String) info.get("dptAirPort"));
			//Log.i("dptAirPort", (String)info.get("dptAirPort")+":"+ info.get("dptAirPort"));
			flightInfoVo.setMeal((String) info.get("meal"));
			//机型
			flightInfoVo.setAircraftType((String) info.get("plantype"));
			flightInfoVo.setConstructionFee((String) info.get("constructionFee"));
			flightInfoVo.setAdultBaf((String) info.get("adulBaf"));
			flightInfoVo.setChildBaf((String) info.get("childBaf"));
			//航站楼
			flightInfoVo.setDepartureTerminal((String)info.get("deStop"));
			flightInfoVo.setArrivalTerminal((String)info.get("arStop"));
			//政策ID
			FlightCabinInfoVo flightCabinInfoLowest = new FlightCabinInfoVo();
			//仓位code
			flightCabinInfoLowest.setCabinCode((String) info.get("lowestCabinCode"));
			//仓位中文
			flightCabinInfoLowest.setCabinName((String) info.get("lowestCabinCN"));
			//仓位数量
			flightCabinInfoLowest.setCabinSeatNum((String) info.get("lowestSeatNum"));
			//折扣
			flightCabinInfoLowest.setDiscount(new BigDecimal(info.get("discount").toString()));
			//成人票价
			flightCabinInfoLowest.setAdultTicketPrice(info.get("lowestPrice").toString());
			//成人票面价
			flightCabinInfoLowest.setAdultTicketPricePar(info.get("lowestPricePar").toString());
			//儿童票价
			flightCabinInfoLowest.setChildTicketPrice((String) info.get("lowestChildTicket"));
			//儿童票面价
			flightCabinInfoLowest.setChildTicketPricePar((String) info.get("lowestChildTicketPar"));
			//儿童机建
			flightCabinInfoLowest.setChildConstructionFee((String) info.get("childConstructionFee"));
			//儿童燃油
			flightCabinInfoLowest.setChildBaf((String) info.get("childBaf"));
			//成人基建
			flightCabinInfoLowest.setAdultConstructionFee((String) info.get("constructionFee"));
			//成人燃油
			flightCabinInfoLowest.setAdultBaf((String) info.get("adulBaf"));
			//政策ID
			flightCabinInfoLowest.setPolicyCode((String) info.get("pCode"));
			//原始折扣
			flightCabinInfoLowest.setCabinDiscount((String) info.get("lowestCabinDiscount"));
			//退改签
			if(null == info.get("changeInfo")){
				flightCabinInfoLowest.setChangeInfo("暂无退改签规则！<br/>如需进行退改签请联系客服人员！<br/>客服电话：950719");	
			}
			else{
				flightCabinInfoLowest.setChangeInfo((String)info.get("changeInfo"));
			}
			//佣金比例
			flightCabinInfoLowest.setCommissionRate((String)info.get("commissionRate"));
			//来源
			flightCabinInfoLowest.setFlightOrgin((String) info.get("flightOrgin"));
			//最低价仓位
			flightInfoVo.setFlightCabinInfoVo(flightCabinInfoLowest);
			JSONArray cabins = (JSONArray) info.get("Cabins");
				FlightCabinInfoVo cabinInfo;
				ArrayList<FlightCabinInfoVo> flightCabinInfoList = new ArrayList<FlightCabinInfoVo>();
				//将cabin位list外的推荐仓位放入cabinList中
				if(cabins != null){
				for (int j = 0; j < cabins.size(); j++) {
					JSONObject cabin = (JSONObject) cabins.get(j);
					cabinInfo = new FlightCabinInfoVo();
					cabinInfo.setCabinCode((String) cabin.get("cabinCode"));//仓位CODE
					cabinInfo.setCabinName((String)cabin.get("cabinCN"));//仓位名
					cabinInfo.setAdultTicketPrice((String) cabin.get("price"));//仓位价格成人
					cabinInfo.setAdultTicketPricePar((String) cabin.get("pricePar"));
					cabinInfo.setChildTicketPrice((String) cabin.get("childPrice"));//仓位价格儿童
					cabinInfo.setChildTicketPricePar((String) cabin.get("childPricePar"));
					cabinInfo.setCabinSeatNum((String) cabin.get("seatNum"));//仓位数
					cabinInfo.setDiscount(new BigDecimal((String) cabin.get("discount")));//仓位折扣
					cabinInfo.setChildConstructionFee((String) info.get("childConstructionFee"));//儿童机建
					cabinInfo.setChildBaf((String) info.get("childBaf"));//儿童燃油
					cabinInfo.setAdultConstructionFee((String) info.get("constructionFee"));//成人基建
					cabinInfo.setAdultBaf((String) info.get("adulBaf"));//成人燃油
					cabinInfo.setPolicyCode((String) cabin.get("pCode"));//政策ID
					cabinInfo.setCabinDiscount((String)cabin.get("cabinDiscount"));
					if(null==cabin.get("changeInfo")){
						cabinInfo.setChangeInfo("暂无退改签规则！<br/>如需进行退改签请联系客服人员！<br/>客服电话：950719");
					}
					else{
						cabinInfo.setChangeInfo((String) cabin.get("changeInfo"));//退改签
					}
					
					cabinInfo.setCommissionRate((String) cabin.get("commissionRate"));//佣金比率
					//来源
					cabinInfo.setFlightOrgin((String) cabin.get("flightOrgin"));
					flightCabinInfoList.add(cabinInfo);
				}
			}
				flightInfoVo.setFlightCabinInfoVoList(flightCabinInfoList);
				boundsList.add(flightInfoVo);
		}
	}
	
	public String getArr() {
		return arr;
	}

	public String getDate() {
		return date;
	}

	public String getDpt() {
		return dpt;
	}

	public String getCabin() {
		return cabin;
	}

	public String getCarrier() {
		return carrier;
	}

	public String getDptTime() {
		return dptTime;
	}

	public void setFType(String type) {
		fType = type;
	}

	public ArrayList<FlightInfoVo> getOutBoundsList() {
		return outBoundsList;
	}

	public ArrayList<FlightInfoVo> getInBoundsList() {
		return inBoundsList;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "SearchResponseMessage ( "
	        + super.toString() + TAB
	        + "arr = " + this.arr + TAB
	        + "date = " + this.date + TAB
	        + "dpt = " + this.dpt + TAB
	        + "cabin = " + this.cabin + TAB
	        + "carrier = " + this.carrier + TAB
	        + "dptTime = " + this.dptTime + TAB
	        + "outBoundsList = " + this.outBoundsList + TAB
	        + "inBoundsList = " + this.inBoundsList + TAB
	        + " )";
	
	    return retValue;
	}

	public String getBackdate() {
		return backdate;
	}

	

}
