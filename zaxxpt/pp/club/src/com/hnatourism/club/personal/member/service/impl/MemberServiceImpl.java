package com.hnatourism.club.personal.member.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.acegisecurity.providers.encoding.PasswordEncoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.base.dao.ISysSecuMemRoleDao;
import com.hnatourism.club.base.domain.SysSecuMemRole;
import com.hnatourism.club.common.Constants;
import com.hnatourism.club.common.dao.ISysOrganizationUserDao;
import com.hnatourism.club.common.util.DateUtils;
import com.hnatourism.club.common.util.SnoGerUtil;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.dao.IMemberInfoDao;
import com.hnatourism.club.personal.member.dao.IMemberInvoiceDao;
import com.hnatourism.club.personal.member.dao.IMemberStsDao;
import com.hnatourism.club.personal.member.dao.IPayAccountBalanceDao;
import com.hnatourism.club.personal.member.dao.IXlbBalanceDao;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.domain.MemberInfo;
import com.hnatourism.club.personal.member.domain.MemberInvoice;
import com.hnatourism.club.personal.member.domain.MemberSts;
import com.hnatourism.club.personal.member.domain.PayAccountBalance;
import com.hnatourism.club.personal.member.domain.XlbBalance;
import com.hnatourism.club.personal.member.service.IMemberService;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberInvoiceVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.utils.ValidateRegexUtils;
import com.hnatourism.framework.utils.ValidateUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员登录注册
 * 
 * 历史版本: 2010-07-02 v1.0.0 (hna) 创建:
 * 
 */
public class MemberServiceImpl implements IMemberService {

	// 日志信息
	private static final Log log = LogFactory
			.getLog(MemberServiceImpl.class);
	// DAO
	private IMemberInfoDao memberInfoDao;
	// 加密接口
	private PasswordEncoder passwordEncoder;
	
	private IMemberAccountDao memberAccountDao;
	
	// 发票dao
	private IMemberInvoiceDao memberInvoiceDao;
	// 状态dao
	private IMemberStsDao memberStsDao;
	// 组织
	private ISysOrganizationUserDao organizationUserDao;
	// 网站账号
	private IPayAccountBalanceDao payAccountBalanceDao;
	// 金币账号
	private IXlbBalanceDao xlbBalanceDao;
	// 角色--目前C站注册用户
	private ISysSecuMemRoleDao sysSecuMemRoleDao;

	/**
	 * @return the payAccountBalanceDao
	 */
	public IPayAccountBalanceDao getPayAccountBalanceDao() {
		return payAccountBalanceDao;
	}

	/**
	 * @param payAccountBalanceDao the payAccountBalanceDao to set
	 */
	public void setPayAccountBalanceDao(IPayAccountBalanceDao payAccountBalanceDao) {
		this.payAccountBalanceDao = payAccountBalanceDao;
	}

	/**
	 * @return the xlbBalanceDao
	 */
	public IXlbBalanceDao getXlbBalanceDao() {
		return xlbBalanceDao;
	}

	/**
	 * @param xlbBalanceDao the xlbBalanceDao to set
	 */
	public void setXlbBalanceDao(IXlbBalanceDao xlbBalanceDao) {
		this.xlbBalanceDao = xlbBalanceDao;
	}

	/**
	 * @return the sysSecuMemRoleDao
	 */
	public ISysSecuMemRoleDao getSysSecuMemRoleDao() {
		return sysSecuMemRoleDao;
	}

	/**
	 * @param sysSecuMemRoleDao the sysSecuMemRoleDao to set
	 */
	public void setSysSecuMemRoleDao(ISysSecuMemRoleDao sysSecuMemRoleDao) {
		this.sysSecuMemRoleDao = sysSecuMemRoleDao;
	}

	/**
	 * @return the memberInvoiceDao
	 */
	public IMemberInvoiceDao getMemberInvoiceDao() {
		return memberInvoiceDao;
	}

	/**
	 * @param memberInvoiceDao the memberInvoiceDao to set
	 */
	public void setMemberInvoiceDao(IMemberInvoiceDao memberInvoiceDao) {
		this.memberInvoiceDao = memberInvoiceDao;
	}

