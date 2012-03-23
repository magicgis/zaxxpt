package com.sunshine.framework.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sunshine.framework.entity.PageEntity;


public class PageTag extends SimpleTagSupport {
	private String controller;  //��ҳ����Ŀ�����·��

	private PageEntity pageEntity;  //��ҳ����

	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) this.getJspContext();
		JspWriter out = pageContext.getOut();
		
		
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		//ʹ�þ��Զ�λ
		String basePath=request.getContextPath()+controller;
		//ƴҳ��
		out.println("<script>function goTo(pageNum){location.href='"
				+ basePath + "?page='+pageNum;}</script>");
		out.println("������:" + pageEntity.getRowCount() + "   ��ҳ��:"
				+ pageEntity.getTotalPage() + "   ��ǰҳ:" + pageEntity.getPage()
				+ "  <a href='javascript:goTo(1)'>��ҳ</a>   ");
		if (pageEntity.getPage() <= 1) {
			out.println("��һҳ");
		} else {
			out.println("<a href='javascript:goTo("
					+ pageEntity.getPreviousPage() + ")'>��һҳ</a>");
		}
		if (pageEntity.getPage() >= pageEntity.getTotalPage()) {
			out.println("��һҳ");
		} else {
			out.println("<a href='javascript:goTo(" + pageEntity.getBackPage()
					+ ")' >��һҳ</a>");
		}
		out.println("<a href='javascript:goTo(" + pageEntity.getTotalPage()
				+ ")'>ĩҳ</a>");
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
