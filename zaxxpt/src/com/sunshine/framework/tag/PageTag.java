package com.sunshine.framework.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sunshine.framework.entity.PageEntity;


public class PageTag extends SimpleTagSupport {
	private String controller;  //分页处理的控制器路径

	private PageEntity pageEntity;  //分页对象

	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) this.getJspContext();
		JspWriter out = pageContext.getOut();
		
		
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		//使用绝对定位
		String basePath=request.getContextPath()+controller;
		//拼页面
		out.println("<script>function goTo(pageNum){location.href='"
				+ basePath + "?page='+pageNum;}</script>");
		out.println("总行数:" + pageEntity.getRowCount() + "   总页数:"
				+ pageEntity.getTotalPage() + "   当前页:" + pageEntity.getPage()
				+ "  <a href='javascript:goTo(1)'>首页</a>   ");
		if (pageEntity.getPage() <= 1) {
			out.println("上一页");
		} else {
			out.println("<a href='javascript:goTo("
					+ pageEntity.getPreviousPage() + ")'>上一页</a>");
		}
		if (pageEntity.getPage() >= pageEntity.getTotalPage()) {
			out.println("下一页");
		} else {
			out.println("<a href='javascript:goTo(" + pageEntity.getBackPage()
					+ ")' >下一页</a>");
		}
		out.println("<a href='javascript:goTo(" + pageEntity.getTotalPage()
				+ ")'>末页</a>");
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public PageEntity getpageEntity() {
		return pageEntity;
	}

	public void setpageEntity(PageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}

}
