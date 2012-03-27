package com.hnatourism.club.personal.member.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.acegisecurity.providers.encoding.PasswordEncoder;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.hnatourism.club.common.util.RedirectUtil;
import com.hnatourism.club.personal.member.domain.MemberAccount;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.service.IMemberService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.framework.core.domain.BaseUser;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.EmailUtils;
import com.hnatourism.framework.utils.ListUtils;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.framework.web.action.BaseAction;
import com.hnatourism.framework.web.utils.CookieUtils;
import com.hnatourism.framework.web.vo.AbstractVo;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转到用户信息编辑
 * 
 * 历史版本: ${2011.8.23} v1.0.0 (${高杰}) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class MemberInfoAction extends BaseAction
{
	private static final long serialVersionUID = 8922017842741135405L;
	
	private String id;//会员ID
	private MemberInfoVo member;//会员信息
	private String code;//编号
	private String name;//联系人
	private String pw;//密码
	private String mobile;//手机
	private String sex;//性别
	private String birth;//出生日期
	private String address;//地址

	private String time;
	private String pwaction;//修改登录密码的动作判断
	private String newPw;
	private String newPwConfirm;
	private String rolename;
	
	
	/**
	 * 会员信息服务
	 */
	private IMemberInfoService memberInfoServ;
	private IMemberService memberService;
	/**
	 * 会员账户信息服务
	 */
	private IMemberAccountService memberAccountServ;
	private IMemberRoleService memberRoleServ;
	private PasswordEncoder passwordEncoder;
	
	
	/**
	 * 待客下单接收参数
	 * 
	 */
	private String memberId="";
	private String source="";
	private String createUser="";
	private String proType="";
	
	
	/**
	 * 首页显示
	 */
	public String showMemberInfo()
	{
		try
		{
			HttpSession session=this.getSession();
			MemberInfoVo vo = UserUtil.getUser(getSession().getId());
			if(vo == null)
			{
				return "notlogin";
			}
			session.setAttribute("updmember", null);
			
			member=(MemberInfoVo)memberInfoServ.findByCode(vo.getCode());
			rolename=member.getMemberRole().getName();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "success";
		}
		
		return "success";
	}
	
	
	/**
	 * 修改会员个人信息
	 * @return
	 */
	public String updateMemberInfo()
	{
		HttpSession session=null;
		try
		{
			session= this.getSession();
			if(UserUtil.getUser(getSession().getId())==null)
			{
				return "notlogin";
			}
			session.setAttribute("updmember", null);
			
			String[] birthInfo=birth.split("-");
			
			member=new MemberInfoVo();
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
			
			memberInfoServ.update(member);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			session.setAttribute("updmember", "error");
			return "success";
		}
		session.setAttribute("updmember", "success");
		return "success";
	}
	
	public String proLogin(){
		String redirctUrl="";
		try {	
		if(!"".equals(memberId)){
			MemberInfoVo infoVo = (MemberInfoVo) memberInfoServ.findById(memberId);
			code = infoVo.getCode();
			login();
		}
	 	if("GF".equals(proType)){
			redirctUrl="/golf/index.jsp";
		}else if("L".equals(proType)){
			redirctUrl="/lounge/index.jsp";
		}else if("H".equals(proType)){
			redirctUrl="/hotel/index.jsp";
		}else if("F".equals(proType)){
			redirctUrl="/flight/index.jsp";
		}
	} catch (BusinessException e) {
		e.printStackTrace();
	}
		return "common";
	}
	/**
	 * 登录
	 * @return
	 */
	public String login()
	{
		HttpSession session=this.getSession();
		
		try
		{
			if(UserUtil.getUser(getSession().getId())!=null)
			{
				return "login";
			}
			
			session.setAttribute("mistakeInfo_code", "");
			session.setAttribute("mistakeInfo_pw", "");
			
			MemberInfoVo member=null;
			if(memberInfoServ.findByCodeLogin(code)!=null)
			{
				member=(MemberInfoVo)memberInfoServ.findByCodePw(code, passwordEncoder.encodePassword(pw, null));
			}
			else
			{
				MemberAccountVo account=(MemberAccountVo)memberAccountServ.findByCardNo(code);
				if(account==null)
				{
					session.setAttribute("mistakeInfo_code", "卡号或者账号不存在，请重新输入！！！！！");
					return "mistake";
				}
				else
				{
					MemberInfoVo member_account=(MemberInfoVo)memberInfoServ.findByCodeLogin(account.getMemberId());
					member=(MemberInfoVo)memberInfoServ.findByCodePw(member_account.getCode(), passwordEncoder.encodePassword(pw, null));
				}
			}
			
			if(member==null)
			{
				session.setAttribute("mistakeInfo_pw", "密码，请重新输入！！！！！");
				return "mistake";
			}
			else
			{
				// 会员账户信息
				MemberAccountVo account=(MemberAccountVo)memberAccountServ.findByMember(member.getId());
				MemberRoleVo memberRole=(MemberRoleVo)memberRoleServ.findById(account.getRole());
				
				// 保存到session
				account.setMemberRole(memberRole);
				member.setMemberAccount(account);
				
				if(!"".equals(createUser)){
				    //把用户放到session中
				}
				// 保存到session
				setMSession(member);

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "success";
		}
		
		if(session.getAttribute("backlink")==null)
		{
			return "success";
		}
		else
		{
			String forward_url=session.getAttribute("backlink").toString();
			session.setAttribute("backlink", null);
			return forward_url;
		}
	}
	
	public String login2() {
		if(UserUtil.getUser(getSession().getId()) != null && StringUtils.isNotEmpty(UserUtil.getUser(getSession().getId()).getId())){
			return "login";
		}
		try {
			String url = this.getRequest().getParameter("url");
			String email = this.getRequest().getParameter("email");
			// 验证码
			String verifyCodeSession = "";
			if (this.getRequest().getSession().getAttribute("rand") != null) {
				verifyCodeSession = this.getRequest().getSession()
						.getAttribute("rand").toString();
			}
			//如果没登陆，邮箱存在，根据邮箱查询用户
			if (member == null && email != null) {
//				member = this.memberRegistLoginService
//						.findPSWByEmail(email);
//				member.setLoginAccount(member.getEmail());
				MemberInfoVo memberVo = new MemberInfoVo();
				memberVo.setEmail(member.getEmail());
				List<MemberInfoVo> memberList = memberInfoServ.findByWhere(memberVo);
				member = memberList.get(0);
			}
			String rememberPSW = member.getIsRememberPsw();
			member.setVerifyCodeSession(verifyCodeSession);
			member = memberService.login(member);
			setMSession();
			this.getRequest().getSession().removeAttribute("rand");
			// 将用户名和密码放入到Cookie中
			if (rememberPSW != null && "on".equals(rememberPSW)) {
				CookieUtils.createCookie(getResponse(), "SESSION_LOGIN_USERNAME", URLEncoder
						.encode(member.getCode()), 99999999);
				// 保存密码到Cookie，注意需要加密一下
				CookieUtils.createCookie(getResponse(), "SESSION_LOGIN_PASSWORD", member
						.getPassword(), 99999999);
			}
			
			if (url != null && url.trim().length() > 0 && !"null".equals(url)) {
				try {
					url = RedirectUtil.geturl(url);
					this.getResponse().sendRedirect(url);
					return null;
				} catch (IOException e) {
					log.error("登陆后重定向异常。", e);
				}
			}
//			if (email != null && email.trim().length() > 0) {
//				return "toIndex";
//			}
		} catch (BusinessException e) {
			setMessage(e.getMessage());
			log.error("用户登陆异常。", e);
			return "mistake";
		}
		catch (Exception e) {
			setMessage(e.getMessage());
			log.error("用户登陆异常。", e);
			return "mistake";
		}

		HttpSession session=this.getSession();
		if(session.getAttribute("backlink")==null)
		{
			return "success";
		}
		else
		{
			String forward_url=session.getAttribute("backlink").toString();
			session.setAttribute("backlink", null);
			return forward_url;
		}
//		return "success";
	}
	public void setMSession() throws BusinessException {
//		HttpSession session = this.getSession();
//		String sessionId = session.getId();
		// 会员账户信息
		MemberAccountVo account=(MemberAccountVo)memberAccountServ.findByMember(member.getId());
		MemberRoleVo memberRole=(MemberRoleVo)memberRoleServ.findById(account.getRole());
		account.setMemberRole(memberRole);
		member.setMemberAccount(account);
		UserUtil.set("sessionId", getSession().getId(),member);
		getSession().setAttribute("createUser", member.getCode());;
//		ServletContext application = this.getServletContext();
//		application.setAttribute(sessionId, member);
	}
	/**
	 * 注销退出
	 * @return
	 */
	public String loginout()
	{
//		HttpSession session= this.getSession();
//		session.setAttribute("memberId", null);
//		session.setAttribute("user_"+session.getId(), null);
//		session.setAttribute("memberCode", null);
//		session.setAttribute("memberName", null);
//		session.setAttribute("createUser", null);
//		session.setAttribute("cardNo", null);
		
		UserUtil.remove("sessionId",getSession().getId());
		Cookie cookie = new Cookie("SESSION_LOGIN_USERNAME", null);
		CookieUtils.deleteCookie(cookie, getResponse());
		cookie = new Cookie("SESSION_LOGIN_PASSWORD", null);
		CookieUtils.deleteCookie(cookie, getResponse());
		// 退出判断跳转
		String toPage = null;
		String prodType = getRequest().getParameter("prodType");
		if ("F".equals(prodType)) {
			toPage = "flightIndex";
		} 
		else if ("H".equals(prodType)) {
			toPage = "hotelIndex";
		} 
		else if ("GF".equals(prodType)) {
			toPage = "golfIndex";
		} 
		else if ("L".equals(prodType)) {
			toPage = "loungeIndex";
		} 
		else {
			toPage = "success";
		} 
		return toPage;
	}
	public String toupdateMemberPw()
	{
		HttpSession session=this.getSession();
		if(UserUtil.getUser(getSession().getId())==null)
		{
			return "notlogin";
		}
		session.setAttribute("updmember", null);
		session.setAttribute("mistakeInfo_pw", null);
		
		return "success";
	}
	
	
	public String updateMemberPw()
	{
		HttpSession session=this.getSession();
		if(UserUtil.getUser(getSession().getId())==null)
		{
			return "notlogin";
		}
		session.setAttribute("updmember", null);
		session.setAttribute("mistakeInfo_pw", null);
		
		try
		{
			member=(MemberInfoVo)memberInfoServ.findByCodePw(UserUtil.getUser(getSession().getId()).getCode(), passwordEncoder.encodePassword(pw, null));
			
			if(member!=null)
			{
				if(newPw!=null&&newPwConfirm!=null&&newPw.equalsIgnoreCase(newPwConfirm))
				{
					MemberInfoVo member_upd=new MemberInfoVo();
					member_upd.setId(member.getId());
					member_upd.setPassword(passwordEncoder.encodePassword(newPw, null));
					memberInfoServ.update(member_upd);
				}
			}
			else
			{
				session.setAttribute("updmember", "error");
				return "mistake";
			}
			
		}
		catch (Exception e)
		{
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
		session.setAttribute("user_"+session.getId(), member);
		session.setAttribute("memberCode", member.getCode());
		session.setAttribute("createUser", member.getCode());
		session.setAttribute("memberName", member.getName());
		session.setAttribute("cardNo", member.getMemberAccount().getCardNo());
	}
	/**
	 * 【跳至找回密码首页】
	 * @return
	 */
	public String toFindPwd()  {
		setMessage("系统稍后会将验证信息以邮件方式送到您的邮箱<br/>请及时查收邮件");
		return "toFindPwd";
	}


/**
	 * 【新增】（验证邮箱并发送url）
	 * @return
	 */
	public String sendPwd()  {
//	  try{	
//		  //验证email是否存在
//		  memberInfo = memberInfoDao.findByEmail(memberInfoVo.getEmail());
//		  //不存在返回页面，进行提示
//		  if(memberInfo == null){
//			  setMessage("<font style='color:red'>该email未注册！</font>");
//			  return  "toFindPwd";
//		  }
//		  
//		  //email 存在
//		  //获取该用户的id
//		  sysFindPwdVo.setId(memberInfo.getId());
//		  //生成过期日期(当前时间加12天)
//		  SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
//		  sysFindPwdVo.setLastDate(dateFormat.format(DateUtils.addDays(new Date(), 12)));
//		  //生成用户key（md5 加密用户id及过期日期生成key）
//		  StringBuffer userKey= new StringBuffer(Md5Encrypt.md5(sysFindPwdVo.getId()));
//		  userKey.append("_");
//		  userKey.append(Md5Encrypt.md5(dateFormat.format(DateUtils.addDays(new Date(), 12))));
//		  sysFindPwdVo.setUserKey(userKey.toString());
//		  //判断有无信息
//		  sysFindPwd.setLastDate(sysFindPwdVo.getLastDate());
//		  sysFindPwd.setUserKey(sysFindPwdVo.getUserKey());
//		  List list = sysFindPwdDao.findByWhere(sysFindPwd);
//		  if(!ListUtils.isBlank(list)){
//			  setMessage("<font style='color:red'>找回密码，每天只能使用一次</font>");
//			  return  "toFindPwd";
//		  }
//		  //将找回密码信息插入表
//		  sysFindPwdService.insert(sysFindPwdVo);
//		  
//		  //生成Url发送至用户email邮箱
////		  String rootUrl =ServletActionContext.getRequest().getRequestURL().toString();
////		  rootUrl = rootUrl.substring(0, rootUrl.lastIndexOf('/'))+"/";
//		  String rootUrl = "http://"+Constants.DOMAIN_NAME;
//		  url = rootUrl+"/sysFindPwdAction!toResetPwd.action?ud="+sysFindPwdVo.getId()+"&amp;uk="+sysFindPwdVo.getUserKey();
//		  this.setUrl(url);
//		  //发送邮箱
//		    String MailContent="<p>你好</p><br/><p>你在"+Constants.DOMAIN_NAME_2+"申请了重设密码，请点击下面的链接，" +
//		    		"然后根据页面提示完成密码重设：</p><br/><h3><a href='"
//		    	+url+"'>"+url+"</a></h3>";    //邮件内容
//		    MailContent+="<p>"+Constants.DOMAIN_NAME_2+"客服电话 "+PropertiesUtils.getVal("sysProps", "site_tel")+"</p>";
//		    boolean sendSts = EmailUtils.sendMail(Constants.MAIL_FROM,memberInfo.getEmail(), Constants.MAIL_TITLE, MailContent,
//		    		Constants.SMTP_IP, Constants.SMTP_NAME, Constants.SMTP_PASSWORD, Constants.MAIL_TYPE, true);
//		    if(!sendSts){
//		    	setMessage("<font style='color:red'>邮件发送失败，请稍后再试</font>");
//				  return  "toFindPwd";
//		    }
//		}
//		catch(BusinessException e){
//				log.error("找回密码信息插入数据库失败",e);
//				setMessage("<font style='color:red'>服务器正忙，请稍后再试<font>");
//				 return  "toFindPwd";
//		}
//		catch(Exception e){
//				log.error("",e);
//				setMessage("<font style='color:red'>服务器正忙，请稍后再试<font>");
//				 return  "toFindPwd";
//		}
//		setMessage("<font style='color:green'>找回密码的链接已发送到您的邮箱，请注意查收<font>");
		return "toFindPwd";
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


	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}
	public void setMemberAccountServ(IMemberAccountService memberAccountServ) {
		this.memberAccountServ = memberAccountServ;
	}
	public IMemberRoleService getMemberRoleServ() {
		return memberRoleServ;
	}


	public void setMemberRoleServ(IMemberRoleService memberRoleServ) {
		this.memberRoleServ = memberRoleServ;
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
}
