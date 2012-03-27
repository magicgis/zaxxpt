package com.hnatourism.club.common.web.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.MDC;
import org.springframework.web.util.HtmlUtils;

import com.hnatourism.club.common.util.IpUtils;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.personal.member.service.IMemberService;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.domain.BaseUser;
import com.hnatourism.framework.utils.MapUtils;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.web.filter.SqlQueryFilter;

/**
 * @author zhangyun
 * 
 */
public class OperateFilter implements Filter {
	// 日志信息
	private static final Log log = (Log) LogFactory.getLog(OperateFilter.class);

	private static final String METHOD_GET = "GET";
	private static final String METHOD_POST = "POST";

//	private ISysSecurityPrivilegeService sysSecurityPrivilegeService;
//	private IMemberRegistLoginService memberRegistLoginService;
	
	private IMemberService memberService;

//	private WebUserLoginService webUserLoginService;


//	private List seprList;



//	private List openUrlList;

	private String path;
	
	private String queryString = "";

	// 定义默认用户姓名
	private final static String DEFAULT_USER = "unknown";

	public OperateFilter() {
	}

	/** (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @description 【请添加描述】
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 * @author zhangyun
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		application = filterConfig.getServletContext();
//		ctx = WebApplicationContextUtils.getWebApplicationContext(application);
//		sysSecurityPrivilegeService = (ISysSecurityPrivilegeService) ctx
//				.getBean("sysSecurityPrivilegeService");
//		memberRegistLoginService = (IMemberRegistLoginService) ctx
//				.getBean("memberRegistLoginService");
//		webUserLoginService = (WebUserLoginService) ctx
//				.getBean("webUserLoginService");
		
		
		// if(openUrlList == null){
		// openUrlList = new ArrayList<String>();
		// }

		// 设置不需要进行过滤的特殊URL
		// SysSecurityPrivilegeVo sysSecurityPrivilegeVo = new
		// SysSecurityPrivilegeVo();
		// sysSecurityPrivilegeVo.setType(Constants.SECURITY_PRIVILEGE_TYPE_OPEN);
		// try {
		// openUrlList =
		// sysSecurityPrivilegeService.findByWhere(sysSecurityPrivilegeVo);
		// sysSecurityPrivilegeVo.setType(Constants.SECURITY_PRIVILEGE_TYPE_ROLE);
		// seprList =
		// sysSecurityPrivilegeService.findByWhere(sysSecurityPrivilegeVo);
		// } catch (BusinessException e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * @description 【请添加描述】
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 * @author zhangyun
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String sessionId = httpRequest.getSession().getId();
		String url = httpRequest.getRequestURI();
		String curUrl = httpRequest.getRequestURL().toString();
//		String hoturl = turl.replace(url, "");
		path = httpRequest.getContextPath();
//		String fullUrl = url + "?" + httpRequest.getQueryString();
		String url_temp = url.toLowerCase();
		// 静态的文件、如js脚本、图片等，不做任何过滤
		if (url_temp.endsWith(".js")
				|| url_temp.endsWith(".gif")
				|| url_temp.endsWith(".css")
				|| url_temp.endsWith(".jpg")
				|| url_temp.endsWith(".png")
				|| url_temp.endsWith(".bmp")
				|| url_temp.endsWith(".swf")
				|| url_temp.endsWith(".ico")
				|| url_temp.endsWith(".xml")
				|| url_temp.endsWith(".apk")
				|| url_temp.endsWith("weatheraction!getweather.action")
				|| url_temp.endsWith("cityqryaction!loadcityarr.action")
				|| url_temp.endsWith("cityqryaction!loadairports.action")
				|| url_temp.endsWith("js/my97datepicker/my97datepicker.htm")
				|| url_temp.endsWith("/flight/bookcontrol.jsp")
				|| url_temp.endsWith("/flight/book.jsp")
				|| url_temp.endsWith("/flight/confirm.jsp")
				|| url_temp.endsWith("/flight/searchreturn.jsp")
				|| url_temp.indexOf("flash/xml/city") > 0
				|| url_temp.endsWith("robots.txt")
				) {
			chain.doFilter(request, response);
			return;
		}
		//上一链接
		String refererUrl = null;
		String cacheUrl = null;
		// 非法域名拦截
		String domain_suffix = PropertiesUtils.getVal("domain_suffix");
		if (curUrl.indexOf(domain_suffix) <= 0
				&& curUrl.indexOf("localhost") <= 0
				&& curUrl.indexOf("10.68.200.143") <= 0
				&& curUrl.indexOf("124.207.80.230") <= 0
				&& curUrl.indexOf("192.168.1.145") <= 0
				) {
			// httpResponse.sendRedirect("http://www.google.com.hk");
			// return;
		}
		// 设置当前用户到线程变量
		MemberInfoVo user = UserUtil.getUser(sessionId);
		boolean isLogin = true;
		String loginUrl = "login.action";
		String loginoutUrl = "loginout.action";
		String loginPage = "/login.jsp";
		//如果不是注销
		if(!curUrl.contains(loginoutUrl)){
			if (user == null) {
				isLogin = false;
				user = loginCookie(httpRequest,httpResponse);
			}
			//cookie登陆
			if(user != null && !isLogin){
				UserUtil.set("sessionId", sessionId,user);
			}
			//当前链接为登陆页面
			if(!curUrl.contains(loginPage) && !curUrl.contains(loginUrl) && !curUrl.contains("html") && !curUrl.contains("phone") && !curUrl.contains("include")
					&& !url_temp.contains("recommend")  
					&& !url_temp.contains("findrecomm")
					&& !url_temp.contains("loadprovinces")
					&& !url_temp.contains("weather")
					&& !url_temp.contains("ajax")
					&& !url_temp.contains("gwdetailaction")
					// 球场查询场地 iframe
					&& !url_temp.contains("searchsite")
					){
				httpRequest.getSession().setAttribute("backlink",IpUtils.getUrl(httpRequest));
			}
			else if(curUrl.contains(loginUrl)){
				cacheUrl = (String)httpRequest.getSession().getAttribute("backlink");
				if(StringUtils.isNotEmpty(cacheUrl)){
					refererUrl = cacheUrl;
				}
			}
		}
		// 注销操作
//		if ((path + "/j_xhlxse_logout").equals(url)) {
//			logout(httpRequest, httpResponse);
//			String logoutL = httpRequest.getParameter("logoutL");
//			String toPath = path;
//			// 退出判断跳转
//			if ("0".equals(logoutL)) {
//				toPath = path + "";
//			} else if ("1".equals(logoutL)) {
//				toPath = path + "/group/index.jsp";
//			} else if ("2".equals(logoutL)) {
//				toPath = path + "/indexFlight.jsp";
//			} else if ("3".equals(logoutL)) {
//				toPath = path + "/flight/international/index.jsp";
//			} else if ("4".equals(logoutL)) {
//				toPath = path + "/hotel/index.jsp";
//			} else if ("5".equals(logoutL)) {
//				toPath = path + "/indexTour.jsp";
//			} else if ("6".equals(logoutL)) {
//				toPath = path + "/indexExchange.jsp";
//			} else if ("7".equals(logoutL)) {
//				toPath = path + "/web/subject/employeesCare/index.jsp";
//			}
//
//			httpResponse.sendRedirect(toPath);
//			return;
//		}

		String uri = url.substring(url.lastIndexOf("/") + 1);
//		if ("updatePassengerInfo.jsp".equals(uri)) {
//			httpRequest.setCharacterEncoding("UTF-8");
//			this.dealParameters(httpRequest);
//			log.info("获取B2B请求参数:" + queryString);
//		}
		// 如果是支付宝回调，侧暂不过滤, 是酒店查询页面不过滤
		if (!url.toLowerCase().startsWith(
				(path + "/alipay!toAlipayReturn.action").toLowerCase())
				&& !url.toLowerCase().startsWith(
						(path + "/alipay!toAlipayNotify.action").toLowerCase())
				&& !url.toLowerCase().startsWith(
						(path + "/portalPayAction!payBack.action")
								.toLowerCase())
				&&url.indexOf("hotel/search.jsp")==-1
				&& !"searchHotel.jsp".equals(uri)
				&& !"hotelSearch.jsp".equals(uri)
				&& !"hotelQryAction!findRoomsAndRates.action".equals(uri)
				&& !"memberInfoAction!modifyPassword.action".equals(uri)
				&& !"updatePassengerInfo.jsp".equals(uri)
				&& !"login.jsp".equals(uri)) {
			// 敏感字符或敏感关键字过滤
			Map<String, String> resultMap = dealURLMap(httpRequest);
			if ("true".equals(resultMap.get("result"))) {
				errorDeal(httpRequest, httpResponse, "inputError", resultMap
						.get("value"));
				return;
			}
		}

//		openUrlList = (List) CacheDataManager
//				.get("SYS_SECURITYPRIVILEGE_OPENURLLIST");
//		if (!isOpenUrl(url, openUrlList)) {
//			// 检查是否登陆用户
		String loginFlag = request.getParameter("login");
			if (user == null && "1".equals(loginFlag)) {
				String loginAllUrl = path + "/member" +loginPage;
//				if(StringUtils.isNotEmpty(refererUrl)){
//					loginAllUrl += "?url=" + refererUrl;
//				}
				httpResponse.sendRedirect(loginAllUrl);
				return;
			}
			else if(user != null && StringUtils.isNotEmpty(refererUrl)){
				httpResponse.sendRedirect(refererUrl);
				return;
			}
//		}
			request.setAttribute("url", refererUrl);
		chain.doFilter(request, response);
	}
	
	
	@SuppressWarnings("unchecked")
	public void dealParameters(HttpServletRequest request) throws ServletException {
		if (METHOD_GET.equalsIgnoreCase(request.getMethod())) {
			if (StringUtils.isNotEmpty(request.getQueryString())) {
				queryString = request.getQueryString();
				request.setAttribute("queryString", queryString);
			}
		} else if (METHOD_POST.equalsIgnoreCase(request.getMethod())) {
			Map<String, Object> temp = request.getParameterMap();
			if (!MapUtils.isEmpty(temp)) {
				String[] strs = null;
				for (String key : temp.keySet()) {
					strs = (String[]) temp.get(key);
					if (strs.length > 0
							&& StringUtils.isNotEmpty((String) strs[0]) 
							&& !"error".equals(key)) {
						queryString += "".equals(queryString) ? key + "="
								+ (String) strs[0] : "&" + key + "="
								+ (String) strs[0];
					}
				}
				request.setAttribute("queryString", queryString);
			}
		}
	}

	/**
	 * 处理请求中的非法字符
	 * 
	 * @param req
	 * @author zhangyun
	 */
	public Map<String, String> dealURLMap(HttpServletRequest req) {
		Map map = req.getParameterMap();
		Set set = map.entrySet();
		String tmp;
		Map<String, String> resultMap = new HashMap<String, String>();
		if (map != null) {
			for (Iterator it = set.iterator(); it.hasNext();) {
				Map.Entry entry = (Map.Entry) it.next();
				if (entry.getValue() instanceof String[]) {
					String[] values = (String[]) entry.getValue();
					for (int i = 0; i < values.length; i++) {
						tmp = SqlQueryFilter.dealParamVal(values[i]);
						if (!(tmp + "").equals(values[i])) {
							// 跳到错误提示页
							resultMap.put("result", "true");
							resultMap.put("value", values[i]);
							return resultMap;
						}
						// 处理【空格，&，<>，双引号】 转义成 HTML编码
						values[i] = HtmlUtils.htmlEscape(tmp);
					}
					entry.setValue(values);
				}
			}
		}
		// attribute处理
		Enumeration<String> attrEnum = req.getAttributeNames();
		String attrName = null;
		String attrVal = null;
		while (attrEnum.hasMoreElements()) {
			attrName = attrEnum.nextElement();
			if (req.getAttribute(attrName) instanceof String) {
				attrVal = (String) req.getAttribute(attrName);
				tmp = SqlQueryFilter.dealParamVal(attrVal);
				if (!(tmp + "").equals(attrVal)) {
					// 跳到错误提示页
					resultMap.put("result", "true");
					resultMap.put("value", attrVal);
					return resultMap;
				}
				// 处理【空格，&，<>，双引号】 转义成 HTML编码
				attrVal = HtmlUtils.htmlEscape(tmp);
				req.setAttribute(attrName, attrVal);
			}
		}
		resultMap.put("result", "false");
		resultMap.put("value", "");
		return resultMap;
	}

