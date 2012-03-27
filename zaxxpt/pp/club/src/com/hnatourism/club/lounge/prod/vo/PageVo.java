package com.hnatourism.club.lounge.prod.vo;

import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.web.vo.AbstractVo;
import java.util.List;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:分页VO
 * 
 * 历史版本:2011-08-18 v1.1.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("serial")
public class PageVo extends AbstractVo
{
	private PageInfo pageInfo;
	private List<LoungeInfoVo> loungeList;
	
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public List<LoungeInfoVo> getLoungeList() {
		return loungeList;
	}
	public void setLoungeList(List<LoungeInfoVo> loungeList) {
		this.loungeList = loungeList;
	}
}
