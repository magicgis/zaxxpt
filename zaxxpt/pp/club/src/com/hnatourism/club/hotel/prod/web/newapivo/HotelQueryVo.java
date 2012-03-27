package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:酒店查询vo
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelQueryVo {
	
	private String city;// 城市code;//必填
	private String citySource;// 城市code来源;//必填,设置成hbe即可
	private String idate;// 入住日期;//必填
	private String odate;// 离店日期;//必填
	private String pageSize="10";// 分页大小;//选填
	private String pageNum="0";// 分页编号";//选填,从0开始
	private String sortField;// 排序字段;//选填,price----------价格,star-----------星级,distance-----距离(必须传当前客户端的GPS经纬度坐标)
	private String sortType;// 排序方式;//选填取值范围:asc-----------升序,desc---------降序
	private String x;// 客户端GPS经度坐标;//选填
	private String y;// 客户端GPS纬度坐标;//选填
	private String filterAreaType;// 过滤区域类型;//选填,取值范围:1-----------行政区,2-----------经济区
	private String filterAreaCode;// 过滤区域code;//选填
	private String filterPrice;// 过滤价格区间;//选填 区间最小值与区间最大值用逗号(,)分割,区间之间用竖线(|)分割// 例如:0,100|200,400
	private String filterStar;// 过滤星级;//选填 星级间用逗号(,)分割例如4,4.5,5
	private String distance;// 在地图上圆形查询的半径;//选填,单位为公里(必须传当前客户端的GPS经纬度坐标)
	private String source;// 来源;//必填
	private String key;// 新华旅行网分配的唯一授权码;//必填
	private String syssource;// 系统来源;//选填
	private String qword;//酒店查询关键字
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCitySource() {
		return citySource;
	}
	public void setCitySource(String citySource) {
		this.citySource = citySource;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getFilterAreaType() {
		return filterAreaType;
	}
	public void setFilterAreaType(String filterAreaType) {
		this.filterAreaType = filterAreaType;
	}
	public String getFilterAreaCode() {
		return filterAreaCode;
	}
	public void setFilterAreaCode(String filterAreaCode) {
		this.filterAreaCode = filterAreaCode;
	}
	public String getFilterPrice() {
		return filterPrice;
	}
	public void setFilterPrice(String filterPrice) {
		this.filterPrice = filterPrice;
	}
	public String getFilterStar() {
		return filterStar;
	}
	public void setFilterStar(String filterStar) {
		this.filterStar = filterStar;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSyssource() {
		return syssource;
	}
	public void setSyssource(String syssource) {
		this.syssource = syssource;
	}
	public String getQword() {
		return qword;
	}
	public void setQword(String qword) {
		this.qword = qword;
	}
	
}