	@Override
	public MemberInfoVo regist(MemberInfoVo memberInfoVo)
			throws BusinessException {
		// 系统生成用户
		memberInfoVo.setUserCode("sys");
		
		// 如果是政企管家开户 不通过线上 未实现
		// 1.保存会员信息
		MemberInfo memberInfo = new MemberInfo();
		BeanUtils.copyProperties(memberInfoVo, memberInfo);
		
		memberInfo.setId(SnoGerUtil.getUUID());
		// 处理 生日问题
		if (null != memberInfo.getBirthdateYear()
				&& !"".equals(memberInfo.getBirthdateYear())) {
			String[] sts = memberInfo.getBirthdateYear().split("-");
			if (sts.length >= 3) {
				memberInfo.setBirthdateYear(sts[0]);
				memberInfo.setBirthdateMonth(sts[1]);
				memberInfo.setBirthdateDay(sts[2]);
			}
		}
		// 将邮箱状态设置为1
		memberInfo.setEmailChecking("0");
		// 将会员手机绑定状态改为未绑定0。
		memberInfo.setMobileBinding("0");
		// 加密密码
		String password = (String) passwordEncoder.encodePassword(
				memberInfo.getPassword(), null);
		memberInfo.setPassword(password);
		// 申请时间
		memberInfo.setCreateTime(DateUtils.getCurrentDate());
		memberInfo.setCreateUser(memberInfoVo.getUserCode());
		memberInfo.setStatus("0");// 会员状态
		// 来源
		memberInfo.setSource(Constants.CLUB_SOURCE);
		memberInfo.setActiveSts("0");
		memberInfo.setIsFirst("0");
		// 保存
		memberInfoDao.insert(memberInfo);

		// 2.会员发票表
		MemberInvoiceVo memberInvoiceVo = memberInfoVo.getMemberInvoice();
		if(memberInvoiceVo != null 
				&&"1".equals(memberInvoiceVo.getSts())) {
			MemberInvoice memberInvoice = new MemberInvoice();
			BeanUtils.copyProperties(memberInvoiceVo, memberInvoice);

			// 会员ID
			memberInvoice.setMemberId(memberInfo.getId());
			memberInvoice.setCreateTime(DateUtils.getCurrentDate());
			memberInvoice.setCreateUser(memberInfoVo.getUserCode());
			// id
			memberInvoice.setId(SnoGerUtil.getUUID());
			memberInvoiceDao.insert(memberInvoice);
		}

		// 3.会员账户表
		MemberAccount memberAccount = new MemberAccount();
		BeanUtils.copyProperties(memberInfoVo.getMemberAccount(), memberAccount);
		// 会员ID
		memberAccount.setMemberId(memberInfo.getId());
		// 角色码:GOLD,PLATINUM,DIAMOND,GOVERNMENT
		memberAccount.setRole(memberInfoVo.getMemberAccount().getRole());
		// 组织id
		memberAccount.setOrganizationId((memberInfoVo.getMemberAccount().getOrganizationId()));
		// 直减  优惠方式（MINUS直减，RETURN返点）
		memberAccount.setPrivilegeType("MINUS");
		memberAccount.setCreateTime(DateUtils.getCurrentDate());
		memberAccount.setCreateUser(memberInfoVo.getUserCode());
		// id
		memberAccount.setId(SnoGerUtil.getUUID());
		memberAccountDao.insert(memberAccount);

		// 4会员状态表
		MemberSts memberSts = new MemberSts();
		memberSts.setMemberId(memberInfo.getId());
		// 新增会员默认未激活0
		memberSts.setSts("0");
		memberSts.setCreateTime(DateUtils.getCurrentDate());
		memberSts.setCreateUser(memberInfoVo.getUserCode());
		// id
		memberSts.setId(SnoGerUtil.getUUID());
		memberStsDao.insert(memberSts);
		
//		// 保存组织用户信息
//		SysOrganizationUser organizationUser = new SysOrganizationUser();
//		organizationUser.setId(SnoGerUtil.getUUID());
//		organizationUser.setUserId(memberInfo.getId());
//		organizationUser.setOrganizationId(memberInfoVo.getMemberAccount().getOrganizationId());
//		organizationUser.setCreateUser(memberInfo.getCode());
//		organizationUser.setCreateTime(DateUtils.getCurrentDate());
//		organizationUserDao.insert(organizationUser);
		
		// 同步到B2C
		// 基本表
		//会员基本信息不需要同步了memberInfoDao.synMember(memberInfo);
		// 开通网站账号
		PayAccountBalance pdomain = new PayAccountBalance();
		pdomain.setId(SnoGerUtil.getUUID());
		pdomain.setMemberId(memberInfo.getId());
		pdomain.setPassword(memberInfo.getPassword());
		pdomain.setAmount(new BigDecimal(0));
		pdomain.setStatus("1");
		pdomain.setSource(Constants.CLUB_SOURCE);
		pdomain.setCreateTime(DateUtils.getCurrentDate());
		pdomain.setCreateUser(memberInfoVo.getUserCode());
		payAccountBalanceDao.insert(pdomain);
		//开通金币账号
		XlbBalance xdomain = new XlbBalance(); 
		xdomain.setId(SnoGerUtil.getUUID());
		xdomain.setMemberId(memberInfo.getId());
		xdomain.setAmount(new BigDecimal(0));
		xdomain.setStatus("1");
		xdomain.setCreateTime(DateUtils.getCurrentDate());
		xdomain.setCreateUser(memberInfoVo.getUserCode());
		xlbBalanceDao.insert(xdomain);
		//角色--目前注册用户角色全为会员“member”
		SysSecuMemRole sysSecuMemRole = new SysSecuMemRole();
		sysSecuMemRole.setId(SnoGerUtil.getUUID());
		sysSecuMemRole.setMemberId(memberInfo.getId());
		sysSecuMemRole.setRoleCode("member");
		sysSecuMemRoleDao.insert(sysSecuMemRole);

		return memberInfoVo;
	}