	/**
	 * 处理请求中的非法字符
	 * 
	 * @param req
	 * @author zhangyun
	 */
	public boolean dealURL(HttpServletRequest req) {
		Map map = req.getParameterMap();
		Set set = map.entrySet();
		String tmp;
		if (map != null) {
			for (Iterator it = set.iterator(); it.hasNext();) {
				Map.Entry entry = (Map.Entry) it.next();
				if (entry.getValue() instanceof String[]) {
					String[] values = (String[]) entry.getValue();
					for (int i = 0; i < values.length; i++) {
						tmp = SqlQueryFilter.dealParamVal(values[i]);
						if (!(tmp + "").equals(values[i])) {
							// 跳到错误提示页
							return true;
						}
						// 处理【空格，&，<>，双引号】 转义成 HTML编码
						values[i] = HtmlUtils.htmlEscape(tmp);
					}
					entry.setValue(values);
				}
			}
		}
		// attribute处理
		Enumeration<String> attrEnum = req.getAttributeNames();
		String attrName = null;
		String attrVal = null;
		while (attrEnum.hasMoreElements()) {
			attrName = attrEnum.nextElement();
			if (req.getAttribute(attrName) instanceof String) {
				attrVal = (String) req.getAttribute(attrName);
				tmp = SqlQueryFilter.dealParamVal(attrVal);
				if (!(tmp + "").equals(attrVal)) {
					// 跳到错误提示页
					return true;
				}
				// 处理【空格，&，<>，双引号】 转义成 HTML编码
				attrVal = HtmlUtils.htmlEscape(tmp);
				req.setAttribute(attrName, attrVal);
			}
		}
		return false;
	}

