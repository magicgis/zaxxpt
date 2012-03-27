package com.hnatourism.club.common.web;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.domain.BaseUser;
import com.hnatourism.framework.utils.UserUtil;

/**
 * @author weiyuan
 * @modify zhangyun 增加抽象方法限制命名,统一管理,本类为基类，修改请注意
 */
public abstract class BaseAction extends com.hnatourism.framework.web.action.BaseAction{
	//分页信息
	private PageInfo pageInfo;
	//附件
//	private AttachmentBean attachment;
	//失败页面
	public static final String FAIL = "failPage";
	//成功页面
	public static final String SUCCESS = "successPage";
	//新增页面
	public static final String TO_ADD = "addPage";
	//查询页面
	public static final String TO_SEARCH = "searchPage";
	//修改页面
	public static final String TO_MODIFY = "modifyPage";
	//查看页面
	public static final String TO_VIEW = "viewPage";
	
	
	/**
	 * @description 【新增保存】
	 * @return
	 * @author zhangyun
	 */
	public abstract String add();
	
	/**
	 * @description 【删除】
	 * @return
	 * @author zhangyun
	 */
	public abstract String del();
	
	/**
	 * @description 【修改保存】
	 * @return
	 * @author zhangyun
	 */
	public abstract String modify();

	/**
	 * @description 【查询返回查询结果列表】
	 * @return
	 * @author zhangyun
	 */
	public abstract String search();
	
	/**
	 * @description 【跳转到新增页面】
	 * @return
	 * @author zhangyun
	 */
	public abstract String toAdd();

	/**
	 * @description 【跳转到修改页面】
	 * @return
	 * @author zhangyun
	 */
	public abstract String toModify();
	
	/**
	 * @description 【跳转到查询页面】
	 * @return
	 * @author zhangyun
	 */
	public abstract String toSearch();
	
	/**
	 * @description 【跳转到查看页面，显示单条查询结果信息】
	 * @return
	 * @author zhangyun
	 */
	public abstract String toView();
	
	/**
	 * @description 【获取分页信息】
	 * @return
	 * @author zhangyun
	 */
	public PageInfo getPageInfo() {
		pageInfo = (PageInfo) ContextHolder.getContext().getAttribute(PageInfo.PAGEINFO);
		return pageInfo;
	}
	
	/**
	 * @description 【将用户来源放入session及cookie】
	 * @return
	 * @author lijiaye
	 */
	public void setMemberSource(String ms){
		//放入session
		this.getSession().setAttribute("memberSource", ms);
		//放入cookie
		Cookie mycookie = new Cookie("memberSource",ms);
		mycookie.setPath("/");   
		//coockie放入，关闭标签即失效
        mycookie.setMaxAge(-1);   
        this.getResponse().addCookie(mycookie); 
        
        ServletContext application=this.getServletContext();
		application.setAttribute("memberSource", ms);
	}
	
	/**
	 * @description 【取用户来源】
	 * @return
	 * @author lijiaye
	 */
	public String getMemberSource(){
		BaseUser user = UserUtil.getUser();
		String memberSource = null;
		
		//如果已经登录，从用户信息中取来源
		if(user != null){
//			return user.getSource();
			return "";
		}
		
		//如客人未登录，从session中取来源
		if(!"null".equals(this.getSession().getAttribute("memberSource")+"") 
				&& !"".equals(this.getSession().getAttribute("memberSource")+"")){
			memberSource = this.getSession().getAttribute("memberSource")+"";
			return memberSource;
		}
		//session失效后，到用户的coockie中取得来源
		Cookie[] userCookies = this.getRequest().getCookies();
		//coockie中有来源，取coockie中的来源。
		if(userCookies != null){
			for(int i=0;i<userCookies.length;i++){
				String cookieName = userCookies[i].getName();
				String cookieValue = userCookies[i].getValue();
				if("memberSource".equals(cookieName)){
					if(cookieValue != null && !"".equals(cookieValue)){
						memberSource = cookieValue;
						return memberSource;
					}
				}
			}
		}
		return memberSource;
	}
	
	/**
	 * @description 【设置分页信息】
	 * @param pageInfo
	 * @author zhangyun
	 */
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

//	public AttachmentBean getAttachment() {
//		return attachment;
//	}
//
//
//	public void setAttachment(AttachmentBean attachment) {
//		this.attachment = attachment;
//	}
}