	/**
	 * 登录 
	 * 1、判断会员登录账号类型
	 * 2、当用网站会员账号01时，判断账号是否为email格式，如果为
	 * email格式，则按email账号验证；当不是email格式时，则 按手机账号验证，手机账号验证时要判断手机号是否绑定，
	 * 只有绑定的手机号才可以用手机账号登录。 
	 * 3、根据账号获取会员信息后，核对密码（查询到的会员信息中密码 为加密的，解密后，再核对密码）。
	 * 4、核对通过后，返回会员信息，判断是否要记录用户名，如 要记录同时回写用户Cookie
	 * 
	 * @param memberInfoVo :
	 *            MemberInfoVo类
	 * @return memberInfoVo : MemberInfoVo类
	 * @throws BusinessException
	 */
	@Override
	public MemberInfoVo login(MemberInfoVo memberInfoVo)
			throws BusinessException {
		// 会员登录账号
		String account = memberInfoVo.getCode();
		// 判断会员登录账号类型
//		String type = memberInfoVo.getMemberRole().getCode();
		MemberInfo domain = new MemberInfo();
		//验证验证码是否正确
//		if(memberInfoVo.getVerifyCodeSession()!=null){
//			if(!memberInfoVo.getVerifyCode().toLowerCase().equals(memberInfoVo.getVerifyCodeSession().toLowerCase())){
//				throw new BusinessException("您输入的验证码不正确！请重新输入！");
//			}
//		}
		List<MemberInfo> domainList =  null;
		// 网站用户
		// email账号验证,检查邮箱数据格式
		if (StringUtils.isNotEmpty(account) && ValidateUtils.validate(account,ValidateRegexUtils.EMAIL)) {
			domain.setEmail(account);
			// 按邮箱查询
			domainList = memberInfoDao.findByWhere(domain);
			domain = domainList.get(0);
			if (domain == null || domain.getEmail() == null) {
				throw new BusinessException("noCode","账户不存在");
			}
		} // 按手机账号验证,检查手机账号数据格式
		else if (StringUtils.isNotEmpty(account) && ValidateUtils.validate(account,ValidateRegexUtils.MOBILE)) {
			// 判断是否绑定手机,按手机账号查询
			domain.setMobile(memberInfoVo.getMobile());
			domain.setMobileBinding("1");
			domainList =  memberInfoDao.findByWhere(domain);
			if(domainList.size()>0){
				domain=domainList.get(0);
				if(domain == null || StringUtils.isEmpty(domain.getMobile())){
					throw new BusinessException("noCode","账户不存在");
				}
				else if (!"1".equals(domain.getMobileBinding())) {
					throw new BusinessException("noBinding","此手机号没有绑定！");
				}
			}
			else{
				throw new BusinessException("noBinding","此手机号没有绑定！");
			}
			
		} 
		else if(StringUtils.isNotEmpty(account)){
			//按会员CODE登录
			domain = memberInfoDao.findByCode(account);
			
			if(domain == null){
				MemberAccount memberAccount = new MemberAccount();
				memberAccount.setCardNo(account);
				List<MemberAccount> memberAccountList = memberAccountDao.findByWhere(memberAccount);
				if(!ListUtils.isEmpty(memberAccountList)){
					memberAccount = memberAccountList.get(0);
				}
				else{
					memberAccount = null;
				}
				if(memberAccount==null){
					throw new BusinessException("mistakeInfo_code","卡号不存在！");
				}
				else{
					domain = (MemberInfo)memberInfoDao.findById(memberAccount.getMemberId());
				}
			}
			
			if (domain == null || domain.getCode() == null) {
				throw new BusinessException("noCode","登录帐号不存在！");
			}
		}
		else{
			throw new BusinessException("noCode","账户不存在");
		}
		
		String password = memberInfoVo.getPassword();
		if(memberInfoVo.getPassword().length() < 32){
			// 加密
			password = (String) passwordEncoder.encodePassword(memberInfoVo.getPassword(), null);
		}
		
		// 解密
		MemberSts memberSts=(MemberSts)memberStsDao.findByMember(domain.getId());
		if("0".equalsIgnoreCase(memberSts.getSts()))
		{
			throw new BusinessException("passwordError","账号未被激活");
		}
		
		// 核对
		if (!password.equals(domain.getPassword())) {
			throw new BusinessException("passwordError","密码不正确");
		}

//		// 判断是否要记录用户名
//		if ("true".equals(memberInfoVo.getRememberPSW())) {
//			// 判断是否要记录用户名
//		}

		// 保存登录
		MemberInfo loginDomain = new MemberInfo();
		loginDomain.setId(domain.getId());
		loginDomain.setLastLoginTime(new Date());
		memberInfoDao.update(loginDomain);
		//domain强转成vo
		memberInfoVo = new MemberInfoVo();
		BeanUtils.copyProperties(domain, memberInfoVo);
//		UserUtil.getUser();
//		//获取用户角色
//		SysSecuMemRole sysSecuMemRole = new SysSecuMemRole();
//		sysSecuMemRole.setMemberId(memberInfoVo.getId());
//		List ssmrList = sysSecuMemRoleDao.findByWhere(sysSecuMemRole);
//		StringBuffer authSePr = new StringBuffer();
//		if(ssmrList!=null && ssmrList.size()>0){
//			for (SysSecuMemRole tempssmr : (List<SysSecuMemRole>)ssmrList) {
//				authSePr.append(tempssmr.getRoleCode()+",");
//			}
//			memberInfoVo.setAuthSePr(authSePr.toString());
//		}
//		memberInfoVo.setLoginAccount(account);
		// 回写用户Cookie

		return memberInfoVo;
	}