	/**
	 * 错误处理
	 * 
	 * @param resourceBundleKey
	 * @param httpResponse
	 * @throws IOException
	 */
	public void errorDeal(HttpServletRequest request,
			HttpServletResponse httpResponse, String resourceBundleKey,
			String value) throws IOException {
		httpResponse.setCharacterEncoding("UTF-8");
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle("messageResouce_zh_CN");
		httpResponse
				.getWriter()
				.write(
						"<html><head><title>ERROR</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body><script>alert('"
								+ resourceBundle.getString(resourceBundleKey)
								+ "："
								+ value
								+ "');window.history.go(-1);</script></body></html>");
	}

	/**
	 * 是否打开URL
	 * 
	 * @param url
	 * @param list
	 * @return
	 */
//	public boolean isOpenUrl(String url, List list) {
//		boolean result = false;
//		for (SysSecurityPrivilegeVo openUrlVo : (List<SysSecurityPrivilegeVo>) list) {
//			if (url.matches(path + openUrlVo.getLink())) {
//				result = true;
//				break;
//			}
//		}
//		return result;
//	}

	/**
	 * 是否是有安全权限的URL
	 * 
	 * @param url
	 * @param list
	 * @return
	 */
	public boolean isSePrUrl(BaseUser user, String url) {
//		seprList = (List) CacheDataManager
//				.get("SYS_SECURITYPRIVILEGE_SEPRLIST");
		boolean result = false;
//		if (seprList != null && seprList.size() > 0) {
//			for (SysSecurityPrivilegeVo spVo : (List<SysSecurityPrivilegeVo>) seprList) {
//				String tempSecurityPrs = user.getAuthSePr();
//				if (url.equals(path + spVo.getLink())
//						&& tempSecurityPrs != null) {
//					tempSecurityPrs.indexOf(spVo.getName() + ",");
//					result = true;
//					break;
//				}
//			}
//		}
		return result;
	}

