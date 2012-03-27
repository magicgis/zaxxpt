package com.hnatourism.club.golf.order.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.GolfPriceVo;
import com.hnatourism.club.golf.prod.vo.GolfSiteVo;
import com.hnatourism.framework.core.domain.AbstractEntity;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:高尔夫订单信息VO
 * 
 * 历史版本:2011-08-05 v1.0.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class GolfOrderVo extends AbstractEntity
{
	//确认时间
	private Date confirmTime;
	//订单状态ID
	private String sts;
	//总购球数
	private Long totalBall;
	//球场金额
	private Double price;
	//附加费用金额
	private Double additionalFee;
	//支付总金额
	private Double amountPrice;
	//支付状态ID
	private String paySts;
	//消费状态
	private String consumerSts;
	//订单锁定
	private String operateSts;
	//添加者
	private String createUser;
	//添加时间
	private Date createTime;
	//最后修改者
	private String updateUser;
	//最后修改时间
	private Date updateTime;
	// 订单号
	private String id;
	//场地ID
	private String siteId;
	//会员ID
	private String memberCode;
	//人数
	private Long count;
	//预订时间
	private Date bookTime;
	//来源
	private String source;
	//备注
	private String rmk;
	//编号
	private String code;
	//优惠方式区分
	private String  profit;
	//优惠金额
	private Double profitAmount;
	//签约价格
	private Double signPrice;
	//账单编号
	private String billId;
	//场地类型
	private String golfType;
	//场地
	private GolfSiteVo golfSiteVo;
	//球场
	private GolfInfoVo golfInfoVo;
	//打球人员表
	private List<GolfOrderPlayVo> golfOrderPlayVoList;
	//价格
	private GolfPriceVo golfPriceVo;
	//订单日志
	private List<GolfOrderLogVo> golfOrderLogVoList;
	//联系人
	private OrderContactVo orderContactVo;
	//异常订单
	private List<GolfOrderExceptionVo> golfOrderExceptionList=new ArrayList<GolfOrderExceptionVo>();
	
	public List<GolfOrderExceptionVo> getGolfOrderExceptionList() {
		return golfOrderExceptionList;
	}
	public void setGolfOrderExceptionList(
			List<GolfOrderExceptionVo> golfOrderExceptionList) {
		this.golfOrderExceptionList = golfOrderExceptionList;
	}
	public String getProfit() {
		return profit;
	}
	public Date getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public Long getTotalBall() {
		return totalBall;
	}
	public void setTotalBall(Long totalBall) {
		this.totalBall = totalBall;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAdditionalFee() {
		return additionalFee;
	}
	public void setAdditionalFee(Double additionalFee) {
		this.additionalFee = additionalFee;
	}
	public Double getAmountPrice() {
		return amountPrice;
	}
	public void setAmountPrice(Double amountPrice) {
		this.amountPrice = amountPrice;
	}
	public String getPaySts() {
		return paySts;
	}
	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}
	public String getConsumerSts() {
		return consumerSts;
	}
	public void setConsumerSts(String consumerSts) {
		this.consumerSts = consumerSts;
	}
	public String getOperateSts() {
		return operateSts;
	}
	public void setOperateSts(String operateSts) {
		this.operateSts = operateSts;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Date getBookTime() {
		return bookTime;
	}
	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}
	public Double getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(Double profitAmount) {
		this.profitAmount = profitAmount;
	}
	public Double getSignPrice() {
		return signPrice;
	}
	public void setSignPrice(Double signPrice) {
		this.signPrice = signPrice;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public GolfSiteVo getGolfSiteVo() {
		return golfSiteVo;
	}
	public void setGolfSiteVo(GolfSiteVo golfSiteVo) {
		this.golfSiteVo = golfSiteVo;
	}
	public GolfInfoVo getGolfInfoVo() {
		return golfInfoVo;
	}
	public void setGolfInfoVo(GolfInfoVo golfInfoVo) {
		this.golfInfoVo = golfInfoVo;
	}
	public List<GolfOrderPlayVo> getGolfOrderPlayVoList() {
		return golfOrderPlayVoList;
	}
	public void setGolfOrderPlayVoList(List<GolfOrderPlayVo> golfOrderPlayVoList) {
		this.golfOrderPlayVoList = golfOrderPlayVoList;
	}
	public GolfPriceVo getGolfPriceVo() {
		return golfPriceVo;
	}
	public void setGolfPriceVo(GolfPriceVo golfPriceVo) {
		this.golfPriceVo = golfPriceVo;
	}
	public List<GolfOrderLogVo> getGolfOrderLogVoList() {
		return golfOrderLogVoList;
	}
	public void setGolfOrderLogVoList(List<GolfOrderLogVo> golfOrderLogVoList) {
		this.golfOrderLogVoList = golfOrderLogVoList;
	}
	public OrderContactVo getOrderContactVo() {
		return orderContactVo;
	}
	public void setOrderContactVo(OrderContactVo orderContactVo) {
		this.orderContactVo = orderContactVo;
	}
	public String getGolfType() {
		return golfType;
	}
	public void setGolfType(String golfType) {
		this.golfType = golfType;
	}
}