	/**
	 * 按手机找回密码 1、验证手机是否存在 2、获取会员密码，并发送邮件到邮箱
	 * 
	 * @param mobile :
	 *            String
	 * @return MemberInfoVo
	 * @throws BusinessException
	 */
	public MemberInfoVo findPSWByMobile(String mobile) throws BusinessException {
		// 1、验证手机是否存在
		// 创建VO
		MemberInfoVo vo = new MemberInfoVo();
		// 通过手机号查找绑定的domain
		MemberInfo domain = new MemberInfo();
		domain.setMobile(mobile);
		domain.setMobileBinding("1");
		List<MemberInfo> domainList =  memberInfoDao.findByWhere(domain);
//		List<MemberInfo> domainList =  memberInfoDao.findByMobile(mobile);
		domain = domainList.get(0);
		if (domain == null) {
			// 数据记录不存在
			throw new BusinessException("数据记录不存在");
		}

		// 2、获取会员密码，并发送邮件到邮箱
		String password = domain.getPassword();

		// sendEmail

		return vo;
	}
	//手机绑定
	@Override
	public MemberInfoVo mobileBangding(MemberInfoVo memberInfoVo)
			throws BusinessException {
//		MemberInfo memberInfo=new MemberInfo();
//		BeanUtils.copyProperties(memberInfoVo, memberInfo);
//		memberInfoDao.bindingMobile(memberInfo);
		return null;
	}
	//判断手机是否绑定
	public boolean checkBangdingMobile(String mobile)throws BusinessException{
		boolean flag=false;
		MemberInfoVo memberInfoVo=new MemberInfoVo();
		memberInfoVo.setMobile(mobile);
		memberInfoVo.setMobileBinding("1");
		MemberInfo memberInfo=new MemberInfo();
		BeanUtils.copyProperties(memberInfoVo, memberInfo);
		 List list=memberInfoDao.findByWhere(memberInfo);
		 if(!ListUtils.isEmpty(list) && list.size()>0){
			 return true;
		 }
		return flag;
	}
	
	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}

	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
	}

	/**
	 * @return the memberStsDao
	 */
	public IMemberStsDao getMemberStsDao() {
		return memberStsDao;
	}

	/**
	 * @param memberStsDao the memberStsDao to set
	 */
	public void setMemberStsDao(IMemberStsDao memberStsDao) {
		this.memberStsDao = memberStsDao;
	}

	/**
	 * @return the organizationUserDao
	 */
	public ISysOrganizationUserDao getOrganizationUserDao() {
		return organizationUserDao;
	}

	/**
	 * @param organizationUserDao the organizationUserDao to set
	 */
	public void setOrganizationUserDao(ISysOrganizationUserDao organizationUserDao) {
		this.organizationUserDao = organizationUserDao;
	}
}