	/**
	 * 是否登录
	 * 
	 * @param request
	 * @return
	 */
//	private boolean isLogin(HttpServletRequest request) {
//		BaseUser user = (BaseUser) request.getSession().getAttribute(
//				request.getSession().getId());
//		return user != null;
//	}

//	private void logout(HttpServletRequest request, HttpServletResponse response) {
//		request.getSession().removeAttribute(request.getSession().getId());
//		WebApplicationContext wac = ContextLoader
//				.getCurrentWebApplicationContext();
//		ServletContext context = wac.getServletContext();
//		context.removeAttribute(request.getSession().getId());
//		UserUtil.remove("baseuser");
//		// 清除直接预订用户变量isFirst
//		request.getSession().removeAttribute("isFirst");
//		// 清除cookie
//		Cookie cookie = new Cookie("SESSION_LOGIN_USERNAME", null);
//		cookie.setPath("/");
//		cookie.setMaxAge(0);
//		response.addCookie(cookie);
//		cookie = new Cookie("SESSION_LOGIN_PASSWORD", null);
//		cookie.setPath("/");
//		cookie.setMaxAge(0);
//		response.addCookie(cookie);
//	}

	/**
	 * 检查用户角色
	 * 
	 * @param user
	 * @param roleKeys
	 * @return
	 */
	private boolean hasRole(BaseUser user, String roleKeys) {
		boolean rv = false;
		// String[] roles = roleKeys.trim().split(",");
		// for (int i = 0; i < roles.length; i++) {
		// String roleKey = roles[i];
		boolean hasRight = true;// 检查用户是否有此权限checkRole(user,roleKeys);
		if (hasRight) {
			rv = hasRight;
			// break;
		}
		// }
		return rv;
	}

