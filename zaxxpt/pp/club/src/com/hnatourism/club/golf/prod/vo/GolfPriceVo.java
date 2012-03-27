package com.hnatourism.club.golf.prod.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hnatourism.framework.core.domain.AbstractEntity;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫产品价格VO
 * 
 * 历史版本:2010-08-04 v1.0.0 (高杰+栾晓东) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfPriceVo extends AbstractEntity
{
	//ID
	private String id;
	//消费说明
	private String explain;
	//场地ID
	private String siteId;
	//收费项目ID集合
	private String containItem;
	//平日签约价格
	private Double signingPrice;
	//平日销售价格
	private Double price;
	//平日提前预订日期
	private Long targeDate;
	//节假日签约价格
	private Double hSigningprice;
	//节假日销售价格
	private Double hPrice;
	//节假日提前预订日期
	private Long hTargeDate;
	//此价格开始时间
	private Date startTime;
	//此价格结束时间
	private Date endTime;
	//库存数
	private Long amount;
	//合同编号
	private String contractNo;
	//添加者
	private String createUser;
	//添加时间
	private Date createTime;
	//最后修改人
	private String updateUser;
	//最后修改时间
	private Date updateTime;
	//当天提前预定小时。
	private Integer advanceTime;
	//收费项目集合
	private List<SysConstantVo> itemList;
	//今天日期(yyyy-mm-dd)
	private String today;
	private String sts;
	private Double price_reg;
	private Double hprice_reg;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getContainItem() {
		return containItem;
	}
	public void setContainItem(String containItem) {
		this.containItem = containItem;
	}
	public Double getSigningPrice() {
		return signingPrice;
	}
	public void setSigningPrice(Double signingPrice) {
		this.signingPrice = signingPrice;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getTargeDate() {
		return targeDate;
	}
	public void setTargeDate(Long targeDate) {
		this.targeDate = targeDate;
	}
	public Double getHSigningprice() {
		return hSigningprice;
	}
	public void setHSigningprice(Double hSigningprice) {
		this.hSigningprice = hSigningprice;
	}
	public Long getHTargeDate() {
		return hTargeDate;
	}
	public void setHTargeDate(Long hTargeDate) {
		this.hTargeDate = hTargeDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public List<SysConstantVo> getItemList() {
		return itemList;
	}
	public void setItemList(List<SysConstantVo> itemList) {
		this.itemList = itemList;
	}
	public String getToday()
	{
		Date date=new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		today=bartDateFormat.format(date);
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Double getHPrice() {
		return hPrice;
	}
	public void setHPrice(Double hPrice) {
		this.hPrice = hPrice;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public Double gethSigningprice() {
		return hSigningprice;
	}
	public void sethSigningprice(Double hSigningprice) {
		this.hSigningprice = hSigningprice;
	}
	public Double getHprice_reg() {
		return hprice_reg;
	}
	public void setHprice_reg(Double hpriceReg) {
		hprice_reg = hpriceReg;
	}
	public Double getPrice_reg() {
		return price_reg;
	}
	public void setPrice_reg(Double priceReg) {
		price_reg = priceReg;
	}
	public Integer getAdvanceTime() {
		return advanceTime;
	}
	public void setAdvanceTime(Integer advanceTime) {
		this.advanceTime = advanceTime;
	}
}