package com.hnatourism.club.hotel.prod.web.newapivo;



/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:新版酒店接口详情,酒店详情基本信息
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelDetailsBaseVo {
	/** property 	*/
	private String code;

	/** property 	*/
	private String name;

	/** property 	*/
	private String addr;

	/** property 	*/
	private String phone;

	/** property 	*/
	private String signin;

	/** property 	*/
	private String hdesc;
	
	/** property 	*/
	private String sellpoint;
	
	/** property 	*/
	private String traffic;
	
	/** property 	*/
	private String origin;

	/** property 	*/
	private String longitude;

	/** property 	*/
	private String latitude;

	/** property 	*/
	private String ecoarea;

	/** property 	*/
	private String govarea;

	/** property 	*/
	private String star;

	/** property 	*/
	private String price;
	
	private HotelDetailVo details;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSignin() {
		return signin;
	}

	public void setSignin(String signin) {
		this.signin = signin;
	}

	public String getHdesc() {
		return hdesc;
	}

	public void setHdesc(String hdesc) {
		this.hdesc = hdesc;
	}

	public String getSellpoint() {
		return sellpoint;
	}

	public void setSellpoint(String sellpoint) {
		this.sellpoint = sellpoint;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getEcoarea() {
		return ecoarea;
	}

	public void setEcoarea(String ecoarea) {
		this.ecoarea = ecoarea;
	}

	public String getGovarea() {
		return govarea;
	}

	public void setGovarea(String govarea) {
		this.govarea = govarea;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public HotelDetailVo getDetails() {
		return details;
	}

	public void setDetails(HotelDetailVo details) {
		this.details = details;
	}
	
	
}
