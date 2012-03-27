package com.hnatourism.club.pay.order.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.base.domain.SysRole;
import com.hnatourism.club.base.service.ISysRoleService;
import com.hnatourism.club.common.service.BaseAbstractService;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.pay.order.dao.IOrderBillDao;
import com.hnatourism.club.pay.order.domain.OrderBill;
import com.hnatourism.club.pay.order.service.IOrderBillService;
import com.hnatourism.club.pay.order.web.vo.OrderBillVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.exception.ValidateException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.DateUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.UserUtil;
import com.hnatourism.framework.web.vo.AbstractVo;
import com.hnatourism.framework.web.vo.BaseUserVo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:账单表
 * 
 * 历史版本: 2011-08-09 v1.0.0 (hna) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class OrderBillServiceImpl extends BaseAbstractService implements
		IOrderBillService {
	private static final Log log = LogFactory
			.getLog(OrderBillServiceImpl.class);
	private IOrderBillDao orderBill2Dao;
	private ISysRoleService sysRoleService;
	/**
	 * 【根据条件查询】@author 苏忆
	 * 
	 * @param vo
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<OrderBill> findBillByWhere(OrderBill vo, PageInfo pageInfo)
			throws BusinessException {

		if (null == vo) {
			vo = new OrderBill();
		}
		OrderBill ob = new OrderBill();
		// 交易号
		if (vo.getTradeNo() != null) {
			ob.setTradeNo(vo.getTradeNo());
		}
		// 开始时间
		if (null != vo.getStartDate()) {
			ob.setStartDate(vo.getStartDate());
		}
		// 结束时间
		if (null != vo.getEndDate()) {
			ob.setEndDate(vo.getEndDate());
		}
		//pageInfo.setRowsOfPage(10);

		List List = orderBill2Dao.findBillByWhere(ob, pageInfo);

		OrderBill vos = new OrderBill();
		List<OrderBill> list = new ArrayList<OrderBill>();
		for (Object temp : List) {
			Map map = (HashMap) temp;
			try {
				vos = mapData2Vo(map);
				// 异常该如何处理?
			} catch (ParseException e) {
				e.printStackTrace();
			}
			list.add(vos);
		}
		Page page = new Page();
		page.setData(list);
		return list;
	}

	/**
	 * @description 【Bill map转换成vo】
	 * @param map
	 * @return
	 * @createTime 2011-8-31 上午10:23:14
	 * @author 苏忆
	 * @throws ParseException
	 */
	public OrderBill mapData2Vo(Map map) throws ParseException {
		// 返回结果
		OrderBill vo = new OrderBill();
		// 转化数据
		// 账单ID
		vo.setAccountId(String.valueOf(map.get("accountid")) == "null" ? ""
				: String.valueOf(map.get("accountid")));
		// 角色ID
		vo.setRoleId(String.valueOf(map.get("roleid")) == "null" ? "" : String
				.valueOf(map.get("roleid")));
		// 账单类型 交易方式
		vo.setType(String.valueOf(map.get("type")) == "null" ? "" : String
				.valueOf(map.get("type")));
		// 角色名称
		vo.setRoleName(String.valueOf(map.get("rolename")) == "null" ? ""
				: String.valueOf(map.get("rolename")));
		// 交易金额
		BigDecimal mny = (BigDecimal) map.get("amount");
		if (mny != null) {
			vo.setAmount(mny.floatValue());
		}
		// 账号
		vo.setAccount(String.valueOf(map.get("account")) == "null" ? ""
				: String.valueOf(map.get("account")));
		// 交易号
		vo.setTradeNo(String.valueOf(map.get("trade_no")) == "null" ? ""
				: String.valueOf(map.get("trade_no")));
		// 交易时间
		Date tradeDate = (Date) (map.get("trade_time"));
		if (tradeDate != null) {
			vo.setTradeTime(tradeDate);
		}
		// 更新时间
		Date updateTime = (Date) (map.get("updatetime"));
		if (updateTime != null) {
			vo.setUpdateTime(updateTime);
		}
		// 创建时间
		Date createTime = (Date) (map.get("createtime"));
		if (createTime != null) {
			vo.setCreateTime(createTime);
		}

		// 更新人
		vo.setUpdateUser(String.valueOf(map.get("updateuser")) == "null" ? ""
				: String.valueOf(map.get("updateuser")));
		// 创建人
		vo.setCreateUser(String.valueOf(map.get("createuser")) == "null" ? ""
				: String.valueOf(map.get("createuser")));
		// 订单类型
		vo.setOrderType(String.valueOf(map.get("ordertype")) == "null" ? ""
				: String.valueOf(map.get("ordertype")));
		// 产品类型
		vo.setProductType(String.valueOf(map.get("producttype")) == "null" ? ""
				: String.valueOf(map.get("producttype")));
		// 订单code
		vo.setOrderCode(String.valueOf(map.get("ordercode")) == "null" ? ""
				: String.valueOf(map.get("ordercode")));

		// 交易类型
		vo.setTransactionType(String.valueOf(map.get("transaction_type")) == "null" ? ""
						: String.valueOf(map.get("transaction_type")));

		// 手续费
		if (map.get("commission") != null) {
			BigDecimal commission = (BigDecimal) map.get("commission");
			if (commission != null) {
				vo.setCommission(commission.floatValue());
			}
		}

		// 状态
		vo.setStatus(String.valueOf(map.get("status")) == "null" ? "" : String
				.valueOf(map.get("status")));
		return vo;
	}

	/**
	 * 【新增】（系统生成方法）
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Object insert(AbstractVo vo) throws BusinessException {
		BaseUserVo user = UserUtil.getUserVo();
		// validate data
		validateData(vo);
		// validate uniqueness
		// if (!checkUniqueness(vo)) {
		// throw new BusinessException("notUnique");
		// }
		OrderBill domain = new OrderBill();
		BeanUtils.copyProperties((OrderBillVo) vo, domain);
		// domain.setId(SnoGerUtil.getUUID());
		// domain.setCreateUser(user.getUsername());
		// domain.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
		return orderBill2Dao.insert(domain);
	}

	/**
	 * 【删除】（系统生成方法）
	 * 
	 * @param id
	 * @throws BusinessException
	 */
	@Override
	public int delete(String id) throws BusinessException {
		return orderBill2Dao.delete(id);
	}

	/**
	 * 【修改】（系统生成方法）
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public int update(AbstractVo vo) throws BusinessException {
		BaseUserVo user = UserUtil.getUserVo();
		// validate data
		validateData(vo);

		OrderBill domain = new OrderBill();
		BeanUtils.copyProperties((OrderBillVo) vo, domain);
		domain.setUpdateUser(user.getUsername());
		domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return orderBill2Dao.update(domain);
	}

	/**
	 * 【修改】（系统生成方法）
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public int updateClear(AbstractVo vo) throws BusinessException {
		// validate data
		validateData(vo);
		OrderBill domain = new OrderBill();
		BeanUtils.copyProperties((OrderBillVo) vo, domain);
		return orderBill2Dao.update(domain);
	}

	
	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List findByWhere(AbstractVo vo) throws BusinessException {
		OrderBill domain = new OrderBill();
		BeanUtils.copyProperties((OrderBillVo) vo, domain);
		List<OrderBill> list = orderBill2Dao.findByWhere(domain);
		OrderBillVo returnVo = null;
		List<OrderBillVo> voList = new ArrayList();
		for (OrderBill temp : list) {
			returnVo = new OrderBillVo();
			BeanUtils.copyProperties(temp, returnVo);
			voList.add(returnVo);
		}
		return voList;
	}

	/**
	 * 【根据条件查询】（系统生成方法）
	 * 
	 * @param vo
	 * @param pageInfo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Page findByWhere(AbstractVo vo, PageInfo pageInfo)
			throws BusinessException {
		OrderBill domain = new OrderBill();
		BeanUtils.copyProperties((OrderBillVo) vo, domain);
		Page page = orderBill2Dao.findByWhere(domain, pageInfo);
		OrderBillVo returnVo = null;
		List<OrderBillVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			OrderBill orderBill = (OrderBill) temp;
			returnVo = new OrderBillVo();
			BeanUtils.copyProperties(orderBill, returnVo);
			voList.add(returnVo);
		}
		page.setData(voList);
		return page;
	}

	/**
	 * 【根据ID查询】（系统生成方法）
	 * 
	 * @param id
	 * @throws BusinessException
	 */
	@Override
	public AbstractVo findById(String id) throws BusinessException {
		OrderBill domain = orderBill2Dao.findById(id);
		OrderBillVo vo = null;
		if (domain != null) {
			vo = new OrderBillVo();
			BeanUtils.copyProperties(domain, vo);
		}
		return vo;
	}

	/**
	 * 【校验唯一性】（系统生成方法）通常在insert,update前使用
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public boolean checkUniqueness(AbstractVo vo) throws BusinessException {
		boolean isUnique = false;
		OrderBillVo checkVo = (OrderBillVo) vo;

		OrderBillVo qryVo = new OrderBillVo();

		// start
		// qryVo.set...(checkVo.get...());
		// end

		List voList = findByWhere(qryVo);
		if (ListUtils.isEmpty(voList)) {
			isUnique = true;
		}
		return isUnique;
	}
	//分润前插入数据
	public void insertOrderBill(SubRunBean subRunBean,MemberInfoVo user){
		try {
			//调用封装好的接口返回subRunBean
			//SubRunBean subRunBean = new SubRunBean();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			//角色      GOLD金管家      PLATINUM白金管家     DIAMOND钻石管家       GOVERNMENT政企管家
			SysRole sysRole = new SysRole();
			sysRole.setCode(subRunBean.getRoleCode());
			List<SysRole> list_sysRole = sysRoleService.findByWhere(sysRole);
			if(list_sysRole != null && list_sysRole.size()>0){
				sysRole = list_sysRole.get(0);
			}
			// 分润支付插入账单表

			OrderBill orderBill = new OrderBill();
			//源账户
			if(subRunBean.getOrderPrice() != null && subRunBean.getOrderPrice() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getName());
				orderBill.setRoleId(sysRole.getId()); //角色id，sys_role
				orderBill.setAccount(subRunBean.getCardNo());// 会员账户
				orderBill.setAmount(subRunBean.getOrderPrice().floatValue());// 支付金额
				orderBill.setStatus("00");//支付状态00：未支付
				//orderBill.setTradeNo(trade_no);   // 会员账户
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setTransactionType("0");
				orderBill.setCommission(Float.valueOf(0));
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//用户账户返积分
			if(subRunBean.getOrderRetPrice() != null && subRunBean.getOrderRetPrice() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				//orderBill.setTradeNo(trade_no);   // 会员账户
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId(sysRole.getId()); //角色id，sys_role
				orderBill.setAccount(subRunBean.getAccount());// 会员账户
				orderBill.setAmount(subRunBean.getOrderRetPrice().floatValue());// 支付金额
				orderBill.setTransactionType("1");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//供应商帐号
			if(subRunBean.getOrderSignprice() != null && subRunBean.getOrderSignprice() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getName());
				//orderBill.setTradeNo(trade_no);   // 会员账户
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId("1108240331110002824"); //角色id，sys_role
				orderBill.setAccount(subRunBean.getSellerCardNo());// 会员账户
				orderBill.setAmount(subRunBean.getOrderSignprice().floatValue());// 支付金额
				orderBill.setTransactionType("0");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//分公司帐号
			if(subRunBean.getSubCorpNoMoney() != null && subRunBean.getSubCorpNoMoney() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getName());
				//orderBill.setTradeNo(trade_no);   // 会员账户
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId("1108240331110002825"); //角色id，sys_role
				orderBill.setAccount(subRunBean.getSubCorpAccount());// 会员账户
				orderBill.setAmount(subRunBean.getSubCorpNoMoney().floatValue());// 支付金额
				orderBill.setTransactionType("0");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//平台帐号
			if(subRunBean.getPlatformNoMoney()!= null && subRunBean.getPlatformNoMoney() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getName());
				//orderBill.setTradeNo(trade_no);   // 会员账户
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId(""); //角色id，sys_role
				orderBill.setAccount(subRunBean.getPlatformAccount());// 会员账户
				orderBill.setAmount(subRunBean.getPlatformNoMoney().floatValue());// 支付金额
				orderBill.setTransactionType("0");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);

			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//改期前插入数据
	public void insertOrderChangeBill(SubRunBean subRunBean){
		try {
			//调用封装好的接口返回subRunBean
			//SubRunBean subRunBean = new SubRunBean();
			
			BaseUserVo user = UserUtil.getUserVo();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			//角色      GOLD金管家      PLATINUM白金管家     DIAMOND钻石管家       GOVERNMENT政企管家
			SysRole sysRole = new SysRole();
			sysRole.setCode(subRunBean.getRoleCode());
			List<SysRole> list_sysRole = sysRoleService.findByWhere(sysRole);
			if(list_sysRole != null && list_sysRole.size()>0){
				sysRole = list_sysRole.get(0);
			}
			// 分润支付插入账单表
			OrderBill orderBill = new OrderBill();
			//源账户
			if(subRunBean.getAmountMoney() != null && subRunBean.getAmountMoney() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				orderBill.setRoleId(sysRole.getId()); //角色id，sys_role
				orderBill.setAccount(subRunBean.getCardNo());// 会员账户
				orderBill.setAmount(subRunBean.getAmountMoney().floatValue());// 支付金额
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setTransactionType("5");
				orderBill.setCommission(Float.valueOf(0));
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//供应商帐号
			if(subRunBean.getSellerMoney() != null && subRunBean.getSellerMoney() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId("1108240331110002824"); //角色id，sys_role
				orderBill.setAccount(subRunBean.getSellerCardNo());// 会员账户
				orderBill.setAmount(subRunBean.getSellerMoney().floatValue());// 支付金额
				orderBill.setTransactionType("5");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//平台帐号
			if(subRunBean.getPlatformNoMoney()!= null && subRunBean.getPlatformNoMoney() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId(""); //角色id，sys_role
				orderBill.setAccount(subRunBean.getPlatformAccount());// 会员账户
				orderBill.setAmount(subRunBean.getPlatformNoMoney().floatValue());// 支付金额
				orderBill.setTransactionType("5");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);

			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//退订插入数据
	public void insertOrderReturnBill(SubRunBean subRunBean){
		try {
			//调用封装好的接口返回subRunBean
			//SubRunBean subRunBean = new SubRunBean();
			
			BaseUserVo user = UserUtil.getUserVo();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			//角色      GOLD金管家      PLATINUM白金管家     DIAMOND钻石管家       GOVERNMENT政企管家
			SysRole sysRole = new SysRole();
			sysRole.setCode(subRunBean.getRoleCode());
			List<SysRole> list_sysRole = sysRoleService.findByWhere(sysRole);
			if(list_sysRole != null && list_sysRole.size()>0){
				sysRole = list_sysRole.get(0);
			}
			// 分润支付插入账单表

			OrderBill orderBill = new OrderBill();
			//源账户
			if(subRunBean.getOrderPrice() != null && subRunBean.getOrderPrice() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				orderBill.setRoleId(sysRole.getId()); //角色id，sys_role
				orderBill.setAccount(subRunBean.getCardNo());// 会员账户
				orderBill.setAmount(subRunBean.getOrderPrice().floatValue());// 支付金额
				orderBill.setStatus("00");//支付状态00：未支付
				//orderBill.setTradeNo(trade_no);   // 会员账户
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setTransactionType("2");
				orderBill.setCommission(Float.valueOf(0));
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//用户账户返积分
			if(subRunBean.getOrderRetPrice() != null && subRunBean.getOrderRetPrice() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				//orderBill.setTradeNo(trade_no);   // 会员账户
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId(sysRole.getId()); //角色id，sys_role
				orderBill.setAccount(subRunBean.getAccount());// 会员账户
				orderBill.setAmount(subRunBean.getOrderRetPrice().floatValue());// 支付金额
				orderBill.setTransactionType("2");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//供应商帐号
			if(subRunBean.getOrderSignprice() != null && subRunBean.getOrderSignprice() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				//orderBill.setTradeNo(trade_no);   // 会员账户
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId("1108240331110002824"); //角色id，sys_role
				orderBill.setAccount(subRunBean.getSellerCardNo());// 会员账户
				orderBill.setAmount(subRunBean.getOrderSignprice().floatValue());// 支付金额
				orderBill.setTransactionType("2");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//分公司帐号
			if(subRunBean.getSubCorpNoMoney() != null && subRunBean.getSubCorpNoMoney() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				//orderBill.setTradeNo(trade_no);   // 会员账户
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId("1108240331110002825"); //角色id，sys_role
				orderBill.setAccount(subRunBean.getSubCorpAccount());// 会员账户
				orderBill.setAmount(subRunBean.getSubCorpNoMoney().floatValue());// 支付金额
				orderBill.setTransactionType("2");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);
			}
			//平台帐号
			if(subRunBean.getPlatformNoMoney()!= null && subRunBean.getPlatformNoMoney() != 0){
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(user.getUsername());
				//orderBill.setTradeNo(trade_no);   // 会员账户
				//orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(Float.valueOf(0));
				orderBill.setStatus("00");//支付状态00：未支付
				orderBill.setRoleId(""); //角色id，sys_role
				orderBill.setAccount(subRunBean.getPlatformAccount());// 会员账户
				orderBill.setAmount(subRunBean.getPlatformNoMoney().floatValue());// 支付金额
				orderBill.setTransactionType("2");
				// 插入订单账户表
				orderBill2Dao.insert(orderBill);

			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//通过原订单号取得交易号
	public String getTradeNoByOrderId(String orderId){
		OrderBill domain = new OrderBill();
		domain.setOrderId(orderId);
		List<OrderBill> list = orderBill2Dao.findByWhere(domain);
		String ret = "";
		if(list != null && list.size()>0){
			domain = list.get(0);
			ret = domain.getTradeNo();
		}
		return ret;
	}
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void validateData(AbstractVo vo) throws ValidateException {

	}

	public IOrderBillDao getOrderBill2Dao() {
		return orderBill2Dao;
	}

	public void setOrderBill2Dao(IOrderBillDao orderBill2Dao) {
		this.orderBill2Dao = orderBill2Dao;
	}

	public ISysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

}