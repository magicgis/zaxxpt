package com.hnatourism.club.golf.prod.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnatourism.club.golf.prod.service.IGolfProdViewService;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转到高尔夫产品详细页面
 * 
 * 历史版本: ${2011.8.2} v1.0.0 (${周峰}) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class GolfProdViewAction extends ActionSupport
{
	private static final long serialVersionUID = 8922017842741135405L;

	private GolfInfoVo golfinfovo;//详细信息展示
	//高尔夫预订时间
	private String bookTime;
	
	@Autowired
	private IGolfProdViewService golfProdViewServ;
	public void setGolfProdViewServ(IGolfProdViewService golfProdViewServ) {
		this.golfProdViewServ = golfProdViewServ;
	}
	
	private String pop;
	/**
	 * 高尔夫产品详细显示
	 */
	public String getGolfProdView()
	{
		try
		{
			String viewId ;
			viewId = String.valueOf(ServletActionContext.getRequest().getParameter("id"));
			pop = String.valueOf(ServletActionContext.getRequest().getParameter("pop"));
			golfinfovo=golfProdViewServ.findById(viewId);

		}catch (Exception e)
		{
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}

	public GolfInfoVo getGolfinfovo() {
		return golfinfovo;
	}
	public void setGolfinfovo(GolfInfoVo golfinfovo) {
		this.golfinfovo = golfinfovo;
	}
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}

	public String getBookTime() {
		return bookTime;
	}

	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	
}