	/**
	 * 设置本地线程变量
	 * 
	 * @param request
	 * @param response
	 */
//	private void setLocalVar(HttpServletRequest request,
//			HttpServletResponse response) {
//		UserUtil.set("sessionId", request.getSession().getId());
//	}

	/**
	 * @description 设置日志信息
	 * @param user
	 * @param clientIP
	 * @author zhangyun
	 */
	public void setOperateLogInfo(BaseUser user, String clientIP) {
		if (user == null) {
			MDC.put("userCode", DEFAULT_USER);
			MDC.put("username", DEFAULT_USER);
			MDC.put("userRole", DEFAULT_USER);
		} else {
			if (user.getEmail() != null) {
				MDC.put("userCode", user.getEmail());
			} else {
				MDC.put("userCode", DEFAULT_USER);
			}
			if (user.getUsername() != null) {
				MDC.put("username", user.getUsername());
			} else {
				MDC.put("username", DEFAULT_USER);
			}
			// MDC.put("userRole", user.getCurrRoleName());
		}
		MDC.put("clientIP", clientIP);
	}

	/**
	 * Cookie登录
	 * 
	 * @param request
	 * @param response
	 */
	public MemberInfoVo loginCookie(HttpServletRequest request,
			HttpServletResponse response) {
		String usernameCookie = null;
		String passwordCookie = null;
		MemberInfoVo memberInfoVo = null;
//		Hashtable<String, String> cookies = CookieUtils.getCookies(request);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("SESSION_LOGIN_USERNAME".equals(cookie.getName())) {
					if (usernameCookie == null
							|| "".equals(usernameCookie.trim()))
						usernameCookie = cookie.getValue(); // 得到cookie的用户名
				}
				if ("SESSION_LOGIN_PASSWORD".equals(cookie.getName())) {
					if (passwordCookie == null
							|| "".equals(passwordCookie.trim()))
						passwordCookie = cookie.getValue(); // 得到cookie的密码
				}
			}
			
			if (StringUtils.isNotEmpty(usernameCookie)
					&& StringUtils.isNotEmpty(passwordCookie)) { // 如果存在
				usernameCookie = URLDecoder.decode(usernameCookie);
				memberInfoVo = new MemberInfoVo();
//				memberInfoVo.setLoginAccount(usernameCookie);
				memberInfoVo.setCode(usernameCookie);
				memberInfoVo.setPassword(passwordCookie);
//				memberInfoVo.setAccountType("01");
				try {
					memberInfoVo = memberService.login(memberInfoVo);
//					HttpSession session = request.getSession();
//					BaseUser baseuser = new BaseUser();
//					baseuser.setId(memberInfoVo.getId());
//					baseuser.setEmail(memberInfoVo.getEmail());
//					baseuser.setMobile(memberInfoVo.getMobile());
//					baseuser.setMobileBinding(memberInfoVo.getMobileBinding());
//					baseuser.setLastLoginTime(memberInfoVo.getLastLoginTime());
//					baseuser.setUserCode(memberInfoVo.getCode());
//					baseuser.setUsername(memberInfoVo.getName());
//					baseuser.setAuthSePr(memberInfoVo.getAuthSePr());
//					baseuser.setSource(memberInfoVo.getSource());
//					baseuser.setRootSource(memberInfoVo.getRootSource());
//					String sessionId = request.getSession().getId();
//					session.setAttribute(sessionId, baseuser);
//					UserUtil.set("baseuser", baseuser);
//					WebApplicationContext wac = ContextLoader
//							.getCurrentWebApplicationContext();
//					ServletContext context = wac.getServletContext();
//					context.setAttribute(sessionId, baseuser);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		}
		return memberInfoVo;
	}

	/**
	 * Cookie来源
	 * 
	 * @param request
	 * @param response
	 */
	public BaseUser sourceCookie(HttpServletRequest request,
			HttpServletResponse response, String isource) {
		String memberSource = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("memberSource".equals(cookie.getName())) {
					if (memberSource == null || "".equals(memberSource.trim()))
						memberSource = cookie.getValue(); // 得到cookie的用户名
				}
			}
			if (memberSource == null || "".equals(memberSource)) { // 如果不存在，记录
				Cookie cookie = new Cookie("memberSource", URLEncoder
						.encode(isource));// 不支持@符号
				// cookie.setPath("/");
				cookie.setMaxAge(2592000);
				response.addCookie(cookie);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String specialStr = "'<div \\ id=\"testDiv\"script>  aNd  test1;test2</div>(or)+%$#?;|";
		System.out.println(specialStr);
		// 
//		System.out.println(SqlQueryFilter.dealParamVal(specialStr));
	}

//	public ISysSecurityPrivilegeService getSysSecurityPrivilegeService() {
//		return sysSecurityPrivilegeService;
//	}
//
//	public void setSysSecurityPrivilegeService(
//			ISysSecurityPrivilegeService sysSecurityPrivilegeService) {
//		this.sysSecurityPrivilegeService = sysSecurityPrivilegeService;
//	}

//	public void setCebUserLoginService(WebUserLoginService cebUserLoginService) {
//		this.webUserLoginService = cebUserLoginService;
//	}
//
//	public WebUserLoginService getCebUserLoginService() {
//		return webUserLoginService;
//	}
//
//	public void setMemberRegistLoginService(
//			IMemberRegistLoginService memberRegistLoginService) {
//		this.memberRegistLoginService = memberRegistLoginService;
//	}
//
//	public IMemberRegistLoginService getMemberRegistLoginService() {
//		return memberRegistLoginService;
//	}
	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}
}
