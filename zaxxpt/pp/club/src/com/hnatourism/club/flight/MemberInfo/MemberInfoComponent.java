package com.hnatourism.club.flight.MemberInfo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hnatourism.club.common.helper.protocol.Constants;
import com.hnatourism.club.common.util.MemberUtils;
import com.hnatourism.framework.utils.StringUtils;

public class MemberInfoComponent {
	//获取当前登录用户基本信息Vo,为空则跳转到登录页面
	public static MemberInfoVo getCurLoginUser(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		MemberInfoVo user=null;
		String loginUrl = null;
		String ctx=request.getContextPath();
		String sessionId = session.getId();
		String isource = null;
		String url = request.getRequestURL().toString(); 
		String uri = request.getRequestURI(); 
		String hoturl = url.replace(uri,"");
		if("/".equals(uri)&& url !=null && url.length()>0){
			hoturl = url.substring(0,url.length()-1);
		}
		// 根据二级域名设定来源
		if(StringUtils.isNotEmpty(hoturl)
				&& hoturl.equalsIgnoreCase("ihzly.xhlx.cn")){// 惠众联银
			isource = Constants.SOURCE_IHZLY;
		}
		if(session.getAttribute("_user_")!=null){
			user=(MemberInfoVo)session.getAttribute("_user_");
		}
		else{
			try{
				if(Constants.SOURCE_IHZLY.equalsIgnoreCase(isource)){
					loginUrl = MemberUtils.getLoginString(Constants.SOURCE_IHZLY,"0");
					response.sendRedirect(loginUrl);
				}
				return null;
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		return user;
	}
}
