package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelQueryPageInfo {
	/** property 	*/
	private String totalPageCount;

	/** property 	*/
	private String totalRowCount;

	/** property 	*/
	private String currentPageNum;

	/** property 	*/
	private String rowsOfPage;

	/** property 	*/
	private String groupsOfPage;

	/** property 	*/
	private String currentGroupNum;

	/** property 	*/
	private String totalGroupNum;

	public String getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(String totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public String getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(String totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public String getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(String currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public String getRowsOfPage() {
		return rowsOfPage;
	}

	public void setRowsOfPage(String rowsOfPage) {
		this.rowsOfPage = rowsOfPage;
	}

	public String getGroupsOfPage() {
		return groupsOfPage;
	}

	public void setGroupsOfPage(String groupsOfPage) {
		this.groupsOfPage = groupsOfPage;
	}

	public String getCurrentGroupNum() {
		return currentGroupNum;
	}

	public void setCurrentGroupNum(String currentGroupNum) {
		this.currentGroupNum = currentGroupNum;
	}

	public String getTotalGroupNum() {
		return totalGroupNum;
	}

	public void setTotalGroupNum(String totalGroupNum) {
		this.totalGroupNum = totalGroupNum;
	}
	
}
