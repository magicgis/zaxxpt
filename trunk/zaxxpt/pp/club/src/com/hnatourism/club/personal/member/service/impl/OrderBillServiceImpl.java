package com.hnatourism.club.personal.member.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.base.domain.SysRole;
import com.hnatourism.club.base.service.ISysRoleService;
import com.hnatourism.club.common.service.BaseAbstractService;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.common.util.SubRunBean;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.order.vo.GolfOrderExceptionVo;
import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeExceptionVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.personal.member.dao.IOrderBillDao;
import com.hnatourism.club.personal.member.domain.OrderBill;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IOrderBillService;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberStsVo;
import com.hnatourism.club.personal.member.web.vo.OrderBillVo;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.domain.BaseUser;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.core.exception.ValidateException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.UserUtil;
import com.hnatourism.framework.web.vo.AbstractVo;
import com.hnatourism.framework.web.vo.BaseUserVo;

/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员状态表
 * 
 * 历史版本:2011-08-24 v1.1.0 (高杰) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class OrderBillServiceImpl extends BaseAbstractService implements
		IOrderBillService {
	private static final Log log = LogFactory
			.getLog(OrderBillServiceImpl.class);
	private IOrderBillDao orderBillDao;
	private ISysRoleService sysRoleService;
	private IMemberInfoService memberInfoServ;

	public ISysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
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
		
		// validate data
		// validateData(vo);
		// validate uniqueness
		// if (!checkUniqueness(vo)) {
		// throw new BusinessException("notUnique");
		// }
		OrderBill domain = new OrderBill();
		// copy vo Properties to domain
		BeanUtils.copyProperties((OrderBillVo) vo, domain);
		// id
		domain.setId(SnoGerUtil.getUUID());
		// createUser
		if(domain.getCreateUser()==null || "".equals(domain.getCreateUser())){
			BaseUserVo user = UserUtil.getUserVo();
			domain.setCreateUser(user.getUserCode());
		}
		// createTime
		domain.setCreateTime(DateUtils.getCurrentDate());
		return orderBillDao.insert(domain);
	}
	@Override
	public Object myInsert(OrderBillVo vo,MemberInfoVo user) throws BusinessException {
		OrderBill domain = new OrderBill();
		// copy vo Properties to domain
		BeanUtils.copyProperties(vo, domain);
		// id
		domain.setId(SnoGerUtil.getUUID());
		// createUser
		domain.setCreateUser(user.getCode());//会员的网站登录名
		// createTime
		domain.setCreateTime(DateUtils.getCurrentDate());
		return orderBillDao.insert(domain);
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
		return orderBillDao.update(domain);
	}

	/**
	 * 【删除】（系统生成方法）
	 * 
	 * @param id
	 * @throws BusinessException
	 */
	@Override
	public int delete(String id) throws BusinessException {
		return orderBillDao.delete(id);
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
		// domain.setUpdateUser(user.getUsername());
		// domain.setUpdateTime(DateUtils.utilDate2SqlDate(new Date()));
		return orderBillDao.update(domain);
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
		List<OrderBill> list = orderBillDao.findByWhere(domain);
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
		Page page = orderBillDao.findByWhere(domain, pageInfo);
		OrderBillVo returnVo = null;
		List<OrderBillVo> voList = new ArrayList();
		for (Object temp : page.getData()) {
			OrderBill memberSts = (OrderBill) temp;
			returnVo = new OrderBillVo();
			BeanUtils.copyProperties(memberSts, returnVo);
			voList.add(returnVo);
		}
		page.setData(voList);
		return page;
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
	public Page findByAccount(String account, int currentPage)
			throws BusinessException {
		Page page = new Page();
		List<OrderBillVo> billlist = new ArrayList<OrderBillVo>();
		List orderbilllist_temp = orderBillDao.findByAccount(account);
		PageInfo pageinfo = new PageInfo();
		pageinfo.setRowsOfPage(20);
		pageinfo.setCurrentPageNum(currentPage);

		int sum = orderbilllist_temp.size();
		int pagesum = 0;
		if (sum % pageinfo.getRowsOfPage() > 0) {
			pagesum = sum / pageinfo.getRowsOfPage() + 1;
		} else {
			pagesum = sum / pageinfo.getRowsOfPage();
		}
		pageinfo.setTotalPageCount(pagesum);

		int start = (currentPage - 1) * pageinfo.getRowsOfPage();
		int end = 0;
		if (currentPage == pagesum || pagesum == 0) {
			end = sum;
		} else {
			end = currentPage * pageinfo.getRowsOfPage();
		}

		for (int i = start; i < end; i++) {
			OrderBillVo ob = new OrderBillVo();
			BeanUtils.copyProperties(orderbilllist_temp.get(i), ob);

			ApiClient client1 = new ApiClient();// 得到API客户端。
			Gson gson = new Gson();// 拿到google 的Gson

			if (ob.getOrderType() == null) {
				continue;
			}

			if (ob.getOrderType().equalsIgnoreCase("n")) {
				if("1".equals(ob.getTransactionType().trim()))continue;//如果为分润返现跳过
				Type return_type = null;
				if (ob.getProdType() != null
						&& ob.getProdType().equalsIgnoreCase("GF")) {
					return_type = new TypeToken<List<GolfOrderVo>>() {
					}.getType();
					List<GolfOrderVo> golfOrderList = (List<GolfOrderVo>) gson
							.fromJson(
									client1
											.getHtml("/api/apiServer.action?method=api_findGolfOrderById&&id="
													+ ob.getOrderId()),
									return_type);
					if (golfOrderList != null && golfOrderList.size() > 0) {
						GolfOrderVo golfOrder = golfOrderList.get(0);// System.out.println(golfOrder.getId()+"=====================================");
						ob.setConsumeSts(golfOrder.getConsumerSts());
						ob.setMny(-golfOrder.getPrice());
					}
				} else if (ob.getProdType() != null
						&& ob.getProdType().equalsIgnoreCase("L")) {
					return_type = new TypeToken<OrderLoungeVo>() {
					}.getType();
					OrderLoungeVo loungeOrder = (OrderLoungeVo) gson
							.fromJson(
									client1
											.getHtml("/api/apiServer.action?method=findLoungeOrderDetail&&id="
													+ ob.getOrderId()),
									return_type);
					if (loungeOrder.getId() != null) {
						ob.setConsumeSts(loungeOrder.getConsumerSts());
						ob.setMny(-loungeOrder.getPrice());
					}
				} else if (ob.getProdType() != null
						&& ob.getProdType().trim().equalsIgnoreCase("H")) {
					ob.setMny(-ob.getMny());
				} else if (ob.getProdType() != null
						&& ob.getProdType().trim().equalsIgnoreCase("F")) {
					ob.setMny(-ob.getMny());
				}
			} else if (ob.getOrderType().equalsIgnoreCase("e")) {
				Type return_type = new TypeToken<List<GolfOrderExceptionVo>>() {
				}.getType();
				if (ob.getProdType() != null
						&& ob.getProdType().equalsIgnoreCase("GF")) {
					return_type = new TypeToken<List<GolfOrderExceptionVo>>() {
					}.getType();
					List<GolfOrderExceptionVo> golfExeptionList = (List<GolfOrderExceptionVo>) gson
							.fromJson(
									client1
											.getHtml("/api/apiServer.action?method=api_findGolfOrderExcepById&&id="
													+ ob.getOrderId()),
									return_type);
					if (golfExeptionList != null && golfExeptionList.size() > 0) {
						GolfOrderExceptionVo golfException = golfExeptionList
								.get(0);
						ob.setConsumeSts(golfException.getConsumerSts());
						ob.setMny(golfException.getFee());
						// 谷建亮 添加 如果为退款 取price
						if (golfException.getType().equalsIgnoreCase("R")) {
							ob.setMny(golfException.getPrice());
						} else if (golfException.getType()
								.equalsIgnoreCase("M")) {
							ob.setMny(-golfException.getPrice());
						}
					}
				} else if (ob.getProdType() != null
						&& ob.getProdType().equalsIgnoreCase("L")) {
					return_type = new TypeToken<List<OrderLoungeExceptionVo>>() {
					}.getType();
					List<OrderLoungeExceptionVo> loungeOrderList = (List<OrderLoungeExceptionVo>) gson
							.fromJson(
									client1
											.getHtml("/api/apiServer.action?method=findLoungeOrderException&&id="
													+ ob.getOrderId()),
									return_type);
					if (loungeOrderList != null && loungeOrderList.size() > 0) {
						OrderLoungeExceptionVo loungeException = loungeOrderList
								.get(0);
						ob.setConsumeSts(loungeException.getConsumerSts());
						ob.setMny(Double.parseDouble(loungeException.getPrice()
								.toString()));
						// 谷建亮 添加 如果为退款 取price
						if (loungeException.getType().equalsIgnoreCase("R")) {
							ob.setMny(loungeException.getPrice());
						} else if (loungeException.getType().equalsIgnoreCase(
								"M")) {
							ob.setMny(-loungeException.getPrice());
						}
					}
				} else if (ob.getProdType() != null
						&& ob.getProdType().trim().equalsIgnoreCase("H")) {
					
					// 谷建亮 添加 如果为退款 取price
					if (ob.getTransactionType().trim().equalsIgnoreCase("2")) {// 退款
						ob.setMny(ob.getMny());
					}else{
						ob.setMny(-ob.getMny());
					}
				} else if (ob.getProdType() != null
						&& ob.getProdType().trim().equalsIgnoreCase("F")) {
					
					// 谷建亮 添加 如果为退款 取price
					if (ob.getTransactionType().trim().equalsIgnoreCase("2")) {// 退款
						ob.setMny(ob.getMny());
					}else{
						ob.setMny(-ob.getMny());
					}
				}
			}

			billlist.add(ob);
		}

		page.setData(billlist);
		page.setPageInfo(pageinfo);

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
		OrderBill domain = orderBillDao.findById(id);
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
		MemberStsVo checkVo = (MemberStsVo) vo;
		MemberStsVo qryVo = new MemberStsVo();

		// start
		// qryVo.set...(checkVo.get...());
		// end

		List voList = findByWhere(qryVo);
		if (ListUtils.isEmpty(voList)) {
			isUnique = true;
		}
		return isUnique;
	}

	// 分润前插入数据
	public void insertOrderBill(SubRunBean subRunBean, String createUser) {
		try {
			// 调用封装好的接口返回subRunBean
			// SubRunBean subRunBean = new SubRunBean();

			// 角色 GOLD金管家 PLATINUM白金管家 DIAMOND钻石管家 GOVERNMENT政企管家
			SysRole sysRole = new SysRole();
			sysRole.setCode(subRunBean.getRoleCode());
			List<SysRole> list_sysRole = sysRoleService.findByWhere(sysRole);
			if (list_sysRole != null && list_sysRole.size() > 0) {
				sysRole = list_sysRole.get(0);
			}
			// 分润支付插入账单表

			OrderBill orderBill = new OrderBill();

			// 如果账单存在则删除
			orderBill.setOrderCode(subRunBean.getOrderCode());
			List<OrderBill> orderBillList = orderBillDao.findByWhere(orderBill);
			if (orderBillList != null) {
				for (OrderBill ob : orderBillList) {
					if (ob != null) {
						orderBillDao.delete(ob.getId());
					}
				}
			}

			// 源账户
			if (subRunBean.getOrderPrice() != null
					&& subRunBean.getOrderPrice() != 0) {
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(createUser);
				orderBill.setRoleId(sysRole.getId()); // 角色id，sys_role
				orderBill.setAccount(subRunBean.getCardNo());// 会员账户
				orderBill.setAmount(subRunBean.getOrderPrice());// 支付金额
				orderBill.setStatus("00");// 支付状态00：未支付
				// orderBill.setTradeNo(trade_no); // 会员账户
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				// orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setTransactionType("0");
				orderBill.setCommission(0d);
				// 插入订单账户表
				orderBillDao.insert(orderBill);
			}
			// 用户账户返积分
			if (subRunBean.getOrderRetPrice() != null
					&& subRunBean.getOrderRetPrice() != 0) {
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(createUser);
				// orderBill.setTradeNo(trade_no); // 会员账户
				// orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(0d);
				orderBill.setStatus("00");// 支付状态00：未支付
				orderBill.setRoleId(sysRole.getId()); // 角色id，sys_role
				orderBill.setAccount(subRunBean.getAccount());// 会员账户
				orderBill.setAmount(subRunBean.getOrderRetPrice());// 支付金额
				orderBill.setTransactionType("1");
				// 插入订单账户表
				orderBillDao.insert(orderBill);
			}
			// 供应商帐号
			if (subRunBean.getOrderSignprice() != null
					&& subRunBean.getOrderSignprice() != 0) {
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(createUser);
				// orderBill.setTradeNo(trade_no); // 会员账户
				// orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(0d);
				orderBill.setStatus("00");// 支付状态00：未支付
				orderBill.setRoleId("1108240331110002824"); // 角色id，sys_role
				orderBill.setAccount(subRunBean.getSellerCardNo());// 会员账户
				orderBill.setAmount(subRunBean.getSellerMoney());// 支付金额
				orderBill.setTransactionType("0");
				// 插入订单账户表
				orderBillDao.insert(orderBill);
			}
			// 分公司帐号
			if (subRunBean.getSubCorpNoMoney() != null
					&& subRunBean.getSubCorpNoMoney() != 0) {
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(createUser);
				// orderBill.setTradeNo(trade_no); // 会员账户
				// orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(0d);
				orderBill.setStatus("00");// 支付状态00：未支付
				orderBill.setRoleId("1108240331110002825"); // 角色id，sys_role
				orderBill.setAccount(subRunBean.getSubCorpAccount());// 会员账户
				orderBill.setAmount(subRunBean.getSubCorpNoMoney());// 支付金额
				orderBill.setTransactionType("0");
				// 插入订单账户表
				orderBillDao.insert(orderBill);
			}
			// 平台帐号
			if (subRunBean.getPlatformNoMoney() != null
					&& subRunBean.getPlatformNoMoney() != 0) {
				orderBill = new OrderBill();
				orderBill.setId(UUID.randomUUID().toString().replace("-", ""));
				orderBill.setCreateTime(DateUtils.utilDate2SqlDate(new Date()));
				orderBill.setCreateUser(createUser);
				// orderBill.setTradeNo(trade_no); // 会员账户
				// orderBill.setTradeTime(sdf.parse(pay_time));// 交易时间
				orderBill.setOrderId(subRunBean.getOrderId());// 关联订单ID
				orderBill.setType("chinapnr");// 交易方式:汇付天下
				orderBill.setOrderType(subRunBean.getOrderType());// 单据类型 N普通订单
				orderBill.setOrderCode(subRunBean.getOrderCode());
				orderBill.setProdType(subRunBean.getProdType());
				orderBill.setCommission(0d);
				orderBill.setStatus("00");// 支付状态00：未支付
				orderBill.setRoleId("1108240331110002827"); // 角色id，sys_role
				orderBill.setAccount(subRunBean.getPlatformAccount());// 会员账户
				orderBill.setAmount(subRunBean.getPlatformNoMoney());// 支付金额
				orderBill.setTransactionType("0");
				// 插入订单账户表
				orderBillDao.insert(orderBill);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void validateData(AbstractVo vo) throws ValidateException {

	}

	public IOrderBillDao getOrderBillDao() {
		return orderBillDao;
	}

	public void setOrderBillDao(IOrderBillDao orderBillDao) {
		this.orderBillDao = orderBillDao;
	}

	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}
}