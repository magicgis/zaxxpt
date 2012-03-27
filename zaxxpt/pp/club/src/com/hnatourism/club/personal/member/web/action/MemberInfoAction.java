package com.hnatourism.club.personal.member.web.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.acegisecurity.providers.encoding.PasswordEncoder;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.util.HtmlUtils;

import com.hnatourism.club.common.Constants.SysRoleCode;
import com.hnatourism.club.common.dao.ISysOrganizationDao;
import com.hnatourism.club.common.domain.SysOrganization;
import com.hnatourism.club.common.util.RedirectUtil;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.member.rule.service.IRuleConfigService;
import com.hnatourism.club.personal.member.dao.IMemberAccountDao;
import com.hnatourism.club.personal.member.dao.IMemberInfoDao;
import com.hnatourism.club.personal.member.dao.IMemberInvoiceDao;
import com.hnatourism.club.personal.member.dao.IMemberStsDao;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.domain.MemberInfo;
import com.hnatourism.club.personal.member.domain.MemberInvoice;
import com.hnatourism.club.personal.member.domain.MemberSts;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.service.IMemberService;
import com.hnatourism.club.personal.member.service.IMemberStsService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.club.personal.member.web.vo.MemberStsVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.web.action.BaseAction;
import com.hnatourism.framework.web.utils.CookieUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转到用户信息编辑
 * 
 * 历史版本: ${2011.8.23} v1.0.0 (${高杰}) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class MemberInfoAction extends BaseAction {
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private static final long serialVersionUID = 8922017842741135405L;

	private String id;// 会员ID
	private MemberInfoVo member;// 会员信息
	private String code;// 编号
	private String name;// 联系人
	private String pw;// 密码
	private String isRememberPsw;
	private String mobile;// 手机
	private String sex;// 性别
	private String birth;// 出生日期
	private String address;// 地址
	private String mistakeInfo;
	private String email;

	private String time;
	private String newPw;
	private String newPwConfirm;
	private String rolename;
	private String hcode;
	private String rcode;
	private String idate;
	private String odate;

	/**
	 * 会员信息服务
	 */
	private IMemberInfoService memberInfoService;
	private IMemberService memberService;
	private IMemberStsService memberStsService;
	private MemberStsVo memberStsVo;
	private MemberInfoVo memberInfoVo = new MemberInfoVo();

	public MemberInfoVo getMemberInfoVo() {
		return memberInfoVo;
	}

	public void setMemberInfoVo(MemberInfoVo memberInfoVo) {
		this.memberInfoVo = memberInfoVo;
	}

	public MemberStsVo getMemberStsVo() {
		return memberStsVo;
	}

	public void setMemberStsVo(MemberStsVo memberStsVo) {
		this.memberStsVo = memberStsVo;
	}

	/**
	 * 会员账户信息服务
	 */
	private IMemberAccountService memberAccountService;
	private IMemberRoleService memberRoleService;
	private PasswordEncoder passwordEncoder;
	private IRuleConfigService ruleConfigService;

	// 角色表
	private List<MemberRoleVo> memberRoleVoList;

	// 组织
	private ISysOrganizationDao sysOrganizationDao;

	private IMemberInfoDao memberInfoDao;
	private MemberInfo memberInfo;

	// 发票
	private IMemberInvoiceDao memberInvoiceDao;
	private MemberInvoice memberInvoice;

	// 会员账户表
	private MemberAccount memberAccount;
	private IMemberAccountDao memberAccountDao;

	// 会员状态表
	private IMemberStsDao memberStsDao;
	private MemberSts memberSts;

	/**
	 * 待客下单接收参数
	 * 
	 */
	private String memberId = "";
	private String source = "";
	private String createUser = "";
	private String proType = "";

	/**
	 * 首页显示
	 */
	public String showMemberInfo() {
		try {
			HttpSession session = this.getSession();
			MemberInfoVo vo = UserUtil.getUser(getSession().getId());
			if (vo == null) {
				return "notlogin";
			}
			session.setAttribute("updmember", null);

			member = (MemberInfoVo) memberInfoService.findByCode(vo.getCode());
			rolename = member.getMemberRole().getName();
		} catch (Exception e) {
			e.printStackTrace();
			return "success";
		}

		return "success";
	}

	/**
	 * 修改会员个人信息
	 * 
	 * @return
	 */
	public String updateMemberInfo() {
		// System.out.println(121212);
		HttpSession session = null;
		try {
			session = this.getSession();
			if (UserUtil.getUser(getSession().getId()) == null) {
				return "notlogin";
			}
			session.setAttribute("updmember", null);
			String[] birthInfo = birth.split("-");
			member = new MemberInfoVo();
			member.setId(id);
			member.setAddress(address);
			member.setCode(code);
			member.setMobile(mobile);
			member.setBirthdateDay(birthInfo[2]);
			member.setBirthdateMonth(birthInfo[1]);
			member.setBirthdateYear(birthInfo[0]);
			member.setUpdateTime(new Date());
			member.setUpdateUser(code);
			member.setName(name);
			member.setSex(sex);
			// System.out.println(email+"-----------");
			member.setEmail(email);

			memberInfoService.update(member);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("updmember", "error");
			return "success";
		}
		session.setAttribute("updmember", "success");
		return "success";
	}

	public String toMoveMember() {
		return "success";
	}

	/**
	 * 会员退会申请:修改会员状态:
	 * @return
	 */
	public String moveMember() {
		HttpSession session=this.getSession();
		if (UserUtil.getUser(getSession().getId()) == null) {
			return "notlogin";
		}
		//得到当前用户的信息\
		String userCode = UserUtil.getUser(getSession().getId()).getCode();
		try {
			memberStsVo.setMemberId(memberInfoVo.getId());
			memberStsVo.setSts("3");
			memberStsVo.setUpdateUser(userCode);//当前用户
			memberStsVo.setUpdateTime(new Date());
			int count = memberStsService.update(memberStsVo);
			if (count != 0) {
				getSession().setAttribute("sts", "3");
			} else {
				getRequest().setAttribute("showSts", 0);
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			getRequest().setAttribute("showSts", 0);
			return "error";
		}
		getRequest().setAttribute("showSts", 1);
		return "success";
	}

	/***
	 * 代客下单
	 * 
	 * @return
	 */
	public String proLogin() {
		HttpSession session = this.getSession();
		try {
			if (!"".equals(memberId)) {
				member = (MemberInfoVo) memberInfoService.findById(memberId);
				code = member.getCode();
				// 解决 没有找到用户时 登录异常
				if (member == null) {
					return "login";
				} else {
					if (null != createUser && !"".equals(createUser))
						member.setCreateUser(createUser);
					if (member.getPassword() == null) {
						return "login";
					}
				}
				// String rememberPSW = member.getIsRememberPsw();
				String pw_temp = member.getPassword();
				setMSession();
				this.getRequest().getSession().removeAttribute("rand");
				// 将用户名和密码放入到Cookie中
				if (isRememberPsw != null && "on".equals(isRememberPsw)) {
					CookieUtils.createCookie(getResponse(),
							"SESSION_LOGIN_USERNAME", URLEncoder.encode(member
									.getEmail()), 99999999);
					// 保存密码到Cookie，注意需要加密一下
					CookieUtils.createCookie(getResponse(),
							"SESSION_LOGIN_PASSWORD", member.getPassword(),
							99999999);

					Cookie cookie_code = new Cookie("login_code", member
							.getCode());
					cookie_code.setMaxAge(99999999);
					cookie_code.setPath("/");
					getResponse().addCookie(cookie_code);
					Cookie cookie_pw = new Cookie("login_pw", pw_temp);
					cookie_pw.setMaxAge(99999999);
					cookie_pw.setPath("/");
					getResponse().addCookie(cookie_pw);
				} else {
					Cookie[] cookielist = getRequest().getCookies();
					if(null!=cookielist&&cookielist.length>0)
					for (int i = 0; i < cookielist.length; i++) {
						Cookie cookie_temp = cookielist[i];
						if ("login_code"
								.equalsIgnoreCase(cookie_temp.getName())) {
							cookie_temp.setValue("");
						}
						if ("login_pw".equalsIgnoreCase(cookie_temp.getName())) {
							cookie_temp.setValue("");
						}
						cookie_temp.setMaxAge(99999999);
						cookie_temp.setPath("/");
						getResponse().addCookie(cookie_temp);
					}
				}

			}

			if (null == member)
				log.debug("member is null");
			if ("GF".equals(proType)) {
				return "golf";
			} else if ("L".equals(proType)) {
				return "lounge";
			} else if ("H".equals(proType)) {
				return "hotel";
			} else if ("F".equals(proType)) {
				return "flight";
			}
		} catch (BusinessException e) {
			log.debug(e.getMessage());
			e.printStackTrace();
		}
		return "login";
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		HttpSession session = this.getSession();

		try {
			if (UserUtil.getUser(getSession().getId()) != null) {
				return "login";
			}

			MemberInfoVo member = null;
			if (memberInfoService.findByCodeLogin(code) != null) {
				member = (MemberInfoVo) memberInfoService.findByCodePw(code,
						passwordEncoder.encodePassword(pw, null));
			} else {
				MemberAccountVo account = (MemberAccountVo) memberAccountService
						.findByCardNo(code);
				if (account == null) {
					session.setAttribute("mistakeInfo_code",
							"卡号或者账号不存在，请重新输入！！！！！");
					return "mistake";
				} else {
					MemberInfoVo member_account = (MemberInfoVo) memberInfoService
							.findByCodeLogin(account.getMemberId());
					member = (MemberInfoVo) memberInfoService.findByCodePw(
							member_account.getCode(), passwordEncoder
									.encodePassword(pw, null));
				}
			}

			if (member == null) {
				session.setAttribute("mistakeInfo_pw", "密码，请重新输入！！！！！");
				return "mistake";
			} else {
				// 会员账户信息
				MemberAccountVo account = (MemberAccountVo) memberAccountService
						.findByMember(member.getId());
				MemberRoleVo memberRole = (MemberRoleVo) memberRoleService
						.findById(account.getRole());

				// 保存到session
				account.setMemberRole(memberRole);
				member.setMemberAccount(account);

				// 保存到session
				setMSession(member);

			}
		} catch (Exception e) {
			log.error("", e);
			return "success";
		}

		if (session.getAttribute("backlink") == null) {
			return "success";
		} else {
			String forward_url = session.getAttribute("backlink").toString();
			session.setAttribute("backlink", null);
			return forward_url;
		}
	}

	public String login2() {
		if (UserUtil.getUser(getSession().getId()) != null
				&& StringUtils.isNotEmpty(UserUtil
						.getUser(getSession().getId()).getId())) {
			return "login";
		}
		try {
			String url = this.getRequest().getParameter("url");
			url = (StringUtils.isEmpty(url) || "null".equals(url) || url
					.contains("login")) ? (String) getSession().getAttribute(
					"backlink") : url;
			url = HtmlUtils.htmlUnescape(url);
			String email = this.getRequest().getParameter("email");
			// 验证码
			String verifyCodeSession = "";
			if (this.getRequest().getSession().getAttribute("rand") != null) {
				verifyCodeSession = this.getRequest().getSession()
						.getAttribute("rand").toString();
			}
			// 如果没登陆，邮箱存在，根据邮箱查询用户
			if (member == null && email != null) {
				// member = this.memberRegistLoginService
				// .findPSWByEmail(email);
				// member.setLoginAccount(member.getEmail());
				MemberInfoVo memberVo = new MemberInfoVo();
				memberVo.setEmail(member.getEmail());
				List<MemberInfoVo> memberList = memberInfoService
						.findByWhere(memberVo);
				member = memberList.get(0);
			}
			// 解决 没有找到用户时 登录异常
			if (member == null) {
				return "login";
			} else {
				if (member.getPassword() == null) {
					return "login";
				}
			}
			// String rememberPSW = member.getIsRememberPsw();
			member.setVerifyCodeSession(verifyCodeSession);
			String pw_temp = member.getPassword();
			member = memberService.login(member);

			getSession().setAttribute("mid", member.getId());
			MemberStsVo mv = (MemberStsVo) memberStsService.findByMember(member
					.getId());
			getSession().setAttribute("sid", mv.getId());
			getSession().setAttribute("sts", mv.getSts());
			if(mv.getSts().equals("4")){
				getSession().setAttribute("mistakeInfo", "该用户已退会！");
				return "login";
			}
			setMSession();
			this.getRequest().getSession().removeAttribute("rand");
			// 将用户名和密码放入到Cookie中
			if (isRememberPsw != null && "on".equals(isRememberPsw)) {
				CookieUtils.createCookie(getResponse(),
						"SESSION_LOGIN_USERNAME", URLEncoder.encode(member
								.getEmail()), 99999999);
				// 保存密码到Cookie，注意需要加密一下
				CookieUtils.createCookie(getResponse(),
						"SESSION_LOGIN_PASSWORD", member.getPassword(),
						99999999);

				Cookie cookie_code = new Cookie("login_code", member.getCode());
				cookie_code.setMaxAge(99999999);
				cookie_code.setPath("/");
				getResponse().addCookie(cookie_code);
				Cookie cookie_pw = new Cookie("login_pw", pw_temp);
				cookie_pw.setMaxAge(99999999);
				cookie_pw.setPath("/");
				getResponse().addCookie(cookie_pw);
			} else {
				Cookie[] cookielist = getRequest().getCookies();
				for (int i = 0; i < cookielist.length; i++) {
					Cookie cookie_temp = cookielist[i];
					if ("login_code".equalsIgnoreCase(cookie_temp.getName())) {
						cookie_temp.setValue("");
					}
					if ("login_pw".equalsIgnoreCase(cookie_temp.getName())) {
						cookie_temp.setValue("");
					}
					cookie_temp.setMaxAge(99999999);
					cookie_temp.setPath("/");
					getResponse().addCookie(cookie_temp);
				}
			}

			if (StringUtils.isNotEmpty(url) && url.trim().length() > 0
					&& !"null".equals(url)) {
				try {
					url = RedirectUtil.geturl(url);
					this.getResponse().sendRedirect(url);
					return null;
				} catch (IOException e) {
					log.error("登陆后重定向异常。", e);
				}
			}
			// if (email != null && email.trim().length() > 0) {
			// return "toIndex";
			// }
		} catch (BusinessException e) {
			// setMessage(e.getMessage());
			getSession().setAttribute("mistakeInfo", e.getMessage());
			log.error("用户登陆异常。", e);
			getSession().setAttribute("backlink", null);
			return "mistake";
		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户登陆异常。", e);
			getSession().setAttribute("mistakeInfo", "登录异常");
			getSession().setAttribute("backlink", null);
			return "mistake";
		}

		// HttpSession session=this.getSession();
		// if(getRequest().getAttribute("backlink")==null)
		// {
		// return "success";
		// }
		// else
		// {
		// String forward_url=getRequest().getAttribute("backlink").toString();
		// getRequest().setAttribute("backlink", null);
		// System.out.println("==========="+forward_url);
		// // try {
		// // getResponse().sendRedirect(forward_url);
		// // }catch (Exception e) {
		// // log.error("用户登陆异常。", e);
		// // }
		// return forward_url;
		// }
		return "success";
	}

	public void setMSession() throws BusinessException {
		// HttpSession session = this.getSession();
		// String sessionId = session.getId();
		// 会员账户信息
		MemberAccountVo account = (MemberAccountVo) memberAccountService
				.findByMember(member.getId());
		// 所属分公司账号
		MemberAccountVo account2 = (MemberAccountVo) memberAccountService
				.findByMember(account.getOrganizationId());

		MemberRoleVo memberRole = (MemberRoleVo) memberRoleService
				.findById(account.getRole());
		account.setMemberRole(memberRole);
		member.setMemberAccount(account);
		member.setMemberCropAccount(account2);
		if (memberRole.getCode().equalsIgnoreCase("GOVERNMENT")) {
			member.setRuleConfigList(ruleConfigService.findByCrop(account
					.getOrganizationId()));
		}
		UserUtil.set("sessionId", getSession().getId(), member);
		// UserUtil.getUser(getSession().getId()).setMemberAccount(account);
		getSession().setAttribute("createUser", member.getCode());
		// ServletContext application = this.getServletContext();
		// application.setAttribute(sessionId, member);
	}

	/**
	 * 注销退出
	 * 
	 * @return
	 */
	public String loginout() {
		// HttpSession session= this.getSession();
		// session.setAttribute("memberId", null);
		// session.setAttribute("user_"+session.getId(), null);
		// session.setAttribute("memberCode", null);
		// session.setAttribute("memberName", null);
		// session.setAttribute("createUser", null);
		// session.setAttribute("cardNo", null);

		UserUtil.remove("sessionId", getSession().getId());
		Cookie cookie = new Cookie("SESSION_LOGIN_USERNAME", null);
		CookieUtils.deleteCookie(cookie, getResponse());
		cookie = new Cookie("SESSION_LOGIN_PASSWORD", null);
		CookieUtils.deleteCookie(cookie, getResponse());
		// 退出判断跳转
		String toPage = null;
		String prodType = getRequest().getParameter("prodType");
		if ("F".equals(prodType)) {
			toPage = "flightIndex";
		} else if ("H".equals(prodType)) {
			toPage = "hotelIndex";
		} else if ("GF".equals(prodType)) {
			toPage = "golfIndex";
		} else if ("L".equals(prodType)) {
			toPage = "loungeIndex";
		} else {
			toPage = "success";
		}
		return toPage;
	}

	public String toupdateMemberPw() {
		HttpSession session = this.getSession();
		if (UserUtil.getUser(getSession().getId()) == null) {
			return "notlogin";
		}
		session.setAttribute("updmember", null);
		session.setAttribute("mistakeInfo_pw", null);

		return "success";
	}

	public String updateMemberPw() {
		HttpSession session = this.getSession();
		if (UserUtil.getUser(getSession().getId()) == null) {
			return "notlogin";
		}
		session.setAttribute("updmember", null);
		session.setAttribute("mistakeInfo_pw", null);

		try {
			member = (MemberInfoVo) memberInfoService.findByCodePw(UserUtil
					.getUser(getSession().getId()).getCode(), passwordEncoder
					.encodePassword(pw, null));

			if (member != null) {
				if (newPw != null && newPwConfirm != null
						&& newPw.equalsIgnoreCase(newPwConfirm)) {
					MemberInfoVo member_upd = new MemberInfoVo();
					member_upd.setId(member.getId());
					member_upd.setPassword(passwordEncoder.encodePassword(
							newPw, null));
					memberInfoService.update(member_upd);
				}
			} else {
				session.setAttribute("updmember", "error");
				return "mistake";
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("updmember", "error");
			return "success";
		}

		session.setAttribute("updmember", "success");
		return "success";
	}

	/**
	 * 保存会员登录信息到session
	 */
	public void setMSession(MemberInfoVo member) {
		HttpSession session = this.getSession();
		session.setAttribute("memberId", member.getId());
		session.setAttribute("user_" + session.getId(), member);
		session.setAttribute("memberCode", member.getCode());
		session.setAttribute("createUser", member.getCode());
		session.setAttribute("memberName", member.getName());
		session.setAttribute("cardNo", member.getMemberAccount().getCardNo());
	}

	/**
	 * 【跳至找回密码首页】
	 * 
	 * @return
	 */
	public String toFindPwd() {
		setMessage("系统稍后会将验证信息以邮件方式送到您的邮箱<br/>请及时查收邮件");
		return "toFindPwd";
	}

	/**
	 * 【新增】（验证邮箱并发送url）
	 * 
	 * @return
	 */
	public String sendPwd() {
		// try{
		// //验证email是否存在
		// memberInfo = memberInfoDao.findByEmail(memberInfoVo.getEmail());
		// //不存在返回页面，进行提示
		// if(memberInfo == null){
		// setMessage("<font style='color:red'>该email未注册！</font>");
		// return "toFindPwd";
		// }
		//		  
		// //email 存在
		// //获取该用户的id
		// sysFindPwdVo.setId(memberInfo.getId());
		// //生成过期日期(当前时间加12天)
		// SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
		// sysFindPwdVo.setLastDate(dateFormat.format(DateUtils.addDays(new
		// Date(), 12)));
		// //生成用户key（md5 加密用户id及过期日期生成key）
		// StringBuffer userKey= new
		// StringBuffer(Md5Encrypt.md5(sysFindPwdVo.getId()));
		// userKey.append("_");
		// userKey.append(Md5Encrypt.md5(dateFormat.format(DateUtils.addDays(new
		// Date(), 12))));
		// sysFindPwdVo.setUserKey(userKey.toString());
		// //判断有无信息
		// sysFindPwd.setLastDate(sysFindPwdVo.getLastDate());
		// sysFindPwd.setUserKey(sysFindPwdVo.getUserKey());
		// List list = sysFindPwdDao.findByWhere(sysFindPwd);
		// if(!ListUtils.isBlank(list)){
		// setMessage("<font style='color:red'>找回密码，每天只能使用一次</font>");
		// return "toFindPwd";
		// }
		// //将找回密码信息插入表
		// sysFindPwdService.insert(sysFindPwdVo);
		//		  
		// //生成Url发送至用户email邮箱
		// // String rootUrl
		// =ServletActionContext.getRequest().getRequestURL().toString();
		// // rootUrl = rootUrl.substring(0, rootUrl.lastIndexOf('/'))+"/";
		// String rootUrl = "http://"+Constants.DOMAIN_NAME;
		// url =
		// rootUrl+"/sysFindPwdAction!toResetPwd.action?ud="+sysFindPwdVo.getId()+"&amp;uk="+sysFindPwdVo.getUserKey();
		// this.setUrl(url);
		// //发送邮箱
		// String
		// MailContent="<p>你好</p><br/><p>你在"+Constants.DOMAIN_NAME_2+"申请了重设密码，请点击下面的链接，"
		// +
		// "然后根据页面提示完成密码重设：</p><br/><h3><a href='"
		// +url+"'>"+url+"</a></h3>"; //邮件内容
		// MailContent+="<p>"+Constants.DOMAIN_NAME_2+"客服电话 "+PropertiesUtils.getVal("sysProps",
		// "site_tel")+"</p>";
		// boolean sendSts =
		// EmailUtils.sendMail(Constants.MAIL_FROM,memberInfo.getEmail(),
		// Constants.MAIL_TITLE, MailContent,
		// Constants.SMTP_IP, Constants.SMTP_NAME, Constants.SMTP_PASSWORD,
		// Constants.MAIL_TYPE, true);
		// if(!sendSts){
		// setMessage("<font style='color:red'>邮件发送失败，请稍后再试</font>");
		// return "toFindPwd";
		// }
		// }
		// catch(BusinessException e){
		// log.error("找回密码信息插入数据库失败",e);
		// setMessage("<font style='color:red'>服务器正忙，请稍后再试<font>");
		// return "toFindPwd";
		// }
		// catch(Exception e){
		// log.error("",e);
		// setMessage("<font style='color:red'>服务器正忙，请稍后再试<font>");
		// return "toFindPwd";
		// }
		// setMessage("<font style='color:green'>找回密码的链接已发送到您的邮箱，请注意查收<font>");
		return "toFindPwd";
	}

	/**
	 * @description 【ajax检查网站用户名是否占用】
	 * 
	 */
	public void ckCode() {
		String result = "";
		try {
			MemberInfo memberInfoVar = memberInfoDao.findByCode(memberInfo
					.getCode());
			if (null == memberInfoVar) {
				result = "0";// 未占用
			} else {
				result = "1";// 占用
			}
			writeString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description 【ajax检查email是否占用】
	 * 
	 */
	public void ckEmail() {
		String result = "";
		List list = memberInfoDao.findByWhere(memberInfo);
		if (ListUtils.isEmpty(list)) {
			result = "0";// 未占用
		} else {
			result = "1";// 占用
		}
		try {
			writeString(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 【查询会员类型】
	 * 
	 * @return
	 */
	public String onLineApplyView() {
		// 会员类型.绑定到下拉列表中
		try {
			memberRoleVoList = memberRoleService.findByWhere(new MemberRoleVo());
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("memberRoleVoList", memberRoleVoList);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "onLineApplyPage";
	}

	/**
	 * 【在线会员申请】
	 * 
	 * @return
	 */
	public String onLineApply() {
		try {
			// String userName = UserUtil.getUser().getUsername();
			SysOrganization organization = new SysOrganization();
			organization.setCode(SysRoleCode.MAIN_COMPANY);
			List<SysOrganization> organzationList = sysOrganizationDao
					.findByWhere(organization);
			if (ListUtils.isEmpty(organzationList)) {
				setMessage("<font style='color:red'>未发现总公司的组织</font>");
				return "error";
			}
//			// 保存会员信息
//			memberInfo.setId(SnoGerUtil.getUUID());
//			memberInfo.setStatus("01");
//			memberInfo.setEmailChecking("0");
//			memberInfo.setMobileBinding("0");
//			memberInfo.setSource(Constants.CLUB_ORDER_SOURCE);
//			memberInfo.setActiveSts("0");
//			memberInfo.setIsFirst("0");
//			memberInfo.setPassword(passwordEncoder.encodePassword(memberInfo
//					.getPassword(), null));
//			memberInfo.setCreateTime(DateUtils.getCurrentDate());
//			memberInfo.setCreateUser(memberInfo.getCode());
//			memberInfoDao.insert(memberInfo);
//
//			// 保存组织用户信息
//			SysOrganizationUser organizationUser = new SysOrganizationUser();
//			SysOrganization organizationVar = organzationList.get(0);
//			organizationUser.setId(SnoGerUtil.getUUID());
//			organizationUser.setCreateUser(memberInfo.getCode());
//			organizationUser.setCreateTime(new Date());
//			organizationUser.setOrganizationId(organizationVar.getId());
//			organizationUserDao.insert(organizationUser);
//
//			// 保存会员发票
//			/*
//			 * memberInvoice.setId(SnoGerUtil.getUUID());
//			 * memberInvoice.setCreateTime(new Date());
//			 * memberInvoice.setCreateUser(memberInfo.getCode());
//			 * memberInvoice.setType("0"); memberInvoice.setSts("1");
//			 * System.out.
//			 * println(memberInvoice.getTitle()+"----------------------"
//			 * +memberInvoice.getUserType());
//			 * memberInvoiceDao.insert(memberInvoice);
//			 */
//
//			// 保存会员状态
//			memberSts = new MemberSts();
//			memberSts.setId(SnoGerUtil.getUUID());
//			memberSts.setMemberId(memberInfo.getId());
//			memberSts.setSts("0");
//			memberSts.setCreateUser(memberInfo.getCode());
//			memberSts.setCreateTime(DateUtils.getCurrentDate());
//			memberStsDao.insert(memberSts);
//
//			// 保存会员账户
//			memberAccount.setId(SnoGerUtil.getUUID());
//			memberAccount.setCreateUser(memberInfo.getCode());
//			memberAccount.setMemberId(memberInfo.getId());
//			memberAccount.setCreateTime(DateUtils.getCurrentDate());
//			memberAccount.setOrganizationId(organizationVar.getId());
//			memberAccountDao.insert(memberAccount);
//
			//在线申请注册
			memberInfoVo = new MemberInfoVo();
			// 会员信息
			BeanUtils.copyProperties(memberInfo, memberInfoVo);
			// 会员账户
			MemberAccountVo memberAccountVo = new MemberAccountVo();
			BeanUtils.copyProperties(memberAccount, memberAccountVo);
			memberAccountVo.setOrganizationId(organzationList.get(0).getId());
			memberInfoVo.setMemberAccount(memberAccountVo);

			// 在线申请注册
			memberService.regist(memberInfoVo);
		} catch (Exception e) {
			log.error("在线申请会员失败！",e);
			return "error";
		}
		// SnoGerUtil
		// PropertiesUtils
		return "success";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MemberInfoVo getMember() {
		return member;
	}

	public void setMember(MemberInfoVo member) {
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}
	/**
	 * @return the memberInfoService
	 */
	public IMemberInfoService getMemberInfoService() {
		return memberInfoService;
	}

	/**
	 * @param memberInfoService the memberInfoService to set
	 */
	public void setMemberInfoService(IMemberInfoService memberInfoService) {
		this.memberInfoService = memberInfoService;
	}
	/**
	 * @return the memberRoleService
	 */
	public IMemberRoleService getMemberRoleService() {
		return memberRoleService;
	}

	/**
	 * @param memberRoleService the memberRoleService to set
	 */
	public void setMemberRoleService(IMemberRoleService memberRoleService) {
		this.memberRoleService = memberRoleService;
	}

	/**
	 * @return the memberStsService
	 */
	public IMemberStsService getMemberStsService() {
		return memberStsService;
	}

	/**
	 * @return the passwordEncoder
	 */
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	/**
	 * @return the ruleConfigService
	 */
	public IRuleConfigService getRuleConfigService() {
		return ruleConfigService;
	}
	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

	public IMemberInvoiceDao getMemberInvoiceDao() {
		return memberInvoiceDao;
	}

	public void setMemberInvoiceDao(IMemberInvoiceDao memberInvoiceDao) {
		this.memberInvoiceDao = memberInvoiceDao;
	}

	public MemberInvoice getMemberInvoice() {
		return memberInvoice;
	}

	public void setMemberInvoice(MemberInvoice memberInvoice) {
		this.memberInvoice = memberInvoice;
	}

	public MemberAccount getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(MemberAccount memberAccount) {
		this.memberAccount = memberAccount;
	}

	public IMemberAccountDao getMemberAccountDao() {
		return memberAccountDao;
	}

	public void setMemberAccountDao(IMemberAccountDao memberAccountDao) {
		this.memberAccountDao = memberAccountDao;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getNewPw() {
		return newPw;
	}

	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}

	public String getNewPwConfirm() {
		return newPwConfirm;
	}

	public void setNewPwConfirm(String newPwConfirm) {
		this.newPwConfirm = newPwConfirm;
	}

	public String getHcode() {
		return hcode;
	}

	public void setHcode(String hcode) {
		this.hcode = hcode;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
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

	public List<MemberRoleVo> getMemberRoleVoList() {
		return memberRoleVoList;
	}

	public void setMemberRoleVoList(List<MemberRoleVo> memberRoleVoList) {
		this.memberRoleVoList = memberRoleVoList;
	}

	public void setRuleConfigService(IRuleConfigService ruleConfigService) {
		this.ruleConfigService = ruleConfigService;
	}

	public String getMistakeInfo() {
		return mistakeInfo;
	}

	public void setMistakeInfo(String mistakeInfo) {
		this.mistakeInfo = mistakeInfo;
	}

	public void setMemberStsService(IMemberStsService memberStsService) {
		this.memberStsService = memberStsService;
	}

	public String getIsRememberPsw() {
		return isRememberPsw;
	}

	public void setIsRememberPsw(String isRememberPsw) {
		this.isRememberPsw = isRememberPsw;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public IMemberStsDao getMemberStsDao() {
		return memberStsDao;
	}

	public void setMemberStsDao(IMemberStsDao memberStsDao) {
		this.memberStsDao = memberStsDao;
	}

	public MemberSts getMemberSts() {
		return memberSts;
	}

	public void setMemberSts(MemberSts memberSts) {
		this.memberSts = memberSts;
	}

	/**
	 * @return the memberAccountService
	 */
	public IMemberAccountService getMemberAccountService() {
		return memberAccountService;
	}

	/**
	 * @param memberAccountService the memberAccountService to set
	 */
	public void setMemberAccountService(IMemberAccountService memberAccountService) {
		this.memberAccountService = memberAccountService;
	}

	/**
	 * @return the sysOrganizationDao
	 */
	public ISysOrganizationDao getSysOrganizationDao() {
		return sysOrganizationDao;
	}

	/**
	 * @param sysOrganizationDao the sysOrganizationDao to set
	 */
	public void setSysOrganizationDao(ISysOrganizationDao sysOrganizationDao) {
		this.sysOrganizationDao = sysOrganizationDao;
	}

}
