package com.xunruan.framekork.lang;

import java.util.List;

/***
 * 
 * @author wenz
 * 2012-02-02 16:25
 * @version 1.0
 * 
 */
public class PageInfo<E>
{

	private int totalPageCount;  //总页面数
	private int totalRowCount;  //总条数
	private int currentPageNum;  //当前页数
	private int rowsOfPage;  //查询条数（每页显示多少条）
	private int startIndex;  //开始查询条数索引
	private List<E> recordList; // 本页的数据列表

	public PageInfo()
	{
		startIndex=0;
		totalPageCount = 0;
		totalRowCount = 0;
		currentPageNum = 1;
		rowsOfPage =15;
	}

	public void setTotalPageCount(int rowsOfPage, int totalRowCount)
	{
		int totalPageCount = totalRowCount % rowsOfPage != 0 ? totalRowCount / rowsOfPage + 1 : totalRowCount / rowsOfPage;
		this.totalPageCount = totalPageCount;
	}

	public int getTotalPageCount()
	{
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount)
	{
		this.totalPageCount = totalPageCount;
	}

	public int getTotalRowCount()
	{
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount)
	{
		this.totalRowCount = totalRowCount;
	}
	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getCurrentPageNum()
	{
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum)
	{
		this.currentPageNum = currentPageNum;
	}

	public int getRowsOfPage()
	{
		return rowsOfPage;
	}

	public void setRowsOfPage(int rowsOfPage)
	{
		this.rowsOfPage = rowsOfPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
}
